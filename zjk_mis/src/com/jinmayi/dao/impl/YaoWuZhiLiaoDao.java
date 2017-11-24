package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.YaoWuZhiLiao;

public class YaoWuZhiLiaoDao extends BaseDao<YaoWuZhiLiao> {

	public long save(YaoWuZhiLiao y) {
		String sql = "insert into yao_wu_zhi_liao (yaoMing, guiGe, yongLiang, yongFa, zhenLiaoFangAnId) values (?,?,?,?,?)";
		return insert(sql, y.getYaoMing(),y.getGuiGe(),y.getYongLiang(),y.getYongFa(),y.getZhenLiaoFangAnId());
	}
	
	public List<YaoWuZhiLiao> getYaoWuZhiLiaosByZlfaId(Integer id) {
		String sql = "select id, yaoMing, guiGe, yongLiang, yongFa from yao_wu_zhi_liao where zhenLiaoFangAnId = ? and isdelete = ?";
		return queryForList(sql, id, false);
	}

	
	public void deleteByZlfaId(Integer id) {
		String sql = "update yao_wu_zhi_liao set isDelete = ? where zhenLiaoFangAnId = ?";
		update(sql, true, id);
	}
}
