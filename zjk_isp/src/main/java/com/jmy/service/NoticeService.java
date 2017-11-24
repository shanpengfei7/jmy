package com.jmy.service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.util.DataShowPage;

public interface NoticeService {

	public DataShowPage getNotices(int uid, int pageNum, int pageSize);

	public DataShowPage getNotices(int pageNum, int pageSize, String title);
	
	public JSONObject getUnread(int uid);

	public NoticeWithBLOBs getNotice(int id);

	public int save(NoticeWithBLOBs n);

	public int edit(NoticeWithBLOBs n);

	// =====================================================

	public DataShowPage getNoticeReads(int pageNum, int pageSize);

	public boolean isNotice(int uid, int nid);

	public boolean isRead(int uid, int nid);

	public int notice(int uid, int nid);

	public int read(int nid, int uid, int time);
}
