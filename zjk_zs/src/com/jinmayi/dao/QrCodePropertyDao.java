package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Qrcodeproperty;

public interface QrCodePropertyDao extends BaseDAO<Qrcodeproperty> {

	public List<Qrcodeproperty> getQrcodepropertiesByQrCodeId(Integer qid);
}
