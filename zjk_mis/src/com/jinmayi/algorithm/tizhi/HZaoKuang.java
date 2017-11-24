package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao8;
import com.jinmayi.entity.DaAn;

public class HZaoKuang {
	
	public CePingBaoGao8 getZaoKuang(List<DaAn> daAn) {
		
		CePingBaoGao8 c = new CePingBaoGao8();
		
		int[] fz8 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz8[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz8[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz8[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz8[i] = 4;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz8[i] = 5;
			}
		}
		
		Integer sum = 0;
		
		for(int i = 0; i <= daAn.size() ; i++) {
			sum += fz8[i];
		}
		
		c.setSum(sum);
		
		if(sum <= 5) {
			c.setYiJian("ÎÞÃ÷ÏÔÔê¿ñÖ¢×´");
		} else if (sum <= 10) {
			c.setYiJian("ÓÐ¿Ï¶¨Ôê¿ñÖ¢×´");
		} else if (sum <= 22) {
			c.setYiJian("ÖÐ¶ÈÔê¿ñÖ¢×´");
		} else {
			c.setYiJian("ÑÏÖØÔê¿ñÖ¢×´");
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		HZaoKuang z = new HZaoKuang();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 13; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao8 dd = z.getZaoKuang(daAns);
		 System.out.println(dd);
	}

}
