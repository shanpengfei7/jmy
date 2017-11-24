package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.YaoWu;

public class YaoWuDao extends BaseDao<YaoWu> {

	public List<YaoWu> getGuiGesByName(String name){
		String sql = "select distinct guiGe from yao_wu where isdelete = ? and yaoming = ?";
		return queryForList(sql, false, name);
	}
	
	public List<YaoWu> getYongLiangsByName(String name){
		String sql = "select distinct yongLiang from yao_wu where isdelete = ? and yaoming = ?";
		return queryForList(sql, false, name);
	}
}
