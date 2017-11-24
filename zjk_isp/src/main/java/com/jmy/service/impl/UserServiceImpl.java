package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.UserMapper;
import com.jmy.entity.User;
import com.jmy.entity.UserExample;
import com.jmy.service.UserService;
import com.jmy.util.DataShowPage;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public boolean hasUsername(String username) {
		UserExample u = new UserExample();
		u.createCriteria().andUsernameEqualTo(username);
		if (userMapper.countByExample(u) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int registe(User user) {
		if (hasUsername(user.getUsername())) {
			return 0;
		} else {
			user.setStatus((byte) 0);
			user.setIsdel((byte) 0);
			user.setCreateTime((int) (System.currentTimeMillis() / 1000));
			if (user.getCreateUser() == null) {
				user.setCreateUser(0);
			}
			user.setUpdateTime((int) (System.currentTimeMillis() / 1000));
			if (user.getUpdateUser() == null) {
				user.setUpdateUser(0);
			}
			return userMapper.insertSelective(user);
		}
	}

	public int edit(User user) {
		user.setUpdateTime((int) (System.currentTimeMillis() / 1000));
		if (user.getUpdateUser() == null) {
			user.setUpdateUser(0);
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public int delete(int id) {
		User u = new User();
		u.setId(id);
		u.setIsdel((byte) 1);
		return userMapper.updateByPrimaryKeySelective(u);
	}

	public int check(int id, byte status, int checkUserId) {
		User u = new User();
		u.setId(id);
		u.setStatus(status);
		u.setCheckTime((int) (System.currentTimeMillis() / 1000));
		u.setCheckUser(checkUserId);
		return userMapper.updateByPrimaryKeySelective(u);
	}

	public User login(String username, String password) {
		UserExample u = new UserExample();
		u.createCriteria().andUsernameEqualTo(username);
		u.createCriteria().andPasswordEqualTo(password);
		u.createCriteria().andIsdelEqualTo((byte) 0);
		List<User> user = userMapper.selectByExample(u);
		if (user == null || user.size() == 0) {
			return null;
		} else {
			return user.get(0);
		}
	}

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int editPasswd(User user) {
		user.setUpdateTime((int) (System.currentTimeMillis() / 1000));
		if (user.getUpdateUser() != null) {
			user.setUpdateUser(0);
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public int editUsername(User user) {
		user.setUpdateTime((int) (System.currentTimeMillis() / 1000));
		if (user.getUpdateUser() != null) {
			user.setUpdateUser(0);
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public DataShowPage getUsers(int pageNum, int pageSize, String name, String username, String phone, String email,
			String address, byte status) {
		UserExample u = new UserExample();
		// u.createCriteria().andIsdelEqualTo((byte) 0).andNameLike(" %" +
		// name.trim() + "%")
		// .andUsernameLike(" %" + username.trim() + "%").andPhoneLike(" %" +
		// phone.trim() + "%")
		// .andEmailLike(" %" + email.trim() + "%").andAddressLike(" %" +
		// address.trim() + "%")
		// .andStatusEqualTo(status);
		com.jmy.entity.UserExample.Criteria c = u.createCriteria().andIsdelEqualTo((byte) 0);
		if (!"".equals(name) && !"".equals(name.trim())) {
			c.andNameLike("%" + name.trim() + "%");
		}
		if (!"".equals(username) && !"".equals(username.trim())) {
			c.andUsernameLike("%" + username.trim() + "%");
		}
		if (!"".equals(phone) && !"".equals(phone.trim())) {
			c.andPhoneLike("%" + phone.trim() + "%");
		}
		if (!"".equals(email) && !"".equals(email.trim())) {
			c.andEmailLike("%" + email.trim() + "%");
		}
		if (!"".equals(address) && !"".equals(address.trim())) {
			c.andAddressLike("%" + address.trim() + "%");
		}
		if (3 != status) {
			c.andStatusEqualTo(status);
		}
		u.setOrderByClause("id desc");
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<User> list = userMapper.selectByExample(u);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
		// return userMapper.selectByExample(null);
	}
}
