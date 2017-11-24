package com.jinmayi.entity;

/**
 * YiYuan entity. @author MyEclipse Persistence Tools
 */

public class YiYuan implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String mingCheng;
	private String daiHao;
	private String sheng;
	private String shi;
	private String xian;
	private String lianXiDianHua;
	private Integer dengLuId;
	private Integer todayCount;
	private Boolean isUse;

	// Constructors

	/** default constructor */
	public YiYuan() {
	}

	/** minimal constructor */
	public YiYuan(Integer id, Boolean isDelete, String mingCheng,
			String daiHao, String sheng, String shi, String xian,
			String lianXiDianHua, Integer dengLuId, Boolean isUse) {
		this.id = id;
		this.isDelete = isDelete;
		this.mingCheng = mingCheng;
		this.daiHao = daiHao;
		this.sheng = sheng;
		this.shi = shi;
		this.xian = xian;
		this.lianXiDianHua = lianXiDianHua;
		this.dengLuId = dengLuId;
		this.isUse = isUse;
	}

	/** full constructor */
	public YiYuan(Integer id, Boolean isDelete, String mingCheng,
			String daiHao, String sheng, String shi, String xian,
			String lianXiDianHua, Integer dengLuId, Integer todayCount,
			Boolean isUse) {
		this.id = id;
		this.isDelete = isDelete;
		this.mingCheng = mingCheng;
		this.daiHao = daiHao;
		this.sheng = sheng;
		this.shi = shi;
		this.xian = xian;
		this.lianXiDianHua = lianXiDianHua;
		this.dengLuId = dengLuId;
		this.todayCount = todayCount;
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

	public String getDaiHao() {
		return this.daiHao;
	}

	public void setDaiHao(String daiHao) {
		this.daiHao = daiHao;
	}

	public String getSheng() {
		return this.sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return this.shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getXian() {
		return this.xian;
	}

	public void setXian(String xian) {
		this.xian = xian;
	}

	public String getLianXiDianHua() {
		return this.lianXiDianHua;
	}

	public void setLianXiDianHua(String lianXiDianHua) {
		this.lianXiDianHua = lianXiDianHua;
	}

	public Integer getDengLuId() {
		return this.dengLuId;
	}

	public void setDengLuId(Integer dengLuId) {
		this.dengLuId = dengLuId;
	}

	public Integer getTodayCount() {
		return this.todayCount;
	}

	public void setTodayCount(Integer todayCount) {
		this.todayCount = todayCount;
	}

	public Boolean getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Boolean isUse) {
		this.isUse = isUse;
	}

}