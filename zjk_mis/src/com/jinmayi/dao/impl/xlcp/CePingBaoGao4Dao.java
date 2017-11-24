package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao4;

public class CePingBaoGao4Dao extends BaseDao<CePingBaoGao4> {
	public long save(CePingBaoGao4 c) {
		String sql = "insert into ce_ping_bao_gao4 (riQi, ciShu, jiChuXinXiId, yiZhia0, jiReb0, "
				+ "shengWuc0, renZhid0, xiangXiange0, yiZhia, jiReb, shengWuc, "
				+ "belong1, belong2, renZhid, xiangXiange, yiJian1, yiJian2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(),
				c.getJiChuXinXiId(), c.getYiZhia0(), c.getJiReb0(),
				c.getShengWuc0(), c.getRenZhid0(), c.getXiangXiange0(),
				c.getYiZhia(), c.getJiReb(), c.getShengWuc(), c.getBelong1(),
				c.getBelong2(), c.getRenZhid(), c.getXiangXiange(),
				c.getYiJian1(), c.getYiJian2());
	}

	public CePingBaoGao4 getCePingBaoGao4ByCiShuJcxx(Integer cs, Integer jId) {
		String sql = "select id,isDelete, riQi, ciShu, jiChuXinXiId, yiZhia0, jiReb0, "
				+ "shengWuc0, renZhid0, xiangXiange0, yiZhia, jiReb, shengWuc, "
				+ "belong1, belong2, renZhid, xiangXiange, yiJian1, yiJian2 from ce_ping_bao_gao4 "
				+ "where isDelete = ? and ciShu = ? and jiChuXinXiId = ?";
		return query(sql, false, cs, jId);
	}
	
	public void update(CePingBaoGao4 c) {
		String sql = "update ce_ping_bao_gao4 set belong1 = ?, belong2 = ?, yiJian1 = ?, yiJian2 = ? where id = ?";
		update(sql, c.getBelong1(), c.getBelong2(), c.getYiJian1(), c.getYiJian2(), c.getId());
	}
}
