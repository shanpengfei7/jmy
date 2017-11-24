package com.jmy.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Admi;
import com.jmy.util.DataShowPage;

public interface AdminService {

	/**
	 * 登录
	 * 
	 * @param swjgDm
	 * @param password
	 * @param role
	 * @return
	 */
	public JSONObject login(HttpSession session, String swjgDm, String password);

	/**
	 * 列出管理用户
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param pid
	 * @param swjgDm
	 * @param phone
	 * @param name
	 * @return
	 */
	public DataShowPage getNotices(int pageNum, int pageSize, int pid, String swjgDm, String phone, String name);

	public Admi getAdminById(int id);

	public Admi getAdminBySwjgDm(String swjgDm);

	public JSONObject edit(int id, String phone, String name, HttpSession session);

	public JSONObject add(String phone, String password1, String password2, String name, String swjgDm, int pid,
			byte role, HttpSession session);
	public JSONObject add(String phone, String password1, String password2, String name, String swjgDm, int pid,
			byte role, int adminId);

	public JSONObject del(int id);

	public JSONObject pass(int id, String password, String password1, String password2);

	public JSONObject pass(int id, String password1, String password2);
}
