package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Makeqrcode;

public interface MakeQrCodeDao extends BaseDAO<Makeqrcode> {

	public List<Makeqrcode> getMakeqrcodesByEidAndPid(Integer eid, Integer pid);
}
