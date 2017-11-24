package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao14 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao14 implements java.io.Serializable {

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
	private String yiJian;
	private String jianYi;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao14() {
	}

	/** minimal constructor */
	public CePingBaoGao14(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao14(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer sum, String yiJian, String jianYi,
			Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.sum = sum;
		this.yiJian = yiJian;
		this.jianYi = jianYi;
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

	public String getYiJian() {
		return this.yiJian;
	}

	public void setYiJian(String yiJian) {
		this.yiJian = yiJian;
	}

	public String getJianYi() {
		return this.jianYi;
	}

	public void setJianYi(String jianYi) {
		this.jianYi = jianYi;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}