package com.jmy.entity.son;

import com.jmy.entity.NoticeWithBLOBs;

public class NoticeSon extends NoticeWithBLOBs {

	private boolean notice;
	private boolean read;
	private String user;

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
