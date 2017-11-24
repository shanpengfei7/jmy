package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao8 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao8 implements java.io.Serializable {

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
	private Integer sum;
	private String yiJian;

	// Constructors

	/** default constructor */
	public CePingBaoGao8() {
	}

	/** minimal constructor */
	public CePingBaoGao8(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao8(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Timestamp riQi, Integer sum, String yiJian) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.riQi = riQi;
		this.sum = sum;
		this.yiJian = yiJian;
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

	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getYiJian() {
		return this.yiJian;
	}

	public void setYiJian(String yiJian) {
		this.yiJian = yiJian;
	}

}