package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Productproperty;

public interface ProductPropertyDao extends BaseDAO<Productproperty> {

	public List<Productproperty> getProductpropertiesByProductId(Integer id);
}
