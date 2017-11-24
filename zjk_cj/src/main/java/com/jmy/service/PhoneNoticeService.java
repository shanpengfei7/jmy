package com.jmy.service;

import javax.servlet.http.HttpSession;

import com.jmy.entity.PhoneNoticeWithBLOBs;

public interface PhoneNoticeService {
	
	public PhoneNoticeWithBLOBs show();

	public int edit(HttpSession session, String content, String message, String sendTime);
}
