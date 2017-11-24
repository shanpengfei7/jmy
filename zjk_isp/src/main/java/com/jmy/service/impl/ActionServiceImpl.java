package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.ActionMapper;
import com.jmy.entity.Action;
import com.jmy.entity.ActionExample;
import com.jmy.service.ActionService;
import com.jmy.util.DataShowPage;

@Service("actionService")
public class ActionServiceImpl implements ActionService {

	@Resource
	private ActionMapper actionMapper;
	
	public int save(Action action) {
		action.setIsdel((byte)0);
		action.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(action.getCreateUser() == null) {
			action.setCreateUser(0);
		}
		int count = actionMapper.countByExample(null);
		action.setSort(count + 1);
		return actionMapper.insertSelective(action);
	}

	public int delete(int id) {
		Action a = new Action();
		a.setId(id);
		a.setIsdel((byte)1);
		return actionMapper.updateByPrimaryKeySelective(a);
	}

	public int edit(Action action) {
		action.setUpdateTime((int)(System.currentTimeMillis() / 1000));
		if(action.getUpdateUser() == null) {
			action.setUpdateUser(0);
		}
		return actionMapper.updateByPrimaryKeySelective(action);
	}

	public DataShowPage getActionByActionClassId(int cid,int pageNum,int pageSize) {
		ActionExample a = new ActionExample();
		a.createCriteria().andIsdelEqualTo((byte)0).andCidEqualTo(cid);
		a.setOrderByClause("sort asc");
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Action> list=actionMapper.selectByExample(a);  
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

	public Action getActionById(int id) {
		return actionMapper.selectByPrimaryKey(id);
	}

	public int sort(Action action) {
		// TODO Auto-generated method stub
		return 0;
	}

}
