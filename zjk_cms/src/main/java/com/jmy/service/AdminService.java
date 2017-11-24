package com.jmy.service;

import com.alibaba.fastjson.JSONObject;

public interface AdminService {

	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	public JSONObject login(String username, String password);
	
	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param password
	 * @param password1
	 * @param password2
	 * @return
	 */
	public JSONObject editPass(int id, String password, String password1, String password2);
}
