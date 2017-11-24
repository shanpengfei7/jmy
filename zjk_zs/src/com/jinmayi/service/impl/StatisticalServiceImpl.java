package com.jinmayi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.StatisticalDao;
import com.jinmayi.entity.Statistical;
import com.jinmayi.service.StatisticalService;

@Service("statisticalService")
public class StatisticalServiceImpl implements StatisticalService {

	@Resource
	private StatisticalDao statisticalDao;
	
	@Override
	public Integer updateScannumber() {
		return statisticalDao.updateScannumber();
	}

	@Override
	public Integer updateQrcodeCount(Integer count) {
		return statisticalDao.updateQrcodeCount(count);
	}

	@Override
	public Integer updateUserCount(Integer count) {
		return statisticalDao.updateUserCount(count);
	}

	@Override
	public Integer updateEnterpriseCount() {
		return statisticalDao.updateEnterpriseCount();
	}

	@Override
	public Statistical getsStatistical() {
		return statisticalDao.getsStatistical();
	}

}
