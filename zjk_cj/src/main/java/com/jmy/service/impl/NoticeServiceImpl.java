package com.jmy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.NoticeMapper;
import com.jmy.dao.NoticeReadMapper;
import com.jmy.entity.Admi;
import com.jmy.entity.Enterprise;
import com.jmy.entity.Notice;
import com.jmy.entity.NoticeExample;
import com.jmy.entity.NoticeRead;
import com.jmy.entity.NoticeReadExample;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.entity.Swjg;
import com.jmy.entity.son.NoticeReadSon;
import com.jmy.entity.son.NoticeSon;
import com.jmy.service.AdminService;
import com.jmy.service.EnterpriseService;
import com.jmy.service.NoticeService;
import com.jmy.service.SwjgService;
import com.jmy.util.DataShowPage;
import com.jmy.util.DateFormatUtil;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper noticeMapper;
	@Resource
	private NoticeReadMapper noticeReadMapper;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private AdminService adminService;
	@Resource
	private SwjgService swjgService;

	public List<NoticeSon> getNotices(int enterpriseId) {
		NoticeExample ne = new NoticeExample();
		ne.setOrderByClause("id desc");
		Enterprise enterprise = enterpriseService.getEnterpriseById(enterpriseId);
		List<Integer> adminIds = new ArrayList<Integer>();
		Admi admin1 = adminService.getAdminBySwjgDm(enterprise.getSwjgDm());
		if (admin1 != null) {
			adminIds.add(admin1.getId());
			Admi admin2 = adminService.getAdminById(admin1.getpId());
			if (admin2 != null) {
				adminIds.add(admin2.getId());
				Admi admin3 = adminService.getAdminById(admin2.getpId());
				if (admin3 != null) {
					adminIds.add(admin3.getId());
					Admi admin4 = adminService.getAdminById(admin3.getpId());
					if (admin4 != null) {
						adminIds.add(admin4.getId());
					}
				}
			}
		}
		ne.createCriteria().andCreateUserIn(adminIds);
		// 查询数据
		List<NoticeWithBLOBs> list = noticeMapper.selectByExampleWithBLOBs(ne);
		List<NoticeSon> lists = new ArrayList<NoticeSon>();
		if (list.size() > 0) {
			for (NoticeWithBLOBs n : list) {
				NoticeSon no = new NoticeSon();
				if (!isNotice(enterprise.getId(), n.getId())) {
					notice(enterprise.getId(), n.getId());
				}
				no.setId(n.getId());
				no.setTitle(n.getTitle());
				no.setContent(n.getContent());
				no.setCreateTime(n.getCreateTime());
				no.setCreateUser(n.getCreateUser());
				no.setMessage(n.getMessage());
				if (isRead(enterprise.getId(), n.getId())) {
					no.setRead(true);
				} else {
					no.setRead(false);
				}
				lists.add(no);
			}
		}
		return lists;
	}

	public DataShowPage getNotices(HttpSession session, int pageNum, int pageSize) {
		NoticeExample ne = new NoticeExample();
		ne.setOrderByClause("id desc");
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<Integer> adminIds = new ArrayList<Integer>();
		Admi admin1 = adminService.getAdminBySwjgDm(enterprise.getSwjgDm());
		if (admin1 != null) {
			adminIds.add(admin1.getId());
			Admi admin2 = adminService.getAdminById(admin1.getpId());
			if (admin2 != null) {
				adminIds.add(admin2.getId());
				Admi admin3 = adminService.getAdminById(admin2.getpId());
				if (admin3 != null) {
					adminIds.add(admin3.getId());
					Admi admin4 = adminService.getAdminById(admin3.getpId());
					if (admin4 != null) {
						adminIds.add(admin4.getId());
					}
				}
			}
		}
		ne.createCriteria().andCreateUserIn(adminIds);
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<NoticeWithBLOBs> list = noticeMapper.selectByExampleWithBLOBs(ne);
		List<NoticeSon> lists = new ArrayList<NoticeSon>();
		if (list.size() > 0) {
			for (NoticeWithBLOBs n : list) {
				NoticeSon no = new NoticeSon();
				if (!isNotice(enterprise.getId(), n.getId())) {
					notice(enterprise.getId(), n.getId());
				}
				no.setId(n.getId());
				no.setTitle(n.getTitle());
				no.setContent(n.getContent());
				no.setCreateTime(n.getCreateTime());
				no.setCreateUser(n.getCreateUser());
				no.setMessage(n.getMessage());
				if (isRead(enterprise.getId(), n.getId())) {
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
		List<NoticeSon> lists = new ArrayList<NoticeSon>();
		if (list.size() > 0) {
			for (NoticeWithBLOBs n : list) {
				NoticeSon no = new NoticeSon();
				no.setId(n.getId());
				no.setTitle(n.getTitle());
				no.setContent(n.getContent());
				no.setCreateTime(n.getCreateTime());
				no.setCreateUser(n.getCreateUser());
				no.setMessage(n.getMessage());
				Admi admin = adminService.getAdminById(n.getCreateUser());
				if (admin.getRole() == 0) {
					no.setUser("管理员");
				} else {
					if (admin != null) {
						Swjg swjg = swjgService.getSwjgByswjg(admin.getSwjgDm());
						if (swjg != null) {
							no.setUser(swjg.getSwjgmc());
						}
					}
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

	public JSONObject getUnread(int uid) {
		JSONObject json = new JSONObject();
		json.put("status", 0);
		json.put("title", "");
		int count = 0;

		Enterprise e = enterpriseService.getEnterpriseById(uid);
		Admi admin1 = adminService.getAdminBySwjgDm(e.getSwjgDm());
		List<Integer> adminIds = new ArrayList<Integer>();
		if (admin1 != null) {
			adminIds.add(admin1.getId());
			Admi admin2 = adminService.getAdminById(admin1.getpId());
			if (admin2 != null) {
				adminIds.add(admin2.getId());
				Admi admin3 = adminService.getAdminById(admin2.getpId());
				if (admin3 != null) {
					adminIds.add(admin3.getId());
					Admi admin4 = adminService.getAdminById(admin3.getpId());
					if (admin4 != null) {
						adminIds.add(admin4.getId());
					}
				}
			}
		}

		NoticeExample ne = new NoticeExample();
		ne.createCriteria().andCreateUserIn(adminIds);
		List<NoticeWithBLOBs> notices = noticeMapper.selectByExampleWithBLOBs(ne);
		for (NoticeWithBLOBs notice : notices) {
			NoticeReadExample n = new NoticeReadExample();
			n.createCriteria().andUidEqualTo(uid).andNidEqualTo(notice.getId());
			List<NoticeRead> nr = noticeReadMapper.selectByExample(n);
			if (nr.size() == 0) {
				json.put("status", 1);
				json.put("title", notice.getTitle());
				json.put("content", notice.getContent());
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
		n.setCreateTime(System.currentTimeMillis());
		if (n.getCreateUser() == null) {
			n.setCreateUser(0);
		}
		return noticeMapper.insertSelective(n);
	}

	public int edit(NoticeWithBLOBs n) {
		return noticeMapper.updateByPrimaryKeySelective(n);
	}

	public DataShowPage getNoticeReads(int pageNum, int pageSize) {
		NoticeReadExample nre = new NoticeReadExample();
		nre.setOrderByClause("id desc");
		// 设置分页的参数
		PageHelper.startPage(pageNum, pageSize);
		// 查询数据
		List<NoticeRead> list = noticeReadMapper.selectByExample(nre);
		List<NoticeReadSon> lists = new ArrayList<NoticeReadSon>();
		for (NoticeRead n : list) {
			NoticeReadSon nr = new NoticeReadSon();
			nr.setNid(n.getNid());
			nr.setUid(n.getUid());
			Enterprise e = enterpriseService.getEnterpriseById(n.getUid());
			if (e != null) {
				nr.setUser(e.getName());
			}
			if (n.getCreateTime() != null) {
				nr.setCreateTimeStr(DateFormatUtil.getStrTime(n.getCreateTime()));
			} else {
				nr.setCreateTimeStr("");
			}
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
		NoticeReadExample n = new NoticeReadExample();
		n.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		List<NoticeRead> nr = noticeReadMapper.selectByExample(n);
		if (nr.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRead(int uid, int nid) {
		NoticeReadExample n = new NoticeReadExample();
		n.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		List<NoticeRead> nr = noticeReadMapper.selectByExample(n);
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
		NoticeRead n = new NoticeRead();
		n.setUid(uid);
		n.setNid(nid);
		return noticeReadMapper.insertSelective(n);
	}

	public int read(int nid, int uid, long time) {
		NoticeRead n = new NoticeRead();
		n.setCreateTime(time);
		NoticeReadExample ne = new NoticeReadExample();
		ne.createCriteria().andUidEqualTo(uid).andNidEqualTo(nid);
		return noticeReadMapper.updateByExampleSelective(n, ne);
	}
}
