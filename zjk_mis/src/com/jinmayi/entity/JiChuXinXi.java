package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * JiChuXinXi entity. @author MyEclipse Persistence Tools
 */

public class JiChuXinXi implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private String yongHuId;
	private Timestamp riQi;
	private String menZhenHao;
	private String bingAnHao;
	private String zhuGuanYiShi;
	private String suoShuKeShi;
	private String zhuanKeYiSheng;
	private String xingMing;
	private Integer xingBie;
	private Integer chuShengNian;
	private Integer chuShengYue;
	private Integer chuShengRi;
	private String minZu;
	private String hunYinZhuangKuang;
	private Integer shenGao;
	private Integer tiZhong;
	private String chuShengDi;
	private String zhiYe;
	private String wenHuaChengDu;
	private Integer paiHang1;
	private Integer paiHang2;
	private Integer jingJiZhuangKuang;
	private String lianXiDiZhi;
	private String lianXiDianHua;
	private String jiuZhenYuanYin;
	private String shuiMian;
	private Integer shiYu;
	private String chuXian1;
	private String chuXian2;
	private Integer jiWangLeiSiFaZuo;
	private Integer jiWangQuTiJiBing;
	private String jiWangJuTiJiBingZhenDuan;
	private Integer xianLeiSiFaZuo;
	private Integer xianQuTiJiBing;
	private String xianJuTiJiBingZhenDuan;
	private Integer jiaZuBingShi;
	private String jiaZuJuTiJiBingZhenDuan;
	private Integer geXingTeDian;
	private Integer qingXuWenDingXing;
	private Integer renGeTeDian;
	private Integer xueXing;
	private String renGeTeZhi;
	private String xingQu;
	private Integer yan;
	private Integer jiu;
	private String yanJiuQiTa;
	private String shengZhangFaYu;
	private Integer xueBu;
	private Integer yuYan;
	private Integer yueJingChuChao;
	private Integer shouCiYiJing;
	private Integer tingJing;
	private String youNianFuYangRen;
	private Integer jiYangShi1;
	private Integer jiYangShi2;
	private String youNianShengHuoHuanJing;
	private String xianZaiShengHuoHuanJing;
	private Integer xiongDiJieMeiGuanXi;
	private Integer fuQiGuanXi;
	private Integer poXiGuanXi;
	private String fuQinZhiYe;
	private String muQinZhiYe;
	private String fuQinWenHuaChengDu;
	private String muQinWenHuaChengDu;
	private Integer zhongDaFuXingShiJian1;
	private String zhongDaFuXingShiJian2;
	private Integer yingJiShiJian1;
	private String yingJiShiJian2;
	private Integer renJiGuanXi;
	private String wenTiBiaoXianWei;
	private String wenTiFaShengZai;
	private Integer shengHuoManYiYuFou;
	private String buManYiDeFangMian;
	private Integer dangQianJiBingRenZhi;
	private Integer jiBingYuHouTaiDu;
	private Integer yingDuiFangShi;
	private Integer zhiLiaoCanYuChengDu;
	private Integer sheHuiZhiChi;
	private Integer pengYou;
	private Integer jiaRen;
	private Integer duiGeXiangZhiChiLiYongDu;
	private Integer xingShengHuo;
	private String wenTiFaShengQiTa;
	private Integer yinXiang;
	private String yinXiangQiTa;
	private Integer chuZhi;
	private String jiaPuTu;
	private String fangShuRen;
	private String miMa;
	private Integer keShiId;
	private Integer zhuanKeYiShengId;
	private Integer jingShenKeYiShengId;
	private Integer yiYuanId;
	private String cePingShi;
	private Integer cePingShiId;
	private Boolean isGuiDang;
	private Timestamp gdRiQi;
	private String jiaPuTuBeiZhu;
	private Integer qinZiGuanXi;

	// Constructors

	/** default constructor */
	public JiChuXinXi() {
	}

	/** minimal constructor */
	public JiChuXinXi(Integer id, Boolean isDelete, String yongHuId,
			Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.yongHuId = yongHuId;
		this.riQi = riQi;
	}

	/** full constructor */
	public JiChuXinXi(Integer id, Boolean isDelete, String yongHuId,
			Timestamp riQi, String menZhenHao, String bingAnHao,
			String zhuGuanYiShi, String suoShuKeShi, String zhuanKeYiSheng,
			String xingMing, Integer xingBie, Integer chuShengNian,
			Integer chuShengYue, Integer chuShengRi, String minZu,
			String hunYinZhuangKuang, Integer shenGao, Integer tiZhong,
			String chuShengDi, String zhiYe, String wenHuaChengDu,
			Integer paiHang1, Integer paiHang2, Integer jingJiZhuangKuang,
			String lianXiDiZhi, String lianXiDianHua, String jiuZhenYuanYin,
			String shuiMian, Integer shiYu, String chuXian1, String chuXian2,
			Integer jiWangLeiSiFaZuo, Integer jiWangQuTiJiBing,
			String jiWangJuTiJiBingZhenDuan, Integer xianLeiSiFaZuo,
			Integer xianQuTiJiBing, String xianJuTiJiBingZhenDuan,
			Integer jiaZuBingShi, String jiaZuJuTiJiBingZhenDuan,
			Integer geXingTeDian, Integer qingXuWenDingXing,
			Integer renGeTeDian, Integer xueXing, String renGeTeZhi,
			String xingQu, Integer yan, Integer jiu, String yanJiuQiTa,
			String shengZhangFaYu, Integer xueBu, Integer yuYan,
			Integer yueJingChuChao, Integer shouCiYiJing, Integer tingJing,
			String youNianFuYangRen, Integer jiYangShi1, Integer jiYangShi2,
			String youNianShengHuoHuanJing, String xianZaiShengHuoHuanJing,
			Integer xiongDiJieMeiGuanXi, Integer fuQiGuanXi,
			Integer poXiGuanXi, String fuQinZhiYe, String muQinZhiYe,
			String fuQinWenHuaChengDu, String muQinWenHuaChengDu,
			Integer zhongDaFuXingShiJian1, String zhongDaFuXingShiJian2,
			Integer yingJiShiJian1, String yingJiShiJian2, Integer renJiGuanXi,
			String wenTiBiaoXianWei, String wenTiFaShengZai,
			Integer shengHuoManYiYuFou, String buManYiDeFangMian,
			Integer dangQianJiBingRenZhi, Integer jiBingYuHouTaiDu,
			Integer yingDuiFangShi, Integer zhiLiaoCanYuChengDu,
			Integer sheHuiZhiChi, Integer pengYou, Integer jiaRen,
			Integer duiGeXiangZhiChiLiYongDu, Integer xingShengHuo,
			String wenTiFaShengQiTa, Integer yinXiang, String yinXiangQiTa,
			Integer chuZhi, String jiaPuTu, String fangShuRen, String miMa,
			Integer keShiId, Integer zhuanKeYiShengId,
			Integer jingShenKeYiShengId, Integer yiYuanId, String cePingShi,
			Integer cePingShiId, Boolean isGuiDang, Timestamp gdRiQi,
			String jiaPuTuBeiZhu) {
		this.id = id;
		this.isDelete = isDelete;
		this.yongHuId = yongHuId;
		this.riQi = riQi;
		this.menZhenHao = menZhenHao;
		this.bingAnHao = bingAnHao;
		this.zhuGuanYiShi = zhuGuanYiShi;
		this.suoShuKeShi = suoShuKeShi;
		this.zhuanKeYiSheng = zhuanKeYiSheng;
		this.xingMing = xingMing;
		this.xingBie = xingBie;
		this.chuShengNian = chuShengNian;
		this.chuShengYue = chuShengYue;
		this.chuShengRi = chuShengRi;
		this.minZu = minZu;
		this.hunYinZhuangKuang = hunYinZhuangKuang;
		this.shenGao = shenGao;
		this.tiZhong = tiZhong;
		this.chuShengDi = chuShengDi;
		this.zhiYe = zhiYe;
		this.wenHuaChengDu = wenHuaChengDu;
		this.paiHang1 = paiHang1;
		this.paiHang2 = paiHang2;
		this.jingJiZhuangKuang = jingJiZhuangKuang;
		this.lianXiDiZhi = lianXiDiZhi;
		this.lianXiDianHua = lianXiDianHua;
		this.jiuZhenYuanYin = jiuZhenYuanYin;
		this.shuiMian = shuiMian;
		this.shiYu = shiYu;
		this.chuXian1 = chuXian1;
		this.chuXian2 = chuXian2;
		this.jiWangLeiSiFaZuo = jiWangLeiSiFaZuo;
		this.jiWangQuTiJiBing = jiWangQuTiJiBing;
		this.jiWangJuTiJiBingZhenDuan = jiWangJuTiJiBingZhenDuan;
		this.xianLeiSiFaZuo = xianLeiSiFaZuo;
		this.xianQuTiJiBing = xianQuTiJiBing;
		this.xianJuTiJiBingZhenDuan = xianJuTiJiBingZhenDuan;
		this.jiaZuBingShi = jiaZuBingShi;
		this.jiaZuJuTiJiBingZhenDuan = jiaZuJuTiJiBingZhenDuan;
		this.geXingTeDian = geXingTeDian;
		this.qingXuWenDingXing = qingXuWenDingXing;
		this.renGeTeDian = renGeTeDian;
		this.xueXing = xueXing;
		this.renGeTeZhi = renGeTeZhi;
		this.xingQu = xingQu;
		this.yan = yan;
		this.jiu = jiu;
		this.yanJiuQiTa = yanJiuQiTa;
		this.shengZhangFaYu = shengZhangFaYu;
		this.xueBu = xueBu;
		this.yuYan = yuYan;
		this.yueJingChuChao = yueJingChuChao;
		this.shouCiYiJing = shouCiYiJing;
		this.tingJing = tingJing;
		this.youNianFuYangRen = youNianFuYangRen;
		this.jiYangShi1 = jiYangShi1;
		this.jiYangShi2 = jiYangShi2;
		this.youNianShengHuoHuanJing = youNianShengHuoHuanJing;
		this.xianZaiShengHuoHuanJing = xianZaiShengHuoHuanJing;
		this.xiongDiJieMeiGuanXi = xiongDiJieMeiGuanXi;
		this.fuQiGuanXi = fuQiGuanXi;
		this.poXiGuanXi = poXiGuanXi;
		this.fuQinZhiYe = fuQinZhiYe;
		this.muQinZhiYe = muQinZhiYe;
		this.fuQinWenHuaChengDu = fuQinWenHuaChengDu;
		this.muQinWenHuaChengDu = muQinWenHuaChengDu;
		this.zhongDaFuXingShiJian1 = zhongDaFuXingShiJian1;
		this.zhongDaFuXingShiJian2 = zhongDaFuXingShiJian2;
		this.yingJiShiJian1 = yingJiShiJian1;
		this.yingJiShiJian2 = yingJiShiJian2;
		this.renJiGuanXi = renJiGuanXi;
		this.wenTiBiaoXianWei = wenTiBiaoXianWei;
		this.wenTiFaShengZai = wenTiFaShengZai;
		this.shengHuoManYiYuFou = shengHuoManYiYuFou;
		this.buManYiDeFangMian = buManYiDeFangMian;
		this.dangQianJiBingRenZhi = dangQianJiBingRenZhi;
		this.jiBingYuHouTaiDu = jiBingYuHouTaiDu;
		this.yingDuiFangShi = yingDuiFangShi;
		this.zhiLiaoCanYuChengDu = zhiLiaoCanYuChengDu;
		this.sheHuiZhiChi = sheHuiZhiChi;
		this.pengYou = pengYou;
		this.jiaRen = jiaRen;
		this.duiGeXiangZhiChiLiYongDu = duiGeXiangZhiChiLiYongDu;
		this.xingShengHuo = xingShengHuo;
		this.wenTiFaShengQiTa = wenTiFaShengQiTa;
		this.yinXiang = yinXiang;
		this.yinXiangQiTa = yinXiangQiTa;
		this.chuZhi = chuZhi;
		this.jiaPuTu = jiaPuTu;
		this.fangShuRen = fangShuRen;
		this.miMa = miMa;
		this.keShiId = keShiId;
		this.zhuanKeYiShengId = zhuanKeYiShengId;
		this.jingShenKeYiShengId = jingShenKeYiShengId;
		this.yiYuanId = yiYuanId;
		this.cePingShi = cePingShi;
		this.cePingShiId = cePingShiId;
		this.isGuiDang = isGuiDang;
		this.gdRiQi = gdRiQi;
		this.jiaPuTuBeiZhu = jiaPuTuBeiZhu;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getYongHuId() {
		return this.yongHuId;
	}

	public void setYongHuId(String yongHuId) {
		this.yongHuId = yongHuId;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

	public String getMenZhenHao() {
		return this.menZhenHao;
	}

	public void setMenZhenHao(String menZhenHao) {
		this.menZhenHao = menZhenHao;
	}

	public String getBingAnHao() {
		return this.bingAnHao;
	}

	public void setBingAnHao(String bingAnHao) {
		this.bingAnHao = bingAnHao;
	}

	public String getZhuGuanYiShi() {
		return this.zhuGuanYiShi;
	}

	public void setZhuGuanYiShi(String zhuGuanYiShi) {
		this.zhuGuanYiShi = zhuGuanYiShi;
	}

	public String getSuoShuKeShi() {
		return this.suoShuKeShi;
	}

	public void setSuoShuKeShi(String suoShuKeShi) {
		this.suoShuKeShi = suoShuKeShi;
	}

	public String getZhuanKeYiSheng() {
		return this.zhuanKeYiSheng;
	}

	public void setZhuanKeYiSheng(String zhuanKeYiSheng) {
		this.zhuanKeYiSheng = zhuanKeYiSheng;
	}

	public String getXingMing() {
		return this.xingMing;
	}

	public void setXingMing(String xingMing) {
		this.xingMing = xingMing;
	}

	public Integer getXingBie() {
		return this.xingBie;
	}

	public void setXingBie(Integer xingBie) {
		this.xingBie = xingBie;
	}

	public Integer getChuShengNian() {
		return this.chuShengNian;
	}

	public void setChuShengNian(Integer chuShengNian) {
		this.chuShengNian = chuShengNian;
	}

	public Integer getChuShengYue() {
		return this.chuShengYue;
	}

	public void setChuShengYue(Integer chuShengYue) {
		this.chuShengYue = chuShengYue;
	}

	public Integer getChuShengRi() {
		return this.chuShengRi;
	}

	public void setChuShengRi(Integer chuShengRi) {
		this.chuShengRi = chuShengRi;
	}

	public String getMinZu() {
		return this.minZu;
	}

	public void setMinZu(String minZu) {
		this.minZu = minZu;
	}

	public String getHunYinZhuangKuang() {
		return this.hunYinZhuangKuang;
	}

	public void setHunYinZhuangKuang(String hunYinZhuangKuang) {
		this.hunYinZhuangKuang = hunYinZhuangKuang;
	}

	public Integer getShenGao() {
		return this.shenGao;
	}

	public void setShenGao(Integer shenGao) {
		this.shenGao = shenGao;
	}

	public Integer getTiZhong() {
		return this.tiZhong;
	}

	public void setTiZhong(Integer tiZhong) {
		this.tiZhong = tiZhong;
	}

	public String getChuShengDi() {
		return this.chuShengDi;
	}

	public void setChuShengDi(String chuShengDi) {
		this.chuShengDi = chuShengDi;
	}

	public String getZhiYe() {
		return this.zhiYe;
	}

	public void setZhiYe(String zhiYe) {
		this.zhiYe = zhiYe;
	}

	public String getWenHuaChengDu() {
		return this.wenHuaChengDu;
	}

	public void setWenHuaChengDu(String wenHuaChengDu) {
		this.wenHuaChengDu = wenHuaChengDu;
	}

	public Integer getPaiHang1() {
		return this.paiHang1;
	}

	public void setPaiHang1(Integer paiHang1) {
		this.paiHang1 = paiHang1;
	}

	public Integer getPaiHang2() {
		return this.paiHang2;
	}

	public void setPaiHang2(Integer paiHang2) {
		this.paiHang2 = paiHang2;
	}

	public Integer getJingJiZhuangKuang() {
		return this.jingJiZhuangKuang;
	}

	public void setJingJiZhuangKuang(Integer jingJiZhuangKuang) {
		this.jingJiZhuangKuang = jingJiZhuangKuang;
	}

	public String getLianXiDiZhi() {
		return this.lianXiDiZhi;
	}

	public void setLianXiDiZhi(String lianXiDiZhi) {
		this.lianXiDiZhi = lianXiDiZhi;
	}

	public String getLianXiDianHua() {
		return this.lianXiDianHua;
	}

	public void setLianXiDianHua(String lianXiDianHua) {
		this.lianXiDianHua = lianXiDianHua;
	}

	public String getJiuZhenYuanYin() {
		return this.jiuZhenYuanYin;
	}

	public void setJiuZhenYuanYin(String jiuZhenYuanYin) {
		this.jiuZhenYuanYin = jiuZhenYuanYin;
	}

	public String getShuiMian() {
		return this.shuiMian;
	}

	public void setShuiMian(String shuiMian) {
		this.shuiMian = shuiMian;
	}

	public Integer getShiYu() {
		return this.shiYu;
	}

	public void setShiYu(Integer shiYu) {
		this.shiYu = shiYu;
	}

	public String getChuXian1() {
		return this.chuXian1;
	}

	public void setChuXian1(String chuXian1) {
		this.chuXian1 = chuXian1;
	}

	public String getChuXian2() {
		return this.chuXian2;
	}

	public void setChuXian2(String chuXian2) {
		this.chuXian2 = chuXian2;
	}

	public Integer getJiWangLeiSiFaZuo() {
		return this.jiWangLeiSiFaZuo;
	}

	public void setJiWangLeiSiFaZuo(Integer jiWangLeiSiFaZuo) {
		this.jiWangLeiSiFaZuo = jiWangLeiSiFaZuo;
	}

	public Integer getJiWangQuTiJiBing() {
		return this.jiWangQuTiJiBing;
	}

	public void setJiWangQuTiJiBing(Integer jiWangQuTiJiBing) {
		this.jiWangQuTiJiBing = jiWangQuTiJiBing;
	}

	public String getJiWangJuTiJiBingZhenDuan() {
		return this.jiWangJuTiJiBingZhenDuan;
	}

	public void setJiWangJuTiJiBingZhenDuan(String jiWangJuTiJiBingZhenDuan) {
		this.jiWangJuTiJiBingZhenDuan = jiWangJuTiJiBingZhenDuan;
	}

	public Integer getXianLeiSiFaZuo() {
		return this.xianLeiSiFaZuo;
	}

	public void setXianLeiSiFaZuo(Integer xianLeiSiFaZuo) {
		this.xianLeiSiFaZuo = xianLeiSiFaZuo;
	}

	public Integer getXianQuTiJiBing() {
		return this.xianQuTiJiBing;
	}

	public void setXianQuTiJiBing(Integer xianQuTiJiBing) {
		this.xianQuTiJiBing = xianQuTiJiBing;
	}

	public String getXianJuTiJiBingZhenDuan() {
		return this.xianJuTiJiBingZhenDuan;
	}

	public void setXianJuTiJiBingZhenDuan(String xianJuTiJiBingZhenDuan) {
		this.xianJuTiJiBingZhenDuan = xianJuTiJiBingZhenDuan;
	}

	public Integer getJiaZuBingShi() {
		return this.jiaZuBingShi;
	}

	public void setJiaZuBingShi(Integer jiaZuBingShi) {
		this.jiaZuBingShi = jiaZuBingShi;
	}

	public String getJiaZuJuTiJiBingZhenDuan() {
		return this.jiaZuJuTiJiBingZhenDuan;
	}

	public void setJiaZuJuTiJiBingZhenDuan(String jiaZuJuTiJiBingZhenDuan) {
		this.jiaZuJuTiJiBingZhenDuan = jiaZuJuTiJiBingZhenDuan;
	}

	public Integer getGeXingTeDian() {
		return this.geXingTeDian;
	}

	public void setGeXingTeDian(Integer geXingTeDian) {
		this.geXingTeDian = geXingTeDian;
	}

	public Integer getQingXuWenDingXing() {
		return this.qingXuWenDingXing;
	}

	public void setQingXuWenDingXing(Integer qingXuWenDingXing) {
		this.qingXuWenDingXing = qingXuWenDingXing;
	}

	public Integer getRenGeTeDian() {
		return this.renGeTeDian;
	}

	public void setRenGeTeDian(Integer renGeTeDian) {
		this.renGeTeDian = renGeTeDian;
	}

	public Integer getXueXing() {
		return this.xueXing;
	}

	public void setXueXing(Integer xueXing) {
		this.xueXing = xueXing;
	}

	public String getRenGeTeZhi() {
		return this.renGeTeZhi;
	}

	public void setRenGeTeZhi(String renGeTeZhi) {
		this.renGeTeZhi = renGeTeZhi;
	}

	public String getXingQu() {
		return this.xingQu;
	}

	public void setXingQu(String xingQu) {
		this.xingQu = xingQu;
	}

	public Integer getYan() {
		return this.yan;
	}

	public void setYan(Integer yan) {
		this.yan = yan;
	}

	public Integer getJiu() {
		return this.jiu;
	}

	public void setJiu(Integer jiu) {
		this.jiu = jiu;
	}

	public String getYanJiuQiTa() {
		return this.yanJiuQiTa;
	}

	public void setYanJiuQiTa(String yanJiuQiTa) {
		this.yanJiuQiTa = yanJiuQiTa;
	}

	public String getShengZhangFaYu() {
		return this.shengZhangFaYu;
	}

	public void setShengZhangFaYu(String shengZhangFaYu) {
		this.shengZhangFaYu = shengZhangFaYu;
	}

	public Integer getXueBu() {
		return this.xueBu;
	}

	public void setXueBu(Integer xueBu) {
		this.xueBu = xueBu;
	}

	public Integer getYuYan() {
		return this.yuYan;
	}

	public void setYuYan(Integer yuYan) {
		this.yuYan = yuYan;
	}

	public Integer getYueJingChuChao() {
		return this.yueJingChuChao;
	}

	public void setYueJingChuChao(Integer yueJingChuChao) {
		this.yueJingChuChao = yueJingChuChao;
	}

	public Integer getShouCiYiJing() {
		return this.shouCiYiJing;
	}

	public void setShouCiYiJing(Integer shouCiYiJing) {
		this.shouCiYiJing = shouCiYiJing;
	}

	public Integer getTingJing() {
		return this.tingJing;
	}

	public void setTingJing(Integer tingJing) {
		this.tingJing = tingJing;
	}

	public String getYouNianFuYangRen() {
		return this.youNianFuYangRen;
	}

	public void setYouNianFuYangRen(String youNianFuYangRen) {
		this.youNianFuYangRen = youNianFuYangRen;
	}

	public Integer getJiYangShi1() {
		return this.jiYangShi1;
	}

	public void setJiYangShi1(Integer jiYangShi1) {
		this.jiYangShi1 = jiYangShi1;
	}

	public Integer getJiYangShi2() {
		return this.jiYangShi2;
	}

	public void setJiYangShi2(Integer jiYangShi2) {
		this.jiYangShi2 = jiYangShi2;
	}

	public String getYouNianShengHuoHuanJing() {
		return this.youNianShengHuoHuanJing;
	}

	public void setYouNianShengHuoHuanJing(String youNianShengHuoHuanJing) {
		this.youNianShengHuoHuanJing = youNianShengHuoHuanJing;
	}

	public String getXianZaiShengHuoHuanJing() {
		return this.xianZaiShengHuoHuanJing;
	}

	public void setXianZaiShengHuoHuanJing(String xianZaiShengHuoHuanJing) {
		this.xianZaiShengHuoHuanJing = xianZaiShengHuoHuanJing;
	}

	public Integer getXiongDiJieMeiGuanXi() {
		return this.xiongDiJieMeiGuanXi;
	}

	public void setXiongDiJieMeiGuanXi(Integer xiongDiJieMeiGuanXi) {
		this.xiongDiJieMeiGuanXi = xiongDiJieMeiGuanXi;
	}

	public Integer getFuQiGuanXi() {
		return this.fuQiGuanXi;
	}

	public void setFuQiGuanXi(Integer fuQiGuanXi) {
		this.fuQiGuanXi = fuQiGuanXi;
	}

	public Integer getPoXiGuanXi() {
		return this.poXiGuanXi;
	}

	public void setPoXiGuanXi(Integer poXiGuanXi) {
		this.poXiGuanXi = poXiGuanXi;
	}

	public String getFuQinZhiYe() {
		return this.fuQinZhiYe;
	}

	public void setFuQinZhiYe(String fuQinZhiYe) {
		this.fuQinZhiYe = fuQinZhiYe;
	}

	public String getMuQinZhiYe() {
		return this.muQinZhiYe;
	}

	public void setMuQinZhiYe(String muQinZhiYe) {
		this.muQinZhiYe = muQinZhiYe;
	}

	public String getFuQinWenHuaChengDu() {
		return this.fuQinWenHuaChengDu;
	}

	public void setFuQinWenHuaChengDu(String fuQinWenHuaChengDu) {
		this.fuQinWenHuaChengDu = fuQinWenHuaChengDu;
	}

	public String getMuQinWenHuaChengDu() {
		return this.muQinWenHuaChengDu;
	}

	public void setMuQinWenHuaChengDu(String muQinWenHuaChengDu) {
		this.muQinWenHuaChengDu = muQinWenHuaChengDu;
	}

	public Integer getZhongDaFuXingShiJian1() {
		return this.zhongDaFuXingShiJian1;
	}

	public void setZhongDaFuXingShiJian1(Integer zhongDaFuXingShiJian1) {
		this.zhongDaFuXingShiJian1 = zhongDaFuXingShiJian1;
	}

	public String getZhongDaFuXingShiJian2() {
		return this.zhongDaFuXingShiJian2;
	}

	public void setZhongDaFuXingShiJian2(String zhongDaFuXingShiJian2) {
		this.zhongDaFuXingShiJian2 = zhongDaFuXingShiJian2;
	}

	public Integer getYingJiShiJian1() {
		return this.yingJiShiJian1;
	}

	public void setYingJiShiJian1(Integer yingJiShiJian1) {
		this.yingJiShiJian1 = yingJiShiJian1;
	}

	public String getYingJiShiJian2() {
		return this.yingJiShiJian2;
	}

	public void setYingJiShiJian2(String yingJiShiJian2) {
		this.yingJiShiJian2 = yingJiShiJian2;
	}

	public Integer getRenJiGuanXi() {
		return this.renJiGuanXi;
	}

	public void setRenJiGuanXi(Integer renJiGuanXi) {
		this.renJiGuanXi = renJiGuanXi;
	}

	public String getWenTiBiaoXianWei() {
		return this.wenTiBiaoXianWei;
	}

	public void setWenTiBiaoXianWei(String wenTiBiaoXianWei) {
		this.wenTiBiaoXianWei = wenTiBiaoXianWei;
	}

	public String getWenTiFaShengZai() {
		return this.wenTiFaShengZai;
	}

	public void setWenTiFaShengZai(String wenTiFaShengZai) {
		this.wenTiFaShengZai = wenTiFaShengZai;
	}

	public Integer getShengHuoManYiYuFou() {
		return this.shengHuoManYiYuFou;
	}

	public void setShengHuoManYiYuFou(Integer shengHuoManYiYuFou) {
		this.shengHuoManYiYuFou = shengHuoManYiYuFou;
	}

	public String getBuManYiDeFangMian() {
		return this.buManYiDeFangMian;
	}

	public void setBuManYiDeFangMian(String buManYiDeFangMian) {
		this.buManYiDeFangMian = buManYiDeFangMian;
	}

	public Integer getDangQianJiBingRenZhi() {
		return this.dangQianJiBingRenZhi;
	}

	public void setDangQianJiBingRenZhi(Integer dangQianJiBingRenZhi) {
		this.dangQianJiBingRenZhi = dangQianJiBingRenZhi;
	}

	public Integer getJiBingYuHouTaiDu() {
		return this.jiBingYuHouTaiDu;
	}

	public void setJiBingYuHouTaiDu(Integer jiBingYuHouTaiDu) {
		this.jiBingYuHouTaiDu = jiBingYuHouTaiDu;
	}

	public Integer getYingDuiFangShi() {
		return this.yingDuiFangShi;
	}

	public void setYingDuiFangShi(Integer yingDuiFangShi) {
		this.yingDuiFangShi = yingDuiFangShi;
	}

	public Integer getZhiLiaoCanYuChengDu() {
		return this.zhiLiaoCanYuChengDu;
	}

	public void setZhiLiaoCanYuChengDu(Integer zhiLiaoCanYuChengDu) {
		this.zhiLiaoCanYuChengDu = zhiLiaoCanYuChengDu;
	}

	public Integer getSheHuiZhiChi() {
		return this.sheHuiZhiChi;
	}

	public void setSheHuiZhiChi(Integer sheHuiZhiChi) {
		this.sheHuiZhiChi = sheHuiZhiChi;
	}

	public Integer getPengYou() {
		return this.pengYou;
	}

	public void setPengYou(Integer pengYou) {
		this.pengYou = pengYou;
	}

	public Integer getJiaRen() {
		return this.jiaRen;
	}

	public void setJiaRen(Integer jiaRen) {
		this.jiaRen = jiaRen;
	}

	public Integer getDuiGeXiangZhiChiLiYongDu() {
		return this.duiGeXiangZhiChiLiYongDu;
	}

	public void setDuiGeXiangZhiChiLiYongDu(Integer duiGeXiangZhiChiLiYongDu) {
		this.duiGeXiangZhiChiLiYongDu = duiGeXiangZhiChiLiYongDu;
	}

	public Integer getXingShengHuo() {
		return this.xingShengHuo;
	}

	public void setXingShengHuo(Integer xingShengHuo) {
		this.xingShengHuo = xingShengHuo;
	}

	public String getWenTiFaShengQiTa() {
		return this.wenTiFaShengQiTa;
	}

	public void setWenTiFaShengQiTa(String wenTiFaShengQiTa) {
		this.wenTiFaShengQiTa = wenTiFaShengQiTa;
	}

	public Integer getYinXiang() {
		return this.yinXiang;
	}

	public void setYinXiang(Integer yinXiang) {
		this.yinXiang = yinXiang;
	}

	public String getYinXiangQiTa() {
		return this.yinXiangQiTa;
	}

	public void setYinXiangQiTa(String yinXiangQiTa) {
		this.yinXiangQiTa = yinXiangQiTa;
	}

	public Integer getChuZhi() {
		return this.chuZhi;
	}

	public void setChuZhi(Integer chuZhi) {
		this.chuZhi = chuZhi;
	}

	public String getJiaPuTu() {
		return this.jiaPuTu;
	}

	public void setJiaPuTu(String jiaPuTu) {
		this.jiaPuTu = jiaPuTu;
	}

	public String getFangShuRen() {
		return this.fangShuRen;
	}

	public void setFangShuRen(String fangShuRen) {
		this.fangShuRen = fangShuRen;
	}

	public String getMiMa() {
		return this.miMa;
	}

	public void setMiMa(String miMa) {
		this.miMa = miMa;
	}

	public Integer getKeShiId() {
		return this.keShiId;
	}

	public void setKeShiId(Integer keShiId) {
		this.keShiId = keShiId;
	}

	public Integer getZhuanKeYiShengId() {
		return this.zhuanKeYiShengId;
	}

	public void setZhuanKeYiShengId(Integer zhuanKeYiShengId) {
		this.zhuanKeYiShengId = zhuanKeYiShengId;
	}

	public Integer getJingShenKeYiShengId() {
		return this.jingShenKeYiShengId;
	}

	public void setJingShenKeYiShengId(Integer jingShenKeYiShengId) {
		this.jingShenKeYiShengId = jingShenKeYiShengId;
	}

	public Integer getYiYuanId() {
		return this.yiYuanId;
	}

	public void setYiYuanId(Integer yiYuanId) {
		this.yiYuanId = yiYuanId;
	}

	public String getCePingShi() {
		return this.cePingShi;
	}

	public void setCePingShi(String cePingShi) {
		this.cePingShi = cePingShi;
	}

	public Integer getCePingShiId() {
		return this.cePingShiId;
	}

	public void setCePingShiId(Integer cePingShiId) {
		this.cePingShiId = cePingShiId;
	}

	public Boolean getIsGuiDang() {
		return this.isGuiDang;
	}

	public void setIsGuiDang(Boolean isGuiDang) {
		this.isGuiDang = isGuiDang;
	}

	public Timestamp getGdRiQi() {
		return this.gdRiQi;
	}

	public void setGdRiQi(Timestamp gdRiQi) {
		this.gdRiQi = gdRiQi;
	}

	public String getJiaPuTuBeiZhu() {
		return this.jiaPuTuBeiZhu;
	}

	public void setJiaPuTuBeiZhu(String jiaPuTuBeiZhu) {
		this.jiaPuTuBeiZhu = jiaPuTuBeiZhu;
	}

	public Integer getQinZiGuanXi() {
		return qinZiGuanXi;
	}

	public void setQinZiGuanXi(Integer qinZiGuanXi) {
		this.qinZiGuanXi = qinZiGuanXi;
	}

	@Override
	public String toString() {
		return "JiChuXinXi [id=" + id + ", isDelete=" + isDelete + ", yongHuId=" + yongHuId + ", riQi=" + riQi
				+ ", menZhenHao=" + menZhenHao + ", bingAnHao=" + bingAnHao + ", zhuGuanYiShi=" + zhuGuanYiShi
				+ ", suoShuKeShi=" + suoShuKeShi + ", zhuanKeYiSheng=" + zhuanKeYiSheng + ", xingMing=" + xingMing
				+ ", xingBie=" + xingBie + ", chuShengNian=" + chuShengNian + ", chuShengYue=" + chuShengYue
				+ ", chuShengRi=" + chuShengRi + ", minZu=" + minZu + ", hunYinZhuangKuang=" + hunYinZhuangKuang
				+ ", shenGao=" + shenGao + ", tiZhong=" + tiZhong + ", chuShengDi=" + chuShengDi + ", zhiYe=" + zhiYe
				+ ", wenHuaChengDu=" + wenHuaChengDu + ", paiHang1=" + paiHang1 + ", paiHang2=" + paiHang2
				+ ", jingJiZhuangKuang=" + jingJiZhuangKuang + ", lianXiDiZhi=" + lianXiDiZhi + ", lianXiDianHua="
				+ lianXiDianHua + ", jiuZhenYuanYin=" + jiuZhenYuanYin + ", shuiMian=" + shuiMian + ", shiYu=" + shiYu
				+ ", chuXian1=" + chuXian1 + ", chuXian2=" + chuXian2 + ", jiWangLeiSiFaZuo=" + jiWangLeiSiFaZuo
				+ ", jiWangQuTiJiBing=" + jiWangQuTiJiBing + ", jiWangJuTiJiBingZhenDuan=" + jiWangJuTiJiBingZhenDuan
				+ ", xianLeiSiFaZuo=" + xianLeiSiFaZuo + ", xianQuTiJiBing=" + xianQuTiJiBing
				+ ", xianJuTiJiBingZhenDuan=" + xianJuTiJiBingZhenDuan + ", jiaZuBingShi=" + jiaZuBingShi
				+ ", jiaZuJuTiJiBingZhenDuan=" + jiaZuJuTiJiBingZhenDuan + ", geXingTeDian=" + geXingTeDian
				+ ", qingXuWenDingXing=" + qingXuWenDingXing + ", renGeTeDian=" + renGeTeDian + ", xueXing=" + xueXing
				+ ", renGeTeZhi=" + renGeTeZhi + ", xingQu=" + xingQu + ", yan=" + yan + ", jiu=" + jiu
				+ ", yanJiuQiTa=" + yanJiuQiTa + ", shengZhangFaYu=" + shengZhangFaYu + ", xueBu=" + xueBu + ", yuYan="
				+ yuYan + ", yueJingChuChao=" + yueJingChuChao + ", shouCiYiJing=" + shouCiYiJing + ", tingJing="
				+ tingJing + ", youNianFuYangRen=" + youNianFuYangRen + ", jiYangShi1=" + jiYangShi1 + ", jiYangShi2="
				+ jiYangShi2 + ", youNianShengHuoHuanJing=" + youNianShengHuoHuanJing + ", xianZaiShengHuoHuanJing="
				+ xianZaiShengHuoHuanJing + ", xiongDiJieMeiGuanXi=" + xiongDiJieMeiGuanXi + ", fuQiGuanXi="
				+ fuQiGuanXi + ", poXiGuanXi=" + poXiGuanXi + ", fuQinZhiYe=" + fuQinZhiYe + ", muQinZhiYe="
				+ muQinZhiYe + ", fuQinWenHuaChengDu=" + fuQinWenHuaChengDu + ", muQinWenHuaChengDu="
				+ muQinWenHuaChengDu + ", zhongDaFuXingShiJian1=" + zhongDaFuXingShiJian1 + ", zhongDaFuXingShiJian2="
				+ zhongDaFuXingShiJian2 + ", yingJiShiJian1=" + yingJiShiJian1 + ", yingJiShiJian2=" + yingJiShiJian2
				+ ", renJiGuanXi=" + renJiGuanXi + ", wenTiBiaoXianWei=" + wenTiBiaoXianWei + ", wenTiFaShengZai="
				+ wenTiFaShengZai + ", shengHuoManYiYuFou=" + shengHuoManYiYuFou + ", buManYiDeFangMian="
				+ buManYiDeFangMian + ", dangQianJiBingRenZhi=" + dangQianJiBingRenZhi + ", jiBingYuHouTaiDu="
				+ jiBingYuHouTaiDu + ", yingDuiFangShi=" + yingDuiFangShi + ", zhiLiaoCanYuChengDu="
				+ zhiLiaoCanYuChengDu + ", sheHuiZhiChi=" + sheHuiZhiChi + ", pengYou=" + pengYou + ", jiaRen=" + jiaRen
				+ ", duiGeXiangZhiChiLiYongDu=" + duiGeXiangZhiChiLiYongDu + ", xingShengHuo=" + xingShengHuo
				+ ", wenTiFaShengQiTa=" + wenTiFaShengQiTa + ", yinXiang=" + yinXiang + ", yinXiangQiTa=" + yinXiangQiTa
				+ ", chuZhi=" + chuZhi + ", jiaPuTu=" + jiaPuTu + ", fangShuRen=" + fangShuRen + ", miMa=" + miMa
				+ ", keShiId=" + keShiId + ", zhuanKeYiShengId=" + zhuanKeYiShengId + ", jingShenKeYiShengId="
				+ jingShenKeYiShengId + ", yiYuanId=" + yiYuanId + ", cePingShi=" + cePingShi + ", cePingShiId="
				+ cePingShiId + ", isGuiDang=" + isGuiDang + ", gdRiQi=" + gdRiQi + ", jiaPuTuBeiZhu=" + jiaPuTuBeiZhu
				+ ", qinZiGuanXi=" + qinZiGuanXi + "]";
	}

}