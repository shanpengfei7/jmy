package com.jmy.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Actionpackage;
import com.jmy.entity.Faceext;
import com.jmy.entity.Faceinfo;
import com.jmy.entity.User;
import com.jmy.service.ActionPackageService;
import com.jmy.service.AdminService;
import com.jmy.service.FaceExtService;
import com.jmy.service.FaceInfoService;
import com.jmy.service.UserService;
import com.jmy.util.JsonOutput;
import com.jmy.util.TimeFormats;

@Controller
@RequestMapping("/faceinfo")
public class FaceInfoController {
	@Resource
	private FaceInfoService faceInfoService;
	@Resource
	private ActionPackageService actionPackageService;
	@Resource
	private UserService userService;
	@Resource
	AdminService adminService;
	@Resource
	private FaceExtService faceExtService;

	@RequestMapping("/show")
	public String show(Map<String, Object> map, int id) {
		Faceinfo f = faceInfoService.getFaceinfoById(id);
		User u = userService.getUserById(f.getUserId());
		Actionpackage ap = actionPackageService.getActionpackageById(f.getTaoId());
		map.put("user", u.getName());
		map.put("tao", ap.getName());
		map.put("years", f.getYears());
		map.put("money", f.getMoney());
		map.put("token", f.getToken());
		map.put("status", f.getStatus());
		map.put("message", f.getMessage());
		return "faceinfo/show";
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, HttpSession session) {
		Object obj = session.getAttribute("userId");
		int id = 0;
		if (obj != null) {
			id = Integer.parseInt(obj.toString());
		}
		map.put("data", faceInfoService.getFaceinfos(id, page, rows));
		return "faceinfo/list";
	}

	// ===================================================================================================
	@RequestMapping("/adshow")
	public String adshow(Map<String, Object> map, int id) {
		Faceinfo f = faceInfoService.getFaceinfoById(id);
		User u = userService.getUserById(f.getUserId());
		Actionpackage ap = actionPackageService.getActionpackageById(f.getTaoId());
		map.put("user", u.getName());
		map.put("tao", ap.getName());
		map.put("years", f.getYears());
		map.put("money", f.getMoney());
		map.put("token", f.getToken());
		map.put("status", f.getStatus());
		map.put("message", f.getMessage());
		return "faceinfo/adshow";
	}

	@RequestMapping("/adlist")
	public String adlist(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows, @RequestParam(defaultValue = "") String user,
			@RequestParam(defaultValue = "") String tao, @RequestParam(defaultValue = "3") byte status) {
		map.put("data", faceInfoService.getFaceinfos(page, rows, user, tao, status));
		map.put("user", user);
		map.put("tao", tao);
		map.put("status", status);
		return "faceinfo/adlist";
	}

	@RequestMapping("/check")
	public void check(HttpServletResponse response, HttpSession session, int id) {
		Faceinfo f = new Faceinfo();
		f.setId(id);
		f.setStatus((byte) 1);
		int result = faceInfoService.unCheck(f);

		if (result > 0) {
			// 成功
			JsonOutput.out(response, "审核成功");
			return;
		} else {
			// 失败
			JsonOutput.out(response, "审核成功");
			return;
		}
	}

	@RequestMapping("/uncheck")
	public void uncheck(HttpServletResponse response, HttpSession session, int id) {
		Faceinfo f = new Faceinfo();
		f.setId(id);
		f.setStatus((byte) 0);
		int result = faceInfoService.unCheck(f);

		if (result > 0) {
			// 成功
			JsonOutput.out(response, "审核成功");
			return;
		} else {
			// 失败
			JsonOutput.out(response, "审核成功");
			return;
		}
	}

	@RequestMapping("/iext")
	public String iext(Map<String, Object> map, int fid) {
		Faceinfo f = faceInfoService.getFaceinfoById(fid);
		Actionpackage ap = actionPackageService.getActionpackageById(f.getTaoId());
		map.put("price", ap.getMoney());
		map.put("fid", fid);
		if (f.getLastTime() != null) {
			map.put("last", TimeFormats.changeTime(f.getLastTime()));
		}
		return "faceinfo/ext";
	}

	@RequestMapping("/ext")
	public void ext(HttpServletResponse response, HttpSession session, int fid, int addyear, int money,
			String message) {
		if ("".equals(addyear)) {
			JsonOutput.out(response, "续费失败，年为空！");
			return;
		} else if ("".equals(money)) {
			JsonOutput.out(response, "续费失败，价格为空！");
			return;
		}

		Faceext f = new Faceext();
		f.setFid(fid);
		f.setAddyear(addyear);
		Faceinfo fi = faceInfoService.getFaceinfoById(fid);
		f.setOldTime(fi.getLastTime());

		Calendar calendar = Calendar.getInstance();
		long dt = (long) (1000.0 * fi.getLastTime());
		Date date = new Date(dt);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +addyear);
		long longTime = calendar.getTimeInMillis();
		System.out.println(longTime);
		int intTime = (int) (longTime / 1000);

		f.setNewTime(intTime);
		f.setMoney(money);

		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		f.setCreateUser(uid);
		f.setMessage(message);
		int result = faceExtService.save(f);
		if (result > 0) {
			JsonOutput.out(response, "续费成功！");
			return;

		} else {
			JsonOutput.out(response, "续费失败！");
			return;
		}
	}

	@RequestMapping("/extlist")
	public String extlist(Map<String, Object> map, int fid, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		map.put("data", faceExtService.getFaceExts(fid, page, rows));
		return "faceinfo/extlist";
	}

	@RequestMapping("/extshow")
	public String extshow(Map<String, Object> map, int id) {
		Faceext f = faceExtService.getFaceext(id);
		map.put("addyear", f.getAddyear());
		if (f.getOldTime() != null) {
			map.put("oldTime", TimeFormats.changeTime(f.getOldTime()));
		}
		if (f.getNewTime() != null) {
			map.put("newTime", TimeFormats.changeTime(f.getNewTime()));
		}
		map.put("money", f.getMoney());
		map.put("message", f.getMessage());
		return "faceinfo/extshow";
	}
}
