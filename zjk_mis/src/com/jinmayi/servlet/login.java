package com.jinmayi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinmayi.dao.impl.DengLuDao;
import com.jinmayi.dao.impl.YiShengDao;
import com.jinmayi.dao.impl.YiYuanDao;
import com.jinmayi.entity.DengLu;
import com.jinmayi.entity.YiSheng;
import com.jinmayi.entity.YiYuan;

/**
 * 登陆
 * 
 * @author pnfy
 *
 */
public class login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DengLuDao dengLuDao = new DengLuDao();
	YiYuanDao yiYuanDao = new YiYuanDao();
	YiShengDao yiShengDao = new YiShengDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName = request.getParameter("m");

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void hdl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String h = request.getParameter("h");
		
		out.print(dengLuDao.hasDengLuHao(h));
		
		out.flush();
		out.close();
	}
	
	/**
	 * 根据登陆角色的权限进入不同的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void lgn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String number = request.getParameter("number");
		String password = request.getParameter("password");
		DengLu dengLu = dengLuDao.getDengLuByDengLuHao(number);
		try{
			if (dengLu.getMiMa().equals(password)) {
				
				Integer quanXian = dengLu.getQuanXian();
				HttpSession session = request.getSession(true);
				session.setAttribute("quanxian", quanXian);
				
				// 1管理员 2医院 3测评师 4精神科主任 5精神科医生 6专科主任 7专科医生
				if (quanXian == 1) {
					session.setAttribute("nav", "管理员");
					request.getRequestDispatcher("csh?m=iGlyCsh").forward(
							request, response);
				} else if (quanXian == 2) {
					YiYuan yy = yiYuanDao.getIdByDLId(dengLu.getId());
					session.setAttribute("yiYuanId", yy.getId());
					session.setAttribute("yiYuanMingCheng", yy.getMingCheng());
					session.setAttribute("nav", yy.getMingCheng());
					request.getRequestDispatcher("csh?m=iYyCsh").forward(
							request, response);
				} else if (quanXian == 3) {
					YiSheng ys = yiShengDao.getYiShengByDlId(dengLu.getId());
					session.setAttribute("yiYuanId", ys.getYiYuanId());
					session.setAttribute("yiYuanMingCheng", ys.getYiYuan());
					session.setAttribute("keshiId", ys.getKeShiId());
					session.setAttribute("cePingShiId", ys.getId());
					session.setAttribute("cePingShi", ys.getXingMing());
					session.setAttribute("nav", ys.getXingMing());
					request.getRequestDispatcher("jcxx?m=iJcxx").forward(request,
							response);
				} else if (quanXian == 4) {
					YiSheng ys = yiShengDao.getYiShengByDlId(dengLu.getId());
					session.setAttribute("yiYuanId", ys.getYiYuanId());
					session.setAttribute("yiYuanMingCheng", ys.getYiYuan());
					session.setAttribute("nav", ys.getXingMing());
					request.getRequestDispatcher("blgl?m=iBlgl").forward(request,
							response);
				} else if (quanXian == 5) {
					YiSheng ys = yiShengDao.getYiShengByDlId(dengLu.getId());
					session.setAttribute("yiYuanId", ys.getYiYuanId());
					session.setAttribute("yiYuanMingCheng", ys.getYiYuan());
					session.setAttribute("yiShengId", ys.getId());
					session.setAttribute("keShi", ys.getKeShi());
					session.setAttribute("xingMing", ys.getXingMing());
					session.setAttribute("nav", ys.getXingMing());
					request.getRequestDispatcher("blgl?m=iBlgl").forward(request,
							response);
				} else if (quanXian == 6) {
					YiSheng ys = yiShengDao.getYiShengByDlId(dengLu.getId());
					session.setAttribute("yiYuanId", ys.getYiYuanId());
					session.setAttribute("yiYuanMingCheng", ys.getYiYuan());
					session.setAttribute("keshiId", ys.getKeShiId());
					session.setAttribute("keShi", ys.getKeShi());
					session.setAttribute("nav", ys.getXingMing());
					request.getRequestDispatcher("blgl?m=iBlgl").forward(request,
							response);
				} else if (quanXian == 7) {
					YiSheng ys = yiShengDao.getYiShengByDlId(dengLu.getId());
					session.setAttribute("yiYuanId", ys.getYiYuanId());
					session.setAttribute("yiYuanMingCheng", ys.getYiYuan());
					session.setAttribute("yiShengId", ys.getId());
					session.setAttribute("keShi", ys.getKeShi());
					session.setAttribute("xingMing", ys.getXingMing());
					session.setAttribute("nav", ys.getXingMing());
					request.getRequestDispatcher("blgl?m=iBlgl").forward(request,
							response);
				}
			} else {
				String error = "您的用户名或密码有误！";
				request.setAttribute("error", error);
				request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			String error = "您的用户名或密码有误！";
			request.setAttribute("error", error);
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

	/**
	 * 用户注销
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void lv(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("pages/login.jsp");
	}
}
