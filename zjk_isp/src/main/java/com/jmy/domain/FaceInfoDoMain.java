package com.jmy.domain;

import com.jmy.entity.Faceinfo;

public class FaceInfoDoMain extends Faceinfo {

	private String user;
	private String tao;
	private String start;
	private String last;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTao() {
		return tao;
	}

	public void setTao(String tao) {
		this.tao = tao;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

}
