package com.jinmayi.util;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")

public class LoginedCheckInterceptor extends AbstractInterceptor {

	/** session���ڡ���¼��Ч�Լ�������Ȩ����֤������ */

	@Override

	public String intercept(ActionInvocation ai) throws Exception {

		// ȡ�������URL

		String url = ServletActionContext.getRequest().getRequestURL().toString();

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Pragma", "No-cache");

		response.setDateHeader("Expires", 0);

		response.setHeader("Cache-Control", "no-cache");

		response.setHeader("Cache-Control", "no-store");

		response.setHeader("Content-Type", "text/html; charset=UTF-8");

		response.setHeader("Cache-Control", "no-store");

		response.setHeader("Content-Type", "text/html; charset=UTF-8");

		// �Ե�¼��ע������ֱ�ӷ��У���������
		if (url.indexOf("adminlogin.php") != -1 
				||url.indexOf("login.php") != -1 
				||url.indexOf("login.jmy") != -1 
				|| url.indexOf("leave.php") != -1 
				|| url.indexOf("leave.jmy") != -1 
				|| url.indexOf("verCode.php") != -1
				|| url.indexOf("show.php") != -1
				|| url.indexOf("shows.php") != -1
				|| url.indexOf("register.php") != -1
				|| url.indexOf("evaluate.php") != -1
				
				|| url.indexOf("app-in.php") != -1
				|| url.indexOf("app-login.php") != -1
				|| url.indexOf("app-qrcode.php") != -1
				|| url.indexOf("app-package.php") != -1
				|| url.indexOf("app-deliver.php") != -1
				|| url.indexOf("app-receive.php") != -1
				|| url.indexOf("app-sell.php") != -1
				|| url.indexOf("app-enterprise.php") != -1
				|| url.indexOf("app-info.php") != -1
				|| url.indexOf("app-parent.php") != -1
				|| url.indexOf("app-son.php") != -1
				|| url.indexOf("app-decode.php") != -1
				|| url.indexOf("app-recode.php") != -1
				|| url.indexOf("app-waybill.php") != -1
				|| url.indexOf("app-waybills.php") != -1
				|| url.indexOf("app-secode.php") != -1
				|| url.indexOf("app-unpackage.php") != -1
				|| url.indexOf("app-unqrcode.php") != -1
				
				|| url.indexOf("appinfo-packagelist.php") != -1
				|| url.indexOf("appinfo-delist.php") != -1
				|| url.indexOf("appinfo-dlist.php") != -1
				|| url.indexOf("appinfo-dslist.php") != -1
				|| url.indexOf("appinfo-relist.php") != -1
				|| url.indexOf("appinfo-rlist.php") != -1
				|| url.indexOf("appinfo-rslist.php") != -1
				|| url.indexOf("appinfo-sell.php") != -1
				) {

			return ai.invoke();

		} else {

			// ��֤Session�Ƿ����

			if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {

				// session����,ת��session������ʾҳ,������ת����¼ҳ��

				return "tologin";

			} else {

				// ��֤�Ƿ��Ѿ���¼

				try {
					if (ServletActionContext.getRequest().getSession().getAttribute("islogin").toString().equals("1")) {

						return ai.invoke();

					} else {
						// ��δ��¼,��ת����¼ҳ��
						return "tologin";

					}
				} catch (Exception e) {
					return "exception";
				}

			}

		}

	}

}