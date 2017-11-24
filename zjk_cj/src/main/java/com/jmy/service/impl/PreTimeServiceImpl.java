package com.jmy.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.PreTimeMapper;
import com.jmy.entity.PreTime;
import com.jmy.entity.PreTimeExample;
import com.jmy.entity.son.PreTimeSon;
import com.jmy.service.PreTimeService;
import com.jmy.util.DataShowPage;
import com.jmy.util.DateFormatUtil;

@Service("preTimeService")
public class PreTimeServiceImpl implements PreTimeService {

	@Resource
	private PreTimeMapper preTimeMapper;
	private JSONObject json = new JSONObject();

	@Override
	public DataShowPage list(int pageNum, int pageSize) {
		PreTimeExample pte = new PreTimeExample();
		pte.setOrderByClause("id desc");

		PageHelper.startPage(pageNum, pageSize);
		List<PreTime> list = preTimeMapper.selectByExample(pte);
		List<PreTimeSon> sons = new ArrayList<PreTimeSon>();
		for (PreTime pt : list) {
			PreTimeSon s = new PreTimeSon();
			s.setLast(DateFormatUtil.getStrTime(pt.getLastTime()));
			s.setNow(DateFormatUtil.getStrTime(pt.getNowTime()));
			s.setId(pt.getId());
			s.setIsUse(pt.getIsUse());
			sons.add(s);
		}
		DataShowPage page = new DataShowPage();
		page.setRows(sons);

		page.setNow(pageNum);
		page.setSize(pageSize);

		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	@Override
	public JSONObject add(String lastTime, String nowTime) {
		json.clear();
		PreTime p = new PreTime();
		
		long last = DateFormatUtil.getTime(lastTime);
		p.setLastTime(last);
		long now = DateFormatUtil.getTime(nowTime);
		p.setNowTime(now);
		
		if(now < last) {
			json.put("status", 0);
			json.put("error", "该时间节点格式不正确！");
			return json;
		}
		long currentTime = System.currentTimeMillis();
		if(now < currentTime) {
			json.put("status", 0);
			json.put("error", "该时间节点已过时！");
			return json;
			
		}
		if (exist(now)) {
			json.put("status", 0);
			json.put("error", "该时间节点已存在！");
			return json;
		}
		int r = preTimeMapper.insertSelective(p);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}

	@Override
	public PreTime getPreTimeById(int id) {
		return preTimeMapper.selectByPrimaryKey(id);
	}

	@Override
	public PreTime getPreTimeByTime(long time) {
		PreTimeExample p = new PreTimeExample();
		p.createCriteria().andLastTimeLessThan(time).andNowTimeGreaterThanOrEqualTo(time);
		p.setOrderByClause("id desc");
		List<PreTime> times = preTimeMapper.selectByExample(p);
		if(times.size() == 0) {
			return null;
		} else {
			return times.get(0);
		}
	}

	@Override
	public JSONObject edit(int id, String lastTime, String nowTime) {
		json.clear();
		PreTime p = new PreTime();
		p.setId(id);
		long last = DateFormatUtil.getTime(lastTime);
		p.setLastTime(last);
		long now = DateFormatUtil.getTime(nowTime);
		p.setNowTime(now);
		if(now < last) {
			json.put("status", 0);
			json.put("error", "该时间节点格式不正确！");
			return json;
		}
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		String nt = s.format(new Date());
		if(now < DateFormatUtil.getTime(nt)) {
			json.put("status", 0);
			json.put("error", "该时间节点已过时！");
			return json;
			
		}
//		if (exist(now)) {
//			json.put("status", 0);
//			json.put("error", "该时间节点已存在！");
//			return json;
//		}
		int r = preTimeMapper.updateByPrimaryKeySelective(p);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@Override
	public JSONObject del(int id) {
		int r = preTimeMapper.deleteByPrimaryKey(id);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "删除失败！");
		}
		return json;
	}

	public Boolean exist(long nowTime) {
		PreTimeExample pte = new PreTimeExample();
		pte.createCriteria().andNowTimeEqualTo(nowTime);
		List<PreTime> pts = preTimeMapper.selectByExample(pte);
		if (pts.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PreTime> getTimesByTime(long start, long end) {
		PreTimeExample p = new PreTimeExample();
		p.createCriteria().andNowTimeBetween(start, end);
		p.setOrderByClause("id desc");
		return preTimeMapper.selectByExample(p);
	}

	@Override
	public List<PreTime> getTimes() {
		PreTimeExample p = new PreTimeExample();
		p.setOrderByClause("id desc");
		return preTimeMapper.selectByExample(p);
	}

	@Override
	public PreTime getPreTimeByNowTime(long time) {
		PreTimeExample p = new PreTimeExample();
		p.createCriteria().andNowTimeEqualTo(time);
		p.setOrderByClause("id desc");
		List<PreTime> times = preTimeMapper.selectByExample(p);
		if(times.size() > 0) {
			return times.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int flag(int id) {
		PreTime p = new PreTime();
		p.setId(id);
		p.setIsUse((byte)1);
		return preTimeMapper.updateByPrimaryKeySelective(p);
	}

}
