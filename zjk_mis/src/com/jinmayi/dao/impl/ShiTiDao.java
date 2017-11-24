package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.ShiTi;

public class ShiTiDao extends BaseDao<ShiTi> {

	public List<ShiTi> getShiTiByLiangBiaoId(Integer id) {
		String sql = "select id, liangBiaoId, tiHao, tiMu, a, b, c, d, e, f, g from shi_ti where liangBiaoId = ? and isdelete = ?";
		return queryForList(sql, id, false);
	}
}
