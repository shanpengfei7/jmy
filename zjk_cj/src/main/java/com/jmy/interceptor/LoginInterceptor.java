package com.jmy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jmy.entity.Admi;
import com.jmy.entity.Enterprise;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		if (url.contains("admin.jmy")) {
			return true;
		} else if (url.contains("user.jmy")) {
			return true;
		} else if (url.contains("login.jmy")) {
			return true;
		} else if (url.contains("/tool/")) {
			return true;
		} else if (url.contains("/app/")) {
			return true;
		} else {
			Admi admin = (Admi) request.getSession().getAttribute("admin");
			if (admin == null) {
				Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");
				if(enterprise == null) {
					if (url.contains(request.getContextPath() + "/admin/")) {
						PrintWriter out = response.getWriter();
						String u = "<script>window.parent.location.href='";
						u += request.getContextPath();
						u += "/admin.jmy'</script>)";
						out.println(u);
						out.close();
						return false;
					} else {
						// response.sendRedirect(request.getContextPath()
						// +"/user.jmy");
						PrintWriter out = response.getWriter();
						String u = "<script>window.parent.location.href='";
						u += request.getContextPath();
						u += "/user.jmy'</script>)";
						out.println(u);
						return false;
					}
				} else {
					return true;
				}
				
			} else {
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
