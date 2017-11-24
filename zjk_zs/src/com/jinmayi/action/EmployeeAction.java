package com.jinmayi.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 员工管理，对员工的操作
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Resource
	private EmployeeService employeeService;
	private String name;
	private Integer sex;
	private String jobnumber;
	private String phonenumber;
	private String username;
	private String password;
	private String password1;
	private String password2;
	private String error;
	private Integer status;
	private Integer id;// 街道前台id
	private List<Employee> employees;
	private Employee employee;
	private String nextUrl;
	private Integer operate;
	private Integer isdelete;
	private Integer enterpriseid;
	private String power;
	private Enterprise enterprise;

	private Integer pageNow;// 当前页
	private Integer pageSize;// 一页多少条
	private Integer rowCount;// 总条数
	private Integer pageCount;// 共多少页

	private String keyword;// 查询的关键字

	HttpSession session = ServletActionContext.getRequest().getSession();

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		Employee e = new Employee();
		e.setId(id);
		employeeService.deleteEmployee(e);
		nextUrl = "employee-list.php";
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		employee = employeeService.getEmployeeById(id);
		if (operate == 4) {
			return "edit";
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (power == null || power.equals("")) {
			power="0";
		}
		String[] powers = power.split(",");
		Integer p = 0;
		for (String s : powers) {
			p += Integer.parseInt(s.trim());
		}
		Employee e = new Employee();
		e.setPower(p);
		e.setName(name);
		e.setSex(sex);
		e.setJobnumber(jobnumber);
		e.setPhonenumber(phonenumber);
		e.setStatus(status);
		e.setUpdateenterpriseid(Integer.parseInt(session.getAttribute("enterpriseId").toString()));
		e.setId(id);
		employeeService.updateEmployee(e);
		nextUrl = "employee-list.php";
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pswd() throws Exception {
		if (password1.equals(password2)) {
			Employee e = new Employee();
			e.setPassword(password1);
			e.setId(id);
			employeeService.updatePassword(e);
		} else {
			error = "修改失败,两次密码输入不一致！";
			return INPUT;
		}
		nextUrl = "employee-list.php";
		return NONE;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String username() throws Exception {
		try {
			try {
				username = username.trim();
			} catch (Exception ex) {
				error = "账号为空";
				return INPUT;
			}
			if (username == null || username.equals("")) {
				error = "账号为空！";
				return INPUT;
			}
			if (employeeService.usernameCheck(username,
					Integer.parseInt(session.getAttribute("enterpriseId").toString()))) {
				error = "该账户已存在";
				return INPUT;
			}
			Employee e = new Employee();
			e.setUsername(username);
			e.setId(id);
			employeeService.updateUsername(e);
			nextUrl = "employee-list.php";
			return NONE;
		} catch (Exception e) {
			error = "修改失败！";
			return INPUT;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("GET")) {
			return SUCCESS;
		}
		Employee e = new Employee();
		try {
			username = username.trim();
		} catch (Exception ex) {
			error = "账号为空";
			return INPUT;
		}
		// Integer.parseInt(session.getAttribute("enterpriseId").toString());
		if (name == null || name.equals("")) {
			error = "姓名为空！";
			return INPUT;
		} else if (jobnumber == null || jobnumber.equals("")) {
			error = "工号为空！";
			return INPUT;
		} else if (phonenumber == null || phonenumber.equals("")) {
			error = "电话号码为空！";
			return INPUT;
		} else if (username == null || username.equals("")) {
			error = "账号为空";
			return INPUT;
		} else if (password == null || password.equals("")) {
			error = "密码为空！";
			return INPUT;
		} else if (password2 == null || password2.equals("")) {
			error = "确认密码为空";
			return INPUT;
		} else if (employeeService.usernameCheck(username,
				Integer.parseInt(session.getAttribute("enterpriseId").toString()))) {
			error = "该账户已存在";
			return INPUT;
		} else
		// 判断密马的一致性，如果一致，可以保存
		if (password.equals(password2)) {
			if (power == null || power.equals("")) {
				error = "保存失败,未指定员工的权限！";
				return INPUT;
			}
			String[] powers = power.split(",");
			Integer p = 0;
			for (String s : powers) {
				p += Integer.parseInt(s.trim());
			}
			// Short s0 = 0;
			e.setPower(p);
			e.setPassword(password);
			e.setName(name);
			e.setSex(sex);
			e.setJobnumber(jobnumber);
			e.setUsername(username);
			e.setPhonenumber(phonenumber);
			e.setEnterpriseid(Integer.parseInt(session.getAttribute("enterpriseId").toString()));
			e.setCreatetime(System.currentTimeMillis());
			e.setCreateenterpriseid(e.getEnterpriseid());
			e.setStatus(0);
			e.setIsdelete(0);
			employeeService.save(e);
			nextUrl = "employee-list.php";
			return NONE;
		}
		// 否则提示密吗不一致，
		else {
			error = "保存失败,密码不一致！";
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
		// 企业id
		Integer enterpriseId = null;
		try {
			enterpriseId = Integer.parseInt(session.getAttribute("enterpriseId").toString());
		} catch (Exception e) {
			enterpriseId = enterpriseid;
		}
		// 得到总条数
		rowCount = employeeService.getEmployeeCount(enterpriseId, keyword);
		if (rowCount > 0) {
			employees = employeeService.getEmployees(enterpriseId, pageNow, pageSize, keyword);
		}
		return SUCCESS;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	public Integer getPageCount() {
		pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}
