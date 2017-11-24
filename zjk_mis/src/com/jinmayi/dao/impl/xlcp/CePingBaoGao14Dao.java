package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao14;

public class CePingBaoGao14Dao extends BaseDao<CePingBaoGao14> {

	public long save(CePingBaoGao14 c) {
		String sql = "insert into ce_ping_bao_gao14 (riQi, ciShu, jiChuXinXiId, sum, yiJian, jianYi) values (?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getSum(), c.getYiJian(), c.getJianYi());
	}
	
	public CePingBaoGao14 getCePingBaoGao14ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, sum, yiJian, jianYi from ce_ping_bao_gao14 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao14 c) {
		String sql = "update ce_ping_bao_gao14 set yiJian = ?, jianYi = ? where id = ?";
		update(sql, c.getYiJian(), c.getJianYi(), c.getId());
	}
}
