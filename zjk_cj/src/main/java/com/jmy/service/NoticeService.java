package com.jmy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.entity.son.NoticeSon;
import com.jmy.util.DataShowPage;

public interface NoticeService {

	public List<NoticeSon> getNotices(int enterpriseId);

	public DataShowPage getNotices(HttpSession session, int pageNum, int pageSize);

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

	public int read(int nid, int uid, long time);
}
