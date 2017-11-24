package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao7;

public class CePingBaoGao7Dao extends BaseDao<CePingBaoGao7> {

	public long save(CePingBaoGao7 c) {
		String sql = "insert into ce_ping_bao_gao7 (riQi, ciShu, jiChuXinXiId, sum, jiaoLvYouLv, queFaHuoLi, siWeiZhangAi, jiHuoXing, diDuiCaiYi) values (?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(), c.getJiChuXinXiId(), c.getSum(), c.getJiaoLvYouLv(), c.getQueFaHuoLi(), c.getSiWeiZhangAi(), c.getJiHuoXing(), c.getDiDuiCaiYi());
	}
	
	public CePingBaoGao7 getCePingBaoGao7ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, sum, jiaoLvYouLv, queFaHuoLi, siWeiZhangAi, jiHuoXing, diDuiCaiYi from ce_ping_bao_gao7 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
}
