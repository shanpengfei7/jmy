package com.jinmayi.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Admin;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.StatisticalService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 对企业用户的操作
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class EnterpriseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		if (id == null || id.equals("")) {
			try {
				id = Integer.parseInt(session.getAttribute("enterpriseId").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		enterprise = enterpriseService.getEnterpriseById(id);
		if (operate == 5) {
			return SUCCESS;
		} else if (operate == 55) {
			return "edit";
		} else {
			return "add";
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pswd() throws Exception {
		if (password1.equals(password2)) {
			if (id == null || id.equals("")) {
				try {
					id = Integer.parseInt(session.getAttribute("enterpriseId").toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Enterprise en = enterpriseService.getEnterpriseById(id);
			if (password.equals(en.getPassword())) {
				Enterprise e = new Enterprise();
				e.setId(id);
				e.setPassword(password1);
				enterpriseService.changePassword(e);
				nextUrl = "enterprise-show.php?operate=5";
				return NONE;
			} else {
				error = "输入的密码与原密码不一致！";
				return SUCCESS;
			}
		} else {
			// 不一致
			error = "两次输入的新密码不一致！";
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		Enterprise en = enterpriseService.getEnterpriseById(id);
		Enterprise e = new Enterprise();
		Short s0 = 0;
		e.setId(id);
		e.setInformation(information);
		e.setIsconnect(en.getIsconnect());
		e.setStatus(s0);
		e.setIsdelete(s0);
		e.setUpdatetime(System.currentTimeMillis());
		e.setUpdateadminid(0);
		e.setName(name);
		e.setPhonenumber(phonenumber);
		e.setAddress(address);
		e.setCompany(company);
		e.setRole(role);
		enterpriseService.updateEnterprise(e);

		nextUrl = "enterprise-show.php?operate=5";
		return "none";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {

		Enterprise e = new Enterprise();
		Short s0 = 0;
		Short s1 = 1;
		e.setId(id);
		e.setInformation(information);
		if (operate == 7) {
			e.setIsconnect(s1);
		} else {
			e.setIsconnect(s0);
		}
		e.setStatus(s0);
		e.setIsdelete(s0);
		e.setUpdatetime(System.currentTimeMillis());
		e.setUpdateadminid(0);
		e.setName(name);
		e.setPhonenumber(phonenumber);
		e.setAddress(address);
		e.setCompany(company);
		e.setRole(role);
		Integer result = enterpriseService.updateEnterprise(e);

		if (result > 0) {
			if (operate == 7) {
				session.setAttribute("role", role);
				nextUrl = "pages/role/welcome.jsp";
			} else {
				nextUrl = "login-index.php";
			}
			return "none";
		} else {
			return INPUT;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// 如果pageNow当前页面为空，则设为0
		if (pageNow == null) {
			pageNow = 1;
		}
		// 如果pageSize一页显示多少条信息为空，则显示10条
		if (pageSize == null) {
			pageSize = 10;
		}

		if (keyword == null || keyword.equals("")) {
			keyword = "";
		}
		// 得到总条数
		rowCount = enterpriseService.getEnterprise(role, keyword);
		if (rowCount > 0) {
			enterprises = enterpriseService.getEnterprise(pageNow, pageSize, role, keyword);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String status() throws Exception {
		Enterprise en = new Enterprise();
		en.setId(id);
		if (operate == 5) {
			enterpriseService.changeStatus(en);
			nextUrl = "enterprise-list.php?role=" + role;
			return NONE;
		} else if (operate == 6) {
			enterpriseService.changeStatus1(en);
			nextUrl = "enterprise-list.php?role=" + role;
			return NONE;
		} else {
			nextUrl = "enterprise-list.php?role=" + role;
			return NONE;
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String con() throws Exception {
		Enterprise e = new Enterprise();
		e.setId(id);
		enterpriseService.changeConnect(e);
		statisticalService.updateEnterpriseCount();
		nextUrl = "enterprise-list.php?role=" + role;
		return NONE;
	}

	@Resource
	private EnterpriseService enterpriseService;

	@Resource
	private StatisticalService statisticalService;

	private Integer id;
	private String company;
	private String code;
	private String address;
	private String information;
	private String name;
	private String phonenumber;
	private Short role;
	private String username;
	private String password;
	private String password1;
	private String password2;
	private Integer isconnect;
	private Integer status;
	private Integer isdelete;
	private List<Enterprise> enterprises;
	private Enterprise enterprise;
	private Admin createadmin;
	private String error;
	private String nextUrl;
	private Integer operate;

	private Integer pageNow;
	private Integer pageSize;
	private Integer rowCount;
	private String keyword;
	private Integer pageCount;

	HttpSession session = ServletActionContext.getRequest().getSession();

	public Integer getPageCount() {
		pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getOperate() {
		return operate;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public Admin getCreateadmin() {
		return createadmin;
	}

	public void setCreateadmin(Admin createadmin) {
		this.createadmin = createadmin;
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Integer getIsconnect() {
		return isconnect;
	}

	public void setIsconnect(Integer isconnect) {
		this.isconnect = isconnect;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
