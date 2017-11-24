package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.MakeQrCodeDao;
import com.jinmayi.entity.Makeqrcode;

@Repository("makeQrCodeDao")
public class MakeQrCodeDaoImpl extends BaseDAOImpl<Makeqrcode> implements MakeQrCodeDao {

	@Override
	public List<Makeqrcode> getMakeqrcodesByEidAndPid(Integer eid, Integer pid) {
		String hql = " from Makeqrcode where enterpriseid = ? and productid = ? order by id desc";
		return find(hql, new Object[]{eid, pid});
	}

}
