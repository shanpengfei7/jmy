package com.jmy.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JavaTest {

	@Test
	public void testJson() {
		JSONArray js = new JSONArray();
		for (int i = 0; i < 5; i++) {
			JSONObject j = new JSONObject();
			j.put("q" + i, "q" + i);
			j.put("w" + i, "w" + i);
			j.put("e" + i, "e" + i);
			j.put("r" + i, "r" + i);
			j.put("t" + i, "t" + i);
			js.add(j);
		}
		System.out.println(js);
	}

	@Test
	public void testEmail() {
		Properties prop = new Properties();
		try {
			String relativelyPath=Class.class.getClass().getResource("/").getPath();
			System.out.println(relativelyPath);
			// 读取属性文件a.properties
			InputStream in = new BufferedInputStream(new FileInputStream("email.properties"));
			prop.load(in); /// 加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println(key + ":" + prop.getProperty(key));
			}
			in.close();

//			/// 保存属性到b.properties文件
//			FileOutputStream oFile = new FileOutputStream("b.properties", true);// true表示追加打开
//			prop.setProperty("phone", "10086");
//			prop.store(oFile, "The New properties file");
//			oFile.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
//	public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String name, String verify) throws Exception {
//		
//		 String sendPserson = "";
//		 String title = "";
//		 String verify_before = "";
//		 String verify_after = "";
//		 Properties prop = new Properties();
//			try {
//				// 读取属性文件a.properties
//				InputStream in = new BufferedInputStream(new FileInputStream("email.properties"));
//				prop.load(in); /// 加载属性列表
//				Iterator<String> it = prop.stringPropertyNames().iterator();
//				while (it.hasNext()) {
//					String key = it.next();
//					System.out.println(key + ":" + prop.getProperty(key));
//					if("sendPserson".equals(key)) {
//						sendPserson=prop.getProperty(key);
//					} else if("title".equals(key)) {
//						title=prop.getProperty(key);
//					} else if("verify_before".equals(key)) {
//						verify_before=prop.getProperty(key);
//					} else if("verify_after".equals(key)) {
//						verify_after=prop.getProperty(key);
//					}
//				}
//				in.close();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		
//		// 1. 创建一封邮件
//		MimeMessage message = new MimeMessage(session);
//
//		// 2. From: 发件人
//		message.setFrom(new InternetAddress(sendMail, sendPserson, "UTF-8"));
//
//		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
//		message.setRecipient(RecipientType.TO, new InternetAddress(receiveMail, name, "UTF-8"));
//
//		// 4. Subject: 邮件主题
//		message.setSubject(title, "UTF-8");
//		String content = "<style type='text/css'>.p{text-indent: 2em;}</style>" + name + "，您好：<br /><div class='p'>您于" + getStringDate() 
//		+ verify_before	+verify+verify_after;
//		// 5. Content: 邮件正文（可以使用html标签）
//		message.setContent(content, "text/html;charset=UTF-8");
//
//		// 6. 设置发件时间
//		message.setSentDate(new Date());
//
//		// 7. 保存设置
//		message.saveChanges();
//
//		return message;
//	}
}
