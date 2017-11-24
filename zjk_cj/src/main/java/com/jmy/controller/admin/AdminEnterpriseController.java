package com.jmy.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Admi;
import com.jmy.entity.Enterprise;
import com.jmy.service.AdminService;
import com.jmy.service.EnterpriseService;
import com.jmy.service.SwjgService;

@Controller
@RequestMapping("/admin/enterprise")
public class AdminEnterpriseController {

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private AdminService adminService; 
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/list")
	public Map<String, Object> list(HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String idCode, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id == 0) {
			Admi admin = (Admi) session.getAttribute("admin");
			if (admin == null) {
				return null;
			}
			map.put("id", admin.getId());
			map.put("data", enterpriseService.getNotices(pageNum, pageSize, idCode, admin.getSwjgDm(), phone, name));
			return map;
		} else {
			Admi admin = adminService.getAdminById(id);
			if (admin == null) {
				return null;
			}
			map.put("id", admin.getId());
			map.put("data", enterpriseService.getNotices(pageNum, pageSize, idCode, admin.getSwjgDm(), phone, name));
			return map;
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Map<String, Object> add(HttpSession session, @RequestParam(defaultValue = "") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2,
			@RequestParam(defaultValue = "") String idCode) {
		Admi admin = adminService.getAdminById(id);
		if (admin == null) {
			return null;
		}
		json = enterpriseService.add(idCode, password1, password2, phone, name, admin.getSwjgDm(), session);
		if (json.getInteger("status") == 0) {
			map.put("id", id);
			map.put("phone", phone);
			map.put("name", name);
			map.put("password1", password1);
			map.put("password2", password2);
			map.put("idCode", idCode);
			map.put("error", json.getString("error"));
			return "admin/enterprise/add";
		}
		map.put("data", json);
		return "redirect:list.jmy?id=" + id;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(HttpSession session, @RequestParam(defaultValue = "") int id,@RequestParam(defaultValue = "0") Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Enterprise e = enterpriseService.getEnterpriseById(id);
		map.put("id", id);
		map.put("pid", pid);
		map.put("idCode", e.getIdCode());
		map.put("name", e.getName());
		map.put("phone", e.getPhone());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "0") Integer pid,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String idCode) {

		json = enterpriseService.edit(id, idCode, phone, name, session);
		if (json.getInteger("status") == 0) {
			map.put("phone", phone);
			map.put("name", name);
			map.put("id", id);
			map.put("idCode", idCode);
			map.put("error", json.getString("error"));
			return "admin/enterprise/edit";
		}
		map.put("data", json);
		return "redirect:list.jmy?id=" + pid;
	}

	@RequestMapping("/del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "0") Integer id) {
		json.clear();

		json = enterpriseService.del(id);

		return json;
	}
	@RequestMapping(value = "/pass", method = RequestMethod.GET)
	public Map<String, Object> pass(HttpSession session, @RequestParam(defaultValue = "") int id,@RequestParam(defaultValue = "0") Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pid", pid);
		return map;
	}

	@RequestMapping(value = "/pass", method = RequestMethod.POST)
	public String pass(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,@RequestParam(defaultValue = "0") Integer pid,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {

		json = enterpriseService.pass(id, password1, password2);
		if (json.getInteger("status") == 0) {
			map.put("password1", password1);
			map.put("password2", password2);
			map.put("id", id);
			map.put("error", json.getString("error"));
			return "admin/enterprise/pass";
		}
		map.put("data", json);
		return "redirect:list.jmy?id=" + pid;
	}
}
