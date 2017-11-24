package com.jinmayi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.AdminDao;
import com.jinmayi.dao.EnterpriseDao;
import com.jinmayi.dao.LoginInformationDao;
import com.jinmayi.entity.Admin;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Logininformation;
import com.jinmayi.service.SubscriberService;

@Service("subscriberService")
public class SubscriberServiceImpl implements SubscriberService {

	@Resource
	private AdminDao adminDao;
	@Resource
	private EnterpriseDao enterpriseDao;
	@Resource
	private LoginInformationDao loginInformationDao;

	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) {
		return adminDao.findAdminByUsernameAndPassword(username, password);
	}

	@Override
	public Enterprise findEnterpriseByUsernameAndPassword(String username, String password) {
		return enterpriseDao.findEnterpriseByUsernameAndPassword(username, password);
	}

	@Override
	public Integer register(Enterprise enterprise) {
		return (Integer) enterpriseDao.save(enterprise);
	}

	@Override
	public Long saveLoginInfo(String lastip,String nowip, Long lasttime, String address, Short role, Integer subid) {
		Logininformation l = new Logininformation();
		l.setLastip(lastip);
		l.setNowip(nowip);
		l.setLasttime(lasttime);
		l.setNowtime(System.currentTimeMillis());
		l.setAddress(address);
		l.setRole(role);
		l.setSubid(subid);
		return (Long)loginInformationDao.save(l);
	}

	@Override
	public Logininformation getLastLoginInfo(Short role, Integer subid) {
		return loginInformationDao.getLastLoginInfo(role, subid);
	}

}
