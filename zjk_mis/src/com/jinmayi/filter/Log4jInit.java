package com.jinmayi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet implements Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Log log = LogFactory.getLog(this.getClass());
     private String filterName;
	@Override
	public void destroy() {
		super.destroy();
	}

	public Log4jInit() {
		super();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		String file = this.getInitParameter("log4j");// ��web.xml���ö�ȡ������һ��Ҫ��web.xml����һ��
		if (file != null) {
			PropertyConfigurator.configure(file);
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest request = (HttpServletRequest) req;
         HttpServletResponse response = (HttpServletResponse) res;
         long startTime = System.currentTimeMillis();                                   //����ǰ��ʱ��
         String requestURI = request.getRequestURI();                                   //��ȡ���ʵ�URI
         requestURI = request.getQueryString() == null ? requestURI                    //���еĵ�ַ�������Ա�
                     : (requestURI + "?" + request.getQueryString());
         
         chain.doFilter(request, response);
         
         long endTime = System.currentTimeMillis();
         //���ĵ���ʱ��
         log.info(request.getRemoteAddr() + " " + requestURI + " "+ (endTime - startTime) + " " + request.getHeader("user-agent") + " " + response.getStatus());//ʱ�䵥λ������
         
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterName = filterConfig.getFilterName();//��ȡ Filter�� name������Filter
        log.info("���� Filter: " + filterName);//
        log.info("ip, ���������, ��Ӧ��ʱ��, ���Լ�������İ汾, ���ص�״̬��");
	}
}
