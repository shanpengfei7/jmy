package com.jmy.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.PreTime;
import com.jmy.util.DataShowPage;

public interface PreTimeService {

	/**
	 * 一个月所有的时间点
	 * @param time
	 * @return
	 */
	public DataShowPage list(int pageNum, int pageSize); 
	
	public PreTime getPreTimeById(int id);

	public PreTime getPreTimeByTime(long time);
	
	public JSONObject add(String lastTime, String nowTime);
	
	public JSONObject edit(int id, String lastTime, String nowTime);
	
	public JSONObject del(int id);
	
	public Boolean exist(long nowTime);
	
	public List<PreTime> getTimesByTime(long start, long end);
	
	public List<PreTime> getTimes();
	
	public PreTime getPreTimeByNowTime(long time);
	
	public int flag(int id);
}
