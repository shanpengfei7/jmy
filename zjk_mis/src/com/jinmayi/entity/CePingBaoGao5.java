package com.jinmayi.entity;

import java.sql.Timestamp;

/**
 * CePingBaoGao5 entity. @author MyEclipse Persistence Tools
 */

public class CePingBaoGao5 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer ciShu;
	private Integer jiChuXinXiId;
	private Integer quTiHua0;
	private Integer qiangPoZheng0;
	private Integer renJiGuanXi0;
	private Integer yiYu0;
	private Integer jiaoLv0;
	private Integer diDui0;
	private Integer kongBu0;
	private Integer pianZhi0;
	private Integer jingShenBing0;
	private Integer qiTa0;
	private Double quTiHua;
	private Double qiangPoZheng;
	private Double renJiGuanXi;
	private Double yiYu;
	private Double jiaoLv;
	private Double diDui;
	private Double kongBu;
	private Double pianZhi;
	private Double jingShenBing;
	private Double qiTa;
	private String belongQuTiHua;
	private Integer sum;
	private String belongQiangPoZheng;
	private String belongRenJiGuanXi;
	private String belongYiYu;
	private String belongJiaoLv;
	private String belongDiDui;
	private String belongKongBu;
	private String belongPianZhi;
	private String belongJingShenBing;
	private String belongQiTa;
	private Double ave;
	private Timestamp riQi;
	private String belongQuTiHua0;
	private String belongQiangPoZheng0;
	private String belongRenJiGuanXi0;
	private String belongYiYu0;
	private String belongJiaoLv0;
	private String belongDiDui0;
	private String belongKongBu0;
	private String belongPianZhi0;
	private String belongJingShenBing0;
	private String belongQiTa0;

	// Constructors

	/** default constructor */
	public CePingBaoGao5() {
	}

	/** minimal constructor */
	public CePingBaoGao5(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
	}

	/** full constructor */
	public CePingBaoGao5(Integer id, Boolean isDelete, Integer ciShu,
			Integer jiChuXinXiId, Integer quTiHua0, Integer qiangPoZheng0,
			Integer renJiGuanXi0, Integer yiYu0, Integer jiaoLv0,
			Integer diDui0, Integer kongBu0, Integer pianZhi0,
			Integer jingShenBing0, Integer qiTa0, Double quTiHua,
			Double qiangPoZheng, Double renJiGuanXi, Double yiYu,
			Double jiaoLv, Double diDui, Double kongBu, Double pianZhi,
			Double jingShenBing, Double qiTa, String belongQuTiHua,
			Integer sum, String belongQiangPoZheng, String belongRenJiGuanXi,
			String belongYiYu, String belongJiaoLv, String belongDiDui,
			String belongKongBu, String belongPianZhi,
			String belongJingShenBing, String belongQiTa, Double ave,
			Timestamp riQi, String belongQuTiHua0, String belongQiangPoZheng0,
			String belongRenJiGuanXi0, String belongYiYu0,
			String belongJiaoLv0, String belongDiDui0, String belongKongBu0,
			String belongPianZhi0, String belongJingShenBing0,
			String belongQiTa0) {
		this.id = id;
		this.isDelete = isDelete;
		this.ciShu = ciShu;
		this.jiChuXinXiId = jiChuXinXiId;
		this.quTiHua0 = quTiHua0;
		this.qiangPoZheng0 = qiangPoZheng0;
		this.renJiGuanXi0 = renJiGuanXi0;
		this.yiYu0 = yiYu0;
		this.jiaoLv0 = jiaoLv0;
		this.diDui0 = diDui0;
		this.kongBu0 = kongBu0;
		this.pianZhi0 = pianZhi0;
		this.jingShenBing0 = jingShenBing0;
		this.qiTa0 = qiTa0;
		this.quTiHua = quTiHua;
		this.qiangPoZheng = qiangPoZheng;
		this.renJiGuanXi = renJiGuanXi;
		this.yiYu = yiYu;
		this.jiaoLv = jiaoLv;
		this.diDui = diDui;
		this.kongBu = kongBu;
		this.pianZhi = pianZhi;
		this.jingShenBing = jingShenBing;
		this.qiTa = qiTa;
		this.belongQuTiHua = belongQuTiHua;
		this.sum = sum;
		this.belongQiangPoZheng = belongQiangPoZheng;
		this.belongRenJiGuanXi = belongRenJiGuanXi;
		this.belongYiYu = belongYiYu;
		this.belongJiaoLv = belongJiaoLv;
		this.belongDiDui = belongDiDui;
		this.belongKongBu = belongKongBu;
		this.belongPianZhi = belongPianZhi;
		this.belongJingShenBing = belongJingShenBing;
		this.belongQiTa = belongQiTa;
		this.ave = ave;
		this.riQi = riQi;
		this.belongQuTiHua0 = belongQuTiHua0;
		this.belongQiangPoZheng0 = belongQiangPoZheng0;
		this.belongRenJiGuanXi0 = belongRenJiGuanXi0;
		this.belongYiYu0 = belongYiYu0;
		this.belongJiaoLv0 = belongJiaoLv0;
		this.belongDiDui0 = belongDiDui0;
		this.belongKongBu0 = belongKongBu0;
		this.belongPianZhi0 = belongPianZhi0;
		this.belongJingShenBing0 = belongJingShenBing0;
		this.belongQiTa0 = belongQiTa0;
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

	public Integer getQuTiHua0() {
		return this.quTiHua0;
	}

	public void setQuTiHua0(Integer quTiHua0) {
		this.quTiHua0 = quTiHua0;
	}

	public Integer getQiangPoZheng0() {
		return this.qiangPoZheng0;
	}

	public void setQiangPoZheng0(Integer qiangPoZheng0) {
		this.qiangPoZheng0 = qiangPoZheng0;
	}

	public Integer getRenJiGuanXi0() {
		return this.renJiGuanXi0;
	}

	public void setRenJiGuanXi0(Integer renJiGuanXi0) {
		this.renJiGuanXi0 = renJiGuanXi0;
	}

	public Integer getYiYu0() {
		return this.yiYu0;
	}

	public void setYiYu0(Integer yiYu0) {
		this.yiYu0 = yiYu0;
	}

	public Integer getJiaoLv0() {
		return this.jiaoLv0;
	}

	public void setJiaoLv0(Integer jiaoLv0) {
		this.jiaoLv0 = jiaoLv0;
	}

	public Integer getDiDui0() {
		return this.diDui0;
	}

	public void setDiDui0(Integer diDui0) {
		this.diDui0 = diDui0;
	}

	public Integer getKongBu0() {
		return this.kongBu0;
	}

	public void setKongBu0(Integer kongBu0) {
		this.kongBu0 = kongBu0;
	}

	public Integer getPianZhi0() {
		return this.pianZhi0;
	}

	public void setPianZhi0(Integer pianZhi0) {
		this.pianZhi0 = pianZhi0;
	}

	public Integer getJingShenBing0() {
		return this.jingShenBing0;
	}

	public void setJingShenBing0(Integer jingShenBing0) {
		this.jingShenBing0 = jingShenBing0;
	}

	public Integer getQiTa0() {
		return this.qiTa0;
	}

	public void setQiTa0(Integer qiTa0) {
		this.qiTa0 = qiTa0;
	}

	public Double getQuTiHua() {
		return this.quTiHua;
	}

	public void setQuTiHua(Double quTiHua) {
		this.quTiHua = quTiHua;
	}

	public Double getQiangPoZheng() {
		return this.qiangPoZheng;
	}

	public void setQiangPoZheng(Double qiangPoZheng) {
		this.qiangPoZheng = qiangPoZheng;
	}

	public Double getRenJiGuanXi() {
		return this.renJiGuanXi;
	}

	public void setRenJiGuanXi(Double renJiGuanXi) {
		this.renJiGuanXi = renJiGuanXi;
	}

	public Double getYiYu() {
		return this.yiYu;
	}

	public void setYiYu(Double yiYu) {
		this.yiYu = yiYu;
	}

	public Double getJiaoLv() {
		return this.jiaoLv;
	}

	public void setJiaoLv(Double jiaoLv) {
		this.jiaoLv = jiaoLv;
	}

	public Double getDiDui() {
		return this.diDui;
	}

	public void setDiDui(Double diDui) {
		this.diDui = diDui;
	}

	public Double getKongBu() {
		return this.kongBu;
	}

	public void setKongBu(Double kongBu) {
		this.kongBu = kongBu;
	}

	public Double getPianZhi() {
		return this.pianZhi;
	}

	public void setPianZhi(Double pianZhi) {
		this.pianZhi = pianZhi;
	}

	public Double getJingShenBing() {
		return this.jingShenBing;
	}

	public void setJingShenBing(Double jingShenBing) {
		this.jingShenBing = jingShenBing;
	}

	public Double getQiTa() {
		return this.qiTa;
	}

	public void setQiTa(Double qiTa) {
		this.qiTa = qiTa;
	}

	public String getBelongQuTiHua() {
		return this.belongQuTiHua;
	}

	public void setBelongQuTiHua(String belongQuTiHua) {
		this.belongQuTiHua = belongQuTiHua;
	}

	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getBelongQiangPoZheng() {
		return this.belongQiangPoZheng;
	}

	public void setBelongQiangPoZheng(String belongQiangPoZheng) {
		this.belongQiangPoZheng = belongQiangPoZheng;
	}

	public String getBelongRenJiGuanXi() {
		return this.belongRenJiGuanXi;
	}

	public void setBelongRenJiGuanXi(String belongRenJiGuanXi) {
		this.belongRenJiGuanXi = belongRenJiGuanXi;
	}

	public String getBelongYiYu() {
		return this.belongYiYu;
	}

	public void setBelongYiYu(String belongYiYu) {
		this.belongYiYu = belongYiYu;
	}

	public String getBelongJiaoLv() {
		return this.belongJiaoLv;
	}

	public void setBelongJiaoLv(String belongJiaoLv) {
		this.belongJiaoLv = belongJiaoLv;
	}

	public String getBelongDiDui() {
		return this.belongDiDui;
	}

	public void setBelongDiDui(String belongDiDui) {
		this.belongDiDui = belongDiDui;
	}

	public String getBelongKongBu() {
		return this.belongKongBu;
	}

	public void setBelongKongBu(String belongKongBu) {
		this.belongKongBu = belongKongBu;
	}

	public String getBelongPianZhi() {
		return this.belongPianZhi;
	}

	public void setBelongPianZhi(String belongPianZhi) {
		this.belongPianZhi = belongPianZhi;
	}

	public String getBelongJingShenBing() {
		return this.belongJingShenBing;
	}

	public void setBelongJingShenBing(String belongJingShenBing) {
		this.belongJingShenBing = belongJingShenBing;
	}

	public String getBelongQiTa() {
		return this.belongQiTa;
	}

	public void setBelongQiTa(String belongQiTa) {
		this.belongQiTa = belongQiTa;
	}

	public Double getAve() {
		return this.ave;
	}

	public void setAve(Double ave) {
		this.ave = ave;
	}

	public Timestamp getRiQi() {
		return this.riQi;
	}

	public void setRiQi(Timestamp riQi) {
		this.riQi = riQi;
	}

	public String getBelongQuTiHua0() {
		return this.belongQuTiHua0;
	}

	public void setBelongQuTiHua0(String belongQuTiHua0) {
		this.belongQuTiHua0 = belongQuTiHua0;
	}

	public String getBelongQiangPoZheng0() {
		return this.belongQiangPoZheng0;
	}

	public void setBelongQiangPoZheng0(String belongQiangPoZheng0) {
		this.belongQiangPoZheng0 = belongQiangPoZheng0;
	}

	public String getBelongRenJiGuanXi0() {
		return this.belongRenJiGuanXi0;
	}

	public void setBelongRenJiGuanXi0(String belongRenJiGuanXi0) {
		this.belongRenJiGuanXi0 = belongRenJiGuanXi0;
	}

	public String getBelongYiYu0() {
		return this.belongYiYu0;
	}

	public void setBelongYiYu0(String belongYiYu0) {
		this.belongYiYu0 = belongYiYu0;
	}

	public String getBelongJiaoLv0() {
		return this.belongJiaoLv0;
	}

	public void setBelongJiaoLv0(String belongJiaoLv0) {
		this.belongJiaoLv0 = belongJiaoLv0;
	}

	public String getBelongDiDui0() {
		return this.belongDiDui0;
	}

	public void setBelongDiDui0(String belongDiDui0) {
		this.belongDiDui0 = belongDiDui0;
	}

	public String getBelongKongBu0() {
		return this.belongKongBu0;
	}

	public void setBelongKongBu0(String belongKongBu0) {
		this.belongKongBu0 = belongKongBu0;
	}

	public String getBelongPianZhi0() {
		return this.belongPianZhi0;
	}

	public void setBelongPianZhi0(String belongPianZhi0) {
		this.belongPianZhi0 = belongPianZhi0;
	}

	public String getBelongJingShenBing0() {
		return this.belongJingShenBing0;
	}

	public void setBelongJingShenBing0(String belongJingShenBing0) {
		this.belongJingShenBing0 = belongJingShenBing0;
	}

	public String getBelongQiTa0() {
		return this.belongQiTa0;
	}

	public void setBelongQiTa0(String belongQiTa0) {
		this.belongQiTa0 = belongQiTa0;
	}

}