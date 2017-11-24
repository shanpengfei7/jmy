package com.jmy.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.entity.PreTime;
import com.jmy.entity.Tax;
import com.jmy.entity.TimeNoticeWithBLOBs;
import com.jmy.service.EnterpriseService;
import com.jmy.service.PreTimeService;
import com.jmy.service.TaxService;
import com.jmy.service.TimeNoticeService;
import com.jmy.util.DateFormatUtil;
import com.jmy.util.JsonOutput;

@Controller
@RequestMapping("/user/timenotice")
public class UserTimeNoticeController {

	@Resource
	private TimeNoticeService timeNoticeService;
	@Resource
	private PreTimeService preTimeService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private TaxService taxService;

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public void notice(HttpServletResponse response, HttpSession session) {
		JSONObject json = new JSONObject();
		TimeNoticeWithBLOBs n = timeNoticeService.show();

		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		String time = s.format(new Date());
		long timeBetween = DateFormatUtil.timeBetween(time + " " + n.getSendTime(), System.currentTimeMillis());

		if (timeBetween > 0 && timeBetween < 100) {

			PreTime preTime = preTimeService.getPreTimeByTime(DateFormatUtil.getTime(time));
			if (preTime != null) {
				Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
				Tax t = taxService.getTax(enterprise.getId(), preTime.getId());
				if (t == null) {
					json.put("title", n.getTitle());
					if (n.getIsTime() == 1) {
						long day = (DateFormatUtil.timeBetween(System.currentTimeMillis(),
								DateFormatUtil.getStrTime(preTime.getNowTime()) + " 23:59:59")) / (24 * 60 * 60);
						if (day == 0) {
							json.put("content", n.getContent() + "今天是最后一天上报时间");
						} else {
							json.put("content", n.getContent() + "距离上报截止还有" + day + "天时间");
						}
					} else {
						json.put("content", n.getContent());
					}
					JsonOutput.out(response, json);
				}
			}

		}
	}

}
