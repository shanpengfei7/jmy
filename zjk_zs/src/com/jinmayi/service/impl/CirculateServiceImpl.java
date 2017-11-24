package com.jinmayi.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.CirculateDao;
import com.jinmayi.dao.WayBillDao;
import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Repertory;
import com.jinmayi.entity.Waybill;
import com.jinmayi.service.CirculateService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;
import com.jinmayi.service.WayBillService;

@Service("circulateService")
public class CirculateServiceImpl implements CirculateService {

	@Resource
	private CirculateDao circulateDao;

	@Resource
	private WayBillDao wayBillDao;

	@Resource
	private RepertoryService repertoryService;

	@Resource
	private QrCodeService qrCodeService;

	private Integer deliverenterpriseid;
	private Integer deliveremployeeid;
	private String deliverplace;
	private Integer willreceiveenterpriseid;
	private List<Qrcode> qrcodelist;

	@Override
	public void newGood(Integer wayBillId, List<Qrcode> qrcodes, Long time,
			Integer deliverenterpriseid, Integer deliveremployeeid,
			String deliverplace, Integer willreceiveenterpriseid) {
		this.setQrcodelist(qrcodes);
		this.deliverenterpriseid = deliverenterpriseid;
		this.deliveremployeeid = deliveremployeeid;
		this.deliverplace = deliverplace;
		this.willreceiveenterpriseid = willreceiveenterpriseid;
		this.deliver(wayBillId, qrcodes, time);
		String hql = "update Circulate set iswaybill = 1 where id = ?";
		for (int i = 0; i < qrcodes.size(); i++) {
			circulateDao.executeHql(hql,
					new Object[] { qrcodes.get(i).getId() });
		}
	}

	public List<Qrcode> getQrcodelist() {
		return qrcodelist;
	}

	public void setQrcodelist(List<Qrcode> qrcodelist) {
		this.qrcodelist = qrcodelist;
	}

	private void deliver(Integer wayBillId, List<Qrcode> qrcodes, Long time) {
		Short s0 = 0;
		for (int i = 0; i < qrcodes.size(); i++) {
			// 过程信息
			Circulate c = new Circulate();
			c.setIsdelete(s0);
			c.setQrcodeid(qrcodes.get(i).getId());
			c.setIsreceive(s0);
			c.setDelivertime(time);
			c.setDeliveremployeeid(deliveremployeeid);
			c.setDeliverplace(deliverplace);
			c.setDeliverenterpriseid(deliverenterpriseid);
			c.setWaybillid(wayBillId);
			c.setWillreceiveenterpriseid(willreceiveenterpriseid);
			c.setIswaybill(s0);
			for (Qrcode qrcode : qrcodelist) {
				if (qrcode.getId() == qrcodes.get(i).getId()) {
					Short s1 = 1;
					c.setIswaybill(s1);
				}
			}
			if (this.isDeliver(deliverenterpriseid, qrcodes.get(i).getId())) {
				throw new RuntimeException();
			} else {
				circulateDao.save(c);
				//如果该包装有父包装，则删除库存中的父包装
				if(qrcodes.get(i).getHasparent() == 1) {
					Repertory r = new Repertory();
					r.setEnterpriseid(deliverenterpriseid);
					r.setQrcodeid(qrcodes.get(i).getParentid());
					repertoryService.delete(r);
				}
			}
			// 减少库存信息
			Repertory r = new Repertory();
			r.setEnterpriseid(deliverenterpriseid);
			r.setQrcodeid(qrcodes.get(i).getId());
			repertoryService.delete(r);

			if (qrcodes.get(i).getHasson() == 1) {
				deliver(wayBillId, qrCodeService.getQrcodesByParentId(qrcodes
						.get(i).getId()), time);
			}
		}
	}

	private void receive(List<Integer> integers, Long time) {
		Short s0 = 0;
		if(!wayBillIds.isEmpty()) {
			wayBillIds.clear();
		}
		for (Integer integer : integers) {
			Circulate circulate = this.getCirculateByQrCodeId(integer,
					receiveenterpriseid);
			if (circulate == null) {
				throw new RuntimeException();
			}
			// 过程信息
			Circulate c = new Circulate();
			c.setReceiveemployeeid(receiveemployeeid);
			c.setReceiveenterpriseid(receiveenterpriseid);
			c.setReceiveplace(receiveplace);
			c.setReceivetime(time);
			c.setQrcodeid(integer);
			this.updateGood(c);
			wayBillIds.add(circulate.getWaybillid());
			// 增加库存
			Repertory r = new Repertory();
			r.setEnterpriseid(receiveenterpriseid);
			r.setIsdelete(s0);
			r.setQrcodeid(integer);
			repertoryService.save(r);

			Qrcode qrcode = qrCodeService.getQrCodeById(integer);
			if (qrcode.getHasson() == 1) {
				List<Qrcode> qrcodes = qrCodeService
						.getQrcodesByParentId(integer);
				List<Integer> integerss = new ArrayList<Integer>();
				for (Qrcode qrcode2 : qrcodes) {
					integerss.add(qrcode2.getId());
				}
				receive(integerss, time);
			}

		}
	}

	private Set<Integer> wayBillIds = new HashSet<Integer>();

	private Integer receiveemployeeid;
	private Integer receiveenterpriseid;
	private String receiveplace;
	@Resource
	private WayBillService wayBillService;

	@Override
	public Integer updateGood(List<Integer> integers, Long time, Integer flag,
			Integer receiveenterpriseid, Integer receiveemployeeid,
			String receiveplace) {
		this.receiveemployeeid = receiveemployeeid;
		this.receiveenterpriseid = receiveenterpriseid;
		this.receiveplace = receiveplace;
		// 扫码扫的是货物
		if (flag == 0) {
			receive(integers, time);
			for (Integer integer : wayBillIds) {
				List<Circulate> circulates = this.getCirculatesByWaybillid(
						integer, receiveenterpriseid);
				if (circulates != null) {
					Waybill w = new Waybill();
					w.setReceiveenterpriseid(receiveenterpriseid);
					w.setReceiveemployeeid(receiveemployeeid);
					w.setReceiveplace(receiveplace);
					w.setReceivetime(time);
					w.setId(integer);
					wayBillService.updateWayBill(w);

				}
			}
		}
		// 扫码扫的是运单
		else {
			for (Integer integer : integers) {
				Waybill waybill = wayBillService.getWaybillByWillEnterpriseId(
						integer, receiveenterpriseid);
				if (waybill == null) {
					throw new RuntimeException();
				}
				Waybill w = new Waybill();
				w.setReceiveenterpriseid(receiveenterpriseid);
				w.setReceiveemployeeid(receiveemployeeid);
				w.setReceiveplace(receiveplace);
				w.setReceivetime(time);
				w.setId(integer);
				wayBillService.updateWayBill(w);
				List<Circulate> circulates = this.getCirculatesByWaybillid(
						integer, receiveenterpriseid);
				for (Circulate circulate : circulates) {
					Circulate c = new Circulate();
					c.setReceiveemployeeid(receiveemployeeid);
					c.setReceiveenterpriseid(receiveenterpriseid);
					c.setReceiveplace(receiveplace);
					c.setReceivetime(time);
					c.setQrcodeid(circulate.getQrcodeid());
					this.updateGood(c);
					// 增加库存
					Repertory r = new Repertory();
					Short s0 = 0;
					r.setEnterpriseid(receiveenterpriseid);
					r.setIsdelete(s0);
					r.setQrcodeid(circulate.getQrcodeid());
					repertoryService.save(r);
				}
			}
		}
		return 0;
	}

	private Integer updateGood(Circulate circulate) {
		return circulateDao
				.executeHql(
						"update Circulate set isreceive = 1, receiveemployeeid = ?, "
								+ "receiveenterpriseid = ?, receivetime = ?, receiveplace = ? "
								+ "where qrcodeid = ? and isreceive = 0 and isdelete = 0 and willreceiveenterpriseid = ?",
						new Object[] { circulate.getReceiveemployeeid(),
								circulate.getReceiveenterpriseid(),
								circulate.getReceivetime(),
								circulate.getReceiveplace(),
								circulate.getQrcodeid(),
								circulate.getReceiveenterpriseid() });
	}

	@Override
	public Circulate getCirculateByQrCodeId(Integer qrcodeid,
			Integer willreceiveenterpriseid) {
		String hql = " from Circulate where qrcodeid = ? and isreceive = 0 and isdelete = 0 and willreceiveenterpriseid = ?";
		return circulateDao.get(hql, new Object[] { qrcodeid,
				willreceiveenterpriseid });
	}

	@Override
	public List<Circulate> getCirculatesByWaybillid(Integer waybillid,
			Integer willreceiveenterpriseid) {
		String hql = "from Circulate where waybillid = ? and isreceive = 0 and isdelete = 0 and willreceiveenterpriseid = ?";
		return circulateDao.find(hql, new Object[] { waybillid,
				willreceiveenterpriseid });

	}

	@Override
	public Integer deleteGood(Circulate circulate) {
		return circulateDao.executeHql("update Circulate set isdelete = 1 "
				+ "where qrcodeid = ? and isreceive = 0 and isdelete = 0",
				new Object[] { circulate.getQrcodeid() });
	}

	@Override
	public List<Circulate> getCirculateByQrCodeId(Integer id) {
		return circulateDao.find(
				" from Circulate where isdelete = 0 and qrcodeid = ?",
				new Object[] { id });
	}

	@Override
	public List<Circulate> getCirculatesByDeEmId(Integer did, Integer page,
			Integer rows) {
		return circulateDao
				.find(" from Circulate where deliverenterpriseid = ? group by qrcodeid",
						new Object[] { did }, page, rows);
	}

	@Override
	public List<Circulate> getCirculatesByReEmId(Integer rid, Integer page,
			Integer rows) {
		return circulateDao
				.find(" from Circulate where receiveenterpriseid = ? group by qrcodeid",
						new Object[] { rid }, page, rows);
	}

	@Override
	public Integer getCirculateCountByDeEmId(Integer did) {
		List<Circulate> circulates = circulateDao
				.find(" from Circulate where deliverenterpriseid = ? group by qrcodeid",
						new Object[] { did });
		return circulates.size();
	}

	@Override
	public Integer getCirculateCountByReEmId(Integer rid) {
		List<Circulate> circulates = circulateDao
				.find(" from Circulate where receiveenterpriseid = ? group by qrcodeid",
						new Object[] { rid });
		return circulates.size();
	}

	@Override
	public Boolean isDeliver(Integer enterpriseid, Integer qrcodeid) {
		String hql = " from Circulate where isdelete = 0 and qrcodeid = ? and deliverenterpriseid = ?";
		List<Circulate> c = circulateDao.find(hql, new Object[] { qrcodeid,
				enterpriseid });
		if (c == null) {
			return false;
		} else if (c.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Boolean isReceive(Integer enterpriseid, Integer qrcodeid) {
		String hql = " from Circulate where isdelete = 0 and qrcodeid = ? and deliverenterpriseid = ?";
		List<Circulate> c = circulateDao.find(hql, new Object[] { qrcodeid,
				enterpriseid });
		if (c == null) {
			return false;
		} else if (c.get(c.size()-1).getIsreceive() == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Circulate> getCirculatesByWaybillId(Integer id) {
		String hql = " from Circulate where isdelete = 0 and iswaybill = 1 and waybillid = ?";
		return circulateDao.find(hql, new Object[] { id });
	}

	@Override
	public Integer getCirculatesCount(Integer id) {
		String hql = " from Circulate where isdelete = 0 and waybillid = ?";
		return circulateDao.find(hql, new Object[] { id }).size();
	}

	@Override
	public List<Circulate> getCirculatesByWaybillId(Integer[] ids, Integer id) {
		return circulateDao.getCirculatesByWaybillId(ids, id);
	}

	@Override
	public Integer getCirculatesCount(List<Integer> ids, Integer id) {
		// String hql =
		// " from Circulate where isdelete = 0 and waybillid = ? qrcodeid in ?";
		// return circulateDao.find(hql, new Object[]{id, ids}).size();
		return 0;
	}

}
