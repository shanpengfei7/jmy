package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Product;

public interface EvaluateDao extends BaseDAO<Evaluate> {

	public List<Evaluate> getEvaluatesByProducts(List<Product> products);
}
