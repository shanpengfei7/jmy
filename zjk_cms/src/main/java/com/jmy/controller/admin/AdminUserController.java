package com.jmy.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.User;
import com.jmy.service.AdminService;
import com.jmy.service.UserService;
import com.jmy.util.DataShowPage;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

	@Resource
	private AdminService adminService;
	@Resource
	private UserService userService;
	private JSONObject json = new JSONObject();

	@RequestMapping(value = "list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, 
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String email) {
		User u = new User();
		u.setName(name.trim());
		u.setPhone(phone.trim());
		u.setEmail(email.trim());
		DataShowPage dsp = userService.list(page, rows, u);

		JSONArray js = new JSONArray();
		for (int i = 0; i < dsp.getRows().size(); i++) {
			JSONObject j = new JSONObject();
			u = (User) dsp.getRows().get(i);
			j.put("name", u.getName());
			j.put("phone", u.getPhone());
			j.put("email", u.getEmail());
			j.put("status", u.getStatus());
			j.put("id", u.getId());
			js.add(j);
		}
		json.put("data", js);
		json.put("total", dsp.getTotal());
		json.put("size", dsp.getSize());
		json.put("now", dsp.getNow());
		json.put("count", dsp.getCount());
		return json;
	}

	@RequestMapping(value = "add")
	public @ResponseBody JSONObject add(
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2,
			@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") Integer adminId) {
		name = name.trim();
		phone = phone.trim();
		email = email.trim();
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "姓名为空！");
			return json;
		}
		if (phone.equals("")) {
			json.put("status", 0);
			json.put("error", "电话为空！");
			return json;
		}
		if (email.equals("")) {
			json.put("status", 0);
			json.put("error", "电子邮件为空！");
			return json;
		}
		json = userService.add(password1, password2, name, phone, email, adminId);
		return json;
	}

	@RequestMapping(value = "edit")
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "") Integer id,
	@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") Integer adminId) {
		name = name.trim();
		phone = phone.trim();
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "姓名为空！");
			return json;
		}
		if (phone.equals("")) {
			json.put("status", 0);
			json.put("error", "电话为空！");
			return json;
		}
		json = userService.edit(id, adminId, name, phone);
		return json;
	}

	@RequestMapping(value = "pass")
	public @ResponseBody JSONObject pass(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {
		json = userService.editPass(id, password1, password2);
		return json;
	}

	@RequestMapping(value = "check")
	public @ResponseBody JSONObject check(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer adminId, @RequestParam(defaultValue = "") Integer status) {
		int s = status;
		json = userService.check(id, adminId, (byte) s);
		return json;
	}

	@RequestMapping(value = "show")
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") Integer id) {
		User u = userService.show(id);
		json.put("id", u.getId());
		json.put("status", u.getStatus());
		json.put("name", u.getName());
		json.put("phone", u.getPhone());
		json.put("email", u.getEmail());
		return json;
	}
	
	@RequestMapping(value = "del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "") Integer id) {
		return userService.delete(id);
	}
}
