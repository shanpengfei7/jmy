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
		String file = this.getInitParameter("log4j");// 从web.xml配置读取，名字一定要和web.xml配置一致
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
         long startTime = System.currentTimeMillis();                                   //运行前的时间
         String requestURI = request.getRequestURI();                                   //获取访问的URI
         requestURI = request.getQueryString() == null ? requestURI                    //所有的地址栏参数对比
                     : (requestURI + "?" + request.getQueryString());
         
         chain.doFilter(request, response);
         
         long endTime = System.currentTimeMillis();
         //消耗的总时间
         log.info(request.getRemoteAddr() + " " + requestURI + " "+ (endTime - startTime) + " " + request.getHeader("user-agent") + " " + response.getStatus());//时间单位：毫秒
         
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterName = filterConfig.getFilterName();//获取 Filter的 name，启动Filter
        log.info("启动 Filter: " + filterName);//
        log.info("ip, 请求的内容, 响应的时间, 电脑及浏览器的版本, 返回的状态码");
	}
}
