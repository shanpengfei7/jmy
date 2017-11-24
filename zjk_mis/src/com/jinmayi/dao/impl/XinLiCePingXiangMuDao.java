package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.XingLiCePingXiangMu;

public class XinLiCePingXiangMuDao extends BaseDao<XingLiCePingXiangMu> {

	public List<XingLiCePingXiangMu> getXingLiCePingXiangMusByJcxmId(Integer id) {
		String sql = "select liangBiaoId, isJianCe from xing_li_ce_ping_xiang_mu where jianCeXiangMu = ? and isdelete = ?";
		return queryForList(sql, id, false);
	}
	
	public long save(XingLiCePingXiangMu x) {
		String sql = "insert into xing_li_ce_ping_xiang_mu (liangBiaoId, jianCeXiangMu) values(?,?)";
		return insert(sql, x.getLiangBiaoId(), x.getJianCeXiangMu());
	}
	
	public void jianCed(Integer lbId, Integer jcxmId) {
		String sql = "update xing_li_ce_ping_xiang_mu set isjiance = ? where liangbiaoId = ? and jiancexiangmu = ?";
		update(sql, true, lbId, jcxmId);
	}
	
	public void delete(Integer id) {
		String sql = "update xing_li_ce_ping_xiang_mu set isDelete = ? where jianCeXiangMu = ?";
		update(sql, true, id);
	}
}
