package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.PackageInformationDao;
import com.jinmayi.entity.Packageinformation;

@Repository("packageInformationDao")
public class PackageInformationDaoImpl extends BaseDAOImpl<Packageinformation> implements PackageInformationDao {

	@Override
	public Packageinformation getPackageinformationByQrCodeId(Integer qrcodeId) {
		String hql = " from Packageinformation where qrcodeid = ?";
		return get(hql, new Object[]{qrcodeId});
	}

}
