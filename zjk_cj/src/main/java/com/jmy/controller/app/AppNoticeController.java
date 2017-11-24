package com.jmy.controller.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.NoticeWithBLOBs;
import com.jmy.entity.son.NoticeSon;
import com.jmy.service.NoticeService;
import com.jmy.util.DateFormatUtil;
import com.jmy.util.HTMLSpirit;

@Controller
@RequestMapping("/app/notice")
public class AppNoticeController {

	@Resource
	private NoticeService noticeService;

	private JSONObject json = new JSONObject();

	@RequestMapping("/list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "") int enterpriseId) {
		json.clear();
		List<NoticeSon> notices = noticeService.getNotices(enterpriseId);

		JSONArray js = new JSONArray();

		for (NoticeSon n : notices) {
			JSONObject j = new JSONObject();
			j.put("id", n.getId());
			j.put("content", HTMLSpirit.delHTMLTag(n.getContent()));
			j.put("time", DateFormatUtil.getStrTime(n.getCreateTime()));
			j.put("read", n.isRead());
			js.add(j);
		}
		json.put("status", 1);
		json.put("error", "");
		json.put("data", js);
		return json;
	}

	@RequestMapping("/show")
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") int noticeId,
			@RequestParam(defaultValue = "") int enterpriseId) {
		json.clear();
		NoticeWithBLOBs n = noticeService.getNotice(noticeId);
		int r = noticeService.read(noticeId, enterpriseId, System.currentTimeMillis());
		if (r > 0 && n != null) {
			json.put("status", 1);
			json.put("error", "");
			json.put("id", n.getId());
			json.put("content", HTMLSpirit.delHTMLTag(n.getContent()));
			json.put("time", DateFormatUtil.getStrTime(n.getCreateTime()));
		} else {
			json.put("status", 0);
			json.put("error", "没有消息");
		}
		return json;
	}

}
