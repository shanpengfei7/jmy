package com.jinmayi.entity;

/**
 * Statistical entity. @author MyEclipse Persistence Tools
 */

public class Statistical implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer scannumber;
	private Integer qrcodecount;
	private Integer usecount;
	private Integer unusecount;
	private Integer enterprisecount;

	// Constructors

	/** default constructor */
	public Statistical() {
	}

	/** full constructor */
	public Statistical(Integer scannumber, Integer qrcodecount, Integer usecount, Integer unusecount,
			Integer enterprisecount) {
		this.scannumber = scannumber;
		this.qrcodecount = qrcodecount;
		this.usecount = usecount;
		this.unusecount = unusecount;
		this.enterprisecount = enterprisecount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScannumber() {
		return this.scannumber;
	}

	public void setScannumber(Integer scannumber) {
		this.scannumber = scannumber;
	}

	public Integer getQrcodecount() {
		return this.qrcodecount;
	}

	public void setQrcodecount(Integer qrcodecount) {
		this.qrcodecount = qrcodecount;
	}

	public Integer getUsecount() {
		return this.usecount;
	}

	public void setUsecount(Integer usecount) {
		this.usecount = usecount;
	}

	public Integer getUnusecount() {
		return this.unusecount;
	}

	public void setUnusecount(Integer unusecount) {
		this.unusecount = unusecount;
	}

	public Integer getEnterprisecount() {
		return this.enterprisecount;
	}

	public void setEnterprisecount(Integer enterprisecount) {
		this.enterprisecount = enterprisecount;
	}

}