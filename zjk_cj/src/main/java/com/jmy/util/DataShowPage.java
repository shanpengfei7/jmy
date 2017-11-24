package com.jmy.util;


import java.util.List;

public class DataShowPage {
	private long total;// 总条数
	private List<?> rows;// 数据
	private int size;// 一页多少条
	private int now;// 当前第几页
	private int count; // 共有几页

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}

	public int getCount() {
		if(total%size==0) {
			count = (int) (total/size);
		} else {
			count = (int) (total/size+1);
		}
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}