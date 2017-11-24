package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.EvaluateDao;
import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Product;
import com.jinmayi.service.EvaluateService;

@Service("evaluateService")
public class EvaluateServiceImpl implements EvaluateService {

	@Resource
	private EvaluateDao evaluateDao;

	@Override
	public Integer save(Evaluate e) {
		return (Integer) evaluateDao.save(e);
	}

	@Override
	public List<Evaluate> getEvaluatesByProductId(Integer productid) {
		String hql = " from Evaluate where productid = ? order by id desc";
		return evaluateDao.find(hql, new Object[] { productid });
	}

	@Override
	public List<Evaluate> getEvaluatesByProducts(List<Product> products) {
		return evaluateDao.getEvaluatesByProducts(products);
	}

	@Override
	public List<Evaluate> getEvaluatesByProductId(Integer productid,
			Integer pageNow, Integer pageSize) {
		String hql = " from Evaluate where productid = ? order by id desc";
		return evaluateDao.find(hql, new Object[] { productid }, pageNow,
				pageSize);
	}

	@Override
	public Integer getEvaluateCountByProductId(Integer productid) {
		String hql = " from Evaluate where productid = ?";
		return evaluateDao.find(hql, new Object[] { productid }).size();
	}

}
