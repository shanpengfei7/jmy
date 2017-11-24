package com.jinmayi.dao.impl.xlcp;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.LiangBiao;

public class LiangBiaoDao extends BaseDao<LiangBiao> {
	
	public LiangBiao getLiangBiaoById(Integer id) {
		String sql = "select id, mingCheng, jianJie, yaoQiu, shiJian, zhuYiShiXiang, yingYongPingJia from liang_biao where id = ? and isdelete = ?";
		return query(sql, id, false);
	}
	
	public Integer getIdByName(String name) {
		String sql = "select id from liang_biao where isdelete = ? and mingCheng = ?";
		return getSingleVal(sql, false, name);
	}
	
	public String getNameById(Integer id) {
		String sql = "select mingCheng from liang_biao where id = ?";
		return getSingleVal(sql, id);
	}
}
