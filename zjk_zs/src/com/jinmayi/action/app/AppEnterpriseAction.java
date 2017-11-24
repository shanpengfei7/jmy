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

import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EnterpriseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * app�ˣ���ҵ�Ĳ�������
 * 
 * @author pengfei
 *
 */
@Controller
@Scope("prototype")
public class AppEnterpriseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSONObject json = new JSONObject();

	/**
	 * ɨ��ҵ����
	 * 
	 * @throws Exception
	 */
	public void enterprise() throws Exception {
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Enterprise e = enterpriseService.getEnterpriseByCode(token);

			if (e == null) {
				json.put("status", 0);
				json.put("message", "��ά�벻����ҵ����!");
				json.put("data", "");
			} else {
				json.put("status", 1);
				json.put("message", "ɨ��ɹ�!");
				JSONObject j = new JSONObject();
				j.put("id", e.getId());
				j.put("name", e.getName());
				j.put("company", e.getCompany());
				j.put("address", e.getAddress());
				j.put("phonenumber", e.getPhonenumber());
				json.put("data", j);
			}

			out.print(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			json.put("status", 0);
			json.put("message", "ɨ��δ�ɹ���");
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

	@Resource
	private EnterpriseService enterpriseService;
	HttpServletRequest request;
	private HttpServletResponse response;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
