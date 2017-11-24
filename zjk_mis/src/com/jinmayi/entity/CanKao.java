package com.jinmayi.entity;

/**
 * CanKao entity. @author MyEclipse Persistence Tools
 */

public class CanKao implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "CanKao [id=" + id + ", isDelete=" + isDelete + ", liangBiaoId="
				+ liangBiaoId + ", zhiDaoYiJian=" + zhiDaoYiJian + ", jianYi="
				+ jianYi + ", yaoShan=" + yaoShan + "]";
	}

	private Integer id;
	private Boolean isDelete;
	private Integer liangBiaoId;
	private String zhiDaoYiJian;
	private String jianYi;
	private String yaoShan;

	// Constructors

	/** default constructor */
	public CanKao() {
	}

	/** minimal constructor */
	public CanKao(Integer id, Boolean isDelete) {
		this.id = id;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public CanKao(Integer id, Boolean isDelete, Integer liangBiaoId,
			String zhiDaoYiJian, String jianYi, String yaoShan) {
		this.id = id;
		this.isDelete = isDelete;
		this.liangBiaoId = liangBiaoId;
		this.zhiDaoYiJian = zhiDaoYiJian;
		this.jianYi = jianYi;
		this.yaoShan = yaoShan;
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

	public Integer getLiangBiaoId() {
		return this.liangBiaoId;
	}

	public void setLiangBiaoId(Integer liangBiaoId) {
		this.liangBiaoId = liangBiaoId;
	}

	public String getZhiDaoYiJian() {
		return this.zhiDaoYiJian;
	}

	public void setZhiDaoYiJian(String zhiDaoYiJian) {
		this.zhiDaoYiJian = zhiDaoYiJian;
	}

	public String getJianYi() {
		return this.jianYi;
	}

	public void setJianYi(String jianYi) {
		this.jianYi = jianYi;
	}

	public String getYaoShan() {
		return this.yaoShan;
	}

	public void setYaoShan(String yaoShan) {
		this.yaoShan = yaoShan;
	}

}