package com.jinmayi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.XinLiCePingXiangMuDao;
import com.jinmayi.dao.impl.YaoWuZhiLiaoDao;
import com.jinmayi.dao.impl.ZhenLiaoFangAnDao;
import com.jinmayi.dao.impl.xlcp.LiangBiaoDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.XingLiCePingXiangMu;
import com.jinmayi.entity.YaoWuZhiLiao;
import com.jinmayi.entity.ZhenLiaoFangAn;

/**
 * 病例管理
 * 
 * @author pnfy
 *
 */
public class blgl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	LiangBiaoDao liangBiaoDao = new LiangBiaoDao();
	XinLiCePingXiangMuDao xinLiCePingXiangMuDao = new XinLiCePingXiangMuDao();
	ZhenLiaoFangAnDao zhenLiaoFangAnDao = new ZhenLiaoFangAnDao();
	YaoWuZhiLiaoDao yaoWuZhiLiaoDao = new YaoWuZhiLiaoDao();

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

	public void gzlfa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			response.sendRedirect("blgl?m=iBlgl");
		}

		JiChuXinXi j = null;
		List<ZhenLiaoFangAn> zs = zhenLiaoFangAnDao.getMoreGdZhenLiaoFangAnsByJcxxId(jId);
		if(zs.size() != 0) {
			for (ZhenLiaoFangAn z : zs) {
				List<YaoWuZhiLiao> ys = yaoWuZhiLiaoDao.getYaoWuZhiLiaosByZlfaId(z.getId());
				z.setYaoWuZhiLiaos(ys);
			}
			
			
			j = jiChuXinXiDao.getJiChuXinXiById(zs.get(0).getJiChuXinXiId());
			
		}
		
		request.setAttribute("j", j);
		request.setAttribute("zs", zs);
			request.getRequestDispatcher("pages/blgl-zlfa-xq.jsp").forward(request,
					response);
	}
	
	public void gjcxm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			response.sendRedirect("blgl?m=iBlgl");
		}

		JiChuXinXi j = jiChuXinXiDao.getJiChuXinXiById(jId);
		List<JianCeXiangMu> jcs = jianCeXiangMuDao.getMoreGdJianCeXiangMusByJcxxId(jId);
		
		for (JianCeXiangMu jc : jcs) {
			List<XingLiCePingXiangMu> xs = xinLiCePingXiangMuDao.getXingLiCePingXiangMusByJcxmId(jc.getId());
			List<String> lbs = new ArrayList<String>();
			for(XingLiCePingXiangMu x : xs) {
				lbs.add(liangBiaoDao.getNameById(x.getLiangBiaoId()));
			}
			jc.setLiangBiaos(lbs);
		}
		
		request.setAttribute("j", j);
		request.setAttribute("jcs", jcs);
		
		request.getRequestDispatcher("pages/blgl-jcxm-xq.jsp").forward(request,
				response);
	}

	public void gBlgl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			response.sendRedirect("blgl?m=iBlgl");
		}
		request.setAttribute("j", jiChuXinXiDao.getAllJiChuXinXiById(jId));
		request.getRequestDispatcher("pages/blgl-xq.jsp").forward(request,
				response);
	}

	/**
	 * 进入病例管理列表的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iBlgl(HttpServletRequest request, HttpServletResponse response)
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
		try {
			n = n.trim();
			if (n.equals("") || n == null) {
				s.setName("");
			} else {
				s.setName(n);
			}
		} catch (Exception e) {
			s.setName("");
		} finally {
			try {
				r = r.trim();
				if (r.equals("") || r == null) {
					s.setTime1("2000-0-0");
				} else {
					s.setTime1(r);
				}
			} catch (Exception e) {
				s.setTime1("2000-0-0");
			} finally {
				try {
					q = q.trim();
					if (q.equals("") || q == null) {
						s.setTime2(new Timestamp(new Date().getTime())
								.toString());
					} else {
						s.setTime2(q);
					}
				} catch (Exception e) {
					s.setTime2(new Timestamp(new Date().getTime()).toString());
				}
			}
		}
		HttpSession session = request.getSession(true);
		Integer quanXian = (Integer) session.getAttribute("quanxian");
		Page<JiChuXinXi> page = null;
		if (quanXian == 1) {
			page = jiChuXinXiDao.getPages(pageNow, s,
					request.getSession());
		} else if (quanXian == 2) {
			page = jiChuXinXiDao.getPage(pageNow, s,
					request.getSession());
		} else if (quanXian == 3) {
			page = jiChuXinXiDao.getPage(pageNow, s,
					request.getSession());
		} else if (quanXian == 4) {
			page = jiChuXinXiDao.getPage(pageNow, s,
					request.getSession());
		} else if (quanXian == 5) {
			page = jiChuXinXiDao.getPageByJingShenKeYiSheng(
					pageNow, s, request.getSession());
		} else if (quanXian == 6) {
			page = jiChuXinXiDao.getPageByKeShi(pageNow, s,
					request.getSession());
		} else if (quanXian == 7) {
			page = jiChuXinXiDao.getPageByZhuanKeYiSheng(
					pageNow, s, request.getSession());
		}
		request.setAttribute("page", page);

		request.getRequestDispatcher("pages/blgl.jsp").forward(request,
				response);
	}

}
