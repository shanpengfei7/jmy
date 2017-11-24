package com.jinmayi.service;

import com.jinmayi.entity.Statistical;

public interface StatisticalService {

	public Integer updateScannumber();

	public Integer updateQrcodeCount(Integer count);

	public Integer updateUserCount(Integer count);

	public Integer updateEnterpriseCount();

	public Statistical getsStatistical();
}
