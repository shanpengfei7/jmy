package com.jinmayi.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class NFDFlightDataTimerTask extends TimerTask {

	private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);

	@Override
	public void run() {
		try {
			// 在这里写你要执行的内容
			// new YiYuanDao().qingLingTodayCount();
			// public void qingLingTodayCount(){
			 String sql = "update yi_yuan set todayCount = 0";
			// update(sql, 0);
			//
			// }

			Connection con = null;
			try {
				con = new ComboPooledDataSource("loginpnfy").getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.execute();
			
		} catch (Exception e) {
			log.info("-------------解析信息发生异常--------------");
		}
	}
}
