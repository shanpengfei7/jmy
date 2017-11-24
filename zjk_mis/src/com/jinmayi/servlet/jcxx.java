 package com.jinmayi.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.jinmayi.dao.impl.JiChuXinXiDao;
import com.jinmayi.dao.impl.JianCeXiangMuDao;
import com.jinmayi.dao.impl.KeShiDao;
import com.jinmayi.dao.impl.XinLiCePingXiangMuDao;
import com.jinmayi.dao.impl.YiShengDao;
import com.jinmayi.dao.impl.YiYuanDao;
import com.jinmayi.dao.impl.ZhenLiaoFangAnDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;
import com.jinmayi.entity.JianCeXiangMu;
import com.jinmayi.entity.KeShi;
import com.jinmayi.entity.YiSheng;
import com.jinmayi.entity.YiYuan;
import com.jinmayi.entity.ZhenLiaoFangAn;

/**
 * 基础信息
 * 
 * @author pnfy
 *
 */
public class jcxx extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	YiYuanDao yiYuanDao = new YiYuanDao();
	JiChuXinXiDao jiChuXinXiDao = new JiChuXinXiDao();
	YiShengDao yiShengDao = new YiShengDao();
	KeShiDao keShiDao = new KeShiDao();
	ZhenLiaoFangAnDao zhenLiaoFangAnDao = new ZhenLiaoFangAnDao();
	JianCeXiangMuDao jianCeXiangMuDao = new JianCeXiangMuDao();
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

	public void gjc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id);
		} catch (Exception e) {
			jId = 1;
		}
		JiChuXinXi j = jiChuXinXiDao.getJiChuXinXiById(jId);

		JSONObject json = new JSONObject();

		if (j != null) {
			try {
				json.put("yongHuId", j.getYongHuId());
				json.put("riQi", j.getRiQi());
				json.put("menZhenHao", j.getMenZhenHao());
				json.put("bingAnHao", j.getBingAnHao());
				json.put("xingMing", j.getXingMing());
				json.put("xingBie", j.getXingBie());
				json.put("chuShengNian", j.getChuShengNian());
				json.put("chuShengYue", j.getChuShengYue());
				json.put("chuShengRi", j.getChuShengRi());
				json.put("minZu", j.getMinZu());
				json.put("hunYinZhuangKuang", j.getHunYinZhuangKuang());
				json.put("shenGao", j.getShenGao());
				json.put("tiZhong", j.getTiZhong());
				json.put("chuShengDi", j.getChuShengDi());
				json.put("zhiYe", j.getZhiYe());
				json.put("wenHuaChengDu", j.getWenHuaChengDu());
				json.put("paiHang1", j.getPaiHang1());
				json.put("paiHang2", j.getPaiHang2());
				json.put("jingJiZhuangKuang", j.getJingJiZhuangKuang());
				json.put("lianXiDiZhi", j.getLianXiDiZhi());
				json.put("lianXiDianHua", j.getLianXiDianHua());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		out.print(json);

		out.flush();
		out.close();
	}

	/**
	 * 只得到基础信息上面的问题
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void gjjc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id);
		} catch (Exception e) {
			jId = 1;
		}
		JiChuXinXi j = jiChuXinXiDao.getJiChuXinXiById(jId);

		JSONObject json = new JSONObject();

		if (j != null) {
			try {
				json.put("id", j.getId());
				json.put("yongHuId", j.getYongHuId());
				json.put("riQi", j.getRiQi());
				json.put("menZhenHao", j.getMenZhenHao());
				json.put("bingAnHao", j.getBingAnHao());
				json.put("zhuGuanYiShi", j.getZhuGuanYiShi());
				json.put("suoShuKeShi", j.getSuoShuKeShi());
				json.put("zhuanKeYiSheng", j.getZhuanKeYiSheng());
				json.put("xingMing", j.getXingMing());
				json.put("xingBie", j.getXingBie());
				json.put("chuShengNian", j.getChuShengNian());
				json.put("chuShengYue", j.getChuShengYue());
				json.put("chuShengRi", j.getChuShengRi());
				json.put("minZu", j.getMinZu());
				json.put("hunYinZhuangKuang", j.getHunYinZhuangKuang());
				json.put("shenGao", j.getShenGao());
				json.put("tiZhong", j.getTiZhong());
				json.put("chuShengDi", j.getChuShengDi());
				json.put("zhiYe", j.getZhiYe());
				json.put("wenHuaChengDu", j.getWenHuaChengDu());
				json.put("paiHang1", j.getPaiHang1());
				json.put("paiHang2", j.getPaiHang2());
				json.put("jingJiZhuangKuang", j.getJingJiZhuangKuang());
				json.put("lianXiDiZhi", j.getLianXiDiZhi());
				json.put("lianXiDianHua", j.getLianXiDianHua());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		ZhenLiaoFangAn z = zhenLiaoFangAnDao.getJcxmByJcId(jId);
		JianCeXiangMu jcxm = jianCeXiangMuDao
				.getNewAllJianCeXiangMusByJcxxId(jId);
		Integer cs = jianCeXiangMuDao.getCiShuByJcxxId(jId);
		try {
			json.put("jianCeXiangMu", "");
			json.put("xinLiCePingXiangMu", "");
			json.put("ciShu", 0);
			json.put("naoDian", "");
			json.put("ccbt", "");
			json.put("naoRenZhi", "");
			json.put("xinLiCePing", "");
			json.put("yingYan", "");
			json.put("hrv", "");
			json.put("cs", cs);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		if (z != null) {
			if (request.getParameter("x").equals("j")) {
				try {
					json.put("jianCeXiangMu", z.getJianCeXiangMu());
					json.put("xinLiCePingXiangMu", z.getXinLiCePingXiangMu());
					json.put("ciShu", z.getCiShu());

				} catch (JSONException e) {
					e.printStackTrace();
				}

			} else {
				if (jcxm != null) {
					try {
						json.put("ciShu", z.getCiShu());
						json.put("naoDian", jcxm.getNaoDian());
						json.put("ccbt", jcxm.getCcbt());
						json.put("naoRenZhi", jcxm.getNaoRenZhi());
						json.put("xinLiCePing", jcxm.getXinLiCePing());
						json.put("yingYan", jcxm.getYingYan());
						json.put("hrv", jcxm.getHrv());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
		out.print(json);

		out.flush();
		out.close();
	}

	public void cJcxx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = "";
		JiChuXinXi j = new JiChuXinXi();

		try {
			j.setId(Integer.parseInt(request.getParameter("jcxxId").trim()));
		} catch (Exception e) {
			request.getRequestDispatcher("jcxx?m=iJcxx").forward(request,
					response);
			return;
		}

		j.setYongHuId(this.getYongHuId(request.getSession(true)));
		j.setRiQi(new Timestamp(new Date().getTime()));
		j.setMenZhenHao(request.getParameter("men_zhen_hao"));
		j.setBingAnHao(request.getParameter("bing_an_hao"));

		String zhu_guan_yi_shi = request.getParameter("zhu_guan_yi_shi");
		j.setZhuGuanYiShi(zhu_guan_yi_shi);
		String suo_shu_ke_shi = request.getParameter("suo_shu_ke_shi");
		j.setSuoShuKeShi(suo_shu_ke_shi);
		String zhuan_ke_yi_sheng = request.getParameter("zhuan_ke_yi_sheng");
		j.setZhuanKeYiSheng(zhuan_ke_yi_sheng);
		String xing_ming = request.getParameter("xing_ming");
		j.setXingMing(xing_ming.trim());
		String xing_bie = request.getParameter("xing_bie");
		if (xing_bie != null) {
			if (xing_bie.equals("男")) {
				j.setXingBie(1);
			} else if (xing_bie.equals("女")) {
				j.setXingBie(2);
			}
		}
		String nian = request.getParameter("nian");
		try {
			j.setChuShengNian(Integer.parseInt(nian));
		} catch (Exception e) {

		}
		String yue = request.getParameter("yue");
		try {
			j.setChuShengYue(Integer.parseInt(yue));
		} catch (Exception e) {

		}
		String ri = request.getParameter("ri");
		try {
			j.setChuShengRi(Integer.parseInt(ri));
		} catch (Exception e) {

		}
		String min_zu = request.getParameter("min_zu");
		j.setMinZu(min_zu);
		String hun_yin_zhuang_kuang = request
				.getParameter("hun_yin_zhuang_kuang");
		j.setHunYinZhuangKuang(hun_yin_zhuang_kuang);
		String shen_gao = request.getParameter("shen_gao");
		try {
			j.setShenGao(Integer.parseInt(shen_gao));
		} catch (Exception e) {

		}
		String ti_zhong = request.getParameter("ti_zhong");
		try {
			j.setTiZhong(Integer.parseInt(ti_zhong));
		} catch (Exception e) {

		}
		String chu_sheng_di = request.getParameter("chu_sheng_di");
		j.setChuShengDi(chu_sheng_di);
		String zhi_ye = request.getParameter("zhi_ye");
		j.setZhiYe(zhi_ye);
		String wen_hua_cheng_du = request.getParameter("wen_hua_cheng_du");
		j.setWenHuaChengDu(wen_hua_cheng_du);
		String jia_li_pai_hang_1 = request.getParameter("jia_li_pai_hang_1");
		try {
			j.setPaiHang1(Integer.parseInt(jia_li_pai_hang_1));
		} catch (Exception e) {

		}
		String jia_li_pai_hang_2 = request.getParameter("jia_li_pai_hang_2");
		try {
			j.setPaiHang2(Integer.parseInt(jia_li_pai_hang_2));
		} catch (Exception e) {

		}
		String jing_ji_zhuang_kuang = request
				.getParameter("jing_ji_zhuang_kuang");
		if (jing_ji_zhuang_kuang != null) {
			if (jing_ji_zhuang_kuang.equals("良好")) {
				j.setJingJiZhuangKuang(1);
			} else if (jing_ji_zhuang_kuang.equals("一般")) {
				j.setJingJiZhuangKuang(2);
			} else if (jing_ji_zhuang_kuang.equals("较差")) {
				j.setJingJiZhuangKuang(3);
			} else if (jing_ji_zhuang_kuang.equals("很差")) {
				j.setJingJiZhuangKuang(4);
			}
		}
		String lian_xi_di_zhi = request.getParameter("lian_xi_di_zhi");
		j.setLianXiDiZhi(lian_xi_di_zhi);
		String lian_xi_dian_hua = request.getParameter("lian_xi_dian_hua");
		j.setLianXiDianHua(lian_xi_dian_hua);

		String[] jiu_zhen_yuan_yin = request
				.getParameterValues("jiu_zhen_yuan_yin");
		if (jiu_zhen_yuan_yin != null) {
			for (String a : jiu_zhen_yuan_yin) {
				str = str + "|" + a;
			}
			j.setJiuZhenYuanYin(str.substring(1));
			str = "";
		}

		String[] shuimian = request.getParameterValues("shuimian");
		if (shuimian != null) {
			for (String a : shuimian) {
				str = str + "|" + a;
			}
			j.setShuiMian(str.substring(1));
			str = "";
		}

		// 接收到前台食欲的状态
		String shiyu = request.getParameter("shiyu");
		if (shiyu != null) {
			if (shiyu.equals("良好")) {
				j.setShiYu(1);
			} else if (shiyu.equals("一般")) {
				j.setShiYu(2);
			} else if (shiyu.equals("欠佳")) {
				j.setShiYu(3);
			}
		}

		// 接收到前台性生活的状况
		String xingshenghuo = request.getParameter("xingshenghuo");
		if (xingshenghuo != null) {
			if (xingshenghuo.equals("良好")) {
				j.setXingShengHuo(1);
			} else if (xingshenghuo.equals("一般")) {
				j.setXingShengHuo(2);
			} else if (xingshenghuo.equals("欠佳")) {
				j.setXingShengHuo(3);
			}
		}

		// 接收到前台第一个“是否出现”
		String[] chu_xian_1 = request.getParameterValues("chu_xian_1");
		if (chu_xian_1 != null) {
			for (String a : chu_xian_1) {
				str = str + "|" + a;
			}
			j.setChuXian1(str.substring(1));
			str = "";
		}

		// 接收到前台第二个“是否出现”
		String[] chu_xian2 = request.getParameterValues("chu_xian2");
		if (chu_xian2 != null) {
			for (String a : chu_xian2) {
				str = str + "|" + a;
			}
			j.setChuXian2(str.substring(1));
			str = "";
		}

		// 接受到前台传来的现病史是否发作
		String xian_has_lei_si_fa_zuo = request
				.getParameter("xian_has_lei_si_fa_zuo");
		if (xian_has_lei_si_fa_zuo != null) {
			if (xian_has_lei_si_fa_zuo.equals("反复发作")) {
				j.setXianLeiSiFaZuo(1);
			} else if (xian_has_lei_si_fa_zuo.equals("间断发作")) {
				j.setXianLeiSiFaZuo(2);
			} else if (xian_has_lei_si_fa_zuo.equals("偶发")) {
				j.setXianLeiSiFaZuo(3);
			}
		}

		// 接收到前台的现病史躯体病
		String xian_has_qu_ti_ji_bing = request
				.getParameter("xian_has_qu_ti_ji_bing");
		if (xian_has_qu_ti_ji_bing != null) {
			if (xian_has_qu_ti_ji_bing.equals("无")) {
				j.setXianQuTiJiBing(1);
			} else if (xian_has_qu_ti_ji_bing.equals("偶发")) {
				j.setXianQuTiJiBing(2);
			}
		}

		// 接受到前台先病史的诊断，时间和用药史
		String xian_bing_shi = request.getParameter("xian_bing_shi");
		j.setXianJuTiJiBingZhenDuan(xian_bing_shi);

		// 接受到前台过往病史是否有发作
		String ji_wang_has_lei_si_fa_zuo = request
				.getParameter("ji_wang_has_lei_si_fa_zuo");
		if (ji_wang_has_lei_si_fa_zuo != null) {
			if (ji_wang_has_lei_si_fa_zuo.equals("无")) {
				j.setJiWangLeiSiFaZuo(1);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("偶发")) {
				j.setJiWangLeiSiFaZuo(2);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("多发")) {
				j.setJiWangLeiSiFaZuo(3);
			}
		}

		// 接收到前台过往病史躯体病
		String ji_wang_has_qu_ti_ji_bing = request
				.getParameter("ji_wang_has_qu_ti_ji_bing");
		if (ji_wang_has_qu_ti_ji_bing != null) {
			if (ji_wang_has_qu_ti_ji_bing.equals("无")) {
				j.setJiWangQuTiJiBing(1);
			} else if (ji_wang_has_qu_ti_ji_bing.equals("偶发")) {
				j.setJiWangQuTiJiBing(2);
			}
		}

		// 接收前台过往病史的诊断，时间和用药史
		String ji_wang_bing_shi = request.getParameter("ji_wang_bing_shi");
		j.setJiWangJuTiJiBingZhenDuan(ji_wang_bing_shi);

		// 接收到前台家族是否有病史
		String jia_zu_has_ji_bing = request.getParameter("jia_zu_has_ji_bing"); // 有疑问
		if (jia_zu_has_ji_bing != null) {
			if (jia_zu_has_ji_bing.equals("无")) {
				j.setJiaZuBingShi(1);
			} else if (jia_zu_has_ji_bing.equals("偶发")) {
				j.setJiaZuBingShi(2);
			}
		}

		// 接收到前台家族病史的诊断，时间和用药史
		String jia_zu_bing_shi = request.getParameter("jia_zu_bing_shi"); // 有疑问
		j.setJiaZuJuTiJiBingZhenDuan(jia_zu_bing_shi);

		// 接收到前台个性特点
		String xingge = request.getParameter("xingge");
		if (xingge != null) {
			if (xingge.equals("内向")) {
				j.setGeXingTeDian(1);
			} else if (xingge.equals("外向")) {
				j.setGeXingTeDian(2);
			} else if (xingge.equals("适中")) {
				j.setGeXingTeDian(3);
			}
		}

		// 接受带前台的情绪稳定性
		String qingxu = request.getParameter("qingxu");
		if (qingxu != null) {
			if (qingxu.equals("稳定")) {
				j.setQingXuWenDingXing(1);
			} else if (qingxu.equals("欠稳定")) {
				j.setQingXuWenDingXing(2);
			}
		}

		//
		String tedian = request.getParameter("tedian");
		if (tedian != null) {
			if (tedian.equals("A型")) {
				j.setRenGeTeDian(1);
			} else if (tedian.equals("B型")) {
				j.setRenGeTeDian(2);
			} else if (tedian.equals("C型")) {
				j.setRenGeTeDian(3);
			}
		}

		// 接收到前台血型
		String xuexing = request.getParameter("xuexing");
		if (xuexing != null) {
			if (xuexing.equals("A型")) {
				j.setXueXing(1);
			} else if (xuexing.equals("B型")) {
				j.setXueXing(2);
			} else if (xuexing.equals("AB型")) {
				j.setXueXing(3);
			} else if (xuexing.equals("O型")) {
				j.setXueXing(4);
			}
		}

		// 接收到前台的人格特质
		String[] renge = request.getParameterValues("renge");
		if (renge != null) {
			for (String a : renge) {
				str = str + "|" + a;
			}
			j.setRenGeTeZhi(str.substring(1));
			str = "";
		}

		// 接收到前台兴趣
		String[] xingqu = request.getParameterValues("xingqu");
		if (xingqu != null) {
			for (String a : xingqu) {
				str = str + "|" + a;
			}
			j.setXingQu(str.substring(1));
			str = "";
		}

		// 接收到前台的每天吸烟的数/支
		String yan = request.getParameter("ya");
		try {
			j.setYan(Integer.parseInt(yan));
		} catch (Exception e) {

		}

		// 接受带前台的每天喝酒的数/两
		String jiu = request.getParameter("jiu");
		try {
			j.setJiu(Integer.parseInt(jiu));
		} catch (Exception e) {

		}

		// 接受到前台的其他爱好
		String qi = request.getParameter("yan_jiu_qi_ta");
		j.setYanJiuQiTa(qi);

		// 接收到前台=的生长发育
		String[] shengzhang = request.getParameterValues("shengzhang");
		if (shengzhang != null) {
			for (String a : shengzhang) {
				str = str + "|" + a;
			}
			j.setShengZhangFaYu(str.substring(1));
			str = "";
		}

		// 接收到前台的学会走路的年龄
		String walk = request.getParameter("walk");
		try {
			j.setXueBu(Integer.parseInt(walk));
		} catch (Exception e) {

		}

		// 接收到前台的会说话的年龄
		String talk = request.getParameter("talk");
		try {
			j.setYuYan(Integer.parseInt(talk));
		} catch (Exception e) {

		}
		// 接受到前台的月经的年龄
		String yuejing = request.getParameter("yuejing");
		try {
			j.setYueJingChuChao(Integer.parseInt(yuejing));
		} catch (Exception e) {

		}

		// 接收到前台的遗精的年龄
		String yijing = request.getParameter("yijing");
		try {
			j.setShouCiYiJing(Integer.parseInt(yijing));
		} catch (Exception e) {

		}

		// 接收到前台的停经的年龄
		String ting = request.getParameter("ting");
		try {
			j.setTingJing(Integer.parseInt(ting));
		} catch (Exception e) {

		}

		// 接收到前台的抚养人的信息
		String[] fuyangren = request.getParameterValues("fuyangren");
		if (fuyangren != null) {
			for (String a : fuyangren) {
				str = str + "|" + a;
			}
			j.setYouNianFuYangRen(str.substring(1));
			str = "";
		}

		// 接受到前台的寄养开始的年龄
		String jiyang1 = request.getParameter("jiyang1");
		try {
			j.setJiYangShi1(Integer.parseInt(jiyang1));
		} catch (Exception e) {

		}

		// 接收到前台的寄养结束的年龄
		String jiyang2 = request.getParameter("jiyang2");
		try {
			j.setJiYangShi2(Integer.parseInt(jiyang2));
		} catch (Exception e) {

		}

		// 接收到前台的幼年生活环境
		String[] you_nian_huan_jing = request
				.getParameterValues("you_nian_huan_jing");
		if (you_nian_huan_jing != null) {
			for (String a : you_nian_huan_jing) {
				str = str + "|" + a;
			}
			j.setYouNianShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// 接收到前台的现在的生活环境
		String[] xian_zai_huan_jing = request
				.getParameterValues("xian_zai_huan_jing");
		if (xian_zai_huan_jing != null) {
			for (String a : xian_zai_huan_jing) {
				str = str + "|" + a;
			}
			j.setXianZaiShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// 接收到前台的与兄弟姐妹的关系
		String yu_xiong_di_jie_mei_guan_xi = request
				.getParameter("yu_xiong_di_jie_mei_guan_xi");
		if (yu_xiong_di_jie_mei_guan_xi != null) {
			if (yu_xiong_di_jie_mei_guan_xi.equals("良好")) {
				j.setXiongDiJieMeiGuanXi(1);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("尚可")) {
				j.setXiongDiJieMeiGuanXi(2);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("一般")) {
				j.setXiongDiJieMeiGuanXi(3);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("冷淡")) {
				j.setXiongDiJieMeiGuanXi(4);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("差")) {
				j.setXiongDiJieMeiGuanXi(5);
			}
		}

		// 接收到前台的夫妻关系
		String fu_qi_guan_xi = request.getParameter("fu_qi_guan_xi");
		if (fu_qi_guan_xi != null) {
			if (fu_qi_guan_xi.equals("良好")) {
				j.setFuQiGuanXi(1);
			} else if (fu_qi_guan_xi.equals("尚可")) {
				j.setFuQiGuanXi(2);
			} else if (fu_qi_guan_xi.equals("一般")) {
				j.setFuQiGuanXi(3);
			} else if (fu_qi_guan_xi.equals("冷淡")) {
				j.setFuQiGuanXi(4);
			} else if (fu_qi_guan_xi.equals("差")) {
				j.setFuQiGuanXi(5);
			}
		}

		// 接收到前台的婆媳关系
		String po_xi_guan_xi = request.getParameter("po_xi_guan_xi");
		if (po_xi_guan_xi != null) {
			if (po_xi_guan_xi.equals("良好")) {
				j.setPoXiGuanXi(1);
			} else if (po_xi_guan_xi.equals("尚可")) {
				j.setPoXiGuanXi(2);
			} else if (po_xi_guan_xi.equals("一般")) {
				j.setPoXiGuanXi(3);
			} else if (po_xi_guan_xi.equals("冷淡")) {
				j.setPoXiGuanXi(4);
			} else if (po_xi_guan_xi.equals("差")) {
				j.setPoXiGuanXi(5);
			}
		}

		// 接收到前台的父亲的职业
		String fu_qin_zhi_ye = request.getParameter("fu_qin_zhi_ye");
		j.setFuQinZhiYe(fu_qin_zhi_ye);

		// 接收到前台的母亲的职业
		String mu_qin_zhi_ye = request.getParameter("mu_qin_zhi_ye");
		j.setMuQinZhiYe(mu_qin_zhi_ye);

		// 父亲文化程度
		String fu_qin_wen_hua = request.getParameter("fu_qin_wen_hua");
		j.setFuQinWenHuaChengDu(fu_qin_wen_hua);

		// 母亲文化程度
		String mu_qin_wen_hua = request.getParameter("mu_qin_wen_hua");
		j.setMuQinWenHuaChengDu(mu_qin_wen_hua);

		// 负性事件
		String fu_xing_shi_jian = request.getParameter("fu_xing_shi_jian");
		if (fu_xing_shi_jian != null) {
			if (fu_xing_shi_jian.equals("无")) {
				j.setZhongDaFuXingShiJian1(1);
			} else if (fu_xing_shi_jian.equals("有")) {
				j.setZhongDaFuXingShiJian1(2);
			}
		}

		// 负性事件内容
		String fu_xing_shi_jian_nei_rong = request
				.getParameter("fu_xing_shi_jian_nei_rong");
		j.setZhongDaFuXingShiJian2(fu_xing_shi_jian_nei_rong);

		// 应激事件
		String ying_ji_shi_jian = request.getParameter("ying_ji_shi_jian");
		if (ying_ji_shi_jian != null) {
			if (ying_ji_shi_jian.equals("无")) {
				j.setYingJiShiJian1(1);
			} else if (ying_ji_shi_jian.equals("有")) {
				j.setYingJiShiJian1(2);
			}
		}

		// 应激事件内容
		String ying_ji_shi_jian_nei_rong = request
				.getParameter("ying_ji_shi_jian_nei_rong");
		j.setYingJiShiJian2(ying_ji_shi_jian_nei_rong);

		// 人际关系
		String renjiguanxi = request.getParameter("renjiguanxi");
		if (renjiguanxi != null) {
			if (renjiguanxi.equals("良好")) {
				j.setRenJiGuanXi(1);
			} else if (renjiguanxi.equals("一般")) {
				j.setRenJiGuanXi(2);
			} else if (renjiguanxi.equals("欠佳")) {
				j.setRenJiGuanXi(3);
			}
		}

		// 问题表现为
		String[] wenti = request.getParameterValues("wenti");
		if (wenti != null) {
			for (String a : wenti) {
				str = str + "|" + a;
			}
			j.setWenTiBiaoXianWei(str.substring(1));
			str = "";
		}

		// 问题发生在：
		String[] wentifasheng = request.getParameterValues("wentifasheng");
		if (wentifasheng != null) {
			for (String a : wentifasheng) {
				str = str + "|" + a;
			}
			j.setWenTiFaShengZai(str.substring(1));
			str = "";
		}

		// 问题发生在其他
		String qitafangmian = request.getParameter("qitafangmian");
		j.setWenTiFaShengQiTa(qitafangmian);

		// 生活满意与否
		String shenghuomianyiyufou = request
				.getParameter("shenghuomianyiyufou");
		if (shenghuomianyiyufou != null) {
			if (shenghuomianyiyufou.equals("满意")) {
				j.setShengHuoManYiYuFou(1);
			} else if (shenghuomianyiyufou.equals("尚可")) {
				j.setShengHuoManYiYuFou(2);
			} else if (shenghuomianyiyufou.equals("不满意")) {
				j.setShengHuoManYiYuFou(3);
			}
		}

		// 不满意的方面
		String[] bu_man_yi_fang_mian = request
				.getParameterValues("bu_man_yi_fang_mian");
		if (bu_man_yi_fang_mian != null) {
			for (String a : bu_man_yi_fang_mian) {
				str = str + "|" + a;
			}
			j.setBuManYiDeFangMian(str.substring(1));
			str = "";
		}

		// String bu_man_yi_fang_mian_qi_ta =
		// request.getParameter("bu_man_yi_fang_mian_qi_ta");

		// 疾病认知
		String ji_bing_ren_zhi = request.getParameter("ji_bing_ren_zhi");
		if (ji_bing_ren_zhi != null) {
			if (ji_bing_ren_zhi.equals("完全正确")) {
				j.setDangQianJiBingRenZhi(1);
			} else if (ji_bing_ren_zhi.equals("基本正确")) {
				j.setDangQianJiBingRenZhi(2);
			} else if (ji_bing_ren_zhi.equals("不正确")) {
				j.setDangQianJiBingRenZhi(3);
			} else if (ji_bing_ren_zhi.equals("基本错误")) {
				j.setDangQianJiBingRenZhi(4);
			} else if (ji_bing_ren_zhi.equals("完全错误")) {
				j.setDangQianJiBingRenZhi(5);
			}
		}

		// 疾病愈后态度
		String taidu = request.getParameter("taidu");
		if (taidu != null) {
			if (taidu.equals("非常乐观")) {
				j.setJiBingYuHouTaiDu(1);
			} else if (taidu.equals("乐观")) {
				j.setJiBingYuHouTaiDu(2);
			} else if (taidu.equals("不确定")) {
				j.setJiBingYuHouTaiDu(3);
			} else if (taidu.equals("消极")) {
				j.setJiBingYuHouTaiDu(4);
			} else if (taidu.equals("非常消极")) {
				j.setJiBingYuHouTaiDu(5);
			}
		}

		// 应对方式
		String yingduifangshi = request.getParameter("yingduifangshi");
		if (yingduifangshi != null) {
			if (yingduifangshi.equals("非常积极")) {
				j.setYingDuiFangShi(1);
			} else if (yingduifangshi.equals("积极")) {
				j.setYingDuiFangShi(2);
			} else if (yingduifangshi.equals("一般")) {
				j.setYingDuiFangShi(3);
			} else if (yingduifangshi.equals("消极")) {
				j.setYingDuiFangShi(4);
			} else if (yingduifangshi.equals("非常消极")) {
				j.setYingDuiFangShi(5);
			}
		}

		// 治疗参与程度
		String zhiliaocanyu = request.getParameter("zhiliaocanyu");
		if (zhiliaocanyu != null) {
			if (zhiliaocanyu.equals("积极主动")) {
				j.setZhiLiaoCanYuChengDu(1);
			} else if (zhiliaocanyu.equals("消极被动")) {
				j.setZhiLiaoCanYuChengDu(2);
			} else if (zhiliaocanyu.equals("一般")) {
				j.setZhiLiaoCanYuChengDu(3);
			}
		}

		// 社会参与
		String shehuizhichi = request.getParameter("shehuizhichi");
		if (shehuizhichi != null) {
			if (shehuizhichi.equals("极差")) {
				j.setSheHuiZhiChi(1);
			} else if (shehuizhichi.equals("差")) {
				j.setSheHuiZhiChi(2);
			} else if (shehuizhichi.equals("一般")) {
				j.setSheHuiZhiChi(3);
			} else if (shehuizhichi.equals("好")) {
				j.setSheHuiZhiChi(4);
			} else if (shehuizhichi.equals("极好")) {
				j.setSheHuiZhiChi(5);
			}
		}

		// 朋友
		String pengyou = request.getParameter("pengyou");
		if (pengyou != null) {
			if (pengyou.equals("极差")) {
				j.setPengYou(1);
			} else if (pengyou.equals("差")) {
				j.setPengYou(2);
			} else if (pengyou.equals("一般")) {
				j.setPengYou(3);
			} else if (pengyou.equals("好")) {
				j.setPengYou(4);
			} else if (pengyou.equals("极好")) {
				j.setPengYou(5);
			}
		}

		// 家人
		String jiaren = request.getParameter("jiaren");
		if (jiaren != null) {
			if (jiaren.equals("极差")) {
				j.setJiaRen(1);
			} else if (jiaren.equals("差")) {
				j.setJiaRen(2);
			} else if (jiaren.equals("一般")) {
				j.setJiaRen(3);
			} else if (jiaren.equals("好")) {
				j.setJiaRen(4);
			} else if (jiaren.equals("极好")) {
				j.setJiaRen(5);
			}
		}

		// 对各项的支持利用度
		String gexiangzhichi = request.getParameter("gexiangzhichi");
		if (gexiangzhichi != null) {
			if (gexiangzhichi.equals("极差")) {
				j.setDuiGeXiangZhiChiLiYongDu(1);
			} else if (gexiangzhichi.equals("差")) {
				j.setDuiGeXiangZhiChiLiYongDu(2);
			} else if (gexiangzhichi.equals("一般")) {
				j.setDuiGeXiangZhiChiLiYongDu(3);
			} else if (gexiangzhichi.equals("好")) {
				j.setDuiGeXiangZhiChiLiYongDu(4);
			} else if (gexiangzhichi.equals("极好")) {
				j.setDuiGeXiangZhiChiLiYongDu(5);
			}
		}

		String yin_xiang = request.getParameter("yin_xiang");
		if (yin_xiang != null) {
			if (yin_xiang.equals("神经衰弱")) {
				j.setYinXiang(1);
			} else if (yin_xiang.equals("植物神经功能紊乱")) {
				j.setYinXiang(2);
			} else if (yin_xiang.equals("焦虑状态")) {
				j.setYinXiang(3);
			} else if (yin_xiang.equals("抑郁状态")) {
				j.setYinXiang(4);
			} else if (yin_xiang.equals("焦虑抑郁状态")) {
				j.setYinXiang(5);
			} else if (yin_xiang.equals("强迫状态")) {
				j.setYinXiang(6);
			} else if (yin_xiang.equals("躁狂状态")) {
				j.setYinXiang(7);
			} else if (yin_xiang.equals("妄想状态")) {
				j.setYinXiang(8);
			}
		}

		// 印象其他
		String yin_xiang_qi_ta = request.getParameter("yin_xiang_qi_ta");
		j.setYinXiangQiTa(yin_xiang_qi_ta);

		// 处置
		String chu_zhi = request.getParameter("chu_zhi");
		if (chu_zhi != null) {
			if (chu_zhi.equals("心身测评（脑功能检测，HRV检测，精神科A,B C类量表）")) {
				j.setChuZhi(1);
			} else if (chu_zhi.equals("心脑检测（脑功能检测，HRV，首访量表）")) {
				j.setChuZhi(2);
			} else if (chu_zhi.equals("植物神经功能检测（HRV，首访量表）")) {
				j.setChuZhi(3);
			}
		}

		jiChuXinXiDao.change(j, request.getSession(true));

		request.getRequestDispatcher("jcxx?m=iJcxx").forward(request, response);
	}

	public void sJcxx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = "";
		JiChuXinXi j = new JiChuXinXi();

		j.setYongHuId(this.getYongHuId(request.getSession(true)));
		j.setRiQi(new Timestamp(new Date().getTime()));
		j.setMenZhenHao(request.getParameter("men_zhen_hao"));
		j.setBingAnHao(request.getParameter("bing_an_hao"));

		String zhu_guan_yi_shi = request.getParameter("zhu_guan_yi_shi");
		j.setZhuGuanYiShi(zhu_guan_yi_shi);
		String suo_shu_ke_shi = request.getParameter("suo_shu_ke_shi");
		j.setSuoShuKeShi(suo_shu_ke_shi);
		String zhuan_ke_yi_sheng = request.getParameter("zhuan_ke_yi_sheng");
		j.setZhuanKeYiSheng(zhuan_ke_yi_sheng);
		String xing_ming = request.getParameter("xing_ming");
		j.setXingMing(xing_ming.trim());
		String xing_bie = request.getParameter("xing_bie");
		if (xing_bie != null) {
			if (xing_bie.equals("男")) {
				j.setXingBie(1);
			} else if (xing_bie.equals("女")) {
				j.setXingBie(2);
			}
		}
		String nian = request.getParameter("nian");
		try {
			j.setChuShengNian(Integer.parseInt(nian));
		} catch (Exception e) {

		}
		String yue = request.getParameter("yue");
		try {
			j.setChuShengYue(Integer.parseInt(yue));
		} catch (Exception e) {

		}
		String ri = request.getParameter("ri");
		try {
			j.setChuShengRi(Integer.parseInt(ri));
		} catch (Exception e) {

		}
		String min_zu = request.getParameter("min_zu");
		j.setMinZu(min_zu);
		String hun_yin_zhuang_kuang = request
				.getParameter("hun_yin_zhuang_kuang");
		j.setHunYinZhuangKuang(hun_yin_zhuang_kuang);
		String shen_gao = request.getParameter("shen_gao");
		try {
			j.setShenGao(Integer.parseInt(shen_gao));
		} catch (Exception e) {

		}
		String ti_zhong = request.getParameter("ti_zhong");
		try {
			j.setTiZhong(Integer.parseInt(ti_zhong));
		} catch (Exception e) {

		}
		String chu_sheng_di = request.getParameter("chu_sheng_di");
		j.setChuShengDi(chu_sheng_di);
		String zhi_ye = request.getParameter("zhi_ye");
		j.setZhiYe(zhi_ye);
		String wen_hua_cheng_du = request.getParameter("wen_hua_cheng_du");
		j.setWenHuaChengDu(wen_hua_cheng_du);
		String jia_li_pai_hang_1 = request.getParameter("jia_li_pai_hang_1");
		try {
			j.setPaiHang1(Integer.parseInt(jia_li_pai_hang_1));
		} catch (Exception e) {

		}
		String jia_li_pai_hang_2 = request.getParameter("jia_li_pai_hang_2");
		try {
			j.setPaiHang2(Integer.parseInt(jia_li_pai_hang_2));
		} catch (Exception e) {

		}
		String jing_ji_zhuang_kuang = request
				.getParameter("jing_ji_zhuang_kuang");
		if (jing_ji_zhuang_kuang != null) {
			if (jing_ji_zhuang_kuang.equals("良好")) {
				j.setJingJiZhuangKuang(1);
			} else if (jing_ji_zhuang_kuang.equals("一般")) {
				j.setJingJiZhuangKuang(2);
			} else if (jing_ji_zhuang_kuang.equals("较差")) {
				j.setJingJiZhuangKuang(3);
			} else if (jing_ji_zhuang_kuang.equals("很差")) {
				j.setJingJiZhuangKuang(4);
			}
		}
		String lian_xi_di_zhi = request.getParameter("lian_xi_di_zhi");
		j.setLianXiDiZhi(lian_xi_di_zhi);
		String lian_xi_dian_hua = request.getParameter("lian_xi_dian_hua");
		j.setLianXiDianHua(lian_xi_dian_hua);

		String[] jiu_zhen_yuan_yin = request
				.getParameterValues("jiu_zhen_yuan_yin");
		if (jiu_zhen_yuan_yin != null) {
			for (String a : jiu_zhen_yuan_yin) {
				str = str + "|" + a;
			}
			j.setJiuZhenYuanYin(str.substring(1));
			str = "";
		}

		String[] shuimian = request.getParameterValues("shuimian");
		if (shuimian != null) {
			for (String a : shuimian) {
				str = str + "|" + a;
			}
			j.setShuiMian(str.substring(1));
			str = "";
		}

		// 接收到前台食欲的状态
		String shiyu = request.getParameter("shiyu");
		if (shiyu != null) {
			if (shiyu.equals("良好")) {
				j.setShiYu(1);
			} else if (shiyu.equals("一般")) {
				j.setShiYu(2);
			} else if (shiyu.equals("欠佳")) {
				j.setShiYu(3);
			}
		}

		// 接收到前台性生活的状况
		String xingshenghuo = request.getParameter("xingshenghuo");
		if (xingshenghuo != null) {
			if (xingshenghuo.equals("良好")) {
				j.setXingShengHuo(1);
			} else if (xingshenghuo.equals("一般")) {
				j.setXingShengHuo(2);
			} else if (xingshenghuo.equals("欠佳")) {
				j.setXingShengHuo(3);
			}
		}

		// 接收到前台第一个“是否出现”
		String[] chu_xian_1 = request.getParameterValues("chu_xian_1");
		if (chu_xian_1 != null) {
			for (String a : chu_xian_1) {
				str = str + "|" + a;
			}
			j.setChuXian1(str.substring(1));
			str = "";
		}

		// 接收到前台第二个“是否出现”
		String[] chu_xian2 = request.getParameterValues("chu_xian2");
		if (chu_xian2 != null) {
			for (String a : chu_xian2) {
				str = str + "|" + a;
			}
			j.setChuXian2(str.substring(1));
			str = "";
		}

		// 接受到前台传来的现病史是否发作
		String xian_has_lei_si_fa_zuo = request
				.getParameter("xian_has_lei_si_fa_zuo");
		if (xian_has_lei_si_fa_zuo != null) {
			if (xian_has_lei_si_fa_zuo.equals("反复发作")) {
				j.setXianLeiSiFaZuo(1);
			} else if (xian_has_lei_si_fa_zuo.equals("间断发作")) {
				j.setXianLeiSiFaZuo(2);
			} else if (xian_has_lei_si_fa_zuo.equals("偶发")) {
				j.setXianLeiSiFaZuo(3);
			}
		}

		// 接收到前台的现病史躯体病
		String xian_has_qu_ti_ji_bing = request
				.getParameter("xian_has_qu_ti_ji_bing");
		if (xian_has_qu_ti_ji_bing != null) {
			if (xian_has_qu_ti_ji_bing.equals("无")) {
				j.setXianQuTiJiBing(1);
			} else if (xian_has_qu_ti_ji_bing.equals("偶发")) {
				j.setXianQuTiJiBing(2);
			}
		}

		// 接受到前台先病史的诊断，时间和用药史
		String xian_bing_shi = request.getParameter("xian_bing_shi");
		j.setXianJuTiJiBingZhenDuan(xian_bing_shi);

		// 接受到前台过往病史是否有发作
		String ji_wang_has_lei_si_fa_zuo = request
				.getParameter("ji_wang_has_lei_si_fa_zuo");
		if (ji_wang_has_lei_si_fa_zuo != null) {
			if (ji_wang_has_lei_si_fa_zuo.equals("无")) {
				j.setJiWangLeiSiFaZuo(1);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("偶发")) {
				j.setJiWangLeiSiFaZuo(2);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("多发")) {
				j.setJiWangLeiSiFaZuo(3);
			}
		}

		// 接收到前台过往病史躯体病
		String ji_wang_has_qu_ti_ji_bing = request
				.getParameter("ji_wang_has_qu_ti_ji_bing");
		if (ji_wang_has_qu_ti_ji_bing != null) {
			if (ji_wang_has_qu_ti_ji_bing.equals("无")) {
				j.setJiWangQuTiJiBing(1);
			} else if (ji_wang_has_qu_ti_ji_bing.equals("偶发")) {
				j.setJiWangQuTiJiBing(2);
			}
		}

		// 接收前台过往病史的诊断，时间和用药史
		String ji_wang_bing_shi = request.getParameter("ji_wang_bing_shi");
		j.setJiWangJuTiJiBingZhenDuan(ji_wang_bing_shi);

		// 接收到前台家族是否有病史
		String jia_zu_has_ji_bing = request.getParameter("jia_zu_has_ji_bing"); // 有疑问
		if (jia_zu_has_ji_bing != null) {
			if (jia_zu_has_ji_bing.equals("无")) {
				j.setJiaZuBingShi(1);
			} else if (jia_zu_has_ji_bing.equals("偶发")) {
				j.setJiaZuBingShi(2);
			}
		}

		// 接收到前台家族病史的诊断，时间和用药史
		String jia_zu_bing_shi = request.getParameter("jia_zu_bing_shi"); // 有疑问
		j.setJiaZuJuTiJiBingZhenDuan(jia_zu_bing_shi);

		// 接收到前台个性特点
		String xingge = request.getParameter("xingge");
		if (xingge != null) {
			if (xingge.equals("内向")) {
				j.setGeXingTeDian(1);
			} else if (xingge.equals("外向")) {
				j.setGeXingTeDian(2);
			} else if (xingge.equals("适中")) {
				j.setGeXingTeDian(3);
			}
		}

		// 接受带前台的情绪稳定性
		String qingxu = request.getParameter("qingxu");
		if (qingxu != null) {
			if (qingxu.equals("稳定")) {
				j.setQingXuWenDingXing(1);
			} else if (qingxu.equals("欠稳定")) {
				j.setQingXuWenDingXing(2);
			}
		}

		//
		String tedian = request.getParameter("tedian");
		if (tedian != null) {
			if (tedian.equals("A型")) {
				j.setRenGeTeDian(1);
			} else if (tedian.equals("B型")) {
				j.setRenGeTeDian(2);
			} else if (tedian.equals("C型")) {
				j.setRenGeTeDian(3);
			}
		}

		// 接收到前台血型
		String xuexing = request.getParameter("xuexing");
		if (xuexing != null) {
			if (xuexing.equals("A型")) {
				j.setXueXing(1);
			} else if (xuexing.equals("B型")) {
				j.setXueXing(2);
			} else if (xuexing.equals("AB型")) {
				j.setXueXing(3);
			} else if (xuexing.equals("O型")) {
				j.setXueXing(4);
			}
		}

		// 接收到前台的人格特质
		String[] renge = request.getParameterValues("renge");
		if (renge != null) {
			for (String a : renge) {
				str = str + "|" + a;
			}
			j.setRenGeTeZhi(str.substring(1));
			str = "";
		}

		// 接收到前台兴趣
		String[] xingqu = request.getParameterValues("xingqu");
		if (xingqu != null) {
			for (String a : xingqu) {
				str = str + "|" + a;
			}
			j.setXingQu(str.substring(1));
			str = "";
		}

		// 接收到前台的每天吸烟的数/支
		String yan = request.getParameter("ya");
		try {
			j.setYan(Integer.parseInt(yan));
		} catch (Exception e) {

		}

		// 接受带前台的每天喝酒的数/两
		String jiu = request.getParameter("jiu");
		try {
			j.setJiu(Integer.parseInt(jiu));
		} catch (Exception e) {

		}

		// 接受到前台的其他爱好
		String qi = request.getParameter("yan_jiu_qi_ta");
		j.setYanJiuQiTa(qi);

		// 接收到前台=的生长发育
		String[] shengzhang = request.getParameterValues("shengzhang");
		if (shengzhang != null) {
			for (String a : shengzhang) {
				str = str + "|" + a;
			}
			j.setShengZhangFaYu(str.substring(1));
			str = "";
		}

		// 接收到前台的学会走路的年龄
		String walk = request.getParameter("walk");
		try {
			j.setXueBu(Integer.parseInt(walk));
		} catch (Exception e) {

		}

		// 接收到前台的会说话的年龄
		String talk = request.getParameter("talk");
		try {
			j.setYuYan(Integer.parseInt(talk));
		} catch (Exception e) {

		}
		// 接受到前台的月经的年龄
		String yuejing = request.getParameter("yuejing");
		try {
			j.setYueJingChuChao(Integer.parseInt(yuejing));
		} catch (Exception e) {

		}

		// 接收到前台的遗精的年龄
		String yijing = request.getParameter("yijing");
		try {
			j.setShouCiYiJing(Integer.parseInt(yijing));
		} catch (Exception e) {

		}

		// 接收到前台的停经的年龄
		String ting = request.getParameter("ting");
		try {
			j.setTingJing(Integer.parseInt(ting));
		} catch (Exception e) {

		}

		// 接收到前台的抚养人的信息
		String[] fuyangren = request.getParameterValues("fuyangren");
		if (fuyangren != null) {
			for (String a : fuyangren) {
				str = str + "|" + a;
			}
			j.setYouNianFuYangRen(str.substring(1));
			str = "";
		}

		// 接受到前台的寄养开始的年龄
		String jiyang1 = request.getParameter("jiyang1");
		try {
			j.setJiYangShi1(Integer.parseInt(jiyang1));
		} catch (Exception e) {

		}

		// 接收到前台的寄养结束的年龄
		String jiyang2 = request.getParameter("jiyang2");
		try {
			j.setJiYangShi2(Integer.parseInt(jiyang2));
		} catch (Exception e) {

		}

		// 接收到前台的幼年生活环境
		String[] you_nian_huan_jing = request
				.getParameterValues("you_nian_huan_jing");
		if (you_nian_huan_jing != null) {
			for (String a : you_nian_huan_jing) {
				str = str + "|" + a;
			}
			j.setYouNianShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// 接收到前台的现在的生活环境
		String[] xian_zai_huan_jing = request
				.getParameterValues("xian_zai_huan_jing");
		if (xian_zai_huan_jing != null) {
			for (String a : xian_zai_huan_jing) {
				str = str + "|" + a;
			}
			j.setXianZaiShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// 接收到前台的与兄弟姐妹的关系
		String yu_xiong_di_jie_mei_guan_xi = request
				.getParameter("yu_xiong_di_jie_mei_guan_xi");
		if (yu_xiong_di_jie_mei_guan_xi != null) {
			if (yu_xiong_di_jie_mei_guan_xi.equals("良好")) {
				j.setXiongDiJieMeiGuanXi(1);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("尚可")) {
				j.setXiongDiJieMeiGuanXi(2);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("一般")) {
				j.setXiongDiJieMeiGuanXi(3);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("冷淡")) {
				j.setXiongDiJieMeiGuanXi(4);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("差")) {
				j.setXiongDiJieMeiGuanXi(5);
			}
		}

		// 接收到前台的夫妻关系
		String fu_qi_guan_xi = request.getParameter("fu_qi_guan_xi");
		if (fu_qi_guan_xi != null) {
			if (fu_qi_guan_xi.equals("良好")) {
				j.setFuQiGuanXi(1);
			} else if (fu_qi_guan_xi.equals("尚可")) {
				j.setFuQiGuanXi(2);
			} else if (fu_qi_guan_xi.equals("一般")) {
				j.setFuQiGuanXi(3);
			} else if (fu_qi_guan_xi.equals("冷淡")) {
				j.setFuQiGuanXi(4);
			} else if (fu_qi_guan_xi.equals("差")) {
				j.setFuQiGuanXi(5);
			}
		}

		// 接收到前台的婆媳关系
		String po_xi_guan_xi = request.getParameter("po_xi_guan_xi");
		if (po_xi_guan_xi != null) {
			if (po_xi_guan_xi.equals("良好")) {
				j.setPoXiGuanXi(1);
			} else if (po_xi_guan_xi.equals("尚可")) {
				j.setPoXiGuanXi(2);
			} else if (po_xi_guan_xi.equals("一般")) {
				j.setPoXiGuanXi(3);
			} else if (po_xi_guan_xi.equals("冷淡")) {
				j.setPoXiGuanXi(4);
			} else if (po_xi_guan_xi.equals("差")) {
				j.setPoXiGuanXi(5);
			}
		}

		// 接收到前台的父亲的职业
		String fu_qin_zhi_ye = request.getParameter("fu_qin_zhi_ye");
		j.setFuQinZhiYe(fu_qin_zhi_ye);

		// 接收到前台的母亲的职业
		String mu_qin_zhi_ye = request.getParameter("mu_qin_zhi_ye");
		j.setMuQinZhiYe(mu_qin_zhi_ye);

		// 父亲文化程度
		String fu_qin_wen_hua = request.getParameter("fu_qin_wen_hua");
		j.setFuQinWenHuaChengDu(fu_qin_wen_hua);

		// 母亲文化程度
		String mu_qin_wen_hua = request.getParameter("mu_qin_wen_hua");
		j.setMuQinWenHuaChengDu(mu_qin_wen_hua);

		// 负性事件
		String fu_xing_shi_jian = request.getParameter("fu_xing_shi_jian");
		if (fu_xing_shi_jian != null) {
			if (fu_xing_shi_jian.equals("无")) {
				j.setZhongDaFuXingShiJian1(1);
			} else if (fu_xing_shi_jian.equals("有")) {
				j.setZhongDaFuXingShiJian1(2);
			}
		}

		// 负性事件内容
		String fu_xing_shi_jian_nei_rong = request
				.getParameter("fu_xing_shi_jian_nei_rong");
		j.setZhongDaFuXingShiJian2(fu_xing_shi_jian_nei_rong);

		// 应激事件
		String ying_ji_shi_jian = request.getParameter("ying_ji_shi_jian");
		if (ying_ji_shi_jian != null) {
			if (ying_ji_shi_jian.equals("无")) {
				j.setYingJiShiJian1(1);
			} else if (ying_ji_shi_jian.equals("有")) {
				j.setYingJiShiJian1(2);
			}
		}

		// 应激事件内容
		String ying_ji_shi_jian_nei_rong = request
				.getParameter("ying_ji_shi_jian_nei_rong");
		j.setYingJiShiJian2(ying_ji_shi_jian_nei_rong);

		// 人际关系
		String renjiguanxi = request.getParameter("renjiguanxi");
		if (renjiguanxi != null) {
			if (renjiguanxi.equals("良好")) {
				j.setRenJiGuanXi(1);
			} else if (renjiguanxi.equals("一般")) {
				j.setRenJiGuanXi(2);
			} else if (renjiguanxi.equals("欠佳")) {
				j.setRenJiGuanXi(3);
			}
		}

		// 问题表现为
		String[] wenti = request.getParameterValues("wenti");
		if (wenti != null) {
			for (String a : wenti) {
				str = str + "|" + a;
			}
			j.setWenTiBiaoXianWei(str.substring(1));
			str = "";
		}

		// 问题发生在：
		String[] wentifasheng = request.getParameterValues("wentifasheng");
		if (wentifasheng != null) {
			for (String a : wentifasheng) {
				str = str + "|" + a;
			}
			j.setWenTiFaShengZai(str.substring(1));
			str = "";
		}

		// 问题发生在其他
		String qitafangmian = request.getParameter("qitafangmian");
		j.setWenTiFaShengQiTa(qitafangmian);

		// 生活满意与否
		String shenghuomianyiyufou = request
				.getParameter("shenghuomianyiyufou");
		if (shenghuomianyiyufou != null) {
			if (shenghuomianyiyufou.equals("满意")) {
				j.setShengHuoManYiYuFou(1);
			} else if (shenghuomianyiyufou.equals("尚可")) {
				j.setShengHuoManYiYuFou(2);
			} else if (shenghuomianyiyufou.equals("不满意")) {
				j.setShengHuoManYiYuFou(3);
			}
		}

		// 不满意的方面
		String[] bu_man_yi_fang_mian = request
				.getParameterValues("bu_man_yi_fang_mian");
		if (bu_man_yi_fang_mian != null) {
			for (String a : bu_man_yi_fang_mian) {
				str = str + "|" + a;
			}
			j.setBuManYiDeFangMian(str.substring(1));
			str = "";
		}

		// String bu_man_yi_fang_mian_qi_ta =
		// request.getParameter("bu_man_yi_fang_mian_qi_ta");

		// 疾病认知
		String ji_bing_ren_zhi = request.getParameter("ji_bing_ren_zhi");
		if (ji_bing_ren_zhi != null) {
			if (ji_bing_ren_zhi.equals("完全正确")) {
				j.setDangQianJiBingRenZhi(1);
			} else if (ji_bing_ren_zhi.equals("基本正确")) {
				j.setDangQianJiBingRenZhi(2);
			} else if (ji_bing_ren_zhi.equals("不正确")) {
				j.setDangQianJiBingRenZhi(3);
			} else if (ji_bing_ren_zhi.equals("基本错误")) {
				j.setDangQianJiBingRenZhi(4);
			} else if (ji_bing_ren_zhi.equals("完全错误")) {
				j.setDangQianJiBingRenZhi(5);
			}
		}

		// 疾病愈后态度
		String taidu = request.getParameter("taidu");
		if (taidu != null) {
			if (taidu.equals("非常乐观")) {
				j.setJiBingYuHouTaiDu(1);
			} else if (taidu.equals("乐观")) {
				j.setJiBingYuHouTaiDu(2);
			} else if (taidu.equals("不确定")) {
				j.setJiBingYuHouTaiDu(3);
			} else if (taidu.equals("消极")) {
				j.setJiBingYuHouTaiDu(4);
			} else if (taidu.equals("非常消极")) {
				j.setJiBingYuHouTaiDu(5);
			}
		}

		// 应对方式
		String yingduifangshi = request.getParameter("yingduifangshi");
		if (yingduifangshi != null) {
			if (yingduifangshi.equals("非常积极")) {
				j.setYingDuiFangShi(1);
			} else if (yingduifangshi.equals("积极")) {
				j.setYingDuiFangShi(2);
			} else if (yingduifangshi.equals("一般")) {
				j.setYingDuiFangShi(3);
			} else if (yingduifangshi.equals("消极")) {
				j.setYingDuiFangShi(4);
			} else if (yingduifangshi.equals("非常消极")) {
				j.setYingDuiFangShi(5);
			}
		}

		// 治疗参与程度
		String zhiliaocanyu = request.getParameter("zhiliaocanyu");
		if (zhiliaocanyu != null) {
			if (zhiliaocanyu.equals("积极主动")) {
				j.setZhiLiaoCanYuChengDu(1);
			} else if (zhiliaocanyu.equals("消极被动")) {
				j.setZhiLiaoCanYuChengDu(2);
			} else if (zhiliaocanyu.equals("一般")) {
				j.setZhiLiaoCanYuChengDu(3);
			}
		}

		// 社会参与
		String shehuizhichi = request.getParameter("shehuizhichi");
		if (shehuizhichi != null) {
			if (shehuizhichi.equals("极差")) {
				j.setSheHuiZhiChi(1);
			} else if (shehuizhichi.equals("差")) {
				j.setSheHuiZhiChi(2);
			} else if (shehuizhichi.equals("一般")) {
				j.setSheHuiZhiChi(3);
			} else if (shehuizhichi.equals("好")) {
				j.setSheHuiZhiChi(4);
			} else if (shehuizhichi.equals("极好")) {
				j.setSheHuiZhiChi(5);
			}
		}

		// 朋友
		String pengyou = request.getParameter("pengyou");
		if (pengyou != null) {
			if (pengyou.equals("极差")) {
				j.setPengYou(1);
			} else if (pengyou.equals("差")) {
				j.setPengYou(2);
			} else if (pengyou.equals("一般")) {
				j.setPengYou(3);
			} else if (pengyou.equals("好")) {
				j.setPengYou(4);
			} else if (pengyou.equals("极好")) {
				j.setPengYou(5);
			}
		}

		// 家人
		String jiaren = request.getParameter("jiaren");
		if (jiaren != null) {
			if (jiaren.equals("极差")) {
				j.setJiaRen(1);
			} else if (jiaren.equals("差")) {
				j.setJiaRen(2);
			} else if (jiaren.equals("一般")) {
				j.setJiaRen(3);
			} else if (jiaren.equals("好")) {
				j.setJiaRen(4);
			} else if (jiaren.equals("极好")) {
				j.setJiaRen(5);
			}
		}

		// 对各项的支持利用度
		String gexiangzhichi = request.getParameter("gexiangzhichi");
		if (gexiangzhichi != null) {
			if (gexiangzhichi.equals("极差")) {
				j.setDuiGeXiangZhiChiLiYongDu(1);
			} else if (gexiangzhichi.equals("差")) {
				j.setDuiGeXiangZhiChiLiYongDu(2);
			} else if (gexiangzhichi.equals("一般")) {
				j.setDuiGeXiangZhiChiLiYongDu(3);
			} else if (gexiangzhichi.equals("好")) {
				j.setDuiGeXiangZhiChiLiYongDu(4);
			} else if (gexiangzhichi.equals("极好")) {
				j.setDuiGeXiangZhiChiLiYongDu(5);
			}
		}

		String yin_xiang = request.getParameter("yin_xiang");
		if (yin_xiang != null) {
			if (yin_xiang.equals("神经衰弱")) {
				j.setYinXiang(1);
			} else if (yin_xiang.equals("植物神经功能紊乱")) {
				j.setYinXiang(2);
			} else if (yin_xiang.equals("焦虑状态")) {
				j.setYinXiang(3);
			} else if (yin_xiang.equals("抑郁状态")) {
				j.setYinXiang(4);
			} else if (yin_xiang.equals("焦虑抑郁状态")) {
				j.setYinXiang(5);
			} else if (yin_xiang.equals("强迫状态")) {
				j.setYinXiang(6);
			} else if (yin_xiang.equals("躁狂状态")) {
				j.setYinXiang(7);
			} else if (yin_xiang.equals("妄想状态")) {
				j.setYinXiang(8);
			}
		}

		// 印象其他
		String yin_xiang_qi_ta = request.getParameter("yin_xiang_qi_ta");
		j.setYinXiangQiTa(yin_xiang_qi_ta);

		// 处置
		String chu_zhi = request.getParameter("chu_zhi");
		if (chu_zhi != null) {
			if (chu_zhi.equals("心身测评（脑功能检测，HRV检测，精神科A,B C类量表）")) {
				j.setChuZhi(1);
			} else if (chu_zhi.equals("心脑检测（脑功能检测，HRV，首访量表）")) {
				j.setChuZhi(2);
			} else if (chu_zhi.equals("植物神经功能检测（HRV，首访量表）")) {
				j.setChuZhi(3);
			}
		}

		jiChuXinXiDao.save(j, request.getSession(true));

		request.getRequestDispatcher("jcxm?m=iJcxmAdd").forward(request,
				response);
	}

	/**
	 * 进入病人首诊（基础）信息添加的界面，病人不是第一次来这个医院，界面中，可以直接调出以前在这个医院填写的基础信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iHtbrAdd(HttpServletRequest request,
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
		List<YiSheng> ys = yiShengDao.getZhuGuanYiShisBySession(session);
		List<KeShi> ks = keShiDao.getKeShisBySession(session);
		session.setAttribute("token", UUID.randomUUID());
		request.setAttribute("token", session.getAttribute("token"));
		Page<JiChuXinXi> page = jiChuXinXiDao.getPage(pageNow, s, session, true);
		request.setAttribute("j", request.getParameter("j"));
		request.setAttribute("page", page);
		request.setAttribute("f", request.getParameter("f"));
		request.setAttribute("zhuGuanYiShengs", ys);
		request.setAttribute("keShis", ks);
		request.setAttribute("shou_zhen_ri_qi",
				new Timestamp(new Date().getTime()));
		request.getRequestDispatcher("pages/htbr-add.jsp").forward(request,
				response);
	}

	/**
	 * 进入病人首诊（基础）信息添加的界面，病人第一次来这个医院
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iJcxxAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<YiSheng> ys = yiShengDao.getZhuGuanYiShisBySession(request
				.getSession());
		List<KeShi> ks = keShiDao.getKeShisBySession(request.getSession());

		HttpSession session = request.getSession();
		session.setAttribute("token", UUID.randomUUID());
		request.setAttribute("token", session.getAttribute("token"));

		request.setAttribute("zhuGuanYiShengs", ys);
		request.setAttribute("keShis", ks);
		request.setAttribute("shou_zhen_ri_qi",
				new Timestamp(new Date().getTime()));
		request.getRequestDispatcher("pages/jcxx-add.jsp").forward(request,
				response);
	}

	public void gzkys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String ks = request.getParameter("ks");
		List<YiSheng> yiShengs = yiShengDao.getZhuanKeYiShengsBySessionKeShi(
				request.getSession(), ks);

		JSONObject json = new JSONObject();

		if (yiShengs != null) {
			for (int i = 0; i< yiShengs.size(); i++) {
				try {
					json.put("" + i, yiShengs.get(i).getXingMing());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		out.print(json);

		out.flush();
		out.close();
	}

	public void gJcxx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer jId = null;
		try {
			jId = Integer.parseInt(id.trim());
		} catch (Exception e) {
			jId = 1;
		}
		
		
		List<YiSheng> ys = yiShengDao.getZhuGuanYiShisBySession(request
				.getSession());
		List<KeShi> ks = keShiDao.getKeShisBySession(request.getSession());

		request.setAttribute("zhuGuanYiShengs", ys);
		request.setAttribute("keShis", ks);
		
		request.setAttribute("j", jiChuXinXiDao.getAllJiChuXinXiById(jId));
		String z = request.getParameter("z");
		if (z.equals("b")) {
			request.getRequestDispatcher("pages/jcxx-edit.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("pages/jcxx-xq.jsp").forward(request,
					response);
		}
	}

	/**
	 * 进入基础信息列表的界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void iJcxx(HttpServletRequest request, HttpServletResponse response)
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

		Page<JiChuXinXi> page = jiChuXinXiDao.getPage(pageNow, s,
				request.getSession(), false);

		request.setAttribute("page", page);

		request.getRequestDispatcher("pages/jcxx.jsp").forward(request,
				response);
	}

	private String getYongHuId(HttpSession session) {
		Integer id = Integer.parseInt(session.getAttribute("yiYuanId")
				.toString());
		YiYuan yiYuan = yiYuanDao.getYiYuanById(id);
		String yyDh = yiYuan.getDaiHao();

		Date d = new Timestamp(new Date().getTime());
		String t = d.toString().split(" ")[0];
		String[] y = t.split("-");
		String date = y[0].substring(2, 4) + y[1] + y[2];

		String num = String.format("%06d", yiYuan.getTodayCount());
		yiYuanDao.setTodayById(id);
		return yyDh + date + num + this.getCheck(yyDh + date + num);
	}

	private String getCheck(String str) {
		final int[] wi = { 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
				5, 8, 4, 2, 1 };
		// verify digit
		final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] ai = new int[22];
		int remaining = 0;
		if (str.length() == 22) {
			int sum = 0;
			for (int i = 0; i < 22; i++) {
				String k = str.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}

			for (int i = 0; i < 22; i++) {
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}

		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void sssht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// 可以上传多个文件
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {

					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString("UTF-8");
					if (name.equals("token")) {
						String token = session.getAttribute("token").toString();
						if (token.equals(value)) {
//							j.setYongHuId(this.getYongHuId(request.getSession(true)));
							j.setRiQi(new Timestamp(new Date().getTime()));
						} else {
							response.sendRedirect("jcxm?m=iJcxmAdd");
							return;
						}
						
					}
					session.removeAttribute("token");
					if (name.equals("yong_hu_id")) {
						if(value.equals("")) {
							response.sendRedirect("jcxm?m=iHtbrAdd");
							return;
						} else {
							j.setYongHuId(value);
						}
					}
					if (name.equals("men_zhen_hao")) {
						j.setMenZhenHao(value);
					}
					if (name.equals("bing_an_hao")) {
						j.setBingAnHao(value);
					}

					if ("zhu_guan_yi_shi".equals(name)) {

						j.setZhuGuanYiShi(value);
					}
					if ("suo_shu_ke_shi".equals(name)) {
						j.setSuoShuKeShi(value);
					}
					if ("zhuan_ke_yi_sheng".equals(name)) {
						j.setZhuanKeYiSheng(value);
					}
					if ("xing_ming".equals(name)) {
						j.setXingMing(value.trim());
					}
					if ("xing_bie".equals(name)) {
						if (value.equals("男")) {
							j.setXingBie(1);
						} else if (value.equals("女")) {
							j.setXingBie(2);
						}
					}
					if ("nian".equals(name)) {
						try {
							j.setChuShengNian(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("yue".equals(name)) {
						try {
							j.setChuShengYue(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ri".equals(name)) {
						try {
							j.setChuShengRi(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("min_zu".equals(name)) {
						j.setMinZu(value);
					}
					if ("hun_yin_zhuang_kuang".equals(name)) {
						j.setHunYinZhuangKuang(value);
					}
					if ("shen_gao".equals(name)) {
						try {
							j.setShenGao(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ti_zhong".equals(name)) {
						try {
							j.setTiZhong(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("chu_sheng_di".equals(name)) {
						j.setChuShengDi(value);
					}
					if ("zhi_ye".equals(name)) {
						j.setZhiYe(value);
					}
					if ("wen_hua_cheng_du".equals(name)) {
						j.setWenHuaChengDu(value);
					}
					if ("jia_li_pai_hang_1".equals(name)) {
						try {
							j.setPaiHang1(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("jia_li_pai_hang_2".equals(name)) {
						try {
							j.setPaiHang2(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("jing_ji_zhuang_kuang".equals(name)) {
						if (value.equals("良好")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("一般")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("较差")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("很差")) {
							j.setJingJiZhuangKuang(4);
						}
					}
					if ("lian_xi_di_zhi".equals(name)) {
						j.setLianXiDiZhi(value);
					}
					if ("lian_xi_dian_hua".equals(name)) {
						j.setLianXiDianHua(value);
					}

					if ("jiu_zhen_yuan_yin".equals(name)) {

						j.setJiuZhenYuanYin(j.getJiuZhenYuanYin() + "|" + value);
						if (j.getJiuZhenYuanYin().startsWith("null|")) {
							j.setJiuZhenYuanYin(j.getJiuZhenYuanYin()
									.substring(5));
						}
					}

					if ("shuimian".equals(name)) {

						j.setShuiMian(j.getShuiMian() + "|" + value);
						if (j.getShuiMian().startsWith("null|")) {
							j.setShuiMian(j.getShuiMian().substring(5));
						}
					}

					// 接收到前台食欲的状态
					if ("shiyu".equals(name)) {
						if (value.equals("良好")) {
							j.setShiYu(1);
						} else if (value.equals("一般")) {
							j.setShiYu(2);
						} else if (value.equals("欠佳")) {
							j.setShiYu(3);
						}
					}

					// 接收到前台性生活的状况
					if ("xingshenghuo".equals(name)) {
						if (value.equals("良好")) {
							j.setXingShengHuo(1);
						} else if (value.equals("一般")) {
							j.setXingShengHuo(2);
						} else if (value.equals("欠佳")) {
							j.setXingShengHuo(3);
						}
					}

					// 接收到前台第一个“是否出现”
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// 接收到前台第二个“是否出现”
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// 接受到前台传来的现病史是否发作
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("反复发作")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("间断发作")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("偶发")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("无")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// 接收到前台的现病史躯体病
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// 接受到前台先病史的诊断，时间和用药史
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// 接受到前台过往病史是否有发作
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("偶发")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("多发")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// 接收到前台过往病史躯体病
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// 接收前台过往病史的诊断，时间和用药史
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// 接收到前台家族是否有病史
					if ("jia_zu_has_ji_bing".equals(name)) { // 有疑问
						if (value.equals("无")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("偶发")) {
							j.setJiaZuBingShi(2);
						}
					}

					// 接收到前台家族病史的诊断，时间和用药史
					if ("jia_zu_bing_shi".equals(name)) { // 有疑问
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// 接收到前台个性特点
					if ("xingge".equals(name)) {
						if (value.equals("内向")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("外向")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("适中")) {
							j.setGeXingTeDian(3);
						}
					}

					// 接受带前台的情绪稳定性
					if ("qingxu".equals(name)) {
						if (value.equals("稳定")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("欠稳定")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A型")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B型")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C型")) {
							j.setRenGeTeDian(3);
						}
					}

					// 接收到前台血型
					if ("xuexing".equals(name)) {
						if (value.equals("A型")) {
							j.setXueXing(1);
						} else if (value.equals("B型")) {
							j.setXueXing(2);
						} else if (value.equals("AB型")) {
							j.setXueXing(3);
						} else if (value.equals("O型")) {
							j.setXueXing(4);
						}
					}

					// 接收到前台的人格特质
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// 接收到前台兴趣
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// 接收到前台的每天吸烟的数/支
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受带前台的每天喝酒的数/两
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受到前台的其他爱好
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// 接收到前台=的生长发育
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// 接收到前台的学会走路的年龄
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的会说话的年龄
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// 接受到前台的月经的年龄
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的遗精的年龄
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的停经的年龄
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的抚养人的信息
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// 接受到前台的寄养开始的年龄
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的寄养结束的年龄
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的幼年生活环境
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的现在的生活环境
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的与兄弟姐妹的关系
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("差")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// 接收到前台的夫妻关系
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("差")) {
							j.setFuQiGuanXi(5);
						}
					}

					// 接收到前台的婆媳关系
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("差")) {
							j.setPoXiGuanXi(5);
						}
					}
					// 接收到前台的亲子关系
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("差")) {
							j.setQinZiGuanXi(5);
						}
					}

					// // 接收到前台的父亲的职业
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// 接收到前台的母亲的职业
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// 父亲文化程度
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// 母亲文化程度
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// 负性事件
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("有")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// 负性事件内容
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// 应激事件
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("有")) {
							j.setYingJiShiJian1(2);
						}
					}

					// 应激事件内容
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// 人际关系
					if ("renjiguanxi".equals(name)) {
						if (value.equals("良好")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("一般")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("欠佳")) {
							j.setRenJiGuanXi(3);
						}
					}

					// 问题表现为
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// 问题发生在：
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// 问题发生在其他
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// 生活满意与否
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("满意")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("尚可")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("不满意")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// 不满意的方面
					if ("bu_man_yi_fang_mian".equals(name)) {
						j.setBuManYiDeFangMian(j.getBuManYiDeFangMian() + "|"
								+ value);
						if (j.getBuManYiDeFangMian().startsWith("null|")) {
							j.setBuManYiDeFangMian(j.getBuManYiDeFangMian()
									.substring(5));
						}
					}

					// String bu_man_yi_fang_mian_qi_ta =
					// request.getParameter("bu_man_yi_fang_mian_qi_ta");

					// 疾病认知
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("完全正确")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("基本正确")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("不正确")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("基本错误")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("完全错误")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// 疾病愈后态度
					if ("taidu".equals(name)) {
						if (value.equals("非常乐观")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("乐观")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("不确定")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("消极")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("非常消极")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// 应对方式
					if ("yingduifangshi".equals(name)) {
						if (value.equals("非常积极")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("积极")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("一般")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("消极")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("非常消极")) {
							j.setYingDuiFangShi(5);
						}
					}

					// 治疗参与程度
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("积极主动")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("消极被动")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("一般")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// 社会参与
					if ("shehuizhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("差")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("一般")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("好")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("极好")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// 朋友
					if ("pengyou".equals(name)) {
						if (value.equals("极差")) {
							j.setPengYou(1);
						} else if (value.equals("差")) {
							j.setPengYou(2);
						} else if (value.equals("一般")) {
							j.setPengYou(3);
						} else if (value.equals("好")) {
							j.setPengYou(4);
						} else if (value.equals("极好")) {
							j.setPengYou(5);
						}
					}

					// 家人
					if ("jiaren".equals(name)) {
						if (value.equals("极差")) {
							j.setJiaRen(1);
						} else if (value.equals("差")) {
							j.setJiaRen(2);
						} else if (value.equals("一般")) {
							j.setJiaRen(3);
						} else if (value.equals("好")) {
							j.setJiaRen(4);
						} else if (value.equals("极好")) {
							j.setJiaRen(5);
						}
					}

					// 对各项的支持利用度
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("差")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("一般")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("好")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("极好")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("神经衰弱")) {
							j.setYinXiang(1);
						} else if (value.equals("植物神经功能紊乱")) {
							j.setYinXiang(2);
						} else if (value.equals("焦虑状态")) {
							j.setYinXiang(3);
						} else if (value.equals("抑郁状态")) {
							j.setYinXiang(4);
						} else if (value.equals("焦虑抑郁状态")) {
							j.setYinXiang(5);
						} else if (value.equals("强迫状态")) {
							j.setYinXiang(6);
						} else if (value.equals("躁狂状态")) {
							j.setYinXiang(7);
						} else if (value.equals("妄想状态")) {
							j.setYinXiang(8);
						}
					}
					// 家谱图备注
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// 印象其他
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// 处置
					if ("chu_zhi".equals(name)) {
						if (value.equals("心身测评（脑功能检测，HRV检测，精神科A,B C类量表）")) {
							j.setChuZhi(1);
						} else if (value.equals("心脑检测（脑功能检测，HRV，首访量表）")) {
							j.setChuZhi(2);
						} else if (value.equals("植物神经功能检测（HRV，首访量表）")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉

					// item.write( new File(path,filename) );//第三方提供的

					// 手动写的
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("获取上传文件的总共的容量：" + item.getSize());

					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}

			jiChuXinXiDao.save(j, session);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("jcxm?m=iJcxmAdd");
	}
	public void sss(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// 可以上传多个文件
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {

					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString("UTF-8");
					if (name.equals("token")) {
						String token = session.getAttribute("token").toString();
						if (token.equals(value)) {
							j.setYongHuId(this.getYongHuId(request.getSession(true)));
							j.setRiQi(new Timestamp(new Date().getTime()));
						} else {
							response.sendRedirect("jcxm?m=iJcxmAdd");
							return;
						}
						
					}
					session.removeAttribute("token");
					if (name.equals("men_zhen_hao")) {
						j.setMenZhenHao(value);
					}
					if (name.equals("bing_an_hao")) {
						j.setBingAnHao(value);
					}

					if ("zhu_guan_yi_shi".equals(name)) {

						j.setZhuGuanYiShi(value);
					}
					if ("suo_shu_ke_shi".equals(name)) {
						j.setSuoShuKeShi(value);
					}
					if ("zhuan_ke_yi_sheng".equals(name)) {
						j.setZhuanKeYiSheng(value);
					}
					if ("xing_ming".equals(name)) {
						j.setXingMing(value.trim());
					}
					if ("xing_bie".equals(name)) {
						if (value.equals("男")) {
							j.setXingBie(1);
						} else if (value.equals("女")) {
							j.setXingBie(2);
						}
					}
					if ("nian".equals(name)) {
						try {
							j.setChuShengNian(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("yue".equals(name)) {
						try {
							j.setChuShengYue(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ri".equals(name)) {
						try {
							j.setChuShengRi(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("min_zu".equals(name)) {
						j.setMinZu(value);
					}
					if ("hun_yin_zhuang_kuang".equals(name)) {
						j.setHunYinZhuangKuang(value);
					}
					if ("shen_gao".equals(name)) {
						try {
							j.setShenGao(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ti_zhong".equals(name)) {
						try {
							j.setTiZhong(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("chu_sheng_di".equals(name)) {
						j.setChuShengDi(value);
					}
					if ("zhi_ye".equals(name)) {
						j.setZhiYe(value);
					}
					if ("wen_hua_cheng_du".equals(name)) {
						j.setWenHuaChengDu(value);
					}
					if ("jia_li_pai_hang_1".equals(name)) {
						try {
							j.setPaiHang1(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("jia_li_pai_hang_2".equals(name)) {
						try {
							j.setPaiHang2(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("jing_ji_zhuang_kuang".equals(name)) {
						if (value.equals("良好")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("一般")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("较差")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("很差")) {
							j.setJingJiZhuangKuang(4);
						}
					}
					if ("lian_xi_di_zhi".equals(name)) {
						j.setLianXiDiZhi(value);
					}
					if ("lian_xi_dian_hua".equals(name)) {
						j.setLianXiDianHua(value);
					}

					if ("jiu_zhen_yuan_yin".equals(name)) {

						j.setJiuZhenYuanYin(j.getJiuZhenYuanYin() + "|" + value);
						if (j.getJiuZhenYuanYin().startsWith("null|")) {
							j.setJiuZhenYuanYin(j.getJiuZhenYuanYin()
									.substring(5));
						}
					}

					if ("shuimian".equals(name)) {

						j.setShuiMian(j.getShuiMian() + "|" + value);
						if (j.getShuiMian().startsWith("null|")) {
							j.setShuiMian(j.getShuiMian().substring(5));
						}
					}

					// 接收到前台食欲的状态
					if ("shiyu".equals(name)) {
						if (value.equals("良好")) {
							j.setShiYu(1);
						} else if (value.equals("一般")) {
							j.setShiYu(2);
						} else if (value.equals("欠佳")) {
							j.setShiYu(3);
						}
					}

					// 接收到前台性生活的状况
					if ("xingshenghuo".equals(name)) {
						if (value.equals("良好")) {
							j.setXingShengHuo(1);
						} else if (value.equals("一般")) {
							j.setXingShengHuo(2);
						} else if (value.equals("欠佳")) {
							j.setXingShengHuo(3);
						}
					}

					// 接收到前台第一个“是否出现”
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// 接收到前台第二个“是否出现”
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// 接受到前台传来的现病史是否发作
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("反复发作")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("间断发作")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("偶发")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("无")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// 接收到前台的现病史躯体病
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// 接受到前台先病史的诊断，时间和用药史
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// 接受到前台过往病史是否有发作
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("偶发")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("多发")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// 接收到前台过往病史躯体病
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// 接收前台过往病史的诊断，时间和用药史
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// 接收到前台家族是否有病史
					if ("jia_zu_has_ji_bing".equals(name)) { // 有疑问
						if (value.equals("无")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("偶发")) {
							j.setJiaZuBingShi(2);
						}
					}

					// 接收到前台家族病史的诊断，时间和用药史
					if ("jia_zu_bing_shi".equals(name)) { // 有疑问
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// 接收到前台个性特点
					if ("xingge".equals(name)) {
						if (value.equals("内向")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("外向")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("适中")) {
							j.setGeXingTeDian(3);
						}
					}

					// 接受带前台的情绪稳定性
					if ("qingxu".equals(name)) {
						if (value.equals("稳定")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("欠稳定")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A型")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B型")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C型")) {
							j.setRenGeTeDian(3);
						}
					}

					// 接收到前台血型
					if ("xuexing".equals(name)) {
						if (value.equals("A型")) {
							j.setXueXing(1);
						} else if (value.equals("B型")) {
							j.setXueXing(2);
						} else if (value.equals("AB型")) {
							j.setXueXing(3);
						} else if (value.equals("O型")) {
							j.setXueXing(4);
						}
					}

					// 接收到前台的人格特质
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// 接收到前台兴趣
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// 接收到前台的每天吸烟的数/支
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受带前台的每天喝酒的数/两
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受到前台的其他爱好
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// 接收到前台=的生长发育
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// 接收到前台的学会走路的年龄
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的会说话的年龄
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// 接受到前台的月经的年龄
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的遗精的年龄
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的停经的年龄
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的抚养人的信息
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// 接受到前台的寄养开始的年龄
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的寄养结束的年龄
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的幼年生活环境
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的现在的生活环境
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的与兄弟姐妹的关系
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("差")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// 接收到前台的夫妻关系
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("差")) {
							j.setFuQiGuanXi(5);
						}
					}

					// 接收到前台的婆媳关系
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("差")) {
							j.setPoXiGuanXi(5);
						}
					}
					// 接收到前台的亲子关系
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("差")) {
							j.setQinZiGuanXi(5);
						}
					}

					// // 接收到前台的父亲的职业
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// 接收到前台的母亲的职业
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// 父亲文化程度
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// 母亲文化程度
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// 负性事件
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("有")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// 负性事件内容
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// 应激事件
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("有")) {
							j.setYingJiShiJian1(2);
						}
					}

					// 应激事件内容
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// 人际关系
					if ("renjiguanxi".equals(name)) {
						if (value.equals("良好")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("一般")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("欠佳")) {
							j.setRenJiGuanXi(3);
						}
					}

					// 问题表现为
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// 问题发生在：
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// 问题发生在其他
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// 生活满意与否
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("满意")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("尚可")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("不满意")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// 不满意的方面
					if ("bu_man_yi_fang_mian".equals(name)) {
						j.setBuManYiDeFangMian(j.getBuManYiDeFangMian() + "|"
								+ value);
						if (j.getBuManYiDeFangMian().startsWith("null|")) {
							j.setBuManYiDeFangMian(j.getBuManYiDeFangMian()
									.substring(5));
						}
					}

					// String bu_man_yi_fang_mian_qi_ta =
					// request.getParameter("bu_man_yi_fang_mian_qi_ta");

					// 疾病认知
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("完全正确")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("基本正确")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("不正确")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("基本错误")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("完全错误")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// 疾病愈后态度
					if ("taidu".equals(name)) {
						if (value.equals("非常乐观")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("乐观")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("不确定")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("消极")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("非常消极")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// 应对方式
					if ("yingduifangshi".equals(name)) {
						if (value.equals("非常积极")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("积极")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("一般")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("消极")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("非常消极")) {
							j.setYingDuiFangShi(5);
						}
					}

					// 治疗参与程度
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("积极主动")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("消极被动")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("一般")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// 社会参与
					if ("shehuizhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("差")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("一般")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("好")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("极好")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// 朋友
					if ("pengyou".equals(name)) {
						if (value.equals("极差")) {
							j.setPengYou(1);
						} else if (value.equals("差")) {
							j.setPengYou(2);
						} else if (value.equals("一般")) {
							j.setPengYou(3);
						} else if (value.equals("好")) {
							j.setPengYou(4);
						} else if (value.equals("极好")) {
							j.setPengYou(5);
						}
					}

					// 家人
					if ("jiaren".equals(name)) {
						if (value.equals("极差")) {
							j.setJiaRen(1);
						} else if (value.equals("差")) {
							j.setJiaRen(2);
						} else if (value.equals("一般")) {
							j.setJiaRen(3);
						} else if (value.equals("好")) {
							j.setJiaRen(4);
						} else if (value.equals("极好")) {
							j.setJiaRen(5);
						}
					}

					// 对各项的支持利用度
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("差")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("一般")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("好")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("极好")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("神经衰弱")) {
							j.setYinXiang(1);
						} else if (value.equals("植物神经功能紊乱")) {
							j.setYinXiang(2);
						} else if (value.equals("焦虑状态")) {
							j.setYinXiang(3);
						} else if (value.equals("抑郁状态")) {
							j.setYinXiang(4);
						} else if (value.equals("焦虑抑郁状态")) {
							j.setYinXiang(5);
						} else if (value.equals("强迫状态")) {
							j.setYinXiang(6);
						} else if (value.equals("躁狂状态")) {
							j.setYinXiang(7);
						} else if (value.equals("妄想状态")) {
							j.setYinXiang(8);
						}
					}
					// 家谱图备注
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// 印象其他
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// 处置
					if ("chu_zhi".equals(name)) {
						if (value.equals("心身测评（脑功能检测，HRV检测，精神科A,B C类量表）")) {
							j.setChuZhi(1);
						} else if (value.equals("心脑检测（脑功能检测，HRV，首访量表）")) {
							j.setChuZhi(2);
						} else if (value.equals("植物神经功能检测（HRV，首访量表）")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉

					// item.write( new File(path,filename) );//第三方提供的

					// 手动写的
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("获取上传文件的总共的容量：" + item.getSize());

					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}

			jiChuXinXiDao.save(j, session);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		response.sendRedirect("jcxm?m=iJcxmAdd");
	}

	public void ccc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// 可以上传多个文件
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {

					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString("UTF-8");

					try {
						if ("jcxxId".equals(name)) {
							j.setId(Integer.parseInt(value.trim()));
							j.setRiQi(new Timestamp(new Date().getTime()));
						}
					} catch (Exception e) {
						request.getRequestDispatcher("jcxx?m=iJcxx").forward(
								request, response);
						return;
					}

					// j.setYongHuId(this.getYongHuId(request.getSession(true)));
					if (name.equals("men_zhen_hao")) {
						j.setMenZhenHao(value);
					}
					if (name.equals("bing_an_hao")) {
						j.setBingAnHao(value);
					}

					if ("zhu_guan_yi_shi".equals(name)) {

						j.setZhuGuanYiShi(value);
					}
					if ("suo_shu_ke_shi".equals(name)) {
						j.setSuoShuKeShi(value);
					}
					if ("zhuan_ke_yi_sheng".equals(name)) {
						j.setZhuanKeYiSheng(value);
					}
					if ("xing_ming".equals(name)) {
						j.setXingMing(value.trim());
					}
					if ("xing_bie".equals(name)) {
						if (value.equals("男")) {
							j.setXingBie(1);
						} else if (value.equals("女")) {
							j.setXingBie(2);
						}
					}
					if ("nian".equals(name)) {
						try {
							j.setChuShengNian(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("yue".equals(name)) {
						try {
							j.setChuShengYue(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ri".equals(name)) {
						try {
							j.setChuShengRi(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("min_zu".equals(name)) {
						j.setMinZu(value);
					}
					if ("hun_yin_zhuang_kuang".equals(name)) {
						j.setHunYinZhuangKuang(value);
					}
					if ("shen_gao".equals(name)) {
						try {
							j.setShenGao(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("ti_zhong".equals(name)) {
						try {
							j.setTiZhong(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("chu_sheng_di".equals(name)) {
						j.setChuShengDi(value);
					}
					if ("zhi_ye".equals(name)) {
						j.setZhiYe(value);
					}
					if ("wen_hua_cheng_du".equals(name)) {
						j.setWenHuaChengDu(value);
					}
					if ("jia_li_pai_hang_1".equals(name)) {
						try {
							j.setPaiHang1(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}
					if ("jia_li_pai_hang_2".equals(name)) {
						try {
							j.setPaiHang2(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					if ("jing_ji_zhuang_kuang".equals(name)) {
						if (value.equals("良好")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("一般")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("较差")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("很差")) {
							j.setJingJiZhuangKuang(4);
						}
					}
					if ("lian_xi_di_zhi".equals(name)) {
						j.setLianXiDiZhi(value);
					}
					if ("lian_xi_dian_hua".equals(name)) {
						j.setLianXiDianHua(value);
					}

					if ("jiu_zhen_yuan_yin".equals(name)) {

						j.setJiuZhenYuanYin(j.getJiuZhenYuanYin() + "|" + value);
						if (j.getJiuZhenYuanYin().startsWith("null|")) {
							j.setJiuZhenYuanYin(j.getJiuZhenYuanYin()
									.substring(5));
						}
					}

					if ("shuimian".equals(name)) {

						j.setShuiMian(j.getShuiMian() + "|" + value);
						if (j.getShuiMian().startsWith("null|")) {
							j.setShuiMian(j.getShuiMian().substring(5));
						}
					}

					// 接收到前台食欲的状态
					if ("shiyu".equals(name)) {
						if (value.equals("良好")) {
							j.setShiYu(1);
						} else if (value.equals("一般")) {
							j.setShiYu(2);
						} else if (value.equals("欠佳")) {
							j.setShiYu(3);
						}
					}

					// 接收到前台性生活的状况
					if ("xingshenghuo".equals(name)) {
						if (value.equals("良好")) {
							j.setXingShengHuo(1);
						} else if (value.equals("一般")) {
							j.setXingShengHuo(2);
						} else if (value.equals("欠佳")) {
							j.setXingShengHuo(3);
						}
					}

					// 接收到前台第一个“是否出现”
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// 接收到前台第二个“是否出现”
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// 接受到前台传来的现病史是否发作
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("反复发作")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("间断发作")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("偶发")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("无")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// 接收到前台的现病史躯体病
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// 接受到前台先病史的诊断，时间和用药史
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// 接受到前台过往病史是否有发作
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("偶发")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("多发")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// 接收到前台过往病史躯体病
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("无")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("偶发")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// 接收前台过往病史的诊断，时间和用药史
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// 接收到前台家族是否有病史
					if ("jia_zu_has_ji_bing".equals(name)) { // 有疑问
						if (value.equals("无")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("偶发")) {
							j.setJiaZuBingShi(2);
						}
					}

					// 接收到前台家族病史的诊断，时间和用药史
					if ("jia_zu_bing_shi".equals(name)) { // 有疑问
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// 接收到前台个性特点
					if ("xingge".equals(name)) {
						if (value.equals("内向")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("外向")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("适中")) {
							j.setGeXingTeDian(3);
						}
					}

					// 接受带前台的情绪稳定性
					if ("qingxu".equals(name)) {
						if (value.equals("稳定")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("欠稳定")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A型")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B型")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C型")) {
							j.setRenGeTeDian(3);
						}
					}

					// 接收到前台血型
					if ("xuexing".equals(name)) {
						if (value.equals("A型")) {
							j.setXueXing(1);
						} else if (value.equals("B型")) {
							j.setXueXing(2);
						} else if (value.equals("AB型")) {
							j.setXueXing(3);
						} else if (value.equals("O型")) {
							j.setXueXing(4);
						}
					}

					// 接收到前台的人格特质
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// 接收到前台兴趣
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// 接收到前台的每天吸烟的数/支
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受带前台的每天喝酒的数/两
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接受到前台的其他爱好
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// 接收到前台=的生长发育
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// 接收到前台的学会走路的年龄
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的会说话的年龄
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// 接受到前台的月经的年龄
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的遗精的年龄
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的停经的年龄
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的抚养人的信息
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// 接受到前台的寄养开始的年龄
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// 接收到前台的寄养结束的年龄
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// 接收到前台的幼年生活环境
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的现在的生活环境
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// 接收到前台的与兄弟姐妹的关系
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("差")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// 接收到前台的夫妻关系
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("差")) {
							j.setFuQiGuanXi(5);
						}
					}

					// 接收到前台的婆媳关系
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("差")) {
							j.setPoXiGuanXi(5);
						}
					}
					// 接收到前台的亲子关系
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("良好")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("尚可")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("一般")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("冷淡")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("差")) {
							j.setQinZiGuanXi(5);
						}
					}
					// // 接收到前台的父亲的职业
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// 接收到前台的母亲的职业
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// 父亲文化程度
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// 母亲文化程度
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// 负性事件
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("有")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// 负性事件内容
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// 应激事件
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("无")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("有")) {
							j.setYingJiShiJian1(2);
						}
					}

					// 应激事件内容
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// 人际关系
					if ("renjiguanxi".equals(name)) {
						if (value.equals("良好")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("一般")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("欠佳")) {
							j.setRenJiGuanXi(3);
						}
					}

					// 问题表现为
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// 问题发生在：
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// 问题发生在其他
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// 生活满意与否
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("满意")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("尚可")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("不满意")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// 不满意的方面
					if ("bu_man_yi_fang_mian".equals(name)) {
						j.setBuManYiDeFangMian(j.getBuManYiDeFangMian() + "|"
								+ value);
						if (j.getBuManYiDeFangMian().startsWith("null|")) {
							j.setBuManYiDeFangMian(j.getBuManYiDeFangMian()
									.substring(5));
						}
					}

					// String bu_man_yi_fang_mian_qi_ta =
					// request.getParameter("bu_man_yi_fang_mian_qi_ta");

					// 疾病认知
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("完全正确")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("基本正确")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("不正确")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("基本错误")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("完全错误")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// 疾病愈后态度
					if ("taidu".equals(name)) {
						if (value.equals("非常乐观")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("乐观")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("不确定")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("消极")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("非常消极")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// 应对方式
					if ("yingduifangshi".equals(name)) {
						if (value.equals("非常积极")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("积极")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("一般")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("消极")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("非常消极")) {
							j.setYingDuiFangShi(5);
						}
					}

					// 治疗参与程度
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("积极主动")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("消极被动")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("一般")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// 社会参与
					if ("shehuizhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("差")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("一般")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("好")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("极好")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// 朋友
					if ("pengyou".equals(name)) {
						if (value.equals("极差")) {
							j.setPengYou(1);
						} else if (value.equals("差")) {
							j.setPengYou(2);
						} else if (value.equals("一般")) {
							j.setPengYou(3);
						} else if (value.equals("好")) {
							j.setPengYou(4);
						} else if (value.equals("极好")) {
							j.setPengYou(5);
						}
					}

					// 家人
					if ("jiaren".equals(name)) {
						if (value.equals("极差")) {
							j.setJiaRen(1);
						} else if (value.equals("差")) {
							j.setJiaRen(2);
						} else if (value.equals("一般")) {
							j.setJiaRen(3);
						} else if (value.equals("好")) {
							j.setJiaRen(4);
						} else if (value.equals("极好")) {
							j.setJiaRen(5);
						}
					}

					// 对各项的支持利用度
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("极差")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("差")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("一般")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("好")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("极好")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("神经衰弱")) {
							j.setYinXiang(1);
						} else if (value.equals("植物神经功能紊乱")) {
							j.setYinXiang(2);
						} else if (value.equals("焦虑状态")) {
							j.setYinXiang(3);
						} else if (value.equals("抑郁状态")) {
							j.setYinXiang(4);
						} else if (value.equals("焦虑抑郁状态")) {
							j.setYinXiang(5);
						} else if (value.equals("强迫状态")) {
							j.setYinXiang(6);
						} else if (value.equals("躁狂状态")) {
							j.setYinXiang(7);
						} else if (value.equals("妄想状态")) {
							j.setYinXiang(8);
						}
					}

					// 家谱图备注
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// 印象其他
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// 处置
					if ("chu_zhi".equals(name)) {
						if (value.equals("心身测评（脑功能检测，HRV检测，精神科A,B C类量表）")) {
							j.setChuZhi(1);
						} else if (value.equals("心脑检测（脑功能检测，HRV，首访量表）")) {
							j.setChuZhi(2);
						} else if (value.equals("植物神经功能检测（HRV，首访量表）")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉

					// item.write( new File(path,filename) );//第三方提供的

					// 手动写的
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("获取上传文件的总共的容量：" + item.getSize());

					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
				}
			}

			jiChuXinXiDao.change(j, request.getSession(true));

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("jcxx?m=gJcxx&z=x&id=" + j.getId());
	}
}
