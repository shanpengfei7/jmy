package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short status;
	private Short isapply;
	private String information;
	private Short ispackage;
	private Short isdelete;
	private String name;
	private String version;
	private String description;
	private String tradename;
	private Integer enterpriseid;
	private Enterprise enterprise;
	private List<Productproperty> productproperties = new ArrayList<Productproperty>();
	private List<Qrcode> qrcodes = new ArrayList<Qrcode>();
	private String procode;
	// Constructors

	/** default constructor */
	public Product() {
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", status=" + status + ", isapply=" + isapply + ", information=" + information
				+ ", ispackage=" + ispackage + ", isdelete=" + isdelete + ", name=" + name
				+ ", version=" + version + ", description=" + description + ", tradename=" + tradename
				+ ", enterpriseid=" + enterpriseid + ", productproperties=" + productproperties + ", qrcodes=" + qrcodes
				+ "]";
	}

	public List<Productproperty> getProductproperties() {
		return productproperties;
	}

	public void setProductproperties(List<Productproperty> productproperties) {
		this.productproperties = productproperties;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getIsapply() {
		return isapply;
	}

	public void setIsapply(Short isapply) {
		this.isapply = isapply;
	}

	public Short getIspackage() {
		return ispackage;
	}

	public void setIspackage(Short ispackage) {
		this.ispackage = ispackage;
	}

	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

}