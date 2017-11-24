package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao9;

public class CePingBaoGao9Dao extends BaseDao<CePingBaoGao9> {

	public long save(CePingBaoGao9 c) {
		String sql = "insert into ce_ping_bao_gao9 (riQi, ciShu, jiChuXinXiId, yiJian, sum) values (?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getYiJian(), c.getSum());
	}
	
	public CePingBaoGao9 getCePingBaoGao9ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, yiJian, sum from ce_ping_bao_gao9 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	public void update(CePingBaoGao9 c) {
		String sql = "update ce_ping_bao_gao9 set yiJian = ? where id = ?";
		update(sql, c.getYiJian(),c.getId());
	}
}
