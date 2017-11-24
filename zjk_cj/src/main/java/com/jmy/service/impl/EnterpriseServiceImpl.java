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
import com.jmy.dao.EnterpriseMapper;
import com.jmy.entity.Admi;
import com.jmy.entity.Enterprise;
import com.jmy.entity.EnterpriseExample;
import com.jmy.entity.EnterpriseExample.Criteria;
import com.jmy.entity.Swjg;
import com.jmy.entity.son.EnterpriseSon;
import com.jmy.service.EnterpriseService;
import com.jmy.service.SwjgService;
import com.jmy.util.DataShowPage;
import com.jmy.util.MD5Tools;

@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

	@Resource
	private EnterpriseMapper enterpriseMapper;
	@Resource
	private SwjgService swjgService;
	private JSONObject json = new JSONObject();

	@Override
	public JSONObject login(HttpSession session, String idCode, String password) {
		idCode = idCode.trim();
		json.clear();
		int status = 0;

		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIdCodeEqualTo(idCode).andIsDelEqualTo((byte) 0);
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(ee);

		EnterpriseExample ee2 = new EnterpriseExample();
		ee2.createCriteria().andPhoneEqualTo(idCode).andIsDelEqualTo((byte) 0).andBindEqualTo((byte) 1);
		List<Enterprise> enterprises2 = enterpriseMapper.selectByExample(ee2);

		if (enterprises.size() > 0) {
			Enterprise e = enterprises.get(0);
			if (MD5Tools.MD5(password + e.getSecret()).equals(e.getPassword())) {
				status = 1;
				session.setAttribute("enterprise", e);
				session.setAttribute("login", 1);
			} else {
				json.put("error", "用户名或密码错误！");
			}
		} else if (enterprises2.size() > 0) {
			Enterprise e = enterprises2.get(0);
			if (MD5Tools.MD5(password + e.getSecret()).equals(e.getPassword())) {
				status = 1;
				session.setAttribute("enterprise", e);
				session.setAttribute("login", 1);
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
	public JSONObject login(String idCode, String password) {
		idCode = idCode.trim();
		json.clear();
		int status = 0;

		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIdCodeEqualTo(idCode).andIsDelEqualTo((byte) 0);
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(ee);

		EnterpriseExample ee2 = new EnterpriseExample();
		ee2.createCriteria().andPhoneEqualTo(idCode).andIsDelEqualTo((byte) 0).andBindEqualTo((byte) 1);
		List<Enterprise> enterprises2 = enterpriseMapper.selectByExample(ee2);

		if (enterprises.size() > 0) {
			Enterprise e = enterprises.get(0);
			if (MD5Tools.MD5(password + e.getSecret()).equals(e.getPassword())) {
				status = 1;
				json.put("name", e.getName());
				json.put("enterpriseId", e.getId());
				json.put("loginTime", e.getLoginTime());
				Enterprise en = new Enterprise();
				en.setId(e.getId());
				en.setLoginTime(System.currentTimeMillis());
				enterpriseMapper.updateByPrimaryKeySelective(en);
			} else {
				json.put("error", "用户名或密码错误！");
			}
		} else if (enterprises2.size() > 0) {
			Enterprise e = enterprises2.get(0);
			if (MD5Tools.MD5(password + e.getSecret()).equals(e.getPassword())) {
				status = 1;
				json.put("name", e.getName());
				json.put("enterpriseId", e.getId());
				json.put("loginTime", e.getLoginTime());
				Enterprise en = new Enterprise();
				en.setId(e.getId());
				en.setLoginTime(System.currentTimeMillis());
				enterpriseMapper.updateByPrimaryKeySelective(en);
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
	public DataShowPage getNotices(int pageNum, int pageSize, String idCode, String swjgDm, String phone, String name) {
		EnterpriseExample ee = new EnterpriseExample();
		Criteria c = ee.createCriteria().andIsDelEqualTo((byte) 0).andSwjgDmEqualTo(swjgDm);
		ee.setOrderByClause("id desc");
		if (!phone.trim().equals("")) {
			c.andPhoneLike("%" + phone.trim() + "%");
		}
		if (!name.trim().equals("")) {
			c.andNameLike("%" + name.trim() + "%");
		}
		if (!idCode.trim().equals("")) {
			c.andIdCodeLike("%" + idCode.trim() + "%");
		}

		PageHelper.startPage(pageNum, pageSize);
		List<Enterprise> list = enterpriseMapper.selectByExample(ee);
		List<EnterpriseSon> ess = new ArrayList<EnterpriseSon>();
		for (Enterprise e : list) {
			EnterpriseSon es = new EnterpriseSon();
			Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
			es.setCreateTime(e.getCreateTime());
			es.setCreateUser(e.getCreateUser());
			es.setId(e.getId());
			es.setIdCode(e.getIdCode());
			es.setIsDel(e.getIsDel());
			es.setName(e.getName());
			es.setPassword(e.getPassword());
			es.setPhone(e.getPhone());
			es.setSecret(e.getSecret());
			es.setSwjg(swjg);
			es.setSwjgDm(e.getSwjgDm());
			es.setUpdateTime(e.getUpdateTime());
			es.setUpdateUser(e.getUpdateUser());
			es.setUsername(e.getUsername());
			ess.add(es);
		}
		DataShowPage page = new DataShowPage();
		page.setRows(ess);

		page.setNow(pageNum);
		page.setSize(pageSize);

		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public Enterprise getEnterpriseById(int id) {
		return enterpriseMapper.selectByPrimaryKey(id);
	}

	@Override
	public JSONObject edit(int id, String phone, String name) {
		json.clear();
		Enterprise e = new Enterprise();
		e.setId(id);
		e.setPhone(phone);
		e.setName(name);
		e.setIsDel((byte) 0);
		e.setUpdateTime(System.currentTimeMillis());
		e.setUpdateUser(0);
		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@Override
	public JSONObject edit(int id, String idCode, String phone, String name, HttpSession session) {
		json.clear();
		Admi admin = (Admi) session.getAttribute("admin");
		if (admin == null) {
			json.put("status", 0);
			json.put("error", "登录已过期，请重新登录再试！");
			return json;
		}
		Enterprise e = new Enterprise();
		e.setId(id);
		e.setPhone(phone);
		e.setName(name);
		if ("".equals(idCode) || "".equals(idCode.trim())) {
			json.put("status", 0);
			json.put("error", "纳税人识别号为空！");
			return json;
		} else {
			json.put("status", 1);
			e.setIdCode(idCode.trim());
		}
		e.setIsDel((byte) 0);
		e.setUpdateTime(System.currentTimeMillis());
		e.setUpdateUser(admin.getId());
		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@Override
	public JSONObject add(String idCode, String password1, String password2, String phone, String name, String swjgDm,
			HttpSession session) {
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
		Enterprise e = new Enterprise();
		e.setPhone(phone);
		e.setName(name);
		if ("".equals(idCode) || "".equals(idCode.trim())) {
			json.put("status", 0);
			json.put("error", "纳税人识别号为空！");
			return json;
		} else {
			json.put("status", 1);
			e.setIdCode(idCode.trim());
		}
		if ("".equals(swjgDm) || "".equals(swjgDm.trim())) {
			json.put("status", 0);
			json.put("error", "税务机关代码为空！");
			return json;
		} else {
			json.put("status", 1);
			e.setSwjgDm(swjgDm.trim());
		}
		// 密码
		int p = new Random().nextInt(999999);
		e.setPassword(MD5Tools.MD5(password1 + p));
		e.setSecret(p + "");

		e.setIsDel((byte) 0);
		e.setCreateTime(System.currentTimeMillis());
		e.setCreateUser(admin.getId());
		EnterpriseExample example = new EnterpriseExample();
		example.createCriteria().andIsDelEqualTo((byte) 0).andIdCodeEqualTo(idCode);
		List<Enterprise> en = enterpriseMapper.selectByExample(example);
		if (en.size() > 0) {
			json.put("status", 0);
			json.put("error", "该企业已存在！");
			return json;

		}
		int r = enterpriseMapper.insertSelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "添加失败！");
		}
		return json;
	}
	@Override
	public JSONObject add(String idCode, String password1, String password2, String phone, String name, String swjgDm,
			int adminId) {
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
		Enterprise e = new Enterprise();
		e.setPhone(phone);
		e.setName(name);
		if ("".equals(idCode) || "".equals(idCode.trim())) {
			json.put("status", 0);
			json.put("error", "纳税人识别号为空！");
			return json;
		} else {
			json.put("status", 1);
			e.setIdCode(idCode.trim());
		}
		if ("".equals(swjgDm) || "".equals(swjgDm.trim())) {
			json.put("status", 0);
			json.put("error", "税务机关代码为空！");
			return json;
		} else {
			json.put("status", 1);
			e.setSwjgDm(swjgDm.trim());
		}
		// 密码
		int p = new Random().nextInt(999999);
		e.setPassword(MD5Tools.MD5(password1 + p));
		e.setSecret(p + "");
		
		e.setIsDel((byte) 0);
		e.setCreateTime(System.currentTimeMillis());
		e.setCreateUser(adminId);
		EnterpriseExample example = new EnterpriseExample();
		example.createCriteria().andIsDelEqualTo((byte) 0).andIdCodeEqualTo(idCode);
		List<Enterprise> en = enterpriseMapper.selectByExample(example);
		if (en.size() > 0) {
			json.put("status", 0);
			json.put("error", "该企业已存在！");
			return json;
			
		}
		int r = enterpriseMapper.insertSelective(e);
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
		Enterprise e = new Enterprise();
		e.setId(id);
		e.setIsDel((byte) 1);

		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "删除失败！");
		}
		return json;
	}

	public JSONObject bind(int id) {
		json.clear();
		Enterprise e = new Enterprise();
		e.setId(id);
		e.setBind((byte) 1);

		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "绑定失败！");
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

		Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
		if (!enterprise.getPassword().equals(MD5Tools.MD5(password + enterprise.getSecret()))) {
			json.put("status", 0);
			json.put("error", "原密码输入不正确！");
			return json;
		}

		Enterprise e = new Enterprise();
		e.setId(id);

		// 密码
		int p = new Random().nextInt(999999);
		e.setPassword(MD5Tools.MD5(password1 + p));
		e.setSecret(p + "");

		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
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

		Enterprise e = new Enterprise();
		e.setId(id);

		// 密码
		int p = new Random().nextInt(999999);
		e.setPassword(MD5Tools.MD5(password1 + p));
		e.setSecret(p + "");

		int r = enterpriseMapper.updateByPrimaryKeySelective(e);
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "修改失败！");
		}
		return json;
	}

	@Override
	public List<Enterprise> getEnterprisesBySwjgDm(String swjgDm) {
		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIsDelEqualTo((byte) 0).andSwjgDmEqualTo(swjgDm);
		ee.setOrderByClause("id desc");

		return enterpriseMapper.selectByExample(ee);
	}

	public List<Enterprise> getEnterprisesByPhone(String phone) {
		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIsDelEqualTo((byte) 0).andPhoneEqualTo(phone);
		ee.setOrderByClause("id desc");

		return enterpriseMapper.selectByExample(ee);
	}

	@Override
	public List<Enterprise> getEnterprises() {
		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIsDelEqualTo((byte) 0);
		ee.setOrderByClause("id desc");
		return enterpriseMapper.selectByExample(ee);
	}

	@Override
	public Enterprise getEnterprisesByIdCode(String idCode) {
		EnterpriseExample ee = new EnterpriseExample();
		ee.createCriteria().andIsDelEqualTo((byte) 0).andIdCodeEqualTo(idCode);
		ee.setOrderByClause("id desc");

		List<Enterprise> enterprises = enterpriseMapper.selectByExample(ee);
		if (enterprises.size() == 0) {
			return null;
		} else {
			return enterprises.get(0);
		}
	}

}
