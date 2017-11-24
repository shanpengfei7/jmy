package com.jmy.controller;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Actionpackage;
import com.jmy.entity.Faceapplay;
import com.jmy.entity.Faceinfo;
import com.jmy.entity.User;
import com.jmy.service.ActionPackageService;
import com.jmy.service.AdminService;
import com.jmy.service.FaceApplayService;
import com.jmy.service.UserService;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/faceapplay")
public class FaceApplayController {
	@Resource
	private FaceApplayService faceApplayService;
	@Resource
	private ActionPackageService actionPackageService;
	@Resource
	private UserService userService;
	@Resource
	AdminService adminService;

	@RequestMapping("/show")
	public String show(Map<String, Object> map, int id) {
		Faceapplay f = faceApplayService.getFaceapplayById(id);
		User u = userService.getUserById(f.getUserId());
		Actionpackage ap = actionPackageService.getActionpackageById(f.getTaoId());
		map.put("price", ap.getMoney());
		map.put("user", u.getName());
		map.put("tao", ap.getName());
		map.put("years", f.getYears());
		map.put("money", f.getMoney());
		map.put("status", f.getStatus());
		map.put("message", f.getMessage());
		return "faceapplay/show";
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, HttpSession session) {
		Object obj = session.getAttribute("userId");
		int id = 0;
		if (obj != null) {
			id = Integer.parseInt(obj.toString());
		}
		map.put("data", faceApplayService.getFaceapplays(id, page, rows));
		return "faceapplay/list";
	}

	@RequestMapping("/packagelist")
	public String packagelist(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		map.put("data", actionPackageService.getActionpackages(page, rows));
		return "faceapplay/packagelist";
	}

	/**
	 * 企业用户申请
	 * 
	 * @param map
	 * @param session
	 * @param tid
	 * @param years
	 * @param message
	 * @return
	 */
	@RequestMapping("/applay")
	public void applay(HttpServletResponse response, HttpSession session, int tid, int years, String message) {
		if ("".equals(years)) {
			// 失败
			JsonOutput.out(response, "您未填几年，申请失败，请重新申请！");
		}

		Object obj = session.getAttribute("userId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		} else {
			// 失败
			JsonOutput.out(response, "申请失败，由于您长时间未操作系统，请重新登录入再申请套餐！");
		}
		Actionpackage a = actionPackageService.getActionpackageById(tid);
		Faceapplay f = new Faceapplay();
		f.setUserId(uid);
		f.setTaoId(tid);
		f.setYears(years);
		f.setMoney(a.getMoney() * years);
		f.setMessage(message);
		int result = faceApplayService.applay(f);
		if (result == 0) {
			JsonOutput.out(response, "添加失败！");
		} else {
			JsonOutput.out(response, "添加成功！");
		}
	}

	// ===================================================================================================
	@RequestMapping("/adshow")
	public String adshow(Map<String, Object> map, int id, String o) {
		Faceapplay f = faceApplayService.getFaceapplayById(id);
		User u = userService.getUserById(f.getUserId());
		Actionpackage ap = actionPackageService.getActionpackageById(f.getTaoId());
		map.put("user", u.getName());
		map.put("tao", ap.getName());
		map.put("price", ap.getMoney());
		map.put("id", f.getId());
		map.put("years", f.getYears());
		map.put("money", f.getMoney());
		map.put("status", f.getStatus());
		map.put("message", f.getMessage());
		if ("x".equals(o)) {
			// 修改页面
			return "faceapplay/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "faceapplay/adshow";
		}
		return "";
	}

	@RequestMapping("/adlist")
	public String adlist(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows,
			@RequestParam(defaultValue = "") String user,
			@RequestParam(defaultValue = "") String tao,
			@RequestParam(defaultValue = "3") byte status) {
		map.put("data", faceApplayService.getFaceapplays(page, rows, user, tao, status));
		map.put("user", user);
		map.put("tao", tao);
		map.put("status", status);
		return "faceapplay/adlist";
	}

	/**
	 * 管理员更改
	 * 
	 * @param map
	 * @param session
	 * @param tid
	 * @param years
	 * @param message
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit")
	public void edit(HttpServletResponse response, HttpSession session, int money, int years, String message, int id) {
		if ("".equals(years)) {
			// 失败
			JsonOutput.out(response, "您未填几年，申请失败，请重新申请！");
		} else if ("".equals(money)) {
			// 失败
			JsonOutput.out(response, "您未填价格，申请失败，请重新申请！");
		}
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		} else {
			// 失败
			JsonOutput.out(response, "修改失败，由于您长时间未操作系统，请重新登录入再修改套餐！");
		}
		Faceapplay f = new Faceapplay();
		f.setId(id);
		f.setYears(years);
		f.setMoney(money);
		f.setUpdateUser(uid);
		f.setMessage(message);
		int result = faceApplayService.edit(f);
		if (result == 0) {
			JsonOutput.out(response, "修改失败！");
		} else {
			JsonOutput.out(response, "修改成功！");
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
	public void check(HttpServletResponse response, HttpSession session, int id) {
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		if (uid > 0) {
			Faceapplay a = new Faceapplay();
			Faceinfo i = new Faceinfo();
			a.setId(id);
			a.setCheckUser(uid);
			// token message
			i.setToken(UUID.randomUUID().toString().replace("-", ""));
			i.setMessage("");

			if (faceApplayService.check(a, i) == 0) {
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
			Faceapplay f = new Faceapplay();
			f.setId(id);
			if (faceApplayService.uncheck(f) == 0) {
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

}
