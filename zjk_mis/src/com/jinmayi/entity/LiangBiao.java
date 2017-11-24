package com.jinmayi.entity;

/**
 * LiangBiao entity. @author MyEclipse Persistence Tools
 */

public class LiangBiao implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String mingCheng;
	private String jianJie;
	private String yaoQiu;
	private String shiJian;
	private String zhuYiShiXiang;
	private String yingYongPingJia;

	// Constructors

	@Override
	public String toString() {
		return "LiangBiao [id=" + id + ", isDelete=" + isDelete
				+ ", mingCheng=" + mingCheng + ", jianJie=" + jianJie
				+ ", yaoQiu=" + yaoQiu + ", shiJian=" + shiJian
				+ ", zhuYiShiXiang=" + zhuYiShiXiang + ", yingYongPingJia="
				+ yingYongPingJia + "]";
	}

	/** default constructor */
	public LiangBiao() {
	}

	/** minimal constructor */
	public LiangBiao(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public LiangBiao(Integer id, Boolean isDelete, String mingCheng,
			String jianJie, String yaoQiu, String shiJian,
			String zhuYiShiXiang, String yingYongPingJia) {
		this.id = id;
		this.isDelete = isDelete;
		this.mingCheng = mingCheng;
		this.jianJie = jianJie;
		this.yaoQiu = yaoQiu;
		this.shiJian = shiJian;
		this.zhuYiShiXiang = zhuYiShiXiang;
		this.yingYongPingJia = yingYongPingJia;
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

	public String getJianJie() {
		return this.jianJie;
	}

	public void setJianJie(String jianJie) {
		this.jianJie = jianJie;
	}

	public String getYaoQiu() {
		return this.yaoQiu;
	}

	public void setYaoQiu(String yaoQiu) {
		this.yaoQiu = yaoQiu;
	}

	public String getShiJian() {
		return this.shiJian;
	}

	public void setShiJian(String shiJian) {
		this.shiJian = shiJian;
	}

	public String getZhuYiShiXiang() {
		return this.zhuYiShiXiang;
	}

	public void setZhuYiShiXiang(String zhuYiShiXiang) {
		this.zhuYiShiXiang = zhuYiShiXiang;
	}

	public String getYingYongPingJia() {
		return this.yingYongPingJia;
	}

	public void setYingYongPingJia(String yingYongPingJia) {
		this.yingYongPingJia = yingYongPingJia;
	}

}