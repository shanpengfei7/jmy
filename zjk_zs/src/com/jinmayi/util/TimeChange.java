package com.jinmayi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeChange {
	/*
	 * 将时间转换为时间戳
	 */
	public static Long dateToStamp(String s)  {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long ts = date.getTime();
		return ts;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(Long s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}
	
	public static String getToday() {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		return dateFormater.format(date);
	}
}
