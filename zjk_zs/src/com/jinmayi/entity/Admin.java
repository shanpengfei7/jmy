package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private Short isdelete;
	private Short status;
	private Long createtime;
	private Integer createadminid;
	private Long updatetime;
	private Integer updateadminid;
	private Admin createadmin;
	private Admin updateadmin;
	private List<Enterprise> createenterprises = new ArrayList<Enterprise>();
	private List<Enterprise> updateenterprises = new ArrayList<Enterprise>();
	// Constructors

	/** default constructor */
	public Admin() {
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", isdelete=" + isdelete
				+ ", status=" + status + ", createtime=" + createtime + ", createadminid=" + createadminid
				+ ", updatetime=" + updatetime + ", updateadminid=" + updateadminid + ", createadmin=" + createadmin
				+ ", updateadmin=" + updateadmin + ", createenterprises=" + createenterprises + ", updateenterprises="
				+ updateenterprises + "]";
	}

	public Admin getCreateadmin() {
		return createadmin;
	}

	public void setCreateadmin(Admin createadmin) {
		this.createadmin = createadmin;
	}

	public Admin getUpdateadmin() {
		return updateadmin;
	}

	public void setUpdateadmin(Admin updateadmin) {
		this.updateadmin = updateadmin;
	}

	public List<Enterprise> getCreateenterprises() {
		return createenterprises;
	}

	public void setCreateenterprises(List<Enterprise> createenterprises) {
		this.createenterprises = createenterprises;
	}

	public List<Enterprise> getUpdateenterprises() {
		return updateenterprises;
	}

	public void setUpdateenterprises(List<Enterprise> updateenterprises) {
		this.updateenterprises = updateenterprises;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateadminid() {
		return this.createadminid;
	}

	public void setCreateadminid(Integer createadminid) {
		this.createadminid = createadminid;
	}

	public Long getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getUpdateadminid() {
		return this.updateadminid;
	}

	public void setUpdateadminid(Integer updateadminid) {
		this.updateadminid = updateadminid;
	}

}