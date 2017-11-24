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

import com.jmy.entity.TimeNoticeWithBLOBs;
import com.jmy.service.TimeNoticeService;

@Controller
@RequestMapping("/admin/timenotice")
public class AdminTimeNoticeController {

	@Resource
	private TimeNoticeService timeNoticeService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(Map<String, Object> map) {
		TimeNoticeWithBLOBs n = timeNoticeService.show();
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		if(n.getIsTime() == 1) {
			map.put("isTime", "on");
		} else { 
			map.put("isTime", "off");
		}
		map.put("sendTime", n.getSendTime());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Map<String, Object> edit(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String content,
			@RequestParam(defaultValue = "off") String isTime, @RequestParam(defaultValue = "") String sendTime) {
		byte is_time;
		if(isTime.equals("on")) {
			is_time = 1;
		} else {
			is_time = 0;
		}
		
		map.put("title", title.trim());
		map.put("content", content.trim());
		map.put("isTime", isTime);
		map.put("sendTime", sendTime);
		
		String reg = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(sendTime.trim());
		if(!matcher.matches()) {
			map.put("error", "发送时间格式不正确，修改失败！");
			return map;
		}
		
		int result = timeNoticeService.edit(session, title, content, "", is_time, sendTime);
		
		if (result == 0) {
			map.put("error", "修改失败！");
			return map;
		} else {
			map.put("error", "修改成功！");
			return map;
		}
	}
}
