package com.jmy.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.service.AdminService;
import com.jmy.service.NoticeService;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private AdminService adminService;

	@RequestMapping("/list")
	public String list(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		Object obj = session.getAttribute("userId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		map.put("data", noticeService.getNotices(uid, page, rows));
		return "notice/list";
	}

	@RequestMapping(value="/unread", method=RequestMethod.GET)
	public void unread(HttpServletResponse response, HttpSession session) {
		Object obj = session.getAttribute("userId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		JSONObject json = null;
		if(uid > 0) {
			json = noticeService.getUnread(uid);
		}
		JsonOutput.out(response, json);
	}

	@RequestMapping("/show")
	public String show(Map<String, Object> map, HttpSession session, int id) {
		NoticeWithBLOBs n = noticeService.getNotice(id);
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		map.put("message", n.getMessage());
		Object obj = session.getAttribute("userId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		if (uid > 0) {
			noticeService.read(id, uid, (int) (System.currentTimeMillis() / 1000));
		}
		return "notice/show";
	}

	// ==================================================
	@RequestMapping("/adlist")
	public String adlist(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, @RequestParam(defaultValue = "") String title) {
		map.put("data", noticeService.getNotices(page, rows, title));
		map.put("title", title);
		return "notice/adlist";
	}

	@RequestMapping("/noticereadlist")
	public String noticereadlist(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		map.put("data", noticeService.getNoticeReads(page, rows));
		return "notice/noticereadlist";
	}

	@RequestMapping("/add")
	public void add(HttpServletResponse response, HttpSession session, String title, String content, String message) {
		NoticeWithBLOBs n = new NoticeWithBLOBs();
		n.setTitle(title);
		n.setContent(content);
		n.setMessage(message);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		n.setCreateUser(uid);
		int result = noticeService.save(n);
		if (result == 0) {
			JsonOutput.out(response, "添加失败！");
			return;
		} else {
			JsonOutput.out(response, "添加成功！");
			return;
		}
	}

	@RequestMapping("/edit")
	public void edit(HttpServletResponse response, HttpSession session, String title, String content, String message,
			int id) {
		NoticeWithBLOBs n = new NoticeWithBLOBs();
		n.setTitle(title);
		n.setContent(content);
		n.setMessage(message);
		n.setId(id);
		int result = noticeService.edit(n);
		if (result == 0) {
			JsonOutput.out(response, "修改失败！");
			return;
		} else {
			JsonOutput.out(response, "修改成功！");
			return;
		}
	}

	@RequestMapping("/adshow")
	public String adshow(Map<String, Object> map, int id, String o) {
		NoticeWithBLOBs n = noticeService.getNotice(id);
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		map.put("message", n.getMessage());
		map.put("id", n.getId());
		if ("x".equals(o)) {
			// 修改页面
			return "notice/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "notice/adshow";
		}
		return "";
	}
}
