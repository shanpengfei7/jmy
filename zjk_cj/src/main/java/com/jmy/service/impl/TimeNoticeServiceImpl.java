package com.jmy.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jmy.dao.TimeNoticeMapper;
import com.jmy.entity.Admi;
import com.jmy.entity.TimeNoticeExample;
import com.jmy.entity.TimeNoticeWithBLOBs;
import com.jmy.service.TimeNoticeService;

@Service("timeNoticeService")
public class TimeNoticeServiceImpl implements TimeNoticeService {

	@Resource
	private TimeNoticeMapper timeNoticeMapper;
	
	@Override
	public TimeNoticeWithBLOBs show() {
		return timeNoticeMapper.selectByPrimaryKey(1);
	}

	@Override
	public int edit(HttpSession session, String title, String content, String message, byte isTime,
			String sendTime) {
		TimeNoticeWithBLOBs t = new TimeNoticeWithBLOBs();
		t.setTitle(title.trim());
		t.setContent(content.trim());
		t.setMessage(message.trim());
		t.setIsTime(isTime);
		t.setSendTime(sendTime.trim());
		t.setUpdateTime(System.currentTimeMillis());
		Admi a = (Admi) session.getAttribute("admin");
		t.setUpdateUser(a.getId());
		
		TimeNoticeExample te = new TimeNoticeExample();
		te.createCriteria().andIdEqualTo(1);
		return timeNoticeMapper.updateByExampleSelective(t, te);
	}

}
