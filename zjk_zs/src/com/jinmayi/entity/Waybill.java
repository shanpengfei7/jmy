package com.jinmayi.entity;

import java.util.List;

/**
 * Waybill entity. @author MyEclipse Persistence Tools
 */

public class Waybill implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String qrcode;
	private String number;
	private String receiveplace;
	private String receivephonenumber;
	private String receiveemployeename;
	private String receiveenterprisename;
	private Short isdelete;
	private Integer receiveenterpriseid;
	private Integer receiveemployeeid;
	private Integer deliverenterpriseid;
	private Integer deliveremployeeid;
	private Enterprise receiveenterprise;
	private Employee receiveemployee;
	private Enterprise deliverenterprise;
	private Employee deliveremployee;
	private Integer willreceiveenterpriseid;
	private Long delivertime;
	private Long receivetime;
	private Short isreceive;
	private Enterprise willreceiveenterprise;
	private Long printtime;
	private Integer printemployeeid;
	private Integer printenterpriseid;
	private Employee printemployee;
	private Enterprise printenterprise;
	private String deliverplace;

	private List<Circulate> circulates;

	// Constructors

	/** default constructor */
	public Waybill() {
	}


	@Override
	public String toString() {
		return "Waybill [id=" + id + ", qrcode=" + qrcode + ", number="
				+ number + ", receiveplace=" + receiveplace
				+ ", receivephonenumber=" + receivephonenumber
				+ ", receiveemployeename=" + receiveemployeename
				+ ", receiveenterprisename=" + receiveenterprisename
				+ ", isdelete=" + isdelete + ", receiveenterpriseid="
				+ receiveenterpriseid + ", receiveemployeeid="
				+ receiveemployeeid + ", deliverenterpriseid="
				+ deliverenterpriseid + ", deliveremployeeid="
				+ deliveremployeeid + ", receiveenterprise="
				+ receiveenterprise + ", receiveemployee=" + receiveemployee
				+ ", deliverenterprise=" + deliverenterprise
				+ ", deliveremployee=" + deliveremployee
				+ ", willreceiveenterpriseid=" + willreceiveenterpriseid
				+ ", delivertime=" + delivertime + ", receivetime="
				+ receivetime + ", isreceive=" + isreceive
				+ ", willreceiveenterprise=" + willreceiveenterprise
				+ ", printtime=" + printtime + ", printemployeeid="
				+ printemployeeid + ", printenterpriseid=" + printenterpriseid
				+ ", printemployee=" + printemployee + ", printenterprise="
				+ printenterprise + ", circulates=" + circulates + "]";
	}


	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public Waybill(Integer id, String qrcode, String number,
			Integer circulateid, String receiveplace,
			String receivephonenumber, String receiveemployeename,
			String receiveenterprisename) {
		super();
		this.id = id;
		this.qrcode = qrcode;
		this.number = number;
		this.receiveplace = receiveplace;
		this.receivephonenumber = receivephonenumber;
		this.receiveemployeename = receiveemployeename;
		this.receiveenterprisename = receiveenterprisename;
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

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getReceiveplace() {
		return receiveplace;
	}

	public void setReceiveplace(String receiveplace) {
		this.receiveplace = receiveplace;
	}

	public String getReceivephonenumber() {
		return receivephonenumber;
	}

	public void setReceivephonenumber(String receivephonenumber) {
		this.receivephonenumber = receivephonenumber;
	}

	public String getReceiveemployeename() {
		return receiveemployeename;
	}

	public void setReceiveemployeename(String receiveemployeename) {
		this.receiveemployeename = receiveemployeename;
	}

	public String getReceiveenterprisename() {
		return receiveenterprisename;
	}

	public void setReceiveenterprisename(String receiveenterprisename) {
		this.receiveenterprisename = receiveenterprisename;
	}

	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getReceiveenterpriseid() {
		return receiveenterpriseid;
	}

	public void setReceiveenterpriseid(Integer receiveenterpriseid) {
		this.receiveenterpriseid = receiveenterpriseid;
	}

	public Integer getReceiveemployeeid() {
		return receiveemployeeid;
	}

	public void setReceiveemployeeid(Integer receiveemployeeid) {
		this.receiveemployeeid = receiveemployeeid;
	}

	public Integer getDeliverenterpriseid() {
		return deliverenterpriseid;
	}

	public void setDeliverenterpriseid(Integer deliverenterpriseid) {
		this.deliverenterpriseid = deliverenterpriseid;
	}

	public Integer getDeliveremployeeid() {
		return deliveremployeeid;
	}

	public void setDeliveremployeeid(Integer deliveremployeeid) {
		this.deliveremployeeid = deliveremployeeid;
	}

	public List<Circulate> getCirculates() {
		return circulates;
	}

	public void setCirculates(List<Circulate> circulates) {
		this.circulates = circulates;
	}

	public Enterprise getReceiveenterprise() {
		return receiveenterprise;
	}

	public void setReceiveenterprise(Enterprise receiveenterprise) {
		this.receiveenterprise = receiveenterprise;
	}

	public Employee getReceiveemployee() {
		return receiveemployee;
	}

	public void setReceiveemployee(Employee receiveemployee) {
		this.receiveemployee = receiveemployee;
	}

	public Enterprise getDeliverenterprise() {
		return deliverenterprise;
	}

	public void setDeliverenterprise(Enterprise deliverenterprise) {
		this.deliverenterprise = deliverenterprise;
	}

	public Employee getDeliveremployee() {
		return deliveremployee;
	}

	public void setDeliveremployee(Employee deliveremployee) {
		this.deliveremployee = deliveremployee;
	}

	public Integer getWillreceiveenterpriseid() {
		return willreceiveenterpriseid;
	}

	public void setWillreceiveenterpriseid(Integer willreceiveenterpriseid) {
		this.willreceiveenterpriseid = willreceiveenterpriseid;
	}

	public Long getDelivertime() {
		return delivertime;
	}

	public void setDelivertime(Long delivertime) {
		this.delivertime = delivertime;
	}

	public Long getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Long receivetime) {
		this.receivetime = receivetime;
	}

	public Short getIsreceive() {
		return isreceive;
	}

	public void setIsreceive(Short isreceive) {
		this.isreceive = isreceive;
	}

	public Enterprise getWillreceiveenterprise() {
		return willreceiveenterprise;
	}

	public void setWillreceiveenterprise(Enterprise willreceiveenterprise) {
		this.willreceiveenterprise = willreceiveenterprise;
	}

	public Long getPrinttime() {
		return printtime;
	}

	public void setPrinttime(Long printtime) {
		this.printtime = printtime;
	}

	public Integer getPrintemployeeid() {
		return printemployeeid;
	}

	public void setPrintemployeeid(Integer printemployeeid) {
		this.printemployeeid = printemployeeid;
	}

	public Integer getPrintenterpriseid() {
		return printenterpriseid;
	}

	public void setPrintenterpriseid(Integer printenterpriseid) {
		this.printenterpriseid = printenterpriseid;
	}

	public Employee getPrintemployee() {
		return printemployee;
	}

	public void setPrintemployee(Employee printemployee) {
		this.printemployee = printemployee;
	}

	public Enterprise getPrintenterprise() {
		return printenterprise;
	}

	public void setPrintenterprise(Enterprise printenterprise) {
		this.printenterprise = printenterprise;
	}


	public String getDeliverplace() {
		return deliverplace;
	}


	public void setDeliverplace(String deliverplace) {
		this.deliverplace = deliverplace;
	}

}