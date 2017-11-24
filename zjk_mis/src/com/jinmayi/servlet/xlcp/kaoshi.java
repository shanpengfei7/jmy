package com.jinmayi.servlet.xlcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinmayi.dao.impl.ShiTiDao;
import com.jinmayi.dao.impl.xlcp.DaAnDao;
import com.jinmayi.entity.DaAn;
import com.jinmayi.entity.ShiTi;
/**
 * 考试
 * @author pnfy
 *
 */
public class kaoshi extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ShiTiDao shiTiDao = new ShiTiDao();
	DaAnDao daAnDao = new DaAnDao();
	
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
	 * 拿到病人要测试的试卷，给该病人配题，并进入病人做题界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("t");
		Integer lId = null;
		try{
			lId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			lId = 0;
		}
		
		List<ShiTi> shiTis = shiTiDao.getShiTiByLiangBiaoId(lId);
		List<DaAn> daAns = daAnDao.getDaAnsByJcIdLbIdCs(Integer.parseInt(request.getParameter("j")), shiTis.get(0).getLiangBiaoId(), Integer.parseInt(request.getParameter("c")));
		
		request.setAttribute("shiTis", shiTis);
		request.setAttribute("cs", request.getParameter("c"));
		request.setAttribute("jId", request.getParameter("j"));
		if(daAns != null) {
			request.setAttribute("daAns", daAns);
		}
		
		request.getRequestDispatcher("pages/xlcp/kaoshi.jsp").forward(request, response);
	}
	
	/**
	 * 提交答案
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void td(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String th = request.getParameter("t");
		String jId = request.getParameter("j");
		String da = request.getParameter("d");
		String lbId = request.getParameter("l");
		String cs = request.getParameter("c");
		Integer tiHao = null;
		Integer jiChuXinXiId = null;
		String daAn = "";
		Integer liangBiaoId = null;
		Integer ciShu = null;
		try{
			tiHao = Integer.parseInt(th.trim());
		} catch (Exception e) {
			tiHao = 0;
		}
		try{
			jiChuXinXiId = Integer.parseInt(jId.trim());
		} catch (Exception e) {
			jiChuXinXiId = 0;
		}
		try{
			daAn = da.trim();
		} catch (Exception e) {
			daAn = "";
		}
		try{
			liangBiaoId = Integer.parseInt(lbId.trim());
		} catch (Exception e) {
			liangBiaoId = 0;
		}
		try{
			ciShu = Integer.parseInt(cs.trim());
		} catch (Exception e) {
			ciShu = 0;
		}
		
		DaAn d = new DaAn();
		d.setTiHao(tiHao);
		d.setJiChuXinXiId(jiChuXinXiId);
		d.setDaAn(daAn);
		d.setLiangBiaoId(liangBiaoId);
		d.setCiShu(ciShu);
		
		daAnDao.save(d);
		
		out.flush();
		out.close();
	}
}
