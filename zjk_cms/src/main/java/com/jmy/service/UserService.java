package com.jmy.service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.User;
import com.jmy.util.DataShowPage;

public interface UserService {

	/**
	 * 登录
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public JSONObject login(String email, String password);

	/**
	 * 注册
	 * 
	 * @param email
	 * @param password1
	 * @param password2
	 * @return
	 */
	public JSONObject register(String email, String password1, String password2);

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	public User show(int id);

	/**
	 * 用户修改和完善信息
	 * 
	 * @param name
	 * @param phone
	 * @param email
	 * @return
	 */
	public JSONObject edit(int id, String name, String phone);

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

	/**
	 * 重设密码
	 * 
	 * @param id
	 * @param password1
	 * @param password2
	 * @return
	 */
	public JSONObject editPass(int id, String password1, String password2);

	/**
	 * 管理员审核用户
	 * 
	 * @param id
	 * @param adminId
	 * @param status
	 * @return
	 */
	public JSONObject check(int id, int adminId, byte status);

	/**
	 * 列出用户信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param u
	 * @return
	 */
	public DataShowPage list(int pageNum, int pageSize, User u);

	/**
	 * 管理员增加用户
	 * 
	 * @param username
	 * @param password1
	 * @param password2
	 * @param name
	 * @param phone
	 * @param email
	 * @param adminId
	 * @return
	 */
	public JSONObject add(String password1, String password2, String name, String phone, String email,
			int adminId);

	/**
	 * 管理员修改
	 * 
	 * @param id
	 * @param adminId
	 * @param name
	 * @param phone
	 * @param email
	 * @return
	 */
	public JSONObject edit(int id, int adminId, String name, String phone);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public JSONObject delete(int id);
	
	/**
	 * 通过邮箱得到该类
	 * @param email
	 * @return
	 */
	public JSONObject show(String email);
}
