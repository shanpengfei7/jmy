package com.jinmayi.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.ZhenLiaoFangAn;

public class ZhenLiaoFangAnDao extends BaseDao<ZhenLiaoFangAn> {

	public ZhenLiaoFangAn getZhenLiaoFangAnById(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, fuZhenShiJian, jianCeXiangMu, xinLiCePingXiangMu, XinShenTiaoJie, xinShenZhenDuan, huiFangZhuangTai, huiFangNeiRong, isGuiDang, gdRiQi from zhen_liao_fang_an where id = ?";
		return query(sql, id);
	}
	
	public List<ZhenLiaoFangAn> getMoreGdZhenLiaoFangAnsByJcxxId(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, fuZhenShiJian, jianCeXiangMu, xinLiCePingXiangMu,xinShenTiaoJie,xinShenZhenDuan, huiFangZhuangTai, huiFangNeiRong from zhen_liao_fang_an where jiChuXinXiId = ? and isdelete = ?";
		return queryForList(sql, id, false);
	}
	
	public List<ZhenLiaoFangAn> getMoreZhenLiaoFangAnsByJcxxId(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, fuZhenShiJian, jianCeXiangMu, xinLiCePingXiangMu,xinShenTiaoJie,xinShenZhenDuan, huiFangZhuangTai, huiFangNeiRong from zhen_liao_fang_an where jiChuXinXiId = ? and isdelete = ? and isGuiDang = ?";
		return queryForList(sql, id, false, false);
	}
	
	public List<ZhenLiaoFangAn> getZhenLiaoFangAnsByJcxxId(Integer id) {
		String sql = "select distinct id from zhen_liao_fang_an where jiChuXinXiId = ? and isdelete = ? and isGuiDang = ?";
		return queryForList(sql, id, false, false);
	}
	
	public void guiDang(List<Integer> ids) {
		String sql = "update zhen_liao_fang_an set isGuiDang = ?, gdRiQi = ? where id = ?";
		Object[][] params = new Object[ids.size()][3];
		for(int i = 0; i < ids.size(); i++) {
			params[i][0] = true;
			params[i][1] = new Timestamp(new Date().getTime());
			params[i][2] = ids.get(i);
		}
		batch(sql, params);
	}
	
	public void saveHuiFang(String hf, Integer id) {
		String sql = "update zhen_liao_fang_an set huiFangZhuangTai = ?, huiFangNeiRong = ? where id = ?";
		update(sql, true, hf, id);
	}
	
	public Boolean hasHuiFangById(Integer id) {
		String sql = "select huiFangZhuangTai from zhen_liao_fang_an where id = ? and isdelete = ?";
		return getSingleVal(sql, id, false);
	}
	
	public String getHuiFangById(Integer id) {
		String sql = "select huiFangNeiRong from zhen_liao_fang_an where id = ? and isdelete = ?";
		return getSingleVal(sql, id, false);
	}
	
	public ZhenLiaoFangAn getJcxmByJcId(Integer id) {
		String sql = "select id, jianCeXiangMu, xinLiCePingXiangMu, ciShu  from zhen_liao_fang_an "
				+ "where jiChuXinXiId = ? and isdelete = ? and "
				+ "ciShu = (select MAX(ciShu) from zhen_liao_fang_an "
				+ "where jiChuXinXiId = ? and isdelete = ?)";
		return query(sql, id, false, id, false);
	}
	
	public long save(ZhenLiaoFangAn z, HttpSession session) {
		
		String sql = "insert into zhen_liao_fang_an (jiChuXinXiId,yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingshenkeyisheng, shouzhenriQi, yiYuanId) select id, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, riQi, yiYuanId from ji_chu_xin_xi where id = ?";
		long id = insert(sql, z.getJiChuXinXiId());
		
		sql = "update zhen_liao_fang_an set ciShu=?, riQi=?, fuZhenShiJian=?, jianCeXiangMu=?, xinLiCePingXiangMu=?, xinShenTiaoJie=?, xinShenzhenDuan=?, cePingShi = ? where id = ?";
		update(sql, z.getCiShu(),z.getRiQi(),z.getFuZhenShiJian(),z.getJianCeXiangMu(),z.getXinLiCePingXiangMu(),z.getXinShenTiaoJie(),z.getXinShenZhenDuan(), session.getAttribute("cePingShi"), id);
		return id;
	}
	
	public void changBatch(JiChuXinXi j) {
		String sql = "update zhen_liao_fang_an set xingMing = ?, xingBie = ?, chuShengNian = ?, chuShengYue = ?, chuShengRi = ? where jiChuXinXiId = ?";
		update(sql, j.getXingMing(), j.getXingBie(), j.getChuShengNian(), j.getChuShengYue(), j.getChuShengRi(), j.getId());
	}
	
	public Page<ZhenLiaoFangAn> getPage(long pageNow, SearchContent s, HttpSession session) {
		Page<ZhenLiaoFangAn> page = new Page<ZhenLiaoFangAn>(pageNow);
		page.setTotalItemNumber(getZhenLiaoFangAnCount(session, s));
		page.setList(getZhenLiaoFangAns(page, s, session));
		return page;
	}
	
	private List<ZhenLiaoFangAn> getZhenLiaoFangAns(Page<ZhenLiaoFangAn> page, SearchContent s, HttpSession session) {
		
		String sql = "select id, isGuiDang, gdRiQi, ciShu, riQi, huiFangZhuangTai, huiFangNeiRong, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingShenKeYiSheng, cePingShi, shouZhenRiQi, yiYuanId from zhen_liao_fang_an "
				+ "where  isdelete = ? and yiYuanId = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		
		return queryForList(sql,  false, session.getAttribute("yiYuanId"), s.getName(), s.getTime1(), s.getTime2(),  (page.getpageNow()-1)*page.getPageSize(), page.getPageSize());
	}
	
	private Long getZhenLiaoFangAnCount(HttpSession session, SearchContent s) {
		String sql = "select count(id) from zhen_liao_fang_an where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2());
	}
	
	public Page<ZhenLiaoFangAn> getPage(long pageNow, SearchContent s, HttpSession session, Boolean isGuiDang) {
		Page<ZhenLiaoFangAn> page = new Page<ZhenLiaoFangAn>(pageNow);
		page.setTotalItemNumber(getZhenLiaoFangAnCount(session, s, isGuiDang));
		page.setList(getZhenLiaoFangAns(page, s, session, isGuiDang));
		return page;
	}
	
	private List<ZhenLiaoFangAn> getZhenLiaoFangAns(Page<ZhenLiaoFangAn> page, SearchContent s, HttpSession session, Boolean isGuiDang) {
		
		String sql = "select id, gdRiQi, ciShu, riQi, huiFangZhuangTai, huiFangNeiRong, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingShenKeYiSheng, cePingShi, shouZhenRiQi, yiYuanId from zhen_liao_fang_an "
				+ "where  isdelete = ? and yiYuanId = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ? ORDER BY id desc limit ?,?";
		
		return queryForList(sql,  false, session.getAttribute("yiYuanId"), s.getName(), s.getTime1(), s.getTime2(), isGuiDang, (page.getpageNow()-1)*page.getPageSize(), page.getPageSize());
	}
	
	private Long getZhenLiaoFangAnCount(HttpSession session, SearchContent s, Boolean isGuiDang) {
		String sql = "select count(id) from zhen_liao_fang_an where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2(), isGuiDang);
	}

	public void change(ZhenLiaoFangAn z) {
		String sql = "update zhen_liao_fang_an set ciShu=?, riQi=?, fuZhenShiJian=?, jianCeXiangMu=?, xinLiCePingXiangMu=?, xinShenTiaoJie=?, xinShenzhenDuan=? where id = ?";
		update(sql, z.getCiShu(),z.getRiQi(),z.getFuZhenShiJian(),z.getJianCeXiangMu(),z.getXinLiCePingXiangMu(),z.getXinShenTiaoJie(),z.getXinShenZhenDuan(),z.getId());
	}
}
