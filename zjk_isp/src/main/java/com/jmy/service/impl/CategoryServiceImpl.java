package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.Coi_category_oneMapper;
import com.jmy.dao.Coi_category_threeMapper;
import com.jmy.dao.Coi_category_twoMapper;
import com.jmy.entity.Coi_category_one;
import com.jmy.entity.Coi_category_three;
import com.jmy.entity.Coi_category_threeExample;
import com.jmy.entity.Coi_category_two;
import com.jmy.entity.Coi_category_twoExample;
import com.jmy.service.CategoryService;
import com.jmy.util.DataShowPage;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private Coi_category_oneMapper oneMapper;
	@Resource
	private Coi_category_twoMapper twoMapper;
	@Resource
	private Coi_category_threeMapper threeMapper;

	public DataShowPage getOne(int pageNum, int pageSize) {
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<Coi_category_one> list = oneMapper.selectByExample(null);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public DataShowPage getTwo(int tid, int pageNum, int pageSize) {
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		Coi_category_twoExample c = new Coi_category_twoExample();
		c.createCriteria().andPidEqualTo(tid);
		List<Coi_category_two> list = twoMapper.selectByExample(c);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public DataShowPage getThree(int tid, int pageNum, int pageSize) {
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		Coi_category_threeExample c = new Coi_category_threeExample();
		c.createCriteria().andPidEqualTo(tid);
		List<Coi_category_three> list = threeMapper.selectByExample(c);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

}
