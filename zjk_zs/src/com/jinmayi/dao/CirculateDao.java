package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Circulate;

public interface CirculateDao extends BaseDAO<Circulate> {

	public List<Circulate> getCirculatesByWaybillId(Integer[] ids, Integer id);
}
