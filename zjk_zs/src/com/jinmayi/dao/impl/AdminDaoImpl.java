package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.AdminDao;
import com.jinmayi.entity.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDAOImpl<Admin> implements AdminDao {

	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) {
		return get(" from Admin a where a.username = ? and a.password = ? ",
				new Object[] { username, password });
	}
}
