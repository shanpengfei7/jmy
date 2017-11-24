package com.jmy.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private CategoryService categoryService;

	@RequestMapping("/one")
	public String ont(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows) {
		map.put("data", categoryService.getOne(page, rows));
		return "category/one";
	}

	@RequestMapping("/two")
	public String two(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows, int pid) {
		map.put("data", categoryService.getTwo(pid, page, rows));
		return "category/two";
	}

	@RequestMapping("/three")
	public String three(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "1000") Integer rows, int pid) {
		map.put("data", categoryService.getThree(pid, page, rows));
		return "category/three";
	}

}
