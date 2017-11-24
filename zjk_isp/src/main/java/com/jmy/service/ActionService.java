package com.jmy.service;

import com.jmy.entity.Action;
import com.jmy.util.DataShowPage;

public interface ActionService {

	public int save(Action action);
	
	public int delete(int id);
	
	public int edit(Action action);
	
	public DataShowPage getActionByActionClassId(int cid, int pageNum,int pageSize);
	
	public Action getActionById(int id);
	
	public int sort(Action action);
}
