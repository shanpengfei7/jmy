package com.jinmayi.dao.impl.baogao;

import java.sql.Timestamp;
import java.util.Date;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.entity.NaoDianBaoGao;

public class NaoDianBaoGaoDao extends BaseDao<NaoDianBaoGao> {

	public long save(NaoDianBaoGao h) {
		String sql = "insert into nao_dian_bao_gao (isDelete, ciShu, jiChuXinXiId, riQi, pic1, pic2, pic3, pic4, pic5) values (?,?,?,?,?,?,?,?,?)";
		return insert(sql, false, h.getCiShu(), h.getJiChuXinXiId(), new Timestamp(new Date().getTime()), h.getPic1(), h.getPic2(), h.getPic3(), h.getPic4(), h.getPic5());
	}
	
	public NaoDianBaoGao getNaoDianBaoGaoByCiShuJcxx(Integer cs, Integer jId){
		String sql = "select id, ciShu, riQi, jiChuXinXiId, pic1, pic2,pic3,pic4,pic5 from nao_dian_bao_gao "
				+ "where ciShu = ? and jiChuXinXiId = ? and isdelete = ?";
		return query(sql, cs, jId, false);
	}
	public long update(NaoDianBaoGao h) {
		String sql = "update nao_dian_bao_gao set isDelete = ?, ciShu = ?, jiChuXinXiId = ?, riQi = ?, pic1 = ?, pic2 = ?, pic3 = ?, pic4 = ?, pic5 = ? where id = ?";
		return insert(sql, false, h.getCiShu(), h.getJiChuXinXiId(), new Timestamp(new Date().getTime()), h.getPic1(), h.getPic2(), h.getPic3(), h.getPic4(), h.getPic5(), h.getId());
	}
}
