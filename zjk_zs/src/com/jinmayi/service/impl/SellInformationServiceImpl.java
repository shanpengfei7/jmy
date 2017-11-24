package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.SellInformationDao;
import com.jinmayi.entity.Sellinformation;
import com.jinmayi.service.SellInformationService;
import com.jinmayi.util.TimeChange;

@Service("sellInformationService")
public class SellInformationServiceImpl implements SellInformationService {

	@Resource
	private SellInformationDao sellInformationDao;

	@Override
	public Sellinformation getSellinformationsByQrcodeid(Integer qrcodeid) {
		String hql = " from Sellinformation where qrcodeid = ? order by id desc";
		return sellInformationDao.get(hql, new Object[] { qrcodeid });
	}
	@Override
	public Integer getSellinformationCountByEnid(Integer enterpriseid) {
		String hql = " from Sellinformation where enterpriseid = ?";
		return sellInformationDao.find(hql, new Object[]{enterpriseid}).size();
	}

	@Override
	public List<Sellinformation> getSellinformationsByEnid(Integer enterpriseid,
			Integer pageNow, Integer pageSize) {
		String hql = " from Sellinformation where enterpriseid = ? order by id desc";
		return sellInformationDao.find(hql, new Object[]{enterpriseid}, pageNow, pageSize);
	}

	@Override
	public List<Sellinformation> getSellinformationsByEmid(Integer employeeid, String date) {
		String hql = " from Sellinformation where employeeid = ? and time between ? and ? order by id desc";
		return sellInformationDao.find(hql, new Object[]{employeeid, TimeChange.dateToStamp(date + " 00:00:00"),
				TimeChange.dateToStamp(date + " 23:59:59")});
	}


}
