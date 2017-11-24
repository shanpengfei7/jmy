package com.jmy.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.SyInfo;
import com.jmy.entity.User;
import com.jmy.entity.Version;
import com.jmy.service.AdminService;
import com.jmy.service.SyInfoService;
import com.jmy.service.UserService;
import com.jmy.service.VersionService;
import com.jmy.util.DataShowPage;

@Controller
@RequestMapping("admin/version")
public class AdminVersionController {
	@Resource
	private SyInfoService syInfoService;
	@Resource
	private AdminService adminService;
	@Resource
	private VersionService versionService;
	@Resource
	private UserService userService;
	private JSONObject json = new JSONObject();

	@RequestMapping(value = "list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, @RequestParam(defaultValue = "") String code,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String title) {
		Version v = new Version();
		v.setCode(code.trim());
		v.setName(name.trim());
		v.setTitle(title.trim());
		DataShowPage dsp = versionService.list(page, rows, v);

		JSONArray js = new JSONArray();
		for (int i = 0; i < dsp.getRows().size(); i++) {
			JSONObject j = new JSONObject();
			v = (Version) dsp.getRows().get(i);
			j.put("name", v.getName());
			j.put("code", v.getCode());
			j.put("title", v.getTitle());
			j.put("content", v.getContent());
			j.put("id", v.getId());
			User u = userService.show(v.getUserId());
			j.put("user", u.getName());
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
		Version v = versionService.show(id);
		json.put("id", v.getId());
		json.put("code", v.getCode());
		json.put("title", v.getTitle());
		json.put("pic", v.getPic());
		json.put("content", v.getContent());
		json.put("name", v.getName());
		User u = userService.show(v.getUserId());
		json.put("user", u.getName());
		List<SyInfo> syInfos = syInfoService.getInfos(v.getId());
		SyInfo s1 = syInfos.get(0);
		SyInfo s2 = syInfos.get(1);
		SyInfo s3 = syInfos.get(2);
		SyInfo s4 = syInfos.get(3);

		// if (!"0".equals(s1.getContent())) {
		json.put("name1", s1.getName());
		json.put("content1", s1.getContent());
		json.put("sort1", s1.getSort());
		json.put("isHref1", s1.getIsHref());
		// }
		// if (!"0".equals(s2.getContent())) {
		json.put("name2", s2.getName());
		json.put("content2", s2.getContent());
		json.put("sort2", s2.getSort());
		json.put("isHref2", s2.getIsHref());
		// }
		// if (!"0".equals(s3.getContent())) {
		json.put("name3", s3.getName());
		json.put("content3", s3.getContent());
		json.put("sort3", s3.getSort());
		json.put("isHref3", s3.getIsHref());
		// }
		// if (!"0".equals(s4.getContent())) {
		json.put("name4", s4.getName());
		json.put("content4", s4.getContent());
		json.put("sort4", s4.getSort());
		json.put("isHref4", s4.getIsHref());
		// }
		json.put("data", syInfos);
		return json;
	}
	@RequestMapping(value = "del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "") Integer id) {
		return versionService.delete(id);
	}
	
	@RequestMapping(value = "edit")
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer adminId, @RequestParam(defaultValue = "") String code,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String pic, @RequestParam(defaultValue = "") String content) {
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
		json = versionService.editAdmin(id, adminId, code, title, pic, content, name);
		return json;
	}
}
