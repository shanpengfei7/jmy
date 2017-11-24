package com.jinmayi.entity;

/**
 * DengLu entity. @author MyEclipse Persistence Tools
 */

public class DengLu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String dengLuHao;
	private String miMa;
	private Integer quanXian;

	// Constructors

	/** default constructor */
	public DengLu() {
	}

	/** full constructor */
	public DengLu(Integer id, Boolean isDelete, String dengLuHao, String miMa,
			Integer quanXian) {
		this.id = id;
		this.isDelete = isDelete;
		this.dengLuHao = dengLuHao;
		this.miMa = miMa;
		this.quanXian = quanXian;
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

	public String getDengLuHao() {
		return this.dengLuHao;
	}

	public void setDengLuHao(String dengLuHao) {
		this.dengLuHao = dengLuHao;
	}

	public String getMiMa() {
		return this.miMa;
	}

	public void setMiMa(String miMa) {
		this.miMa = miMa;
	}

	public Integer getQuanXian() {
		return this.quanXian;
	}

	public void setQuanXian(Integer quanXian) {
		this.quanXian = quanXian;
	}

}