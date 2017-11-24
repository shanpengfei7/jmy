package com.jinmayi.servlet.xlcp;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.XinLiCePingXiangMuDao;
import com.jinmayi.dao.impl.xlcp.LiangBiaoDao;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.LiangBiao;
import com.jinmayi.entity.XingLiCePingXiangMu;
/**
 * 选择病人
 * @author pnfy
 *
 */
public class xzbr extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
	XinLiCePingXiangMuDao xinLiCePingXiangMuDao = new XinLiCePingXiangMuDao();
	LiangBiaoDao liangBiaoDao = new LiangBiaoDao();
	
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
	 * 拿到病人的用户ID和密码，把该病人能进行的考试的试卷传到界面，并跳转到选择试卷的界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ibr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String yongHuId = request.getParameter("yong_hu_id");
		String mima = request.getParameter("yong_hu_mi_ma");
//		int id = 0;
//		try{
//			id = Integer.parseInt(yongHuId);
//		} catch (Exception e) {
//			request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
//			return;
//		}
//		JiChuXinXi jiChuXinXi = jiChuXinXiDao.getMimaByidId(id);
		JiChuXinXi jiChuXinXi = jiChuXinXiDao.getIdByYongHuId(yongHuId);
		if(jiChuXinXi != null) {
			if(!jiChuXinXi.getMiMa().equals(mima)) {
				request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
				return;
			}
		} else {
			request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
			return;
		}
		JianCeXiangMu jianCeXiangMu = jianCeXiangMuDao.getNewJianCeXiangMusByJcxxId(jiChuXinXi.getId());
		
		List<XingLiCePingXiangMu> xingLiCePingXiangMus = xinLiCePingXiangMuDao.getXingLiCePingXiangMusByJcxmId(jianCeXiangMu.getId());
		
		for (XingLiCePingXiangMu xingLiCePingXiangMu : xingLiCePingXiangMus) {
			LiangBiao liangBiao = liangBiaoDao.getLiangBiaoById(xingLiCePingXiangMu.getLiangBiaoId());
			xingLiCePingXiangMu.setLiangBiao(liangBiao);
		}
		
		request.setAttribute("xl", xingLiCePingXiangMus);
		request.setAttribute("cs", jianCeXiangMu.getCiShu());
		request.setAttribute("jId", jiChuXinXi.getId());
		
		request.getRequestDispatcher("pages/xlcp/xzsj.jsp").forward(request, response);
	}
	
	
	/**
	 * 直接跳转到选择试卷的界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ibg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try{
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			
		}
		
		JianCeXiangMu jianCeXiangMu = jianCeXiangMuDao.getNewJianCeXiangMusByJcxxId(jId);
		if(jianCeXiangMu == null) {
			request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
			return;
		}
		List<XingLiCePingXiangMu> xingLiCePingXiangMus = xinLiCePingXiangMuDao.getXingLiCePingXiangMusByJcxmId(jianCeXiangMu.getId());
		if(xingLiCePingXiangMus == null) {
			request.getRequestDispatcher("pages/xlcp/xzbr.jsp").forward(request, response);
			return;
		}
		for (XingLiCePingXiangMu xingLiCePingXiangMu : xingLiCePingXiangMus) {
			LiangBiao liangBiao = liangBiaoDao.getLiangBiaoById(xingLiCePingXiangMu.getLiangBiaoId());
			xingLiCePingXiangMu.setLiangBiao(liangBiao);
		}
		
		request.setAttribute("xl", xingLiCePingXiangMus);
		request.setAttribute("cs", jianCeXiangMu.getCiShu());
		request.setAttribute("jId", jId);
		
		request.getRequestDispatcher("pages/xlcp/xzsj.jsp").forward(request, response);
	}

}
