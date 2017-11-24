package com.jmy.controller.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.entity.Swjg;
import com.jmy.service.EnterpriseService;
import com.jmy.service.SwjgService;

@Controller
@RequestMapping("/app/mine")
public class AppMineController {

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") int enterpriseId) {
		Enterprise e = enterpriseService.getEnterpriseById(enterpriseId);
		json.put("id", e.getId());
		json.put("name", e.getName());
		json.put("phone", e.getPhone());
		json.put("idCode", e.getIdCode());
		Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
		if (swjg != null) {
			json.put("swjgmc", swjg.getSwjgmc());
		}
		return json;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody JSONObject edit(@RequestParam(defaultValue = "0") Integer enterpriseId,
			@RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String name) {

		return enterpriseService.edit(enterpriseId, phone, name);
	}

	@RequestMapping(value = "/pass", method = RequestMethod.POST)
	public @ResponseBody JSONObject pass(@RequestParam(defaultValue = "0") Integer enterpriseId,
			@RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String password1,
			@RequestParam(defaultValue = "") String password2) {

		return enterpriseService.pass(enterpriseId, password, password1, password2);
	}
}
