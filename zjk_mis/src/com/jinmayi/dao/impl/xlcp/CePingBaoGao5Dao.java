package com.jinmayi.dao.impl.xlcp;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.CePingBaoGao5;

public class CePingBaoGao5Dao extends BaseDao<CePingBaoGao5> {

	/*
	 * public long save(CePingBaoGao3 c) { String sql =
	 * "insert into ce_ping_bao_gao2 (flag, riQi, ciShu, jiChuXinXiId, yiJian, result, belong) values (?,?,?,?,?,?,?)"
	 * ; return insert(sql, c.getFlag(), c.getRiQi(), c.getCiShu(),
	 * c.getJiChuXinXiId(), c.getYiJian(), c.getResult(), c.getBelong()); }
	 */

	public long save(CePingBaoGao5 c) {
		String sql = "insert into ce_ping_bao_gao5 (riQi, ciShu, jiChuXinXiId, quTiHua0, qiangPoZheng0,"
				+ " renJiGuanXi0, yiYu0, jiaoLv0, diDui0, kongBu0,"
				+ " pianZhi0, jingShenBing0, qiTa0, quTiHua, qiangPoZheng, "
				+ "renJiGuanXi, yiYu, jiaoLv, diDui, kongBu,"
				+ " pianZhi, jingShenBing, qiTa, belongQuTiHua, sum,"
				+ " belongQiangPoZheng, belongRenJiGuanXi, belongYiYu, belongJiaoLv, belongDiDui,"
				+ " belongKongBu, belongPianZhi, belongJingShenBing, belongQiTa, ave,"
				+ " belongYiYu0, belongJiaoLv0, belongDiDui0,belongQiangPoZheng0, belongRenJiGuanXi0,belongQuTiHua0,"
				+ " belongKongBu0, belongPianZhi0, belongJingShenBing0, belongQiTa0) values (?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, new Timestamp(new Date().getTime()), c.getCiShu(),
				c.getJiChuXinXiId(), c.getQuTiHua0(), c.getQiangPoZheng0(),
				c.getRenJiGuanXi0(), c.getYiYu0(), c.getJiaoLv0(),
				c.getDiDui0(), c.getKongBu0(), c.getPianZhi0(),
				c.getJingShenBing0(), c.getQiTa0(), c.getQuTiHua(),
				c.getQiangPoZheng(), c.getRenJiGuanXi(), c.getYiYu(),
				c.getJiaoLv(), c.getDiDui(), c.getKongBu(), c.getPianZhi(),
				c.getJingShenBing(), c.getQiTa(), c.getBelongQuTiHua(), c.getSum(), c.getBelongQiangPoZheng(),
				c.getBelongRenJiGuanXi(), c.getBelongYiYu(),
				c.getBelongJiaoLv(), c.getBelongDiDui(), c.getBelongKongBu(),
				c.getBelongPianZhi(), c.getBelongJingShenBing(),
				c.getBelongQiTa(), c.getAve(), c.getBelongYiYu0(), c.getBelongJiaoLv0(),
				c.getBelongDiDui0(), c.getBelongQiangPoZheng0(), c.getBelongRenJiGuanXi0(), c.getBelongQuTiHua0(),
				c.getBelongKongBu0(),  c.getBelongPianZhi0(), c.getBelongJingShenBing0()
				, c.getBelongQiTa0());
	}

	public CePingBaoGao5 getCePingBaoGao5ByCiShuJcxx(Integer cs, Integer jId) {
		String sql = "select id,belongYiYu0, belongJiaoLv0, belongDiDui0,belongQiangPoZheng0, belongRenJiGuanXi0,belongQuTiHua0,"
				+ " belongKongBu0, belongPianZhi0, belongJingShenBing0, belongQiTa0, isDelete, riQi, ciShu, jiChuXinXiId, quTiHua0, qiangPoZheng0,"
				+ " renJiGuanXi0, yiYu0, jiaoLv0, diDui0, kongBu0,"
				+ " pianZhi0, jingShenBing0, qiTa0, quTiHua, qiangPoZheng, "
				+ "renJiGuanXi, yiYu, jiaoLv, diDui, kongBu,"
				+ " pianZhi, jingShenBing, qiTa, belongQuTiHua, sum,"
				+ " belongQiangPoZheng, belongRenJiGuanXi, belongYiYu, belongJiaoLv, belongDiDui,"
				+ " belongKongBu, belongPianZhi, belongJingShenBing, belongQiTa, ave from ce_ping_bao_gao5 "
				+ "where isDelete = ? and ciShu = ? and jiChuXinXiId = ?";
		return query(sql, false, cs, jId);
	}
	
	public void update(CePingBaoGao5 c) {
		String sql = "update ce_ping_bao_gao5 set belongQuTiHua = ?, belongQiangPoZheng = ?, belongRenJiGuanXi = ?, belongYiYu = ?, belongJiaoLv = ?, belongDiDui = ?, belongKongBu = ?, belongPianZhi = ?, belongJingShenBing = ?, belongQiTa = ? where id = ?";
		update(sql, c.getBelongQuTiHua(), c.getBelongQiangPoZheng(), c.getBelongRenJiGuanXi(), c.getBelongYiYu(), c.getBelongJiaoLv(), c.getBelongDiDui(), c.getBelongKongBu(), c.getBelongPianZhi(), c.getBelongJingShenBing(), c.getBelongQiTa(), c.getId());
	}
}
