package com.jinmayi.algorithm.tizhi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao7;
import com.jinmayi.entity.DaAn;

public class GJianMingJingShenBing {
	
	public CePingBaoGao7 getJianMingJingShenBing(List<DaAn> daAn) {
		
		CePingBaoGao7 c = new CePingBaoGao7();
		
		int[] fz7 = new int[21];
		for (int i = 1; i < daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz7[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz7[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz7[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz7[i] = 4;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz7[i] = 5;
			} else if (daAn.get(i-1).getDaAn().equals("f")) {
				fz7[i] = 6;
			} else if (daAn.get(i-1).getDaAn().equals("g")) {
				fz7[i] = 7;
			} 
		}
		
		double jiaoLvYouYu = 0;
		double queFaHuoLi = 0;
		double siWeiZhangAi = 0;
		double jiHuoXing = 0;
		double diDuiCaiYi = 0;
		Integer sum = 0;
		
		for(int i=1;i<daAn.size();i++) {
			sum += fz7[i];
		}
		
		jiaoLvYouYu = (fz7[1] + fz7[2] + fz7[5] + fz7[9] + fz7[19] + fz7[20]) * 1.0 / 6;
		queFaHuoLi = (fz7[3] + fz7[13] + fz7[16] + fz7[18] + fz7[19] + fz7[20]) * 1.0 /6;
		siWeiZhangAi = (fz7[4] + fz7[8] + fz7[12] + fz7[15] + fz7[19] + fz7[20]) * 1.0 /6;
		jiHuoXing = (fz7[6] + fz7[7] + fz7[17] + fz7[19] + fz7[20]) * 1.0 / 5;
		diDuiCaiYi = (fz7[10] + fz7[11] + fz7[14] + fz7[19] + fz7[20]) * 1.0 / 5;
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		jiaoLvYouYu = Double.parseDouble(df.format(jiaoLvYouYu));
		queFaHuoLi = Double.parseDouble(df.format(queFaHuoLi));
		siWeiZhangAi = Double.parseDouble(df.format(siWeiZhangAi));
		jiHuoXing = Double.parseDouble(df.format(jiHuoXing));
		diDuiCaiYi = Double.parseDouble(df.format(diDuiCaiYi));
		
		c.setSum(sum);
		c.setJiaoLvYouLv(jiaoLvYouYu);
		c.setQueFaHuoLi(queFaHuoLi);
		c.setSiWeiZhangAi(siWeiZhangAi);
		c.setJiHuoXing(jiHuoXing);
		c.setDiDuiCaiYi(diDuiCaiYi);
		
		return c;
	}

	
	public static void main(String[] args) {
		GJianMingJingShenBing j = new GJianMingJingShenBing();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e","f","g" };
		for (int i = 0; i < 21; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 7;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao7 dd = j.getJianMingJingShenBing(daAns);
		 System.out.println(dd);
	}
	
}
