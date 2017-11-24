package com.jinmayi.entity;

/**
 * KeShi entity. @author MyEclipse Persistence Tools
 */

public class KeShi implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String mingCheng;
	private String yiYuan;
	private Integer yiYuanId;
	private Boolean isUse;

	// Constructors

	/** default constructor */
	public KeShi() {
	}

	/** full constructor */
	public KeShi(Integer id, Boolean isDelete, String mingCheng, String yiYuan,
			Integer yiYuanId, Boolean isUse) {
		this.id = id;
		this.isDelete = isDelete;
		this.mingCheng = mingCheng;
		this.yiYuan = yiYuan;
		this.yiYuanId = yiYuanId;
		this.isUse = isUse;
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

	public String getMingCheng() {
		return this.mingCheng;
	}

	public void setMingCheng(String mingCheng) {
		this.mingCheng = mingCheng;
	}

	public String getYiYuan() {
		return this.yiYuan;
	}

	public void setYiYuan(String yiYuan) {
		this.yiYuan = yiYuan;
	}

	public Integer getYiYuanId() {
		return this.yiYuanId;
	}

	public void setYiYuanId(Integer yiYuanId) {
		this.yiYuanId = yiYuanId;
	}

	public Boolean getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Boolean isUse) {
		this.isUse = isUse;
	}

}