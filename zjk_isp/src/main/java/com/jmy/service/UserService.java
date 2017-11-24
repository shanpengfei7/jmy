package com.jmy.service;

import com.jmy.entity.User;
import com.jmy.util.DataShowPage;

public interface UserService {

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
	public int registe(User user);

	/**
	 * 修改用户的资料
	 * @param user
	 * @return
	 */
	public int edit(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delete(int id);

	/**
	 * 用户审核
	 * @param id
	 * @param status
	 * @param checkUserId
	 * @return
	 */
	public int check(int id, byte status, int checkUserId);

	/**
	 * 用户登陆
	 * @param username
	 * @return
	 */
	public User login(String username, String password);

	/**
	 * 通过用户id拿到用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
	/**
	 * 修改密码
	 * @param u
	 * @return
	 */
	public int editPasswd(User user);
	
	/**
	 * 修改用户名
	 * @param u
	 * @return
	 */
	public int editUsername(User user);
	
	/**
	 * 列出所有用户
	 * @return
	 */
	public DataShowPage getUsers(int pageNum,int pageSize, String name, String username, String phone, String email,
			String address, byte status);
}
