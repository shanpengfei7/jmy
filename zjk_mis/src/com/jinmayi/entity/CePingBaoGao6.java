package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao6 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao6 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Double p;
	private Double e;
	private Double n;
	private Double l;
	private String yiJianP;
	private String yiJianE;
	private String yiJianN;
	private String yiJianL;
	private String belongP;
	private String belongE;
	private String belongN;
	private String belongL;
	private Timestamp riQi;
	private Double py;
	private Double ey;
	private Double ny;
	private Double ly;

	// Constructors

	/** default constructor */
	public CePingBaoGao6() {
	}

	/** minimal constructor */
	public CePingBaoGao6(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao6(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Double p, Double e, Double n, Double l,
			String yiJianP, String yiJianE, String yiJianN, String yiJianL,
			String belongP, String belongE, String belongN, String belongL,
			Timestamp riQi, Double py, Double ey, Double ny, Double ly) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.p = p;
		this.e = e;
		this.n = n;
		this.l = l;
		this.yiJianP = yiJianP;
		this.yiJianE = yiJianE;
		this.yiJianN = yiJianN;
		this.yiJianL = yiJianL;
		this.belongP = belongP;
		this.belongE = belongE;
		this.belongN = belongN;
		this.belongL = belongL;
		this.riQi = riQi;
		this.py = py;
		this.ey = ey;
		this.ny = ny;
		this.ly = ly;
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

	public Double getP() {
		return this.p;
	}

	public void setP(Double p) {
		this.p = p;
	}

	public Double getE() {
		return this.e;
	}

	public void setE(Double e) {
		this.e = e;
	}

	public Double getN() {
		return this.n;
	}

	public void setN(Double n) {
		this.n = n;
	}

	public Double getL() {
		return this.l;
	}

	public void setL(Double l) {
		this.l = l;
	}

	public String getYiJianP() {
		return this.yiJianP;
	}

	public void setYiJianP(String yiJianP) {
		this.yiJianP = yiJianP;
	}

	public String getYiJianE() {
		return this.yiJianE;
	}

	public void setYiJianE(String yiJianE) {
		this.yiJianE = yiJianE;
	}

	public String getYiJianN() {
		return this.yiJianN;
	}

	public void setYiJianN(String yiJianN) {
		this.yiJianN = yiJianN;
	}

	public String getYiJianL() {
		return this.yiJianL;
	}

	public void setYiJianL(String yiJianL) {
		this.yiJianL = yiJianL;
	}

	public String getBelongP() {
		return this.belongP;
	}

	public void setBelongP(String belongP) {
		this.belongP = belongP;
	}

	public String getBelongE() {
		return this.belongE;
	}

	public void setBelongE(String belongE) {
		this.belongE = belongE;
	}

	public String getBelongN() {
		return this.belongN;
	}

	public void setBelongN(String belongN) {
		this.belongN = belongN;
	}

	public String getBelongL() {
		return this.belongL;
	}

	public void setBelongL(String belongL) {
		this.belongL = belongL;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

	public Double getPy() {
		return this.py;
	}

	public void setPy(Double py) {
		this.py = py;
	}

	public Double getEy() {
		return this.ey;
	}

	public void setEy(Double ey) {
		this.ey = ey;
	}

	public Double getNy() {
		return this.ny;
	}

	public void setNy(Double ny) {
		this.ny = ny;
	}

	public Double getLy() {
		return this.ly;
	}

	public void setLy(Double ly) {
		this.ly = ly;
	}

}