package com.jmy.controller.admin;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.PhoneNoticeWithBLOBs;
import com.jmy.service.PhoneNoticeService;

@Controller
@RequestMapping("/admin/phonenotice")
public class AdminPhoneNoticeController {

	@Resource
	private PhoneNoticeService phoneNoticeService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(Map<String, Object> map) {
		PhoneNoticeWithBLOBs n = phoneNoticeService.show();
		map.put("content", n.getContent());
		map.put("sendTime", n.getSendTime());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Map<String, Object> edit(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "") String content, 
			@RequestParam(defaultValue = "") String sendTime) {
		map.put("content", content.trim());
		map.put("sendTime", sendTime.trim());
		
		String reg = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(sendTime.trim());
		if(!matcher.matches()) {
			map.put("error", "发送时间格式不正确，修改失败！");
			return map;
		}
		
		int result = phoneNoticeService.edit(session, content, "", sendTime.trim());
		if (result == 0) {
			map.put("error", "修改失败！");
			return map;
		} else {
			map.put("error", "修改成功！");
			return map;
		}
	}
}
