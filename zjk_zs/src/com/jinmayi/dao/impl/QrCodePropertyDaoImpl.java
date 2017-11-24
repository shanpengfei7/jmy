package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.QrCodePropertyDao;
import com.jinmayi.entity.Qrcodeproperty;

@Repository("qrCodePropertyDao")
public class QrCodePropertyDaoImpl extends BaseDAOImpl<Qrcodeproperty> implements QrCodePropertyDao {

	@Override
	public List<Qrcodeproperty> getQrcodepropertiesByQrCodeId(Integer qid) {
		return find(" from Qrcodeproperty where qrcodeid = ?", new Object[]{qid});
	}

}
