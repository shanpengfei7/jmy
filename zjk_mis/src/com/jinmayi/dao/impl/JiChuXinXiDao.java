package com.jinmayi.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jinmayi.dao.BaseDao;
import com.jinmayi.domain.Page;
import com.jinmayi.domain.SearchContent;
import com.jinmayi.entity.JiChuXinXi;

public class JiChuXinXiDao extends BaseDao<JiChuXinXi> {

	public void guiDang(Integer id) {
		String sql = "update ji_chu_xin_xi set isGuiDang = ?, gdRiQi = ? where id = ?";
		update(sql, true, new Timestamp(new Date().getTime()), id);
	}

	public JiChuXinXi getLittleXinXiById(Integer id) {
		String sql = "select id, yongHuId, xingMing, xingBie, chuShengNian, chuShengYue, chuShengRi from ji_chu_xin_xi where id = ?";
		return query(sql, id);
	}

	public JiChuXinXi getIdByYongHuId(String yongHuId) {
		String sql = "select id, miMa from ji_chu_xin_xi where yongHuId = ? and isdelete = ? order by id desc";
		return query(sql, yongHuId, false);
	}

	public JiChuXinXi getMimaByidId(int yongHuId) {
		String sql = "select id, miMa from ji_chu_xin_xi where id = ? and isdelete = ?";
		return query(sql, yongHuId, false);
	}

	public JiChuXinXi getAllJiChuXinXiById(Integer id) {
		String sql = "select id, jiaPuTuBeiZhu, cePingShi, cePingShiId, jingShenKeYiShengId,keShiid,zhuanKeYiShengId,yiYuanId,"
				+ "yongHuId,riQi,menZhenHao,bingAnHao,zhuGuanYiShi,suoShuKeShi,zhuanKeYiSheng,"
				+ "xingMing,xingBie,chuShengNian,chuShengYue,chuShengRi,minZu,hunYinZhuangKuang,"
				+ "shenGao,tiZhong,chuShengDi,zhiYe,wenHuaChengDu,paiHang1,paiHang2,jingJiZhuangKuang,lianXiDiZhi,"
				+ "lianXiDianHua,jiuZhenYuanYin,shuiMian,shiYu,	chuXian1,chuXian2,"
				+ "jiWangLeiSiFaZuo,jiWangQuTiJiBing,jiWangJuTiJiBingZhenDuan,xianLeiSiFaZuo,"
				+ "xianQuTiJiBing,xianJuTiJiBingZhenDuan,jiaZuBingShi,jiaZuJuTiJiBingZhenDuan,"
				+ "geXingTeDian,QingXuWenDingXing,RenGeTeDian,XueXing,RenGeTeZhi,XingQu,"
				+ "yan,	jiu,yanJiuQiTa,shengZhangFaYu,xueBu,yuYan,yueJingChuChao,shouCiYiJing,"
				+ "tingJing,youNianFuYangRen,jiYangShi1,jiYangShi2,	youNianShengHuoHuanJing,xianZaiShengHuoHuanJIng,	"
				+ "xiongDiJieMeiGuanXi,fuQiGuanXi,poXiGuanXi,fuQinZhiYe,muQinZhiYe,fuQinWenHuaChengDu,	"
				+ "muQinWenHuaChengDu,zhongDaFuXingShiJian1,zhongDaFuXingShiJian2,yingJiShiJian1,yingJiShiJian2,"
				+ "	renJiGuanXi,wenTiBiaoXianWei,wenTiFaShengZai,shengHuoManYiYuFou,buManYiDeFangMian,	"
				+ "dangQianJiBingRenZhi,jiBingYuHouTaiDu,yingDuiFangShi,zhiLiaoCanYuChengDu,sheHuiZhiChi,	"
				+ "pengYou, qinZiGuanXi,jiaRen,	duiGeXiangZhiChiLiYongDu,xingShengHuo,wenTiFaShengQiTa,yinXiang,yinXiangQiTa,chuZhi,jiaPuTu,jiaPuTuBeiZhu,fangShuRen"
				+ " from ji_chu_xin_xi where id = ? and isdelete = ?";
		return query(sql, id, false);
	}

	public JiChuXinXi getJiChuXinXiById(Integer id) {
		String sql = "select id, yongHuId, riQi, menZhenHao, bingAnHao, zhuGuanYiShi, suoShuKeShi, zhuanKeYiSheng, xingMing, xingBie, chuShengNian,chuShengYue,chuShengRi,minZu,hunYinZhuangKuang,shenGao,tiZhong, chuShengDi, zhiYe, wenHuaChengDu, paiHang1,paiHang2,jingJiZhuangKuang,lianXiDiZhi,lianXiDianHua from ji_chu_xin_xi where id = ? and isdelete = ?";
		return query(sql, id, false);
	}

	public long save(JiChuXinXi j, HttpSession session) {

		Integer yiYuanId = Integer.parseInt(session.getAttribute("yiYuanId").toString());
		Integer keShiId = new KeShiDao().getKeShiByName(j.getSuoShuKeShi()).getId();
		Integer zkysId = new YiShengDao().getIdByNameYyId(j.getZhuanKeYiSheng(), yiYuanId);
		Integer jskysId = new YiShengDao().getIdByNameYyId(j.getZhuGuanYiShi(), yiYuanId);

		String sql = "insert into ji_chu_xin_xi(cePingShi, jiaPuTuBeiZhu, cePingShiId, jingShenKeYiShengId,keShiid,zhuankeyishengid,yiyuanid,"
				+ "yonghuid,riqi,menzhenhao,binganhao,zhuguanyishi,suoshukeshi,zhuankeyisheng,"
				+ "xingming,xingbie,chushengnian,chushengyue,chushengri,minzu,hunyinzhuangkuang,"
				+ "shengao,tizhong,chushengdi,zhiye,wenhuachengdu,paihang1,paihang2,jingjizhuangkuang,lianxidizhi,"
				+ "lianxidianhua,jiuZhenYuanYin,shuiMian,shiYu,	chuXian1,chuXian2,"
				+ "jiWangLeiSiFaZuo,jiWangQuTiJiBing,jiWangJuTiJiBingZhenDuan,xianLeiSiFaZuo,"
				+ "xianQuTiJiBing,xianJuTiJiBingZhenDuan,jiaZuBingShi,jiaZuJuTiJiBingZhenDuan,"
				+ "geXingTeDian,QingXuWenDingXing,RenGeTeDian,XueXing,RenGeTeZhi,XingQu,"
				+ "yan,	jiu,yanJiuQiTa,shengZhangFaYu,xueBu,yuYan,yueJingChuChao,shouCiYiJing,"
				+ "tingJing,youNianFuYangRen,jiYangShi1,jiYangShi2,	youNianShengHuoHuanJing,xianZaiShengHuoHuanJIng,	"
				+ "xiongDiJieMeiGuanXi,fuQiGuanXi,poXiGuanXi,fuQinZhiYe,muQinZhiYe,fuQinWenHuaChengDu,	"
				+ "muQinWenHuaChengDu,zhongDaFuXingShiJian1,zhongDaFuXingShiJian2,yingJiShiJian1,yingJiShiJian2,"
				+ "	renJiGuanXi,wenTiBiaoXianWei,wenTiFaShengZai,shengHuoManYiYuFou,buManYiDeFangMian,	"
				+ "dangQianJiBingRenZhi,jiBingYuHouTaiDu,yingDuiFangShi,zhiLiaoCanYuChengDu,sheHuiZhiChi,	"
				+ "pengYou,	jiaRen,	duiGeXiangZhiChiLiYongDu,xingShengHuo,wenTiFaShengQiTa,yinXiang,"
				+ "yinXiangQiTa,chuZhi,jiaPuTu,fangShuRen,qinZiGuanXi)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, session.getAttribute("cePingShi"), j.getJiaPuTuBeiZhu(), session.getAttribute("cePingShiId"),
				jskysId, keShiId, zkysId, yiYuanId, j.getYongHuId(), j.getRiQi(), j.getMenZhenHao(), j.getBingAnHao(),
				j.getZhuGuanYiShi(), j.getSuoShuKeShi(), j.getZhuanKeYiSheng(), j.getXingMing(), j.getXingBie(),
				j.getChuShengNian(), j.getChuShengYue(), j.getChuShengRi(), j.getMinZu(), j.getHunYinZhuangKuang(),
				j.getShenGao(), j.getTiZhong(), j.getChuShengDi(), j.getZhiYe(), j.getWenHuaChengDu(), j.getPaiHang1(),
				j.getPaiHang2(), j.getJingJiZhuangKuang(), j.getLianXiDiZhi(), j.getLianXiDianHua(),
				j.getJiuZhenYuanYin(), j.getShuiMian(), j.getShiYu(), j.getChuXian1(), j.getChuXian2(),
				j.getJiWangLeiSiFaZuo(), j.getJiWangQuTiJiBing(), j.getJiWangJuTiJiBingZhenDuan(),
				j.getXianLeiSiFaZuo(), j.getXianQuTiJiBing(), j.getXianJuTiJiBingZhenDuan(), j.getJiaZuBingShi(),
				j.getJiaZuJuTiJiBingZhenDuan(), j.getGeXingTeDian(), j.getQingXuWenDingXing(), j.getRenGeTeDian(),
				j.getXueXing(), j.getRenGeTeZhi(), j.getXingQu(), j.getYan(), j.getJiu(), j.getYanJiuQiTa(),
				j.getShengZhangFaYu(), j.getXueBu(), j.getYuYan(), j.getYueJingChuChao(), j.getShouCiYiJing(),
				j.getTingJing(), j.getYouNianFuYangRen(), j.getJiYangShi1(), j.getJiYangShi2(),
				j.getYouNianShengHuoHuanJing(), j.getXianZaiShengHuoHuanJing(), j.getXiongDiJieMeiGuanXi(),
				j.getFuQiGuanXi(), j.getPoXiGuanXi(), j.getFuQinZhiYe(), j.getMuQinZhiYe(), j.getFuQinWenHuaChengDu(),
				j.getMuQinWenHuaChengDu(), j.getZhongDaFuXingShiJian1(), j.getZhongDaFuXingShiJian2(),
				j.getYingJiShiJian1(), j.getYingJiShiJian2(), j.getRenJiGuanXi(), j.getWenTiBiaoXianWei(),
				j.getWenTiFaShengZai(), j.getShengHuoManYiYuFou(), j.getBuManYiDeFangMian(),
				j.getDangQianJiBingRenZhi(), j.getJiBingYuHouTaiDu(), j.getYingDuiFangShi(), j.getZhiLiaoCanYuChengDu(),
				j.getSheHuiZhiChi(), j.getPengYou(), j.getJiaRen(), j.getDuiGeXiangZhiChiLiYongDu(),
				j.getXingShengHuo(), j.getWenTiFaShengQiTa(), j.getYinXiang(), j.getYinXiangQiTa(), j.getChuZhi(),
				j.getJiaPuTu(), j.getFangShuRen(), j.getQinZiGuanXi());
	}

	public Page<JiChuXinXi> getPages(long pageNow, SearchContent s, HttpSession session) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCountss(session, s));
		page.setList(getJiChuXinXiss(page, s, session));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXiss(Page<JiChuXinXi> page, SearchContent s, HttpSession session) {
		String sql = "select id, isGuiDang, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi "
				+ "where isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, false, s.getName(), s.getTime1(), s.getTime2(),
				(page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCountss(HttpSession session, SearchContent s) {
		String sql = "select count(id) from ji_chu_xin_xi where isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, false, s.getName(), s.getTime1(), s.getTime2());
	}

	public Page<JiChuXinXi> getPageByJingShenKeYiSheng(long pageNow, SearchContent s, HttpSession session) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCountByJingShenKeYiSheng(session, s));
		page.setList(getJiChuXinXisByJingShenKeYiSheng(page, s, session));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXisByJingShenKeYiSheng(Page<JiChuXinXi> page, SearchContent s,
			HttpSession session) {
		String sql = "select id, isGuiDang, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi "
				+ "where yiYuanId = ? and jingShenKeYiShengId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, session.getAttribute("yiYuanId"),
				session.getAttribute("yiShengId"), false, s.getName(), s.getTime1(), s.getTime2(),
				(page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCountByJingShenKeYiSheng(HttpSession session, SearchContent s) {
		String sql = "select count(id) from ji_chu_xin_xi where yiYuanId = ? and jingShenKeYiShengId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), session.getAttribute("yiShengId"), false,
				s.getName(), s.getTime1(), s.getTime2());
	}

	public Page<JiChuXinXi> getPageByZhuanKeYiSheng(long pageNow, SearchContent s, HttpSession session) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCountByZhuanKeYiSheng(session, s));
		page.setList(getJiChuXinXisByZhuanKeYiSheng(page, s, session));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXisByZhuanKeYiSheng(Page<JiChuXinXi> page, SearchContent s,
			HttpSession session) {
		String sql = "select id, isGuiDang, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi "
				+ "where yiYuanId = ? and zhuanKeYiShengId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, session.getAttribute("yiYuanId"),
				session.getAttribute("yiShengId"), false, s.getName(), s.getTime1(), s.getTime2(),
				(page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCountByZhuanKeYiSheng(HttpSession session, SearchContent s) {
		String sql = "select count(id) from ji_chu_xin_xi where yiYuanId = ? and zhuanKeYiShengId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), session.getAttribute("yiShengId"), false,
				s.getName(), s.getTime1(), s.getTime2());
	}

	public Page<JiChuXinXi> getPageByKeShi(long pageNow, SearchContent s, HttpSession session) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCountByKeShi(session, s));
		page.setList(getJiChuXinXisByKeShi(page, s, session));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXisByKeShi(Page<JiChuXinXi> page, SearchContent s, HttpSession session) {
		String sql = "select id, isGuiDang, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi "
				+ "where yiYuanId = ? and KeShiId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, session.getAttribute("yiYuanId"),
				session.getAttribute("keshiId"), false, s.getName(), s.getTime1(), s.getTime2(),
				(page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCountByKeShi(HttpSession session, SearchContent s) {
		String sql = "select count(id) from ji_chu_xin_xi where yiYuanId = ? and KeShiId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), session.getAttribute("keshiId"), false, s.getName(),
				s.getTime1(), s.getTime2());
	}

	public Page<JiChuXinXi> getPage(long pageNow, SearchContent s, HttpSession session) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCount(session, s));
		page.setList(getJiChuXinXis(page, s, session));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXis(Page<JiChuXinXi> page, SearchContent s, HttpSession session) {
		String sql = "select id, isGuiDang, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, session.getAttribute("yiYuanId"), false, s.getName(),
				s.getTime1(), s.getTime2(), (page.getpageNow() - 1) * page.getPageSize(), page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCount(HttpSession session, SearchContent s) {
		String sql = "select count(id) from ji_chu_xin_xi where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2());
	}

	public Page<JiChuXinXi> getPage(long pageNow, SearchContent s, HttpSession session, Boolean isGuiDang) {
		Page<JiChuXinXi> page = new Page<JiChuXinXi>(pageNow);
		page.setTotalItemNumber(getJiChuXinXiCount(session, s, isGuiDang));
		page.setList(getJiChuXinXis(page, s, session, isGuiDang));
		return page;
	}

	private List<JiChuXinXi> getJiChuXinXis(Page<JiChuXinXi> page, SearchContent s, HttpSession session,
			Boolean isGuiDang) {
		String sql = "select id, gdRiQi, yongHuId, xingMing, xingBie,chuShengNian, chuShengYue, chuShengRi, zhuGuanYiShi, cePingshi,zhuanKeYiSheng,riQi,lianXiDianHua,lianXiDiZhi from ji_chu_xin_xi where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ? ORDER BY id desc limit ?,?";
		List<JiChuXinXi> jiChuXinXis = queryForList(sql, session.getAttribute("yiYuanId"), false, s.getName(),
				s.getTime1(), s.getTime2(), isGuiDang, (page.getpageNow() - 1) * page.getPageSize(),
				page.getPageSize());
		return jiChuXinXis;
	}

	private Long getJiChuXinXiCount(HttpSession session, SearchContent s, Boolean isGuiDang) {
		String sql = "select count(id) from ji_chu_xin_xi where yiYuanId = ? and isdelete = ? and xingMing like concat('%',?,'%') and riQi between ? and ? and isGuiDang = ?";
		return getSingleVal(sql, session.getAttribute("yiYuanId"), false, s.getName(), s.getTime1(), s.getTime2(),
				isGuiDang);
	}

	public void change(JiChuXinXi j, HttpSession session) {
		Integer yiYuanId = Integer.parseInt(session.getAttribute("yiYuanId").toString());
		Integer keShiId = new KeShiDao().getKeShiByName(j.getSuoShuKeShi()).getId();
		Integer zkysId = new YiShengDao().getIdByNameYyId(j.getZhuanKeYiSheng(), yiYuanId);
		Integer jskysId = new YiShengDao().getIdByNameYyId(j.getZhuGuanYiShi(), yiYuanId);

		String sql = "update ji_chu_xin_xi set cePingShi = ?, jiaPuTuBeiZhu = ?, cePingShiId = ?, jingShenKeYiShengId = ?,keShiid = ?,zhuankeyishengid = ?,yiyuanid = ?,"
				+ "menzhenhao = ?,binganhao = ?,zhuguanyishi = ?,suoshukeshi = ?,zhuankeyisheng = ?,"
				+ "xingming = ?,xingbie = ?,chushengnian = ?,chushengyue = ?,chushengri = ?,minzu = ?,hunyinzhuangkuang = ?,"
				+ "shengao = ?,tizhong = ?,chushengdi = ?,zhiye = ?,wenhuachengdu = ?,paihang1 = ?,paihang2 = ?,jingjizhuangkuang = ?,lianxidizhi = ?,"
				+ "lianxidianhua = ?,jiuZhenYuanYin = ?,shuiMian = ?,shiYu = ?,	chuXian1 = ?,chuXian2 = ?,"
				+ "jiWangLeiSiFaZuo = ?,jiWangQuTiJiBing = ?,jiWangJuTiJiBingZhenDuan = ?,xianLeiSiFaZuo = ?,"
				+ "xianQuTiJiBing = ?,xianJuTiJiBingZhenDuan = ?,jiaZuBingShi = ?,jiaZuJuTiJiBingZhenDuan = ?,"
				+ "geXingTeDian = ?,QingXuWenDingXing = ?,RenGeTeDian = ?,XueXing = ?,RenGeTeZhi = ?,XingQu = ?,"
				+ "yan = ?,	jiu = ?,yanJiuQiTa = ?,shengZhangFaYu = ?,xueBu = ?,yuYan = ?,yueJingChuChao = ?,shouCiYiJing = ?,"
				+ "tingJing = ?,youNianFuYangRen = ?,jiYangShi1 = ?,jiYangShi2 = ?,	youNianShengHuoHuanJing = ?,xianZaiShengHuoHuanJIng = ?,	"
				+ "xiongDiJieMeiGuanXi = ?,fuQiGuanXi = ?,poXiGuanXi = ?,fuQinZhiYe = ?,muQinZhiYe = ?,fuQinWenHuaChengDu = ?,	"
				+ "muQinWenHuaChengDu = ?,zhongDaFuXingShiJian1 = ?,zhongDaFuXingShiJian2 = ?,yingJiShiJian1 = ?,yingJiShiJian2 = ?,"
				+ "	renJiGuanXi = ?,wenTiBiaoXianWei = ?,wenTiFaShengZai = ?,shengHuoManYiYuFou = ?,buManYiDeFangMian = ?,"
				+ "dangQianJiBingRenZhi = ?,jiBingYuHouTaiDu = ?,yingDuiFangShi = ?,zhiLiaoCanYuChengDu = ?,sheHuiZhiChi = ?,"
				+ "pengYou = ?,	jiaRen = ?,	duiGeXiangZhiChiLiYongDu = ?,xingShengHuo = ?,wenTiFaShengQiTa = ?,yinXiang = ?,"
				+ "yinXiangQiTa = ?,chuZhi = ?,jiaPuTu = ?,fangShuRen = ?, qinZiGuanXi = ? where id = ?";

		update(sql, session.getAttribute("cePingShi"), j.getJiaPuTuBeiZhu(), session.getAttribute("cePingShiId"),
				jskysId, keShiId, zkysId, yiYuanId, j.getMenZhenHao(), j.getBingAnHao(), j.getZhuGuanYiShi(),
				j.getSuoShuKeShi(), j.getZhuanKeYiSheng(), j.getXingMing(), j.getXingBie(), j.getChuShengNian(),
				j.getChuShengYue(), j.getChuShengRi(), j.getMinZu(), j.getHunYinZhuangKuang(), j.getShenGao(),
				j.getTiZhong(), j.getChuShengDi(), j.getZhiYe(), j.getWenHuaChengDu(), j.getPaiHang1(), j.getPaiHang2(),
				j.getJingJiZhuangKuang(), j.getLianXiDiZhi(), j.getLianXiDianHua(), j.getJiuZhenYuanYin(),
				j.getShuiMian(), j.getShiYu(), j.getChuXian1(), j.getChuXian2(), j.getJiWangLeiSiFaZuo(),
				j.getJiWangQuTiJiBing(), j.getJiWangJuTiJiBingZhenDuan(), j.getXianLeiSiFaZuo(), j.getXianQuTiJiBing(),
				j.getXianJuTiJiBingZhenDuan(), j.getJiaZuBingShi(), j.getJiaZuJuTiJiBingZhenDuan(), j.getGeXingTeDian(),
				j.getQingXuWenDingXing(), j.getRenGeTeDian(), j.getXueXing(), j.getRenGeTeZhi(), j.getXingQu(),
				j.getYan(), j.getJiu(), j.getYanJiuQiTa(), j.getShengZhangFaYu(), j.getXueBu(), j.getYuYan(),
				j.getYueJingChuChao(), j.getShouCiYiJing(), j.getTingJing(), j.getYouNianFuYangRen(), j.getJiYangShi1(),
				j.getJiYangShi2(), j.getYouNianShengHuoHuanJing(), j.getXianZaiShengHuoHuanJing(),
				j.getXiongDiJieMeiGuanXi(), j.getFuQiGuanXi(), j.getPoXiGuanXi(), j.getFuQinZhiYe(), j.getMuQinZhiYe(),
				j.getFuQinWenHuaChengDu(), j.getMuQinWenHuaChengDu(), j.getZhongDaFuXingShiJian1(),
				j.getZhongDaFuXingShiJian2(), j.getYingJiShiJian1(), j.getYingJiShiJian2(), j.getRenJiGuanXi(),
				j.getWenTiBiaoXianWei(), j.getWenTiFaShengZai(), j.getShengHuoManYiYuFou(), j.getBuManYiDeFangMian(),
				j.getDangQianJiBingRenZhi(), j.getJiBingYuHouTaiDu(), j.getYingDuiFangShi(), j.getZhiLiaoCanYuChengDu(),
				j.getSheHuiZhiChi(), j.getPengYou(), j.getJiaRen(), j.getDuiGeXiangZhiChiLiYongDu(),
				j.getXingShengHuo(), j.getWenTiFaShengQiTa(), j.getYinXiang(), j.getYinXiangQiTa(), j.getChuZhi(),
				j.getJiaPuTu(), j.getFangShuRen(), j.getQinZiGuanXi(), j.getId());

	}
	
	public List<JiChuXinXi> hrv(int yyid) {
		String sql = "select id, xingMing,  xingBie, chuShengNian, chuShengYue, chuShengRi, riQi, yongHuId, menZhenHao, bingAnHao from ji_chu_xin_xi where yiYuanId = ?";
        return queryForList(sql, yyid);
	}
	public JiChuXinXi one(int jcxxid) {
		 String sql = "select yongHuId,xingMing,  xingBie, chuShengNian, chuShengYue, chuShengRi, shenGao, tiZhong,  menZhenHao, bingAnHao, lianXiDianHua, lianXiDiZhi, zhuGuanYiShi, jingShenKeYiShengId from ji_chu_xin_xi where id = ?";
		return query(sql, jcxxid);
	}

}
