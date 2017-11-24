package com.jmy.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.UserMapper;
import com.jmy.entity.User;
import com.jmy.entity.UserExample;
import com.jmy.entity.UserExample.Criteria;
import com.jmy.service.UserService;
import com.jmy.util.DataShowPage;
import com.jmy.util.MD5Tools;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public JSONObject login(String email, String password) {
		JSONObject json = new JSONObject();
		int status = 0;
		email = email.trim();
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email).andIsdelEqualTo((byte)0);
		List<User> users = userMapper.selectByExample(ue);
		if (users.size() > 0) {
			User u = users.get(0);
			if (MD5Tools.MD5(password + u.getSecret()).equals(u.getPassword())) {
				status = 1;
				json.put("name", u.getName());
				json.put("id", u.getId());
			} else {
				json.put("error", "密码错误！");
			}
		} else {
			json.put("error", "用户名错误！");
		}

		json.put("status", status);
		return json;
	}

	public JSONObject register(String email, String password1, String password2) {
		JSONObject json = new JSONObject();
		int status = 0;
		if (!password1.equals(password2)) {
			json.put("status", status);
			json.put("error", "两次密码输入不一致！");
			return json;
		}
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email.trim()).andIsdelEqualTo((byte)0);
		List<User> users = userMapper.selectByExample(ue);
		if (users.size() > 0) {
			json.put("status", status);
			json.put("error", "该用户已存在！");
			return json;
		}
		User u = new User();
		u.setEmail(email.trim());
		int p = new Random().nextInt(999999);
		u.setSecret(p + "");
		u.setPassword(MD5Tools.MD5(password1 + p));
		u.setStatus((byte) 0);
		u.setIsdel((byte) 0);
		u.setCreatetime((int) (System.currentTimeMillis() / 1000));
		u.setCheckuser(0);
		u.setUpdatetime(0);
		u.setUpdatetime(0);
		u.setChecktime(0);
		u.setCheckuser(0);
		int r = userMapper.insertSelective(u);
		if (r > 0) {
			status = 1;
			users = userMapper.selectByExample(ue);
			if (users.size() > 0) {				
				json.put("id", users.get(0).getId());
			}
		} else {
			json.put("error", "注册失败！");
		}
		json.put("status", status);
		return json;
	}

	public User show(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public JSONObject edit(int id, String name, String phone) {
		JSONObject json = new JSONObject();
		int status = 0;
		User u = new User();
		u.setId(id);
		u.setName(name.trim());
		u.setPhone(phone.trim());
		u.setUpdatetime((int) (System.currentTimeMillis() / 1000));
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "修改失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject edit(int id, int adminId, String name, String phone) {
		JSONObject json = new JSONObject();
		int status = 0;
		User u = new User();
		u.setId(id);
		u.setName(name.trim());
		u.setPhone(phone.trim());
		u.setUpdatetime((int) (System.currentTimeMillis() / 1000));
		u.setUpdateuser(adminId);
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "修改失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject editPass(int id, String password, String password1, String password2) {
		JSONObject json = new JSONObject();
		int status = 0;
		if (!password1.equals(password2)) {
			json.put("status", status);
			json.put("error", "两次密码输入不一致！");
			return json;
		}
		User user = userMapper.selectByPrimaryKey(id);
		if (!user.getPassword().equals(MD5Tools.MD5(password + user.getSecret()))) {
			json.put("status", status);
			json.put("error", "原密码输入不正确！");
			return json;
		}
		User u = new User();
		u.setId(id);
		int p = new Random().nextInt(999999);
		u.setPassword(MD5Tools.MD5(password1 + p));
		u.setSecret(p + "");
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "密码修改失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject editPass(int id, String password1, String password2) {
		JSONObject json = new JSONObject();
		int status = 0;
		if (!password1.equals(password2)) {
			json.put("status", status);
			json.put("error", "两次密码输入不一致！");
			return json;
		}
		User u = new User();
		u.setId(id);
		int p = new Random().nextInt(999999);
		u.setPassword(MD5Tools.MD5(password1 + p));
		u.setSecret(p + "");
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "密码修改失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject check(int id, int adminId, byte status) {
		JSONObject json = new JSONObject();
		int statu = 0;
		User u = new User();
		u.setId(id);
		u.setStatus(status);
		u.setChecktime((int) (System.currentTimeMillis() / 1000));
		u.setCheckuser(adminId);
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			statu = 1;
		} else {
			json.put("error", "审核失败！");
		}
		json.put("status", statu);
		return json;
	}

	public DataShowPage list(int pageNum, int pageSize, User u) {
		UserExample ue = new UserExample();
		ue.setOrderByClause("id desc");
		Criteria c = ue.createCriteria().andIsdelEqualTo((byte) 0);
		if (!u.getName().equals("")) {
			c.andNameLike("%" + u.getName() + "%");
		}
		if (!u.getPhone().equals("")) {
			c.andPhoneLike("%" + u.getPhone() + "%");
		}
		if (!u.getEmail().equals("")) {
			c.andEmailLike("%" + u.getEmail() + "%");
		}

		// 璁剧疆鍒嗛〉鐨勫弬鏁�
		PageHelper.startPage(pageNum, pageSize);
		// 鏌ヨ鏁版嵁
		List<User> list = userMapper.selectByExample(ue);
		// 鍒涘缓涓�涓繑鍥炲�煎璞�
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 鍙栬褰曟�绘潯鏁�
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public JSONObject add(String password1, String password2, String name, String phone, String email,
			int adminId) {
		JSONObject json = new JSONObject();
		int status = 0;
		if (!password1.equals(password2)) {
			json.put("status", status);
			json.put("error", "两次密码输入不一致！");
			return json;
		}
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email).andIsdelEqualTo((byte)0);
		List<User> users = userMapper.selectByExample(ue);
		if (users.size() > 0) {
			json.put("status", status);
			json.put("error", "该用户已存在！");
			return json;
		}
		User u = new User();
		int p = new Random().nextInt(999999);
		u.setPassword(MD5Tools.MD5(password1 + p));
		u.setSecret(p + "");
		u.setName(name.trim());
		u.setPhone(phone.trim());
		u.setEmail(email.trim());
		u.setStatus((byte) 0);
		u.setIsdel((byte) 0);
		u.setCreatetime((int) (System.currentTimeMillis() / 1000));
		u.setCheckuser(adminId);
		u.setUpdatetime(0);
		u.setUpdatetime(0);
		u.setChecktime(0);
		u.setCheckuser(0);
		int r = userMapper.insertSelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "添加失败！");
		}
		json.put("status", status);
		return json;

	}

	public JSONObject delete(int id) {
		JSONObject json = new JSONObject();
		int status = 0;
		User u = new User();
		u.setIsdel((byte) 1);
		u.setId(id);
		int r = userMapper.updateByPrimaryKeySelective(u);
		if (r > 0) {
			status = 1;
		} else {
			json.put("error", "删除失败！");
		}
		json.put("status", status);
		return json;
	}

	public JSONObject show(String email) {
		JSONObject json = new JSONObject();
		int status = 0;
		email = email.trim();
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email).andIsdelEqualTo((byte)0);
		List<User> users = userMapper.selectByExample(ue);
		if (users.size() > 0) {
			status = 1;
			json.put("name", users.get(0).getName());
			json.put("id", users.get(0).getId());
		} else {
			json.put("error", "用户名错误！");
		}

		json.put("status", status);
		return json;
	}

}
