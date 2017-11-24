package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Enterprise entity. @author MyEclipse Persistence Tools
 */

public class Enterprise implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String information;
	private String qrcode;
	private Short isconnect;
	private Short status;
	private Short isdelete;
	private String username;
	private String password;
	private Long createtime;
	private Integer createadminid;
	private Long updatetime;
	private Integer updateadminid;
	private String name;
	private String phonenumber;
	private String address;
	private String company;
	private String code;
	private Short role;
	private Admin createadmin;
	private Admin updateadmin;
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Employee> createemployees = new ArrayList<Employee>();
	private List<Employee> updateemployees = new ArrayList<Employee>();
	private List<Circulate> receivecirculates = new ArrayList<Circulate>();
	private Integer scannumber;
    private Integer qrcodecount;
    private Integer usecount;
    private Integer unusecount;
	// Constructors

	/** default constructor */
	public Enterprise() {
	}

	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", information=" + information + ", qrcode=" + qrcode + ", isconnect="
				+ isconnect + ", status=" + status + ", isdelete=" + isdelete + ", username=" + username + ", password="
				+ password + ", createtime=" + createtime + ", createadminid=" + createadminid + ", updatetime="
				+ updatetime + ", updateadminid=" + updateadminid + ", name=" + name + ", phonenumber=" + phonenumber
				+ ", address=" + address + ", company=" + company + ", code=" + code + ", role=" + role
				+ ", createadmin=" + createadmin + ", updateadmin=" + updateadmin + ", employees=" + employees
				+ ", createemployees=" + createemployees + ", updateemployees=" + updateemployees
				+ ", receivecirculates=" + receivecirculates + "]";
	}

	public boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);// true 表示第i位为1,否则为0
	}
	
	public Admin getCreateadmin() {
		return createadmin;
	}

	public void setCreateadmin(Admin createadmin) {
		this.createadmin = createadmin;
	}

	public Admin getUpdateadmin() {
		return updateadmin;
	}

	public void setUpdateadmin(Admin updateadmin) {
		this.updateadmin = updateadmin;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getCreateemployees() {
		return createemployees;
	}

	public void setCreateemployees(List<Employee> createemployees) {
		this.createemployees = createemployees;
	}

	public List<Employee> getUpdateemployees() {
		return updateemployees;
	}

	public void setUpdateemployees(List<Employee> updateemployees) {
		this.updateemployees = updateemployees;
	}

	public List<Circulate> getReceivecirculates() {
		return receivecirculates;
	}

	public void setReceivecirculates(List<Circulate> receivecirculates) {
		this.receivecirculates = receivecirculates;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}


	public Short getIsconnect() {
		return isconnect;
	}

	public void setIsconnect(Short isconnect) {
		this.isconnect = isconnect;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Short isdelete) {
		this.isdelete = isdelete;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateadminid() {
		return this.createadminid;
	}

	public void setCreateadminid(Integer createadminid) {
		this.createadminid = createadminid;
	}

	public Long getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getUpdateadminid() {
		return this.updateadminid;
	}

	public void setUpdateadminid(Integer updateadminid) {
		this.updateadminid = updateadminid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public Integer getScannumber() {
		return scannumber;
	}

	public void setScannumber(Integer scannumber) {
		this.scannumber = scannumber;
	}

	public Integer getQrcodecount() {
		return qrcodecount;
	}

	public void setQrcodecount(Integer qrcodecount) {
		this.qrcodecount = qrcodecount;
	}

	public Integer getUsecount() {
		return usecount;
	}

	public void setUsecount(Integer usecount) {
		this.usecount = usecount;
	}

	public Integer getUnusecount() {
		return unusecount;
	}

	public void setUnusecount(Integer unusecount) {
		this.unusecount = unusecount;
	}


}