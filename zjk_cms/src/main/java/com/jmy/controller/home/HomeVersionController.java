package com.jmy.controller.home;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.User;
import com.jmy.entity.Version;
import com.jmy.service.AdminService;
import com.jmy.service.UserService;
import com.jmy.service.VersionExtService;
import com.jmy.service.VersionService;
import com.jmy.util.DataShowPage;

@Controller
@RequestMapping("home/version")
public class HomeVersionController {

	@Resource
	private AdminService adminService;
	@Resource
	private VersionService versionService;
	@Resource
	private VersionExtService versionExtService;
	@Resource
	private UserService userService;

	@RequestMapping(value = "list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, @RequestParam(defaultValue = "1") Integer userId,
			@RequestParam(defaultValue = "") String code, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title) {
		JSONObject json = new JSONObject();
		Version v = new Version();
		v.setCode(code.trim());
		v.setName(name.trim());
		v.setTitle(title.trim());
		DataShowPage dsp = versionService.list(page, rows, v, userId);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONArray js = new JSONArray();
		for (int i = 0; i < dsp.getRows().size(); i++) {
			JSONObject j = new JSONObject();
			v = (Version) dsp.getRows().get(i);
			j.put("name", v.getName());
			j.put("code", v.getCode());
			j.put("lastTime", s.format(new Date((long) (1000.0 * v.getLastTime()))));
			j.put("status", v.getStatus());
			j.put("title", v.getTitle());
			j.put("content", v.getContent());
			j.put("id", v.getId());
			js.add(j);
		}
		json.put("data", js);
		json.put("total", dsp.getTotal());
		json.put("size", dsp.getSize());
		json.put("now", dsp.getNow());
		json.put("count", dsp.getCount());
		return json;
	}

	@RequestMapping(value = "show")
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") Integer id) {
		JSONObject json = new JSONObject();
		Version v = versionService.show(id);
		if (v == null) {
			json.put("status", 0);
			json.put("error", "码已被删除!");
		} else if (v.getStatus() == 0) {
			json.put("status", 0);
			json.put("error", "码已失效，需要续费!");
		} else if (v.getLastTime() < ((int) (System.currentTimeMillis() / 1000))) {
			json.put("status", 0);
			json.put("error", "码已失效，需要续费!");
			versionService.status(v.getId());
		} else {
			json.put("status", 1);
			json.put("id", v.getId());
			json.put("code", v.getCode());
			json.put("title", v.getTitle());
			json.put("pic", v.getPic());
			json.put("content", v.getContent());
			json.put("name", v.getName());
		}
		return json;
	}

	@RequestMapping(value = "del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer userId) {
		JSONObject json = new JSONObject();
		User u = userService.show(userId);
		if (u.getStatus() != 1) {
			json.put("status", 0);
			json.put("error", "您未通过审核，没有该权限！");
			return json;
		}
		return versionService.delete(id);
	}

	@RequestMapping(value = "edit")
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer userId, @RequestParam(defaultValue = "") String code,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String pic, @RequestParam(defaultValue = "") String content) {
		JSONObject json = new JSONObject();
		code = code.trim();
		title = title.trim();
		name = name.trim();
		if (code.equals("")) {
			json.put("status", 0);
			json.put("error", "型号码为空！");
			return json;
		}
		if (title.equals("")) {
			json.put("status", 0);
			json.put("error", "标题为空！");
			return json;
		}
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "名称为空！");
			return json;
		}
		User u = userService.show(userId);
		if (u.getStatus() != 1) {
			json.put("status", 0);
			json.put("error", "您未通过审核，没有该权限！");
			return json;
		}
		json = versionService.editUser(id, userId, code, title, pic, content, name);
		return json;
	}

	@RequestMapping(value = "add")
	public @ResponseBody JSONObject add(@RequestParam(defaultValue = "") Integer userId,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "0") int years, @RequestParam(defaultValue = "") String pic,
			@RequestParam(defaultValue = "") String content) {
		JSONObject json = new JSONObject();

		title = title.trim();
		name = name.trim();
		if (title.equals("")) {
			json.put("status", 0);
			json.put("error", "标题为空！");
			return json;
		}
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "名称为空！");
			return json;
		}
		User u = userService.show(userId);
		if (u.getStatus() != 1) {
			json.put("status", 0);
			json.put("error", "您未通过审核，没有该权限！");
			return json;
		}
		json = versionService.add(userId, title, pic, content, name, years);
		return json;
	}
	@RequestMapping(value = "ext")
	public @ResponseBody JSONObject ext(@RequestParam(defaultValue = "") Integer vid,
			@RequestParam(defaultValue = "0") int addyear) {
		JSONObject json = new JSONObject();
		
		json = versionExtService.save(vid, addyear);
		return json;
	}

	@RequestMapping(value = "addCode")
	public @ResponseBody JSONObject addCode(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String code) {
		JSONObject json = new JSONObject();
		code = code.trim();
		if (code.equals("")) {
			json.put("status", 0);
			json.put("error", "应用平台对应型号为空！");
			return json;
		}
		json = versionService.addCode(id, code);
		return json;
	}
}
