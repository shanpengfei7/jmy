package com.jmy.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Admi;
import com.jmy.entity.Swjg;
import com.jmy.service.AdminService;
import com.jmy.service.SwjgService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	@Resource
	private AdminService adminService;
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/list")
	public String list(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String swjgDm, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String name) {
		if (id == 0) {
			Admi admin = (Admi) session.getAttribute("admin");
			if (admin == null) {
				return null;
			}
			if(admin.getRole()==3) {
				return "redirect:../enterprise/list.jmy";
			}
			map.put("data", adminService.getNotices(pageNum, pageSize, admin.getId(), swjgDm, phone, name));
			map.put("role", admin.getRole());
			map.put("id", admin.getId());
			return "admin/user/list";
		} else {
			Admi admin = adminService.getAdminById(id);
			if (admin == null) {
				return null;
			}
			map.put("data", adminService.getNotices(pageNum, pageSize, id, swjgDm, phone, name));
			map.put("role", admin.getRole());
			map.put("id", admin.getId());
			return "admin/user/list";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Map<String, Object> add(HttpSession session, @RequestParam(defaultValue = "") String pid,
			@RequestParam(defaultValue = "") String role) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Swjg> swjgs = new ArrayList<Swjg>();
		if ("0".equals(role)) {
			role = "1";
			swjgs = swjgService.getSwjgsBySjswjg("21300000000");
		} else {
			Admi admin = (Admi) session.getAttribute("admin");
			if (admin == null) {
				return null;
			} else if (admin.getpId().equals(pid) && admin.getRole().equals(role)) {
				swjgs = swjgService.getSwjgsBySjswjg(admin.getSwjgDm());
				role = (Integer.parseInt(role) + 1) + "";
			} else {
				admin = adminService.getAdminById(Integer.parseInt(pid));
				swjgs = swjgService.getSwjgsBySjswjg(admin.getSwjgDm());
				role = (Integer.parseInt(role) + 1) + "";
			}

		}
		map.put("role", role);
		map.put("pid", pid);
		map.put("swjgs", swjgs);
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer pid,
			@RequestParam(defaultValue = "") String swjgDm, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String password1,
			@RequestParam(defaultValue = "") String password2, @RequestParam(defaultValue = "") byte role) {

		json = adminService.add(phone, password1, password2, name, swjgDm, pid, role, session);
		if (json.getInteger("status") == 0) {
			map.put("pid", pid);
			map.put("swjgDm", swjgDm);
			map.put("phone", phone);
			map.put("name", name);
			map.put("password1", password1);
			map.put("password2", password2);
			map.put("role", role);
			map.put("error", json.getString("error"));
			List<Swjg> swjgs = new ArrayList<Swjg>();
			if ((byte) 1 == role) {
				swjgs = swjgService.getSwjgsBySjswjg("21300000000");
			} else {
				Admi admin = adminService.getAdminById(pid);
				swjgs = swjgService.getSwjgsBySjswjg(admin.getSwjgDm());
			}
			map.put("swjgs", swjgs);
			return "admin/user/add";
		}
		map.put("data", json);
		return "redirect:list.jmy?id=" + pid;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(HttpSession session, @RequestParam(defaultValue = "") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Admi a = adminService.getAdminById(id);
		map.put("id", id);
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
			return "admin/user/edit";
		}
		map.put("data", json);
		Admi a = adminService.getAdminById(id);
		return "redirect:list.jmy?id=" + a.getpId();
	}

	@RequestMapping("/del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "0") Integer id) {
		json.clear();

		json = adminService.del(id);

		return json;
	}

	@RequestMapping("/dels")
	public @ResponseBody JSONObject dels(@RequestParam(defaultValue = "0") Integer[] id) {
		json.clear();
		JSONArray js = new JSONArray();
		JSONObject j = new JSONObject();

		for (int i = 0; i < id.length; i++) {
			json = adminService.del(id[i]);
			if (json.getInteger("status") == 0) {
				j.put("fail", id[i]);
				js.add(j);
			}
		}
		json.put("fails", js);

		return json;
	}
	
	@RequestMapping(value = "/pass", method = RequestMethod.GET)
	public Map<String, Object> pass(HttpSession session, @RequestParam(defaultValue = "") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return map;
	}

	@RequestMapping(value = "/pass", method = RequestMethod.POST)
	public String pass(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {

		json = adminService.pass(id, password1, password2);
		if (json.getInteger("status") == 0) {
			map.put("password1", password1);
			map.put("password2", password2);
			map.put("id", id);
			map.put("error", json.getString("error"));
			return "admin/user/pass";
		}
		map.put("data", json);
		Admi a = adminService.getAdminById(id);
		return "redirect:list.jmy?id=" + a.getpId();
	}
}
