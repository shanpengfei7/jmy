package com.jmy.service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Version;
import com.jmy.util.DataShowPage;

public interface VersionService {

	/**
	 * 管理员列出型号
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param v
	 * @return
	 */
	public DataShowPage list(int pageNum, int pageSize, Version v);

	/**
	 * 用户列出型号
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param v
	 * @param userId
	 * @return
	 */
	public DataShowPage list(int pageNum, int pageSize, Version v, int userId);

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	public Version show(int id);

	/**
	 * 用户添加型号
	 * 
	 * @param userId
	 * @param title
	 * @param pic
	 * @param content
	 * @param name
	 * @return
	 */
	public JSONObject add(int userId, String title, String pic, String content, String name, int years);

	/**
	 * 添加上型号码
	 * 
	 * @param id
	 * @param code
	 * @return
	 */
	public JSONObject addCode(int id, String code);

	/**
	 * 用户修改型号
	 * 
	 * @param id
	 * @param userId
	 * @param code
	 * @param title
	 * @param pic
	 * @param content
	 * @param name
	 * @return
	 */
	public JSONObject editUser(int id, int userId, String code, String title, String pic, String content, String name);

	/**
	 * 管理员修改型号
	 * 
	 * @param id
	 * @param adminId
	 * @param code
	 * @param title
	 * @param pic
	 * @param content
	 * @param name
	 * @return
	 */
	public JSONObject editAdmin(int id, int adminId, String code, String title, String pic, String content,
			String name);

	/**
	 * 删除型号
	 * 
	 * @param id
	 * @return
	 */
	public JSONObject delete(int id);
	
	/**
	 * 设置型号失效
	 * @param id
	 * @return
	 */
	public int status(int id);
}
