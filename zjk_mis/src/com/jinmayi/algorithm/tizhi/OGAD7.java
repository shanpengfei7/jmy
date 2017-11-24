package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao15;
import com.jinmayi.entity.DaAn;

public class OGAD7 {
	
	public CePingBaoGao15 getGAD7(List<DaAn> daAn) {
		
		CePingBaoGao15 c = new CePingBaoGao15();
		
		Integer sum = 0;
		
		int[] fz15 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz15[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz15[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz15[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz15[i] = 3;
			} 
			
		}
		
		
		for(int i = 1 ; i <= daAn.size() ; i++) {
			sum += fz15[i];
		}
		c.setSum(sum);
		
		if(sum <= 5) {
			c.setBelong("轻度");
		} else if ( sum <= 10) {
			c.setBelong("中度");
		} else {
			c.setBelong("重度");
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		OGAD7 g = new OGAD7();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d"};
		for (int i = 0; i < 7; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 4;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao15 dd = g.getGAD7(daAns);
		 System.out.println(dd);
	}
}
