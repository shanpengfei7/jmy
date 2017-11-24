package com.jinmayi.entity;

/**
 * Evaluate entity. @author MyEclipse Persistence Tools
 */

public class Evaluate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer productid;
	private String evaluate1;
	private String evaluate2;
	private String evaluate3;
	private String evaluate4;
	private String phonenumber;

	// Constructors

	/** default constructor */
	public Evaluate() {
	}

	/** full constructor */
	public Evaluate(Integer productid, String evaluate1, String evaluate2,
			String evaluate3, String evaluate4, String phonenumber) {
		this.productid = productid;
		this.evaluate1 = evaluate1;
		this.evaluate2 = evaluate2;
		this.evaluate3 = evaluate3;
		this.evaluate4 = evaluate4;
		this.phonenumber = phonenumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getEvaluate1() {
		return evaluate1;
	}

	public void setEvaluate1(String evaluate1) {
		this.evaluate1 = evaluate1;
	}

	public String getEvaluate2() {
		return evaluate2;
	}

	public void setEvaluate2(String evaluate2) {
		this.evaluate2 = evaluate2;
	}

	public String getEvaluate3() {
		return evaluate3;
	}

	public void setEvaluate3(String evaluate3) {
		this.evaluate3 = evaluate3;
	}

	public String getEvaluate4() {
		return evaluate4;
	}

	public void setEvaluate4(String evaluate4) {
		this.evaluate4 = evaluate4;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	// Property accessors

}