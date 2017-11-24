package com.jmy.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Admin;
import com.jmy.entity.User;
import com.jmy.service.AdminService;
import com.jmy.service.UserService;
import com.jmy.util.JsonOutput;
import com.jmy.util.VerifyCodeUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private UserService userService;
	@Resource
	private AdminService adminService;

	/**
	 * 把验证码传到前台
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verify")
	public void verify(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 220, h = 40;
		try {
			VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登陆
	 * 
	 * @param verify
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletResponse response, String username, String password, String verify,
			HttpSession session) {
		// 获取服务器中的验证码
		String random = session.getAttribute("verCode").toString();
		if ("".equals(verify)) {
			JsonOutput.out(response, "请输入验证码！");
			return;
		} else if ("".equals(verify.trim())) {
			JsonOutput.out(response, "请输入验证码！");
			return;
		} else if (!random.equalsIgnoreCase(verify.trim())) {
			JsonOutput.out(response, "验证码不正确！");
			return;
		} else if ("".equals(username)) {
			JsonOutput.out(response, "请输入用户名！");
			return;
		} else if ("".equals(username.trim())) {
			JsonOutput.out(response, "请输入用户名！");
			return;
		} else if ("".equals(password)) {
			JsonOutput.out(response, "请输入密码!");
			return;
		} else {
			Admin admin = adminService.login(username.trim(), password.trim());
			if (admin == null) {
				JsonOutput.out(response, "登录失败，用户名或密码错误！");
				return;
			} else {
				session.setAttribute("adminId", admin.getId());
				JsonOutput.out(response, "1");
				return;
			}
		}
	}

	/**
	 * 审核通过
	 * 
	 * @param map
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void check(HttpServletResponse response, int id, HttpSession session) {
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		if (uid > 0) {
			if (userService.check(id, (byte) 1, uid) == 0) {
				// 审核失败
				JsonOutput.out(response, "审核失败！");
			} else {
				// 审核成功
				JsonOutput.out(response, "审核成功！");
			}
		} else {
			JsonOutput.out(response, "审核失败！");
		}
	}

	/**
	 * 审核拒绝
	 * 
	 * @param map
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/uncheck", method = RequestMethod.GET)
	public void uncheck(HttpServletResponse response, int id, HttpSession session) {
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		if (uid > 0) {
			if (userService.check(id, (byte) 2, uid) == 0) {
				// 审核失败
				JsonOutput.out(response, "审核失败！");
			} else {
				// 审核成功
				JsonOutput.out(response, "审核成功！");
			}
		} else {
			JsonOutput.out(response, "审核失败！");

		}
	}

	/**
	 * 用户删除
	 * 
	 * @param map
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public void del(HttpServletResponse response, int id) {
		if (userService.delete(id) == 0) {
			// 删除失败
			JsonOutput.out(response, "删除失败！");
		} else {
			// 删除成功
			JsonOutput.out(response, "删除成功！");
		}
	}

	/**
	 * 查看修改用户资料，得到资料信息
	 * 
	 * @param map
	 * @param o
	 * @param id
	 *            用户id
	 * @return
	 */
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info(Map<String, Object> map, String o, int id) {
		if (id > 0) {
			User u = userService.getUserById(id);
			// map.put("user", u);
			map.put("id", u.getId());
			map.put("username", u.getUsername());
			map.put("email", u.getEmail());
			map.put("phone", u.getPhone());
			map.put("name", u.getName());
			map.put("status", u.getStatus());
			map.put("address", u.getAddress());
			map.put("pic", u.getPic());
		}
		if ("x".equals(o)) {
			// 修改页面
			return "admin/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "admin/show";
		}
		return "";
	}

	/**
	 * 资料修改
	 * 
	 * @param map
	 * @param file
	 * @param session
	 * @param name
	 * @param email
	 * @param phone
	 * @param address
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(HttpServletResponse response, String picName, HttpSession session, String name, String email,
			String phone, String address, int id) {
		if ("".equals(name)) {
			JsonOutput.out(response, "名称为空，请输入名称！");
			return;
		} else if ("".equals(email)) {
			JsonOutput.out(response, "电子邮件为空，请输入电子邮件！");
			return;
		} else if ("".equals(phone)) {
			JsonOutput.out(response, "电话为空，请输入电话！");
			return;
		} else if ("".equals(address)) {
			JsonOutput.out(response, "地址为空，请输入地址！");
			return;
		} else if ("".equals(name.trim())) {
			JsonOutput.out(response, "名称为空，请输入名称！");
			return;
		} else if ("".equals(email.trim())) {
			JsonOutput.out(response, "电子邮件为空，请输入电子邮件！");
			return;
		} else if ("".equals(phone.trim())) {
			JsonOutput.out(response, "电话为空，请输入电话！");
			return;
		} else if ("".equals(address.trim())) {
			JsonOutput.out(response, "地址为空，请输入地址！");
			return;
		} else {
			User u = new User();
			u.setName(name.trim());
			u.setPhone(phone.trim());
			u.setEmail(email.trim());
			u.setAddress(address.trim());
			u.setPic(picName);
			u.setId(id);
			Object obj = session.getAttribute("adminId");
			int uid = 0;
			if (obj != null) {
				uid = Integer.parseInt(obj.toString());
			}
			u.setUpdateUser(uid);
			int result = userService.edit(u);
			if (result == 0) {
				JsonOutput.out(response, "修改失败！");
				return;
			} else {
				JsonOutput.out(response, "修改成功！");
				return;
			}
		}
	}

	@RequestMapping(value = "/username", method = RequestMethod.POST)
	public void username(HttpServletResponse response, HttpSession session, String username, int uid) {
		if ("".equals(username)) {
			// 修改失败
			JsonOutput.out(response, "修改失败，该用户名为空！");
			return;
		} else if ("".equals(username.trim())) {
			// 修改失败
			JsonOutput.out(response, "修改失败，该用户名为空！");
			return;
		} else if (userService.hasUsername(username.trim())) {
			// 修改失败
			JsonOutput.out(response, "修改失败，该用户名已存在！");
			return;
		} else {
			// 修改成功
			Object obj = session.getAttribute("adminId");
			int id = 0;
			int result = 0;
			if (obj != null) {
				id = Integer.parseInt(obj.toString());
			}
			if (id > 0) {
				User u = new User();
				u.setId(uid);
				u.setUpdateUser(id);
				u.setUsername(username);
				result = userService.editUsername(u);
			}
			if (result > 0) {
				// 修改成功
				JsonOutput.out(response, "修改成功！");
				return;
			} else {
				// 修改失败
				JsonOutput.out(response, "修改失败,帐号已存在！");
				return;
			}
		}
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public void password(HttpServletResponse response, HttpSession session, String password1, String password2,
			int uid) {
		if ("".equals(password1)) {
			// 修改失败
			JsonOutput.out(response, "修改失败，密码为空！");
			return;
		} else if ("".equals(password2)) {
			// 修改失败
			JsonOutput.out(response, "修改失败，确认密码为空！");
			return;

		} else if (!password1.equals(password2)) {
			// 修改失败
			JsonOutput.out(response, "修改失败，两次密码输入不一致！");
			return;
		} else {
			// 修改成功
			Object obj = session.getAttribute("adminId");
			int id = 0;
			int result = 0;
			if (obj != null) {
				id = Integer.parseInt(obj.toString());
			}
			if (id > 0) {
				User u = new User();
				u.setId(uid);
				u.setUpdateUser(id);
				u.setPassword(password1);
				result = userService.editPasswd(u);
			}
			if (result > 0) {
				// 修改成功
				JsonOutput.out(response, "修改成功！");
				return;
			} else {
				// 修改失败
				JsonOutput.out(response, "修改失败！");
				return;
			}
		}
	}

	/**
	 * 企业用户添加
	 * 
	 * @param map
	 * @param username
	 * @param password1
	 * @param password2
	 * @param verify
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, String username, String password1, String password2, String verify,
			HttpSession session, String name, String picName, String email, String phone, String address) {
		// 获取服务器中的验证码
		String random = session.getAttribute("verCode").toString();
		if ("".equals(verify)) {
			JsonOutput.out(response, "验证码为空，请输入验证码！");
			return;
		} else if ("".equals(username)) {
			JsonOutput.out(response, "用户名为空，请输入用户名！");
			return;
		} else if ("".equals(password1)) {
			JsonOutput.out(response, "密码为空，请输入密码！");
			return;
		} else if ("".equals(password2)) {
			JsonOutput.out(response, "确认密码为空，请输入确认密码！");
			return;
		} else if ("".equals(name)) {
			JsonOutput.out(response, "名称为空，请输入名称！");
			return;
		} else if ("".equals(email)) {
			JsonOutput.out(response, "邮箱地址为空，请输入电子邮件！");
			return;
		} else if ("".equals(phone)) {
			JsonOutput.out(response, "电话为空，请输入电话号！");
			return;
		} else if ("".equals(address)) {
			JsonOutput.out(response, "地址为空，请输入地址！");
			return;
		} else if ("".equals(verify.trim())) {
			JsonOutput.out(response, "验证码为空，请输入验证码！");
			return;
		} else if (!random.equalsIgnoreCase(verify.trim())) {
			JsonOutput.out(response, "验证码不正确！");
			return;
		} else if ("".equals(password1)) {
			JsonOutput.out(response, "密码为空，请输入密码!");
			return;
		} else if ("".equals(password2)) {
			JsonOutput.out(response, "确认密码为空，请输入确认密码！");
			return;
		} else if (!password1.trim().endsWith(password2)) {
			JsonOutput.out(response, "两次密码输入不一致");
			return;
		} else if ("".equals(username.trim())) {
			JsonOutput.out(response, "用户名为空，请输入用户名！");
			return;
		} else if ("".equals(name.trim())) {
			JsonOutput.out(response, "名称为空，请输入名称！");
			return;
		} else if ("".equals(email.trim())) {
			JsonOutput.out(response, "邮箱地址为空，请输入电子邮件！");
			return;
		} else if ("".equals(phone.trim())) {
			JsonOutput.out(response, "电话为空，请输入电话！");
			return;
		} else if ("".equals(address.trim())) {
			JsonOutput.out(response, "地址为空，请输入地址！");
			return;
		} else {
			User u = new User();
			u.setUsername(username.trim());
			u.setPassword(password1);

			u.setName(name.trim());
			u.setPhone(phone.trim());
			u.setEmail(email.trim());
			u.setAddress(address.trim());
			u.setPic(picName);
			Object obj = session.getAttribute("adminId");
			int uid = 0;
			if (obj != null) {
				uid = Integer.parseInt(obj.toString());
			}
			u.setUpdateUser(uid);

			if (userService.registe(u) == 0) {
				JsonOutput.out(response, "注册失败，用户名已存在！");
				return;
			} else {
				JsonOutput.out(response, "1");
				return;
			}
		}
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String address,
			@RequestParam(defaultValue = "3") byte status) {
		map.put("data", userService.getUsers(page, rows, name, username, phone, email, address, status));
		map.put("name", name);
		map.put("username", username);
		map.put("phone", phone);
		map.put("email", email);
		map.put("address", address);
		map.put("status", status);
		return "admin/list";
	}

	@RequestMapping("/leave")
	public String leave(HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
}
