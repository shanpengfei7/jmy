package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.ProductDao;
import com.jinmayi.dao.QrCodeDao;
import com.jinmayi.dao.RepertoryDao;
import com.jinmayi.entity.Repertory;
import com.jinmayi.service.ProductService;
import com.jinmayi.service.QrCodeService;
import com.jinmayi.service.RepertoryService;

@Service("repertoryService")
public class RepertoryServiceImpl implements RepertoryService {

	@Resource
	private RepertoryDao repertoryDao;

	@Resource
	private QrCodeDao qrCodeDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private QrCodeService qrCodeService;
	@Resource
	private ProductService productService;

	@Override
	public List<Repertory> getRepertories(Integer enterpriseid) {
		return repertoryDao.getRepertories(enterpriseid);
	}

	@Override
	public Repertory getRepertories(Integer enterpriseid, Integer qrcodeid) {
		String hql = " from Repertory where isdelete = 0 and enterpriseid = ? and qrcodeid = ?";
		return repertoryDao.get(hql, new Object[] { enterpriseid, qrcodeid });
	}

	@Override
	public Long save(Repertory r) {
		return (Long) repertoryDao.save(r);
	}

	@Override
	public Integer delete(Repertory r) {
		String hql = "update Repertory set isdelete = 1 where enterpriseid = ? and qrcodeid = ?";
		return repertoryDao.executeHql(hql, new Object[] { r.getEnterpriseid(),
				r.getQrcodeid() });
	}

	@Override
	public List<Repertory> getRepertoriesByQrCodeId(Integer qrcodeid) {
		String hql = " from Repertory where isdelete = 0 and qrcodeid = ? order by id desc";
		return repertoryDao.find(hql, new Object[] { qrcodeid });
	}


}
