package com.jmy.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.App;

public interface AppService {

	public List<App> getApps();

	public JSONObject add(String name, String version, String path);

	public JSONObject edit(int id, String name, String version, String path);

	public JSONObject del(int id);

	public App getApp(int id);
}
