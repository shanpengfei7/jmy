package com.jmy.entity;

public class TimeNoticeWithBLOBs extends TimeNotice {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column time_notice.content
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column time_notice.message
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	private String message;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column time_notice.content
	 * @return  the value of time_notice.content
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column time_notice.content
	 * @param content  the value for time_notice.content
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column time_notice.message
	 * @return  the value of time_notice.message
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column time_notice.message
	 * @param message  the value for time_notice.message
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}