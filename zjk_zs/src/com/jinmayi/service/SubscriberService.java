package com.jinmayi.service;

import com.jinmayi.entity.Admin;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Logininformation;

public interface SubscriberService {

	
	public Admin findAdminByUsernameAndPassword(String username, String password);
	
	public Enterprise findEnterpriseByUsernameAndPassword(String username, String password);

	public Integer register(Enterprise enterprise);
	
	/**
	 * 保存登陆信息
	 * @param l
	 * @return
	 */
	public Long saveLoginInfo(String lastip,String nowip, Long lasttime, String address, Short role, Integer subid);
	
	/**
	 * 拿到上次的登陆信息
	 * @param role
	 * @param subid
	 * @return
	 */
	public Logininformation getLastLoginInfo(Short role, Integer subid);
}
