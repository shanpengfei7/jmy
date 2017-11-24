package com.jinmayi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jinmayi.dao.EvaluateDao;
import com.jinmayi.entity.Evaluate;
import com.jinmayi.entity.Product;

@Repository("evaluateDao")
public class EvaluateDaoImpl extends BaseDAOImpl<Evaluate> implements
		EvaluateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluate> getEvaluatesByProducts(List<Product> products) {
		Integer[] ids = new Integer[products.size()];
		for (int i = 0; i < products.size(); i++) {
			ids[i] = products.get(i).getId();
		}
		
		String hql = " from Evaluate where productid in (:ids) order by id desc";
		Query q = getSessionFactory().getCurrentSession().createQuery(hql);
		q.setParameterList("ids", ids);
		return q.list();
	}

	
}
