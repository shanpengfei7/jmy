package com.jinmayi.dao;

import com.jinmayi.entity.Logininformation;

public interface LoginInformationDao extends BaseDAO<Logininformation> {

	public Logininformation getLastLoginInfo(Short role, Integer subid);
}
