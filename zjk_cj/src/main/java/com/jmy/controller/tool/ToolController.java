package com.jmy.controller.tool;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.util.VerifyCodeUtil;

@Controller
@RequestMapping("/tool")
public class ToolController {
	/**
	 * 把验证码传到前台
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verify")
	public void verify(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 220, h = 40;
		try {
			VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/verif")
	public void verif(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 600, h = 80;
		try {
			VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/veri")
	public @ResponseBody JSONObject veri(HttpServletRequest request, @RequestParam(defaultValue = "") String phone) {
		JSONObject json = new JSONObject();

		// 生成随机字串
		String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());

		phone = phone.trim();
		if (phone.equals("")) {
			json.put("status", 0);
			json.put("error", "手机号为空");
			return json;
		}
		String reg = "^1[0-9]{10}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(phone);
		if(!matcher.matches()){
			json.put("status", 0);
			json.put("error", "手机号格式不正确");
			return json;
		}
		// 手机发短信^1[0-9]{10}$

		json.put("status", 1);
		json.put("error", "");
		json.put("phone", phone);
		json.put("sessionId", session.getId());
		json.put("verify", verifyCode);
		return json;
	}
}
