package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Circulate entity. @author MyEclipse Persistence Tools
 */

public class Circulate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short isdelete;
	private Integer qrcodeid;
	private Integer deliveremployeeid;
	private Integer receiveemployeeid;
	private Integer receiveenterpriseid;
	private Short isreceive;
	private Long delivertime;
	private Long receivetime;
	private String deliverplace;
	private String receiveplace;
	private Qrcode qrcode;
	private Employee deliveremployee;
	private Employee receiveemployee;
	private Enterprise receiveenterprise;
	private Integer deliverenterpriseid;
	private Circulate son;
	private Circulate parent;
	private List<Waybill> waybills = new ArrayList<Waybill>();
	private Enterprise deliverenterprise;
	private Integer waybillid;
	private Integer willreceiveenterpriseid;
	private Short iswaybill;

	// Constructors

	/** default constructor */
	public Circulate() {
	}

	@Override
	public String toString() {
		return "Circulate [id=" + id + ", isdelete=" + isdelete + ", qrcodeid="
				+ qrcodeid + ", deliveremployeeid=" + deliveremployeeid
				+ ", receiveemployeeid=" + receiveemployeeid
				+ ", receiveenterpriseid=" + receiveenterpriseid
				+ ", isreceive=" + isreceive + ", delivertime=" + delivertime
				+ ", receivetime=" + receivetime + ", deliverplace="
				+ deliverplace + ", receiveplace=" + receiveplace + ", qrcode="
				+ qrcode + ", deliveremployee=" + deliveremployee
				+ ", receiveemployee=" + receiveemployee
				+ ", receiveenterprise=" + receiveenterprise
				+ ", deliverenterpriseid=" + deliverenterpriseid + ", son="
				+ son + ", parent=" + parent + ", waybills=" + waybills
				+ ", deliverenterprise=" + deliverenterprise + ", waybillid="
				+ waybillid + ", willreceiveenterpriseid="
				+ willreceiveenterpriseid + "]";
	}

	public Qrcode getQrcode() {
		return qrcode;
	}

	public void setQrcode(Qrcode qrcode) {
		this.qrcode = qrcode;
	}

	public Employee getDeliveremployee() {
		return deliveremployee;
	}

	public void setDeliveremployee(Employee deliveremployee) {
		this.deliveremployee = deliveremployee;
	}

	public Employee getReceiveemployee() {
		return receiveemployee;
	}

	public void setReceiveemployee(Employee receiveemployee) {
		this.receiveemployee = receiveemployee;
	}

	public Enterprise getReceiveenterprise() {
		return receiveenterprise;
	}

	public void setReceiveenterprise(Enterprise receiveenterprise) {
		this.receiveenterprise = receiveenterprise;
	}

	public Circulate getSon() {
		return son;
	}

	public void setSon(Circulate son) {
		this.son = son;
	}

	public Circulate getParent() {
		return parent;
	}

	public void setParent(Circulate parent) {
		this.parent = parent;
	}

	public List<Waybill> getWaybills() {
		return waybills;
	}

	public void setWaybills(List<Waybill> waybills) {
		this.waybills = waybills;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQrcodeid() {
		return this.qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public Integer getDeliveremployeeid() {
		return deliveremployeeid;
	}

	public void setDeliveremployeeid(Integer deliveremployeeid) {
		this.deliveremployeeid = deliveremployeeid;
	}

	public Integer getReceiveemployeeid() {
		return this.receiveemployeeid;
	}

	public void setReceiveemployeeid(Integer receiveemployeeid) {
		this.receiveemployeeid = receiveemployeeid;
	}

	public Integer getReceiveenterpriseid() {
		return this.receiveenterpriseid;
	}

	public void setReceiveenterpriseid(Integer receiveenterpriseid) {
		this.receiveenterpriseid = receiveenterpriseid;
	}

	public Long getDelivertime() {
		return this.delivertime;
	}

	public void setDelivertime(Long delivertime) {
		this.delivertime = delivertime;
	}

	public Long getReceivetime() {
		return this.receivetime;
	}

	public void setReceivetime(Long receivetime) {
		this.receivetime = receivetime;
	}

	public String getDeliverplace() {
		return this.deliverplace;
	}

	public void setDeliverplace(String deliverplace) {
		this.deliverplace = deliverplace;
	}

	public String getReceiveplace() {
		return this.receiveplace;
	}

	public void setReceiveplace(String receiveplace) {
		this.receiveplace = receiveplace;
	}

	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}

	public Short getIsreceive() {
		return isreceive;
	}

	public void setIsreceive(Short isreceive) {
		this.isreceive = isreceive;
	}

	public Integer getDeliverenterpriseid() {
		return deliverenterpriseid;
	}

	public void setDeliverenterpriseid(Integer deliverenterpriseid) {
		this.deliverenterpriseid = deliverenterpriseid;
	}

	public Enterprise getDeliverenterprise() {
		return deliverenterprise;
	}

	public void setDeliverenterprise(Enterprise deliverenterprise) {
		this.deliverenterprise = deliverenterprise;
	}

	public Integer getWaybillid() {
		return waybillid;
	}

	public void setWaybillid(Integer waybillid) {
		this.waybillid = waybillid;
	}

	public Integer getWillreceiveenterpriseid() {
		return willreceiveenterpriseid;
	}

	public void setWillreceiveenterpriseid(Integer willreceiveenterpriseid) {
		this.willreceiveenterpriseid = willreceiveenterpriseid;
	}

	public Short getIswaybill() {
		return iswaybill;
	}

	public void setIswaybill(Short iswaybill) {
		this.iswaybill = iswaybill;
	}

}