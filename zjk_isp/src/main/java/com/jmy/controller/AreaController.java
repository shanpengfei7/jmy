package com.jmy.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	@Resource
	private AreaService areaService;

	@RequestMapping("/sheng")
	public String sheng(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows) {
		map.put("data", areaService.getArea(page, rows));
		return "area/sheng";
	}

	@RequestMapping("/shi")
	public String shi(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows, int pid) {
		map.put("data", areaService.getArea(pid, page, rows));
		return "area/shi";
	}

	@RequestMapping("/xian")
	public String xian(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows, int pid) {
		map.put("data", areaService.getArea(pid, page, rows));
		return "area/xian";
	}

}
