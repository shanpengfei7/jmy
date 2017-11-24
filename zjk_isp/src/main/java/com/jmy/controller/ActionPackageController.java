package com.jmy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.domain.ActionClassDoMain;
import com.jmy.domain.ActionDoMain;
import com.jmy.entity.Action;
import com.jmy.entity.Actionclass;
import com.jmy.entity.ActionpackageWithBLOBs;
import com.jmy.service.ActionClassService;
import com.jmy.service.ActionPackageService;
import com.jmy.service.ActionService;
import com.jmy.service.AdminService;
import com.jmy.util.DataShowPage;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/package")
public class ActionPackageController {
	@Resource
	private ActionPackageService actionPackageService;
	@Resource
	private AdminService adminService;
	@Resource
	private ActionClassService actionClassService;
	@Resource
	private ActionService actionService;

	@RequestMapping("/list")
	public String list(Map<String, Object> map, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "12") Integer rows) {
		map.put("data", actionPackageService.getActionpackages(page, rows));
		return "package/list";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/iadd")
	public String iadd(Map<String, Object> map) {
		DataShowPage d = actionClassService.getActionclasses(1, 10000);
		List<ActionClassDoMain> lists = new ArrayList<ActionClassDoMain>();
		for (Object o : d.getRows()) {
			// 把接口分类转成具体对象
			Actionclass ac = (Actionclass) o;
			ActionClassDoMain a = new ActionClassDoMain();
			a.setName(ac.getName());
			// 根据接口分类拿到接口的集合
			DataShowPage dataShowPage = actionService.getActionByActionClassId(ac.getId(), 0, 10000);
			a.setActions((List<ActionDoMain>) dataShowPage.getRows());
			lists.add(a);
		}
		map.put("data", lists);
		return "package/add";
	}

	@RequestMapping("/add")
	public void add(HttpServletResponse response, HttpSession session, String name, String remark, int money,
			String actions) {
		if ("".equals(name)) {
			JsonOutput.out(response, "添加失败，套餐名称为空！");
			return;
		} else if ("".equals(money)) {
			JsonOutput.out(response, "添加失败，价格为空！");
			return;
		} else if ("".equals(actions)) {
			JsonOutput.out(response, "添加失败，action为空！");
			return;
		}
		ActionpackageWithBLOBs a = new ActionpackageWithBLOBs();
		a.setName(name);
		a.setRemark(remark);
		a.setMoney(money);
		a.setActions(actions);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setCreateUser(uid);
		int result = actionPackageService.save(a);
		if (result == 0) {
			JsonOutput.out(response, "添加失败！");
			return;
		} else {
			JsonOutput.out(response, "添加成功！");
			return;
		}
	}

	@RequestMapping("/edit")
	public void edit(HttpServletResponse response, HttpSession session, String name, String remark, int sort, int money,
			String actions, int id) {
		if ("".equals(name)) {
			JsonOutput.out(response, "修改失败，套餐名称为空！");
			return;
		} else if ("".equals(money)) {
			JsonOutput.out(response, "修改失败，价格为空！");
			return;
		} else if ("".equals(actions)) {
			JsonOutput.out(response, "修改失败，action为空！");
			return;
		}
		ActionpackageWithBLOBs a = new ActionpackageWithBLOBs();
		a.setName(name);
		a.setRemark(remark);
		a.setSort(sort);
		a.setMoney(money);
		a.setActions(actions);
		Object obj = session.getAttribute("adminId");
		int uid = 0;
		if (obj != null) {
			uid = Integer.parseInt(obj.toString());
		}
		a.setUpdateUser(uid);
		a.setId(id);

		int result = actionPackageService.edit(a);
		if (result == 0) {
			JsonOutput.out(response, "修改失败！");
			return;
		} else {
			JsonOutput.out(response, "修改成功！");
			return;
		}
	}

	@RequestMapping("/del")
	public void del(HttpServletResponse response, int id, HttpSession session) {
		if (actionPackageService.delete(id) == 0) {
			// 删除失败
			JsonOutput.out(response, "删除失败！");
			return;
		} else {
			// 删除成功
			JsonOutput.out(response, "删除成功！");
			return;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/info")
	public String info(Map<String, Object> map, String o, int id) {
		ActionpackageWithBLOBs a = actionPackageService.getActionpackageById(id);
		map.put("id", a.getId());
		map.put("name", a.getName());
		map.put("remark", a.getRemark());
		map.put("sort", a.getSort());
		map.put("money", a.getMoney());
		map.put("actions", a.getActions());
		String[] actions = a.getActions().split(",");

		DataShowPage d = actionClassService.getActionclasses(1, 10000);
		List<ActionClassDoMain> lists = new ArrayList<ActionClassDoMain>();
		for (Object obj : d.getRows()) {
			// 把接口分类转成具体对象
			Actionclass ac = (Actionclass) obj;
			ActionClassDoMain acdm = new ActionClassDoMain();
			acdm.setName(ac.getName());
			// 根据接口分类拿到接口的集合
			DataShowPage dataShowPage = actionService.getActionByActionClassId(ac.getId(), 0, 10000);
			List<ActionDoMain> ad = new ArrayList<ActionDoMain>();
			for (Action act : (List<Action>) dataShowPage.getRows()) {
				ActionDoMain adm = new ActionDoMain();
				// 选中的接口依然选中
				for (String acti : actions) {
					if (acti.trim().equals(act.getActionName().trim())) {
						adm.setSelect(true);
						break;
					} else {
						adm.setSelect(false);
					}

				}
				adm.setActionName(act.getActionName());
				adm.setName(act.getName());
				ad.add(adm);
			}
			acdm.setActions(ad);
			lists.add(acdm);
		}
		map.put("data", lists);
		if ("x".equals(o)) {
			// 修改页面
			return "package/edit";
		} else if ("c".equals(o)) {
			// 查看页面
			return "package/show";
		}
		return "";
	}
}
