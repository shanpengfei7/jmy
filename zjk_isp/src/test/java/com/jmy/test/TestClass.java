package com.jmy.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.jmy.util.JavaEmeilSend;

public class TestClass {

	@Test
	public void testSplit() {
		String aa = "asdf.jpg";
		int bb = aa.lastIndexOf(".");
		String cc = aa.substring(bb);
		System.out.println(cc);
	}
	@Test
	public void testSplitStr() {
		String aa = "asdf.jpg";
		String[] bb = aa.split(",");
		System.out.println(bb.length);
	}

	@Test
	public void testTime() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +1);
		long a = calendar.getTimeInMillis();
		int b = (int) (a / 1000);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		// 例如：cc_time=1291778220
		long lcc_time = Long.valueOf(b);

		System.out.println(sdf.format(new Date(lcc_time * 1000L)));
	}
	
	@Test
	public void testTimeChange() {
		long time1= System.currentTimeMillis();
		System.out.println(time1);
		int time2 = (int)(time1/1000);
		System.out.println(time2);
		System.out.println((int)time1/1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		System.out.println(time2*1000.0);
		System.out.println(sdf.format(time2*1000.0));
	}
//	@Test
//	public void testChangeTime() {
//		System.out.println(TimeFormat.changeTime((int)(System.currentTimeMillis()/1000)));
//	}
	
	@Test
	public void testSend() {
		try {
			JavaEmeilSend.sendEmail("269247831@qq.com", "单鹏飞", "123852");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCon() {
		System.out.println("".indexOf("aa"));
	}
}
