package com.jmy.entity.son;

import com.jmy.entity.Tax;

public class TaxSon extends Tax {

	private String addTimeSon;
	private String nowTimeSon;
	private String idCode;
	private String name;
	private String swjgDm;
	private String swjgMc;
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getAddTimeSon() {
		return addTimeSon;
	}

	public void setAddTimeSon(String addTimeSon) {
		this.addTimeSon = addTimeSon;
	}

	public String getNowTimeSon() {
		return nowTimeSon;
	}

	public void setNowTimeSon(String nowTimeSon) {
		this.nowTimeSon = nowTimeSon;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSwjgDm() {
		return swjgDm;
	}

	public void setSwjgDm(String swjgDm) {
		this.swjgDm = swjgDm;
	}

	public String getSwjgMc() {
		return swjgMc;
	}

	public void setSwjgMc(String swjgMc) {
		this.swjgMc = swjgMc;
	}


	public TaxSon(String addTimeSon, String nowTimeSon, String idCode, String name, String swjgDm, String swjgMc) {
		super();
		this.addTimeSon = addTimeSon;
		this.nowTimeSon = nowTimeSon;
		this.idCode = idCode;
		this.name = name;
		this.swjgDm = swjgDm;
		this.swjgMc = swjgMc;
	}

	public TaxSon() {
		super();
	}
}
