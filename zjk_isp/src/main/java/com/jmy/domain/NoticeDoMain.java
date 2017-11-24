package com.jmy.domain;

import com.jmy.entity.NoticeWithBLOBs;

public class NoticeDoMain extends NoticeWithBLOBs {

	private boolean notice;
	private boolean read;

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

}
