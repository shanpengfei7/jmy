package com.jinmayi.entity;

/**
 * Repertory entity. @author MyEclipse Persistence Tools
 */

public class Repertory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer enterpriseid;
	private Short isdelete;
	private Integer qrcodeid;
	private Qrcode qrcode;
	
	// Constructors

	/** default constructor */

	// Property accessors


	public Repertory(Long id, Integer enterpriseid, Short isdelete,
			Integer qrcodeid) {
		super();
		this.id = id;
		this.enterpriseid = enterpriseid;
		this.isdelete = isdelete;
		this.qrcodeid = qrcodeid;
	}

	@Override
	public String toString() {
		return "Repertory [id=" + id + ", enterpriseid=" + enterpriseid
				+ ", isdelete=" + isdelete + ", qrcodeid=" + qrcodeid
				+ ", qrcode=" + qrcode + "]";
	}

	public Repertory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}


	public Integer getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public Qrcode getQrcode() {
		return qrcode;
	}

	public void setQrcode(Qrcode qrcode) {
		this.qrcode = qrcode;
	}

}