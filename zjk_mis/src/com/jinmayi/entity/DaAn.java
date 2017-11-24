package com.jinmayi.entity;

/**
 * DaAn entity. @author MyEclipse Persistence Tools
 */

public class DaAn implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer tiHao;
	private Integer jiChuXinXiId;
	private String daAn;
	private Integer liangBiaoId;
	private Integer ciShu;

	// Constructors

	@Override
	public String toString() {
		return "DaAn [id=" + id + ", isDelete=" + isDelete + ", tiHao=" + tiHao
				+ ", jiChuXinXiId=" + jiChuXinXiId + ", daAn=" + daAn
				+ ", liangBiaoId=" + liangBiaoId + ", ciShu=" + ciShu + "]";
	}

	/** default constructor */
	public DaAn() {
	}

	/** full constructor */
	public DaAn(Integer id, Boolean isDelete, Integer tiHao,
			Integer jiChuXinXiId, String daAn, Integer liangBiaoId,
			Integer ciShu) {
		this.id = id;
		this.isDelete = isDelete;
		this.tiHao = tiHao;
		this.jiChuXinXiId = jiChuXinXiId;
		this.daAn = daAn;
		this.liangBiaoId = liangBiaoId;
		this.ciShu = ciShu;
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

	public Integer getTiHao() {
		return this.tiHao;
	}

	public void setTiHao(Integer tiHao) {
		this.tiHao = tiHao;
	}

	public Integer getJiChuXinXiId() {
		return this.jiChuXinXiId;
	}

	public void setJiChuXinXiId(Integer jiChuXinXiId) {
		this.jiChuXinXiId = jiChuXinXiId;
	}

	public String getDaAn() {
		return this.daAn;
	}

	public void setDaAn(String daAn) {
		this.daAn = daAn;
	}

	public Integer getLiangBiaoId() {
		return this.liangBiaoId;
	}

	public void setLiangBiaoId(Integer liangBiaoId) {
		this.liangBiaoId = liangBiaoId;
	}

	public Integer getCiShu() {
		return this.ciShu;
	}

	public void setCiShu(Integer ciShu) {
		this.ciShu = ciShu;
	}

}