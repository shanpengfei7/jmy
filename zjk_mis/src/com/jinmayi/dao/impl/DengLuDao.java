package com.jinmayi.dao.impl;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.DengLu;

public class DengLuDao extends BaseDao<DengLu> {

	public DengLu getDengLuByDengLuHao(String dengLuHao){
		String sql = "select id, miMa, quanXian from deng_lu where dengluhao = ? and isdelete = ?";
		return query(sql, dengLuHao, false);
	}
	
	public long save(DengLu d) {
		String sql = "insert into deng_lu (dengluhao, mima, quanxian) values(?,?,?)";
		return insert(sql, d.getDengLuHao(), d.getMiMa(), d.getQuanXian());
	}

	public void change(DengLu d) {
		String sql = "update deng_lu set dengluhao = ?, mima = ? where id = ?";
		update(sql, d.getDengLuHao(), d.getMiMa(), d.getId());
	}
	
	public void change(DengLu d, Integer quanxian) {
		String sql = "update deng_lu set dengluhao = ?, mima = ?, quanxian = ?  where id = ?";
		update(sql, d.getDengLuHao(), d.getMiMa(), quanxian, d.getId());
	}
	
	public DengLu getDengLuById(Integer id){
		String sql = "select id, miMa, dengLuHao, quanXian from deng_lu where id = ? and isdelete = ?";
		return query(sql, id, false);
	}
	
	public void delete(Integer id) {
		String sql = "update deng_lu set isdelete = ? where id = ?";
		update(sql, true, id);
	}
	
	public void willDelete(Integer id) {
		String sql = "update deng_lu set isdelete = ? where id = ?";
		update(sql, false, id);
	}
	
	public Boolean hasDengLuHao(String dlh) {
		String sql = "select id from deng_lu where dengluhao = ? and isdelete = ?";
		Integer count = getSingleVal(sql, dlh, false);
		if(count == null) {
			return false;
		} else {
			return true;
		}
	}
	public Boolean hasDengLuHao(String dlh, Integer id) {
		String sql = "select id from deng_lu where dengluhao = ? and isdelete = ? and id <> ?";
		Integer count = getSingleVal(sql, dlh, false, id);
		if(count == null) {
			return false;
		} else {
			return true;
		}
	}
}
