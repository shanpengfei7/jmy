package com.jinmayi.dao;

import com.jinmayi.entity.Admin;

public interface AdminDao extends BaseDAO<Admin> {

	public Admin findAdminByUsernameAndPassword(String username, String password);
}
