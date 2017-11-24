package com.jinmayi.entity;

/**
 * YaoWu entity. @author MyEclipse Persistence Tools
 */

public class YaoWu implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public YaoWu() {
	}

	/** full constructor */
	public YaoWu(Integer id, Boolean isDelete, String yaoMing, String guiGe,
			String yongLiang) {
		this.id = id;
		this.isDelete = isDelete;
		this.yaoMing = yaoMing;
		this.guiGe = guiGe;
		this.yongLiang = yongLiang;
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

}