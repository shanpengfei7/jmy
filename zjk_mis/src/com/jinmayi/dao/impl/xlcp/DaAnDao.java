package com.jinmayi.dao.impl.xlcp;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.DaAn;

public class DaAnDao extends BaseDao<DaAn> {

	public long save(DaAn d) {
		String sql = "insert into da_an (tiHao, jiChuXinXiId, daAn, liangBiaoId, ciShu) values (?,?,?,?,?)";
		return insert(sql, d.getTiHao(), d.getJiChuXinXiId(), d.getDaAn(), d.getLiangBiaoId(), d.getCiShu());
	}
	
	public List<DaAn> getDaAnsByJcIdLbIdCs(Integer jId, Integer lbId, Integer cs) {
		String sql = "select ciShu, tiHao, daAn from da_an where jiChuXinXiId = ? and liangBiaoId = ? and ciShu = ? and isdelete = ?";
		return queryForList(sql, jId, lbId, cs, false);
	}
}
