	package com.jinmayi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.XinLiCePingXiangMuDao;
import com.jinmayi.dao.impl.xlcp.LiangBiaoDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.XingLiCePingXiangMu;
/**
 * 检测项目
 * @author pnfy
 *
 */
public class jcxm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	LiangBiaoDao liangBiaoDao = new LiangBiaoDao();
	XinLiCePingXiangMuDao xinLiCePingXiangMuDao = new XinLiCePingXiangMuDao();

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
	
	public void gjcxm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			jId = 1;
		}

		JianCeXiangMu jc = jianCeXiangMuDao.getJianCeXiangMusById(jId);
		JiChuXinXi j = jiChuXinXiDao.getJiChuXinXiById(jc.getJiChuXinXiId());
		List<XingLiCePingXiangMu> xs = xinLiCePingXiangMuDao.getXingLiCePingXiangMusByJcxmId(jc.getJiChuXinXiId());
		List<String> lbs = new ArrayList<String>();
		for(XingLiCePingXiangMu x : xs) {
			lbs.add(liangBiaoDao.getNameById(x.getLiangBiaoId()));
		}
		request.setAttribute("lbs", lbs);
		request.setAttribute("j", j);
		request.setAttribute("jc", jc);
		
		if(request.getParameter("j").equals("x")) {
			request.getRequestDispatcher("pages/jcxm-xq.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("pages/jcxm-edit.jsp").forward(request,
					response);
		}
	}
	
	public void cjcxm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JianCeXiangMu j = new JianCeXiangMu();
		String ciShu = request.getParameter("ci_shu");
		try{
			j.setCiShu(Integer.parseInt(ciShu.trim()));
		} catch (Exception e) {
			j.setCiShu(1);
		}
		
		j.setRiQi(new Timestamp(new Date().getTime()));
		try {
			j.setJiChuXinXiId(Integer.parseInt(request
					.getParameter("ji_chu_xin_xi_id")));
		} catch (Exception e) {
			request.getRequestDispatcher("pages/jcxm-add.jsp").forward(request,
					response);
			return;
		}
		
		// 检测项目
		String[] jian_ce_xiang_mus = request
				.getParameterValues("jian_ce_xiang_mu");
		j.setNaoDian(false);
		j.setCcbt(false);
		j.setNaoRenZhi(false);
		j.setXinLiCePing(false);
		j.setYingYan(false);
		j.setHrv(false);
		if (jian_ce_xiang_mus != null) {
			for (String str : jian_ce_xiang_mus) {
				if(str.equals("脑电")) {
					j.setNaoDian(true);
				} else if (str.equals("CCBT")) {
					j.setCcbt(true);
				} else if (str.equals("脑认知")) {
					j.setNaoRenZhi(true);
				} else if (str.equals("心理测评")) {
					j.setXinLiCePing(true);
				} else if (str.equals("鹰演")) {
					j.setYingYan(true);
				} else if (str.equals("HRV")) {
					j.setHrv(true);
				}
			}
		}
		String  jcId = request.getParameter("jian_ce_xiang_mu_id");
		try{
			j.setId(Integer.parseInt(jcId.trim()));
		} catch (Exception e) {
			
		}
		jianCeXiangMuDao.change(j);
		XingLiCePingXiangMu xl = new XingLiCePingXiangMu();
		xl.setJianCeXiangMu(j.getId());
		// 心理测评项目
		String[] xing_li_ce_ping_xiang_mus = request
				.getParameterValues("xing_li_ce_ping_xiang_mu");
		if (xing_li_ce_ping_xiang_mus != null) {
			xinLiCePingXiangMuDao.delete(j.getId());
			
			for (String str : xing_li_ce_ping_xiang_mus) {
				xl.setLiangBiaoId(liangBiaoDao.getIdByName(str));
				xinLiCePingXiangMuDao.save(xl);
			}
		}
		
		
		
		response.sendRedirect("jcxm?m=gjcxm&j=x&id=" + j.getId());
	}
	public void sjcxm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("token").equals(session.getAttribute("token"))) {
			response.sendRedirect("jcxm?m=iJcxm");
			return;
		}
		session.removeAttribute("token");
		JianCeXiangMu j = new JianCeXiangMu();
		String ciShu = request.getParameter("ci_shu");
		try{
			j.setCiShu(1 + Integer.parseInt(ciShu.trim()));
		} catch (Exception e) {
			j.setCiShu(1);
		}
		
		j.setRiQi(new Timestamp(new Date().getTime()));
		try {
			j.setJiChuXinXiId(Integer.parseInt(request
					.getParameter("ji_chu_xin_xi_id")));
		} catch (Exception e) {
			request.getRequestDispatcher("pages/jcxm-add.jsp").forward(request,
					response);
			return;
		}
		
		// 检测项目
		String[] jian_ce_xiang_mus = request
				.getParameterValues("jian_ce_xiang_mu");
		j.setNaoDian(false);
		j.setCcbt(false);
		j.setNaoRenZhi(false);
		j.setXinLiCePing(false);
		j.setYingYan(false);
		j.setHrv(false);
		if (jian_ce_xiang_mus != null) {
			for (String str : jian_ce_xiang_mus) {
				if(str.equals("脑电")) {
					j.setNaoDian(true);
				} else if (str.equals("CCBT")) {
					j.setCcbt(true);
				} else if (str.equals("脑认知")) {
					j.setNaoRenZhi(true);
				} else if (str.equals("心理测评")) {
					j.setXinLiCePing(true);
				} else if (str.equals("鹰演")) {
					j.setYingYan(true);
				} else if (str.equals("HRV")) {
					j.setHrv(true);
				}
			}
		}
		long jcId = jianCeXiangMuDao.save(j, request.getSession());
		XingLiCePingXiangMu xl = new XingLiCePingXiangMu();
		xl.setJianCeXiangMu((int)jcId);
		// 心理测评项目
		String[] xing_li_ce_ping_xiang_mus = request
				.getParameterValues("xing_li_ce_ping_xiang_mu");
		if (xing_li_ce_ping_xiang_mus != null) {
			for (String str : xing_li_ce_ping_xiang_mus) {
				xl.setLiangBiaoId(liangBiaoDao.getIdByName(str));
				xinLiCePingXiangMuDao.save(xl);
			}
		}
		request.setAttribute("userId", jiChuXinXiDao.getLittleXinXiById(j.getJiChuXinXiId()).getYongHuId());
		//request.getRequestDispatcher("jcxm?m=iJcxm").forward(request, response);
		request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
		
	}
	/**
	 * 进入检测项目添加的界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iJcxmAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long pageNow = 1;

		try {
			pageNow = Long.valueOf(request.getParameter("pn"));
		} catch (Exception e) {
			pageNow = 1;
		}

		SearchContent s = new SearchContent();
		String n = request.getParameter("n");
		String r = request.getParameter("r");
		String q = request.getParameter("q");
		try{
			n = n.trim();
			if(n.equals("") || n == null) {
				s.setName("");
			} else {
				s.setName(n);
			}
		} catch (Exception e) {
			s.setName("");
		} finally{
			try{
				r = r.trim();
				if(r.equals("") || r == null) {
					s.setTime1("2000-0-0");
				} else {
					s.setTime1(r);
				}
			} catch (Exception e) {
				s.setTime1("2000-0-0");
			} finally {
				try{
					q = q.trim();
					if(q.equals("") || q == null) {
						s.setTime2(new Timestamp(new Date().getTime()).toString());
					} else {
						s.setTime2(q);
					}
				} catch (Exception e) {
					s.setTime2(new Timestamp(new Date().getTime()).toString());
				}
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("token", UUID.randomUUID());
		request.setAttribute("token", session.getAttribute("token"));
		Page<JiChuXinXi> page = jiChuXinXiDao.getPage(pageNow, s, session, false);
		request.setAttribute("j", request.getParameter("j"));
		request.setAttribute("page", page);
		request.getRequestDispatcher("pages/jcxm-add.jsp").forward(request, response);
	}
	
	/**
	 * 进入检测项目列表的界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iJcxm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long pageNow = 1;

		try {
			pageNow = Long.valueOf(request.getParameter("pn"));
		} catch (Exception e) {
			pageNow = 1;
		}

		SearchContent s = new SearchContent();
		String n = request.getParameter("n");
		String r = request.getParameter("r");
		String q = request.getParameter("q");
		try{
			n = n.trim();
			if(n.equals("") || n == null) {
				s.setName("");
			} else {
				s.setName(n);
			}
		} catch (Exception e) {
			s.setName("");
		} finally{
			try{
				r = r.trim();
				if(r.equals("") || r == null) {
					s.setTime1("2000-0-0");
				} else {
					s.setTime1(r);
				}
			} catch (Exception e) {
				s.setTime1("2000-0-0");
			} finally {
				try{
					q = q.trim();
					if(q.equals("") || q == null) {
						s.setTime2(new Timestamp(new Date().getTime()).toString());
					} else {
						s.setTime2(q);
					}
				} catch (Exception e) {
					s.setTime2(new Timestamp(new Date().getTime()).toString());
				}
			}
		}
		Page<JianCeXiangMu> page = jianCeXiangMuDao.getPage(pageNow, s, request.getSession(), false);
		
		request.setAttribute("page", page);
		
		
		request.getRequestDispatcher("pages/jcxm.jsp").forward(request, response);
	}
}
