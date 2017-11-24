package com.jmy.controller.admin;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.App;
import com.jmy.service.AppService;
import com.jmy.util.FileOperateUtil;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/admin/app")
public class AdminAppController {

	@Resource
	private AppService appService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/list")
	public Map<String, Object> list(Map<String, Object> map) {
		List<App> apps = appService.getApps();
		map.put("data", apps);
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add() {
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Map<String, Object> map, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String version, @RequestParam(defaultValue = "") String path) {
		json = appService.add(name, version, path);
		if (json.getInteger("status") == 0) {
			map.put("version", version);
			map.put("name", name);
			map.put("path", path);
			map.put("error", json.getString("error"));
			return "admin/app/add";
		}
		map.put("data", json);
		return "redirect:list.jmy";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(Map<String, Object> map, int id) {
		App a = appService.getApp(id);
		map.put("id", id);
		map.put("version", a.getVersion());
		map.put("name", a.getName());
		map.put("path", a.getPath());
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Map<String, Object> map, @RequestParam(defaultValue = "") int id,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String version,
			@RequestParam(defaultValue = "") String path) {
		json = appService.edit(id, name, version, path);
		if (json.getInteger("status") == 0) {
			map.put("version", version);
			map.put("name", name);
			map.put("path", path);
			map.put("error", json.getString("error"));
			return "admin/app/edit";
		}
		map.put("data", json);
		return "redirect:list.jmy";
	}

	@RequestMapping("/del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "0") Integer id) {
		json.clear();

		json = appService.del(id);

		return json;
	}

	@RequestMapping(value = "/upload")
	public void upload(HttpServletResponse response, HttpSession session, @RequestParam("app") MultipartFile file) {
		String filePath = "";
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				int index = fileName.lastIndexOf(".");
				String lastName = fileName.substring(index);
				// 文件保存路径
				filePath = "static/app/" + UUID.randomUUID().toString().replace("-", "") + lastName;
				// 转存文件
				file.transferTo(new File(session.getServletContext().getRealPath("/") + filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		json.clear();
		json.put("path", filePath);
		JsonOutput.out(response, json);
	}

	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response, int id) {

		App app = appService.getApp(id);

		String storeName = request.getSession().getServletContext().getRealPath("/") + app.getPath();
		String realName = app.getName() + "_" + app.getVersion()
				+ app.getPath().substring(app.getPath().lastIndexOf("."));
		String contentType = "application/octet-stream";

		try {
			FileOperateUtil.download(request, response, storeName, contentType, realName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
