package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.StatisticalDao;
import com.jinmayi.entity.Statistical;

@Repository("statisticalDao")
public class StatisticalDaoImpl extends BaseDAOImpl<Statistical> implements StatisticalDao {

	@Override
	public Integer updateScannumber() {
		String hql = "update Statistical set scannumber = scannumber + 1 where id = 1";
		return executeHql(hql);
	}

	@Override
	public Integer updateQrcodeCount(Integer count) {
		String hql = "update Statistical set qrcodecount = qrcodecount + ? where id = 1";
		executeHql(hql, new Object[]{count});
		return updateUnUserCountAdd(count);
	}

	@Override
	public Integer updateUserCount(Integer count) {
		String hql = "update Statistical set usecount = usecount + ? where id = 1";
		executeHql(hql, new Object[]{count});
		return updateUnUserCountDelete(count);
	}

	private Integer updateUnUserCountAdd(Integer count) {
		String hql = "update Statistical set unusecount = unusecount + ? where id = 1";
		return executeHql(hql, new Object[] { count });
	}

	private Integer updateUnUserCountDelete(Integer count) {
		String hql = "update Statistical set unusecount = unusecount - ? where id = 1";
		return executeHql(hql, new Object[] { count });
	}

	@Override
	public Integer updateEnterpriseCount() {
		String hql = "update Statistical set enterprisecount = enterprisecount + 1 where id = 1";
		return executeHql(hql);
	}

	@Override
	public Statistical getsStatistical() {
		return get(Statistical.class, 1);
	}

}
