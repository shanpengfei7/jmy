package com.jinmayi.action.app;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * app端，员工的操作管理
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppEmployeeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSONObject json = new JSONObject();

	/**
	 * 员工登录 
	 * @throws Exception
	 */
	public void login() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Employee e = employeeService.findEmployeeByUsernameAndPassword(username, password, encode);
			if (e == null) {
				json.put("message", "用户名或密码或企业码错误!");
				json.put("status", 0);
				json.put("data", "");
			} else {
				Enterprise en = enterpriseService.getEnterpriseById(e.getEnterpriseid());
				JSONObject j = new JSONObject();
				j.put("enterpriseid", e.getEnterpriseid());
				j.put("employeeid", e.getId());
				j.put("name", e.getName());
				j.put("sex", e.getSex());
				j.put("jobnumber", e.getJobnumber());
				j.put("phonenumber", e.getPhonenumber());
				j.put("address", en.getAddress());
				j.put("power", e.getPower());
				json.put("message", "登陆成功");
				json.put("status", 1);
				json.put("data", j);
			}
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "登陆未成功！");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 查看员工的信息
	 * @throws Exception
	 */
	public void info() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Employee e = employeeService.getEmployeeById(employeeid);

			if (e == null) {
				json.put("message", "");
				json.put("status", 0);
				json.put("data", "");
			} else {
				JSONObject j = new JSONObject();
				j.put("enterpriseid", e.getEnterpriseid());
				j.put("employeeid", e.getId());
				if (e.getName() == null) {
					j.put("name", "");
				} else {
					j.put("name", e.getName());
				}
				j.put("sex", e.getSex());
				if (e.getJobnumber() == null) {
					j.put("jobnumber", "");
				} else {
					j.put("jobnumber", e.getJobnumber());
				}
				if (e.getPhonenumber() == null) {
					j.put("phonenumber", "");
				} else {
					j.put("phonenumber", e.getPhonenumber());
				}
				j.put("power", e.getPower());
				if (e.getUsername() == null) {
					j.put("username", "");
				} else {
					j.put("username", e.getUsername());
				}
				json.put("message", "");
				json.put("status", 1);
				json.put("data", j);
			}
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 修改员工的信息
	 * @throws Exception
	 */
	public void upinfo() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Employee employee = employeeService.getEmployeeById(employeeid);
			Employee e = new Employee();
			e.setId(employee.getId());
			e.setName(name);
			e.setSex(sex);
			e.setPhonenumber(phonenumber);
			e.setJobnumber(jobnumber);
			e.setStatus(employee.getStatus());
			e.setUpdatetime(System.currentTimeMillis());
			e.setUpdateenterpriseid(employee.getUpdateenterpriseid());
			e.setPower(employee.getPower());

			employeeService.updateEmployee(e);

			json.put("message", "修改成功！");
			json.put("status", 1);
			JSONObject j = new JSONObject();
			j.put("enterpriseid", e.getEnterpriseid());
			j.put("employeeid", e.getId());
			if (name == null) {
				j.put("name", "");
			} else {
				j.put("name", name);
			}
			j.put("sex", sex);
			if (jobnumber == null) {
				j.put("jobnumber", "");
			} else {
				j.put("jobnumber", jobnumber);
			}
			if (phonenumber == null) {
				j.put("phonenumber", "");
			} else {
				j.put("phonenumber", phonenumber);
			}
			j.put("power", e.getPower());
			if (e.getUsername() == null) {
				j.put("username", "");
			} else {
				j.put("username", e.getUsername());
			}
			json.put("data", j);
			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "修改未成功！");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 修改密码
	 * @throws Exception
	 */
	public void pswd() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (password1.equals(password2)) {
				Employee e = employeeService.getEmployeeById(employeeid);
				if (e == null) {
					json.put("message", "修改失败，请重新打开该修改页或联系管理员!");
					json.put("status", 0);
					json.put("data", "");
				} else {
					if (e.getPassword().equals(password)) {
						e.setPassword(password1);
						employeeService.updatePassword(e);
						json.put("message", "修改成功！");
						json.put("status", 1);
						json.put("data", "");
					} else {
						json.put("message", "修改失败,原密码输入错误！");
						json.put("status", 0);
						json.put("data", "");
					}
				}
			} else {
				json.put("message", "修改失败,两次密码输入不一致！");
				json.put("status", 0);
				json.put("data", "");
			}

			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "修改未成功！");
			json.put("data", "");
			out.print(json);
			out.flush();
			out.close();
			throw ex;
		} finally {
			out.flush();
			out.close();
		}
	}

	private Integer employeeid;
	private String username;
	private String password;
	private String password1;
	private String password2;
	private String name;
	private Integer sex;
	private String phonenumber;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private EnterpriseService enterpriseService;
	HttpServletRequest request;
	private HttpServletResponse response;
	// 验证码
	private String code;
	// 企业码
	private String encode;
	private String jobnumber;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

}
