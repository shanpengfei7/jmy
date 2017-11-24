package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmy.dao.AdminMapper;
import com.jmy.entity.Admin;
import com.jmy.entity.AdminExample;
import com.jmy.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper adminMapper;
	
	public boolean hasUsername(String username) {
		AdminExample a = new AdminExample();
		a.createCriteria().andUsernameEqualTo(username);
		if(adminMapper.countByExample(a) > 0) {
			return true;
		} else {
		return false;
	}}

	public int Registe(Admin admin) {
		if(hasUsername(admin.getUsername())) {
		return 0;
		} else {
			return adminMapper.insertSelective(admin);
		}
	}

	public Admin login(String username, String password) {
		AdminExample a = new AdminExample();
		a.createCriteria().andUsernameEqualTo(username);
		a.createCriteria().andPasswordEqualTo(password);
		List<Admin> admins = adminMapper.selectByExample(a);
		if(admins == null || admins.size() == 0) {
			return null;
		} else {
			return admins.get(0);
		}
	}

	public Admin getAdminById(int id) {
		return adminMapper.selectByPrimaryKey(id);
	}

}
