package com.jmy.controller.home;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.SyInfo;
import com.jmy.service.SyInfoService;

@Controller
@RequestMapping("home/sy")
public class HomeSyInfoController {

	@Resource
	private SyInfoService syInfoService;

	@RequestMapping(value = "list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "1") int vid) {
		JSONObject json = new JSONObject();
		List<SyInfo> syInfos = syInfoService.getInfos(vid);
		SyInfo v = new SyInfo();
		JSONArray js = new JSONArray();
		for (int i = 0; i < syInfos.size(); i++) {
			JSONObject j = new JSONObject();
			v = syInfos.get(i);
			j.put("name", v.getName());
			j.put("isHref", v.getIsHref());
			j.put("vid", v.getVersionId());
			j.put("content", v.getContent());
			j.put("sort", v.getSort());
			j.put("id", v.getId());
			js.add(j);
		}
		json.put("data", js);
		// json.put("total", dsp.getTotal());
		// json.put("size", dsp.getSize());
		// json.put("now", dsp.getNow());
		// json.put("count", dsp.getCount());
		return json;
	}

	@RequestMapping(value = "show")
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") Integer id) {
		JSONObject j = new JSONObject();
		SyInfo v = syInfoService.getInfoById(id);
		j.put("name", v.getName());
		j.put("isHref", v.getIsHref());
		j.put("vid", v.getVersionId());
		j.put("content", v.getContent());
		j.put("sort", v.getSort());
		j.put("id", v.getId());
		return j;
	}

	@RequestMapping(value = "del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "") Integer id) {
		JSONObject json = new JSONObject();
		int r = syInfoService.del(id);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "删除失败！");
		}
		return json;
	}

	@RequestMapping(value = "edit")
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer vid, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") int sort, @RequestParam(defaultValue = "") byte isHref,
			@RequestParam(defaultValue = "") String content) {
		JSONObject json = new JSONObject();
		name = name.trim();
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "选项卡名称为空！");
			return json;
		}
		SyInfo s = new SyInfo();
		s.setContent(content);
		s.setId(id);
		s.setIsHref(isHref);
		s.setName(name.trim());
		s.setSort(sort);
		s.setVersionId(vid);
		s.setIsDel((byte)0);
		int r = syInfoService.edit(s);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@RequestMapping(value = "add")
	public @ResponseBody JSONObject add(@RequestParam(defaultValue = "") Integer vid,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") int sort,
			@RequestParam(defaultValue = "") byte isHref, @RequestParam(defaultValue = "") String content) {
		JSONObject json = new JSONObject();
		name = name.trim();
		if (name.equals("")) {
			json.put("status", 0);
			json.put("error", "选项卡名称为空！");
			return json;
		}
		SyInfo s = new SyInfo();
		s.setContent(content);
		s.setIsHref(isHref);
		s.setName(name.trim());
		s.setSort(sort);
		s.setVersionId(vid);
		int r = syInfoService.save(s);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}

}
