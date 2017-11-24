package com.jinmayi.download;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.jinmayi.entity.Qrcode;

public class FileTest {
	
	@Test
	public void cba() {
		File f = new File("c:\\abcd.txt");
		f.delete();
	}

	@Test
	public void abc() {
		File f = new File("c:\\abcd.txt");
		String str = "abc";
		List<Qrcode> qrcodes = new ArrayList<Qrcode>();
		Qrcode q = null;
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		try {
			for (Qrcode qrcode : qrcodes) {
				writeTxtFile(qrcode.getQrcode() + "\r\n", f);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName, true);
			o.write(content.getBytes("utf-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Test
	public void abcd() {
		for(int i = 0; i < 20000; i++) {
			int a = new Random().nextInt(99999999);
			if(a < 100000)
			System.out.println(a);
		}
	}
}
