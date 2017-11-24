package com.jmy.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.VersionMapper;
import com.jmy.entity.Version;
import com.jmy.entity.VersionExample;
import com.jmy.entity.VersionExample.Criteria;
import com.jmy.service.VersionService;
import com.jmy.util.DataShowPage;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

	@Resource
	private VersionMapper versionMapper;

	public DataShowPage list(int pageNum, int pageSize, Version v) {
		VersionExample ve = new VersionExample();
		Criteria c = ve.createCriteria().andIsdelEqualTo((byte) 0);
		if (!v.getCode().equals("")) {
			c.andCodeLike("%" + v.getCode() + "%");
		}
		if (!v.getName().equals("")) {
			c.andNameLike("%" + v.getName() + "%");
		}
		if (!v.getTitle().equals("")) {
			c.andTitleLike("%" + v.getTitle() + "%");
		}

		ve.setOrderByClause("id desc");

		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<Version> list = versionMapper.selectByExampleWithBLOBs(ve);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public DataShowPage list(int pageNum, int pageSize, Version v, int userId) {
		VersionExample ve = new VersionExample();

		com.jmy.entity.VersionExample.Criteria c = ve.createCriteria().andIsdelEqualTo((byte) 0)
				.andUserIdEqualTo(userId);
		if (!v.getCode().equals("")) {
			c.andCodeLike("%" + v.getCode() + "%");
		}
		if (!v.getName().equals("")) {
			c.andNameLike("%" + v.getName() + "%");
		}
		if (!v.getTitle().equals("")) {
			c.andTitleLike("%" + v.getTitle() + "%");
		}

		ve.setOrderByClause("id desc");

		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<Version> list = versionMapper.selectByExampleWithBLOBs(ve);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public Version show(int id) {
		VersionExample v = new VersionExample();
		v.createCriteria().andIdEqualTo(id).andIsdelEqualTo((byte)0);
		List<Version> versions = versionMapper.selectByExampleWithBLOBs(v);
		if(versions.size() > 0) {
			return versions.get(0);
		} else {
			return null;
		}
	}

	public JSONObject delete(int id) {
		JSONObject json = new JSONObject();
		int status = 0;
		Version v = new Version();
		v.setIsdel((byte) 1);
		v.setId(id);
		int r = versionMapper.updateByPrimaryKeySelective(v);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "删除失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject add(int userId, String title, String pic, String content, String name, int years) {
		JSONObject json = new JSONObject();
		int status = 0;
		Version v = new Version();
		v.setIsdel((byte) 0);
		v.setCode("");
		v.setTitle(title.trim());
		v.setPic(pic.trim());
		v.setContent(content.trim());
		v.setName(name.trim());
		v.setCreateuser(0);
		v.setCreatetime((int) (System.currentTimeMillis() / 1000));
		v.setUpdatetime(0);
		v.setUpdateuser(0);
		v.setUserId(userId);
		v.setIsadminupdate((byte) 0);
		v.setYears(years);
		v.setStartTime((int) (System.currentTimeMillis() / 1000));
		v.setMoney(years * 1000);
		v.setStatus((byte)1);
		
		Calendar calendar = Calendar.getInstance();
		long dt = (long) (1000.0 * v.getStartTime());
		Date date = new Date(dt);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +years);
		long longTime = calendar.getTimeInMillis();
		System.out.println(longTime);
		int intTime = (int) (longTime / 1000);
		
		v.setLastTime(intTime);
		int r = versionMapper.insertSelective(v);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "添加失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject addCode(int id, String code) {
		JSONObject json = new JSONObject();
		int status = 0;
		Version v = new Version();
		v.setId(id);
		v.setCode(code);
		int r = versionMapper.updateByPrimaryKeySelective(v);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "添加型号失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject editUser(int id, int userId, String code, String title, String pic, String content, String name) {
		JSONObject json = new JSONObject();
		int status = 0;
		Version v = new Version();
		v.setId(id);
		v.setCode(code.trim());
		v.setTitle(title.trim());
		v.setPic(pic.trim());
		v.setContent(content.trim());
		v.setName(name.trim());
		v.setUpdatetime((int) (System.currentTimeMillis() / 1000));
		v.setUpdateuser(userId);
		v.setIsadminupdate((byte) 0);
		int r = versionMapper.updateByPrimaryKeySelective(v);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "修改失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject editAdmin(int id, int adminId, String code, String title, String pic, String content,
			String name) {
		JSONObject json = new JSONObject();
		int status = 0;
		Version v = new Version();
		v.setId(id);
		v.setCode(code.trim());
		v.setTitle(title.trim());
		v.setPic(pic.trim());
		v.setContent(content.trim());
		v.setName(name.trim());
		v.setUpdatetime((int) (System.currentTimeMillis() / 1000));
		v.setUpdateuser(adminId);
		v.setIsadminupdate((byte) 1);
		int r = versionMapper.updateByPrimaryKeySelective(v);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "修改失败！");
		}
		json.put("status", status);
		return json;
	}

	@Override
	public int status(int id) {
		// TODO Auto-generated method stub
		Version v = new Version();
		v.setId(id);
		v.setStatus((byte)0);
		return versionMapper.updateByPrimaryKeySelective(v);
	}

}
