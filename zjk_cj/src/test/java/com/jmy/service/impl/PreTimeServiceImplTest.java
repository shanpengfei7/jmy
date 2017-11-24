package com.jmy.service.impl;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmy.entity.PreTime;
import com.jmy.service.PreTimeService;
import com.jmy.util.DateFormatUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml" })
public class PreTimeServiceImplTest {

	@Resource
	private PreTimeService preTimeService;

	@Test
	public void test() {
		System.out.println(DateFormatUtil.getStrTime(DateFormatUtil.getTime("2017-05-17")));
	}

	@Test
	public void testList() {
	}

	@Test
	public void testAdd() {
		String lastTime = "2017-01-01";
		String nowTime = "2017-01-02";
		preTimeService.add(lastTime, nowTime);
		System.out.println("ok");
	}

	@Test
	public void testGetPreTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPreTimeByTime() {
		PreTime t = preTimeService.getPreTimeByTime(DateFormatUtil.getTime("2017-05-30"));
		System.out.println(t.getId());
		System.out.println(DateFormatUtil.getStrTime(t.getLastTime()));
		System.out.println(DateFormatUtil.getStrTime(t.getNowTime()));
	}

	@Test
	public void testTime() {
		long start = getTime("2017-6-3 00:00:00");
		long now = System.currentTimeMillis();
		long end = getTime("2017-6-3 23:59:59");
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(start);
		System.out.println(now);
		System.out.println(end);
		System.out.println("------------------------------");
	}

	private Long getTime(String user_time) {
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

	@Test
	public void RegTest() {
		String reg = "([01]?\\d|2[0-3]):[0-5]?\\d:[0-5]?\\d";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher("09:00:00");
		System.out.println(matcher.matches());
	}

	@Test
	public void timeTest() {

		System.out.println(
				(DateFormatUtil.timeBetween("2017-06-08" + " 14:50:00", System.currentTimeMillis())) / (24 * 60 * 60));
	}

}
