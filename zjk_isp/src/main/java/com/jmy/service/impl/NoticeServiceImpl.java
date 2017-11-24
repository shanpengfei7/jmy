package com.jmy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.NoticeMapper;
import com.jmy.dao.NoticereadMapper;
import com.jmy.domain.NoticeDoMain;
import com.jmy.domain.NoticeReadDoMain;
import com.jmy.entity.Notice;
import com.jmy.entity.NoticeExample;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.entity.Noticeread;
import com.jmy.entity.NoticereadExample;
import com.jmy.service.AdminService;
import com.jmy.service.NoticeService;
import com.jmy.util.DataShowPage;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;
	@Resource
	private NoticereadMapper noticereadMapper;
	@Resource
	private AdminService adminService;

	public DataShowPage getNotices(int uid, int pageNum, int pageSize) {
		NoticeExample ne = new NoticeExample();
		ne.setOrderByClause("id desc");
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<NoticeWithBLOBs> list = noticeMapper.selectByExampleWithBLOBs(ne);
		List<NoticeDoMain> lists = new ArrayList<NoticeDoMain>();
		if (list.size() > 0) {
			for (NoticeWithBLOBs n : list) {
				NoticeDoMain no = new NoticeDoMain();
				if (!isNotice(uid, n.getId())) {
					notice(uid, n.getId());
				}
				no.setId(n.getId());
				no.setTitle(n.getTitle());
				no.setContent(n.getContent());
				no.setCreateTime(n.getCreateTime());
				no.setCreateUser(n.getCreateUser());
				no.setMessage(n.getMessage());
				if (isRead(uid, n.getId())) {
					no.setRead(true);
				} else {
					no.setRead(false);
				}
				lists.add(no);
			}
		}

		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(lists);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;

	}

	public DataShowPage getNotices(int pageNum, int pageSize, String title) {
		NoticeExample ne = new NoticeExample();
		if (!"".equals(title) && !"".equals(title.trim())) {
			ne.createCriteria().andTitleLike("%" + title.trim() + "%");
		}
		ne.setOrderByClause("id desc");
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<NoticeWithBLOBs> list = noticeMapper.selectByExampleWithBLOBs(ne);
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(list);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public JSONObject getUnread(int uid) {
		JSONObject json = new JSONObject();
		json.put("status", 0);
		json.put("title", "");
		int count = 0;
		List<Notice> notices = noticeMapper.selectByExample(null);
		for (Notice notice : notices) {
			NoticereadExample n = new NoticereadExample();
			n.createCriteria().andUidEqualTo(uid).andNidEqualTo(notice.getId());
			List<Noticeread> nr = noticereadMapper.selectByExample(n);
			if (nr.size() == 0) {
				json.put("status", 1);
				json.put("title", notice.getTitle());
				notice(uid, notice.getId());
				count++;
			} else {
				if (nr.get(0).getCreateTime() == null) {
					count++;
				}
			}
		}
		json.put("count", count);
		return json;
	}

	public NoticeWithBLOBs getNotice(int id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	public int save(NoticeWithBLOBs n) {
		n.setCreateTime((int) (System.currentTimeMillis() / 1000));
		if (n.getCreateUser() == null) {
			n.setCreateUser(0);
		}
		return noticeMapper.insertSelective(n);
	}

	public int edit(NoticeWithBLOBs n) {
		return noticeMapper.updateByPrimaryKeySelective(n);
	}

	public DataShowPage getNoticeReads(int pageNum, int pageSize) {
		NoticereadExample nre = new NoticereadExample();
		nre.setOrderByClause("id desc");
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<Noticeread> list = noticereadMapper.selectByExample(nre);
		List<NoticeReadDoMain> lists = new ArrayList<NoticeReadDoMain>();
		for (Noticeread n : list) {
			NoticeReadDoMain nr = new NoticeReadDoMain();
			nr.setNid(n.getNid());
			nr.setUid(n.getUid());
			Notice notice = noticeMapper.selectByPrimaryKey(n.getNid());
			nr.setNoticeTitle(notice.getTitle());

			lists.add(nr);
		}
		// 创建一个返回值对象
		DataShowPage page = new DataShowPage();
		page.setRows(lists);

		page.setNow(pageNum);
		page.setSize(pageSize);

		// 取记录总条数
		PageInfo pageInfo = new PageInfo(list);
		page.setTotal(pageInfo.getTotal());

		return page;
	}

	public boolean isNotice(int uid, int nid) {
		NoticereadExample n = new NoticereadExample();
		n.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		List<Noticeread> nr = noticereadMapper.selectByExample(n);
		if (nr.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRead(int uid, int nid) {
		NoticereadExample n = new NoticereadExample();
		n.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		List<Noticeread> nr = noticereadMapper.selectByExample(n);
		if (nr.size() > 0) {
			if (nr.get(0).getCreateTime() != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int notice(int uid, int nid) {
		Noticeread n = new Noticeread();
		n.setUid(uid);
		n.setNid(nid);
		return noticereadMapper.insertSelective(n);
	}

	public int read(int nid, int uid, int time) {
		Noticeread n = new Noticeread();
		n.setCreateTime(time);
		NoticereadExample ne = new NoticereadExample();
		ne.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		return noticereadMapper.updateByExampleSelective(n, ne);
	}
}
