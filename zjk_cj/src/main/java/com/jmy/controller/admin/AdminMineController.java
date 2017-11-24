package com.jmy.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Admi;
import com.jmy.entity.Swjg;
import com.jmy.service.AdminService;
import com.jmy.service.SwjgService;

@Controller
@RequestMapping("/admin/mine")
public class AdminMineController {

	@Resource
	private AdminService adminService;
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Map<String, Object> show(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Admi admin = (Admi) session.getAttribute("admin");
		Admi a = adminService.getAdminById(admin.getId());
		map.put("id", admin.getId());
		map.put("name", a.getName());
		map.put("phone", a.getPhone());
		map.put("swjgDm", a.getSwjgDm());
		Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
		if(swjg != null) {
			map.put("swjgmc", swjg.getSwjgmc());
		}
		return map;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Admi admin = (Admi) session.getAttribute("admin");
		Admi a = adminService.getAdminById(admin.getId());
		map.put("id", admin.getId());
		map.put("name", a.getName());
		map.put("phone", a.getPhone());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") String name) {

		json = adminService.edit(id, phone, name, session);
		if (json.getInteger("status") == 0) {
			map.put("phone", phone);
			map.put("name", name);
			map.put("id", id);
			map.put("error", json.getString("error"));
			return "admin/mine/edit";
		}
		map.put("data", json);
		return "redirect:show.jmy";
	}

	@RequestMapping(value = "/pass", method = RequestMethod.GET)
	public Map<String, Object> pass(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Admi admin = (Admi) session.getAttribute("admin");
		map.put("id", admin.getId());
		return map;
	}

	@RequestMapping(value = "/pass", method = RequestMethod.POST)
	public String pass(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String password,@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {

		json = adminService.pass(id, password, password1, password2);
		if (json.getInteger("status") == 0) {
			map.put("password1", password1);
			map.put("password2", password2);
			map.put("password", password);
			map.put("id", id);
			map.put("error", json.getString("error"));
			return "admin/mine/pass";
		}
		map.put("data", json);
		return "redirect:show.jmy";
	}
}
