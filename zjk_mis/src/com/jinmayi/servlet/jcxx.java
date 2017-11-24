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
 * ������Ϣ
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
	 * ֻ�õ�������Ϣ���������
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
			if (xing_bie.equals("��")) {
				j.setXingBie(1);
			} else if (xing_bie.equals("Ů")) {
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
			if (jing_ji_zhuang_kuang.equals("����")) {
				j.setJingJiZhuangKuang(1);
			} else if (jing_ji_zhuang_kuang.equals("һ��")) {
				j.setJingJiZhuangKuang(2);
			} else if (jing_ji_zhuang_kuang.equals("�ϲ�")) {
				j.setJingJiZhuangKuang(3);
			} else if (jing_ji_zhuang_kuang.equals("�ܲ�")) {
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

		// ���յ�ǰ̨ʳ����״̬
		String shiyu = request.getParameter("shiyu");
		if (shiyu != null) {
			if (shiyu.equals("����")) {
				j.setShiYu(1);
			} else if (shiyu.equals("һ��")) {
				j.setShiYu(2);
			} else if (shiyu.equals("Ƿ��")) {
				j.setShiYu(3);
			}
		}

		// ���յ�ǰ̨�������״��
		String xingshenghuo = request.getParameter("xingshenghuo");
		if (xingshenghuo != null) {
			if (xingshenghuo.equals("����")) {
				j.setXingShengHuo(1);
			} else if (xingshenghuo.equals("һ��")) {
				j.setXingShengHuo(2);
			} else if (xingshenghuo.equals("Ƿ��")) {
				j.setXingShengHuo(3);
			}
		}

		// ���յ�ǰ̨��һ�����Ƿ���֡�
		String[] chu_xian_1 = request.getParameterValues("chu_xian_1");
		if (chu_xian_1 != null) {
			for (String a : chu_xian_1) {
				str = str + "|" + a;
			}
			j.setChuXian1(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�ڶ������Ƿ���֡�
		String[] chu_xian2 = request.getParameterValues("chu_xian2");
		if (chu_xian2 != null) {
			for (String a : chu_xian2) {
				str = str + "|" + a;
			}
			j.setChuXian2(str.substring(1));
			str = "";
		}

		// ���ܵ�ǰ̨�������ֲ�ʷ�Ƿ���
		String xian_has_lei_si_fa_zuo = request
				.getParameter("xian_has_lei_si_fa_zuo");
		if (xian_has_lei_si_fa_zuo != null) {
			if (xian_has_lei_si_fa_zuo.equals("��������")) {
				j.setXianLeiSiFaZuo(1);
			} else if (xian_has_lei_si_fa_zuo.equals("��Ϸ���")) {
				j.setXianLeiSiFaZuo(2);
			} else if (xian_has_lei_si_fa_zuo.equals("ż��")) {
				j.setXianLeiSiFaZuo(3);
			}
		}

		// ���յ�ǰ̨���ֲ�ʷ���岡
		String xian_has_qu_ti_ji_bing = request
				.getParameter("xian_has_qu_ti_ji_bing");
		if (xian_has_qu_ti_ji_bing != null) {
			if (xian_has_qu_ti_ji_bing.equals("��")) {
				j.setXianQuTiJiBing(1);
			} else if (xian_has_qu_ti_ji_bing.equals("ż��")) {
				j.setXianQuTiJiBing(2);
			}
		}

		// ���ܵ�ǰ̨�Ȳ�ʷ����ϣ�ʱ�����ҩʷ
		String xian_bing_shi = request.getParameter("xian_bing_shi");
		j.setXianJuTiJiBingZhenDuan(xian_bing_shi);

		// ���ܵ�ǰ̨������ʷ�Ƿ��з���
		String ji_wang_has_lei_si_fa_zuo = request
				.getParameter("ji_wang_has_lei_si_fa_zuo");
		if (ji_wang_has_lei_si_fa_zuo != null) {
			if (ji_wang_has_lei_si_fa_zuo.equals("��")) {
				j.setJiWangLeiSiFaZuo(1);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("ż��")) {
				j.setJiWangLeiSiFaZuo(2);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("�෢")) {
				j.setJiWangLeiSiFaZuo(3);
			}
		}

		// ���յ�ǰ̨������ʷ���岡
		String ji_wang_has_qu_ti_ji_bing = request
				.getParameter("ji_wang_has_qu_ti_ji_bing");
		if (ji_wang_has_qu_ti_ji_bing != null) {
			if (ji_wang_has_qu_ti_ji_bing.equals("��")) {
				j.setJiWangQuTiJiBing(1);
			} else if (ji_wang_has_qu_ti_ji_bing.equals("ż��")) {
				j.setJiWangQuTiJiBing(2);
			}
		}

		// ����ǰ̨������ʷ����ϣ�ʱ�����ҩʷ
		String ji_wang_bing_shi = request.getParameter("ji_wang_bing_shi");
		j.setJiWangJuTiJiBingZhenDuan(ji_wang_bing_shi);

		// ���յ�ǰ̨�����Ƿ��в�ʷ
		String jia_zu_has_ji_bing = request.getParameter("jia_zu_has_ji_bing"); // ������
		if (jia_zu_has_ji_bing != null) {
			if (jia_zu_has_ji_bing.equals("��")) {
				j.setJiaZuBingShi(1);
			} else if (jia_zu_has_ji_bing.equals("ż��")) {
				j.setJiaZuBingShi(2);
			}
		}

		// ���յ�ǰ̨���岡ʷ����ϣ�ʱ�����ҩʷ
		String jia_zu_bing_shi = request.getParameter("jia_zu_bing_shi"); // ������
		j.setJiaZuJuTiJiBingZhenDuan(jia_zu_bing_shi);

		// ���յ�ǰ̨�����ص�
		String xingge = request.getParameter("xingge");
		if (xingge != null) {
			if (xingge.equals("����")) {
				j.setGeXingTeDian(1);
			} else if (xingge.equals("����")) {
				j.setGeXingTeDian(2);
			} else if (xingge.equals("����")) {
				j.setGeXingTeDian(3);
			}
		}

		// ���ܴ�ǰ̨�������ȶ���
		String qingxu = request.getParameter("qingxu");
		if (qingxu != null) {
			if (qingxu.equals("�ȶ�")) {
				j.setQingXuWenDingXing(1);
			} else if (qingxu.equals("Ƿ�ȶ�")) {
				j.setQingXuWenDingXing(2);
			}
		}

		//
		String tedian = request.getParameter("tedian");
		if (tedian != null) {
			if (tedian.equals("A��")) {
				j.setRenGeTeDian(1);
			} else if (tedian.equals("B��")) {
				j.setRenGeTeDian(2);
			} else if (tedian.equals("C��")) {
				j.setRenGeTeDian(3);
			}
		}

		// ���յ�ǰ̨Ѫ��
		String xuexing = request.getParameter("xuexing");
		if (xuexing != null) {
			if (xuexing.equals("A��")) {
				j.setXueXing(1);
			} else if (xuexing.equals("B��")) {
				j.setXueXing(2);
			} else if (xuexing.equals("AB��")) {
				j.setXueXing(3);
			} else if (xuexing.equals("O��")) {
				j.setXueXing(4);
			}
		}

		// ���յ�ǰ̨���˸�����
		String[] renge = request.getParameterValues("renge");
		if (renge != null) {
			for (String a : renge) {
				str = str + "|" + a;
			}
			j.setRenGeTeZhi(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��Ȥ
		String[] xingqu = request.getParameterValues("xingqu");
		if (xingqu != null) {
			for (String a : xingqu) {
				str = str + "|" + a;
			}
			j.setXingQu(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��ÿ�����̵���/֧
		String yan = request.getParameter("ya");
		try {
			j.setYan(Integer.parseInt(yan));
		} catch (Exception e) {

		}

		// ���ܴ�ǰ̨��ÿ��ȾƵ���/��
		String jiu = request.getParameter("jiu");
		try {
			j.setJiu(Integer.parseInt(jiu));
		} catch (Exception e) {

		}

		// ���ܵ�ǰ̨����������
		String qi = request.getParameter("yan_jiu_qi_ta");
		j.setYanJiuQiTa(qi);

		// ���յ�ǰ̨=����������
		String[] shengzhang = request.getParameterValues("shengzhang");
		if (shengzhang != null) {
			for (String a : shengzhang) {
				str = str + "|" + a;
			}
			j.setShengZhangFaYu(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��ѧ����·������
		String walk = request.getParameter("walk");
		try {
			j.setXueBu(Integer.parseInt(walk));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�Ļ�˵��������
		String talk = request.getParameter("talk");
		try {
			j.setYuYan(Integer.parseInt(talk));
		} catch (Exception e) {

		}
		// ���ܵ�ǰ̨���¾�������
		String yuejing = request.getParameter("yuejing");
		try {
			j.setYueJingChuChao(Integer.parseInt(yuejing));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨���ž�������
		String yijing = request.getParameter("yijing");
		try {
			j.setShouCiYiJing(Integer.parseInt(yijing));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨��ͣ��������
		String ting = request.getParameter("ting");
		try {
			j.setTingJing(Integer.parseInt(ting));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�ĸ����˵���Ϣ
		String[] fuyangren = request.getParameterValues("fuyangren");
		if (fuyangren != null) {
			for (String a : fuyangren) {
				str = str + "|" + a;
			}
			j.setYouNianFuYangRen(str.substring(1));
			str = "";
		}

		// ���ܵ�ǰ̨�ļ�����ʼ������
		String jiyang1 = request.getParameter("jiyang1");
		try {
			j.setJiYangShi1(Integer.parseInt(jiyang1));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�ļ�������������
		String jiyang2 = request.getParameter("jiyang2");
		try {
			j.setJiYangShi2(Integer.parseInt(jiyang2));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�����������
		String[] you_nian_huan_jing = request
				.getParameterValues("you_nian_huan_jing");
		if (you_nian_huan_jing != null) {
			for (String a : you_nian_huan_jing) {
				str = str + "|" + a;
			}
			j.setYouNianShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�����ڵ������
		String[] xian_zai_huan_jing = request
				.getParameterValues("xian_zai_huan_jing");
		if (xian_zai_huan_jing != null) {
			for (String a : xian_zai_huan_jing) {
				str = str + "|" + a;
			}
			j.setXianZaiShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�����ֵܽ��õĹ�ϵ
		String yu_xiong_di_jie_mei_guan_xi = request
				.getParameter("yu_xiong_di_jie_mei_guan_xi");
		if (yu_xiong_di_jie_mei_guan_xi != null) {
			if (yu_xiong_di_jie_mei_guan_xi.equals("����")) {
				j.setXiongDiJieMeiGuanXi(1);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("�п�")) {
				j.setXiongDiJieMeiGuanXi(2);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("һ��")) {
				j.setXiongDiJieMeiGuanXi(3);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("�䵭")) {
				j.setXiongDiJieMeiGuanXi(4);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("��")) {
				j.setXiongDiJieMeiGuanXi(5);
			}
		}

		// ���յ�ǰ̨�ķ��޹�ϵ
		String fu_qi_guan_xi = request.getParameter("fu_qi_guan_xi");
		if (fu_qi_guan_xi != null) {
			if (fu_qi_guan_xi.equals("����")) {
				j.setFuQiGuanXi(1);
			} else if (fu_qi_guan_xi.equals("�п�")) {
				j.setFuQiGuanXi(2);
			} else if (fu_qi_guan_xi.equals("һ��")) {
				j.setFuQiGuanXi(3);
			} else if (fu_qi_guan_xi.equals("�䵭")) {
				j.setFuQiGuanXi(4);
			} else if (fu_qi_guan_xi.equals("��")) {
				j.setFuQiGuanXi(5);
			}
		}

		// ���յ�ǰ̨����ϱ��ϵ
		String po_xi_guan_xi = request.getParameter("po_xi_guan_xi");
		if (po_xi_guan_xi != null) {
			if (po_xi_guan_xi.equals("����")) {
				j.setPoXiGuanXi(1);
			} else if (po_xi_guan_xi.equals("�п�")) {
				j.setPoXiGuanXi(2);
			} else if (po_xi_guan_xi.equals("һ��")) {
				j.setPoXiGuanXi(3);
			} else if (po_xi_guan_xi.equals("�䵭")) {
				j.setPoXiGuanXi(4);
			} else if (po_xi_guan_xi.equals("��")) {
				j.setPoXiGuanXi(5);
			}
		}

		// ���յ�ǰ̨�ĸ��׵�ְҵ
		String fu_qin_zhi_ye = request.getParameter("fu_qin_zhi_ye");
		j.setFuQinZhiYe(fu_qin_zhi_ye);

		// ���յ�ǰ̨��ĸ�׵�ְҵ
		String mu_qin_zhi_ye = request.getParameter("mu_qin_zhi_ye");
		j.setMuQinZhiYe(mu_qin_zhi_ye);

		// �����Ļ��̶�
		String fu_qin_wen_hua = request.getParameter("fu_qin_wen_hua");
		j.setFuQinWenHuaChengDu(fu_qin_wen_hua);

		// ĸ���Ļ��̶�
		String mu_qin_wen_hua = request.getParameter("mu_qin_wen_hua");
		j.setMuQinWenHuaChengDu(mu_qin_wen_hua);

		// �����¼�
		String fu_xing_shi_jian = request.getParameter("fu_xing_shi_jian");
		if (fu_xing_shi_jian != null) {
			if (fu_xing_shi_jian.equals("��")) {
				j.setZhongDaFuXingShiJian1(1);
			} else if (fu_xing_shi_jian.equals("��")) {
				j.setZhongDaFuXingShiJian1(2);
			}
		}

		// �����¼�����
		String fu_xing_shi_jian_nei_rong = request
				.getParameter("fu_xing_shi_jian_nei_rong");
		j.setZhongDaFuXingShiJian2(fu_xing_shi_jian_nei_rong);

		// Ӧ���¼�
		String ying_ji_shi_jian = request.getParameter("ying_ji_shi_jian");
		if (ying_ji_shi_jian != null) {
			if (ying_ji_shi_jian.equals("��")) {
				j.setYingJiShiJian1(1);
			} else if (ying_ji_shi_jian.equals("��")) {
				j.setYingJiShiJian1(2);
			}
		}

		// Ӧ���¼�����
		String ying_ji_shi_jian_nei_rong = request
				.getParameter("ying_ji_shi_jian_nei_rong");
		j.setYingJiShiJian2(ying_ji_shi_jian_nei_rong);

		// �˼ʹ�ϵ
		String renjiguanxi = request.getParameter("renjiguanxi");
		if (renjiguanxi != null) {
			if (renjiguanxi.equals("����")) {
				j.setRenJiGuanXi(1);
			} else if (renjiguanxi.equals("һ��")) {
				j.setRenJiGuanXi(2);
			} else if (renjiguanxi.equals("Ƿ��")) {
				j.setRenJiGuanXi(3);
			}
		}

		// �������Ϊ
		String[] wenti = request.getParameterValues("wenti");
		if (wenti != null) {
			for (String a : wenti) {
				str = str + "|" + a;
			}
			j.setWenTiBiaoXianWei(str.substring(1));
			str = "";
		}

		// ���ⷢ���ڣ�
		String[] wentifasheng = request.getParameterValues("wentifasheng");
		if (wentifasheng != null) {
			for (String a : wentifasheng) {
				str = str + "|" + a;
			}
			j.setWenTiFaShengZai(str.substring(1));
			str = "";
		}

		// ���ⷢ��������
		String qitafangmian = request.getParameter("qitafangmian");
		j.setWenTiFaShengQiTa(qitafangmian);

		// �����������
		String shenghuomianyiyufou = request
				.getParameter("shenghuomianyiyufou");
		if (shenghuomianyiyufou != null) {
			if (shenghuomianyiyufou.equals("����")) {
				j.setShengHuoManYiYuFou(1);
			} else if (shenghuomianyiyufou.equals("�п�")) {
				j.setShengHuoManYiYuFou(2);
			} else if (shenghuomianyiyufou.equals("������")) {
				j.setShengHuoManYiYuFou(3);
			}
		}

		// ������ķ���
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

		// ������֪
		String ji_bing_ren_zhi = request.getParameter("ji_bing_ren_zhi");
		if (ji_bing_ren_zhi != null) {
			if (ji_bing_ren_zhi.equals("��ȫ��ȷ")) {
				j.setDangQianJiBingRenZhi(1);
			} else if (ji_bing_ren_zhi.equals("������ȷ")) {
				j.setDangQianJiBingRenZhi(2);
			} else if (ji_bing_ren_zhi.equals("����ȷ")) {
				j.setDangQianJiBingRenZhi(3);
			} else if (ji_bing_ren_zhi.equals("��������")) {
				j.setDangQianJiBingRenZhi(4);
			} else if (ji_bing_ren_zhi.equals("��ȫ����")) {
				j.setDangQianJiBingRenZhi(5);
			}
		}

		// ��������̬��
		String taidu = request.getParameter("taidu");
		if (taidu != null) {
			if (taidu.equals("�ǳ��ֹ�")) {
				j.setJiBingYuHouTaiDu(1);
			} else if (taidu.equals("�ֹ�")) {
				j.setJiBingYuHouTaiDu(2);
			} else if (taidu.equals("��ȷ��")) {
				j.setJiBingYuHouTaiDu(3);
			} else if (taidu.equals("����")) {
				j.setJiBingYuHouTaiDu(4);
			} else if (taidu.equals("�ǳ�����")) {
				j.setJiBingYuHouTaiDu(5);
			}
		}

		// Ӧ�Է�ʽ
		String yingduifangshi = request.getParameter("yingduifangshi");
		if (yingduifangshi != null) {
			if (yingduifangshi.equals("�ǳ�����")) {
				j.setYingDuiFangShi(1);
			} else if (yingduifangshi.equals("����")) {
				j.setYingDuiFangShi(2);
			} else if (yingduifangshi.equals("һ��")) {
				j.setYingDuiFangShi(3);
			} else if (yingduifangshi.equals("����")) {
				j.setYingDuiFangShi(4);
			} else if (yingduifangshi.equals("�ǳ�����")) {
				j.setYingDuiFangShi(5);
			}
		}

		// ���Ʋ���̶�
		String zhiliaocanyu = request.getParameter("zhiliaocanyu");
		if (zhiliaocanyu != null) {
			if (zhiliaocanyu.equals("��������")) {
				j.setZhiLiaoCanYuChengDu(1);
			} else if (zhiliaocanyu.equals("��������")) {
				j.setZhiLiaoCanYuChengDu(2);
			} else if (zhiliaocanyu.equals("һ��")) {
				j.setZhiLiaoCanYuChengDu(3);
			}
		}

		// ������
		String shehuizhichi = request.getParameter("shehuizhichi");
		if (shehuizhichi != null) {
			if (shehuizhichi.equals("����")) {
				j.setSheHuiZhiChi(1);
			} else if (shehuizhichi.equals("��")) {
				j.setSheHuiZhiChi(2);
			} else if (shehuizhichi.equals("һ��")) {
				j.setSheHuiZhiChi(3);
			} else if (shehuizhichi.equals("��")) {
				j.setSheHuiZhiChi(4);
			} else if (shehuizhichi.equals("����")) {
				j.setSheHuiZhiChi(5);
			}
		}

		// ����
		String pengyou = request.getParameter("pengyou");
		if (pengyou != null) {
			if (pengyou.equals("����")) {
				j.setPengYou(1);
			} else if (pengyou.equals("��")) {
				j.setPengYou(2);
			} else if (pengyou.equals("һ��")) {
				j.setPengYou(3);
			} else if (pengyou.equals("��")) {
				j.setPengYou(4);
			} else if (pengyou.equals("����")) {
				j.setPengYou(5);
			}
		}

		// ����
		String jiaren = request.getParameter("jiaren");
		if (jiaren != null) {
			if (jiaren.equals("����")) {
				j.setJiaRen(1);
			} else if (jiaren.equals("��")) {
				j.setJiaRen(2);
			} else if (jiaren.equals("һ��")) {
				j.setJiaRen(3);
			} else if (jiaren.equals("��")) {
				j.setJiaRen(4);
			} else if (jiaren.equals("����")) {
				j.setJiaRen(5);
			}
		}

		// �Ը����֧�����ö�
		String gexiangzhichi = request.getParameter("gexiangzhichi");
		if (gexiangzhichi != null) {
			if (gexiangzhichi.equals("����")) {
				j.setDuiGeXiangZhiChiLiYongDu(1);
			} else if (gexiangzhichi.equals("��")) {
				j.setDuiGeXiangZhiChiLiYongDu(2);
			} else if (gexiangzhichi.equals("һ��")) {
				j.setDuiGeXiangZhiChiLiYongDu(3);
			} else if (gexiangzhichi.equals("��")) {
				j.setDuiGeXiangZhiChiLiYongDu(4);
			} else if (gexiangzhichi.equals("����")) {
				j.setDuiGeXiangZhiChiLiYongDu(5);
			}
		}

		String yin_xiang = request.getParameter("yin_xiang");
		if (yin_xiang != null) {
			if (yin_xiang.equals("��˥��")) {
				j.setYinXiang(1);
			} else if (yin_xiang.equals("ֲ���񾭹�������")) {
				j.setYinXiang(2);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(3);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(4);
			} else if (yin_xiang.equals("��������״̬")) {
				j.setYinXiang(5);
			} else if (yin_xiang.equals("ǿ��״̬")) {
				j.setYinXiang(6);
			} else if (yin_xiang.equals("���״̬")) {
				j.setYinXiang(7);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(8);
			}
		}

		// ӡ������
		String yin_xiang_qi_ta = request.getParameter("yin_xiang_qi_ta");
		j.setYinXiangQiTa(yin_xiang_qi_ta);

		// ����
		String chu_zhi = request.getParameter("chu_zhi");
		if (chu_zhi != null) {
			if (chu_zhi.equals("����������Թ��ܼ�⣬HRV��⣬�����A,B C������")) {
				j.setChuZhi(1);
			} else if (chu_zhi.equals("���Լ�⣨�Թ��ܼ�⣬HRV���׷�����")) {
				j.setChuZhi(2);
			} else if (chu_zhi.equals("ֲ���񾭹��ܼ�⣨HRV���׷�����")) {
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
			if (xing_bie.equals("��")) {
				j.setXingBie(1);
			} else if (xing_bie.equals("Ů")) {
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
			if (jing_ji_zhuang_kuang.equals("����")) {
				j.setJingJiZhuangKuang(1);
			} else if (jing_ji_zhuang_kuang.equals("һ��")) {
				j.setJingJiZhuangKuang(2);
			} else if (jing_ji_zhuang_kuang.equals("�ϲ�")) {
				j.setJingJiZhuangKuang(3);
			} else if (jing_ji_zhuang_kuang.equals("�ܲ�")) {
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

		// ���յ�ǰ̨ʳ����״̬
		String shiyu = request.getParameter("shiyu");
		if (shiyu != null) {
			if (shiyu.equals("����")) {
				j.setShiYu(1);
			} else if (shiyu.equals("һ��")) {
				j.setShiYu(2);
			} else if (shiyu.equals("Ƿ��")) {
				j.setShiYu(3);
			}
		}

		// ���յ�ǰ̨�������״��
		String xingshenghuo = request.getParameter("xingshenghuo");
		if (xingshenghuo != null) {
			if (xingshenghuo.equals("����")) {
				j.setXingShengHuo(1);
			} else if (xingshenghuo.equals("һ��")) {
				j.setXingShengHuo(2);
			} else if (xingshenghuo.equals("Ƿ��")) {
				j.setXingShengHuo(3);
			}
		}

		// ���յ�ǰ̨��һ�����Ƿ���֡�
		String[] chu_xian_1 = request.getParameterValues("chu_xian_1");
		if (chu_xian_1 != null) {
			for (String a : chu_xian_1) {
				str = str + "|" + a;
			}
			j.setChuXian1(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�ڶ������Ƿ���֡�
		String[] chu_xian2 = request.getParameterValues("chu_xian2");
		if (chu_xian2 != null) {
			for (String a : chu_xian2) {
				str = str + "|" + a;
			}
			j.setChuXian2(str.substring(1));
			str = "";
		}

		// ���ܵ�ǰ̨�������ֲ�ʷ�Ƿ���
		String xian_has_lei_si_fa_zuo = request
				.getParameter("xian_has_lei_si_fa_zuo");
		if (xian_has_lei_si_fa_zuo != null) {
			if (xian_has_lei_si_fa_zuo.equals("��������")) {
				j.setXianLeiSiFaZuo(1);
			} else if (xian_has_lei_si_fa_zuo.equals("��Ϸ���")) {
				j.setXianLeiSiFaZuo(2);
			} else if (xian_has_lei_si_fa_zuo.equals("ż��")) {
				j.setXianLeiSiFaZuo(3);
			}
		}

		// ���յ�ǰ̨���ֲ�ʷ���岡
		String xian_has_qu_ti_ji_bing = request
				.getParameter("xian_has_qu_ti_ji_bing");
		if (xian_has_qu_ti_ji_bing != null) {
			if (xian_has_qu_ti_ji_bing.equals("��")) {
				j.setXianQuTiJiBing(1);
			} else if (xian_has_qu_ti_ji_bing.equals("ż��")) {
				j.setXianQuTiJiBing(2);
			}
		}

		// ���ܵ�ǰ̨�Ȳ�ʷ����ϣ�ʱ�����ҩʷ
		String xian_bing_shi = request.getParameter("xian_bing_shi");
		j.setXianJuTiJiBingZhenDuan(xian_bing_shi);

		// ���ܵ�ǰ̨������ʷ�Ƿ��з���
		String ji_wang_has_lei_si_fa_zuo = request
				.getParameter("ji_wang_has_lei_si_fa_zuo");
		if (ji_wang_has_lei_si_fa_zuo != null) {
			if (ji_wang_has_lei_si_fa_zuo.equals("��")) {
				j.setJiWangLeiSiFaZuo(1);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("ż��")) {
				j.setJiWangLeiSiFaZuo(2);
			} else if (ji_wang_has_lei_si_fa_zuo.equals("�෢")) {
				j.setJiWangLeiSiFaZuo(3);
			}
		}

		// ���յ�ǰ̨������ʷ���岡
		String ji_wang_has_qu_ti_ji_bing = request
				.getParameter("ji_wang_has_qu_ti_ji_bing");
		if (ji_wang_has_qu_ti_ji_bing != null) {
			if (ji_wang_has_qu_ti_ji_bing.equals("��")) {
				j.setJiWangQuTiJiBing(1);
			} else if (ji_wang_has_qu_ti_ji_bing.equals("ż��")) {
				j.setJiWangQuTiJiBing(2);
			}
		}

		// ����ǰ̨������ʷ����ϣ�ʱ�����ҩʷ
		String ji_wang_bing_shi = request.getParameter("ji_wang_bing_shi");
		j.setJiWangJuTiJiBingZhenDuan(ji_wang_bing_shi);

		// ���յ�ǰ̨�����Ƿ��в�ʷ
		String jia_zu_has_ji_bing = request.getParameter("jia_zu_has_ji_bing"); // ������
		if (jia_zu_has_ji_bing != null) {
			if (jia_zu_has_ji_bing.equals("��")) {
				j.setJiaZuBingShi(1);
			} else if (jia_zu_has_ji_bing.equals("ż��")) {
				j.setJiaZuBingShi(2);
			}
		}

		// ���յ�ǰ̨���岡ʷ����ϣ�ʱ�����ҩʷ
		String jia_zu_bing_shi = request.getParameter("jia_zu_bing_shi"); // ������
		j.setJiaZuJuTiJiBingZhenDuan(jia_zu_bing_shi);

		// ���յ�ǰ̨�����ص�
		String xingge = request.getParameter("xingge");
		if (xingge != null) {
			if (xingge.equals("����")) {
				j.setGeXingTeDian(1);
			} else if (xingge.equals("����")) {
				j.setGeXingTeDian(2);
			} else if (xingge.equals("����")) {
				j.setGeXingTeDian(3);
			}
		}

		// ���ܴ�ǰ̨�������ȶ���
		String qingxu = request.getParameter("qingxu");
		if (qingxu != null) {
			if (qingxu.equals("�ȶ�")) {
				j.setQingXuWenDingXing(1);
			} else if (qingxu.equals("Ƿ�ȶ�")) {
				j.setQingXuWenDingXing(2);
			}
		}

		//
		String tedian = request.getParameter("tedian");
		if (tedian != null) {
			if (tedian.equals("A��")) {
				j.setRenGeTeDian(1);
			} else if (tedian.equals("B��")) {
				j.setRenGeTeDian(2);
			} else if (tedian.equals("C��")) {
				j.setRenGeTeDian(3);
			}
		}

		// ���յ�ǰ̨Ѫ��
		String xuexing = request.getParameter("xuexing");
		if (xuexing != null) {
			if (xuexing.equals("A��")) {
				j.setXueXing(1);
			} else if (xuexing.equals("B��")) {
				j.setXueXing(2);
			} else if (xuexing.equals("AB��")) {
				j.setXueXing(3);
			} else if (xuexing.equals("O��")) {
				j.setXueXing(4);
			}
		}

		// ���յ�ǰ̨���˸�����
		String[] renge = request.getParameterValues("renge");
		if (renge != null) {
			for (String a : renge) {
				str = str + "|" + a;
			}
			j.setRenGeTeZhi(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��Ȥ
		String[] xingqu = request.getParameterValues("xingqu");
		if (xingqu != null) {
			for (String a : xingqu) {
				str = str + "|" + a;
			}
			j.setXingQu(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��ÿ�����̵���/֧
		String yan = request.getParameter("ya");
		try {
			j.setYan(Integer.parseInt(yan));
		} catch (Exception e) {

		}

		// ���ܴ�ǰ̨��ÿ��ȾƵ���/��
		String jiu = request.getParameter("jiu");
		try {
			j.setJiu(Integer.parseInt(jiu));
		} catch (Exception e) {

		}

		// ���ܵ�ǰ̨����������
		String qi = request.getParameter("yan_jiu_qi_ta");
		j.setYanJiuQiTa(qi);

		// ���յ�ǰ̨=����������
		String[] shengzhang = request.getParameterValues("shengzhang");
		if (shengzhang != null) {
			for (String a : shengzhang) {
				str = str + "|" + a;
			}
			j.setShengZhangFaYu(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨��ѧ����·������
		String walk = request.getParameter("walk");
		try {
			j.setXueBu(Integer.parseInt(walk));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�Ļ�˵��������
		String talk = request.getParameter("talk");
		try {
			j.setYuYan(Integer.parseInt(talk));
		} catch (Exception e) {

		}
		// ���ܵ�ǰ̨���¾�������
		String yuejing = request.getParameter("yuejing");
		try {
			j.setYueJingChuChao(Integer.parseInt(yuejing));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨���ž�������
		String yijing = request.getParameter("yijing");
		try {
			j.setShouCiYiJing(Integer.parseInt(yijing));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨��ͣ��������
		String ting = request.getParameter("ting");
		try {
			j.setTingJing(Integer.parseInt(ting));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�ĸ����˵���Ϣ
		String[] fuyangren = request.getParameterValues("fuyangren");
		if (fuyangren != null) {
			for (String a : fuyangren) {
				str = str + "|" + a;
			}
			j.setYouNianFuYangRen(str.substring(1));
			str = "";
		}

		// ���ܵ�ǰ̨�ļ�����ʼ������
		String jiyang1 = request.getParameter("jiyang1");
		try {
			j.setJiYangShi1(Integer.parseInt(jiyang1));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�ļ�������������
		String jiyang2 = request.getParameter("jiyang2");
		try {
			j.setJiYangShi2(Integer.parseInt(jiyang2));
		} catch (Exception e) {

		}

		// ���յ�ǰ̨�����������
		String[] you_nian_huan_jing = request
				.getParameterValues("you_nian_huan_jing");
		if (you_nian_huan_jing != null) {
			for (String a : you_nian_huan_jing) {
				str = str + "|" + a;
			}
			j.setYouNianShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�����ڵ������
		String[] xian_zai_huan_jing = request
				.getParameterValues("xian_zai_huan_jing");
		if (xian_zai_huan_jing != null) {
			for (String a : xian_zai_huan_jing) {
				str = str + "|" + a;
			}
			j.setXianZaiShengHuoHuanJing(str.substring(1));
			str = "";
		}

		// ���յ�ǰ̨�����ֵܽ��õĹ�ϵ
		String yu_xiong_di_jie_mei_guan_xi = request
				.getParameter("yu_xiong_di_jie_mei_guan_xi");
		if (yu_xiong_di_jie_mei_guan_xi != null) {
			if (yu_xiong_di_jie_mei_guan_xi.equals("����")) {
				j.setXiongDiJieMeiGuanXi(1);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("�п�")) {
				j.setXiongDiJieMeiGuanXi(2);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("һ��")) {
				j.setXiongDiJieMeiGuanXi(3);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("�䵭")) {
				j.setXiongDiJieMeiGuanXi(4);
			} else if (yu_xiong_di_jie_mei_guan_xi.equals("��")) {
				j.setXiongDiJieMeiGuanXi(5);
			}
		}

		// ���յ�ǰ̨�ķ��޹�ϵ
		String fu_qi_guan_xi = request.getParameter("fu_qi_guan_xi");
		if (fu_qi_guan_xi != null) {
			if (fu_qi_guan_xi.equals("����")) {
				j.setFuQiGuanXi(1);
			} else if (fu_qi_guan_xi.equals("�п�")) {
				j.setFuQiGuanXi(2);
			} else if (fu_qi_guan_xi.equals("һ��")) {
				j.setFuQiGuanXi(3);
			} else if (fu_qi_guan_xi.equals("�䵭")) {
				j.setFuQiGuanXi(4);
			} else if (fu_qi_guan_xi.equals("��")) {
				j.setFuQiGuanXi(5);
			}
		}

		// ���յ�ǰ̨����ϱ��ϵ
		String po_xi_guan_xi = request.getParameter("po_xi_guan_xi");
		if (po_xi_guan_xi != null) {
			if (po_xi_guan_xi.equals("����")) {
				j.setPoXiGuanXi(1);
			} else if (po_xi_guan_xi.equals("�п�")) {
				j.setPoXiGuanXi(2);
			} else if (po_xi_guan_xi.equals("һ��")) {
				j.setPoXiGuanXi(3);
			} else if (po_xi_guan_xi.equals("�䵭")) {
				j.setPoXiGuanXi(4);
			} else if (po_xi_guan_xi.equals("��")) {
				j.setPoXiGuanXi(5);
			}
		}

		// ���յ�ǰ̨�ĸ��׵�ְҵ
		String fu_qin_zhi_ye = request.getParameter("fu_qin_zhi_ye");
		j.setFuQinZhiYe(fu_qin_zhi_ye);

		// ���յ�ǰ̨��ĸ�׵�ְҵ
		String mu_qin_zhi_ye = request.getParameter("mu_qin_zhi_ye");
		j.setMuQinZhiYe(mu_qin_zhi_ye);

		// �����Ļ��̶�
		String fu_qin_wen_hua = request.getParameter("fu_qin_wen_hua");
		j.setFuQinWenHuaChengDu(fu_qin_wen_hua);

		// ĸ���Ļ��̶�
		String mu_qin_wen_hua = request.getParameter("mu_qin_wen_hua");
		j.setMuQinWenHuaChengDu(mu_qin_wen_hua);

		// �����¼�
		String fu_xing_shi_jian = request.getParameter("fu_xing_shi_jian");
		if (fu_xing_shi_jian != null) {
			if (fu_xing_shi_jian.equals("��")) {
				j.setZhongDaFuXingShiJian1(1);
			} else if (fu_xing_shi_jian.equals("��")) {
				j.setZhongDaFuXingShiJian1(2);
			}
		}

		// �����¼�����
		String fu_xing_shi_jian_nei_rong = request
				.getParameter("fu_xing_shi_jian_nei_rong");
		j.setZhongDaFuXingShiJian2(fu_xing_shi_jian_nei_rong);

		// Ӧ���¼�
		String ying_ji_shi_jian = request.getParameter("ying_ji_shi_jian");
		if (ying_ji_shi_jian != null) {
			if (ying_ji_shi_jian.equals("��")) {
				j.setYingJiShiJian1(1);
			} else if (ying_ji_shi_jian.equals("��")) {
				j.setYingJiShiJian1(2);
			}
		}

		// Ӧ���¼�����
		String ying_ji_shi_jian_nei_rong = request
				.getParameter("ying_ji_shi_jian_nei_rong");
		j.setYingJiShiJian2(ying_ji_shi_jian_nei_rong);

		// �˼ʹ�ϵ
		String renjiguanxi = request.getParameter("renjiguanxi");
		if (renjiguanxi != null) {
			if (renjiguanxi.equals("����")) {
				j.setRenJiGuanXi(1);
			} else if (renjiguanxi.equals("һ��")) {
				j.setRenJiGuanXi(2);
			} else if (renjiguanxi.equals("Ƿ��")) {
				j.setRenJiGuanXi(3);
			}
		}

		// �������Ϊ
		String[] wenti = request.getParameterValues("wenti");
		if (wenti != null) {
			for (String a : wenti) {
				str = str + "|" + a;
			}
			j.setWenTiBiaoXianWei(str.substring(1));
			str = "";
		}

		// ���ⷢ���ڣ�
		String[] wentifasheng = request.getParameterValues("wentifasheng");
		if (wentifasheng != null) {
			for (String a : wentifasheng) {
				str = str + "|" + a;
			}
			j.setWenTiFaShengZai(str.substring(1));
			str = "";
		}

		// ���ⷢ��������
		String qitafangmian = request.getParameter("qitafangmian");
		j.setWenTiFaShengQiTa(qitafangmian);

		// �����������
		String shenghuomianyiyufou = request
				.getParameter("shenghuomianyiyufou");
		if (shenghuomianyiyufou != null) {
			if (shenghuomianyiyufou.equals("����")) {
				j.setShengHuoManYiYuFou(1);
			} else if (shenghuomianyiyufou.equals("�п�")) {
				j.setShengHuoManYiYuFou(2);
			} else if (shenghuomianyiyufou.equals("������")) {
				j.setShengHuoManYiYuFou(3);
			}
		}

		// ������ķ���
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

		// ������֪
		String ji_bing_ren_zhi = request.getParameter("ji_bing_ren_zhi");
		if (ji_bing_ren_zhi != null) {
			if (ji_bing_ren_zhi.equals("��ȫ��ȷ")) {
				j.setDangQianJiBingRenZhi(1);
			} else if (ji_bing_ren_zhi.equals("������ȷ")) {
				j.setDangQianJiBingRenZhi(2);
			} else if (ji_bing_ren_zhi.equals("����ȷ")) {
				j.setDangQianJiBingRenZhi(3);
			} else if (ji_bing_ren_zhi.equals("��������")) {
				j.setDangQianJiBingRenZhi(4);
			} else if (ji_bing_ren_zhi.equals("��ȫ����")) {
				j.setDangQianJiBingRenZhi(5);
			}
		}

		// ��������̬��
		String taidu = request.getParameter("taidu");
		if (taidu != null) {
			if (taidu.equals("�ǳ��ֹ�")) {
				j.setJiBingYuHouTaiDu(1);
			} else if (taidu.equals("�ֹ�")) {
				j.setJiBingYuHouTaiDu(2);
			} else if (taidu.equals("��ȷ��")) {
				j.setJiBingYuHouTaiDu(3);
			} else if (taidu.equals("����")) {
				j.setJiBingYuHouTaiDu(4);
			} else if (taidu.equals("�ǳ�����")) {
				j.setJiBingYuHouTaiDu(5);
			}
		}

		// Ӧ�Է�ʽ
		String yingduifangshi = request.getParameter("yingduifangshi");
		if (yingduifangshi != null) {
			if (yingduifangshi.equals("�ǳ�����")) {
				j.setYingDuiFangShi(1);
			} else if (yingduifangshi.equals("����")) {
				j.setYingDuiFangShi(2);
			} else if (yingduifangshi.equals("һ��")) {
				j.setYingDuiFangShi(3);
			} else if (yingduifangshi.equals("����")) {
				j.setYingDuiFangShi(4);
			} else if (yingduifangshi.equals("�ǳ�����")) {
				j.setYingDuiFangShi(5);
			}
		}

		// ���Ʋ���̶�
		String zhiliaocanyu = request.getParameter("zhiliaocanyu");
		if (zhiliaocanyu != null) {
			if (zhiliaocanyu.equals("��������")) {
				j.setZhiLiaoCanYuChengDu(1);
			} else if (zhiliaocanyu.equals("��������")) {
				j.setZhiLiaoCanYuChengDu(2);
			} else if (zhiliaocanyu.equals("һ��")) {
				j.setZhiLiaoCanYuChengDu(3);
			}
		}

		// ������
		String shehuizhichi = request.getParameter("shehuizhichi");
		if (shehuizhichi != null) {
			if (shehuizhichi.equals("����")) {
				j.setSheHuiZhiChi(1);
			} else if (shehuizhichi.equals("��")) {
				j.setSheHuiZhiChi(2);
			} else if (shehuizhichi.equals("һ��")) {
				j.setSheHuiZhiChi(3);
			} else if (shehuizhichi.equals("��")) {
				j.setSheHuiZhiChi(4);
			} else if (shehuizhichi.equals("����")) {
				j.setSheHuiZhiChi(5);
			}
		}

		// ����
		String pengyou = request.getParameter("pengyou");
		if (pengyou != null) {
			if (pengyou.equals("����")) {
				j.setPengYou(1);
			} else if (pengyou.equals("��")) {
				j.setPengYou(2);
			} else if (pengyou.equals("һ��")) {
				j.setPengYou(3);
			} else if (pengyou.equals("��")) {
				j.setPengYou(4);
			} else if (pengyou.equals("����")) {
				j.setPengYou(5);
			}
		}

		// ����
		String jiaren = request.getParameter("jiaren");
		if (jiaren != null) {
			if (jiaren.equals("����")) {
				j.setJiaRen(1);
			} else if (jiaren.equals("��")) {
				j.setJiaRen(2);
			} else if (jiaren.equals("һ��")) {
				j.setJiaRen(3);
			} else if (jiaren.equals("��")) {
				j.setJiaRen(4);
			} else if (jiaren.equals("����")) {
				j.setJiaRen(5);
			}
		}

		// �Ը����֧�����ö�
		String gexiangzhichi = request.getParameter("gexiangzhichi");
		if (gexiangzhichi != null) {
			if (gexiangzhichi.equals("����")) {
				j.setDuiGeXiangZhiChiLiYongDu(1);
			} else if (gexiangzhichi.equals("��")) {
				j.setDuiGeXiangZhiChiLiYongDu(2);
			} else if (gexiangzhichi.equals("һ��")) {
				j.setDuiGeXiangZhiChiLiYongDu(3);
			} else if (gexiangzhichi.equals("��")) {
				j.setDuiGeXiangZhiChiLiYongDu(4);
			} else if (gexiangzhichi.equals("����")) {
				j.setDuiGeXiangZhiChiLiYongDu(5);
			}
		}

		String yin_xiang = request.getParameter("yin_xiang");
		if (yin_xiang != null) {
			if (yin_xiang.equals("��˥��")) {
				j.setYinXiang(1);
			} else if (yin_xiang.equals("ֲ���񾭹�������")) {
				j.setYinXiang(2);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(3);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(4);
			} else if (yin_xiang.equals("��������״̬")) {
				j.setYinXiang(5);
			} else if (yin_xiang.equals("ǿ��״̬")) {
				j.setYinXiang(6);
			} else if (yin_xiang.equals("���״̬")) {
				j.setYinXiang(7);
			} else if (yin_xiang.equals("����״̬")) {
				j.setYinXiang(8);
			}
		}

		// ӡ������
		String yin_xiang_qi_ta = request.getParameter("yin_xiang_qi_ta");
		j.setYinXiangQiTa(yin_xiang_qi_ta);

		// ����
		String chu_zhi = request.getParameter("chu_zhi");
		if (chu_zhi != null) {
			if (chu_zhi.equals("����������Թ��ܼ�⣬HRV��⣬�����A,B C������")) {
				j.setChuZhi(1);
			} else if (chu_zhi.equals("���Լ�⣨�Թ��ܼ�⣬HRV���׷�����")) {
				j.setChuZhi(2);
			} else if (chu_zhi.equals("ֲ���񾭹��ܼ�⣨HRV���׷�����")) {
				j.setChuZhi(3);
			}
		}

		jiChuXinXiDao.save(j, request.getSession(true));

		request.getRequestDispatcher("jcxm?m=iJcxmAdd").forward(request,
				response);
	}

	/**
	 * ���벡�������������Ϣ��ӵĽ��棬���˲��ǵ�һ�������ҽԺ�������У�����ֱ�ӵ�����ǰ�����ҽԺ��д�Ļ�����Ϣ
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
	 * ���벡�������������Ϣ��ӵĽ��棬���˵�һ�������ҽԺ
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
	 * ���������Ϣ�б�Ľ���
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

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
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
						if (value.equals("��")) {
							j.setXingBie(1);
						} else if (value.equals("Ů")) {
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
						if (value.equals("����")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("һ��")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("�ϲ�")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("�ܲ�")) {
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

					// ���յ�ǰ̨ʳ����״̬
					if ("shiyu".equals(name)) {
						if (value.equals("����")) {
							j.setShiYu(1);
						} else if (value.equals("һ��")) {
							j.setShiYu(2);
						} else if (value.equals("Ƿ��")) {
							j.setShiYu(3);
						}
					}

					// ���յ�ǰ̨�������״��
					if ("xingshenghuo".equals(name)) {
						if (value.equals("����")) {
							j.setXingShengHuo(1);
						} else if (value.equals("һ��")) {
							j.setXingShengHuo(2);
						} else if (value.equals("Ƿ��")) {
							j.setXingShengHuo(3);
						}
					}

					// ���յ�ǰ̨��һ�����Ƿ���֡�
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// ���յ�ǰ̨�ڶ������Ƿ���֡�
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// ���ܵ�ǰ̨�������ֲ�ʷ�Ƿ���
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��������")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("��Ϸ���")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("ż��")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("��")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// ���յ�ǰ̨���ֲ�ʷ���岡
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// ���ܵ�ǰ̨�Ȳ�ʷ����ϣ�ʱ�����ҩʷ
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// ���ܵ�ǰ̨������ʷ�Ƿ��з���
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("ż��")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("�෢")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// ���յ�ǰ̨������ʷ���岡
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// ����ǰ̨������ʷ����ϣ�ʱ�����ҩʷ
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����Ƿ��в�ʷ
					if ("jia_zu_has_ji_bing".equals(name)) { // ������
						if (value.equals("��")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("ż��")) {
							j.setJiaZuBingShi(2);
						}
					}

					// ���յ�ǰ̨���岡ʷ����ϣ�ʱ�����ҩʷ
					if ("jia_zu_bing_shi".equals(name)) { // ������
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����ص�
					if ("xingge".equals(name)) {
						if (value.equals("����")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(3);
						}
					}

					// ���ܴ�ǰ̨�������ȶ���
					if ("qingxu".equals(name)) {
						if (value.equals("�ȶ�")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("Ƿ�ȶ�")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A��")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B��")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C��")) {
							j.setRenGeTeDian(3);
						}
					}

					// ���յ�ǰ̨Ѫ��
					if ("xuexing".equals(name)) {
						if (value.equals("A��")) {
							j.setXueXing(1);
						} else if (value.equals("B��")) {
							j.setXueXing(2);
						} else if (value.equals("AB��")) {
							j.setXueXing(3);
						} else if (value.equals("O��")) {
							j.setXueXing(4);
						}
					}

					// ���յ�ǰ̨���˸�����
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// ���յ�ǰ̨��Ȥ
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// ���յ�ǰ̨��ÿ�����̵���/֧
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܴ�ǰ̨��ÿ��ȾƵ���/��
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܵ�ǰ̨����������
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// ���յ�ǰ̨=����������
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// ���յ�ǰ̨��ѧ����·������
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�Ļ�˵��������
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// ���ܵ�ǰ̨���¾�������
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨���ž�������
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨��ͣ��������
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ĸ����˵���Ϣ
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// ���ܵ�ǰ̨�ļ�����ʼ������
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ļ�������������
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨�����������
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ڵ������
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ֵܽ��õĹ�ϵ
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("��")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// ���յ�ǰ̨�ķ��޹�ϵ
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("��")) {
							j.setFuQiGuanXi(5);
						}
					}

					// ���յ�ǰ̨����ϱ��ϵ
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("��")) {
							j.setPoXiGuanXi(5);
						}
					}
					// ���յ�ǰ̨�����ӹ�ϵ
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("��")) {
							j.setQinZiGuanXi(5);
						}
					}

					// // ���յ�ǰ̨�ĸ��׵�ְҵ
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// ���յ�ǰ̨��ĸ�׵�ְҵ
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// �����Ļ��̶�
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// ĸ���Ļ��̶�
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// �����¼�
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// �����¼�����
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// Ӧ���¼�
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("��")) {
							j.setYingJiShiJian1(2);
						}
					}

					// Ӧ���¼�����
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// �˼ʹ�ϵ
					if ("renjiguanxi".equals(name)) {
						if (value.equals("����")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("һ��")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("Ƿ��")) {
							j.setRenJiGuanXi(3);
						}
					}

					// �������Ϊ
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// ���ⷢ���ڣ�
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// ���ⷢ��������
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// �����������
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("����")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("�п�")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("������")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// ������ķ���
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

					// ������֪
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("��ȫ��ȷ")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("������ȷ")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("����ȷ")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("��������")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("��ȫ����")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// ��������̬��
					if ("taidu".equals(name)) {
						if (value.equals("�ǳ��ֹ�")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("�ֹ�")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("��ȷ��")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("����")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("�ǳ�����")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// Ӧ�Է�ʽ
					if ("yingduifangshi".equals(name)) {
						if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("һ��")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(5);
						}
					}

					// ���Ʋ���̶�
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("һ��")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// ������
					if ("shehuizhichi".equals(name)) {
						if (value.equals("����")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("һ��")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("����")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// ����
					if ("pengyou".equals(name)) {
						if (value.equals("����")) {
							j.setPengYou(1);
						} else if (value.equals("��")) {
							j.setPengYou(2);
						} else if (value.equals("һ��")) {
							j.setPengYou(3);
						} else if (value.equals("��")) {
							j.setPengYou(4);
						} else if (value.equals("����")) {
							j.setPengYou(5);
						}
					}

					// ����
					if ("jiaren".equals(name)) {
						if (value.equals("����")) {
							j.setJiaRen(1);
						} else if (value.equals("��")) {
							j.setJiaRen(2);
						} else if (value.equals("һ��")) {
							j.setJiaRen(3);
						} else if (value.equals("��")) {
							j.setJiaRen(4);
						} else if (value.equals("����")) {
							j.setJiaRen(5);
						}
					}

					// �Ը����֧�����ö�
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("һ��")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("��˥��")) {
							j.setYinXiang(1);
						} else if (value.equals("ֲ���񾭹�������")) {
							j.setYinXiang(2);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(3);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(4);
						} else if (value.equals("��������״̬")) {
							j.setYinXiang(5);
						} else if (value.equals("ǿ��״̬")) {
							j.setYinXiang(6);
						} else if (value.equals("���״̬")) {
							j.setYinXiang(7);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(8);
						}
					}
					// ����ͼ��ע
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// ӡ������
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// ����
					if ("chu_zhi".equals(name)) {
						if (value.equals("����������Թ��ܼ�⣬HRV��⣬�����A,B C������")) {
							j.setChuZhi(1);
						} else if (value.equals("���Լ�⣨�Թ��ܼ�⣬HRV���׷�����")) {
							j.setChuZhi(2);
						} else if (value.equals("ֲ���񾭹��ܼ�⣨HRV���׷�����")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
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

		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
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
						if (value.equals("��")) {
							j.setXingBie(1);
						} else if (value.equals("Ů")) {
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
						if (value.equals("����")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("һ��")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("�ϲ�")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("�ܲ�")) {
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

					// ���յ�ǰ̨ʳ����״̬
					if ("shiyu".equals(name)) {
						if (value.equals("����")) {
							j.setShiYu(1);
						} else if (value.equals("һ��")) {
							j.setShiYu(2);
						} else if (value.equals("Ƿ��")) {
							j.setShiYu(3);
						}
					}

					// ���յ�ǰ̨�������״��
					if ("xingshenghuo".equals(name)) {
						if (value.equals("����")) {
							j.setXingShengHuo(1);
						} else if (value.equals("һ��")) {
							j.setXingShengHuo(2);
						} else if (value.equals("Ƿ��")) {
							j.setXingShengHuo(3);
						}
					}

					// ���յ�ǰ̨��һ�����Ƿ���֡�
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// ���յ�ǰ̨�ڶ������Ƿ���֡�
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// ���ܵ�ǰ̨�������ֲ�ʷ�Ƿ���
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��������")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("��Ϸ���")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("ż��")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("��")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// ���յ�ǰ̨���ֲ�ʷ���岡
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// ���ܵ�ǰ̨�Ȳ�ʷ����ϣ�ʱ�����ҩʷ
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// ���ܵ�ǰ̨������ʷ�Ƿ��з���
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("ż��")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("�෢")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// ���յ�ǰ̨������ʷ���岡
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// ����ǰ̨������ʷ����ϣ�ʱ�����ҩʷ
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����Ƿ��в�ʷ
					if ("jia_zu_has_ji_bing".equals(name)) { // ������
						if (value.equals("��")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("ż��")) {
							j.setJiaZuBingShi(2);
						}
					}

					// ���յ�ǰ̨���岡ʷ����ϣ�ʱ�����ҩʷ
					if ("jia_zu_bing_shi".equals(name)) { // ������
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����ص�
					if ("xingge".equals(name)) {
						if (value.equals("����")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(3);
						}
					}

					// ���ܴ�ǰ̨�������ȶ���
					if ("qingxu".equals(name)) {
						if (value.equals("�ȶ�")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("Ƿ�ȶ�")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A��")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B��")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C��")) {
							j.setRenGeTeDian(3);
						}
					}

					// ���յ�ǰ̨Ѫ��
					if ("xuexing".equals(name)) {
						if (value.equals("A��")) {
							j.setXueXing(1);
						} else if (value.equals("B��")) {
							j.setXueXing(2);
						} else if (value.equals("AB��")) {
							j.setXueXing(3);
						} else if (value.equals("O��")) {
							j.setXueXing(4);
						}
					}

					// ���յ�ǰ̨���˸�����
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// ���յ�ǰ̨��Ȥ
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// ���յ�ǰ̨��ÿ�����̵���/֧
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܴ�ǰ̨��ÿ��ȾƵ���/��
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܵ�ǰ̨����������
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// ���յ�ǰ̨=����������
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// ���յ�ǰ̨��ѧ����·������
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�Ļ�˵��������
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// ���ܵ�ǰ̨���¾�������
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨���ž�������
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨��ͣ��������
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ĸ����˵���Ϣ
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// ���ܵ�ǰ̨�ļ�����ʼ������
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ļ�������������
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨�����������
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ڵ������
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ֵܽ��õĹ�ϵ
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("��")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// ���յ�ǰ̨�ķ��޹�ϵ
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("��")) {
							j.setFuQiGuanXi(5);
						}
					}

					// ���յ�ǰ̨����ϱ��ϵ
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("��")) {
							j.setPoXiGuanXi(5);
						}
					}
					// ���յ�ǰ̨�����ӹ�ϵ
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("��")) {
							j.setQinZiGuanXi(5);
						}
					}

					// // ���յ�ǰ̨�ĸ��׵�ְҵ
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// ���յ�ǰ̨��ĸ�׵�ְҵ
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// �����Ļ��̶�
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// ĸ���Ļ��̶�
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// �����¼�
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// �����¼�����
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// Ӧ���¼�
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("��")) {
							j.setYingJiShiJian1(2);
						}
					}

					// Ӧ���¼�����
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// �˼ʹ�ϵ
					if ("renjiguanxi".equals(name)) {
						if (value.equals("����")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("һ��")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("Ƿ��")) {
							j.setRenJiGuanXi(3);
						}
					}

					// �������Ϊ
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// ���ⷢ���ڣ�
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// ���ⷢ��������
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// �����������
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("����")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("�п�")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("������")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// ������ķ���
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

					// ������֪
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("��ȫ��ȷ")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("������ȷ")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("����ȷ")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("��������")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("��ȫ����")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// ��������̬��
					if ("taidu".equals(name)) {
						if (value.equals("�ǳ��ֹ�")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("�ֹ�")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("��ȷ��")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("����")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("�ǳ�����")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// Ӧ�Է�ʽ
					if ("yingduifangshi".equals(name)) {
						if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("һ��")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(5);
						}
					}

					// ���Ʋ���̶�
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("һ��")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// ������
					if ("shehuizhichi".equals(name)) {
						if (value.equals("����")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("һ��")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("����")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// ����
					if ("pengyou".equals(name)) {
						if (value.equals("����")) {
							j.setPengYou(1);
						} else if (value.equals("��")) {
							j.setPengYou(2);
						} else if (value.equals("һ��")) {
							j.setPengYou(3);
						} else if (value.equals("��")) {
							j.setPengYou(4);
						} else if (value.equals("����")) {
							j.setPengYou(5);
						}
					}

					// ����
					if ("jiaren".equals(name)) {
						if (value.equals("����")) {
							j.setJiaRen(1);
						} else if (value.equals("��")) {
							j.setJiaRen(2);
						} else if (value.equals("һ��")) {
							j.setJiaRen(3);
						} else if (value.equals("��")) {
							j.setJiaRen(4);
						} else if (value.equals("����")) {
							j.setJiaRen(5);
						}
					}

					// �Ը����֧�����ö�
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("һ��")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("��˥��")) {
							j.setYinXiang(1);
						} else if (value.equals("ֲ���񾭹�������")) {
							j.setYinXiang(2);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(3);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(4);
						} else if (value.equals("��������״̬")) {
							j.setYinXiang(5);
						} else if (value.equals("ǿ��״̬")) {
							j.setYinXiang(6);
						} else if (value.equals("���״̬")) {
							j.setYinXiang(7);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(8);
						}
					}
					// ����ͼ��ע
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// ӡ������
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// ����
					if ("chu_zhi".equals(name)) {
						if (value.equals("����������Թ��ܼ�⣬HRV��⣬�����A,B C������")) {
							j.setChuZhi(1);
						} else if (value.equals("���Լ�⣨�Թ��ܼ�⣬HRV���׷�����")) {
							j.setChuZhi(2);
						} else if (value.equals("ֲ���񾭹��ܼ�⣨HRV���׷�����")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
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
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/img/upload");

		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		JiChuXinXi j = new JiChuXinXi();
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();

				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {

					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
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
						if (value.equals("��")) {
							j.setXingBie(1);
						} else if (value.equals("Ů")) {
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
						if (value.equals("����")) {
							j.setJingJiZhuangKuang(1);
						} else if (value.equals("һ��")) {
							j.setJingJiZhuangKuang(2);
						} else if (value.equals("�ϲ�")) {
							j.setJingJiZhuangKuang(3);
						} else if (value.equals("�ܲ�")) {
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

					// ���յ�ǰ̨ʳ����״̬
					if ("shiyu".equals(name)) {
						if (value.equals("����")) {
							j.setShiYu(1);
						} else if (value.equals("һ��")) {
							j.setShiYu(2);
						} else if (value.equals("Ƿ��")) {
							j.setShiYu(3);
						}
					}

					// ���յ�ǰ̨�������״��
					if ("xingshenghuo".equals(name)) {
						if (value.equals("����")) {
							j.setXingShengHuo(1);
						} else if (value.equals("һ��")) {
							j.setXingShengHuo(2);
						} else if (value.equals("Ƿ��")) {
							j.setXingShengHuo(3);
						}
					}

					// ���յ�ǰ̨��һ�����Ƿ���֡�
					if ("chu_xian_1".equals(name)) {
						j.setChuXian1(j.getChuXian1() + "|" + value);
						if (j.getChuXian1().startsWith("null|")) {
							j.setChuXian1(j.getChuXian1().substring(5));
						}
					}

					// ���յ�ǰ̨�ڶ������Ƿ���֡�
					if ("chu_xian2".equals(name)) {
						j.setChuXian2(j.getChuXian2() + "|" + value);
						if (j.getChuXian2().startsWith("null|")) {
							j.setChuXian2(j.getChuXian2().substring(5));
						}
					}

					// ���ܵ�ǰ̨�������ֲ�ʷ�Ƿ���
					if ("xian_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��������")) {
							j.setXianLeiSiFaZuo(1);
						} else if (value.equals("��Ϸ���")) {
							j.setXianLeiSiFaZuo(2);
						} else if (value.equals("ż��")) {
							j.setXianLeiSiFaZuo(3);
						} else if (value.equals("��")) {
							j.setXianLeiSiFaZuo(4);
						}
					}

					// ���յ�ǰ̨���ֲ�ʷ���岡
					if ("xian_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setXianQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setXianQuTiJiBing(2);
						}
					}

					// ���ܵ�ǰ̨�Ȳ�ʷ����ϣ�ʱ�����ҩʷ
					if ("xian_bing_shi".equals(name)) {
						j.setXianJuTiJiBingZhenDuan(value);
					}

					// ���ܵ�ǰ̨������ʷ�Ƿ��з���
					if ("ji_wang_has_lei_si_fa_zuo".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangLeiSiFaZuo(1);
						} else if (value.equals("ż��")) {
							j.setJiWangLeiSiFaZuo(2);
						} else if (value.equals("�෢")) {
							j.setJiWangLeiSiFaZuo(3);
						}
					}

					// ���յ�ǰ̨������ʷ���岡
					if ("ji_wang_has_qu_ti_ji_bing".equals(name)) {
						if (value.equals("��")) {
							j.setJiWangQuTiJiBing(1);
						} else if (value.equals("ż��")) {
							j.setJiWangQuTiJiBing(2);
						}
					}

					// ����ǰ̨������ʷ����ϣ�ʱ�����ҩʷ
					if ("ji_wang_bing_shi".equals(name)) {
						j.setJiWangJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����Ƿ��в�ʷ
					if ("jia_zu_has_ji_bing".equals(name)) { // ������
						if (value.equals("��")) {
							j.setJiaZuBingShi(1);
						} else if (value.equals("ż��")) {
							j.setJiaZuBingShi(2);
						}
					}

					// ���յ�ǰ̨���岡ʷ����ϣ�ʱ�����ҩʷ
					if ("jia_zu_bing_shi".equals(name)) { // ������
						j.setJiaZuJuTiJiBingZhenDuan(value);
					}
					// ���յ�ǰ̨�����ص�
					if ("xingge".equals(name)) {
						if (value.equals("����")) {
							j.setGeXingTeDian(1);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(2);
						} else if (value.equals("����")) {
							j.setGeXingTeDian(3);
						}
					}

					// ���ܴ�ǰ̨�������ȶ���
					if ("qingxu".equals(name)) {
						if (value.equals("�ȶ�")) {
							j.setQingXuWenDingXing(1);
						} else if (value.equals("Ƿ�ȶ�")) {
							j.setQingXuWenDingXing(2);
						}
					}

					//
					if ("tedian".equals(name)) {
						if (value.equals("A��")) {
							j.setRenGeTeDian(1);
						} else if (value.equals("B��")) {
							j.setRenGeTeDian(2);
						} else if (value.equals("C��")) {
							j.setRenGeTeDian(3);
						}
					}

					// ���յ�ǰ̨Ѫ��
					if ("xuexing".equals(name)) {
						if (value.equals("A��")) {
							j.setXueXing(1);
						} else if (value.equals("B��")) {
							j.setXueXing(2);
						} else if (value.equals("AB��")) {
							j.setXueXing(3);
						} else if (value.equals("O��")) {
							j.setXueXing(4);
						}
					}

					// ���յ�ǰ̨���˸�����
					if ("renge".equals(name)) {
						j.setRenGeTeZhi(j.getRenGeTeZhi() + "|" + value);
						if (j.getRenGeTeZhi().startsWith("null|")) {
							j.setRenGeTeZhi(j.getRenGeTeZhi().substring(5));
						}

					}

					// ���յ�ǰ̨��Ȥ
					if ("xingqu".equals(name)) {
						j.setXingQu(j.getXingQu() + "|" + value);
						if (j.getXingQu().startsWith("null|")) {
							j.setXingQu(j.getXingQu().substring(5));
						}
					}

					// ���յ�ǰ̨��ÿ�����̵���/֧
					if ("ya".equals(name)) {
						try {
							j.setYan(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܴ�ǰ̨��ÿ��ȾƵ���/��
					if ("jiu".equals(name)) {
						try {
							j.setJiu(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���ܵ�ǰ̨����������
					if ("yan_jiu_qi_ta".equals(name)) {
						j.setYanJiuQiTa(value);
					}
					// ���յ�ǰ̨=����������
					if ("shengzhang".equals(name)) {
						j.setShengZhangFaYu(j.getShengZhangFaYu() + "|" + value);
						if (j.getShengZhangFaYu().startsWith("null|")) {
							j.setShengZhangFaYu(j.getShengZhangFaYu()
									.substring(5));
						}
					}

					// ���յ�ǰ̨��ѧ����·������
					if ("walk".equals(name)) {
						try {
							j.setXueBu(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�Ļ�˵��������
					if ("talk".equals(name)) {
						try {
							j.setYuYan(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}
					// ���ܵ�ǰ̨���¾�������
					if ("yuejing".equals(name)) {
						try {
							j.setYueJingChuChao(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨���ž�������
					if ("yijing".equals(name)) {
						try {
							j.setShouCiYiJing(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨��ͣ��������
					if ("ting".equals(name)) {
						try {
							j.setTingJing(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ĸ����˵���Ϣ
					if ("fuyangren".equals(name)) {
						j.setYouNianFuYangRen(j.getYouNianFuYangRen() + "|"
								+ value);
						if (j.getYouNianFuYangRen().startsWith("null|")) {
							j.setYouNianFuYangRen(j.getYouNianFuYangRen()
									.substring(5));
						}
					}

					// ���ܵ�ǰ̨�ļ�����ʼ������
					if ("jiyang1".equals(name)) {
						try {
							j.setJiYangShi1(Integer.parseInt(value));
						} catch (Exception e) {
						}
					}

					// ���յ�ǰ̨�ļ�������������
					if ("jiyang2".equals(name)) {
						try {
							j.setJiYangShi2(Integer.parseInt(value));
						} catch (Exception e) {

						}
					}

					// ���յ�ǰ̨�����������
					if ("you_nian_huan_jing".equals(name)) {
						j.setYouNianShengHuoHuanJing(j
								.getYouNianShengHuoHuanJing() + "|" + value);
						if (j.getYouNianShengHuoHuanJing().startsWith("null|")) {

							j.setYouNianShengHuoHuanJing(j
									.getYouNianShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ڵ������
					if ("xian_zai_huan_jing".equals(name)) {
						j.setXianZaiShengHuoHuanJing(j
								.getXianZaiShengHuoHuanJing() + "|" + value);
						if (j.getXianZaiShengHuoHuanJing().startsWith("null|")) {
							j.setXianZaiShengHuoHuanJing(j
									.getXianZaiShengHuoHuanJing().substring(5));
						}
					}

					// ���յ�ǰ̨�����ֵܽ��õĹ�ϵ
					if ("yu_xiong_di_jie_mei_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setXiongDiJieMeiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setXiongDiJieMeiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setXiongDiJieMeiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setXiongDiJieMeiGuanXi(4);
						} else if (value.equals("��")) {
							j.setXiongDiJieMeiGuanXi(5);
						}
					}

					// ���յ�ǰ̨�ķ��޹�ϵ
					if ("fu_qi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setFuQiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setFuQiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setFuQiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setFuQiGuanXi(4);
						} else if (value.equals("��")) {
							j.setFuQiGuanXi(5);
						}
					}

					// ���յ�ǰ̨����ϱ��ϵ
					if ("po_xi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setPoXiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setPoXiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setPoXiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setPoXiGuanXi(4);
						} else if (value.equals("��")) {
							j.setPoXiGuanXi(5);
						}
					}
					// ���յ�ǰ̨�����ӹ�ϵ
					if ("qin_zi_guan_xi".equals(name)) {
						if (value.equals("����")) {
							j.setQinZiGuanXi(1);
						} else if (value.equals("�п�")) {
							j.setQinZiGuanXi(2);
						} else if (value.equals("һ��")) {
							j.setQinZiGuanXi(3);
						} else if (value.equals("�䵭")) {
							j.setQinZiGuanXi(4);
						} else if (value.equals("��")) {
							j.setQinZiGuanXi(5);
						}
					}
					// // ���յ�ǰ̨�ĸ��׵�ְҵ
					if ("fu_qin_zhi_ye".equals(name)) {
						j.setFuQinZhiYe(value);
					}

					// ���յ�ǰ̨��ĸ�׵�ְҵ
					if ("mu_qin_zhi_ye".equals(name)) {
						j.setMuQinZhiYe(value);
					}

					// �����Ļ��̶�
					if ("fu_qin_wen_hua".equals(name)) {
						j.setFuQinWenHuaChengDu(value);
					}

					// ĸ���Ļ��̶�
					if ("mu_qin_wen_hua".equals(name)) {
						j.setMuQinWenHuaChengDu(value);
					}

					// �����¼�
					if ("fu_xing_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(1);
						} else if (value.equals("��")) {
							j.setZhongDaFuXingShiJian1(2);
						}
					}

					// �����¼�����
					if ("fu_xing_shi_jian_nei_rong".equals(name)) {
						j.setZhongDaFuXingShiJian2(value);
					}

					// Ӧ���¼�
					if ("ying_ji_shi_jian".equals(name)) {
						if (value.equals("��")) {
							j.setYingJiShiJian1(1);
						} else if (value.equals("��")) {
							j.setYingJiShiJian1(2);
						}
					}

					// Ӧ���¼�����
					if ("ying_ji_shi_jian_nei_rong".equals(name)) {
						j.setYingJiShiJian2(value);
					}

					// �˼ʹ�ϵ
					if ("renjiguanxi".equals(name)) {
						if (value.equals("����")) {
							j.setRenJiGuanXi(1);
						} else if (value.equals("һ��")) {
							j.setRenJiGuanXi(2);
						} else if (value.equals("Ƿ��")) {
							j.setRenJiGuanXi(3);
						}
					}

					// �������Ϊ
					if ("wenti".equals(name)) {
						j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei() + "|"
								+ value);
						if (j.getWenTiBiaoXianWei().startsWith("null|")) {
							j.setWenTiBiaoXianWei(j.getWenTiBiaoXianWei()
									.substring(5));
						}
					}

					// ���ⷢ���ڣ�
					if ("wentifasheng".equals(name)) {
						j.setWenTiFaShengZai(j.getWenTiFaShengZai() + "|"
								+ value);
						if (j.getWenTiFaShengZai().startsWith("null|")) {
							j.setWenTiFaShengZai(j.getWenTiFaShengZai()
									.substring(5));
						}
					}

					// ���ⷢ��������
					if ("qitafangmian".equals(name)) {
						j.setWenTiFaShengQiTa(value);
					}

					// �����������
					if ("shenghuomianyiyufou".equals(name)) {
						if (value.equals("����")) {
							j.setShengHuoManYiYuFou(1);
						} else if (value.equals("�п�")) {
							j.setShengHuoManYiYuFou(2);
						} else if (value.equals("������")) {
							j.setShengHuoManYiYuFou(3);
						}
					}

					// ������ķ���
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

					// ������֪
					if ("ji_bing_ren_zhi".equals(name)) {
						if (value.equals("��ȫ��ȷ")) {
							j.setDangQianJiBingRenZhi(1);
						} else if (value.equals("������ȷ")) {
							j.setDangQianJiBingRenZhi(2);
						} else if (value.equals("����ȷ")) {
							j.setDangQianJiBingRenZhi(3);
						} else if (value.equals("��������")) {
							j.setDangQianJiBingRenZhi(4);
						} else if (value.equals("��ȫ����")) {
							j.setDangQianJiBingRenZhi(5);
						}
					}

					// ��������̬��
					if ("taidu".equals(name)) {
						if (value.equals("�ǳ��ֹ�")) {
							j.setJiBingYuHouTaiDu(1);
						} else if (value.equals("�ֹ�")) {
							j.setJiBingYuHouTaiDu(2);
						} else if (value.equals("��ȷ��")) {
							j.setJiBingYuHouTaiDu(3);
						} else if (value.equals("����")) {
							j.setJiBingYuHouTaiDu(4);
						} else if (value.equals("�ǳ�����")) {
							j.setJiBingYuHouTaiDu(5);
						}
					}

					// Ӧ�Է�ʽ
					if ("yingduifangshi".equals(name)) {
						if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(1);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(2);
						} else if (value.equals("һ��")) {
							j.setYingDuiFangShi(3);
						} else if (value.equals("����")) {
							j.setYingDuiFangShi(4);
						} else if (value.equals("�ǳ�����")) {
							j.setYingDuiFangShi(5);
						}
					}

					// ���Ʋ���̶�
					if ("zhiliaocanyu".equals(name)) {
						if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(1);
						} else if (value.equals("��������")) {
							j.setZhiLiaoCanYuChengDu(2);
						} else if (value.equals("һ��")) {
							j.setZhiLiaoCanYuChengDu(3);
						}
					}

					// ������
					if ("shehuizhichi".equals(name)) {
						if (value.equals("����")) {
							j.setSheHuiZhiChi(1);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(2);
						} else if (value.equals("һ��")) {
							j.setSheHuiZhiChi(3);
						} else if (value.equals("��")) {
							j.setSheHuiZhiChi(4);
						} else if (value.equals("����")) {
							j.setSheHuiZhiChi(5);
						}
					}

					// ����
					if ("pengyou".equals(name)) {
						if (value.equals("����")) {
							j.setPengYou(1);
						} else if (value.equals("��")) {
							j.setPengYou(2);
						} else if (value.equals("һ��")) {
							j.setPengYou(3);
						} else if (value.equals("��")) {
							j.setPengYou(4);
						} else if (value.equals("����")) {
							j.setPengYou(5);
						}
					}

					// ����
					if ("jiaren".equals(name)) {
						if (value.equals("����")) {
							j.setJiaRen(1);
						} else if (value.equals("��")) {
							j.setJiaRen(2);
						} else if (value.equals("һ��")) {
							j.setJiaRen(3);
						} else if (value.equals("��")) {
							j.setJiaRen(4);
						} else if (value.equals("����")) {
							j.setJiaRen(5);
						}
					}

					// �Ը����֧�����ö�
					if ("gexiangzhichi".equals(name)) {
						if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(1);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(2);
						} else if (value.equals("һ��")) {
							j.setDuiGeXiangZhiChiLiYongDu(3);
						} else if (value.equals("��")) {
							j.setDuiGeXiangZhiChiLiYongDu(4);
						} else if (value.equals("����")) {
							j.setDuiGeXiangZhiChiLiYongDu(5);
						}
					}

					if ("yin_xiang".equals(name)) {
						if (value.equals("��˥��")) {
							j.setYinXiang(1);
						} else if (value.equals("ֲ���񾭹�������")) {
							j.setYinXiang(2);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(3);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(4);
						} else if (value.equals("��������״̬")) {
							j.setYinXiang(5);
						} else if (value.equals("ǿ��״̬")) {
							j.setYinXiang(6);
						} else if (value.equals("���״̬")) {
							j.setYinXiang(7);
						} else if (value.equals("����״̬")) {
							j.setYinXiang(8);
						}
					}

					// ����ͼ��ע
					if ("jia_pu_tu_bei_zhu".equals(name)) {
						j.setJiaPuTuBeiZhu(value);
					}
					// ӡ������
					if ("yin_xiang_qi_ta".equals(name)) {
						j.setYinXiangQiTa(value);
					}

					// ����
					if ("chu_zhi".equals(name)) {
						if (value.equals("����������Թ��ܼ�⣬HRV��⣬�����A,B C������")) {
							j.setChuZhi(1);
						} else if (value.equals("���Լ�⣨�Թ��ܼ�⣬HRV���׷�����")) {
							j.setChuZhi(2);
						} else if (value.equals("ֲ���񾭹��ܼ�⣨HRV���׷�����")) {
							j.setChuZhi(3);
						}
					}

					if ("jia_pu_tu".equals(name)) {
						j.setJiaPuTu(value);
					}

				}
				// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
				else {
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					if (value.equals("")) {
						continue;
					}
					int aa = value.lastIndexOf(".");
					String ss = value.substring(aa);
					String filename = UUID.randomUUID().toString() + ss;
					j.setFangShuRen(filename);
					// request.setAttribute(name, filename);

					// ����д��������
					// ���׳����쳣 ��exception ��׽

					// item.write( new File(path,filename) );//�������ṩ��

					// �ֶ�д��
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					// System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());

					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
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
