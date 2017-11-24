package com.jinmayi.domain;

public class SearchContent {

	private String time1;
	private String time2;
	private String name;

	@Override
	public String toString() {
		return "SearchContent [time1=" + time1 + ", time2=" + time2 + ", name="
				+ name + "]";
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
