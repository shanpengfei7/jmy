package com.jmy.controller.home;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.User;
import com.jmy.service.UserService;
import com.jmy.util.JavaEmeilSend;
import com.jmy.util.VerifyCodeUtil;

@Controller
@RequestMapping("home/user")
public class HomeUserController {

	@Resource
	private UserService userService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/email")
	public @ResponseBody JSONObject email(@RequestParam(defaultValue = "") String to) {
		json = userService.show(to.trim());
		// 生成随机字串
		String verifyCode = VerifyCodeUtil.generateVerifyCode(6);
		try {
			JavaEmeilSend.sendEmail(to.trim(), json.getString("name"), verifyCode);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		json.put("verify", verifyCode);
		return json;
	}

	@RequestMapping(value = "login")
	public @ResponseBody JSONObject login(@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password) {
		JSONObject json = userService.login(email, password);
		return json;
	}

	@RequestMapping(value = "edit")
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String phone) {
		name = name.trim();
		phone = phone.trim();
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "姓名这空！");
			return json;
		}
		if (phone.equals("")) {
			json.put("status", 0);
			json.put("error", "电话为空！");
			return json;
		}
		json = userService.edit(id, name, phone);
		return json;
	}

	@RequestMapping(value = "password")
	public @ResponseBody JSONObject password(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String password1,
			@RequestParam(defaultValue = "") String password2) {
		json = userService.editPass(id, password, password1, password2);
		return json;
	}

	@RequestMapping(value = "pass")
	public @ResponseBody JSONObject pass(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {
		json = userService.editPass(id, password1, password2);
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

	@RequestMapping(value = "register")
	public @ResponseBody JSONObject register(@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {
		email = email.trim();
		if (email.equals("")) {
			json.put("status", 0);
			json.put("error", "用户名为空！");
			return json;
		}
		json = userService.register(email, password1, password2);
		return json;
	}
}
