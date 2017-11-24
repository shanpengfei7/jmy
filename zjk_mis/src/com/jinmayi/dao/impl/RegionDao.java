package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.Region;

public class RegionDao extends BaseDao<Region> {

	public List<Region> getRegionsByCityName(String name) {
		String sql = "select region_id regionId, region_name regionName from region where city_id = ?";
		return queryForList(sql, new CityDao().getCitysByName(name).getCityId());
	}
	
	public Region getRegionByName(String name) {
		String sql = "select region_id regionId, region_name regionName from region where region_name = ?";
		return query(sql, name);
	}
	
	public Region getRegionById(Integer id) {
		String sql = "select region_id regionId, region_name regionName from region where region_id = ?";
		return query(sql, id);
	}
	
}
