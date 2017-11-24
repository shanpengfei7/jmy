package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao3;
import com.jinmayi.entity.DaAn;

public class CHanMiDunYiYu {
	
	public CePingBaoGao3 getHanMiDunYiYu(List<DaAn> daAn) {
		int[] fz3 = new int[daAn.size()+1];
		
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz3[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz3[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz3[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz3[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz3[i] = 4;
			}
		}
		
		CePingBaoGao3 c = new CePingBaoGao3();
		
		int result = 0;
		
		for(int i = 1 ; i <= 24 ; i++) {
			result += fz3[i];
		}
		c.setResult(result);
		
		if(result <= 7) {
			c.setBelong("ÎÞÒÖÓôÖ¢×´");
			c.setFlag(18);
		} else if(result <= 19) {
			c.setBelong("Çá¶ÈÒÖÓô");
			c.setFlag(19);
		} else if(result <= 34) {
			c.setBelong("ÖÐ¶ÈÒÖÓô");
			c.setFlag(20);
		} else {
			c.setBelong("ÖØ¶ÈÒÖÓô");
			c.setFlag(21);
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		CHanMiDunYiYu hy = new CHanMiDunYiYu();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 60; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao3 dd = hy.getHanMiDunYiYu(daAns);
		 System.out.println(dd);
		 System.out.println(System.currentTimeMillis()-start);
	}
}
