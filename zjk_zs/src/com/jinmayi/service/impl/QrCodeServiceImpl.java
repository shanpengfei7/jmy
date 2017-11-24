package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.EmployeeDao;
import com.jinmayi.dao.EnterpriseDao;
import com.jinmayi.dao.MakeQrCodeDao;
import com.jinmayi.dao.PackageInformationDao;
import com.jinmayi.dao.QrCodeDao;
import com.jinmayi.dao.QrCodePropertyDao;
import com.jinmayi.dao.RepertoryDao;
import com.jinmayi.dao.SellInformationDao;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Makeqrcode;
import com.jinmayi.entity.Packageinformation;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Qrcode;
import com.jinmayi.entity.Qrcodeproperty;
import com.jinmayi.entity.Repertory;
import com.jinmayi.entity.Sellinformation;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;
import com.jinmayi.service.StatisticalService;
import com.jinmayi.util.ConversionNumber;

@Service("qrCodeService")
public class QrCodeServiceImpl implements QrCodeService {

	@Resource
	private QrCodeDao qrCodeDao;
	@Resource
	private EnterpriseDao enterpriseDao;
	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private ProductService productService;
	@Resource
	private QrCodePropertyDao qrCodePropertyDao;
	@Resource
	private RepertoryDao repertoryDao;
	@Resource
	private MakeQrCodeDao makeQrCodeDao;
	@Resource
	private SellInformationDao sellInformationDao;
	@Resource
	private PackageInformationDao packageInformationDao;
	@Resource
	private StatisticalService statisticalService;
	@Resource
	private RepertoryService repertoryService;

	@Override
	public void printQrCodeBatch(Integer pid, Integer count, Integer eid, String pname, String pvalue, Double price) {
		statisticalService.updateQrcodeCount(count);
		enterpriseDao.updateQrcodeCount(eid, count);
		Product p = productService.getProductById(pid);
		String lastQrCode = this.getLastQrCode(pid, eid);
		String qrCodeSF = "000000";
		int num = 0;
		if (lastQrCode == null || lastQrCode.equals("")) {
			num = 1;
		} else {

			String[] a = lastQrCode.split("-");
			String b = a[1];
			String c = b.substring(0, b.length() - 6);
			lastQrCode = c;

			num = ConversionNumber.ConvertTo10(lastQrCode) + 1;
		}
		Short s0 = 0;
		Makeqrcode m = new Makeqrcode();
		m.setEnterpriseid(eid);
		m.setProductid(pid);
		m.setCount(count);
		m.setIsprint(s0);
		Integer makeQrCodeId = (Integer) makeQrCodeDao.save(m);

		for (int i = num; i < num + count; i++) {
			Qrcode q = new Qrcode();
			q.setQrcode(p.getVersion() + "-" + ConversionNumber.ConvertTo36(i) + qrCodeSF);
			q.setProductid(pid);
			q.setEnterpriseid(eid);
			q.setIssell(s0);
			q.setIsevaluate(s0);
			q.setScannumber(0);
			q.setHasson(s0);
			q.setHasparent(s0);
			q.setIsuse(s0);
			q.setPrice(price);
			q.setMakeqrcodeid(makeQrCodeId);
			Integer id = (Integer) qrCodeDao.save(q);
			// 保存二维码的属性值
			if (pname != null) {
				String[] name = pname.split(",");
				String[] value = pvalue.split(",");
				for (int j = 0; j < name.length; j++) {
					Qrcodeproperty qp = new Qrcodeproperty();
					qp.setDescription("");
					qp.setName(name[j]);
					qp.setQrcodeid(id);
					qp.setValue(value[j]);
					qrCodePropertyDao.save(qp);
				}
			}
		}

	}

	@Override
	public String getLastQrCode(Integer pid, Integer eid) {
		Qrcode qrcode = qrCodeDao.get(
				"from Qrcode where id=(select max(id) from Qrcode where productid = ? and enterpriseid=?)",
				new Object[] { pid, eid });
		if (qrcode == null) {
			return null;
		} else {
			return qrcode.getQrcode();
		}
	}

	@Override
	public Qrcode getQrCodeByQrCode(String qrcode) {
		return qrCodeDao.get(" from Qrcode where qrcode = ?", new Object[] { qrcode });
	}

	/**
	 * 这里的事务有问题，如果父包中装了和父类同种型号产品时会抛一个异常，这个异常是为了数据库的事务回滚
	 */
	@Override
	public Integer packageQrCode(Integer enterpriseid, Integer employeeid, List<Integer> sonids, Integer parentid,
			Integer soncount, String place) {
		Qrcode qrcode = qrCodeDao.get(Qrcode.class, parentid);
		if (qrcode.getIsuse() == 0) {
			statisticalService.updateUserCount(1);
			enterpriseDao.updateUserCount(enterpriseid, 1);
		}
		Packageinformation pi = null;
		try {
			pi = packageInformationDao.getPackageinformationByQrCodeId(parentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (pi != null) {
			throw new RuntimeException();
		} else {
			String hql = "";
			Integer count = 0;
			Short s1 = 1;
			// 打包信息
			Packageinformation p = new Packageinformation();
			p.setAction(s1);
			p.setEmployeeid(employeeid);
			p.setEnterpriseid(enterpriseid);
			p.setPlace(place);
			p.setQrcodeid(parentid);
			p.setTime(System.currentTimeMillis());
			packageInformationDao.save(p);

			// 父包
			hql = "update Qrcode set isuse = 1, hasson = 1 where id = ?";
			Integer result = qrCodeDao.executeHql(hql, new Object[] { parentid });
			// 子包
			hql = "update Qrcode set parentid = ?, isuse = 1, hasparent = 1 where id = ?";
			if (result > 0) {
				Qrcode qrcodeParent = qrCodeDao.get(Qrcode.class, parentid);
				if (repertoryService.getRepertories(enterpriseid, parentid) == null) {
					Repertory r = new Repertory();
					Short s0 = 0;
					r.setEnterpriseid(enterpriseid);
					r.setIsdelete(s0);
					r.setQrcodeid(qrcodeParent.getId());
					repertoryDao.save(r);
				}
				for (Integer sonid : sonids) {

					// if(sonid == parentid) {
					// soncount -= 1;
					// continue;
					// }
					Qrcode qrcodeSon = qrCodeDao.get(Qrcode.class, sonid);

					// 包的父子是同一种型号的包，则不能打包
					if (qrcodeParent.getProductid() == qrcodeSon.getProductid()
							|| qrcodeParent.getProductid().equals(qrcodeSon.getProductid())) {
						throw new RuntimeException();
						// try {
						// new RuntimeException();
						// } catch (RuntimeException e) {
						// return 0;
						// }
					}
					if (qrcodeSon.getIsuse() == 0) {
						statisticalService.updateUserCount(1);
						enterpriseDao.updateUserCount(enterpriseid, 1);
					}
					result = qrCodeDao.executeHql(hql, new Object[] { parentid, sonid });
					if (repertoryService.getRepertories(enterpriseid, sonid) == null) {
						Repertory r = new Repertory();
						Short s0 = 0;
						r.setEnterpriseid(enterpriseid);
						r.setIsdelete(s0);
						r.setQrcodeid(qrcodeSon.getId());
						repertoryDao.save(r);
					}
					count++;
				}
				// 父包
				hql = "update Qrcode set soncount = ? where id = ?";
				qrCodeDao.executeHql(hql, new Object[] { soncount, parentid });
			}
			return count;
		}
	}

	@Override
	public Integer packageUnQrCode(Integer enterpriseid, Integer employeeid, List<Integer> parentids, String place) {
		String hql = "";
		Integer count = 0;
		Short s2 = 2;
		// 拆包信息
		Packageinformation p = new Packageinformation();
		p.setAction(s2);
		p.setEmployeeid(employeeid);
		p.setEnterpriseid(enterpriseid);
		p.setPlace(place);
		p.setTime(System.currentTimeMillis());

		for (Integer parentid : parentids) {
			count++;
			p.setQrcodeid(parentid);
			packageInformationDao.save(p);

			// 父包
			hql = "update Qrcode set isuse = 0, hasson = 0,soncount = 0 where id = ?";
			Integer result = qrCodeDao.executeHql(hql, new Object[] { parentid });
			// 子包
			hql = "update Qrcode set parentid = 0, isuse = 1, hasparent = 0 where id = ?";
			if (result > 0) {
				// 减少库存信息
				Repertory r = new Repertory();
				r.setEnterpriseid(enterpriseid);
				r.setQrcodeid(parentid);
				repertoryDao.delete(r);

				List<Qrcode> qrcodes = this.getQrcodesByParentId(parentid);
				for (Qrcode qrcode : qrcodes) {
					result = qrCodeDao.executeHql(hql, new Object[] { qrcode.getId() });

				}
			}
		}
		return count;
	}

	@Override
	public void sellQrCode(List<Qrcode> qrcodes, Integer enid, Integer emid, String sellplace) {
		for (Qrcode qrcode : qrcodes) {
			Qrcode q = new Qrcode();
			q.setQrcode(qrcode.getQrcode());

			Sellinformation sellinformation = new Sellinformation();
			sellinformation.setEmployeeid(emid);
			sellinformation.setEnterpriseid(enid);
			sellinformation.setPlace(sellplace);
			sellinformation.setQrcodeid(qrcode.getId());
			sellinformation.setTime(System.currentTimeMillis());
			if (qrcode.getIssell() == 1) {
				throw new RuntimeException();
			} else {
				sellInformationDao.save(sellinformation);
			}
			sellQrCode(q);
			// 如果该包装有父包装，则删除库存中的父包装
			if (q.getHasparent() != null && q.getHasparent() == 1) {
				Repertory r = new Repertory();
				r.setEnterpriseid(enid);
				r.setQrcodeid(q.getParentid());
				repertoryService.delete(r);
			}
			// 减少库存信息
			Repertory r = new Repertory();
			r.setEnterpriseid(enid);
			r.setQrcodeid(qrcode.getId());
			repertoryService.delete(r);

			if (qrcode.getHasson() == 1) {
				sellQrCode(this.getQrcodesByParentId(qrcode.getId()), enid, emid, sellplace);
			}
		}
	}

	int index = 0;

	private Integer sellQrCode(Qrcode qrcode) {
		return qrCodeDao.executeHql(" update Qrcode set issell = 1 where qrcode = ?",
				new Object[] { qrcode.getQrcode() });
	}

	@Override
	public Integer sellEvaluate(Integer id) {
		return qrCodeDao.executeHql("update Qrcode set isevaluate = 1 where id = ?", new Object[] { id });
	}

	@Override
	public Qrcode getQrCodeByQrCode(Qrcode qrcode) {
		if (qrcode.getEnterpriseid() == null) {
			qrcode.setEnterprise(null);
		} else {
			qrcode.setEnterprise(enterpriseDao.get(Enterprise.class, qrcode.getEnterpriseid()));
		}
		List<Qrcodeproperty> qrcodeproperties = qrCodePropertyDao.getQrcodepropertiesByQrCodeId(qrcode.getId());
		qrcode.setQrcodeproperties(qrcodeproperties);
		return qrcode;
	}

	@Override
	public Qrcode getQrCodeById(Integer id) {
		return qrCodeDao.get(Qrcode.class, id);
	}

	@Override
	public List<Qrcode> getQrcodes(Integer eid, Integer pid, Integer page, Integer rows) {
		return qrCodeDao.find(" from Qrcode where enterpriseid = ? and isuse = 1 and productid = ?",
				new Object[] { eid, pid }, page, rows);
	}

	@Override
	public Integer getQrcodeCount(Integer eid, Integer pid) {
		List<Qrcode> qrcodes = qrCodeDao.find(" from Qrcode where enterpriseid = ? and isuse = 1 and productid = ?",
				new Object[] { eid, pid });
		return qrcodes.size();
	}

	@Override
	public List<Qrcode> getSellQrcodes(Integer eid, Integer pid, Integer page, Integer rows) {
		return qrCodeDao.find(" from Qrcode where isuse = 1 and enterpriseid = ? and productid = ? and issell = 1",
				new Object[] { eid, pid }, page, rows);
	}

	@Override
	public Integer getSellQrcodeCount(Integer eid, Integer pid) {
		List<Qrcode> qrcodes = qrCodeDao.find(
				" from Qrcode where isuse = 1 and enterpriseid = ? and productid = ? and issell = 1",
				new Object[] { eid, pid });
		return qrcodes.size();
	}

	@Override
	public Integer getNoUseQrcodeCount(Integer eid, Integer pid) {
		return qrCodeDao.find(" from Qrcode where isuse = 1 and enterpriseid = ? and isuse = 0 and productid = ?",
				new Object[] { eid, pid }).size();
	}

	@Override
	public List<Qrcode> getQrcodesByParentId(Integer pid) {
		return qrCodeDao.find(" from Qrcode where hasparent = 1 and isuse = 1 and parentid = ?", new Object[] { pid });
	}

	@Override
	public Integer getQrcodeCountBySeEnId(Integer sid) {
		List<Qrcode> qrcodes = qrCodeDao.find(" from Qrcode where isuse = 1 and issell = 1 and sellenterpriseid = ?",
				new Object[] { sid });
		return qrcodes.size();
	}

	@Override
	public List<Qrcode> getQrcodesBySeEnId(Integer sid, Integer page, Integer rows) {
		return qrCodeDao.find(" from Qrcode where issell = 1 and isuse = 1 and sellenterpriseid = ?",
				new Object[] { sid }, page, rows);
	}

	@Override
	public Integer updateScanCountAddOne(Integer id) {
		String hql = "update Qrcode set scannumber = scannumber + 1 where id = ?";
		return qrCodeDao.executeHql(hql, new Object[] { id });
	}

	@Override
	public List<Makeqrcode> getMakeqrcodesByEidAndPid(Integer eid, Integer pid) {
		return makeQrCodeDao.getMakeqrcodesByEidAndPid(eid, pid);
	}

	@Override
	public List<Qrcode> getQrcodesByMakeQrCodeId(Integer id) {
		String hql = " from Qrcode where makeqrcodeid = ?";
		return qrCodeDao.find(hql, new Object[] { id });
	}

	@Override
	public Integer updateMakeQrCode(Integer id) {
		String hql = " update Makeqrcode set isprint = 1 where id = ?";
		return makeQrCodeDao.executeHql(hql, new Object[] { id });
	}

	@Override
	public List<Makeqrcode> getMakeQrCodesByEnId(Integer id) {
		String hql = " from Makeqrcode where enterpriseid = ? order by id desc";
		return makeQrCodeDao.find(hql, new Object[] { id });
	}

	@Override
	public Integer getQrcodeCountByMqid(Integer makeQrCodeId) {
		List<Qrcode> qrcodes = qrCodeDao.find(" from Qrcode where makeqrcodeid = ?", new Object[] { makeQrCodeId });
		return qrcodes.size();
	}

	@Override
	public List<Qrcode> getQrcodesByMqid(Integer makeQrCodeId, Integer page, Integer rows) {
		return qrCodeDao.find(" from Qrcode where isuse = 1 and makeqrcodeid = ?", new Object[] { makeQrCodeId }, page,
				rows);
	}

	@Override
	public Integer getNoUseQrcodeCountByMqid(Integer makeQrCodeId) {
		return qrCodeDao.find(" from Qrcode where makeqrcodeid = ? and isuse = 0", new Object[] { makeQrCodeId })
				.size();
	}

}
