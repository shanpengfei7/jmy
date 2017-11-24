package com.jmy.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.VersionExt;
import com.jmy.util.DataShowPage;

public interface VersionExtService {

	/**
	 * 套餐续费
	 * 
	 * @param faceext
	 * @return
	 */
	public JSONObject save(int vid, int addyear);

	public List<VersionExt> getVersionExts(int vid);
	
	public DataShowPage getVersionExts(int vid, int pageNum, int pageSize);

	public VersionExt getVersionExt(int id);
}
