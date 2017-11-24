package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao10;

public class CePingBaoGao10Dao extends BaseDao<CePingBaoGao10> {

	public long save(CePingBaoGao10 c) {
		String sql = "insert into ce_ping_bao_gao10 (riQi, ciShu, jiChuXinXiId, belong, sum) values (?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getBelong(), c.getSum());
	}
	
	public CePingBaoGao10 getCePingBaoGao10ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, belong, sum from ce_ping_bao_gao10 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao10 c) {
		String sql = "update ce_ping_bao_gao10 set belong = ? where id = ?";
		update(sql, c.getBelong(),c.getId());
	}
}
