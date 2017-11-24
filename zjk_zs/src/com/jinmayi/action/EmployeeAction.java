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
 * Ա��������Ա���Ĳ���
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
	private Integer id;// �ֵ�ǰ̨id
	private List<Employee> employees;
	private Employee employee;
	private String nextUrl;
	private Integer operate;
	private Integer isdelete;
	private Integer enterpriseid;
	private String power;
	private Enterprise enterprise;

	private Integer pageNow;// ��ǰҳ
	private Integer pageSize;// һҳ������
	private Integer rowCount;// ������
	private Integer pageCount;// ������ҳ

	private String keyword;// ��ѯ�Ĺؼ���

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
			error = "�޸�ʧ��,�����������벻һ�£�";
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
				error = "�˺�Ϊ��";
				return INPUT;
			}
			if (username == null || username.equals("")) {
				error = "�˺�Ϊ�գ�";
				return INPUT;
			}
			if (employeeService.usernameCheck(username,
					Integer.parseInt(session.getAttribute("enterpriseId").toString()))) {
				error = "���˻��Ѵ���";
				return INPUT;
			}
			Employee e = new Employee();
			e.setUsername(username);
			e.setId(id);
			employeeService.updateUsername(e);
			nextUrl = "employee-list.php";
			return NONE;
		} catch (Exception e) {
			error = "�޸�ʧ�ܣ�";
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
			error = "�˺�Ϊ��";
			return INPUT;
		}
		// Integer.parseInt(session.getAttribute("enterpriseId").toString());
		if (name == null || name.equals("")) {
			error = "����Ϊ�գ�";
			return INPUT;
		} else if (jobnumber == null || jobnumber.equals("")) {
			error = "����Ϊ�գ�";
			return INPUT;
		} else if (phonenumber == null || phonenumber.equals("")) {
			error = "�绰����Ϊ�գ�";
			return INPUT;
		} else if (username == null || username.equals("")) {
			error = "�˺�Ϊ��";
			return INPUT;
		} else if (password == null || password.equals("")) {
			error = "����Ϊ�գ�";
			return INPUT;
		} else if (password2 == null || password2.equals("")) {
			error = "ȷ������Ϊ��";
			return INPUT;
		} else if (employeeService.usernameCheck(username,
				Integer.parseInt(session.getAttribute("enterpriseId").toString()))) {
			error = "���˻��Ѵ���";
			return INPUT;
		} else
		// �ж������һ���ԣ����һ�£����Ա���
		if (password.equals(password2)) {
			if (power == null || power.equals("")) {
				error = "����ʧ��,δָ��Ա����Ȩ�ޣ�";
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
		// ������ʾ����һ�£�
		else {
			error = "����ʧ��,���벻һ�£�";
			return INPUT;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// ���pageNow��ǰҳ��Ϊ�գ�����Ϊ0
		if (pageNow == null) {
			pageNow = 1;
		}
		// ���pageSizeһҳ��ʾ��������ϢΪ�գ�����ʾ10��
		if (pageSize == null) {
			pageSize = 10;
		}
		// ��ҵid
		Integer enterpriseId = null;
		try {
			enterpriseId = Integer.parseInt(session.getAttribute("enterpriseId").toString());
		} catch (Exception e) {
			enterpriseId = enterpriseid;
		}
		// �õ�������
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
