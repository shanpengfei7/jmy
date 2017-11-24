package com.jinmayi.domain;

import java.util.List;

public class Page<T> {

	// 当前第几页
	private Long pageNow;

	// 当前页的 List
	private List<T> list;

	// 每页显示多少条记录
	private long pageSize = 10;

	// 共有多少条记录
	private long totalItemNumber;

	// 构造器中需要对 pageNow 进行初始化
	public Page(Long pageNow) {
		super();
		this.pageNow = pageNow;
	}

	// 需要校验一下
	public long getpageNow() {
		if (pageNow <= 0)
			pageNow = 1l;

		if (getTotalPageNumber() != 0 && pageNow > getTotalPageNumber()) {
			pageNow = getTotalPageNumber();
		}

		return pageNow;
	}

	public long getPageSize() {
		return pageSize;
	}

	public long setPageSize(long pageSize) {
		return this.pageNow = pageSize;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	// 获取总页数
	public Long getTotalPageNumber() {

		long totalPageNumber =  totalItemNumber / pageSize;

		if (totalItemNumber % pageSize != 0) {
			totalPageNumber++;
		}

		return totalPageNumber;
	}

	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public boolean isHasNext() {
		if (getpageNow() < getTotalPageNumber()) {
			return true;
		}

		return false;
	}

	public boolean isHasPrev() {
		if (getpageNow() > 1) {
			return true;
		}

		return false;
	}

	public long getPrevPage() {
		if (isHasPrev()) {
			return getpageNow() - 1;
		}

		return getpageNow();
	}

	public long getNextPage() {
		if (isHasNext()) {
			return getpageNow() + 1;
		}

		return getpageNow();
	}

	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", list=" + list + ", pageSize="
				+ pageSize + ", totalItemNumber=" + totalItemNumber + "]";
	}
	
}
