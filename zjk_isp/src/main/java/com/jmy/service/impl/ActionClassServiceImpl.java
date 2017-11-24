package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.ActionclassMapper;
import com.jmy.entity.Actionclass;
import com.jmy.entity.ActionclassExample;
import com.jmy.service.ActionClassService;
import com.jmy.util.DataShowPage;

@Service("actionClassService")
public class ActionClassServiceImpl implements ActionClassService {

	@Resource
	private ActionclassMapper actionclassMapper;
	
	public int save(Actionclass actionclass) {
		actionclass.setIsdel((byte)0);
		actionclass.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(actionclass.getCreateUser() == null) {
			actionclass.setCreateUser(0);
		}
		int count = actionclassMapper.countByExample(null);
		actionclass.setSort(count + 1);
		return actionclassMapper.insertSelective(actionclass);
	}

	public int edit(Actionclass actionclass) {
		actionclass.setUpdateTime((int)(System.currentTimeMillis() / 1000));
		if(actionclass.getUpdateUser() == null) {
			actionclass.setUpdateUser(0);
		}
		return actionclassMapper.updateByPrimaryKeySelective(actionclass);
	}

	public int delete(int id) {
		Actionclass actionclass = new Actionclass();
		actionclass.setId(id);
		actionclass.setIsdel((byte)1);
		return actionclassMapper.updateByPrimaryKeySelective(actionclass);
	}

	public DataShowPage getActionclasses(int pageNum,int pageSize) {
		ActionclassExample a = new ActionclassExample();
		a.createCriteria().andIsdelEqualTo((byte)0);
		a.setOrderByClause("sort asc");
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Actionclass> list=actionclassMapper.selectByExample(a);  
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

	public Actionclass getActionclassById(int id) {
		return actionclassMapper.selectByPrimaryKey(id);
	}

	public int sort(Actionclass actionclass) {
		// TODO Auto-generated method stub
		return 0;
	}

}
