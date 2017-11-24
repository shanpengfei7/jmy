package com.jinmayi.entity;

/**
 * YiSheng entity. @author MyEclipse Persistence Tools
 */

public class YiSheng implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Boolean isDelete;
	private String keShi;
	private String yiYuan;
	private String xingMing;
	private Integer xingBie;
	private String jueSe;
	private Boolean isZhuRen;
	private String lianXiFangShi;
	private Integer keShiId;
	private Integer dengLuId;
	private Integer yiYuanId;

	// Constructors

	@Override
	public String toString() {
		return "YiSheng [id=" + id + ", isDelete=" + isDelete + ", keShi="
				+ keShi + ", yiYuan=" + yiYuan + ", xingMing=" + xingMing
				+ ", xingBie=" + xingBie + ", jueSe=" + jueSe + ", isZhuRen="
				+ isZhuRen + ", lianXiFangShi=" + lianXiFangShi + ", keShiId="
				+ keShiId + ", dengLuId=" + dengLuId + ", yiYuanId=" + yiYuanId
				+ "]";
	}

	/** default constructor */
	public YiSheng() {
	}

	/** minimal constructor */
	public YiSheng(Integer id, Boolean isDelete, String keShi, String yiYuan,
			String xingMing, Integer xingBie, String jueSe, Boolean isZhuRen,
			String lianXiFangShi, Integer keShiId, Integer yiYuanId) {
		this.id = id;
		this.isDelete = isDelete;
		this.keShi = keShi;
		this.yiYuan = yiYuan;
		this.xingMing = xingMing;
		this.xingBie = xingBie;
		this.jueSe = jueSe;
		this.isZhuRen = isZhuRen;
		this.lianXiFangShi = lianXiFangShi;
		this.keShiId = keShiId;
		this.yiYuanId = yiYuanId;
	}

	/** full constructor */
	public YiSheng(Integer id, Boolean isDelete, String keShi, String yiYuan,
			String xingMing, Integer xingBie, String jueSe, Boolean isZhuRen,
			String lianXiFangShi, Integer keShiId, Integer dengLuId,
			Integer yiYuanId) {
		this.id = id;
		this.isDelete = isDelete;
		this.keShi = keShi;
		this.yiYuan = yiYuan;
		this.xingMing = xingMing;
		this.xingBie = xingBie;
		this.jueSe = jueSe;
		this.isZhuRen = isZhuRen;
		this.lianXiFangShi = lianXiFangShi;
		this.keShiId = keShiId;
		this.dengLuId = dengLuId;
		this.yiYuanId = yiYuanId;
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

	public String getKeShi() {
		return this.keShi;
	}

	public void setKeShi(String keShi) {
		this.keShi = keShi;
	}

	public String getYiYuan() {
		return this.yiYuan;
	}

	public void setYiYuan(String yiYuan) {
		this.yiYuan = yiYuan;
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

	public String getJueSe() {
		return this.jueSe;
	}

	public void setJueSe(String jueSe) {
		this.jueSe = jueSe;
	}

	public Boolean getIsZhuRen() {
		return this.isZhuRen;
	}

	public void setIsZhuRen(Boolean isZhuRen) {
		this.isZhuRen = isZhuRen;
	}

	public String getLianXiFangShi() {
		return this.lianXiFangShi;
	}

	public void setLianXiFangShi(String lianXiFangShi) {
		this.lianXiFangShi = lianXiFangShi;
	}

	public Integer getKeShiId() {
		return this.keShiId;
	}

	public void setKeShiId(Integer keShiId) {
		this.keShiId = keShiId;
	}

	public Integer getDengLuId() {
		return this.dengLuId;
	}

	public void setDengLuId(Integer dengLuId) {
		this.dengLuId = dengLuId;
	}

	public Integer getYiYuanId() {
		return this.yiYuanId;
	}

	public void setYiYuanId(Integer yiYuanId) {
		this.yiYuanId = yiYuanId;
	}

}