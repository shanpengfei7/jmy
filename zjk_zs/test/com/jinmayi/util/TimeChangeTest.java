package com.jinmayi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TimeChangeTest {

	@Test
	public void testDateToStamp() {
		System.out.println(TimeChange.dateToStamp("2016-10-22 00:00:00"));
		System.out.println(TimeChange.dateToStamp("2016-10-22 23:59:59"));
	}

	@Test
	public void testStampToDate() {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		System.out.print(dateFormater.format(date));
	}
	
	@Test
	public void testTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}

}
