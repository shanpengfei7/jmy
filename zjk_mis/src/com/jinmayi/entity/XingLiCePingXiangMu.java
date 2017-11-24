package com.jinmayi.entity;


/**
 * XingLiCePingXiangMu entity. @author MyEclipse Persistence Tools
 */

public class XingLiCePingXiangMu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Boolean isJianCe;
	private Integer liangBiaoId;
	private Integer jianCeXiangMu;
	private LiangBiao liangBiao;

	// Constructors

	/** default constructor */
	public XingLiCePingXiangMu() {
	}

	@Override
	public String toString() {
		return "XingLiCePingXiangMu [id=" + id + ", isDelete=" + isDelete
				+ ", isJianCe=" + isJianCe + ", liangBiaoId=" + liangBiaoId
				+ ", jianCeXiangMu=" + jianCeXiangMu + ", liangBiao="
				+ liangBiao + "]";
	}

	/** minimal constructor */
	public XingLiCePingXiangMu(Integer id, Boolean isDelete, Boolean isJianCe) {
		this.id = id;
		this.isDelete = isDelete;
		this.isJianCe = isJianCe;
	}

	/** full constructor */
	public XingLiCePingXiangMu(Integer id, Boolean isDelete, Boolean isJianCe,
			Integer liangBiaoId, Integer jianCeXiangMu) {
		this.id = id;
		this.isDelete = isDelete;
		this.isJianCe = isJianCe;
		this.liangBiaoId = liangBiaoId;
		this.jianCeXiangMu = jianCeXiangMu;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public LiangBiao getLiangBiao() {
		return liangBiao;
	}

	public void setLiangBiao(LiangBiao liangBiao) {
		this.liangBiao = liangBiao;
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

	public Boolean getIsJianCe() {
		return this.isJianCe;
	}

	public void setIsJianCe(Boolean isJianCe) {
		this.isJianCe = isJianCe;
	}

	public Integer getLiangBiaoId() {
		return this.liangBiaoId;
	}

	public void setLiangBiaoId(Integer liangBiaoId) {
		this.liangBiaoId = liangBiaoId;
	}

	public Integer getJianCeXiangMu() {
		return this.jianCeXiangMu;
	}

	public void setJianCeXiangMu(Integer jianCeXiangMu) {
		this.jianCeXiangMu = jianCeXiangMu;
	}

}