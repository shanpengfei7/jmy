package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Product;

public interface EvaluateService {

	public Integer save(Evaluate e);

	public List<Evaluate> getEvaluatesByProductId(Integer productid);

	public List<Evaluate> getEvaluatesByProducts(List<Product> products);

	public List<Evaluate> getEvaluatesByProductId(Integer productid,
			Integer pageNow, Integer pageSize);

	public Integer getEvaluateCountByProductId(Integer productid);
}
