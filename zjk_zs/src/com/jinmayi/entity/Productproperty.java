package com.jinmayi.entity;

/**
 * Productproperty entity. @author MyEclipse Persistence Tools
 */

public class Productproperty implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String value;
	private Integer productid;
	private String description;
	private Product product;
	// Constructors

	/** default constructor */
	public Productproperty() {
	}

	@Override
	public String toString() {
		return "Productproperty [id=" + id + ", name=" + name + ", value=" + value + ", productid=" + productid
				+ ", description=" + description + ", product=" + product + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/** full constructor */
	public Productproperty(String name, String value, Integer productid, String description) {
		this.name = name;
		this.value = value;
		this.productid = productid;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}