package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Repertory;

public interface RepertoryDao extends BaseDAO<Repertory> {

	public List<Repertory> getRepertories(Integer enterpriseid);
}
