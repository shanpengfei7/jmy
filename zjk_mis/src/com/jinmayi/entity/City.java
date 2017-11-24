package com.jinmayi.entity;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cityId;
	private String cityName;
	private String provinceId;
	private String firstLetter;
	private Integer isHot;
	private Integer state;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Integer cityId, String cityName, String provinceId,
			Integer isHot, Integer state) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.isHot = isHot;
		this.state = state;
	}

	/** full constructor */
	public City(Integer cityId, String cityName, String provinceId,
			String firstLetter, Integer isHot, Integer state) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.firstLetter = firstLetter;
		this.isHot = isHot;
		this.state = state;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getFirstLetter() {
		return this.firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public Integer getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}