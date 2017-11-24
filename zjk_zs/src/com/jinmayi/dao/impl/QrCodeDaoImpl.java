package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.QrCodeDao;
import com.jinmayi.entity.Qrcode;

@Repository("qrCodeDao")
public class QrCodeDaoImpl extends BaseDAOImpl<Qrcode> implements QrCodeDao {

}
