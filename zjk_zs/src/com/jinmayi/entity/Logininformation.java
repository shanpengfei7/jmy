package com.jinmayi.entity;

/**
 * Logininformation entity. @author MyEclipse Persistence Tools
 */

public class Logininformation implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Logininformation [id=" + id + ", nowip=" + nowip + ", lasttime=" + lasttime + ", nowtime=" + nowtime
				+ ", address=" + address + ", role=" + role + ", subid=" + subid + ", lastip=" + lastip + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nowip;
	private Long lasttime;
	private Long nowtime;
	private String address;
	private Short role;
	private Integer subid;
	private String lastip;

	// Constructors

	/** default constructor */
	public Logininformation() {
	}

	/** full constructor */

	// Property accessors

	public Long getId() {
		return id;
	}

	public Logininformation(Long id, String nowip, Long lasttime, Long nowtime,
			String address, Short role, Integer subid, String lastip) {
		super();
		this.id = id;
		this.nowip = nowip;
		this.lasttime = lasttime;
		this.nowtime = nowtime;
		this.address = address;
		this.role = role;
		this.subid = subid;
		this.lastip = lastip;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNowip() {
		return nowip;
	}

	public void setNowip(String nowip) {
		this.nowip = nowip;
	}

	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}

	public Long getLasttime() {
		return lasttime;
	}

	public void setLasttime(Long lasttime) {
		this.lasttime = lasttime;
	}

	public Long getNowtime() {
		return nowtime;
	}

	public void setNowtime(Long nowtime) {
		this.nowtime = nowtime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public Integer getSubid() {
		return subid;
	}

	public void setSubid(Integer subid) {
		this.subid = subid;
	}

	
}