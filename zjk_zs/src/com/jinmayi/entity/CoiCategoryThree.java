package com.jinmayi.entity;

/**
 * CoiCategoryThree entity. @author MyEclipse Persistence Tools
 */

public class CoiCategoryThree implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String oldCode;
	private String code;
	private String fullCode;
	private String name;
	private Integer pid;
	private Integer level;
	private Short status;
	private Short isdel;
	private String remarks;
	private String pcode;

	// Constructors

	/** default constructor */
	public CoiCategoryThree() {
	}

	/** full constructor */
	public CoiCategoryThree(String oldCode, String code, String fullCode, String name, Integer pid, Integer level,
			Short status, Short isdel, String remarks, String pcode) {
		this.oldCode = oldCode;
		this.code = code;
		this.fullCode = fullCode;
		this.name = name;
		this.pid = pid;
		this.level = level;
		this.status = status;
		this.isdel = isdel;
		this.remarks = remarks;
		this.pcode = pcode;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOldCode() {
		return this.oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullCode() {
		return this.fullCode;
	}

	public void setFullCode(String fullCode) {
		this.fullCode = fullCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Short isdel) {
		this.isdel = isdel;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPcode() {
		return this.pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

}