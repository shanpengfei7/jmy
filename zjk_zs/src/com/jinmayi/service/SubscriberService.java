package com.jinmayi.service;

import com.jinmayi.entity.Admin;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Logininformation;

public interface SubscriberService {

	
	public Admin findAdminByUsernameAndPassword(String username, String password);
	
	public Enterprise findEnterpriseByUsernameAndPassword(String username, String password);

	public Integer register(Enterprise enterprise);
	
	/**
	 * �����½��Ϣ
	 * @param l
	 * @return
	 */
	public Long saveLoginInfo(String lastip,String nowip, Long lasttime, String address, Short role, Integer subid);
	
	/**
	 * �õ��ϴεĵ�½��Ϣ
	 * @param role
	 * @param subid
	 * @return
	 */
	public Logininformation getLastLoginInfo(Short role, Integer subid);
}
