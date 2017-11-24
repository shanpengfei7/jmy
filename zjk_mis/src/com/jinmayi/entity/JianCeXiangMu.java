package com.jinmayi.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * JianCeXiangMu entity. @author MyEclipse Persistence Tools
 */

public class JianCeXiangMu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Timestamp riQi;
	private Boolean naoDian;
	private Boolean ccbt;
	private Boolean naoRenZhi;
	private Boolean xinLiCePing;
	private Boolean yingYan;
	private Boolean hrv;
	private String yongHuId;
	private String xingMing;
	private Integer xingBie;
	private Integer chuShengNian;
	private Integer chuShengYue;
	private Integer chuShengRi;
	private String jingShenKeYiSheng;
	private String cePingShi;
	private Timestamp shouZhenRiQi;
	private Integer yiYuanId;
	private Boolean isGuiDang;
	private Timestamp gdRiQi;
	private String keShi;
	private String zhuanKeYiSheng;
	private List<String> liangBiaos = new ArrayList<String>();
	// Constructors

	public List<String> getLiangBiaos() {
		return liangBiaos;
	}

	public void setLiangBiaos(List<String> liangBiaos) {
		this.liangBiaos = liangBiaos;
	}

	@Override
	public String toString() {
		return "JianCeXiangMu [id=" + id + ", isDelete=" + isDelete
				+ ", ciShu=" + ciShu + ", jiChuXinXiId=" + jiChuXinXiId
				+ ", riQi=" + riQi + ", naoDian=" + naoDian + ", ccbt=" + ccbt
				+ ", naoRenZhi=" + naoRenZhi + ", xinLiCePing=" + xinLiCePing
				+ ", yingYan=" + yingYan + ", hrv=" + hrv + ", yongHuId="
				+ yongHuId + ", xingMing=" + xingMing + ", xingBie=" + xingBie
				+ ", chuShengNian=" + chuShengNian + ", chuShengYue="
				+ chuShengYue + ", chuShengRi=" + chuShengRi
				+ ", jingShenKeYiSheng=" + jingShenKeYiSheng + ", cePingShi="
				+ cePingShi + ", shouZhenRiQi=" + shouZhenRiQi + ", yiYuanId="
				+ yiYuanId + ", isGuiDang=" + isGuiDang + ", gdRiQi=" + gdRiQi
				+ ", keShi=" + keShi + ", zhuanKeYiSheng=" + zhuanKeYiSheng
				+ ", liangBiaos=" + liangBiaos + "]";
	}

	/** default constructor */
	public JianCeXiangMu() {
	}

	/** minimal constructor */
	public JianCeXiangMu(Integer id, Boolean isDelete, Integer jiChuXinXiId,
			Boolean naoDian, Boolean ccbt, Boolean naoRenZhi,
			Boolean xinLiCePing, Boolean yingYan, Boolean hrv) {
		this.id = id;
		this.isDelete = isDelete;
		this.jiChuXinXiId = jiChuXinXiId;
		this.naoDian = naoDian;
		this.ccbt = ccbt;
		this.naoRenZhi = naoRenZhi;
		this.xinLiCePing = xinLiCePing;
		this.yingYan = yingYan;
		this.hrv = hrv;
	}

	/** full constructor */
	public JianCeXiangMu(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Timestamp riQi, Boolean naoDian,
			Boolean ccbt, Boolean naoRenZhi, Boolean xinLiCePing,
			Boolean yingYan, Boolean hrv, String yongHuId, String xingMing,
			Integer xingBie, Integer chuShengNian, Integer chuShengYue,
			Integer chuShengRi, String jingShenKeYiSheng, String cePingShi,
			Timestamp shouZhenRiQi, Integer yiYuanId, Boolean isGuiDang,
			Timestamp gdRiQi, String yiYuan, String keShi, String zhuanKeYiSheng) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.riQi = riQi;
		this.naoDian = naoDian;
		this.ccbt = ccbt;
		this.naoRenZhi = naoRenZhi;
		this.xinLiCePing = xinLiCePing;
		this.yingYan = yingYan;
		this.hrv = hrv;
		this.yongHuId = yongHuId;
		this.xingMing = xingMing;
		this.xingBie = xingBie;
		this.chuShengNian = chuShengNian;
		this.chuShengYue = chuShengYue;
		this.chuShengRi = chuShengRi;
		this.jingShenKeYiSheng = jingShenKeYiSheng;
		this.cePingShi = cePingShi;
		this.shouZhenRiQi = shouZhenRiQi;
		this.yiYuanId = yiYuanId;
		this.isGuiDang = isGuiDang;
		this.gdRiQi = gdRiQi;
		this.keShi = keShi;
		this.zhuanKeYiSheng = zhuanKeYiSheng;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getCiShu() {
		return this.ciShu;
	}

	public void setCiShu(Integer ciShu) {
		this.ciShu = ciShu;
	}

	public Integer getJiChuXinXiId() {
		return this.jiChuXinXiId;
	}

	public void setJiChuXinXiId(Integer jiChuXinXiId) {
		this.jiChuXinXiId = jiChuXinXiId;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

	public Boolean getNaoDian() {
		return this.naoDian;
	}

	public void setNaoDian(Boolean naoDian) {
		this.naoDian = naoDian;
	}

	public Boolean getCcbt() {
		return this.ccbt;
	}

	public void setCcbt(Boolean ccbt) {
		this.ccbt = ccbt;
	}

	public Boolean getNaoRenZhi() {
		return this.naoRenZhi;
	}

	public void setNaoRenZhi(Boolean naoRenZhi) {
		this.naoRenZhi = naoRenZhi;
	}

	public Boolean getXinLiCePing() {
		return this.xinLiCePing;
	}

	public void setXinLiCePing(Boolean xinLiCePing) {
		this.xinLiCePing = xinLiCePing;
	}

	public Boolean getYingYan() {
		return this.yingYan;
	}

	public void setYingYan(Boolean yingYan) {
		this.yingYan = yingYan;
	}

	public Boolean getHrv() {
		return this.hrv;
	}

	public void setHrv(Boolean hrv) {
		this.hrv = hrv;
	}

	public String getYongHuId() {
		return this.yongHuId;
	}

	public void setYongHuId(String yongHuId) {
		this.yongHuId = yongHuId;
	}

	public String getXingMing() {
		return this.xingMing;
	}

	public void setXingMing(String xingMing) {
		this.xingMing = xingMing;
	}

	public Integer getXingBie() {
		return this.xingBie;
	}

	public void setXingBie(Integer xingBie) {
		this.xingBie = xingBie;
	}

	public Integer getChuShengNian() {
		return this.chuShengNian;
	}

	public void setChuShengNian(Integer chuShengNian) {
		this.chuShengNian = chuShengNian;
	}

	public Integer getChuShengYue() {
		return this.chuShengYue;
	}

	public void setChuShengYue(Integer chuShengYue) {
		this.chuShengYue = chuShengYue;
	}

	public Integer getChuShengRi() {
		return this.chuShengRi;
	}

	public void setChuShengRi(Integer chuShengRi) {
		this.chuShengRi = chuShengRi;
	}

	public String getJingShenKeYiSheng() {
		return this.jingShenKeYiSheng;
	}

	public void setJingShenKeYiSheng(String jingShenKeYiSheng) {
		this.jingShenKeYiSheng = jingShenKeYiSheng;
	}

	public String getCePingShi() {
		return this.cePingShi;
	}

	public void setCePingShi(String cePingShi) {
		this.cePingShi = cePingShi;
	}

	public Timestamp getShouZhenRiQi() {
		return this.shouZhenRiQi;
	}

	public void setShouZhenRiQi(Timestamp shouZhenRiQi) {
		this.shouZhenRiQi = shouZhenRiQi;
	}

	public Integer getYiYuanId() {
		return this.yiYuanId;
	}

	public void setYiYuanId(Integer yiYuanId) {
		this.yiYuanId = yiYuanId;
	}

	public Boolean getIsGuiDang() {
		return this.isGuiDang;
	}

	public void setIsGuiDang(Boolean isGuiDang) {
		this.isGuiDang = isGuiDang;
	}

	public Timestamp getGdRiQi() {
		return this.gdRiQi;
	}

	public void setGdRiQi(Timestamp gdRiQi) {
		this.gdRiQi = gdRiQi;
	}

	public String getKeShi() {
		return this.keShi;
	}

	public void setKeShi(String keShi) {
		this.keShi = keShi;
	}

	public String getZhuanKeYiSheng() {
		return this.zhuanKeYiSheng;
	}

	public void setZhuanKeYiSheng(String zhuanKeYiSheng) {
		this.zhuanKeYiSheng = zhuanKeYiSheng;
	}

}