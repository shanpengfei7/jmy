package com.jmy.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.service.AdminService;

@Controller
@RequestMapping("admin/admin")
public class AdminAdminController {

	@Resource
	private AdminService adminService;

	@RequestMapping(value = "login")
	public @ResponseBody JSONObject login(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password) {
		JSONObject json = adminService.login(username, password);
		return json;
	}
	
	@RequestMapping(value = "pass")
	public @ResponseBody JSONObject pass(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String password1,
			@RequestParam(defaultValue = "") String password2) {
		JSONObject json = adminService.editPass(id, password, password1, password2);
		return json;
	}
}
