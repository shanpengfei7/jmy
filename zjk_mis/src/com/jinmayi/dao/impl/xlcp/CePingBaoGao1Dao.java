package com.jinmayi.dao.impl.xlcp;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao1;

public class CePingBaoGao1Dao extends BaseDao<CePingBaoGao1> {

	public long save(CePingBaoGao1 c) {
		String sql = "insert into ce_ping_bao_gao1 (flag, riQi, ciShu, jiChuXinXiId, pingHe, qiXu, yangXu, yinXu, tanShi, shiRe, yuXue, qiYu, teBing, yiJian, jianYi, yaoShan) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, c.getFlag(), c.getRiQi(), c.getCiShu(), c.getJiChuXinXiId(), c.getPingHe(), c.getQiXu(), c.getYangXu(), c.getYinXu(), c.getTanShi(), c.getShiRe(), c.getYuXue(), c.getQiYu(), c.getTeBing(), c.getYiJian(), c.getJianYi(), c.getYaoShan());
	}
	
	public CePingBaoGao1 getCePingBaoGao1ByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, pingHe, qiXu, yangXu, yinXu, tanShi, shiRe, yuXue, qiYu, teBing, yiJian, jianYi, yaoShan from ce_ping_bao_gao1 "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	
	public void update(CePingBaoGao1 c) {
		String sql = "update ce_ping_bao_gao1 set yiJian = ?, jianYi = ?, yaoShan = ? where id = ?";
		update(sql, c.getYiJian(), c.getJianYi(), c.getYaoShan(), c.getId());
	}
}
