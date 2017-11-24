package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.EnterpriseDao;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.util.RandomId;

@Repository("enterpriseDao")
public class EnterpriseDaoImpl extends BaseDAOImpl<Enterprise> implements EnterpriseDao {
	@Override
	public Enterprise findEnterpriseByUsernameAndPassword(String username, String password) {
		return get(" from Enterprise e where e.username = ? and e.password = ?", new Object[] { username, password });
	}

	@Override
	public Integer getEnterpriseCount(Short role, String keyword) {
		List<Enterprise> enterprises = null;
		if (role == 1) {
			enterprises = find("from Enterprise where isdelete = 0 and role in (1,3,5,7)", new Object[] {});
		} else if (role == 2) {
			enterprises = find("from Enterprise where isdelete = 0 and role in (2,3,6,7)", new Object[] {});
		} else if (role == 4) {
			enterprises = find("from Enterprise where isdelete = 0 and role in (4,5,6,7)", new Object[] {});
		}
		return enterprises.size();
	}

	@Override // and concat (information,company,code,name,createtime) like ?
				// "%" + keyword + "%"
	public List<Enterprise> getEnterprises(Integer page, Integer rows, Short role, String keyword) {
		if (role == 1) {
			return find("from Enterprise where isdelete = 0 and role in (1,3,5,7) order by id desc", new Object[] {},
					page, rows);
		} else if (role == 2) {
			return find("from Enterprise where isdelete = 0 and role in (2,3,6,7) order by id desc", new Object[] {},
					page, rows);
		} else if (role == 4) {
			return find("from Enterprise where isdelete = 0 and role in (4,5,6,7) order by id desc", new Object[] {},
					page, rows);
		} else {
			return null;
		}

	}

	@Override
	public void changeStaus(Enterprise enterprise) {
		executeHql("update Enterprise set status = 1 where id = ?", new Object[] { enterprise.getId() });
	}

	@Override
	public void changeConnect(Enterprise enterprise) {
//		executeHql("update Enterprise set isconnect = 0, code = ? where id = ?",
//				new Object[] { ConversionNumber.ConvertTo36(new Long(System.currentTimeMillis() / 1000).intValue()),
//						enterprise.getId() });
		executeHql("update Enterprise set isconnect = 0, code = ? where id = ?",
				new Object[] { new RandomId().randomId(enterprise.getId()),
						enterprise.getId() });
	}

	@Override
	public void changeStaus1(Enterprise enterprise) {
		executeHql("update Enterprise set status = 0 where id = ?", new Object[] { enterprise.getId() });
	}

	@Override
	public Enterprise getEnterpriseByCode(String code) {
		return get(" from Enterprise where isdelete = 0 and code = ?", new Object[] { code });
	}

	@Override
	public Integer updateScannumber(Integer id) {
		String hql = "update Enterprise set scannumber = scannumber + 1 where id = ?";
		return executeHql(hql, new Object[]{id});
	}

	@Override
	public Integer updateQrcodeCount(Integer enterpriseid, Integer count) {
		String hql = "update Enterprise set qrcodecount = qrcodecount + ? where id = ?";
		executeHql(hql, new Object[] { count,enterpriseid });
		return updateUnUserCountAdd(enterpriseid,count);
	}

	@Override
	public Integer updateUserCount(Integer enterpriseid, Integer count) {
		String hql = "update Enterprise set usecount = usecount + ? where id = ?";
		executeHql(hql, new Object[] { count,enterpriseid });
		return updateUnUserCountDelete(enterpriseid,count);
	}
	
	private Integer updateUnUserCountAdd(Integer enterpriseid, Integer count) {
		String hql = "update Enterprise set unusecount = unusecount + ? where id = ?";
		return executeHql(hql, new Object[]{count,enterpriseid});
	}
	private Integer updateUnUserCountDelete(Integer enterpriseid, Integer count) {
		String hql = "update Enterprise set unusecount = unusecount - ? where id = ?";
		return executeHql(hql, new Object[]{count,enterpriseid});
	}
}
