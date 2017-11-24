package com.jinmayi.dao.impl.xlcp;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CanKao;

public class CanKaoDao extends BaseDao<CanKao> {

	public CanKao getCanKaoById(Integer id) {
		String sql = "select liangBiaoId, zhiDaoYiJian, jianYi, yaoShan from can_kao where id = ? and isdelete = ?";
		return query(sql, id, false);
	}
}
