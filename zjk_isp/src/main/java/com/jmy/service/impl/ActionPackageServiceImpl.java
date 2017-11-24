package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.ActionpackageMapper;
import com.jmy.entity.Actionpackage;
import com.jmy.entity.ActionpackageExample;
import com.jmy.entity.ActionpackageWithBLOBs;
import com.jmy.service.ActionPackageService;
import com.jmy.util.DataShowPage;

@Service("actionPackageService")
public class ActionPackageServiceImpl implements ActionPackageService {

	@Resource
	private ActionpackageMapper actionpackageMapper;
	
	public int save(ActionpackageWithBLOBs actionpackage) {
		actionpackage.setIsdel((byte)0);
		actionpackage.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(actionpackage.getCreateUser() == null) {
			actionpackage.setCreateUser(0);
		}
		int count = actionpackageMapper.countByExample(null);
		actionpackage.setSort(count + 1);
		return actionpackageMapper.insertSelective(actionpackage);
	}

	public int delete(int id) {
		ActionpackageWithBLOBs a = new ActionpackageWithBLOBs();
		a.setId(id);
		a.setIsdel((byte)1);
		return actionpackageMapper.updateByPrimaryKeySelective(a);
	}

	public int edit(ActionpackageWithBLOBs actionpackage) {
		actionpackage.setUpdateTime((int)(System.currentTimeMillis() / 1000));
		if(actionpackage.getUpdateUser() == null) {
			actionpackage.setUpdateUser(0);
		}
		return actionpackageMapper.updateByPrimaryKeySelective(actionpackage);
	}

	public DataShowPage getActionpackages(int pageNum,int pageSize) {
		ActionpackageExample a = new ActionpackageExample();
		a.createCriteria().andIsdelEqualTo((byte)0);
		a.setOrderByClause("sort asc");
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Actionpackage> list=actionpackageMapper.selectByExample(a);  
        //创建一个返回值对象  
        DataShowPage page=new DataShowPage();  
        page.setRows(list);  
        
        page.setNow(pageNum);
        page.setSize(pageSize);
        
        //取记录总条数  
        PageInfo pageInfo=new PageInfo(list);  
        page.setTotal(pageInfo.getTotal());  
          
        return page;  
	}

	public ActionpackageWithBLOBs getActionpackageById(int id) {
		return actionpackageMapper.selectByPrimaryKey(id);
	}

	public int sort(Actionpackage actionpackage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
