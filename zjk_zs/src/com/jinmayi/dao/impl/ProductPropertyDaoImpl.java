package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.ProductPropertyDao;
import com.jinmayi.entity.Productproperty;

@Repository("productPropertyDao")
public class ProductPropertyDaoImpl extends BaseDAOImpl<Productproperty> implements ProductPropertyDao {

	@Override
	public List<Productproperty> getProductpropertiesByProductId(Integer id) {
		return find("from Productproperty where productid = ?", new Object[]{id});
	}

}
