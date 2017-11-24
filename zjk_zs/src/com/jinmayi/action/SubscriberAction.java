package com.jinmayi.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinmayi.entity.Admin;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.entity.Logininformation;
import com.jinmayi.entity.Statistical;
import com.jinmayi.service.EmployeeService;
import com.jinmayi.service.EnterpriseService;
import com.jinmayi.service.StatisticalService;
import com.jinmayi.service.SubscriberService;
import com.jinmayi.util.VerifyCodeUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class SubscriberAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @throws Exception
	 */
	public void verCode() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 220, h = 40;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		if (password.equals(password2)) {
			Short s1 = 1;
			Enterprise e = new Enterprise();
			e.setUsername(username);
			e.setPassword(password);
			e.setIsconnect(s1);
			e.setCreatetime(System.currentTimeMillis());
			e.setCreateadminid(0);
			e.setScannumber(0);
			e.setUsecount(0);
			e.setUnusecount(0);
			e.setQrcodecount(0);
			if (subscriberService.register(e) > 0) {
				nextUrl = "pages/login/login.jsp";
				return NONE;
			} else {
				return LOGIN;
			}
		} else {
			return LOGIN;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String adminlogin() throws Exception {

		// 验证码转成小写
		String verCode = code.toLowerCase();
		// 获取服务器中的验证码
		String random = ServletActionContext.getRequest().getSession().getAttribute("verCode").toString().toLowerCase();
		// 判断用户名是否为空
		if (username.equals("")) {
			error = "用户名不能为空，请输入！";
			return LOGIN;
		}
		// 判断认证码是否为空
		else if (code.equals("")) {
			error = "验证码不能为空，请输入！";
			return LOGIN;
		}
		// 判断验证码是否输入正确，如果不正确返回错误结果
		else if (!verCode.equals(random)) {
			error = "验证码输入不正确，请重新输入！";
			code = "";
			return LOGIN;
		} else {
			Admin admin = subscriberService.findAdminByUsernameAndPassword(username, password);
			if (admin != null) {
				session.setMaxInactiveInterval(3600);
				session.setAttribute("adminId", admin.getId());
				session.setAttribute("islogin", 1);
				return "adminok";
			} else {
				return LOGIN;
			}

		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String employeelogin() throws Exception {

		// 判断用户名是否为空
		if (username.equals("")) {
			error = "用户名不能为空，请输入！";
			return LOGIN;
		}
		// 判断用户名是否为空
		if (password.equals("")) {
			error = "密码不能为空，请输入！";
			return LOGIN;
		}
		// 判断认证码是否为空
		else if (encode.equals("")) {
			error = "企业码不能为空，请输入！";
			return LOGIN;
		} else {
			employee = employeeService.findEmployeeByUsernameAndPassword(username, password, encode);
			if (employee != null) {
				session.setMaxInactiveInterval(3600);
				session.setAttribute("employeeId", employee.getId());
				session.setAttribute("enterpriseId", employee.getEnterpriseid());
				session.setAttribute("islogin", 1);

				Short s3 = 3;
				Long time = null;
				String lastip = null;
				logininformation = subscriberService.getLastLoginInfo(s3, employee.getId());
				if (logininformation != null) {
					time = logininformation.getNowtime();
					lastip = logininformation.getNowip();
				}
				subscriberService.saveLoginInfo(lastip, request.getRemoteAddr(), time, "", s3, employee.getId());

				return "employee";
			} else {
				return LOGIN;
			}

		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		// 验证码转成小写
		String verCode = code.toLowerCase();
		// 获取服务器中的验证码
		String random = ServletActionContext.getRequest().getSession().getAttribute("verCode").toString().toLowerCase();
		// 判断用户名是否为空
		if (username.equals("")) {
			error = "用户名不能为空，请输入！";
			return LOGIN;
		}
		// 判断认证码是否为空
		else if (code.equals("")) {
			error = "验证码不能为空，请输入！";
			return LOGIN;
		}
		// 判断验证码是否输入正确，如果不正确返回错误结果
		else if (!verCode.equals(random)) {
			error = "验证码输入不正确，请重新输入！";
			code = "";
			return LOGIN;
		} else {
			enterprise = subscriberService.findEnterpriseByUsernameAndPassword(username, password);
			if (enterprise != null) {
				role = enterprise.getRole();
				session.setMaxInactiveInterval(3600);
				session.setAttribute("enterpriseId", enterprise.getId());
				session.setAttribute("islogin", 1);
//				// 第一次登陆
//				if (enterprise.getIsconnect() == 1) {
//					operate = 7;
//					return "first";
//				}
//				// 登陆成功
//				else {
//					return SUCCESS;
//				}
				return SUCCESS;
			} else {
				error = "用户名或密码错误！";
				return LOGIN;
			}
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String welcome() throws Exception {
		session.setAttribute("role", role);

		String sessionId = null;
		// 角色
		Short r = 0;
		try {
			sessionId = session.getAttribute("employeeId").toString();
			Employee e = employeeService.getEmployeeById(Integer.parseInt(sessionId));
			enterprise = enterpriseService.getEnterpriseById(e.getEnterpriseid());
			r = 3;
		} catch (Exception e) {
			try {
				sessionId = session.getAttribute("enterpriseId").toString();
				enterprise = enterpriseService.getEnterpriseById(Integer.parseInt(sessionId));
				r = 2;
			} catch (Exception ex) {
				try {
					sessionId = session.getAttribute("adminId").toString();
					r = 1;
				} catch (Exception exc) {
					sessionId = "0";
				}
			}
		}

		// 角色id
		Integer rid = Integer.parseInt(sessionId);

		logininformation = subscriberService.getLastLoginInfo(r, rid);
		Long time = null;
		String lastip = null;
		if (logininformation != null) {
			time = logininformation.getNowtime();
			lastip = logininformation.getNowip();
		}
		subscriberService.saveLoginInfo(lastip, request.getRemoteAddr(), time, "", r, rid);

		if (role == 1) {
			return "manu";
		}
		// 返回代理商
		else if (role == 2) {
			return "agent";
		}
		// 返回经销商
		else if (role == 4) {
			return "retailer";
		}
		// 返回管理员
		else {
			return "admin";
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception {
		String sessionId = null;
		// 角色
		Short r = 0;
		try {
			sessionId = session.getAttribute("employeeId").toString();
			Employee e = employeeService.getEmployeeById(Integer.parseInt(sessionId));
			enterprise = enterpriseService.getEnterpriseById(e.getEnterpriseid());
			r = 3;
		} catch (Exception e) {
			try {
				sessionId = session.getAttribute("enterpriseId").toString();
				enterprise = enterpriseService.getEnterpriseById(Integer.parseInt(sessionId));
				r = 2;
			} catch (Exception ex) {
				try {
					sessionId = session.getAttribute("adminId").toString();
					r = 1;
				} catch (Exception exc) {
					sessionId = "0";
				}
			}
		}

		// 角色id
		Integer rid = Integer.parseInt(sessionId);

		logininformation = subscriberService.getLastLoginInfo(r, rid);
		if (r == 1) {
			statistical = statisticalService.getsStatistical();
			return "adminindex";
		} else {
			return "index";
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String leave() throws Exception {
		session.invalidate();
		if (role == 0) {
			return "admin";
		} else if (role == 2) {
			return "employeelogin";
		} else {
			return INPUT;
		}
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	@Resource
	private SubscriberService subscriberService;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 验证码
	private String code;
	// 企业码
	private String encode;
	// 错误的字符串
	private String error;
	// 表的主键
	private int id;
	// 登陆的角色
	private Short role = 0;
	private String password2;
	private String nextUrl;
	private Enterprise enterprise;
	private Logininformation logininformation;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private StatisticalService statisticalService;

	private Statistical statistical;
	private Employee employee;
	private Integer operate;

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Statistical getStatistical() {
		return statistical;
	}

	public void setStatistical(Statistical statistical) {
		this.statistical = statistical;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Logininformation getLogininformation() {
		return logininformation;
	}

	public void setLogininformation(Logininformation logininformation) {
		this.logininformation = logininformation;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

}
