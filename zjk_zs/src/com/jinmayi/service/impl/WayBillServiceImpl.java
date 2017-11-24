package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.CirculateDao;
import com.jinmayi.dao.WayBillDao;
import com.jinmayi.entity.Waybill;
import com.jinmayi.service.WayBillService;
import com.jinmayi.util.TimeChange;

@Service("wayBillService")
public class WayBillServiceImpl implements WayBillService {

	@Resource
	private CirculateDao circulateDao;

	@Resource
	private WayBillDao wayBillDao;

	@Override
	public Integer saveWayBill(Waybill w) {
		return (Integer) wayBillDao.save(w);
	}

	@Override
	public void updateWayBill(Waybill w) {
		String hql = "update Waybill set receiveplace = ?, receiveenterpriseid = ?, receiveemployeeid = ?, isreceive = 1, receivetime = ? where id = ?";
		wayBillDao
				.executeHql(
						hql,
						new Object[] { w.getReceiveplace(),
								w.getReceiveenterpriseid(),
								w.getReceiveemployeeid(), w.getReceivetime(),
								w.getId() });
	}

	@Override
	public void deleteWayBill(Waybill w) {
		String hql = "update Waybill set isdelete = 1 where id = ?";
		wayBillDao.executeHql(hql, new Object[] { w.getId() });
	}

	@Override
	public List<Waybill> getWaybillsByDeEnId(Integer enterpriseid,
			Integer pageNow, Integer pageSize) {
		String hql = " from Waybill where isdelete = 0 and deliverenterpriseid = ? order by id desc";
		return wayBillDao.find(hql, new Object[] { enterpriseid }, pageNow,
				pageSize);
	}

	@Override
	public List<Waybill> getWaybillsByReEnId(Integer enterpriseid,
			Integer pageNow, Integer pageSize) {
		String hql = " from Waybill where isdelete = 0 and receiveenterpriseid = ? order by id desc";
		return wayBillDao.find(hql, new Object[] { enterpriseid }, pageNow,
				pageSize);
	}

	@Override
	public Integer getWaybillsCountByDeEnId(Integer enterpriseid) {
		String hql = " from Waybill where isdelete = 0 and deliverenterpriseid = ?";
		return wayBillDao.find(hql, new Object[] { enterpriseid }).size();
	}

	@Override
	public Integer getWaybillsCountByReEnId(Integer enterpriseid) {
		String hql = " from Waybill where isdelete = 0 and receiveenterpriseid = ?";
		return wayBillDao.find(hql, new Object[] { enterpriseid }).size();
	}

	@Override
	public Waybill getWaybillByWillEnterpriseId(Integer id,
			Integer willEnterpriseId) {
		String hql = " from Waybill where isdelete = 0 and isreceive = 0 and id = ? and willreceiveenterpriseid = ?";
		return wayBillDao.get(hql, new Object[] { id, willEnterpriseId });
	}

	@Override
	public Waybill getWaybillByNumbwer(String number) {
		String hql = " from Waybill where isdelete = 0 and isreceive = 0 and number = ?";
		return wayBillDao.get(hql, new Object[] { number });
	}

	@Override
	public List<Waybill> getWaybillsByDeEmId(Integer employeeid,
			Integer pageNow, Integer pageSize, String date) {
		String hql = " from Waybill where isdelete = 0 and deliveremployeeid = ? and delivertime between ? and ? order by id desc";
		return wayBillDao.find(hql, new Object[] { employeeid, TimeChange.dateToStamp(date + " 00:00:00"),
				TimeChange.dateToStamp(date + " 23:59:59") }, pageNow,
				pageSize);
	}

	@Override
	public List<Waybill> getWaybillsByReEmId(Integer employeeid,
			Integer pageNow, Integer pageSize, String date) {
		String hql = " from Waybill where isdelete = 0 and receiveemployeeid = ? and receivetime between ? and ? order by id desc";
		return wayBillDao.find(hql, new Object[] { employeeid, TimeChange.dateToStamp(date + " 00:00:00"),
				TimeChange.dateToStamp(date + " 23:59:59") }, pageNow,
				pageSize);
	}

	@Override
	public Integer getWaybillsCountByDeEmId(Integer employeeid, String date) {
		String hql = " from Waybill where isdelete = 0 and deliveremployeeid = ? and delivertime between ? and ?";
		return wayBillDao.find(hql, new Object[] { employeeid, TimeChange.dateToStamp(date + " 00:00:00"),
				TimeChange.dateToStamp(date + " 23:59:59") }).size();
	}

	@Override
	public Integer getWaybillsCountByReEmId(Integer employeeid, String date) {
		String hql = " from Waybill where isdelete = 0 and receiveemployeeid = ? and receivetime between ? and ?";
		return wayBillDao.find(hql, new Object[] { employeeid, TimeChange.dateToStamp(date + " 00:00:00"),
				TimeChange.dateToStamp(date + " 23:59:59") }).size();
	}

	@Override
	public Waybill getWaybillById(Integer id) {
		return wayBillDao.get(Waybill.class, id);
	}

	@Override
	public Integer printWaybill(Waybill w) {
		String hql = "update Waybill set printenterpriseid = ?, printemployeeid = ?, printtime = ? where id = ?";
		return wayBillDao.executeHql(hql, new Object[]{w.getPrintenterpriseid(), w.getPrintemployeeid(), w.getPrinttime(), w.getId()});
	}

}
