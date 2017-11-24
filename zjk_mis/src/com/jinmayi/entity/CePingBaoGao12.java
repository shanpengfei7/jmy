package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao12 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao12 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer huanJue;
	private Integer wangXiang;
	private Integer guaiYiXingWei;
	private Integer yangXingSiWei;
	private Integer sum;
	private String show;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao12() {
	}

	/** minimal constructor */
	public CePingBaoGao12(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao12(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer huanJue, Integer wangXiang,
			Integer guaiYiXingWei, Integer yangXingSiWei, Integer sum,
			String show, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.huanJue = huanJue;
		this.wangXiang = wangXiang;
		this.guaiYiXingWei = guaiYiXingWei;
		this.yangXingSiWei = yangXingSiWei;
		this.sum = sum;
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

	public Integer getHuanJue() {
		return this.huanJue;
	}

	public void setHuanJue(Integer huanJue) {
		this.huanJue = huanJue;
	}

	public Integer getWangXiang() {
		return this.wangXiang;
	}

	public void setWangXiang(Integer wangXiang) {
		this.wangXiang = wangXiang;
	}

	public Integer getGuaiYiXingWei() {
		return this.guaiYiXingWei;
	}

	public void setGuaiYiXingWei(Integer guaiYiXingWei) {
		this.guaiYiXingWei = guaiYiXingWei;
	}

	public Integer getYangXingSiWei() {
		return this.yangXingSiWei;
	}

	public void setYangXingSiWei(Integer yangXingSiWei) {
		this.yangXingSiWei = yangXingSiWei;
	}

	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
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