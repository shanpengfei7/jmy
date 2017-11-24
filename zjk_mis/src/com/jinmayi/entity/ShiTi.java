package com.jinmayi.entity;

/**
 * ShiTi entity. @author MyEclipse Persistence Tools
 */

public class ShiTi implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isDelete;
	private Integer liangBiaoId;
	private Integer tiHao;
	private String tiMu;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String f;
	private String g;

	// Constructors

	/** default constructor */
	public ShiTi() {
	}

	/** minimal constructor */
	public ShiTi(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ShiTi(Integer id, Boolean isDelete, Integer liangBiaoId,
			Integer tiHao, String tiMu, String a, String b, String c, String d,
			String e, String f, String g) {
		this.id = id;
		this.isDelete = isDelete;
		this.liangBiaoId = liangBiaoId;
		this.tiHao = tiHao;
		this.tiMu = tiMu;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
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

	public Integer getLiangBiaoId() {
		return this.liangBiaoId;
	}

	public void setLiangBiaoId(Integer liangBiaoId) {
		this.liangBiaoId = liangBiaoId;
	}

	public Integer getTiHao() {
		return this.tiHao;
	}

	public void setTiHao(Integer tiHao) {
		this.tiHao = tiHao;
	}

	public String getTiMu() {
		return this.tiMu;
	}

	public void setTiMu(String tiMu) {
		this.tiMu = tiMu;
	}

	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getF() {
		return this.f;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getG() {
		return this.g;
	}

	public void setG(String g) {
		this.g = g;
	}

}