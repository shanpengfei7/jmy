package com.jinmayi.dao;

import com.jinmayi.entity.Statistical;

public interface StatisticalDao extends BaseDAO<Statistical> {

	public Integer updateScannumber();
	
	public Integer updateQrcodeCount(Integer count);
	
	public Integer updateUserCount(Integer count);
	
	public Integer updateEnterpriseCount();
	
	public Statistical getsStatistical();
}
