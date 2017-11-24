package com.jmy.util;

import java.text.SimpleDateFormat;

public class TimeFormats {

	public static String changeTime(int time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		return sdf.format(time*1000.0);
	}
}
