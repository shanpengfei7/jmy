package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao7 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao7 implements java.io.Serializable {

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
	private Double jiaoLvYouLv;
	private Double queFaHuoLi;
	private Double siWeiZhangAi;
	private Double jiHuoXing;
	private Double diDuiCaiYi;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao7() {
	}

	/** minimal constructor */
	public CePingBaoGao7(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao7(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer sum, Double jiaoLvYouLv,
			Double queFaHuoLi, Double siWeiZhangAi, Double jiHuoXing,
			Double diDuiCaiYi, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.sum = sum;
		this.jiaoLvYouLv = jiaoLvYouLv;
		this.queFaHuoLi = queFaHuoLi;
		this.siWeiZhangAi = siWeiZhangAi;
		this.jiHuoXing = jiHuoXing;
		this.diDuiCaiYi = diDuiCaiYi;
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

	public Double getJiaoLvYouLv() {
		return this.jiaoLvYouLv;
	}

	public void setJiaoLvYouLv(Double jiaoLvYouLv) {
		this.jiaoLvYouLv = jiaoLvYouLv;
	}

	public Double getQueFaHuoLi() {
		return this.queFaHuoLi;
	}

	public void setQueFaHuoLi(Double queFaHuoLi) {
		this.queFaHuoLi = queFaHuoLi;
	}

	public Double getSiWeiZhangAi() {
		return this.siWeiZhangAi;
	}

	public void setSiWeiZhangAi(Double siWeiZhangAi) {
		this.siWeiZhangAi = siWeiZhangAi;
	}

	public Double getJiHuoXing() {
		return this.jiHuoXing;
	}

	public void setJiHuoXing(Double jiHuoXing) {
		this.jiHuoXing = jiHuoXing;
	}

	public Double getDiDuiCaiYi() {
		return this.diDuiCaiYi;
	}

	public void setDiDuiCaiYi(Double diDuiCaiYi) {
		this.diDuiCaiYi = diDuiCaiYi;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}