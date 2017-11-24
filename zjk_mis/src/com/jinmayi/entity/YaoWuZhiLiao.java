package com.jinmayi.entity;

/**
 * YaoWuZhiLiao entity. @author MyEclipse Persistence Tools
 */

public class YaoWuZhiLiao implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String yaoMing;
	private String guiGe;
	private String yongLiang;
	private String yongFa;
	private Integer zhenLiaoFangAnId;

	// Constructors

	/** default constructor */
	public YaoWuZhiLiao() {
	}

	/** minimal constructor */
	public YaoWuZhiLiao(Integer id, Boolean isDelete, String yaoMing,
			String guiGe, String yongLiang) {
		this.id = id;
		this.isDelete = isDelete;
		this.yaoMing = yaoMing;
		this.guiGe = guiGe;
		this.yongLiang = yongLiang;
	}

	/** full constructor */
	public YaoWuZhiLiao(Integer id, Boolean isDelete, String yaoMing,
			String guiGe, String yongLiang, String yongFa,
			Integer zhenLiaoFangAnId) {
		this.id = id;
		this.isDelete = isDelete;
		this.yaoMing = yaoMing;
		this.guiGe = guiGe;
		this.yongLiang = yongLiang;
		this.yongFa = yongFa;
		this.zhenLiaoFangAnId = zhenLiaoFangAnId;
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

	public String getYaoMing() {
		return this.yaoMing;
	}

	public void setYaoMing(String yaoMing) {
		this.yaoMing = yaoMing;
	}

	public String getGuiGe() {
		return this.guiGe;
	}

	public void setGuiGe(String guiGe) {
		this.guiGe = guiGe;
	}

	public String getYongLiang() {
		return this.yongLiang;
	}

	public void setYongLiang(String yongLiang) {
		this.yongLiang = yongLiang;
	}

	public String getYongFa() {
		return this.yongFa;
	}

	public void setYongFa(String yongFa) {
		this.yongFa = yongFa;
	}

	public Integer getZhenLiaoFangAnId() {
		return this.zhenLiaoFangAnId;
	}

	public void setZhenLiaoFangAnId(Integer zhenLiaoFangAnId) {
		this.zhenLiaoFangAnId = zhenLiaoFangAnId;
	}

}