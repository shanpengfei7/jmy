package com.jinmayi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.jinmayi.dao.impl.CityDao;
import com.jinmayi.dao.impl.DengLuDao;
import com.jinmayi.dao.impl.KeShiDao;
import com.jinmayi.dao.impl.ProvinceDao;
import com.jinmayi.dao.impl.RegionDao;
import com.jinmayi.dao.impl.YiShengDao;
import com.jinmayi.dao.impl.YiYuanDao;
import com.jinmayi.entity.City;
import com.jinmayi.entity.DengLu;
import com.jinmayi.entity.KeShi;
import com.jinmayi.entity.Province;
import com.jinmayi.entity.Region;
import com.jinmayi.entity.YiSheng;
import com.jinmayi.entity.YiYuan;

/**
 * 初始化
 * 
 * @author pnfy
 *
 */
public class csh extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProvinceDao provinceDao = new ProvinceDao();
	CityDao cityDao = new CityDao();
	RegionDao regionDao = new RegionDao();
	YiYuanDao yiYuanDao = new YiYuanDao();
	DengLuDao dengLuDao = new DengLuDao();
	KeShiDao keShiDao = new KeShiDao();
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

	public void dys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer ysId = null;
		try {
			ysId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}

		YiSheng y = yiShengDao.getYiShengById(ysId);
		dengLuDao.delete(y.getDengLuId());
		yiShengDao.delete(ysId);

		out.flush();
		out.close();
	}

	public void gys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer ysId = null;
		try {
			ysId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}

		YiSheng ys = yiShengDao.getYiShengById(ysId);
		DengLu dl = dengLuDao.getDengLuById(ys.getDengLuId());

		JSONObject json = new JSONObject();
		try {
			json.put("xingming", ys.getXingMing());
			json.put("xingbie", ys.getXingBie());
			json.put("juese", ys.getJueSe());
			json.put("iszhuren", ys.getIsZhuRen());
			json.put("lianxifangshi", ys.getLianXiFangShi());
			json.put("keshi", ys.getKeShi());
			json.put("keshi_id", ys.getKeShiId());
			json.put("denglu_id", dl.getId());
			json.put("dlh", dl.getDengLuHao());
			json.put("dlmm", dl.getMiMa());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

		out.flush();
		out.close();
	}

	public void cys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String xing_ming_edit = request.getParameter("xing_ming_edit").trim();
		String xing_bie_edit = request.getParameter("xing_bie_edit").trim();
		String ke_shi_ming_cheng_edit = request.getParameter(
				"ke_shi_ming_cheng_edit").trim();
		String is_zhu_ren_edit = request.getParameter("is_zhu_ren_edit").trim();
		String jue_se_edit = request.getParameter("jue_se_edit").trim();
		String lian_xi_fang_shi_edit = request.getParameter(
				"lian_xi_fang_shi_edit").trim();
		String deng_lu_hao_edit = request.getParameter("deng_lu_hao_edit")
				.trim();
		String mi_ma_edit = request.getParameter("mi_ma_edit");
		String dlId = request.getParameter("dlId_edit").trim();
		String ysId = request.getParameter("ysId_edit").trim();

		YiSheng ys = new YiSheng();
		DengLu dl = new DengLu();

		ys.setIsZhuRen(false);
		if (is_zhu_ren_edit.equals("1")) {
			ys.setIsZhuRen(true);
		}
		ys.setJueSe(jue_se_edit);

		ys.setKeShi(ke_shi_ming_cheng_edit.split(",")[1]);
		ys.setKeShiId(Integer.parseInt(ke_shi_ming_cheng_edit.split(",")[0]));
		ys.setLianXiFangShi(lian_xi_fang_shi_edit);
		ys.setXingBie(Integer.parseInt(xing_bie_edit));
		ys.setXingMing(xing_ming_edit);

		if (deng_lu_hao_edit == null || deng_lu_hao_edit.equals("")) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		} else if (dengLuDao.hasDengLuHao(deng_lu_hao_edit, dl.getId())) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		}

		dl.setDengLuHao(deng_lu_hao_edit);
		dl.setMiMa(mi_ma_edit);
		if (jue_se_edit.equals("测评师")) {
			dl.setQuanXian(3);
		} else if (jue_se_edit.equals("精神科主任")) {
			dl.setQuanXian(4);
		} else if (jue_se_edit.equals("精神科医生")) {
			dl.setQuanXian(5);
		} else if (jue_se_edit.equals("专科主任")) {
			dl.setQuanXian(6);
		} else if (jue_se_edit.equals("专科医生")) {
			dl.setQuanXian(7);
		}

		try {
			dl.setId(Integer.parseInt(dlId));
		} catch (Exception e) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		}

		try {
			ys.setId(Integer.parseInt(ysId));
		} catch (Exception e) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		}

		KeShi keShi = keShiDao
				.getKeShiByName(ke_shi_ming_cheng_edit.split(",")[1]);
		ys.setKeShi(keShi.getMingCheng());
		ys.setKeShiId(keShi.getId());

		dengLuDao.change(dl, dl.getQuanXian());
		yiShengDao.change(ys);
		request.setAttribute("xxk", "ys");
		request.getRequestDispatcher("csh?m=iYyCsh").forward(request, response);

	}

	public void sys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String xing_ming_add = request.getParameter("xing_ming_add").trim();
		String xing_bie_add = request.getParameter("xing_bie_add").trim();
		String ke_shi_ming_cheng_add = request.getParameter(
				"ke_shi_ming_cheng_add").trim();
		String is_zhu_ren_add = request.getParameter("is_zhu_ren_add").trim();
		String jue_se_add = request.getParameter("jue_se_add").trim();
		String lian_xi_fang_shi_add = request.getParameter(
				"lian_xi_fang_shi_add").trim();
		String deng_lu_hao_add = request.getParameter("deng_lu_hao_add").trim();
		String mi_ma_add = request.getParameter("mi_ma_add");

		YiSheng ys = new YiSheng();
		DengLu dl = new DengLu();

		ys.setIsZhuRen(false);
		if (is_zhu_ren_add.equals("1")) {
			ys.setIsZhuRen(true);
		}
		ys.setJueSe(jue_se_add);

		ys.setKeShi(ke_shi_ming_cheng_add.split(",")[1]);
		ys.setKeShiId(Integer.parseInt(ke_shi_ming_cheng_add.split(",")[0]));
		ys.setLianXiFangShi(lian_xi_fang_shi_add);
		ys.setXingBie(Integer.parseInt(xing_bie_add));
		ys.setXingMing(xing_ming_add);

		if (deng_lu_hao_add == null || deng_lu_hao_add.equals("")) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		} else if (dengLuDao.hasDengLuHao(deng_lu_hao_add)) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		}

		dl.setDengLuHao(deng_lu_hao_add);
		dl.setMiMa(mi_ma_add);
		if (jue_se_add.equals("测评师")) {
			dl.setQuanXian(3);
		} else if (jue_se_add.equals("精神科主任")) {
			dl.setQuanXian(4);
		} else if (jue_se_add.equals("精神科医生")) {
			dl.setQuanXian(5);
		} else if (jue_se_add.equals("专科主任")) {
			dl.setQuanXian(6);
		} else if (jue_se_add.equals("专科医生")) {
			dl.setQuanXian(7);
		}

		ys.setDengLuId((int) dengLuDao.save(dl));
		yiShengDao.save(ys, request.getSession(true));
		request.setAttribute("xxk", "ys");
		request.getRequestDispatcher("csh?m=iYyCsh").forward(request, response);
	}

	public void dks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer ksId = null;
		try {
			ksId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}

		keShiDao.delete(ksId);

		out.flush();
		out.close();
	}
	public void wdks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer ksId = null;
		try {
			ksId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}

		keShiDao.willDelete(ksId);

		out.flush();
		out.close();
	}

	public void gks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer ksId = null;
		try {
			ksId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}

		KeShi keShi = keShiDao.getKeShiById(ksId);

		out.print(keShi.getMingCheng());

		out.flush();
		out.close();
	}

	public void cks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ksmc = request.getParameter("ke_shi_ming_cheng_edit");
		String id = request.getParameter("ksId").trim();
		Integer ksId = null;
		try {
			ksId = Integer.parseInt(id);
		} catch (Exception e) {
			response.sendRedirect("csh?m=iYyCsh");
			return;
		}
		KeShi keShi = new KeShi();
		keShi.setMingCheng(ksmc);
		keShi.setId(ksId);

		keShiDao.change(keShi);
		yiShengDao.changeKiShi(keShi);

		response.sendRedirect("csh?m=iYyCsh");
	}

	public void sks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ksmc = request.getParameter("ke_shi_ming_cheng_add");
		KeShi keShi = new KeShi();
		keShi.setMingCheng(ksmc);

		keShiDao.save(keShi, request.getSession(true));

		response.sendRedirect("csh?m=iYyCsh");
	}

	/**
	 * 进入医院角色的初始化界面（对科室，医生，诊疗方案）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iYyCsh(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<KeShi> keShis = keShiDao.getKeShis(request.getSession(true));
		List<YiSheng> yiShengs = yiShengDao.getYiShengs(request
				.getSession(true));

		try {
			if (request.getAttribute("xxk").equals("ys")
					|| request.getParameter("cc").equals("z")) {
				request.setAttribute("xxk", "ys");
			}
		} catch (Exception e) {
			try {
				if (request.getParameter("cc").equals("z")) {
					request.setAttribute("xxk", "ys");
				} else {
					request.setAttribute("xxk", "");
				}
			} catch (Exception ee) {
				request.setAttribute("xxk", "");
			}
		}
		request.setAttribute("keShis", keShis);
		request.setAttribute("yiShengs", yiShengs);
		request.getRequestDispatcher("pages/yy-csh.jsp").forward(request,
				response);
	}

	/**
	 * 进入管理员角色的初始化界面（对医院）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iGlyCsh(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<YiYuan> yiYuans = yiYuanDao.getYiYuans();
		request.setAttribute("yiYuans", yiYuans);
		request.getRequestDispatcher("pages/gly-csh.jsp").forward(request,
				response);
	}

	public void gSheng(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Province> provinces = provinceDao.getProvinces();
		JSONObject json = new JSONObject();

		for (Province province : provinces) {
			try {
				json.put(province.getProvinceId(), province.getProvinceName());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	public void gShi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");

		List<City> cities = cityDao.getCitysByProvinceName(name);
		JSONObject json = new JSONObject();

		for (City city : cities) {
			try {
				json.put(city.getCityName(), city.getCityId());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	public void gXian(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");

		List<Region> regions = regionDao.getRegionsByCityName(name);
		JSONObject json = new JSONObject();

		for (Region region : regions) {
			try {
				json.put(region.getRegionName(), region.getRegionId());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	/**
	 * 得到医院代号
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gYyDh(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 县名
		String name = request.getParameter("name");
		// 地区号
		Region region = regionDao.getRegionByName(name);

		long yiYuanCount = yiYuanDao.getYiYuanCount(region.getRegionId()
				.toString());

		JSONObject json = new JSONObject();

		String daiHao = regionDao.getRegionByName(name).getRegionId()
				+ String.format("%04d", yiYuanCount);

		try {
			json.put("daihao", daiHao);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

		out.flush();
		out.close();
	}

	/**
	 * 保存医院
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sYy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		YiYuan y = new YiYuan();
		DengLu d = new DengLu();
		String dlh = request.getParameter("den_lu_hao_add").trim();
		if (dlh == null || dlh.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		} else if (dengLuDao.hasDengLuHao(dlh)) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		d.setDengLuHao(dlh);
		d.setMiMa(request.getParameter("mi_ma_add"));
		d.setQuanXian(2);

		String mc = request.getParameter("yi_yuan_ming_cheng_add").trim();
		if (mc == null || mc.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setMingCheng(mc);
		y.setLianXiDianHua(request.getParameter("shou_ji_hao_add").trim());

		String daiHao = request.getParameter("yi_yuan_dai_hao_add").trim();
		if (daiHao == null || daiHao.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setDaiHao(daiHao);

		String sheng = request.getParameter("sheng_add").trim();
		if (sheng.equals("0") || sheng == null || sheng.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setSheng(sheng);

		String shi = request.getParameter("shi_add").trim();
		if (shi.equals("0") || shi == null || shi.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setShi(shi);

		String xian = request.getParameter("xian_add").trim();
		if (xian.equals("0") || xian == null || xian.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setXian(xian);

		long yys = yiYuanDao.getYiYuanCount(daiHao.substring(0, 6));
		if (Long.parseLong(daiHao.substring(6)) == yys) {

			y.setDengLuId((int) dengLuDao.save(d));
			yiYuanDao.save(y);
		}
		response.sendRedirect("csh?m=iGlyCsh");
	}

	/**
	 * 修改医院
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void cYy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String yiYuanId = request.getParameter("yyId");

		YiYuan y = new YiYuan();
		DengLu d = new DengLu();

		try {
			y.setId(Integer.parseInt(yiYuanId.trim()));
		} catch (Exception e) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		String dlId = request.getParameter("dlId");
		try {
			d.setId(Integer.parseInt(dlId.trim()));
		} catch (Exception e) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}

		String dlh = request.getParameter("deng_lu_hao_edit").trim();
		if (dlh == null || dlh.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		} else if (dengLuDao.hasDengLuHao(dlh, d.getId())) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		d.setDengLuHao(dlh);
		d.setMiMa(request.getParameter("mi_ma_edit"));

		String mc = request.getParameter("yi_yuan_ming_cheng_edit").trim();
		if (mc == null || mc.equals("")) {
			response.sendRedirect("csh?m=iGlyCsh");
			return;
		}
		y.setMingCheng(mc);
		y.setLianXiDianHua(request.getParameter("shou_ji_hao_edit").trim());

		dengLuDao.change(d);
		yiYuanDao.change(y);
		response.sendRedirect("csh?m=iGlyCsh");
	}

	/**
	 * 得到医院信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gYy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		Integer yyId = null;
		try {
			yyId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}
		YiYuan yy = yiYuanDao.getYiYuanById(yyId);
		DengLu dl = dengLuDao.getDengLuById(yy.getDengLuId());

		JSONObject json = new JSONObject();

		try {
			json.put("dlId", dl.getId());
			json.put("dlh", dl.getDengLuHao());
			json.put("dlmm", dl.getMiMa());
			json.put("mc", yy.getMingCheng());
			json.put("dh", yy.getLianXiDianHua());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

		out.flush();
		out.close();
	}

	public void dYy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();

		Integer yyId = null;
		try {
			yyId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}
		Integer dlId = yiYuanDao.getDengLuIdById(yyId);
		yiYuanDao.delete(yyId);
		dengLuDao.delete(dlId);

		out.flush();
		out.close();
	}
	
	public void wdYy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();

		Integer yyId = null;
		try {
			yyId = Integer.parseInt(id);
		} catch (Exception e) {
			out.flush();
			out.close();
			return;
		}
		Integer dlId = yiYuanDao.getDengLuIdById(yyId);
		yiYuanDao.willDelete(yyId);
		dengLuDao.willDelete(dlId);

		out.flush();
		out.close();
	}

}
