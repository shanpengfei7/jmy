package com.jmy.service;

import com.jmy.entity.Actionpackage;
import com.jmy.entity.ActionpackageWithBLOBs;
import com.jmy.util.DataShowPage;

public interface ActionPackageService {

	public int save(ActionpackageWithBLOBs actionpackage);
	
	public int delete(int id);
	
	public int edit(ActionpackageWithBLOBs actionpackage);
	
	public DataShowPage getActionpackages(int pageNum,int pageSize);
	
	public ActionpackageWithBLOBs getActionpackageById(int id);
	
	public int sort(Actionpackage actionpackage);
}
