package com.jmy.service;

import com.jmy.entity.Admin;

public interface AdminService {

	/**
	 * 检查用户名是否重复
	 * 
	 * @param username
	 * @return
	 */
	public boolean hasUsername(String username);

	/**
	 * 注册，保存用户名和密码
	 * @param user
	 * @return
	 */
	public int Registe(Admin admin);


	/**
	 * 用户登陆
	 * @param username
	 * @return
	 */
	public Admin login(String username, String password);
	
	public Admin getAdminById(int id);

}
