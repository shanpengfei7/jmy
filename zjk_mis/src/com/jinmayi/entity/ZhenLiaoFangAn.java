package com.jinmayi.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * ZhenLiaoFangAn entity. @author MyEclipse Persistence Tools
 */

public class ZhenLiaoFangAn implements java.io.Serializable {

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
	private Integer fuZhenShiJian;
	private String jianCeXiangMu;
	private String xinLiCePingXiangMu;
	private String xinShenTiaoJie;
	private String xinShenZhenDuan;
	private Boolean huiFangZhuangTai;
	private String huiFangNeiRong;
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
	private List<YaoWuZhiLiao> yaoWuZhiLiaos = new ArrayList<YaoWuZhiLiao>();

	// Constructors

	@Override
	public String toString() {
		return "ZhenLiaoFangAn [id=" + id + ", isDelete=" + isDelete
				+ ", ciShu=" + ciShu + ", jiChuXinXiId=" + jiChuXinXiId
				+ ", riQi=" + riQi + ", fuZhenShiJian=" + fuZhenShiJian
				+ ", jianCeXiangMu=" + jianCeXiangMu + ", xinLiCePingXiangMu="
				+ xinLiCePingXiangMu + ", xinShenTiaoJie=" + xinShenTiaoJie
				+ ", xinShenZhenDuan=" + xinShenZhenDuan
				+ ", huiFangZhuangTai=" + huiFangZhuangTai
				+ ", huiFangNeiRong=" + huiFangNeiRong + ", yongHuId="
				+ yongHuId + ", xingMing=" + xingMing + ", xingBie=" + xingBie
				+ ", chuShengNian=" + chuShengNian + ", chuShengYue="
				+ chuShengYue + ", chuShengRi=" + chuShengRi
				+ ", jingShenKeYiSheng=" + jingShenKeYiSheng + ", cePingShi="
				+ cePingShi + ", shouZhenRiQi=" + shouZhenRiQi + ", yiYuanId="
				+ yiYuanId + ", isGuiDang=" + isGuiDang + ", gdRiQi=" + gdRiQi
				+ ", yaoWuZhiLiaos=" + yaoWuZhiLiaos + "]";
	}

	public List<YaoWuZhiLiao> getYaoWuZhiLiaos() {
		return yaoWuZhiLiaos;
	}

	public void setYaoWuZhiLiaos(List<YaoWuZhiLiao> yaoWuZhiLiaos) {
		this.yaoWuZhiLiaos = yaoWuZhiLiaos;
	}

	/** default constructor */
	public ZhenLiaoFangAn() {
	}

	/** minimal constructor */
	public ZhenLiaoFangAn(Integer id, Boolean isDelete, Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public ZhenLiaoFangAn(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Timestamp riQi, Integer fuZhenShiJian,
			String jianCeXiangMu, String xinLiCePingXiangMu,
			String xinShenTiaoJie, String xinShenZhenDuan,
			Boolean huiFangZhuangTai, String huiFangNeiRong, String yongHuId,
			String xingMing, Integer xingBie, Integer chuShengNian,
			Integer chuShengYue, Integer chuShengRi, String jingShenKeYiSheng,
			String cePingShi, Timestamp shouZhenRiQi, Integer yiYuanId,
			Boolean isGuiDang, Timestamp gdRiQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.riQi = riQi;
		this.fuZhenShiJian = fuZhenShiJian;
		this.jianCeXiangMu = jianCeXiangMu;
		this.xinLiCePingXiangMu = xinLiCePingXiangMu;
		this.xinShenTiaoJie = xinShenTiaoJie;
		this.xinShenZhenDuan = xinShenZhenDuan;
		this.huiFangZhuangTai = huiFangZhuangTai;
		this.huiFangNeiRong = huiFangNeiRong;
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

	public Integer getFuZhenShiJian() {
		return this.fuZhenShiJian;
	}

	public void setFuZhenShiJian(Integer fuZhenShiJian) {
		this.fuZhenShiJian = fuZhenShiJian;
	}

	public String getJianCeXiangMu() {
		return this.jianCeXiangMu;
	}

	public void setJianCeXiangMu(String jianCeXiangMu) {
		this.jianCeXiangMu = jianCeXiangMu;
	}

	public String getXinLiCePingXiangMu() {
		return this.xinLiCePingXiangMu;
	}

	public void setXinLiCePingXiangMu(String xinLiCePingXiangMu) {
		this.xinLiCePingXiangMu = xinLiCePingXiangMu;
	}

	public String getXinShenTiaoJie() {
		return this.xinShenTiaoJie;
	}

	public void setXinShenTiaoJie(String xinShenTiaoJie) {
		this.xinShenTiaoJie = xinShenTiaoJie;
	}

	public String getXinShenZhenDuan() {
		return this.xinShenZhenDuan;
	}

	public void setXinShenZhenDuan(String xinShenZhenDuan) {
		this.xinShenZhenDuan = xinShenZhenDuan;
	}

	public Boolean getHuiFangZhuangTai() {
		return this.huiFangZhuangTai;
	}

	public void setHuiFangZhuangTai(Boolean huiFangZhuangTai) {
		this.huiFangZhuangTai = huiFangZhuangTai;
	}

	public String getHuiFangNeiRong() {
		return this.huiFangNeiRong;
	}

	public void setHuiFangNeiRong(String huiFangNeiRong) {
		this.huiFangNeiRong = huiFangNeiRong;
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

}