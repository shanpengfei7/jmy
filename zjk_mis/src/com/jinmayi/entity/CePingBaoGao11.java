package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao11 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao11 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer sum;
	private Integer qingGanPingDan;
	private Integer siWeiPinFa;
	private Integer yiZhiQueFa;
	private Integer xingQuSheJiao;
	private Integer zhuYiZhangAi;
	private String show;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao11() {
	}

	@Override
	public String toString() {
		return "CePingBaoGao11 [id=" + id + ", isDelete=" + isDelete
				+ ", ciShu=" + ciShu + ", jiChuXinXiId=" + jiChuXinXiId
				+ ", sum=" + sum + ", qingGanPingDan=" + qingGanPingDan
				+ ", siWeiPinFa=" + siWeiPinFa + ", yiZhiQueFa=" + yiZhiQueFa
				+ ", xingQuSheJiao=" + xingQuSheJiao + ", zhuYiZhangAi="
				+ zhuYiZhangAi + ", show=" + show + ", riQi=" + riQi + "]";
	}

	/** minimal constructor */
	public CePingBaoGao11(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao11(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer sum, Integer qingGanPingDan,
			Integer siWeiPinFa, Integer yiZhiQueFa, Integer xingQuSheJiao,
			Integer zhuYiZhangAi, String show, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.sum = sum;
		this.qingGanPingDan = qingGanPingDan;
		this.siWeiPinFa = siWeiPinFa;
		this.yiZhiQueFa = yiZhiQueFa;
		this.xingQuSheJiao = xingQuSheJiao;
		this.zhuYiZhangAi = zhuYiZhangAi;
		this.show = show;
		this.riQi = riQi;
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

	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getQingGanPingDan() {
		return this.qingGanPingDan;
	}

	public void setQingGanPingDan(Integer qingGanPingDan) {
		this.qingGanPingDan = qingGanPingDan;
	}

	public Integer getSiWeiPinFa() {
		return this.siWeiPinFa;
	}

	public void setSiWeiPinFa(Integer siWeiPinFa) {
		this.siWeiPinFa = siWeiPinFa;
	}

	public Integer getYiZhiQueFa() {
		return this.yiZhiQueFa;
	}

	public void setYiZhiQueFa(Integer yiZhiQueFa) {
		this.yiZhiQueFa = yiZhiQueFa;
	}

	public Integer getXingQuSheJiao() {
		return this.xingQuSheJiao;
	}

	public void setXingQuSheJiao(Integer xingQuSheJiao) {
		this.xingQuSheJiao = xingQuSheJiao;
	}

	public Integer getZhuYiZhangAi() {
		return this.zhuYiZhangAi;
	}

	public void setZhuYiZhangAi(Integer zhuYiZhangAi) {
		this.zhuYiZhangAi = zhuYiZhangAi;
	}

	public String getShow() {
		return this.show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}