package com.jmy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	// 将字符串转为时间戳

	public static Long getAllTime(String user_time) {
		Long re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {

			d = sdf.parse(user_time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = Long.valueOf(str);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re_time;
	}
	// 将字符串转为时间戳

	public static Long getTime(String user_time) {
		Long re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			user_time = user_time + " 23:59:59";
			d = sdf.parse(user_time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = Long.valueOf(str);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re_time;
	}

	// 将时间戳转为字符串
	public static String getStrTime(Long cc_time) {
		String re_StrTime = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 例如：cc_time=1291778220
		re_StrTime = sdf.format(new Date(cc_time));

		return re_StrTime;

	}

	// 两个时间相差的秒数
	public static long timeBetween(String startTime, long endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		long time1 = 0;
		long time2 = 0;

		try {
			cal.setTime(sdf.parse(startTime));
			time1 = cal.getTimeInMillis();
			// cal.setTime(sdf.parse(endTime));
			time2 = endTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (time2 - time1) / 1000;

	}

	// 两个时间相差的秒数
	public static long timeBetween(long startTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		long time1 = 0;
		long time2 = 0;

		try {
			// cal.setTime(sdf.parse(startTime));
			time1 = startTime;
			cal.setTime(sdf.parse(endTime));
			time2 = cal.getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (time2 - time1) / 1000;

	}

	/**
	 * * 获取指定日期是星期几
	 * 
	 * 参数为null时表示获取当前日期是星期几
	 * 
	 * @param date
	 * 
	 * @return
	 * 
	 */

	public static String getWeekOfDate(Long millis) {

		String[] weekOfDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		Calendar calendar = Calendar.getInstance();

		if (millis != null) {

			calendar.setTimeInMillis(millis);

		}

		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		if (w < 0) {

			w = 0;

		}

		return weekOfDays[w];

	}

}
