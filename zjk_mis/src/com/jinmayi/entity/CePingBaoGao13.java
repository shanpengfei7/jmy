package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao13 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao13 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer siWei;
	private Integer xingWei;
	private Integer sum;
	private String zhiDaoYiJian;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao13() {
	}

	/** minimal constructor */
	public CePingBaoGao13(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao13(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer siWei, Integer xingWei, Integer sum,
			String zhiDaoYiJian, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.siWei = siWei;
		this.xingWei = xingWei;
		this.sum = sum;
		this.zhiDaoYiJian = zhiDaoYiJian;
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

	public Integer getSiWei() {
		return this.siWei;
	}

	public void setSiWei(Integer siWei) {
		this.siWei = siWei;
	}

	public Integer getXingWei() {
		return this.xingWei;
	}

	public void setXingWei(Integer xingWei) {
		this.xingWei = xingWei;
	}

	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getZhiDaoYiJian() {
		return this.zhiDaoYiJian;
	}

	public void setZhiDaoYiJian(String zhiDaoYiJian) {
		this.zhiDaoYiJian = zhiDaoYiJian;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}