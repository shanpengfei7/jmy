package com.jmy.service;

import java.util.List;

import com.jmy.entity.Swjg;

public interface SwjgService {

	public List<Swjg> getSwjgsBySjswjg(String sjSwjg);

	public Swjg getSwjgByswjg(String Swjg);
	
	public List<Swjg> getSwjgs();
}
