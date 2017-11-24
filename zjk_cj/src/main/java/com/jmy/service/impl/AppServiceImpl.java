package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.dao.AppMapper;
import com.jmy.entity.App;
import com.jmy.entity.AppExample;
import com.jmy.service.AppService;

@Service("appService")
public class AppServiceImpl implements AppService {

	@Resource
	private AppMapper appMapper;
	
	private JSONObject json = new JSONObject();
	
	@Override
	public List<App> getApps() {
		AppExample ae = new AppExample();
		ae.setOrderByClause("id desc");
		return appMapper.selectByExample(ae);
	}

	@Override
	public JSONObject add(String name, String version, String path) {
		json.clear();
		name = name.trim();
		version = version.trim();
		path = path.trim();
		if(name.equals("")) {
			json.put("status", 0);
			json.put("error", "名称为空！");
			return json;
		}
		if(version.equals("")) {
			json.put("status", 0);
			json.put("error", "版本号为空！");
			return json;
		}
		if(path.equals("")) {
			json.put("status", 0);
			json.put("error", "没上传app！");
			return json;
		}
		App app = new App();
		app.setName(name);
		app.setPath(path);
		app.setVersion(version);
		
		int r = appMapper.insertSelective(app);
		if(r > 0) {
			json.put("status", 1);
			json.put("error", "");
			return json;
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
			return json;
		}
	}

	@Override
	public JSONObject edit(int id, String name, String version, String path) {
		json.clear();
		name = name.trim();
		version = version.trim();
		path = path.trim();
		if(name.equals("")) {
			json.put("status", 0);
			json.put("error", "名称为空！");
			return json;
		}
		if(version.equals("")) {
			json.put("status", 0);
			json.put("error", "版本号为空！");
			return json;
		}
		if(path.equals("")) {
			json.put("status", 0);
			json.put("error", "没上传app！");
			return json;
		}
		App app = new App();
		app.setName(name);
		app.setPath(path);
		app.setVersion(version);
		app.setId(id);
		
		int r = appMapper.updateByPrimaryKeySelective(app);
		if(r > 0) {
			json.put("status", 1);
			json.put("error", "");
			return json;
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
			return json;
		}
	}

	@Override
	public JSONObject del(int id) {
		json.clear();
		int r = appMapper.deleteByPrimaryKey(id);
		if(r > 0) {
			json.put("status", 1);
			json.put("error", "");
			return json;
		} else {
			json.put("status", 0);
			json.put("error", "删除失败！");
			return json;
		}
	}

	@Override
	public App getApp(int id) {
		return appMapper.selectByPrimaryKey(id);
	}

	

}
