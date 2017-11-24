package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao4 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao4 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer yiZhia0;
	private Integer jiReb0;
	private Integer shengWuc0;
	private Integer renZhid0;
	private Integer xiangXiange0;
	private Double yiZhia;
	private Double jiReb;
	private Double shengWuc;
	private String belong1;
	private String belong2;
	private Double renZhid;
	private Double xiangXiange;
	private Timestamp riQi;
	private String yiJian1;
	private String yiJian2;

	// Constructors

	/** default constructor */
	public CePingBaoGao4() {
	}

	/** minimal constructor */
	public CePingBaoGao4(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao4(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer yiZhia0, Integer jiReb0,
			Integer shengWuc0, Integer renZhid0, Integer xiangXiange0,
			Double yiZhia, Double jiReb, Double shengWuc, String belong1,
			String belong2, Double renZhid, Double xiangXiange, Timestamp riQi,
			String yiJian1, String yiJian2) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.yiZhia0 = yiZhia0;
		this.jiReb0 = jiReb0;
		this.shengWuc0 = shengWuc0;
		this.renZhid0 = renZhid0;
		this.xiangXiange0 = xiangXiange0;
		this.yiZhia = yiZhia;
		this.jiReb = jiReb;
		this.shengWuc = shengWuc;
		this.belong1 = belong1;
		this.belong2 = belong2;
		this.renZhid = renZhid;
		this.xiangXiange = xiangXiange;
		this.riQi = riQi;
		this.yiJian1 = yiJian1;
		this.yiJian2 = yiJian2;
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

	public Integer getYiZhia0() {
		return this.yiZhia0;
	}

	public void setYiZhia0(Integer yiZhia0) {
		this.yiZhia0 = yiZhia0;
	}

	public Integer getJiReb0() {
		return this.jiReb0;
	}

	public void setJiReb0(Integer jiReb0) {
		this.jiReb0 = jiReb0;
	}

	public Integer getShengWuc0() {
		return this.shengWuc0;
	}

	public void setShengWuc0(Integer shengWuc0) {
		this.shengWuc0 = shengWuc0;
	}

	public Integer getRenZhid0() {
		return this.renZhid0;
	}

	public void setRenZhid0(Integer renZhid0) {
		this.renZhid0 = renZhid0;
	}

	public Integer getXiangXiange0() {
		return this.xiangXiange0;
	}

	public void setXiangXiange0(Integer xiangXiange0) {
		this.xiangXiange0 = xiangXiange0;
	}

	public Double getYiZhia() {
		return this.yiZhia;
	}

	public void setYiZhia(Double yiZhia) {
		this.yiZhia = yiZhia;
	}

	public Double getJiReb() {
		return this.jiReb;
	}

	public void setJiReb(Double jiReb) {
		this.jiReb = jiReb;
	}

	public Double getShengWuc() {
		return this.shengWuc;
	}

	public void setShengWuc(Double shengWuc) {
		this.shengWuc = shengWuc;
	}

	public String getBelong1() {
		return this.belong1;
	}

	public void setBelong1(String belong1) {
		this.belong1 = belong1;
	}

	public String getBelong2() {
		return this.belong2;
	}

	public void setBelong2(String belong2) {
		this.belong2 = belong2;
	}

	public Double getRenZhid() {
		return this.renZhid;
	}

	public void setRenZhid(Double renZhid) {
		this.renZhid = renZhid;
	}

	public Double getXiangXiange() {
		return this.xiangXiange;
	}

	public void setXiangXiange(Double xiangXiange) {
		this.xiangXiange = xiangXiange;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

	public String getYiJian1() {
		return this.yiJian1;
	}

	public void setYiJian1(String yiJian1) {
		this.yiJian1 = yiJian1;
	}

	public String getYiJian2() {
		return this.yiJian2;
	}

	public void setYiJian2(String yiJian2) {
		this.yiJian2 = yiJian2;
	}

}