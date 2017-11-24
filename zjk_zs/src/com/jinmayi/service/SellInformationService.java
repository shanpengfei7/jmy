package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Sellinformation;

public interface SellInformationService {

	public Sellinformation getSellinformationsByQrcodeid(Integer qrcodeid);

	public Integer getSellinformationCountByEnid(Integer enterpriseid);

	public List<Sellinformation> getSellinformationsByEnid(
			Integer enterpriseid, Integer pageNow, Integer pageSize);

	public List<Sellinformation> getSellinformationsByEmid(Integer employeeid, String date);
}
