package com.jinmayi.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;

public class JianCeXiangMuDao extends BaseDao<JianCeXiangMu> {

	public Long getNaoDianCount(String sq) {
		String sql = "select count(naoDian) from jian_ce_xiang_mu " + "where isdelete = ? and naoDian = 1 " + sq;
		return getSingleVal(sql, false);
	}

	public Long getXinLiCePingCount(String sq) {
		String sql = "select count(xinLiCePing) from jian_ce_xiang_mu " + "where isdelete = ? and xinLiCePing = 1 "
				+ sq;
		return getSingleVal(sql, false);
	}

	public Long getCcbtCount(String sq) {
		String sql = "select count(ccbt) from jian_ce_xiang_mu " + "where isdelete = ? and ccbt = 1 " + sq;
		return getSingleVal(sql, false);
	}

	public Long getNaoRenZhiCount(String sq) {
		String sql = "select count(naoRenZhi) from jian_ce_xiang_mu " + "where isdelete = ? and naoRenZhi = 1 " + sq;
		return getSingleVal(sql, false);
	}

	public Long getYingYanCount(String sq) {
		String sql = "select count(yingYan) from jian_ce_xiang_mu " + "where isdelete = ? and yingYan = 1 " + sq;
		return getSingleVal(sql, false);
	}

	public Long getHrvCount(String sq) {
		String sql = "select count(hrv) from jian_ce_xiang_mu " + "where isdelete = ? and hrv = 1 " + sq;
		return getSingleVal(sql, false);
	}

	public List<JianCeXiangMu> getJianCeXiangMupbb(String sq) {
		String sql = "select yiYuanId, keShi, zhuanKeYiSheng, jingShenKeYiSheng, cePingShi, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv, yongHuId, xingMing from jian_ce_xiang_mu "
				+ "where  isdelete = ?" + sq + " ORDER BY id desc";
		return queryForList(sql, false);
	}

	public Page<JianCeXiangMu> getPagebb(long pageNow, String sq) {
		Page<JianCeXiangMu> page = new Page<JianCeXiangMu>(pageNow);
		page.setTotalItemNumber(getJianCeXiangMuCountbb(sq));
		page.setList(getJianCeXiangMubb(page, sq));
		return page;
	}

	private List<JianCeXiangMu> getJianCeXiangMubb(Page<JianCeXiangMu> page, String sq) {
		String sql = "select yiYuanId, keShi, zhuanKeYiSheng, jingShenKeYiSheng, cePingShi, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv, yongHuId, xingMing from jian_ce_xiang_mu "
				+ "where  isdelete = ?" + sq + " ORDER BY id desc limit ?,?";
		return queryForList(sql, false, (page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
	}

	private Long getJianCeXiangMuCountbb(String sq) {
		String sql = "select count(id) from jian_ce_xiang_mu where  isdelete = ? " + sq;
		return getSingleVal(sql, false);
	}

	public List<JianCeXiangMu> getMoreGdJianCeXiangMusByJcxxId(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ?";
		return queryForList(sql, id, false);
	}

	public List<JianCeXiangMu> getMoreJianCeXiangMusByJcxxId(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ? and isGuiDang = ?";
		return queryForList(sql, id, false, false);
	}

	public List<JianCeXiangMu> getJianCeXiangMusByJcxxId(Integer id) {
		String sql = "select distinct id from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ? and isGuiDang = ?";
		return queryForList(sql, id, false, false);
	}

	public void guiDang(List<Integer> ids) {
		String sql = "update jian_ce_xiang_mu set isGuiDang = ?, gdRiQi = ? where id = ?";
		Object[][] params = new Object[ids.size()][3];
		for (int i = 0; i < ids.size(); i++) {
			params[i][0] = true;
			params[i][1] = new Timestamp(new Date().getTime());
			params[i][2] = ids.get(i);
		}
		batch(sql, params);
	}

	public Integer getCiShuByJcxxId(Integer id) {
		String sql = "select MAX(ciShu) from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ?";
		return getSingleVal(sql, id, false);
	}

	public JianCeXiangMu getNewAllJianCeXiangMusByJcxxId(Integer id) {
		String sql = "select naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ? and "
				+ "ciShu = (select MAX(ciShu) from jian_ce_xiang_mu " + "where jiChuXinXiId = ? and isdelete = ?)";
		return query(sql, id, false, id, false);
	}

	public JianCeXiangMu getNewJianCeXiangMusByJcxxId(Integer id) {
		String sql = "select id, ciShu, xingBie from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = ? and "
				+ "ciShu = (select MAX(ciShu) from jian_ce_xiang_mu " + "where jiChuXinXiId = ? and isdelete = ?)";
		return query(sql, id, false, id, false);
	}

	public long save(JianCeXiangMu j, HttpSession session) {
		String sql = "insert into jian_ce_xiang_mu (jiChuXinXiId,yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingshenkeyisheng, shouzhenriQi, yiYuanId, keShi, zhuanKeYiSheng) select id, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, riQi, yiYuanId, suoShuKeShi, zhuanKeYiSheng from ji_chu_xin_xi where id = ?";
		long id = insert(sql, j.getJiChuXinXiId());

		sql = "update jian_ce_xiang_mu set ciShu = ?, riQi = ?, naoDian = ?, ccbt = ?, naoRenZhi = ?, xinLiCePing = ?, yingYan = ?, hrv = ?, cePingShi =? where id = ?";
		update(sql, j.getCiShu(), j.getRiQi(), j.getNaoDian(), j.getCcbt(), j.getNaoRenZhi(), j.getXinLiCePing(),
				j.getYingYan(), j.getHrv(), session.getAttribute("cePingShi"), id);
		return id;
	}

	public void changBatch(JiChuXinXi j) {
		String sql = "update zhen_liao_fang_an set xingMing = ?, xingBie = ?, chuShengNian = ?, chuShengYue = ?, chuShengRi = ?,  where jiChuXinXiId = ?";
		update(sql, j.getXingMing(), j.getXingBie(), j.getChuShengNian(), j.getChuShengYue(), j.getChuShengRi(),
				j.getId());
	}

	public void change(JianCeXiangMu j) {
		String sql = "update jian_ce_xiang_mu set ciShu = ?, riQi = ?, naoDian = ?, ccbt = ?, naoRenZhi = ?, xinLiCePing = ?, yingYan = ?, hrv = ? where id = ?";
		update(sql, j.getCiShu(), j.getRiQi(), j.getNaoDian(), j.getCcbt(), j.getNaoRenZhi(), j.getXinLiCePing(),
				j.getYingYan(), j.getHrv(), j.getId());

	}

	public Page<JianCeXiangMu> getPage(long pageNow, SearchContent s, HttpSession session) {
		Page<JianCeXiangMu> page = new Page<JianCeXiangMu>(pageNow);
		page.setTotalItemNumber(getJianCeXiangMuCount(session, s));
		page.setList(getJianCeXiangMus(page, s, session));
		return page;
	}

	private List<JianCeXiangMu> getJianCeXiangMus(Page<JianCeXiangMu> page, SearchContent s, HttpSession session) {

		String sql = "select id, isGuiDang, gdRiQi, ciShu, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingShenKeYiSheng, cePingShi, shouZhenRiQi, yiYuanId from jian_ce_xiang_mu "
				+ "where  isdelete = ? and yiYuanId = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";

		return queryForList(sql, false, session.getAttribute("yiYuanId"), s.getName(), s.getTime1(), s.getTime2(),
				(page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
	}

	private Long getJianCeXiangMuCount(HttpSession session, SearchContent s) {
		String sql = "select count(id) from jian_ce_xiang_mu where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2());
	}

	public Page<JianCeXiangMu> getPage(long pageNow, SearchContent s, HttpSession session, Boolean isGuiDang) {
		Page<JianCeXiangMu> page = new Page<JianCeXiangMu>(pageNow);
		page.setTotalItemNumber(getJianCeXiangMuCount(session, s, isGuiDang));
		page.setList(getJianCeXiangMus(page, s, session, isGuiDang));
		return page;
	}

	private List<JianCeXiangMu> getJianCeXiangMus(Page<JianCeXiangMu> page, SearchContent s, HttpSession session,
			Boolean isGuiDang) {

		String sql = "select id, gdRiQi, jiChuXinXiId, ciShu, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi, jingShenKeYiSheng, cePingShi, shouZhenRiQi, yiYuanId from jian_ce_xiang_mu "
				+ "where  isdelete = ? and yiYuanId = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ? ORDER BY id desc limit ?,?";

		return queryForList(sql, false, session.getAttribute("yiYuanId"), s.getName(), s.getTime1(), s.getTime2(),
				isGuiDang, (page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
	}

	private Long getJianCeXiangMuCount(HttpSession session, SearchContent s, Boolean isGuiDang) {
		String sql = "select count(id) from jian_ce_xiang_mu where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2(),
				isGuiDang);
	}

	public JianCeXiangMu getJianCeXiangMusById(Integer id) {
		String sql = "select id, ciShu, jiChuXinXiId, riQi, naoDian, ccbt, naoRenZhi, xinLiCePing, yingYan, hrv from jian_ce_xiang_mu where id = ?";
		return query(sql, id);
	}

	public JianCeXiangMu hrv(int yyid, int jcxxid) {
		String sql = "select id, ciShu from jian_ce_xiang_mu where yiYuanId = ? and hrv = 1 and jiChuXinXiId = ? and isdelete = 0 and "
				+ "ciShu = (select MAX(ciShu) from jian_ce_xiang_mu "
				+ "where yiYuanId = ? and hrv = 1 and jiChuXinXiId = ? and isdelete = 0)";

		return query(sql, yyid, jcxxid, yyid, jcxxid);
	}

	public JianCeXiangMu hrv(int jcxxid) {
		String sql = "select hrv from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = 0 and "
				+ "ciShu = (select MAX(ciShu) from jian_ce_xiang_mu where jiChuXinXiId = ? and isdelete = 0)";

		return query(sql, jcxxid, jcxxid);
	}
}
