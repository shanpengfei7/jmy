package com.jmy.service.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmy.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml" })
public class AdminServiceImplTest {

	@Resource
	private AdminService adminService;

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNotices() {
		fail("Not yet implemented");
	}

	@Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		//adminService.add("18131372240", "123456", "单鹏飞", "000", 0, (byte)0);
		//System.out.println(123);
		//fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testPassIntStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testPassIntStringString() {
		fail("Not yet implemented");
	}

}
