package com.jinmayi.entity;

/**
 * Qrcodeproperty entity. @author MyEclipse Persistence Tools
 */

public class Qrcodeproperty implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String value;
	private Integer qrcodeid;
	private String description;
	private Qrcode qrcode;
	// Constructors

	/** default constructor */
	public Qrcodeproperty() {
	}

	@Override
	public String toString() {
		return "Qrcodeproperty [id=" + id + ", name=" + name + ", value=" + value + ", qrcodeid=" + qrcodeid
				+ ", description=" + description + ", qrcode=" + qrcode + "]";
	}

	public Qrcode getQrcode() {
		return qrcode;
	}

	public void setQrcode(Qrcode qrcode) {
		this.qrcode = qrcode;
	}

	/** full constructor */
	public Qrcodeproperty(String name, String value, Integer qrcodeid, String description) {
		this.name = name;
		this.value = value;
		this.qrcodeid = qrcodeid;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getQrcodeid() {
		return this.qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}