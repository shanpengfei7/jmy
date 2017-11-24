package com.jmy.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jmy.dao.PhoneNoticeMapper;
import com.jmy.entity.Admi;
import com.jmy.entity.PhoneNoticeExample;
import com.jmy.entity.PhoneNoticeWithBLOBs;
import com.jmy.service.PhoneNoticeService;

@Service("phoneNoticeService")
public class PhoneNoticeServiceImpl implements PhoneNoticeService {

	@Resource
	private PhoneNoticeMapper phoneNoticeMapper;
	
	@Override
	public PhoneNoticeWithBLOBs show() {
		return phoneNoticeMapper.selectByPrimaryKey(1);
	}

	@Override
	public int edit(HttpSession session, String content, String message,
			String sendTime) {
		PhoneNoticeWithBLOBs p = new PhoneNoticeWithBLOBs();
		p.setContent(content.trim());
		p.setMessage(message.trim());
		p.setSendTime(sendTime.trim());
		p.setUpdateTime(System.currentTimeMillis());
		Admi a = (Admi) session.getAttribute("admin");
		p.setUpdateUser(a.getId());
		
		PhoneNoticeExample pe = new PhoneNoticeExample();
		pe.createCriteria().andIdEqualTo(1);
		return phoneNoticeMapper.updateByExampleSelective(p, pe);
	}

}
