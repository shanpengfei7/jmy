package com.jmy.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.dao.VersionExtMapper;
import com.jmy.dao.VersionMapper;
import com.jmy.entity.Version;
import com.jmy.entity.VersionExt;
import com.jmy.entity.VersionExtExample;
import com.jmy.service.VersionExtService;
import com.jmy.util.DataShowPage;

@Service("versionExtService")
public class VersionExtServiceImpl implements VersionExtService {

	@Resource
	private VersionExtMapper versionExtMapper;
	@Resource
	private VersionMapper versionMapper;

	@Override
	public JSONObject save(int vid, int addyear) {
		VersionExt v = new VersionExt();
		v.setVid(vid);
		v.setAddyear(addyear);

		int oldTime = 0;
		List<VersionExt> versionExts = getVersionExts(vid);
		if (versionExts.size() > 0) {
			oldTime = versionExts.get(0).getNewTime();
		} else {
			Version version = versionMapper.selectByPrimaryKey(vid);
			oldTime = version.getLastTime();
		}

		v.setOldTime(oldTime);

		Calendar calendar = Calendar.getInstance();
		long dt = (long) (1000.0 * oldTime);
		Date date = new Date(dt);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +addyear);
		long longTime = calendar.getTimeInMillis();
		System.out.println(longTime);
		int intTime = (int) (longTime / 1000);

		v.setNewTime(intTime);
		v.setMoney(addyear * 1000);
		v.setCreateTime((int) (System.currentTimeMillis() / 1000));
		v.setCreateUser(0);
		v.setMessage("");
		int r = versionExtMapper.insertSelective(v);
		JSONObject json = new JSONObject();
		if (r > 0) {
			Version vv = new Version();
			vv.setId(vid);
			vv.setStatus((byte) 1);
			vv.setLastTime(intTime);
			int re = versionMapper.updateByPrimaryKeySelective(vv);
			if (re > 0) {
				json.put("status", 1);
			} else {
				json.put("status", 0);
				json.put("error", "续费失败！");
			}
		} else {
			json.put("status", 0);
			json.put("error", "续费失败！");
		}
		return json;
	}

	public List<VersionExt> getVersionExts(int vid) {
		VersionExtExample v = new VersionExtExample();
		v.createCriteria().andVidEqualTo(vid);
		v.setOrderByClause("id desc");
		return versionExtMapper.selectByExample(v);
	}

	@Override
	public DataShowPage getVersionExts(int vid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionExt getVersionExt(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
