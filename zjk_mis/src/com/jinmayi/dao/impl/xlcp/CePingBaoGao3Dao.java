package com.jinmayi.dao.impl.xlcp;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao3;

public class CePingBaoGao3Dao extends BaseDao<CePingBaoGao3> {

	public long save(CePingBaoGao3 c) {
		String sql = "insert into ce_ping_bao_gao3 (flag, riQi, ciShu, jiChuXinXiId, yiJian, result, belong) values (?,?,?,?,?,?,?)";
		return insert(sql, c.getFlag(), c.getRiQi(), c.getCiShu(), c.getJiChuXinXiId(), c.getYiJian(), c.getResult(), c.getBelong());
	}
	
	public CePingBaoGao3 getCePingBaoGao3ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, yiJian, result from ce_ping_bao_gao3 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao3 c) {
		String sql = "update ce_ping_bao_gao3 set yiJian = ? where id = ?";
		update(sql, c.getYiJian(),c.getId());
	}
}
