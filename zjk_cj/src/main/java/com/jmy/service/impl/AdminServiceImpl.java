package com.jmy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.AdmiMapper;
import com.jmy.entity.Admi;
import com.jmy.entity.AdmiExample;
import com.jmy.entity.AdmiExample.Criteria;
import com.jmy.entity.Swjg;
import com.jmy.entity.son.AdminSon;
import com.jmy.service.AdminService;
import com.jmy.service.SwjgService;
import com.jmy.util.DataShowPage;
import com.jmy.util.MD5Tools;

@Service("admiService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdmiMapper admiMapper;
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();

	@Override
	public JSONObject login(HttpSession session, String swjgDm, String password) {
		swjgDm = swjgDm.trim();
		json.clear();
		int status = 0;
		AdmiExample ae = new AdmiExample();
		ae.createCriteria().andSwjgDmEqualTo(swjgDm).andIsDelEqualTo((byte) 0);
		List<Admi> admis = admiMapper.selectByExample(ae);
		if (admis.size() > 0) {
			Admi a = admis.get(0);
			if (MD5Tools.MD5(password + a.getSecret()).equals(a.getPassword())) {
				status = 1;
				session.setAttribute("admin", a);
				session.setAttribute("login", 1);
				
				if (a.getRole() == 0) {
					session.setAttribute("swjgmc", "管理员");
				} else {
					if (a != null) {
						Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
						if (swjg != null) {
							session.setAttribute("swjgmc", swjg.getSwjgmc());
						}
					}
				}
			} else {
				json.put("error", "用户名或密码错误！");
			}
		} else {
			json.put("error", "用户名或密码错误！");
		}

		json.put("status", status);
		return json;
	}

	@Override
	public DataShowPage getNotices(int pageNum, int pageSize, int pid, String swjgDm, String phone, String name) {
		AdmiExample ae = new AdmiExample();
		Criteria c = ae.createCriteria().andIsDelEqualTo((byte) 0).andPIdEqualTo(pid);
		if (!swjgDm.trim().equals("")) {
			c.andSwjgDmEqualTo("%" + swjgDm.trim() + "%");
		}
		if (!phone.trim().equals("")) {
			c.andPhoneLike("%" + phone.trim() + "%");
		}
		if (!name.trim().equals("")) {
			c.andNameLike("%" + name.trim() + "%");
		}

		PageHelper.startPage(pageNum, pageSize);
		List<Admi> list = admiMapper.selectByExample(ae);
		List<AdminSon> as = new ArrayList<AdminSon>();
		for (Admi admi : list) {
			AdminSon a = new AdminSon();
			Swjg swjg = swjgService.getSwjgByswjg(admi.getSwjgDm());
			a.setSwjg(swjg);
			a.setCreateTime(admi.getCreateTime());
			a.setCreateUser(admi.getCreateUser());
			a.setId(admi.getId());
			a.setIsDel(admi.getIsDel());
			a.setName(admi.getName());
			a.setPassword(admi.getPassword());
			a.setPhone(admi.getPhone());
			a.setpId(admi.getpId());
			a.setRole(admi.getRole());
			a.setSecret(admi.getSecret());
			a.setSwjgDm(admi.getSwjgDm());
			a.setUpdateTime(admi.getUpdateTime());
			a.setUpdateUser(admi.getUpdateUser());
			a.setUsername(admi.getUsername());
			as.add(a);
		}

		DataShowPage page = new DataShowPage();
		page.setRows(as);

		page.setNow(pageNum);
		page.setSize(pageSize);

		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public Admi getAdminById(int id) {
		return admiMapper.selectByPrimaryKey(id);
	}

	public Admi getAdminBySwjgDm(String swjgDm) {
		AdmiExample ae = new AdmiExample();
		ae.createCriteria().andIsDelEqualTo((byte) 0).andSwjgDmEqualTo(swjgDm);
		List<Admi> admis = admiMapper.selectByExample(ae);
		if (admis == null) {
			return null;
		}
		return admis.get(0);
	}

	@Override
	public JSONObject edit(int id, String phone, String name, HttpSession session) {
		json.clear();
		Admi admin = (Admi) session.getAttribute("admin");
		if (admin == null) {
			json.put("status", 0);
			json.put("error", "登录已过期，请重新登录再试！");
			return json;
		}
		Admi a = new Admi();
		a.setId(id);
		a.setPhone(phone);
		a.setName(name);
		a.setUpdateTime(System.currentTimeMillis());
		a.setUpdateUser(admin.getId());

		int r = admiMapper.updateByPrimaryKeySelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@Override
	public JSONObject add(String phone, String password1, String password2, String name, String swjgDm, int pId,
			byte role, HttpSession session) {
		json.clear();
		if ("".equals(password1) || "".equals(password1.trim())) {
			json.put("status", 0);
			json.put("error", "密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if ("".equals(password2) || "".equals(password2.trim())) {
			json.put("status", 0);
			json.put("error", "确认密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if (!password2.equals(password1)) {
			json.put("status", 0);
			json.put("error", "两次密码输入不一致！");
			return json;
		} else {
			json.put("status", 1);
		}
		Admi admin = (Admi) session.getAttribute("admin");
		if (admin == null) {
			json.put("status", 0);
			json.put("error", "登录已过期，请重新登录再试！");
			return json;
		}
		Admi a = new Admi();
		a.setPhone(phone);
		a.setName(name);
		if ("".equals(swjgDm) || "".equals(swjgDm.trim())) {
			json.put("status", 0);
			json.put("error", "税务机关代码为空！");
			return json;
		} else {
			json.put("status", 1);
			a.setSwjgDm(swjgDm.trim());
		}

		// 密码
		int p = new Random().nextInt(999999);
		a.setPassword(MD5Tools.MD5(password1 + p));
		a.setSecret(p + "");

		a.setIsDel((byte) 0);
		a.setpId(pId);
		a.setRole(role);
		a.setCreateTime(System.currentTimeMillis());
		a.setCreateUser(admin.getId());
		AdmiExample example = new AdmiExample();
		example.createCriteria().andIsDelEqualTo((byte) 0).andSwjgDmEqualTo(swjgDm);
		List<Admi> ad = admiMapper.selectByExample(example);
		if (ad.size() > 0) {
			json.put("status", 0);
			json.put("error", "该税务机关已存在！");
			return json;

		}
		int r = admiMapper.insertSelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}
	@Override
	public JSONObject add(String phone, String password1, String password2, String name, String swjgDm, int pId,
			byte role, int adminId) {
		json.clear();
		if ("".equals(password1) || "".equals(password1.trim())) {
			json.put("status", 0);
			json.put("error", "密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if ("".equals(password2) || "".equals(password2.trim())) {
			json.put("status", 0);
			json.put("error", "确认密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if (!password2.equals(password1)) {
			json.put("status", 0);
			json.put("error", "两次密码输入不一致！");
			return json;
		} else {
			json.put("status", 1);
		}
		Admi a = new Admi();
		a.setPhone(phone);
		a.setName(name);
		if ("".equals(swjgDm) || "".equals(swjgDm.trim())) {
			json.put("status", 0);
			json.put("error", "税务机关代码为空！");
			return json;
		} else {
			json.put("status", 1);
			a.setSwjgDm(swjgDm.trim());
		}
		
		// 密码
		int p = new Random().nextInt(999999);
		a.setPassword(MD5Tools.MD5(password1 + p));
		a.setSecret(p + "");
		
		a.setIsDel((byte) 0);
		a.setpId(pId);
		a.setRole(role);
		a.setCreateTime(System.currentTimeMillis());
		a.setCreateUser(adminId);
		AdmiExample example = new AdmiExample();
		example.createCriteria().andIsDelEqualTo((byte) 0).andSwjgDmEqualTo(swjgDm);
		List<Admi> ad = admiMapper.selectByExample(example);
		if (ad.size() > 0) {
			json.put("status", 0);
			json.put("error", "该税务机关已存在！");
			return json;
			
		}
		int r = admiMapper.insertSelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}

	@Override
	public JSONObject del(int id) {
		json.clear();
		Admi a = new Admi();
		a.setId(id);
		a.setIsDel((byte) 1);

		int r = admiMapper.updateByPrimaryKeySelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "删除失败！");
		}
		return json;
	}

	@Override
	public JSONObject pass(int id, String password, String password1, String password2) {
		json.clear();

		if ("".equals(password) || "".equals(password.trim())) {
			json.put("status", 0);
			json.put("error", "原密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if ("".equals(password1) || "".equals(password1.trim())) {
			json.put("status", 0);
			json.put("error", "密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if ("".equals(password2) || "".equals(password2.trim())) {
			json.put("status", 0);
			json.put("error", "确认密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if (!password2.equals(password1)) {
			json.put("status", 0);
			json.put("error", "两次密码输入不一致！");
			return json;
		} else {
			json.put("status", 1);
		}

		Admi admi = admiMapper.selectByPrimaryKey(id);
		if (!admi.getPassword().equals(MD5Tools.MD5(password + admi.getSecret()))) {
			json.put("status", 0);
			json.put("error", "原密码输入不正确！");
			return json;
		}

		Admi a = new Admi();
		a.setId(id);

		// 密码
		int p = new Random().nextInt(999999);
		a.setPassword(MD5Tools.MD5(password1 + p));
		a.setSecret(p + "");

		int r = admiMapper.updateByPrimaryKeySelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}

	@Override
	public JSONObject pass(int id, String password1, String password2) {
		json.clear();

		if ("".equals(password1) || "".equals(password1.trim())) {
			json.put("status", 0);
			json.put("error", "密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if ("".equals(password2) || "".equals(password2.trim())) {
			json.put("status", 0);
			json.put("error", "确认密码为空！");
			return json;
		} else {
			json.put("status", 1);
		}
		if (!password2.equals(password1)) {
			json.put("status", 0);
			json.put("error", "两次密码输入不一致！");
			return json;
		} else {
			json.put("status", 1);
		}

		Admi a = new Admi();
		a.setId(id);

		// 密码
		int p = new Random().nextInt(999999);
		a.setPassword(MD5Tools.MD5(password1 + p));
		a.setSecret(p + "");

		int r = admiMapper.updateByPrimaryKeySelective(a);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}

}
