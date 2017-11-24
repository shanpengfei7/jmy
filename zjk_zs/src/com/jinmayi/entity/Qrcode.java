package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Qrcode entity. @author MyEclipse Persistence Tools
 */

public class Qrcode implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String qrcode;
	private Integer productid;
	private Short issell;
	private Short isevaluate;
	private Integer scannumber;
	private Integer parentid;
	private Short hasson;
	private Short hasparent;
	private Integer soncount;
	private Product product;
	private Qrcode son;
	private Qrcode parent;
	private Integer enterpriseid;
	private Enterprise enterprise;
	private List<Qrcodeproperty> qrcodeproperties = new ArrayList<Qrcodeproperty>();
	private List<Circulate> circulates = new ArrayList<Circulate>();
	private Short isuse;
	private Double price;
	private Repertory repertory;
	private Integer makeqrcodeid;
	private Sellinformation sellinformation;
	private List<Qrcode> sons = new ArrayList<Qrcode>();

	// Constructors

	/** default constructor */
	public Qrcode() {
	}

	@Override
	public String toString() {
		return "Qrcode [id=" + id + ", qrcode=" + qrcode + ", productid="
				+ productid + ", issell=" + issell + ", isevaluate="
				+ isevaluate + ", scannumber=" + scannumber + ", parentid="
				+ parentid + ", hasson=" + hasson + ", hasparent=" + hasparent
				+ ", soncount=" + soncount + ", product=" + product + ", son="
				+ son + ", parent=" + parent + ", enterpriseid=" + enterpriseid
				+ ", enterprise=" + enterprise + ", qrcodeproperties="
				+ qrcodeproperties + ", circulates=" + circulates + ", isuse="
				+ isuse + ", price=" + price + ", repertory=" + repertory
				+ ", makeqrcodeid=" + makeqrcodeid + "]";
	}

	public Repertory getRepertory() {
		return repertory;
	}

	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Qrcode getSon() {
		return son;
	}

	public void setSon(Qrcode son) {
		this.son = son;
	}

	public Qrcode getParent() {
		return parent;
	}

	public void setParent(Qrcode parent) {
		this.parent = parent;
	}

	public List<Qrcodeproperty> getQrcodeproperties() {
		return qrcodeproperties;
	}

	public void setQrcodeproperties(List<Qrcodeproperty> qrcodeproperties) {
		this.qrcodeproperties = qrcodeproperties;
	}

	public List<Circulate> getCirculates() {
		return circulates;
	}

	public void setCirculates(List<Circulate> circulates) {
		this.circulates = circulates;
	}

	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getScannumber() {
		return this.scannumber;
	}

	public void setScannumber(Integer scannumber) {
		this.scannumber = scannumber;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Short getIssell() {
		return issell;
	}

	public void setIssell(Short issell) {
		this.issell = issell;
	}

	public Short getIsevaluate() {
		return isevaluate;
	}

	public void setIsevaluate(Short isevaluate) {
		this.isevaluate = isevaluate;
	}

	public Short getHasson() {
		return hasson;
	}

	public void setHasson(Short hasson) {
		this.hasson = hasson;
	}

	public Short getHasparent() {
		return hasparent;
	}

	public void setHasparent(Short hasparent) {
		this.hasparent = hasparent;
	}

	public Integer getSoncount() {
		return this.soncount;
	}

	public void setSoncount(Integer soncount) {
		this.soncount = soncount;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Short getIsuse() {
		return isuse;
	}

	public void setIsuse(Short isuse) {
		this.isuse = isuse;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMakeqrcodeid() {
		return makeqrcodeid;
	}

	public void setMakeqrcodeid(Integer makeqrcodeid) {
		this.makeqrcodeid = makeqrcodeid;
	}

	public Sellinformation getSellinformation() {
		return sellinformation;
	}

	public void setSellinformation(Sellinformation sellinformation) {
		this.sellinformation = sellinformation;
	}

	public List<Qrcode> getSons() {
		return sons;
	}

	public void setSons(List<Qrcode> sons) {
		this.sons = sons;
	}

}