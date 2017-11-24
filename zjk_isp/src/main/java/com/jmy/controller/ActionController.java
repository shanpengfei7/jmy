package com.jmy.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Action;
import com.jmy.service.ActionClassService;
import com.jmy.service.ActionService;
import com.jmy.service.AdminService;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/action")
public class ActionController {
	@Resource
	private ActionClassService actionClassService;
	@Resource
	private AdminService adminService;
	@Resource
	private ActionService actionService;

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, int cid) {
		map.put("data", actionService.getActionByActionClassId(cid, page, rows));
		map.put("cid", cid);
		return "action/list";
	}

	@RequestMapping("/add")
	public void add(HttpServletResponse response, HttpSession session, String name, String remark, int cid,
			String actionName) {
		if ("".equals(name)) {
			JsonOutput.out(response, "添加失败，接口名称为空！");
			return;
		} else if ("".equals(actionName)) {
			JsonOutput.out(response, "添加失败，接口action名称为空！");
			return;
		}
		Action a = new Action();
		a.setName(name);
		a.setRemark(remark);
		a.setCid(cid);
		a.setActionName(actionName);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setCreateUser(uid);
		int result = actionService.save(a);
		if (result == 0) {
			JsonOutput.out(response, "添加失败！");
			return;
		} else {
			JsonOutput.out(response, "添加成功！");
			return;
		}
	}

	@RequestMapping("/edit")
	public void edit(HttpServletResponse response, HttpSession session, String name, String remark, int sort, int cid,
			String actionName, int id) {
		if ("".equals(name)) {
			JsonOutput.out(response, "修改失败，接口名称为空！");
			return;
		} else if ("".equals(actionName)) {
			JsonOutput.out(response, "修改失败，接口action名称为空！");
			return;
		}
		Action a = new Action();
		a.setName(name);
		a.setRemark(remark);
		a.setCid(cid);
		a.setActionName(actionName);
		a.setSort(sort);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setUpdateUser(uid);
		a.setId(id);

		int result = actionService.edit(a);
		if (result == 0) {
			JsonOutput.out(response, "修改失败！");
			return;
		} else {
			JsonOutput.out(response, "修改成功！");
			return;
		}
	}

	@RequestMapping("/del")
	public void del(HttpServletResponse response, int id, int cid, HttpSession session) {
		if (actionService.delete(id) == 0) {
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
		Action a = actionService.getActionById(id);
		map.put("id", a.getId());
		map.put("name", a.getName());
		map.put("remark", a.getRemark());
		map.put("sort", a.getSort());
		map.put("cid", a.getCid());
		map.put("actionName", a.getActionName());
		if ("x".equals(o)) {
			// 修改页面
			return "action/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "action/show";
		}
		return "";
	}
}
