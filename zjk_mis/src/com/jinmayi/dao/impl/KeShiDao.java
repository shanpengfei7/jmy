package com.jinmayi.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.KeShi;

public class KeShiDao extends BaseDao<KeShi> {

	public List<KeShi> getKeShisByYiYuanId(Integer id) {
		String sql = "select id, mingCheng from ke_shi where yiyuanid = ?";
		return queryForList(sql, id);
	}

	/**
	 * 
	 * @param ks ø∆ “√˚≥∆∫Õsession
	 * @return
	 */
	public long save(KeShi ks, HttpSession session) {
		String sql = "insert into ke_shi(mingcheng,yiyuan,yiyuanid)values(?,?,?)";
		return insert(sql, ks.getMingCheng(),session.getAttribute("yiYuanMingCheng"), session.getAttribute("yiYuanId"));
	}
	
	public List<KeShi> getKeShis(HttpSession session) {
		String sql = "select id, isUse, mingCheng, yiYuan from ke_shi where isdelete = ? and yiyuanid = ? order by id desc";
		return queryForList(sql, false, session.getAttribute("yiYuanId"));
	}
	
	public KeShi getKeShiById(Integer id) {
		String sql = "select id, mingCheng from ke_shi where id = ?";
		return query(sql, id);
	}
	
	public void change(KeShi ks) {
		String sql = "update ke_shi set mingcheng = ? where id = ?";
		update(sql, ks.getMingCheng(), ks.getId());
	}
	
	public void delete(Integer id) {
		String sql = "update ke_shi set isUse = ? where id = ?";
		update(sql, false, id);
	}
	
	public void willDelete(Integer id) {
		String sql = "update ke_shi set isUse = ? where id = ?";
		update(sql, true, id);
	}
	
	public KeShi getKeShiByName(String name) {
		String sql = "select id, mingCheng from ke_shi where mingcheng = ? and isdelete = ?";
		return query(sql, name, false);
	}
	
	public List<KeShi> getKeShisBySession(HttpSession session) {
		String sql = "select id, mingCheng from ke_shi where yiYuanId = ? and isdelete = ? and isUse = ?";
		return queryForList(sql, session.getAttribute("yiYuanId"), false, true);
	}
}
