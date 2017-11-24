package com.jmy.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Actionclass;
import com.jmy.service.ActionClassService;
import com.jmy.service.AdminService;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/class")
public class ActionClassController {
	@Resource
	private ActionClassService actionClassService;
	@Resource
	private AdminService adminService;

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		map.put("data", actionClassService.getActionclasses(page, rows));
		return "class/list";
	}

	@RequestMapping("/add")
	public void add(HttpServletResponse response, HttpSession session, String name, String remark) {

		if ("".equals(name)) {
			JsonOutput.out(response, "添加失败，分类名称为空！");
			return;
		}
		Actionclass a = new Actionclass();
		a.setName(name);
		a.setRemark(remark);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setCreateUser(uid);
		int result = actionClassService.save(a);
		if (result == 0) {
			JsonOutput.out(response, "添加失败！");
			return;
		} else {
			JsonOutput.out(response, "添加成功！");
			return;
		}
	}

	@RequestMapping("/edit")
	public void edit(HttpServletResponse response, HttpSession session, String name, String remark, int sort, int id) {
		if ("".equals(name)) {
			JsonOutput.out(response, "修改失败，分类名称为空！");
			return;
		}
		Actionclass a = new Actionclass();
		a.setName(name);
		a.setRemark(remark);
		a.setSort(sort);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setUpdateUser(uid);
		a.setId(id);

		int result = actionClassService.edit(a);
		if (result == 0) {
			JsonOutput.out(response, "修改失败！");
			return;
		} else {
			JsonOutput.out(response, "修改成功！");
			return;
		}
	}

	@RequestMapping("/del")
	public void del(HttpServletResponse response, int id, HttpSession session) {
		if (actionClassService.delete(id) == 0) {
			// 删除失败
			JsonOutput.out(response, "删除失败！");
			return;
		} else {
			// 删除成功
			JsonOutput.out(response, "删除成功！");
			return;
		}
	}

	@RequestMapping("/info")
	public String info(Map<String, Object> map, String o, int id) {
		Actionclass a = actionClassService.getActionclassById(id);
		map.put("id", a.getId());
		map.put("name", a.getName());
		map.put("remark", a.getRemark());
		map.put("sort", a.getSort());
		if ("x".equals(o)) {
			// 修改页面
			return "class/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "class/show";
		}
		return "";
	}
}
