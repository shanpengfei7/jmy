package com.jmy.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Admi;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.service.AdminService;
import com.jmy.service.NoticeService;

@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private AdminService adminService;

	@RequestMapping("/list")
	public Map<String, Object> list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "15") Integer rows, @RequestParam(defaultValue = "") String title) {
		map.put("data", noticeService.getNotices(page, rows, title));
		map.put("title", title);
		return map;
	}

	@RequestMapping("/read")
	public Map<String, Object> read(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "15") Integer rows) {
		map.put("data", noticeService.getNoticeReads(page, rows));
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletResponse response, HttpSession session, @RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String message) {
		NoticeWithBLOBs n = new NoticeWithBLOBs();
		n.setTitle(title.trim());
		n.setContent(content.trim());
		n.setMessage(message.trim());
		Admi admin = (Admi) session.getAttribute("admin");
		n.setCreateUser(admin.getId());
		int result = noticeService.save(n);
		if (result == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", n.getTitle());
			map.put("content", n.getContent());
			map.put("message", n.getMessage());
			map.put("error", "添加失败！");
			return "admin/notice/add";
		} else {
			return "redirect:list.jmy";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(Map<String, Object> map, int id) {
		NoticeWithBLOBs n = noticeService.getNotice(id);
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		map.put("message", n.getMessage());
		map.put("id", n.getId());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(HttpServletResponse response, HttpSession session, @RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String message, int id) {
		NoticeWithBLOBs n = new NoticeWithBLOBs();
		n.setTitle(title.trim());
		n.setContent(content.trim());
		n.setMessage(message.trim());
		n.setId(id);
		int result = noticeService.edit(n);
		if (result == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", n.getTitle());
			map.put("content", n.getContent());
			map.put("message", n.getMessage());
			map.put("id", n.getId());
			map.put("error", "修改失败！");
			return "admin/notice/edit";
		} else {
			return "redirect:list.jmy";
		}
	}

	@RequestMapping("/show")
	public Map<String, Object> show(Map<String, Object> map, int id, String o) {
		NoticeWithBLOBs n = noticeService.getNotice(id);
		map.put("title", n.getTitle());
		map.put("content", n.getContent());
		map.put("message", n.getMessage());
		map.put("id", n.getId());
		return map;
	}
}
