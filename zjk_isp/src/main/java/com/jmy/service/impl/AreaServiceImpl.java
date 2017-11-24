package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.AreaMapper;
import com.jmy.entity.AreaExample;
import com.jmy.entity.AreaWithBLOBs;
import com.jmy.service.AreaService;
import com.jmy.util.DataShowPage;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Resource
	private AreaMapper areaMapper;

	public DataShowPage getArea(int pageNum, int pageSize) {
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		AreaExample a = new AreaExample();
		a.createCriteria().andPidEqualTo(0);
		// 查询数据
		List<AreaWithBLOBs> list = areaMapper.selectByExampleWithBLOBs(a);
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

	public DataShowPage getArea(int tid, int pageNum, int pageSize) {
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		AreaExample a = new AreaExample();
		a.createCriteria().andPidEqualTo(tid);
		// 查询数据
		List<AreaWithBLOBs> list = areaMapper.selectByExampleWithBLOBs(a);
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
