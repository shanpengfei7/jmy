package com.jinmayi.domain;

import java.util.List;

public class Page<T> {

	// ��ǰ�ڼ�ҳ
	private Long pageNow;

	// ��ǰҳ�� List
	private List<T> list;

	// ÿҳ��ʾ��������¼
	private long pageSize = 10;

	// ���ж�������¼
	private long totalItemNumber;

	// ����������Ҫ�� pageNow ���г�ʼ��
	public Page(Long pageNow) {
		super();
		this.pageNow = pageNow;
	}

	// ��ҪУ��һ��
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

	// ��ȡ��ҳ��
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
