package com.jmy.entity;

public class AreaWithBLOBs extends Area {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column isp_area.name
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column isp_area.remarks
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	private String remarks;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column isp_area.name
	 * @return  the value of isp_area.name
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column isp_area.name
	 * @param name  the value for isp_area.name
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column isp_area.remarks
	 * @return  the value of isp_area.remarks
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column isp_area.remarks
	 * @param remarks  the value for isp_area.remarks
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}