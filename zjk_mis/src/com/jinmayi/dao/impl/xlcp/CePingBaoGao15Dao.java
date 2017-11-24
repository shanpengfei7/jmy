package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao15;

public class CePingBaoGao15Dao extends BaseDao<CePingBaoGao15> {

	public long save(CePingBaoGao15 c) {
		String sql = "insert into ce_ping_bao_gao15 (riQi, ciShu, jiChuXinXiId, sum, belong) values (?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getSum(), c.getBelong());
	}
	
	public CePingBaoGao15 getCePingBaoGao15ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, sum, belong from ce_ping_bao_gao15 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao15 c) {
		String sql = "update ce_ping_bao_gao15 set belong = ? where id = ?";
		update(sql, c.getBelong(),c.getId());
	}
}
