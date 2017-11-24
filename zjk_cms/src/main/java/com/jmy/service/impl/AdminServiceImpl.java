package com.jmy.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.dao.AdminMapper;
import com.jmy.entity.Admin;
import com.jmy.entity.AdminExample;
import com.jmy.service.AdminService;
import com.jmy.util.MD5Tools;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper adminMapper;
	
	public JSONObject login(String username, String password) {
		username = username.trim();
		JSONObject json = new JSONObject();
		int status = 0;
		AdminExample ae = new AdminExample();
		ae.createCriteria().andUsernameEqualTo(username);
		List<Admin> admins = adminMapper.selectByExample(ae);
		if(admins.size() > 0) {
			Admin a = admins.get(0);
			if(MD5Tools.MD5(password + a.getSecret()).equals(a.getPassword())) {
				status = 1;
				json.put("id", a.getId());
			} else {
				json.put("error", "用户名或密码错误！");
			}
		} else {
			json.put("error", "用户名或密码错误！");
		}
		
		json.put("status", status);
		return json;
	}

	public JSONObject editPass(int id, String password, String password1, String password2) {
		JSONObject json = new JSONObject();
		int status = 0;
		if (!password1.equals(password2)) {
			json.put("status", status);
			json.put("error", "两次密码输入不一致！");
			return json;
		}
		Admin admin = adminMapper.selectByPrimaryKey(id);
		if (!admin.getPassword().equals(MD5Tools.MD5(password + admin.getSecret()))) {
			json.put("status", status);
			json.put("error", "原密码输入不正确！");
			return json;
		}
		Admin a = new Admin();
		a.setId(id);
		int p = new Random().nextInt(999999);
		a.setPassword(MD5Tools.MD5(password1 + p));
		a.setSecret(p + "");
		int r = adminMapper.updateByPrimaryKeySelective(a);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "密码修改失败！");
		}
		json.put("status", status);
		return json;
	}

}
