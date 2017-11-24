package com.jinmayi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jinmayi.dao.CirculateDao;
import com.jinmayi.entity.Circulate;

@Repository("circulateDao")
public class CirculateDaoImpl extends BaseDAOImpl<Circulate> implements CirculateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Circulate> getCirculatesByWaybillId(Integer[] ids, Integer id) {
		String hql = " from Circulate where isdelete = 0 and waybillid = :id and qrcodeid in (:ids)";
		Query q = getSessionFactory().getCurrentSession().createQuery(hql);
		q.setParameter("id", id).setParameterList("ids", ids);
		return q.list();
	}
}
