package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao2;
import com.jinmayi.entity.DaAn;

public class BHanMiDunJiaoLv {
	
	public CePingBaoGao2 getHanMiDun(List<DaAn> daAn) {
		
		int[] fz2 = new int[daAn.size()+1];
		
		for(int i = 1; i <= daAn.size(); i++) {
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz2[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz2[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz2[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz2[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz2[i] = 4;
			}
		}
		
		int sum = 0;
		for(int i = 1; i < daAn.size()+1 ; i++) {
			sum += fz2[i];
		}
		
		
		CePingBaoGao2 c = new CePingBaoGao2();
		
		c.setResult(sum);
		
		if(sum <= 7) {
			c.setBelong("ÎÞ½¹ÂÇÖ¢×´");
			c.setFlag(10);
		} else if(sum <= 14) {
			c.setBelong("Çá½¹ÂÇÖ¢");
			c.setFlag(11);
		} else if(sum <= 21) {
			c.setBelong("Çá¡ª¡ªÖÐ¶È½¹ÂÇ");
			c.setFlag(12);
		} else if(sum <= 28) {
			c.setBelong("ÖÐ¶È½¹ÂÇ");
			c.setFlag(13);
		} else if(sum <= 35) {
			c.setBelong("ÖÐ¡ª¡ªÖØ¶È½¹ÂÇ");
			c.setFlag(14);
		} else {
			c.setBelong("ÖØ¶È½¹ÂÇ");
			c.setFlag(15);
		}
		
		
		return c;
	}

	
	public static void main(String[] args) {
		BHanMiDunJiaoLv h = new BHanMiDunJiaoLv();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 15; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao2 dd = h.getHanMiDun(daAns);
		 System.out.println(dd);
	}
}
