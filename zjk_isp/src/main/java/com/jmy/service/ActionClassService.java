package com.jmy.service;

import com.jmy.entity.Actionclass;
import com.jmy.util.DataShowPage;

public interface ActionClassService {

	/**
	 * 添加接口分类
	 * 
	 * @param actionclass
	 * @return
	 */
	public int save(Actionclass actionclass);

	/**
	 * 修改接口分类
	 * 
	 * @param actionclass
	 * @return
	 */
	public int edit(Actionclass actionclass);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id);

	public DataShowPage getActionclasses(int pageNum,int pageSize);

	public Actionclass getActionclassById(int id);

	/**
	 * 排序
	 * 
	 * @param actionclass
	 * @return
	 */
	public int sort(Actionclass actionclass);
}
