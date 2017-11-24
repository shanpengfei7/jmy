package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao12;
import com.jinmayi.entity.DaAn;

public class LYangXing {

	public CePingBaoGao12 getYangXing(List<DaAn> daAn) {
		
		CePingBaoGao12 c = new CePingBaoGao12();
		
		int[] fz12 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz12[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz12[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz12[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz12[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz12[i] = 4;
			} else if (daAn.get(i-1).getDaAn().equals("f")) {
				fz12[i] = 5;
			}
		}
		
		String s = "";
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";

		int huanJue = 0;
		int wangXiang = 0;
		int guaiYiXingWei = 0;
		int yangXingSiwei = 0;
		int sum = 0;
		int sumCount =0 ;
		
		
		//幻觉
		for(int i = 1 ; i <= 7 ; i++) {
			huanJue += fz12[i];
		}
		
		c.setHuanJue(huanJue);
		
		if(fz12[7] >= 3) {
			s1 = ",幻觉";
			sumCount++;
		} 
		
		//妄想
		for(int i = 8 ; i <= 20 ; i++) {
			wangXiang += fz12[i];
		}
		
		c.setWangXiang(wangXiang);
		
		if(fz12[20] >= 3) {
			s2 = ",妄想";
			sumCount++;
		} 
		
		//怪异行为
		for(int i = 21 ; i <= 25 ; i++) {
			guaiYiXingWei += fz12[i];
		}
		
		c.setGuaiYiXingWei(guaiYiXingWei);
		
		if(fz12[25] >= 3) {
			s3 = ",怪异行为";
			sumCount++;
		} 
		
		//阳性思维形式障碍
		for(int i = 26 ; i <= 34 ; i++) {
			yangXingSiwei += fz12[i];
		}
		
		c.setYangXingSiWei(yangXingSiwei);
		
		if(fz12[34] >= 3) {
			s4 = "阳性思维形式障碍";
			sumCount++;
		}
		
		sum = huanJue + wangXiang + guaiYiXingWei + yangXingSiwei;
		
		c.setSum(sum);
		
		s = s1  + s2  + s3  + s4;
		s = s.substring(1);
		
		if(sumCount == 0) {
			c.setShow("无突出阳性症状群");
		} else {
			c.setShow("突出症状群为:" + s);
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		LYangXing y = new LYangXing();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e","f" };
		for (int i = 0; i < 34; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 6;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao12 dd = y.getYangXing(daAns);
		 System.out.println(dd);
	}
}
