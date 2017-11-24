package com.jinmayi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer id;
     private String name;
     private Integer isdelete;
     private Integer enterpriseid;
     private Integer sex;
     private String jobnumber;
     private String phonenumber;
     private Integer status;
     private String username;
     private String password;
     private Long createtime;
     private Integer createenterpriseid;
     private Long updatetime;
     private Integer updateenterpriseid;
     private Integer power;
	
	
	
	private Enterprise enterprise;
	private Enterprise createenterprise;
	private Enterprise updateenterprise;
	private List<Qrcode> qrcodes = new ArrayList<Qrcode>();
	private List<Circulate> dilivercirculates = new ArrayList<Circulate>();
	private List<Circulate> receivecirculates = new ArrayList<Circulate>();
	

	// Constructors
	public boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);// true 表示第i位为1,否则为0
	}

	/** default constructor */
	public Employee() {
	}

	public Employee(Integer id, String name, Integer isdelete, Integer enterpriseid, Integer sex, String jobnumber,
			String phonenumber, Integer status, String username, String password, Long createtime,
			Integer createenterpriseid, Long updatetime, Integer updateenterpriseid, Enterprise enterprise,
			Enterprise createenterprise, Enterprise updateenterprise, List<Qrcode> qrcodes,
			List<Circulate> dilivercirculates, List<Circulate> receivecirculates, Integer power) {
		super();
		this.id = id;
		this.name = name;
		this.isdelete = isdelete;
		this.enterpriseid = enterpriseid;
		this.sex = sex;
		this.jobnumber = jobnumber;
		this.phonenumber = phonenumber;
		this.status = status;
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.createenterpriseid = createenterpriseid;
		this.updatetime = updatetime;
		this.updateenterpriseid = updateenterpriseid;
		this.enterprise = enterprise;
		this.createenterprise = createenterprise;
		this.updateenterprise = updateenterprise;
		this.qrcodes = qrcodes;
		this.dilivercirculates = dilivercirculates;
		this.receivecirculates = receivecirculates;
		this.power = power;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", isdelete=" + isdelete + ", enterpriseid=" + enterpriseid
				+ ", sex=" + sex + ", jobnumber=" + jobnumber + ", phonenumber=" + phonenumber + ", status=" + status
				+ ", username=" + username + ", password=" + password + ", createtime=" + createtime
				+ ", createenterpriseid=" + createenterpriseid + ", updatetime=" + updatetime + ", updateenterpriseid="
				+ updateenterpriseid + ", enterprise=" + enterprise + ", createenterprise=" + createenterprise
				+ ", updateenterprise=" + updateenterprise + ", qrcodes=" + qrcodes + ", dilivercirculates="
				+ dilivercirculates + ", receivecirculates=" + receivecirculates + "]";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Enterprise getCreateenterprise() {
		return createenterprise;
	}

	public void setCreateenterprise(Enterprise createenterprise) {
		this.createenterprise = createenterprise;
	}

	public Enterprise getUpdateenterprise() {
		return updateenterprise;
	}

	public void setUpdateenterprise(Enterprise updateenterprise) {
		this.updateenterprise = updateenterprise;
	}

	public List<Qrcode> getQrcodes() {
		return qrcodes;
	}

	public void setQrcodes(List<Qrcode> qrcodes) {
		this.qrcodes = qrcodes;
	}

	public List<Circulate> getDilivercirculates() {
		return dilivercirculates;
	}

	public void setDilivercirculates(List<Circulate> dilivercirculates) {
		this.dilivercirculates = dilivercirculates;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getEnterpriseid() {
		return this.enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}


	public String getJobnumber() {
		return this.jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getCreateenterpriseid() {
		return this.createenterpriseid;
	}

	public void setCreateenterpriseid(Integer createenterpriseid) {
		this.createenterpriseid = createenterpriseid;
	}

	public Long getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getUpdateenterpriseid() {
		return this.updateenterpriseid;
	}

	public void setUpdateenterpriseid(Integer updateenterpriseid) {
		this.updateenterpriseid = updateenterpriseid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

}