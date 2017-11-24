package com.jinmayi.servlet.xlcp;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinmayi.algorithm.tizhi.ATiZhi;
import com.jinmayi.algorithm.tizhi.BHanMiDunJiaoLv;
import com.jinmayi.algorithm.tizhi.CHanMiDunYiYu;
import com.jinmayi.algorithm.tizhi.DWCPA;
import com.jinmayi.algorithm.tizhi.EZhengZhuang90;
import com.jinmayi.algorithm.tizhi.FAiSenKe;
import com.jinmayi.algorithm.tizhi.GJianMingJingShenBing;
import com.jinmayi.algorithm.tizhi.HZaoKuang;
import com.jinmayi.algorithm.tizhi.IChiDaiJianYiShaiCha;
import com.jinmayi.algorithm.tizhi.JChangGuChuanChiDai;
import com.jinmayi.algorithm.tizhi.KYinXing;
import com.jinmayi.algorithm.tizhi.LYangXing;
import com.jinmayi.algorithm.tizhi.MQiangPo;
import com.jinmayi.algorithm.tizhi.NPHQ9;
import com.jinmayi.algorithm.tizhi.OGAD7;
import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.XinLiCePingXiangMuDao;
import com.jinmayi.dao.impl.xlcp.CanKaoDao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao10Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao11Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao12Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao13Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao14Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao15Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao1Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao2Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao3Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao4Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao5Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao6Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao7Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao8Dao;
import com.jinmayi.dao.impl.xlcp.CePingBaoGao9Dao;
import com.jinmayi.dao.impl.xlcp.DaAnDao;
import com.jinmayi.entity.CanKao;
import com.jinmayi.entity.CePingBaoGao1;
import com.jinmayi.entity.CePingBaoGao10;
import com.jinmayi.entity.CePingBaoGao11;
import com.jinmayi.entity.CePingBaoGao12;
import com.jinmayi.entity.CePingBaoGao13;
import com.jinmayi.entity.CePingBaoGao14;
import com.jinmayi.entity.CePingBaoGao15;
import com.jinmayi.entity.CePingBaoGao2;
import com.jinmayi.entity.CePingBaoGao3;
import com.jinmayi.entity.CePingBaoGao4;
import com.jinmayi.entity.CePingBaoGao5;
import com.jinmayi.entity.CePingBaoGao6;
import com.jinmayi.entity.CePingBaoGao7;
import com.jinmayi.entity.CePingBaoGao8;
import com.jinmayi.entity.CePingBaoGao9;
import com.jinmayi.entity.DaAn;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;

/**
 * 测评报告管理
 * 
 * @author pnfy
 *
 */
public class bggl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DaAnDao daAnDao = new DaAnDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	XinLiCePingXiangMuDao xinLiCePingXiangMuDao = new XinLiCePingXiangMuDao();
	CanKaoDao canKaoDao = new CanKaoDao();
	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	CePingBaoGao1Dao cePingBaoGao1Dao = new CePingBaoGao1Dao();
	CePingBaoGao2Dao cePingBaoGao2Dao = new CePingBaoGao2Dao();
	CePingBaoGao3Dao cePingBaoGao3Dao = new CePingBaoGao3Dao();
	CePingBaoGao4Dao cePingBaoGao4Dao = new CePingBaoGao4Dao();
	CePingBaoGao5Dao cePingBaoGao5Dao = new CePingBaoGao5Dao();
	CePingBaoGao6Dao cePingBaoGao6Dao = new CePingBaoGao6Dao();
	CePingBaoGao7Dao cePingBaoGao7Dao = new CePingBaoGao7Dao();
	CePingBaoGao8Dao cePingBaoGao8Dao = new CePingBaoGao8Dao();
	CePingBaoGao9Dao cePingBaoGao9Dao = new CePingBaoGao9Dao();
	CePingBaoGao10Dao cePingBaoGao10Dao = new CePingBaoGao10Dao();
	CePingBaoGao11Dao cePingBaoGao11Dao = new CePingBaoGao11Dao();
	CePingBaoGao12Dao cePingBaoGao12Dao = new CePingBaoGao12Dao();
	CePingBaoGao13Dao cePingBaoGao13Dao = new CePingBaoGao13Dao();
	CePingBaoGao14Dao cePingBaoGao14Dao = new CePingBaoGao14Dao();
	CePingBaoGao15Dao cePingBaoGao15Dao = new CePingBaoGao15Dao();

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

	/**
	 * 根据界面上选择的报告，拿到对应的报告，并进入查看报告的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gbg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jId = request.getParameter("j");
		String cs = request.getParameter("c");
		String lId = request.getParameter("l");

		Integer jcxxId = null;
		Integer ciShu = null;

		try {
			jcxxId = Integer.parseInt(jId.trim());
		} catch (Exception e) {

		}
		try {
			ciShu = Integer.parseInt(cs.trim());
		} catch (Exception e) {

		}

		if (lId.equals("1")) {
			CePingBaoGao1 cePingBaoGao1 = cePingBaoGao1Dao
					.getCePingBaoGao1ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao1);
			request.getRequestDispatcher("pages/xlcp/cpbg1.jsp").forward(
					request, response);
		} else if (lId.equals("2")) {
			CePingBaoGao2 cePingBaoGao2 = cePingBaoGao2Dao
					.getCePingBaoGao2ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao2);
			request.getRequestDispatcher("pages/xlcp/cpbg2.jsp").forward(
					request, response);
		} else if (lId.equals("3")) {
			CePingBaoGao3 cePingBaoGao3 = cePingBaoGao3Dao
					.getCePingBaoGao3ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao3);
			request.getRequestDispatcher("pages/xlcp/cpbg3.jsp").forward(
					request, response);
		} else if (lId.equals("4")) {
			CePingBaoGao4 cePingBaoGao4 = cePingBaoGao4Dao
					.getCePingBaoGao4ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao4);
			request.getRequestDispatcher("pages/xlcp/cpbg4.jsp").forward(
					request, response);
		} else if (lId.equals("5")) {
			CePingBaoGao5 cePingBaoGao5 = cePingBaoGao5Dao
					.getCePingBaoGao5ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao5);
			request.getRequestDispatcher("pages/xlcp/cpbg5.jsp").forward(
					request, response);
		} else if (lId.equals("6")) {
			CePingBaoGao6 cePingBaoGao6 = cePingBaoGao6Dao
					.getCePingBaoGao6ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao6);
			request.getRequestDispatcher("pages/xlcp/cpbg6.jsp").forward(
					request, response);
		} else if (lId.equals("7")) {
			CePingBaoGao7 cePingBaoGao7 = cePingBaoGao7Dao
					.getCePingBaoGao7ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao7);
			request.getRequestDispatcher("pages/xlcp/cpbg7.jsp").forward(
					request, response);
		} else if (lId.equals("8")) {
			CePingBaoGao8 cePingBaoGao8 = cePingBaoGao8Dao
					.getCePingBaoGao8ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao8);
			request.getRequestDispatcher("pages/xlcp/cpbg8.jsp").forward(
					request, response);
		} else if (lId.equals("9")) {
			CePingBaoGao9 cePingBaoGao9 = cePingBaoGao9Dao
					.getCePingBaoGao9ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao9);
			request.getRequestDispatcher("pages/xlcp/cpbg9.jsp").forward(
					request, response);
		} else if (lId.equals("10")) {
			CePingBaoGao10 cePingBaoGao10 = cePingBaoGao10Dao
					.getCePingBaoGao10ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao10);
			request.getRequestDispatcher("pages/xlcp/cpbg10.jsp").forward(
					request, response);
		} else if (lId.equals("11")) {
			CePingBaoGao11 cePingBaoGao11 = cePingBaoGao11Dao
					.getCePingBaoGao11ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao11);
			request.getRequestDispatcher("pages/xlcp/cpbg11.jsp").forward(
					request, response);
		} else if (lId.equals("12")) {
			CePingBaoGao12 cePingBaoGao12 = cePingBaoGao12Dao
					.getCePingBaoGao12ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao12);
			request.getRequestDispatcher("pages/xlcp/cpbg12.jsp").forward(
					request, response);
		} else if (lId.equals("13")) {
			CePingBaoGao13 cePingBaoGao13 = cePingBaoGao13Dao
					.getCePingBaoGao13ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao13);
			request.getRequestDispatcher("pages/xlcp/cpbg13.jsp").forward(
					request, response);
		}else if (lId.equals("14")) {
			CePingBaoGao14 cePingBaoGao14 = cePingBaoGao14Dao
					.getCePingBaoGao14ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao14);
			request.getRequestDispatcher("pages/xlcp/cpbg14.jsp").forward(
					request, response);
		}else if (lId.equals("15")) {
			CePingBaoGao15 cePingBaoGao15 = cePingBaoGao15Dao
					.getCePingBaoGao15ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao15);
			request.getRequestDispatcher("pages/xlcp/cpbg15.jsp").forward(
					request, response);
		}

	}
	
	/**
	 * 进入修改报告界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iebg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jId = request.getParameter("id");
		String cs = request.getParameter("c");
		String lId = request.getParameter("l");

		Integer jcxxId = null;
		Integer ciShu = null;

		try {
			jcxxId = Integer.parseInt(jId.trim());
		} catch (Exception e) {

		}
		try {
			ciShu = Integer.parseInt(cs.trim());
			request.setAttribute("cs", ciShu);
		} catch (Exception e) {

		}
		
		if (lId.equals("1")) {
			CePingBaoGao1 cePingBaoGao1 = cePingBaoGao1Dao
					.getCePingBaoGao1ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao1);
			request.getRequestDispatcher("pages/xlcp/editcpbg1.jsp").forward(
					request, response);
		} else if (lId.equals("2")) {
			CePingBaoGao2 cePingBaoGao2 = cePingBaoGao2Dao
					.getCePingBaoGao2ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao2);
			request.getRequestDispatcher("pages/xlcp/editcpbg2.jsp").forward(
					request, response);
		} else if (lId.equals("3")) {
			CePingBaoGao3 cePingBaoGao3 = cePingBaoGao3Dao
					.getCePingBaoGao3ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao3);
			request.getRequestDispatcher("pages/xlcp/editcpbg3.jsp").forward(
					request, response);
		} else if (lId.equals("4")) {
			CePingBaoGao4 cePingBaoGao4 = cePingBaoGao4Dao
					.getCePingBaoGao4ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao4);
			request.getRequestDispatcher("pages/xlcp/editcpbg4.jsp").forward(
					request, response);
		} else if (lId.equals("5")) {
			CePingBaoGao5 cePingBaoGao5 = cePingBaoGao5Dao
					.getCePingBaoGao5ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao5);
			request.getRequestDispatcher("pages/xlcp/editcpbg5.jsp").forward(
					request, response);
		} else if (lId.equals("6")) {
			CePingBaoGao6 cePingBaoGao6 = cePingBaoGao6Dao
					.getCePingBaoGao6ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao6);
			request.getRequestDispatcher("pages/xlcp/editcpbg6.jsp").forward(
					request, response);
		} else if (lId.equals("7")) {
			CePingBaoGao7 cePingBaoGao7 = cePingBaoGao7Dao
					.getCePingBaoGao7ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao7);
			request.getRequestDispatcher("pages/xlcp/editcpbg7.jsp").forward(
					request, response);
		} else if (lId.equals("8")) {
			CePingBaoGao8 cePingBaoGao8 = cePingBaoGao8Dao
					.getCePingBaoGao8ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao8);
			request.getRequestDispatcher("pages/xlcp/editcpbg8.jsp").forward(
					request, response);
		} else if (lId.equals("9")) {
			CePingBaoGao9 cePingBaoGao9 = cePingBaoGao9Dao
					.getCePingBaoGao9ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao9);
			request.getRequestDispatcher("pages/xlcp/editcpbg9.jsp").forward(
					request, response);
		} else if (lId.equals("10")) {
			CePingBaoGao10 cePingBaoGao10 = cePingBaoGao10Dao
					.getCePingBaoGao10ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao10);
			request.getRequestDispatcher("pages/xlcp/editcpbg10.jsp").forward(
					request, response);
		} else if (lId.equals("11")) {
			CePingBaoGao11 cePingBaoGao11 = cePingBaoGao11Dao
					.getCePingBaoGao11ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao11);
			request.getRequestDispatcher("pages/xlcp/editcpbg11.jsp").forward(
					request, response);
		} else if (lId.equals("12")) {
			CePingBaoGao12 cePingBaoGao12 = cePingBaoGao12Dao
					.getCePingBaoGao12ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao12);
			request.getRequestDispatcher("pages/xlcp/editcpbg12.jsp").forward(
					request, response);
		} else if (lId.equals("13")) {
			CePingBaoGao13 cePingBaoGao13 = cePingBaoGao13Dao
					.getCePingBaoGao13ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao13);
			request.getRequestDispatcher("pages/xlcp/editcpbg13.jsp").forward(
					request, response);
		}else if (lId.equals("14")) {
			CePingBaoGao14 cePingBaoGao14 = cePingBaoGao14Dao
					.getCePingBaoGao14ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao14);
			request.getRequestDispatcher("pages/xlcp/editcpbg14.jsp").forward(
					request, response);
		}else if (lId.equals("15")) {
			CePingBaoGao15 cePingBaoGao15 = cePingBaoGao15Dao
					.getCePingBaoGao15ByCiShuJcxx(ciShu, jcxxId);
			JiChuXinXi j = jiChuXinXiDao.getLittleXinXiById(jcxxId);
			request.setAttribute("j", j);
			request.setAttribute("c", cePingBaoGao15);
			request.getRequestDispatcher("pages/xlcp/editcpbg15.jsp").forward(
					request, response);
		}

	}
	public void ebg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//量表id
		String lbIds = request.getParameter("id");
		//基础信息id
		String jId = request.getParameter("JId");
		String cs = request.getParameter("c");
		//第几个量表
		String lId = request.getParameter("l");

		Integer jcxxId = null;
		Integer ciShu = null;
		Integer lbId = null;

		try {
			jcxxId = Integer.parseInt(jId.trim());
		} catch (Exception e) {

		}
		try {
			ciShu = Integer.parseInt(cs.trim());
		} catch (Exception e) {

		}
		try {
			lbId = Integer.parseInt(lbIds.trim());
		} catch (Exception e) {

		}
		if (lId.equals("1")) {
			CePingBaoGao1 c = new CePingBaoGao1();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			c.setYaoShan(request.getParameter("yaoShan"));
			c.setJianYi(request.getParameter("jianYi"));
			cePingBaoGao1Dao.update(c);
		} else if (lId.equals("2")) {
			CePingBaoGao2 c = new CePingBaoGao2();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			cePingBaoGao2Dao.update(c);
		} else if (lId.equals("3")) {
			CePingBaoGao3 c = new CePingBaoGao3();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			cePingBaoGao3Dao.update(c);
		} else if (lId.equals("4")) {
			CePingBaoGao4 c = new CePingBaoGao4();
			c.setId(lbId);
			c.setBelong1(request.getParameter("belong1"));
			c.setBelong2(request.getParameter("belong2"));
			c.setYiJian1(request.getParameter("yiJian1"));
			c.setYiJian2(request.getParameter("yiJian2"));
			cePingBaoGao4Dao.update(c);
		} else if (lId.equals("5")) {
			CePingBaoGao5 c = new CePingBaoGao5();
			c.setId(lbId);
			c.setBelongQuTiHua(request.getParameter("belongQuTiHua"));
			c.setBelongQiangPoZheng(request.getParameter("belongQiangPoZheng"));
			c.setBelongRenJiGuanXi(request.getParameter("belongRenJiGuanXi"));
			c.setBelongYiYu(request.getParameter("belongYiYu"));
			c.setBelongJiaoLv(request.getParameter("belongJiaoLv"));
			c.setBelongDiDui(request.getParameter("belongDiDui"));
			c.setBelongKongBu(request.getParameter("belongKongBu"));
			c.setBelongPianZhi(request.getParameter("belongPianZhi"));
			c.setBelongJingShenBing(request.getParameter("belongJingShenBing"));
			c.setBelongQiTa(request.getParameter("belongQiTa"));
			cePingBaoGao5Dao.update(c);
		} else if (lId.equals("6")) {
			CePingBaoGao6 c = new CePingBaoGao6();
			c.setId(lbId);
			c.setYiJianP(request.getParameter("yiJianP"));
			c.setYiJianE(request.getParameter("yiJianE"));
			c.setYiJianN(request.getParameter("yiJianN"));
			c.setYiJianL(request.getParameter("yiJianL"));
			c.setBelongP(request.getParameter("belongP"));
			c.setBelongE(request.getParameter("belongE"));
			c.setBelongN(request.getParameter("belongN"));
			c.setBelongL(request.getParameter("belongL"));
			cePingBaoGao6Dao.update(c);
		} else if (lId.equals("7")) {
		} else if (lId.equals("8")) {
			CePingBaoGao8 c = new CePingBaoGao8();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			cePingBaoGao8Dao.update(c);
		} else if (lId.equals("9")) {
			CePingBaoGao9 c = new CePingBaoGao9();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			cePingBaoGao9Dao.update(c);
		} else if (lId.equals("10")) {
			CePingBaoGao10 c = new CePingBaoGao10();
			c.setId(lbId);
			c.setBelong(request.getParameter("yiJian"));
			cePingBaoGao10Dao.update(c);
		} else if (lId.equals("11")) {
			CePingBaoGao11 c = new CePingBaoGao11();
			c.setId(lbId);
			c.setShow(request.getParameter("yiJian"));
			cePingBaoGao11Dao.update(c);
		} else if (lId.equals("12")) {
			CePingBaoGao12 c = new CePingBaoGao12();
			c.setId(lbId);
			c.setShow(request.getParameter("yiJian"));
			cePingBaoGao12Dao.update(c);
		} else if (lId.equals("13")) {
			CePingBaoGao13 c = new CePingBaoGao13();
			c.setId(lbId);
			c.setZhiDaoYiJian(request.getParameter("yiJian"));
			cePingBaoGao13Dao.update(c);
		}else if (lId.equals("14")) {
			CePingBaoGao14 c = new CePingBaoGao14();
			c.setId(lbId);
			c.setYiJian(request.getParameter("yiJian"));
			c.setJianYi(request.getParameter("jianYi"));
			cePingBaoGao14Dao.update(c);
		}else if (lId.equals("15")) {
			CePingBaoGao15 c = new CePingBaoGao15();
			c.setId(lbId);
			c.setBelong(request.getParameter("yiJian"));
			cePingBaoGao15Dao.update(c);
		}
		
		request.getRequestDispatcher("bggl?m=gbg&j="+jcxxId+"&c="+ciShu+"&l="+lId).forward(
				request, response);
	}
	/**
	 * 生成报告
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void mbg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jId = request.getParameter("j");
		String lId = request.getParameter("l");

		Integer jcxxId = null;
		Integer lbId = null;

		try {
			jcxxId = Integer.parseInt(jId.trim());
		} catch (Exception e) {

		}
		try {
			lbId = Integer.parseInt(lId.trim());
		} catch (Exception e) {

		}
		JianCeXiangMu jianCeXiangMu = jianCeXiangMuDao
				.getNewJianCeXiangMusByJcxxId(jcxxId);
		List<DaAn> daAns = daAnDao.getDaAnsByJcIdLbIdCs(jcxxId, lbId,
				jianCeXiangMu.getCiShu());

		if (lId.equals("1")) {
			CePingBaoGao1 c = new ATiZhi().getTiZhi(daAns);
			CanKao canKao = canKaoDao.getCanKaoById(c.getFlag());
			c.setYiJian(canKao.getZhiDaoYiJian());
			c.setJianYi(canKao.getJianYi());
			c.setYaoShan(canKao.getYaoShan());
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());
			c.setRiQi(new Timestamp(new Date().getTime()));

			cePingBaoGao1Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("2")) {
			CePingBaoGao2 c = new BHanMiDunJiaoLv().getHanMiDun(daAns);
			CanKao canKao = canKaoDao.getCanKaoById(c.getFlag());
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());
			c.setRiQi(new Timestamp(new Date().getTime()));
			c.setYiJian(canKao.getZhiDaoYiJian());

			cePingBaoGao2Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("3")) {
			CePingBaoGao3 c = new CHanMiDunYiYu().getHanMiDunYiYu(daAns);
			CanKao canKao = canKaoDao.getCanKaoById(c.getFlag());
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());
			c.setRiQi(new Timestamp(new Date().getTime()));
			c.setYiJian(canKao.getZhiDaoYiJian());

			cePingBaoGao3Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("4")) {
			CePingBaoGao4 c = new DWCPA().getWCPA(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao4Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("5")) {
			CePingBaoGao5 c = new EZhengZhuang90().getZhengZhuang90(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao5Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("6")) {
			CePingBaoGao6 c = new FAiSenKe().getAiSenKe(daAns,
					jianCeXiangMu.getXingBie());
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao6Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("7")) {
			CePingBaoGao7 c = new GJianMingJingShenBing()
					.getJianMingJingShenBing(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao7Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("8")) {
			CePingBaoGao8 c = new HZaoKuang().getZaoKuang(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao8Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("9")) {
			CePingBaoGao9 c = new IChiDaiJianYiShaiCha()
					.getChiDaiJianYiShaiCha(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao9Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("10")) {
			CePingBaoGao10 c = new JChangGuChuanChiDai()
					.getChangGuChuanChiDai(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao10Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("11")) {
			CePingBaoGao11 c = new KYinXing().getYinXing(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao11Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		} else if (lId.equals("12")) {
			CePingBaoGao12 c = new LYangXing().getYangXing(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao12Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		}else if (lId.equals("13")) {
			CePingBaoGao13 c = new MQiangPo().getQiangPo(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao13Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		}else if (lId.equals("14")) {
			CePingBaoGao14 c = new NPHQ9().getPHQ9(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao14Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		}else if (lId.equals("15")) {
			CePingBaoGao15 c = new OGAD7().getGAD7(daAns);
			c.setJiChuXinXiId(jcxxId);
			c.setCiShu(daAns.get(0).getCiShu());

			cePingBaoGao15Dao.save(c);
			xinLiCePingXiangMuDao.jianCed(lbId, jianCeXiangMu.getId());
			response.sendRedirect("bggl?m=gbg&c=" + jianCeXiangMu.getCiShu()
					+ "&j=" + jcxxId + "&l=" + lbId);
		}

	}
}
