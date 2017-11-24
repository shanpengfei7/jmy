package com.jinmayi.entity;


/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Makeqrcode implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer enterpriseid;
	private Integer productid;
	private Integer count;
	private Short isprint;
	private Product product;
	private Enterprise enterprise;

	// Constructors

	/** default constructor */
	public Makeqrcode() {
	}

	@Override
	public String toString() {
		return "Makeqrcode [id=" + id + ", enterpriseid=" + enterpriseid
				+ ", productid=" + productid + ", count=" + count
				+ ", isprint=" + isprint + ", product=" + product
				+ ", enterprise=" + enterprise + "]";
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Short getIsprint() {
		return isprint;
	}

	public void setIsprint(Short isprint) {
		this.isprint = isprint;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}