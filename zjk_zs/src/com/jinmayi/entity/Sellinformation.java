package com.jinmayi.entity;


/**
 * Qrcode entity. @author MyEclipse Persistence Tools
 */

public class Sellinformation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer enterpriseid;
	private Integer employeeid;
	private Integer qrcodeid;
	private Long time;
	private String place;
	private Enterprise enterprise;
	private Employee employee;
	private Qrcode qrcode;

	// Constructors

	/** default constructor */
	public Sellinformation() {
	}

	public Sellinformation(Integer id, Integer enterpriseid,
			Integer employeeid, Integer qrcodeid, Long time, String place,
			Enterprise enterprise, Employee employee, Qrcode qrcode) {
		super();
		this.id = id;
		this.enterpriseid = enterpriseid;
		this.employeeid = employeeid;
		this.qrcodeid = qrcodeid;
		this.time = time;
		this.place = place;
		this.enterprise = enterprise;
		this.employee = employee;
		this.qrcode = qrcode;
	}

	@Override
	public String toString() {
		return "PackageInformation [id=" + id + ", enterpriseid="
				+ enterpriseid + ", employeeid=" + employeeid + ", qrcodeid="
				+ qrcodeid + ", time=" + time + ", place=" + place
				+ ", enterprise=" + enterprise + ", employee=" + employee
				+ ", qrcode=" + qrcode + "]";
	}

	public Integer getId() {
		return id;
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

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getQrcodeid() {
		return qrcodeid;
	}

	public void setQrcodeid(Integer qrcodeid) {
		this.qrcodeid = qrcodeid;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Qrcode getQrcode() {
		return qrcode;
	}

	public void setQrcode(Qrcode qrcode) {
		this.qrcode = qrcode;
	}

}