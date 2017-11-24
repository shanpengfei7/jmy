package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.City;

public class CityDao extends BaseDao<City> {

	public List<City> getCitysByProvinceName(String name) {
		String sql = "select city_id cityId, city_name cityName from city where province_id = ?";
		return queryForList(sql, new ProvinceDao().getProvinceByName(name).getProvinceId());
	}
	
	public City getCitysById(Integer id) {
		String sql = "select city_id cityId, city_name cityName from city where city_id = ?";
		return query(sql, id);
	}
	
	public City getCitysByName(String name) {
		String sql = "select city_id cityId, city_name cityName from city where city_name = ?";
		return query(sql, name);
	}
	
}
