package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.RepertoryDao;
import com.jinmayi.entity.Repertory;

@Repository("repertoryDao")
public class RepertoryDaoImpl extends BaseDAOImpl<Repertory> implements RepertoryDao {

	@Override
	public List<Repertory> getRepertories(Integer enterpriseid) {
		String hql = " from Repertory where isdelete = 0 and enterpriseid = ?";
		return find(hql, new Object[]{enterpriseid});
	}

}
