package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.Province;

public class ProvinceDao extends BaseDao<Province> {

	public List<Province> getProvinces(){
		String sql = "select province_id provinceId, province_name provinceName from province";
		return queryForList(sql);
	}
	
	public Province getProvinceById(String id){
		String sql = "select province_id provinceId, province_name provinceName from province where province_id = ?";
		return query(sql, id);
	}
	
	public Province getProvinceByName(String name){
		String sql = "select province_id provinceId, province_name provinceName from province where province_name = ?";
		return query(sql, name);
	}
}
