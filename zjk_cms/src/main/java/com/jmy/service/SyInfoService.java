package com.jmy.service;

import java.util.List;

import com.jmy.entity.SyInfo;

public interface SyInfoService {

	public List<SyInfo> getInfos(int version_id);
	
	public SyInfo getInfoById(int id);
	
	public int save(SyInfo s);
	
	public int edit(SyInfo s);
	
	public int del(int id);
}
