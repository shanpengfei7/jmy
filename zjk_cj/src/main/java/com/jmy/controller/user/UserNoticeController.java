package com.jmy.controller.user;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Enterprise;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.service.AdminService;
import com.jmy.service.NoticeService;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/user/notice")
public class UserNoticeController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private AdminService adminService;

	@RequestMapping("/list")
	public Map<String, Object> list(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "12") Integer rows) {

		map.put("data", noticeService.getNotices(session, page, rows));
		return map;
	}

	@RequestMapping(value = "/unread", method = RequestMethod.GET)
	public void unread(HttpServletResponse response, HttpSession session) {
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		JsonOutput.out(response, noticeService.getUnread(enterprise.getId()));
	}

	@RequestMapping("/show")
	public Map<String, Object> show(Map<String, Object> map, HttpSession session, int id) {
		NoticeWithBLOBs n = noticeService.getNotice(id);
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		map.put("message", n.getMessage());
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		noticeService.read(id, enterprise.getId(), System.currentTimeMillis());
		return map;
	}

}
