package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao9;
import com.jinmayi.entity.DaAn;

public class IChiDaiJianYiShaiCha {

	public CePingBaoGao9 getChiDaiJianYiShaiCha(List<DaAn> daAn) {
		
		CePingBaoGao9 c = new CePingBaoGao9();
		
		int flag = 0;
		
		int[] fz9 = new int[daAn.size()+1];
		
		
		if (daAn.get(0).getDaAn().equals("a")) {
			flag = 0;
		} else if (daAn.get(0).getDaAn().equals("b")) {
			flag = 1;
		} else if (daAn.get(0).getDaAn().equals("c")) {
			flag = 2;
		}
		
		
		
		for (int i = 1; i < daAn.size(); i++) {
		
			if (daAn.get(i).getDaAn().equals("a")) {
				fz9[i] = 0;
			} else if (daAn.get(i).getDaAn().equals("b")) {
				fz9[i] = 1;
			} 
		}
		
		int sum = 0;
		
		for(int i = 1 ; i < daAn.size() ; i++) {
			sum += fz9[i];
		}
		
		if (flag == 0) {
			c.setSum(sum);
			if(sum < 16) {
				c.setYiJian("测试者智力障碍");
			} else {
				c.setYiJian("测试者智力正常");
			}
		} else if (flag == 1) {
			c.setSum(sum);
			if (sum < 19) {
				c.setYiJian("测试者智力障碍");
			} else {
				c.setYiJian("测试者智力正常");
			}
		} else if (flag == 2) {
			c.setSum(sum);
			if (sum < 22) {
				c.setYiJian("测试者智力障碍");
			} else {
				c.setYiJian("测试者智力正常");
			}
		}
		
		
		
		return c;
	}
	
	public static void main(String[] args) {
		IChiDaiJianYiShaiCha c = new IChiDaiJianYiShaiCha();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aaa = { "a", "b", "c"};
		DaAn d = new DaAn();
		d.setTiHao(1);
		int a = (int) (Math.random() * 10000) % 3;
		d.setDaAn(aaa[a]);
		daAns.add(d);
		
		String[] aa = { "a", "b"};
		
		for (int i = 0; i < 31; i++) {
			d = new DaAn();
			d.setTiHao(i + 1);
			a = (int) (Math.random() * 10000) % 2;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao9 dd = c.getChiDaiJianYiShaiCha(daAns);
		 System.out.println(dd);
	}
	
}
