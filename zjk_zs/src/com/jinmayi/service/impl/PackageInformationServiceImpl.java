package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.PackageInformationDao;
import com.jinmayi.entity.Packageinformation;
import com.jinmayi.service.PackageInformationService;
import com.jinmayi.util.TimeChange;

@Service("packageInformationService")
public class PackageInformationServiceImpl implements PackageInformationService {

	@Resource
	private PackageInformationDao packageInformationDao;

	@Override
	public List<Packageinformation> getPackageinformationByEmIdAndDate(
			Integer id, String date) {
		String hql = "from Packageinformation where employeeid = ? and time between ? and ? order by id desc";
		return packageInformationDao.find(hql,
				new Object[] { id, TimeChange.dateToStamp(date + " 00:00:00"),
						TimeChange.dateToStamp(date + " 23:59:59") });
	}

	@Override
	public List<Packageinformation> getPackageinformationByQrcodeid(Integer qrcodeid) {
		String hql = "from Packageinformation where qrcodeid = ?";
		return packageInformationDao.find(hql,
				new Object[] { qrcodeid });
	}

}
