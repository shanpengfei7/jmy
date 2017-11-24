package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao11;

public class CePingBaoGao11Dao extends BaseDao<CePingBaoGao11> {

	public long save(CePingBaoGao11 c) {
		String sql = "insert into ce_ping_bao_gao11 (riQi, ciShu, jiChuXinXiId, sum, "
				+ "qingGanPingDan, siWeiPinFa, yiZhiQueFa, xingQuSheJiao, zhuYiZhangAi, "
				+ "`show`) values (?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(),
				c.getJiChuXinXiId(), c.getSum(), c.getQingGanPingDan(),
				c.getSiWeiPinFa(), c.getYiZhiQueFa(), c.getXingQuSheJiao(),
				c.getZhuYiZhangAi(), c.getShow());
	}

	public CePingBaoGao11 getCePingBaoGao11ByCiShuJcxx(Integer cs, Integer jId) {
		String sql = "select id, riQi, ciShu, jiChuXinXiId, sum, qingGanPingDan, "
				+ "siWeiPinFa, yiZhiQueFa, xingQuSheJiao, zhuYiZhangAi, `show` from ce_ping_bao_gao11 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao11 c) {
		String sql = "update ce_ping_bao_gao11 set show = ? where id = ?";
		update(sql, c.getShow(),c.getId());
	}
}
