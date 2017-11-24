package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao1 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao1 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Double pingHe;
	private Double qiXu;
	private Double yangXu;
	private Double yinXu;
	private Double tanShi;
	private Double shiRe;
	private Double yuXue;
	private Double qiYu;
	private Double teBing;
	private String beLong;
	private String yiJian;
	private String jianYi;
	private String yaoShan;
	private Integer flag;
	private Timestamp riQi;

	// Constructors

	/** default constructor */
	public CePingBaoGao1() {
	}

	/** minimal constructor */
	public CePingBaoGao1(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao1(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Double pingHe, Double qiXu, Double yangXu,
			Double yinXu, Double tanShi, Double shiRe, Double yuXue,
			Double qiYu, Double teBing, String beLong, String yiJian,
			String jianYi, String yaoShan, Integer flag, Timestamp riQi) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.pingHe = pingHe;
		this.qiXu = qiXu;
		this.yangXu = yangXu;
		this.yinXu = yinXu;
		this.tanShi = tanShi;
		this.shiRe = shiRe;
		this.yuXue = yuXue;
		this.qiYu = qiYu;
		this.teBing = teBing;
		this.beLong = beLong;
		this.yiJian = yiJian;
		this.jianYi = jianYi;
		this.yaoShan = yaoShan;
		this.flag = flag;
		this.riQi = riQi;
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

	public Integer getCiShu() {
		return this.ciShu;
	}

	public void setCiShu(Integer ciShu) {
		this.ciShu = ciShu;
	}

	public Integer getJiChuXinXiId() {
		return this.jiChuXinXiId;
	}

	public void setJiChuXinXiId(Integer jiChuXinXiId) {
		this.jiChuXinXiId = jiChuXinXiId;
	}

	public Double getPingHe() {
		return this.pingHe;
	}

	public void setPingHe(Double pingHe) {
		this.pingHe = pingHe;
	}

	public Double getQiXu() {
		return this.qiXu;
	}

	public void setQiXu(Double qiXu) {
		this.qiXu = qiXu;
	}

	public Double getYangXu() {
		return this.yangXu;
	}

	public void setYangXu(Double yangXu) {
		this.yangXu = yangXu;
	}

	public Double getYinXu() {
		return this.yinXu;
	}

	public void setYinXu(Double yinXu) {
		this.yinXu = yinXu;
	}

	public Double getTanShi() {
		return this.tanShi;
	}

	public void setTanShi(Double tanShi) {
		this.tanShi = tanShi;
	}

	public Double getShiRe() {
		return this.shiRe;
	}

	public void setShiRe(Double shiRe) {
		this.shiRe = shiRe;
	}

	public Double getYuXue() {
		return this.yuXue;
	}

	public void setYuXue(Double yuXue) {
		this.yuXue = yuXue;
	}

	public Double getQiYu() {
		return this.qiYu;
	}

	public void setQiYu(Double qiYu) {
		this.qiYu = qiYu;
	}

	public Double getTeBing() {
		return this.teBing;
	}

	public void setTeBing(Double teBing) {
		this.teBing = teBing;
	}

	public String getBeLong() {
		return this.beLong;
	}

	public void setBeLong(String beLong) {
		this.beLong = beLong;
	}

	public String getYiJian() {
		return this.yiJian;
	}

	public void setYiJian(String yiJian) {
		this.yiJian = yiJian;
	}

	public String getJianYi() {
		return this.jianYi;
	}

	public void setJianYi(String jianYi) {
		this.jianYi = jianYi;
	}

	public String getYaoShan() {
		return this.yaoShan;
	}

	public void setYaoShan(String yaoShan) {
		this.yaoShan = yaoShan;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

}