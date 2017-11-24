package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao10;
import com.jinmayi.entity.DaAn;

public class JChangGuChuanChiDai {
	
	public CePingBaoGao10 getChangGuChuanChiDai(List<DaAn> daAn) {
		
		CePingBaoGao10 c = new CePingBaoGao10();
		
		double[] fz10 = new double[12];
		double sum = 0.0f;
		
		if (daAn.get(0).getDaAn().equals("a")) {
			fz10[1] = 0;
		} else {
			fz10[1] = 3;
		}
		
		if (daAn.get(1).getDaAn().equals("a")) {
			fz10[2] = 0;
		} else {
			fz10[2] = 2.5;
		}
		
		if (daAn.get(2).getDaAn().equals("a")) {
			fz10[3] = 0;
		} else {
			fz10[3] = 2;
		}
		
		if (daAn.get(3).getDaAn().equals("a")) {
			fz10[4] = 0;
		} else {
			fz10[4] = 2.5;
		}
		
		if (daAn.get(4).getDaAn().equals("a")) {
			fz10[5] = 0;
		} else {
			fz10[5] = 2;
		}
		
		if (daAn.get(5).getDaAn().equals("a")) {
			fz10[6] = 0;
		} else {
			fz10[6] = 3.5;
		}
		
		if (daAn.get(6).getDaAn().equals("a")) {
			fz10[7] = 0;
		} else {
			fz10[7] = 2.5;
		}
		
		if (daAn.get(7).getDaAn().equals("a")) {
			fz10[8] = 0;
		} else {
			fz10[8] = 3;
		}
		
		if (daAn.get(8).getDaAn().equals("a")) {
			fz10[9] = 0;
		} else if (daAn.get(8).getDaAn().equals("b")){
			fz10[9] = 2;
		} else if (daAn.get(8).getDaAn().equals("c")){
			fz10[9] = 4;
		}
		
		if (daAn.get(9).getDaAn().equals("a")) {
			fz10[10] = 0;
		} else if (daAn.get(9).getDaAn().equals("b")){
			fz10[10] = 2;
		} else if (daAn.get(9).getDaAn().equals("c")){
			fz10[10] = 4;
		}
		
		if (daAn.get(10).getDaAn().equals("a")) {
			fz10[11] = 0;
		} else if (daAn.get(10).getDaAn().equals("b")){
			fz10[11] = 0.5;
		} else if (daAn.get(10).getDaAn().equals("c")){
			fz10[11] = 1.5;
		} else if (daAn.get(10).getDaAn().equals("d")) {
			fz10[11] = 2.5;
		} else if (daAn.get(10).getDaAn().equals("e")){
			fz10[11] = 3.5;
		} 
		
		for(int i = 1; i <= daAn.size() ; i++) {
			sum += fz10[i];
		}
		
		c.setSum(sum);
		
		if(sum <= 10.0) {
			c.setBelong("³Õ´ô");
		} else if (sum <= 21.5) {
			c.setBelong("¿ÉÒÉ³Õ´ô");
		} else if (sum <= 30.5) {
			c.setBelong("±ßÔµ×´Ì¬");
		} else {
			c.setBelong("Õý³£");
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		JChangGuChuanChiDai c = new JChangGuChuanChiDai();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b"};
		for (int i = 0; i < 8; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 2;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}
		
		String[] aaa = {"a","b","c"};
		for (int i = 8; i < 10; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 3;
			d.setDaAn(aaa[a]);
			daAns.add(d);
		}
		
		String[] aaaa = {"a","b","c","d","e"};
		DaAn d = new DaAn();
		d.setTiHao(11);
		int a = (int) (Math.random() * 10000) % 5;
		d.setDaAn(aaaa[a]);
		daAns.add(d);

		CePingBaoGao10 dd = c.getChangGuChuanChiDai(daAns);
		 System.out.println(dd);
	}

}
