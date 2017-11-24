package com.jinmayi.dao.impl;

import java.util.List;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.YiYuan;

public class YiYuanDao extends BaseDao<YiYuan> {

	/**
	 * 保存
	 * @param DengLu对象的三个参数(号，密码，权限)，自己的六个参数
	 * @return
	 */
	public long save(YiYuan y) {
		
		String sql = "insert into yi_yuan (daihao, lianxidianhua, mingcheng, sheng, shi, xian, dengluid, todaycount) values(?,?,?,?,?,?,?,?)";
		return insert(sql, y.getDaiHao(), y.getLianXiDianHua(), y.getMingCheng(),y.getSheng(), y.getShi(), y.getXian(), y.getDengLuId(), 0);
	}
	
	public long getYiYuanCount(String d) {
		String sql = "select count(daihao) from yi_yuan where daihao like concat(?,'____')";
		return getSingleVal(sql, d);
	}
	
	public List<YiYuan> getYiYuans(){
		String sql = "select id, isdelete, isUse, mingcheng, daihao, sheng, shi, xian, lianxidianhua from yi_yuan where isdelete = ? order by id desc";
		return queryForList(sql, false);
	}
	
	public List<YiYuan> getLessYiYuans(){
		String sql = "select id, mingcheng from yi_yuan where isdelete = ? and isUse = ? order by id desc";
		return queryForList(sql, false, true);
	}
	/**
	 * 修改
	 * @param y DengLu对象的三个参数(id, 号，密码)，自己的三个参数
	 */
	public void change(YiYuan y) {
		
		String sql = "update yi_yuan set lianxidianhua = ?, mingcheng = ? where id = ?";
		update(sql, y.getLianXiDianHua(), y.getMingCheng(), y.getId());
	}
	
	public YiYuan getYiYuanById(Integer id) {
		String sql = "select id, dengLuId, isUse, todayCount, isdelete, mingcheng, daihao, sheng, shi, xian, lianxidianhua from yi_yuan where id = ? and isdelete = ?";
		return query(sql, id, false);
	}
	
	public Integer getDengLuIdById(Integer id) {
		String sql = "select dengLuId from yi_yuan where id = ?";
		return getSingleVal(sql, id);
	}
	
	public void delete(Integer id) {
		String sql = "update yi_yuan set isUse = ? where id = ?";
		update(sql, false, id);
	}
	
	public void willDelete(Integer id) {
		String sql = "update yi_yuan set isUse = ? where id = ?";
		update(sql, true, id);
	}
	
	public YiYuan getIdByDLId(Integer id) {
		String sql = "select id, mingCheng from yi_yuan where dengluid = ? and isdelete = ?";
		return query(sql, id, false);
	}
	
	
	
	public void setTodayById(Integer id) {
		String sql ="update yi_yuan set todayCount = todayCount + ? where id = ?";
		update(sql, 1, id);
	}
	
}
