package com.jmy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.util.DataShowPage;

public interface EnterpriseService {

	/**
	 * 登录
	 * 
	 * @param idCode
	 * @param password
	 * @return
	 */
	public JSONObject login(HttpSession session, String idCode, String password);

	public JSONObject login(String idCode, String password);

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
	public DataShowPage getNotices(int pageNum, int pageSize, String idCode, String swjgDm, String phone, String name);

	public Enterprise getEnterpriseById(int id);

	public JSONObject edit(int id, String phone, String name);

	public JSONObject edit(int id, String idCode, String phone, String name, HttpSession session);

	public JSONObject add(String idCode, String password1, String password2, String phone, String name, String swjgDm,
			HttpSession session);
	public JSONObject add(String idCode, String password1, String password2, String phone, String name, String swjgDm,
			int adminId);

	public JSONObject del(int id);
	
	public JSONObject bind(int id);

	public JSONObject pass(int id, String password, String password1, String password2);

	public JSONObject pass(int id, String password1, String password2);

	public List<Enterprise> getEnterprisesBySwjgDm(String swjgDm);

	public List<Enterprise> getEnterprisesByPhone(String phone);

	public List<Enterprise> getEnterprises();

	public Enterprise getEnterprisesByIdCode(String idCode);

}
