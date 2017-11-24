package com.jmy.timed.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jmy.entity.Enterprise;
import com.jmy.entity.PhoneNoticeWithBLOBs;
import com.jmy.entity.PreTime;
import com.jmy.entity.Tax;
import com.jmy.service.EnterpriseService;
import com.jmy.service.PhoneNoticeService;
import com.jmy.service.PreTimeService;
import com.jmy.service.TaxService;
import com.jmy.util.DateFormatUtil;

@Component
public class PhoneNoticeTask {

	@Resource
	private PhoneNoticeService phoneNoticeService;
	@Resource
	private PreTimeService preTimeService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private TaxService taxService;

	@Scheduled(cron = "0/10 * * * * ? ") // 间隔5秒执行
	public void phoneNotice() {

		System.out.println("---------------------------------------------");

		PhoneNoticeWithBLOBs n = phoneNoticeService.show();

		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		String time = s.format(new Date());
		long timeBetween = DateFormatUtil.timeBetween(time + " " + n.getSendTime(), System.currentTimeMillis());

		if (timeBetween > 0 && timeBetween <= 10) {

			PreTime preTime = preTimeService.getPreTimeByTime(DateFormatUtil.getTime(time));
			if (preTime != null) {
				for (Enterprise e : enterpriseService.getEnterprises()) {
					Tax t = taxService.getTax(e.getId(), preTime.getId());
					if (t == null) {
						long day = (DateFormatUtil.timeBetween(System.currentTimeMillis(),
								DateFormatUtil.getStrTime(preTime.getNowTime()) + " 23:59:59")) / (24 * 60 * 60);
						if (day == 0) {
							System.out.println(e.getPhone() + "   " + e.getId());
						}
					}
				}
			}
		}

	}
}