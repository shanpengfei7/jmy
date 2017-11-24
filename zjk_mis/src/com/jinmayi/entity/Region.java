package com.jinmayi.entity;

/**
 * Region entity. @author MyEclipse Persistence Tools
 */

public class Region implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer regionId;
	private String regionName;
	private Integer cityId;

	// Constructors

	/** default constructor */
	public Region() {
	}

	/** full constructor */
	public Region(Integer regionId, String regionName, Integer cityId) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.cityId = cityId;
	}

	// Property accessors

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}