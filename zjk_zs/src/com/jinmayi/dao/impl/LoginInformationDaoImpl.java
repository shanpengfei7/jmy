package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.LoginInformationDao;
import com.jinmayi.entity.Logininformation;

@Repository("loginInformationDao")
public class LoginInformationDaoImpl extends BaseDAOImpl<Logininformation> implements LoginInformationDao {

	@Override
	public Logininformation getLastLoginInfo(Short role, Integer subid) {
		String hql = " from Logininformation where role = ? and subid = ? order by id desc limit 1";
		return get(hql, new Object[]{role, subid});
	}

	
}
