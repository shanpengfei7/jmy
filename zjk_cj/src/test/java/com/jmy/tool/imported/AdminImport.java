package com.jmy.tool.imported;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmy.entity.Admi;
import com.jmy.entity.Swjg;
import com.jmy.service.AdminService;
import com.jmy.service.SwjgService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml" })
public class AdminImport {

	@Resource
	private AdminService adminService;
	@Resource
	private SwjgService swjgService;

	@Test
	public void admin() {

		//管理员
		adminService.add("18131372240", "123456", "123456", "单鹏飞", "000", 0, (byte) 0, 0);
		//市局
		adminService.add("", "123456", "123456", "张家口市地方税务局", "21307000000", 1, (byte) 1, 1);
		//县区局
		List<Swjg> swjgsss = swjgService.getSwjgsBySjswjg("21307000000");
		for (Swjg s : swjgsss) {

			adminService.add("", "123456", "123456", s.getSwjgmc(), s.getSwjgDm(), 2, (byte) 2, 1);
		}
		//分局
		List<Swjg> swjgss = swjgService.getSwjgsBySjswjg("21307000000");
		for (Swjg swjg : swjgss) {
			if (swjg != null) {
				List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
				Admi admin = adminService.getAdminBySwjgDm(swjg.getSwjgDm());
				for (Swjg s : swjgs) {
					if (s != null) {
						adminService.add("", "123456", "123456", s.getSwjgmc(), s.getSwjgDm(), admin.getId(), (byte) 3,
								1);
					}
				}
			}
		}
		System.out.println("ok");
	}

}
