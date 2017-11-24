package com.jmy.tool.imported;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmy.service.EnterpriseService;
import com.jmy.service.SwjgService;
import com.jmy.util.ExcelUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml" })
public class EnterpriseImport {

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private SwjgService swjgService;

	@Test
	public void test() {

		File f = new File("d:\\enterprise.xls");
		List<ArrayList<Object>> lists = ExcelUtil.readExcel(f);
		for (int i = 1; i < lists.size(); i++) {
			enterpriseService.add(lists.get(i).get(1)+"", "123456", "123456", "", lists.get(i).get(2)+"", lists.get(i).get(3)+"", 1);
		}
	}

}
