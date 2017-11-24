package com.jinmayi.dao;

import com.jinmayi.entity.Packageinformation;

public interface PackageInformationDao extends BaseDAO<Packageinformation> {

	public Packageinformation getPackageinformationByQrCodeId(Integer qrcodeId);
}
