package com.jinmayi.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.KeShi;
import com.jinmayi.entity.YiSheng;

public class YiShengDao extends BaseDao<YiSheng> {

	public List<YiSheng> getZhuanKesByKeShiId(String keShi, String jue, String se) {
		String sql = "select id, xingMing from yi_sheng where keShi = ? and (jueSe = ? or jueSe = ?) and isDelete = ?";
		return queryForList(sql, keShi, jue, se, false);
	}
	
	public List<YiSheng> getZhuanKesByKeShiId(String keShi, String jue, String se, HttpSession session) {
		String sql = "select id, xingMing from yi_sheng where keShi = ? and (jueSe = ? or jueSe = ?) and isDelete = ? and yiYuanId = ?";
		return queryForList(sql, keShi, jue, se, false, session.getAttribute("yiYuanId"));
	}
	
	public List<YiSheng> getYiShengsByYiYuanId(Integer id, String jue, String se, HttpSession session) {
		String sql = "select id, xingMing from yi_sheng where yiyuanid = ? and (jueSe = ? or jueSe = ?) and isDelete = ? and yiYuanId = ?";
		return queryForList(sql, id, jue, se, false, session.getAttribute("yiYuanId"));
	}
	
	public List<YiSheng> getYiShengsByYiYuanId(Integer id, String jue, String se) {
		String sql = "select id, xingMing from yi_sheng where yiyuanid = ? and (jueSe = ? or jueSe = ?) and isDelete = ?";
		return queryForList(sql, id, jue, se, false);
	}
	
	public List<YiSheng> getZhuGuansByYiYuanId(Integer id) {
		String sql = "select id, xingMing from yi_sheng where yiyuanid = ?";
		return queryForList(sql, id);
	}
	
	public List<YiSheng> getZhuanKesByKeShiId(Integer id) {
		String sql = "select id, xingMing from yi_sheng where keshiid = ?";
		return queryForList(sql, id);
	}
	
	public long save(YiSheng ys, HttpSession session) {
		String sql = "insert into yi_sheng (keshi, yiyuan, xingming, xingbie, juese, iszhuren, lianxifangshi, keshiid, dengluid, yiyuanid) values(?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, ys.getKeShi(), session.getAttribute("yiYuanMingCheng"), ys.getXingMing(), ys.getXingBie(), ys.getJueSe(), ys.getIsZhuRen(), ys.getLianXiFangShi(), ys.getKeShiId(), ys.getDengLuId(), session.getAttribute("yiYuanId"));
	}
	
	public List<YiSheng> getYiShengs(HttpSession session){
		String sql = "select id, keShi, xingMing, xingBie, jueSe, isZhuRen, lianXiFangShi from yi_sheng where isdelete = ? and yiyuanid = ? order by id desc";
		return queryForList(sql, false, session.getAttribute("yiYuanId"));
	}
	
	public YiSheng getYiShengById(Integer id){
		String sql = "select keshi, keShiId, dengLuId, xingMing, xingBie, jueSe, isZhuRen, lianXiFangShi from yi_sheng where id = ? and isdelete = ?";
		return query(sql, id, false);
	}

	public void change(YiSheng ys) {
		String sql = "update yi_sheng set xingming = ?, xingbie = ?, keshi = ?, iszhuren = ?, juese = ?, lianxifangshi = ?, keshiid = ? where id = ?";
		update(sql, ys.getXingMing(), ys.getXingBie(), ys.getKeShi(), ys.getIsZhuRen(), ys.getJueSe(), ys.getLianXiFangShi(), ys.getKeShiId(), ys.getId());
	}
	
	public void changeKiShi(KeShi ks) {
		String sql = "update yi_sheng set keshi = ? where keshiid = ?";
		update(sql,  ks.getMingCheng(), ks.getId());
	}
	
	public void delete(Integer id) {
		String sql = "update yi_sheng set isdelete = ? where id = ?";
		update(sql, true, id);
	}
	
	public YiSheng getYiShengByDlId(Integer id){
		String sql = "select  id, xingMing, yiYuanId, yiYuan, jueSe, keShiId, keShi from yi_sheng where dengluid = ? and isdelete = ?";
		return query(sql, id, false);
	}
	
	public Integer getIdByNameYyId(String name, Integer id) {
		String sql = "select id from yi_sheng where xingming = ? and yiyuanid = ?";
		return getSingleVal(sql, name, id);
	}
	
	public List<YiSheng> getZhuGuanYiShisBySession(HttpSession session) {
		String sql = "select id, xingMing from yi_sheng where yiYuanId = ? and isdelete = ? and (jueSe = ? or jueSe = ?)";
		return queryForList(sql, session.getAttribute("yiYuanId"), false, "精神科医生", "精神科主任");
	}
	
	public List<YiSheng> getZhuanKeYiShengsBySessionKeShi(HttpSession session, String ks) {
		String sql = "select id, xingMing from yi_sheng where yiYuanId = ? and isdelete = ? and keShi = ? and (jueSe = ? or jueSe = ?)";
		return queryForList(sql, session.getAttribute("yiYuanId"), false, ks, "专科医生", "专科主任");
	}
}
