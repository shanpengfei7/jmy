package com.jinmayi.dao.impl.xlcp;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao2;

public class CePingBaoGao2Dao extends BaseDao<CePingBaoGao2> {

	public long save(CePingBaoGao2 c) {
		String sql = "insert into ce_ping_bao_gao2 (flag, riQi, ciShu, jiChuXinXiId, yiJian, result, belong) values (?,?,?,?,?,?,?)";
		return insert(sql, c.getFlag(), c.getRiQi(), c.getCiShu(), c.getJiChuXinXiId(), c.getYiJian(), c.getResult(), c.getBelong());
	}
	
	public CePingBaoGao2 getCePingBaoGao2ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, yiJian, result from ce_ping_bao_gao2 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao2 c) {
		String sql = "update ce_ping_bao_gao2 set yiJian = ? where id = ?";
		update(sql, c.getYiJian(),c.getId());
	}
}
