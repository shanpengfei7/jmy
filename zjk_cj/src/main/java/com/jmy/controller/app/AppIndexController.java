package com.jmy.controller.app;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.service.EnterpriseService;

@Controller
@RequestMapping("/app/index")
public class AppIndexController {

	@Resource
	private EnterpriseService enterpriseService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/login")
	public @ResponseBody JSONObject login(@RequestParam(defaultValue = "") String idCode,
			@RequestParam(defaultValue = "") String password) {
		json.clear();
		json = enterpriseService.login(idCode, password);
		return json;
	}

	@RequestMapping("/loginVerify")
	public @ResponseBody JSONObject loginVerify(HttpSession session, @RequestParam(defaultValue = "") String idCode,
			@RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String verify) {
		json.clear();
		if ("".equals(verify) || "".equals(verify.trim())) {
			json.put("status", 0);
			json.put("error", "验证码为空！");
			return json;
		}
		Object obj = session.getAttribute("verCode");
		String verCode = "";
		if (obj == null) {
			json.put("status", 0);
			json.put("error", "请重新获取验证码！");
			return json;
		} else {
			verCode = obj.toString();
		}
		if (verCode.equalsIgnoreCase(verify.trim())) {
			json = enterpriseService.login(idCode, password);
		} else {
			json.put("status", 0);
			json.put("error", "验证码输入不正确！");
			return json;
		}
		return json;
	}

	@RequestMapping("/bind")
	public @ResponseBody JSONObject bind(HttpSession session, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String verify) {
		json.clear();
		String reg = "^1[0-9]{10}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches()) {
			json.put("status", 0);
			json.put("error", "手机号格式不正确");
			return json;
		}
		if ("".equals(verify) || "".equals(verify.trim())) {
			json.put("status", 0);
			json.put("error", "验证码为空！");
			return json;
		}
		Object obj = session.getAttribute("verCode");
		String verCode = "";
		if (obj == null) {
			json.put("status", 0);
			json.put("error", "请重新获取验证码！");
			return json;
		} else {
			verCode = obj.toString();
		}
		if (verCode.equalsIgnoreCase(verify.trim())) {
			// 绑定手机
			List<Enterprise> es = enterpriseService.getEnterprisesByPhone(phone.trim());
			if (es.size() > 0) {
				Enterprise e = es.get(0);
				if (e.getBind() == 1) {
					json.put("status", 0);
					json.put("error", "该企业已绑定手机号！");
					return json;
				} else {
					// 真正绑定手机
					return enterpriseService.bind(e.getId());
				}
			}
		} else {
			json.put("status", 0);
			json.put("error", "验证码输入不正确！");
			return json;
		}

		return json;
	}

	@RequestMapping("/find")
	public @ResponseBody JSONObject find(HttpSession session, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String verify) {
		json.clear();
		String reg = "^1[0-9]{10}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches()) {
			json.put("status", 0);
			json.put("error", "手机号格式不正确");
			return json;
		}
		if ("".equals(verify) || "".equals(verify.trim())) {
			json.put("status", 0);
			json.put("error", "验证码为空！");
			return json;
		}
		Object obj = session.getAttribute("verCode");
		String verCode = "";
		if (obj == null) {
			json.put("status", 0);
			json.put("error", "请重新获取验证码！");
			return json;
		} else {
			verCode = obj.toString();
		}
		if (verCode.equalsIgnoreCase(verify.trim())) {

			List<Enterprise> es = enterpriseService.getEnterprisesByPhone(phone.trim());
			if (es.size() > 0) {
				Enterprise e = es.get(0);
				if (e.getBind() == 1) {
					// 验证成功
					json.put("status", 1);
					json.put("enterpriseId", e.getId());
					return json;
				} else {
					json.put("status", 0);
					json.put("error", "该企业未绑定手机号！");
					return json;
				}
			}
		} else {
			json.put("status", 0);
			json.put("error", "验证码输入不正确！");
			return json;
		}

		return json;
	}

	@RequestMapping("/pass")
	public @ResponseBody JSONObject pass(@RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String password1, @RequestParam(defaultValue = "") String password2) {
		return enterpriseService.pass(id, password1, password2);
	}
}
