package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao6;

public class CePingBaoGao6Dao extends BaseDao<CePingBaoGao6> {

	public long save(CePingBaoGao6 c) {
		String sql = "insert into ce_ping_bao_gao6 (riQi, ciShu, jiChuXinXiId, P, E, N, L, yiJianP, yiJianE, yiJianN, yiJIanL, belongP, belongE, belongN, belongL, Py, Ey, Ny, Ly) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getP(), c.getE(), c.getN(), c.getL(), c.getYiJianP(),
				c.getYiJianE(), c.getYiJianN(), c.getYiJianL(), c.getBelongP(), c.getBelongE(), 
				c.getBelongN(), c.getBelongL(), c.getPy(), c.getEy(), c.getNy(), c.getLy());
	}
	
	public CePingBaoGao6 getCePingBaoGao6ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, Py, Ey, Ny, Ly, jiChuXinXiId, P, E, N, L, yiJianP, yiJianE, yiJianN, yiJIanL, belongP, belongE, belongN, belongL from ce_ping_bao_gao6 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao6 c) {
		String sql = "update ce_ping_bao_gao6 set yiJianP = ?, yiJianE = ?, yiJianN = ?, yiJianL = ?, belongP = ?, belongE = ?, belongN = ?, belongL = ? where id = ?";
		update(sql, c.getYiJianP(), c.getYiJianE(), c.getYiJianN(), c.getYiJianL(), c.getBelongP(), c.getBelongE(), c.getBelongN(), c.getBelongL(), c.getId());
	}
}
