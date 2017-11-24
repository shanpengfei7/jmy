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
 * ��¼
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

		// ��������ִ�
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// ����Ựsession
		HttpSession session = request.getSession(true);
		// ɾ����ǰ��
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// ����ͼƬ
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

		// ��֤��ת��Сд
		String verCode = code.toLowerCase();
		// ��ȡ�������е���֤��
		String random = ServletActionContext.getRequest().getSession().getAttribute("verCode").toString().toLowerCase();
		// �ж��û����Ƿ�Ϊ��
		if (username.equals("")) {
			error = "�û�������Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж���֤���Ƿ�Ϊ��
		else if (code.equals("")) {
			error = "��֤�벻��Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж���֤���Ƿ�������ȷ���������ȷ���ش�����
		else if (!verCode.equals(random)) {
			error = "��֤�����벻��ȷ�����������룡";
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

		// �ж��û����Ƿ�Ϊ��
		if (username.equals("")) {
			error = "�û�������Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж��û����Ƿ�Ϊ��
		if (password.equals("")) {
			error = "���벻��Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж���֤���Ƿ�Ϊ��
		else if (encode.equals("")) {
			error = "��ҵ�벻��Ϊ�գ������룡";
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
		// ��֤��ת��Сд
		String verCode = code.toLowerCase();
		// ��ȡ�������е���֤��
		String random = ServletActionContext.getRequest().getSession().getAttribute("verCode").toString().toLowerCase();
		// �ж��û����Ƿ�Ϊ��
		if (username.equals("")) {
			error = "�û�������Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж���֤���Ƿ�Ϊ��
		else if (code.equals("")) {
			error = "��֤�벻��Ϊ�գ������룡";
			return LOGIN;
		}
		// �ж���֤���Ƿ�������ȷ���������ȷ���ش�����
		else if (!verCode.equals(random)) {
			error = "��֤�����벻��ȷ�����������룡";
			code = "";
			return LOGIN;
		} else {
			enterprise = subscriberService.findEnterpriseByUsernameAndPassword(username, password);
			if (enterprise != null) {
				role = enterprise.getRole();
				session.setMaxInactiveInterval(3600);
				session.setAttribute("enterpriseId", enterprise.getId());
				session.setAttribute("islogin", 1);
//				// ��һ�ε�½
//				if (enterprise.getIsconnect() == 1) {
//					operate = 7;
//					return "first";
//				}
//				// ��½�ɹ�
//				else {
//					return SUCCESS;
//				}
				return SUCCESS;
			} else {
				error = "�û������������";
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
		// ��ɫ
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

		// ��ɫid
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
		// ���ش�����
		else if (role == 2) {
			return "agent";
		}
		// ���ؾ�����
		else if (role == 4) {
			return "retailer";
		}
		// ���ع���Ա
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
		// ��ɫ
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

		// ��ɫid
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
	// �û���
	private String username;
	// ����
	private String password;
	// ��֤��
	private String code;
	// ��ҵ��
	private String encode;
	// ������ַ���
	private String error;
	// �������
	private int id;
	// ��½�Ľ�ɫ
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
