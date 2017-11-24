package com.jmy.service;

import javax.servlet.http.HttpSession;

import com.jmy.entity.TimeNoticeWithBLOBs;

public interface TimeNoticeService {

	public TimeNoticeWithBLOBs show();
	
	public int edit(HttpSession session, String title, String content, String message, byte isTime, String sendTime);
}
