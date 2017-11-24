package com.jmy.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.service.EnterpriseService;

@Controller
@RequestMapping("/user/index")
public class UserIndexController {

	@Resource
	private EnterpriseService enterpriseService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/login")
	public @ResponseBody JSONObject login(HttpSession session, @RequestParam(defaultValue = "") String idCode,
			@RequestParam(defaultValue = "") String password, 
			@RequestParam(defaultValue = "") String verify) {
		json.clear();
		if("".equals(verify) || "".equals(verify.trim())) {
			json.put("status", 0);
			json.put("error", "验证码为空！");
			return json;
		} 
		Object obj = session.getAttribute("verCode");
		String verCode = "";
		if(obj == null) {
			json.put("status", 0);
			json.put("error", "请重新获取验证码！");
			return json;
		} else {
			verCode = obj.toString();
		}
		if(verCode.equalsIgnoreCase(verify.trim())) {
			json = enterpriseService.login(session, idCode, password);
		} else {
			json.put("status", 0);
			json.put("error", "验证码输入不正确！");
			return json;
		}
		return json;
	}
	@RequestMapping("/frame")
	public String frame() {
		return "user/frame";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}
}
