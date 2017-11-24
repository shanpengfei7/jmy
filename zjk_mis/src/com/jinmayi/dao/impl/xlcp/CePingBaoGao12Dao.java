package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao12;

public class CePingBaoGao12Dao extends BaseDao<CePingBaoGao12> {

	public long save(CePingBaoGao12 c) {
		String sql = "insert into ce_ping_bao_gao12 (riQi, ciShu, jiChuXinXiId, huanJue, wangXiang, guaiYiXingWei, yangXingSiWei, sum, `show`) values (?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getHuanJue(), c.getWangXiang(), c.getGuaiYiXingWei(), c.getYangXingSiWei(), c.getSum(), c.getShow());
	}
	
	public CePingBaoGao12 getCePingBaoGao12ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, huanJue, wangXiang, guaiYiXingWei, yangXingSiWei, sum, `show` from ce_ping_bao_gao12 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao12 c) {
		String sql = "update ce_ping_bao_gao12 set show = ? where id = ?";
		update(sql, c.getShow(),c.getId());
	}
}
