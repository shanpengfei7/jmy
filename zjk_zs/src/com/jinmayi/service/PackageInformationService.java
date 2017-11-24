package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Packageinformation;

public interface PackageInformationService {

	
	public List<Packageinformation> getPackageinformationByEmIdAndDate(Integer id, String date);
	
	public List<Packageinformation> getPackageinformationByQrcodeid(Integer qrcodeid);
	
}
