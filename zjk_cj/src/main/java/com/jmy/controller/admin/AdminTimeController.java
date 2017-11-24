package com.jmy.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.PreTime;
import com.jmy.service.PreTimeService;
import com.jmy.util.DateFormatUtil;

@Controller
@RequestMapping("/admin/time")
public class AdminTimeController {

	@Resource
	private PreTimeService preTimeService;
	private JSONObject json = new JSONObject();

	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", preTimeService.list(pageNum, pageSize));
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add() {
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Map<String, Object> map, @RequestParam(defaultValue = "") String lastTime,
			@RequestParam(defaultValue = "") String nowTime) {
		json = preTimeService.add(lastTime, nowTime);
		if (json.getInteger("status") == 0) {
			map.put("nowTime", nowTime);
			map.put("lastTime", lastTime);
			map.put("error", json.getString("error"));
			return "admin/time/add";
		}
		map.put("data", json);
		return "redirect:list.jmy";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public Map<String, Object> edit(@RequestParam(defaultValue = "") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		PreTime p = preTimeService.getPreTimeById(id);
		map.put("id", id);
		map.put("nowTime", DateFormatUtil.getStrTime(p.getNowTime()));
		map.put("lastTime", DateFormatUtil.getStrTime(p.getLastTime()));
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "0") Integer id,
			@RequestParam(defaultValue = "") String lastTime, @RequestParam(defaultValue = "") String nowTime) {

		json = preTimeService.edit(id, lastTime, nowTime);
		if (json.getInteger("status") == 0) {
			map.put("nowTime", nowTime);
			map.put("lastTime", lastTime);
			map.put("id", id);
			map.put("error", json.getString("error"));
			return "admin/time/edit";
		}
		map.put("data", json);
		return "redirect:list.jmy";
	}

	@RequestMapping("/del")
	public @ResponseBody JSONObject del(@RequestParam(defaultValue = "0") Integer id) {
		json.clear();

		json = preTimeService.del(id);

		return json;
	}

}
