package com.jinmayi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.json.JSONException;
import org.json.JSONObject;

import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.YaoWuDao;
import com.jinmayi.dao.impl.YaoWuZhiLiaoDao;
import com.jinmayi.dao.impl.ZhenLiaoFangAnDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.YaoWu;
import com.jinmayi.entity.YaoWuZhiLiao;
import com.jinmayi.entity.ZhenLiaoFangAn;

/**
 * 诊疗方案
 * 
 * @author pnfy
 *
 */
public class zlfa extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	YaoWuDao yaoWuDao = new YaoWuDao();
	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	ZhenLiaoFangAnDao zhenLiaoFangAnDao = new ZhenLiaoFangAnDao();
	YaoWuZhiLiaoDao yaoWuZhiLiaoDao = new YaoWuZhiLiaoDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();

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

	public void gzl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			jId = 1;
		}

		ZhenLiaoFangAn z = zhenLiaoFangAnDao.getZhenLiaoFangAnById(jId);
		JiChuXinXi j = jiChuXinXiDao.getJiChuXinXiById(z.getJiChuXinXiId());
		List<YaoWuZhiLiao> ys = yaoWuZhiLiaoDao.getYaoWuZhiLiaosByZlfaId(z.getId());
		
		request.setAttribute("ys", ys);
		request.setAttribute("j", j);
		request.setAttribute("z", z);
		if(request.getParameter("z").equals("x")) {
			request.getRequestDispatcher("pages/zlfa-xq.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("pages/zlfa-edit.jsp").forward(request,
					response);
		}
	}

	public void gd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(request.getParameter("token").equals(session.getAttribute("token"))) {
			response.sendRedirect("jcxx?m=iJcxx");
			return;
		}
		session.removeAttribute("token");
		ZhenLiaoFangAn z = new ZhenLiaoFangAn();

		z.setRiQi(new Timestamp(new Date().getTime()));

		String ciShu = request.getParameter("ci_shu");
		try {
			z.setCiShu(1 + Integer.parseInt(ciShu.trim()));
		} catch (Exception e) {
			z.setCiShu(1);
		}
		try {
			z.setJiChuXinXiId(Integer.parseInt(request
					.getParameter("ji_chu_xin_xi_id")));
		} catch (Exception e) {
			request.getRequestDispatcher("pages/zlfa-add.jsp").forward(request,
					response);
			return;
		}

		// 复诊时间
		String fu_zhen_shi_jian = request.getParameter("fz_time");
		try {
			z.setFuZhenShiJian(Integer.parseInt(fu_zhen_shi_jian));
		} catch (Exception e) {
			z.setFuZhenShiJian(0);
		}

		// 心理测评项目
		String[] xing_li_ce_ping_xiang_mus = request
				.getParameterValues("xing_li_ce_ping_xiang_mu");
		if (xing_li_ce_ping_xiang_mus != null) {
			String xing_li_ce_ping_xiang_mu = "";
			for (String str : xing_li_ce_ping_xiang_mus) {
				xing_li_ce_ping_xiang_mu = xing_li_ce_ping_xiang_mu + "|" + str;
			}
			z.setXinLiCePingXiangMu(xing_li_ce_ping_xiang_mu.substring(1));
		}

		// 检测项目
		String[] jian_ce_xiang_mus = request
				.getParameterValues("jian_ce_xiang_mu");
		if (jian_ce_xiang_mus != null) {
			String jian_ce_xiang_mu = "";
			for (String str : jian_ce_xiang_mus) {
				jian_ce_xiang_mu = jian_ce_xiang_mu + "|" + str;
			}
			z.setJianCeXiangMu(jian_ce_xiang_mu.substring(1));
		}

		// 接受心身诊断
		String[] xszds = request.getParameterValues("xszd");
		if (xszds != null) {
			String xszd = "";
			for (String str : xszds) {
				xszd = xszd + "|" + str;
			}
			z.setXinShenZhenDuan(xszd.substring(1));
		}

		String zwsjgntj = request.getParameter("zwsjgntj");
		String ngntj = request.getParameter("ngntj");
		String swfktj = request.getParameter("swfktj");
		String jlccjzl = request.getParameter("jlccjzl");
		String wlzl = request.getParameter("wlzl");
		String xlzl = request.getParameter("xlzl");
		String rzxwlf = request.getParameter("rzxwlf");
		String spzl = request.getParameter("spzl");
		String ttzl = request.getParameter("ttzl");

		String zwsjgntjc = request.getParameter("zwsjgntjc");
		String ngntjc = request.getParameter("ngntjc");
		String swfktjc = request.getParameter("swfktjc");
		String jlccjzlc = request.getParameter("jlccjzlc");
		String wlzlc = request.getParameter("wlzlc");
		String xlzlc = request.getParameter("xlzlc");
		String rzxwlfc = request.getParameter("rzxwlfc");
		String spzlc = request.getParameter("spzlc");
		String ttzlc = request.getParameter("ttzlc");

		String xstj = "";

		if (zwsjgntj != null && zwsjgntjc != null && !zwsjgntjc.equals("0")) {
			xstj = xstj + "|" + zwsjgntj + "," + zwsjgntjc;
		}
		if (ngntj != null && ngntjc != null && !ngntjc.equals("0")) {
			xstj = xstj + "|" + ngntj + "," + ngntjc;
		}
		if (swfktj != null && swfktjc != null && !swfktjc.equals("0")) {
			xstj = xstj + "|" + swfktj + "," + swfktjc;
		}
		if (jlccjzl != null && jlccjzlc != null && !jlccjzlc.equals("0")) {
			xstj = xstj + "|" + jlccjzl + "," + jlccjzlc;
		}
		if (wlzl != null && wlzlc != null && !wlzlc.equals("0")) {
			xstj = xstj + "|" + wlzl + "," + wlzlc;
		}
		if (xlzl != null && xlzlc != null && !xlzlc.equals("0")) {
			xstj = xstj + "|" + xlzl + "," + xlzlc;
		}
		if (rzxwlf != null && rzxwlfc != null && !rzxwlfc.equals("0")) {
			xstj = xstj + "|" + rzxwlf + "," + rzxwlfc;
		}
		if (spzl != null && spzlc != null && !spzlc.equals("0")) {
			xstj = xstj + "|" + spzl + "," + spzlc;
		}
		if (ttzl != null && ttzlc != null && !ttzlc.equals("0")) {
			xstj = xstj + "|" + ttzl + "," + ttzlc;
		}
		if (xstj == null || xstj.equals("")) {
			z.setXinShenTiaoJie("");
		} else {
			z.setXinShenTiaoJie(xstj.substring(1));
		}

		String yaoWuZhiLiao = request.getParameter("yao_wu_zhi_liao");

		try{
			if(z.getCiShu() != Integer.parseInt(request.getParameter("ci_shu_j").trim())) {
				response.sendRedirect("jcxx?m=iJcxx");
				return;
			}
		}catch(Exception e) {
			response.sendRedirect("jcxx?m=iJcxx");
			return;
		}
		
		long zlfaId = zhenLiaoFangAnDao.save(z, request.getSession());

		if (yaoWuZhiLiao == null || yaoWuZhiLiao.equals("")) {

		} else {
			yaoWuZhiLiao = yaoWuZhiLiao.substring(1);
			String[] yaoWus = yaoWuZhiLiao.trim().split("~");
			for (String yaoWu : yaoWus) {
				String[] xs = yaoWu.toString().split("``");

				YaoWuZhiLiao y = new YaoWuZhiLiao();
				y.setYaoMing(xs[0]);
				y.setGuiGe(xs[1]);
				y.setYongLiang(xs[2]);
				y.setYongFa(xs[3]);
				y.setZhenLiaoFangAnId((int) zlfaId);
				yaoWuZhiLiaoDao.save(y);
			}
		}
		////////////////////////////////////////////////////////////////
		
		String id = request.getParameter("id");
		Integer jcId = null;
		try {
			jcId = Integer.parseInt(id.trim());
		} catch (Exception e) {

		}
		List<JianCeXiangMu> jcxms = jianCeXiangMuDao
				.getJianCeXiangMusByJcxxId(jcId);
		List<ZhenLiaoFangAn> zlfas = zhenLiaoFangAnDao
				.getZhenLiaoFangAnsByJcxxId(jcId);

		if (jcxms != null) {
			List<Integer> jcxmIds = new ArrayList<Integer>();
			for (JianCeXiangMu j : jcxms) {
				jcxmIds.add(j.getId());
			}
			jianCeXiangMuDao.guiDang(jcxmIds);
		}

		if (zlfas != null) {
			List<Integer> zlfaIds = new ArrayList<Integer>();
			for (ZhenLiaoFangAn zl : zlfas) {
				zlfaIds.add(zl.getId());
			}

			zhenLiaoFangAnDao.guiDang(zlfaIds);
		}

		jiChuXinXiDao.guiDang(jcId);

		request.getRequestDispatcher("blgl?m=iBlgl").forward(request, response);
	}

	public void ihf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Integer zlId = null;
		try {
			zlId = Integer.parseInt(id.trim());
		} catch (Exception e) {

		}

		out.print(zhenLiaoFangAnDao.getHuiFangById(zlId));
		out.flush();
		out.close();
	}

	public void shf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nr = request.getParameter("hui_fang_nei_rong");
		String id = request.getParameter("id");
		Integer zlId = null;
		try {
			zlId = Integer.parseInt(id.trim());
		} catch (Exception e) {

		}
		zhenLiaoFangAnDao.saveHuiFang(nr, zlId);

		request.getRequestDispatcher("zlfa?m=iZlfa").forward(request, response);
	}

	public void szlfa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("token").equals(session.getAttribute("token"))) {
			response.sendRedirect("jcxx?m=iJcxx");
			return;
		}
		session.removeAttribute("token");
		ZhenLiaoFangAn z = new ZhenLiaoFangAn();

		z.setRiQi(new Timestamp(new Date().getTime()));

		String ciShu = request.getParameter("ci_shu");
		try {
			z.setCiShu(1 + Integer.parseInt(ciShu.trim()));
		} catch (Exception e) {
			z.setCiShu(1);
		}
		try {
			z.setJiChuXinXiId(Integer.parseInt(request
					.getParameter("ji_chu_xin_xi_id")));
		} catch (Exception e) {
			request.getRequestDispatcher("pages/zlfa-add.jsp").forward(request,
					response);
			return;
		}

		// 复诊时间
		String fu_zhen_shi_jian = request.getParameter("fz_time");
		try {
			z.setFuZhenShiJian(Integer.parseInt(fu_zhen_shi_jian));
		} catch (Exception e) {
			z.setFuZhenShiJian(0);
		}

		// 心理测评项目
		String[] xing_li_ce_ping_xiang_mus = request
				.getParameterValues("xing_li_ce_ping_xiang_mu");
		if (xing_li_ce_ping_xiang_mus != null) {
			String xing_li_ce_ping_xiang_mu = "";
			for (String str : xing_li_ce_ping_xiang_mus) {
				xing_li_ce_ping_xiang_mu = xing_li_ce_ping_xiang_mu + "|" + str;
			}
			z.setXinLiCePingXiangMu(xing_li_ce_ping_xiang_mu.substring(1));
		}

		// 检测项目
		String[] jian_ce_xiang_mus = request
				.getParameterValues("jian_ce_xiang_mu");
		if (jian_ce_xiang_mus != null) {
			String jian_ce_xiang_mu = "";
			for (String str : jian_ce_xiang_mus) {
				jian_ce_xiang_mu = jian_ce_xiang_mu + "|" + str;
			}
			z.setJianCeXiangMu(jian_ce_xiang_mu.substring(1));
		}

		// 接受心身诊断
		String[] xszds = request.getParameterValues("xszd");
		if (xszds != null) {
			String xszd = "";
			for (String str : xszds) {
				xszd = xszd + "|" + str;
			}
			z.setXinShenZhenDuan(xszd.substring(1));
		}

		String zwsjgntj = request.getParameter("zwsjgntj");
		String ngntj = request.getParameter("ngntj");
		String swfktj = request.getParameter("swfktj");
		String jlccjzl = request.getParameter("jlccjzl");
		String wlzl = request.getParameter("wlzl");
		String xlzl = request.getParameter("xlzl");
		String rzxwlf = request.getParameter("rzxwlf");
		String spzl = request.getParameter("spzl");
		String ttzl = request.getParameter("ttzl");

		String zwsjgntjc = request.getParameter("zwsjgntjc");
		String ngntjc = request.getParameter("ngntjc");
		String swfktjc = request.getParameter("swfktjc");
		String jlccjzlc = request.getParameter("jlccjzlc");
		String wlzlc = request.getParameter("wlzlc");
		String xlzlc = request.getParameter("xlzlc");
		String rzxwlfc = request.getParameter("rzxwlfc");
		String spzlc = request.getParameter("spzlc");
		String ttzlc = request.getParameter("ttzlc");

		String xstj = "";

		if (zwsjgntj != null && zwsjgntjc != null && !zwsjgntjc.equals("0")) {
			xstj = xstj + "|" + zwsjgntj + "," + zwsjgntjc;
		}
		if (ngntj != null && ngntjc != null && !ngntjc.equals("0")) {
			xstj = xstj + "|" + ngntj + "," + ngntjc;
		}
		if (swfktj != null && swfktjc != null && !swfktjc.equals("0")) {
			xstj = xstj + "|" + swfktj + "," + swfktjc;
		}
		if (jlccjzl != null && jlccjzlc != null && !jlccjzlc.equals("0")) {
			xstj = xstj + "|" + jlccjzl + "," + jlccjzlc;
		}
		if (wlzl != null && wlzlc != null && !wlzlc.equals("0")) {
			xstj = xstj + "|" + wlzl + "," + wlzlc;
		}
		if (xlzl != null && xlzlc != null && !xlzlc.equals("0")) {
			xstj = xstj + "|" + xlzl + "," + xlzlc;
		}
		if (rzxwlf != null && rzxwlfc != null && !rzxwlfc.equals("0")) {
			xstj = xstj + "|" + rzxwlf + "," + rzxwlfc;
		}
		if (spzl != null && spzlc != null && !spzlc.equals("0")) {
			xstj = xstj + "|" + spzl + "," + spzlc;
		}
		if (ttzl != null && ttzlc != null && !ttzlc.equals("0")) {
			xstj = xstj + "|" + ttzl + "," + ttzlc;
		}
		if (xstj == null || xstj.equals("")) {
			z.setXinShenTiaoJie("");
		} else {
			z.setXinShenTiaoJie(xstj.substring(1));
		}

		String yaoWuZhiLiao = request.getParameter("yao_wu_zhi_liao");

		try{
			if(z.getCiShu() != Integer.parseInt(request.getParameter("ci_shu_j").trim())) {
				response.sendRedirect("jcxx?m=iJcxx");
				return;
			}
		}catch(Exception e) {
			response.sendRedirect("jcxx?m=iJcxx");
			return;
		}
		
		long zlfaId = zhenLiaoFangAnDao.save(z, request.getSession());

		if (yaoWuZhiLiao == null || yaoWuZhiLiao.equals("")) {

		} else {
			yaoWuZhiLiao = yaoWuZhiLiao.substring(1);
			String[] yaoWus = yaoWuZhiLiao.trim().split("~");
			for (String yaoWu : yaoWus) {
				String[] xs = yaoWu.toString().split("``");

				YaoWuZhiLiao y = new YaoWuZhiLiao();
				y.setYaoMing(xs[0]);
				y.setGuiGe(xs[1]);
				y.setYongLiang(xs[2]);
				y.setYongFa(xs[3]);
				y.setZhenLiaoFangAnId((int) zlfaId);
				yaoWuZhiLiaoDao.save(y);
			}
		}

		response.sendRedirect("jcxx?m=iJcxx");
	}
	
	public void czlfa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ZhenLiaoFangAn z = new ZhenLiaoFangAn();

		z.setRiQi(new Timestamp(new Date().getTime()));

		String ciShu = request.getParameter("ci_shu");
		try {
			z.setCiShu(Integer.parseInt(ciShu.trim()));
		} catch (Exception e) {
			z.setCiShu(1);
		}
		try {
			z.setJiChuXinXiId(Integer.parseInt(request
					.getParameter("ji_chu_xin_xi_id")));
		} catch (Exception e) {
			request.getRequestDispatcher("pages/zlfa-add.jsp").forward(request,
					response);
			return;
		}

		// 复诊时间
		String fu_zhen_shi_jian = request.getParameter("fz_time");
		try {
			z.setFuZhenShiJian(Integer.parseInt(fu_zhen_shi_jian));
		} catch (Exception e) {
			z.setFuZhenShiJian(0);
		}

		// 心理测评项目
		String[] xing_li_ce_ping_xiang_mus = request
				.getParameterValues("xing_li_ce_ping_xiang_mu");
		if (xing_li_ce_ping_xiang_mus != null) {
			String xing_li_ce_ping_xiang_mu = "";
			for (String str : xing_li_ce_ping_xiang_mus) {
				xing_li_ce_ping_xiang_mu = xing_li_ce_ping_xiang_mu + "|" + str;
			}
			z.setXinLiCePingXiangMu(xing_li_ce_ping_xiang_mu.substring(1));
		}

		// 检测项目
		String[] jian_ce_xiang_mus = request
				.getParameterValues("jian_ce_xiang_mu");
		if (jian_ce_xiang_mus != null) {
			String jian_ce_xiang_mu = "";
			for (String str : jian_ce_xiang_mus) {
				jian_ce_xiang_mu = jian_ce_xiang_mu + "|" + str;
			}
			z.setJianCeXiangMu(jian_ce_xiang_mu.substring(1));
		}

		// 接受心身诊断
		String[] xszds = request.getParameterValues("xszd");
		if (xszds != null) {
			String xszd = "";
			for (String str : xszds) {
				xszd = xszd + "|" + str;
			}
			z.setXinShenZhenDuan(xszd.substring(1));
		}

		String zwsjgntj = request.getParameter("zwsjgntj");
		String ngntj = request.getParameter("ngntj");
		String swfktj = request.getParameter("swfktj");
		String jlccjzl = request.getParameter("jlccjzl");
		String wlzl = request.getParameter("wlzl");
		String xlzl = request.getParameter("xlzl");
		String rzxwlf = request.getParameter("rzxwlf");
		String spzl = request.getParameter("spzl");
		String ttzl = request.getParameter("ttzl");

		String zwsjgntjc = request.getParameter("zwsjgntjc");
		String ngntjc = request.getParameter("ngntjc");
		String swfktjc = request.getParameter("swfktjc");
		String jlccjzlc = request.getParameter("jlccjzlc");
		String wlzlc = request.getParameter("wlzlc");
		String xlzlc = request.getParameter("xlzlc");
		String rzxwlfc = request.getParameter("rzxwlfc");
		String spzlc = request.getParameter("spzlc");
		String ttzlc = request.getParameter("ttzlc");

		String xstj = "";

		if (zwsjgntj != null && zwsjgntjc != null && !zwsjgntjc.equals("0")) {
			xstj = xstj + "|" + zwsjgntj + "," + zwsjgntjc;
		}
		if (ngntj != null && ngntjc != null && !ngntjc.equals("0")) {
			xstj = xstj + "|" + ngntj + "," + ngntjc;
		}
		if (swfktj != null && swfktjc != null && !swfktjc.equals("0")) {
			xstj = xstj + "|" + swfktj + "," + swfktjc;
		}
		if (jlccjzl != null && jlccjzlc != null && !jlccjzlc.equals("0")) {
			xstj = xstj + "|" + jlccjzl + "," + jlccjzlc;
		}
		if (wlzl != null && wlzlc != null && !wlzlc.equals("0")) {
			xstj = xstj + "|" + wlzl + "," + wlzlc;
		}
		if (xlzl != null && xlzlc != null && !xlzlc.equals("0")) {
			xstj = xstj + "|" + xlzl + "," + xlzlc;
		}
		if (rzxwlf != null && rzxwlfc != null && !rzxwlfc.equals("0")) {
			xstj = xstj + "|" + rzxwlf + "," + rzxwlfc;
		}
		if (spzl != null && spzlc != null && !spzlc.equals("0")) {
			xstj = xstj + "|" + spzl + "," + spzlc;
		}
		if (ttzl != null && ttzlc != null && !ttzlc.equals("0")) {
			xstj = xstj + "|" + ttzl + "," + ttzlc;
		}
		if (xstj == null || xstj.equals("")) {
			z.setXinShenTiaoJie("");
		} else {
			z.setXinShenTiaoJie(xstj.substring(1));
		}

		String yaoWuZhiLiao = request.getParameter("yao_wu_zhi_liao");

		String zlfaId = request.getParameter("zhen_liao_fang_an_id");
		try{
			z.setId(Integer.parseInt(zlfaId.trim()));
		} catch (Exception e) {
			
		}
		
		zhenLiaoFangAnDao.change(z);

		if (yaoWuZhiLiao == null || yaoWuZhiLiao.equals("")) {

		} else {
			yaoWuZhiLiao = yaoWuZhiLiao.substring(1);
			String[] yaoWus = yaoWuZhiLiao.trim().split("~");
			
			yaoWuZhiLiaoDao.deleteByZlfaId(z.getId());
			
			for (String yaoWu : yaoWus) {
				String[] xs = yaoWu.toString().split("``");

				YaoWuZhiLiao y = new YaoWuZhiLiao();
				y.setYaoMing(xs[0]);
				y.setGuiGe(xs[1]);
				y.setYongLiang(xs[2]);
				y.setYongFa(xs[3]);
				y.setZhenLiaoFangAnId(z.getId());
				yaoWuZhiLiaoDao.save(y);
			}
		}

		response.sendRedirect("zlfa?m=gzl&z=x&id=" + z.getId());
	}

	/**
	 * 得到用量
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gyl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name").trim();
		List<YaoWu> yaoWus = yaoWuDao.getYongLiangsByName(name);

		JSONObject json = new JSONObject();

		for (int i = 0; i < yaoWus.size(); i++) {
			try {
				json.put("a" + i, yaoWus.get(i).getYongLiang());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	/**
	 * 得到规格
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ggg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name").trim();
		List<YaoWu> yaoWus = yaoWuDao.getGuiGesByName(name);

		JSONObject json = new JSONObject();

		for (int i = 0; i < yaoWus.size(); i++) {
			try {
				json.put("a" + i, yaoWus.get(i).getGuiGe());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	/**
	 * 进入诊疗方案添加的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iZlfaAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

		HttpSession session = request.getSession();
		session.setAttribute("token", UUID.randomUUID());
		request.setAttribute("token", session.getAttribute("token"));
		
		Page<JiChuXinXi> page = jiChuXinXiDao.getPage(pageNow, s,
				session, false);

		request.setAttribute("f", request.getParameter("f"));
		request.setAttribute("page", page);
		request.getRequestDispatcher("pages/zlfa-add.jsp").forward(request,
				response);
	}

	/**
	 * 进入诊疗方案列表的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iZlfa(HttpServletRequest request, HttpServletResponse response)
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

		Page<ZhenLiaoFangAn> page = zhenLiaoFangAnDao.getPage(pageNow, s,
				request.getSession(), false);

		request.setAttribute("page", page);

		request.getRequestDispatcher("pages/zlfa.jsp").forward(request,
				response);
	}
}
