package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao13;

public class CePingBaoGao13Dao extends BaseDao<CePingBaoGao13> {

	public long save(CePingBaoGao13 c) {
		String sql = "insert into ce_ping_bao_gao13 (riQi, ciShu, jiChuXinXiId, siWei, xingWei, sum, zhiDaoYiJian) values (?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getSiWei(), c.getXingWei(), c.getSum(), c.getZhiDaoYiJian());
	}
	
	public CePingBaoGao13 getCePingBaoGao13ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, riQi, ciShu, jiChuXinXiId, siWei, xingWei, sum, zhiDaoYiJian from ce_ping_bao_gao13 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao13 c) {
		String sql = "update ce_ping_bao_gao13 set zhiDaoYiJian = ? where id = ?";
		update(sql, c.getZhiDaoYiJian(),c.getId());
	}
}
