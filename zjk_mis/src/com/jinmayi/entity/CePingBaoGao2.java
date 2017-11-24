package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao2 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao2 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer result;
	private Integer flag;
	private String belong;
	private String yiJian;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao2() {
	}

	/** minimal constructor */
	public CePingBaoGao2(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao2(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer result, Integer flag, String belong,
			String yiJian, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.result = result;
		this.flag = flag;
		this.belong = belong;
		this.yiJian = yiJian;
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

	public Integer getResult() {
		return this.result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getBelong() {
		return this.belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getYiJian() {
		return this.yiJian;
	}

	public void setYiJian(String yiJian) {
		this.yiJian = yiJian;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}