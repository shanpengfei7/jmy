package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao8;

public class CePingBaoGao8Dao extends BaseDao<CePingBaoGao8> {

	public long save(CePingBaoGao8 c) {
		String sql = "insert into ce_ping_bao_gao8 (riQi, ciShu, jiChuXinXiId, yiJian, sum) values (?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getYiJian(), c.getSum());
	}
	
	public CePingBaoGao8 getCePingBaoGao8ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, yiJian, sum from ce_ping_bao_gao8 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao8 c) {
		String sql = "update ce_ping_bao_gao8 set yiJian = ? where id = ?";
		update(sql, c.getYiJian(),c.getId());
	}
}
