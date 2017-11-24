package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao13;
import com.jinmayi.entity.DaAn;

public class MQiangPo {

	public CePingBaoGao13 getQiangPo(List<DaAn> daAn) {

		CePingBaoGao13 c = new CePingBaoGao13();
		
		int[] fz13 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz13[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz13[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz13[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz13[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz13[i] = 4;
			}
		}
		int siWei = 0;
		int xingWei = 0;
		int sum = 0;
		
		for(int i = 1 ; i <= 5 ; i++) {
			siWei += fz13[i];
		}
		for(int i = 6 ; i <= 10 ; i++) {
			xingWei += fz13[i];
		}
		
		sum = siWei + xingWei;
		
		c.setSiWei(siWei);
		c.setXingWei(xingWei);
		c.setSum(sum);
		
		if(sum <= 5) {
			c.setZhiDaoYiJian("无强迫思维与强迫行为");
		} 
		if ((sum >=6 && sum <= 15) || (siWei>=6 && siWei<=9) || (xingWei>=6 && xingWei<=9)) {
			c.setZhiDaoYiJian("轻度严重：处于轻度严重的强迫症患者，其症状已经对患者的生活、学习或职业开始造成一定的影响，患者的症状会随着环境和情绪的变化不断的波动，如果不能尽早的解决，很容易会朝着严重的程度发展、泛化，此时是治疗效果最理想的时期，建议尽早治疗。");
		}
		if ((sum >= 16 && sum <= 25) || (siWei>=10 && siWei<=14) || (xingWei>=10 && xingWei<=14)) {
			c.setZhiDaoYiJian("中度严重：这属于中等的强迫症状，表示症状的频率或严重程度已经对生活、学习或职业造成明显的障碍，导致患者可能无法有效执行其原有的角色功能，甚至在没有出现有效的改善前，可能导致抑郁症状，甚至出现自杀念头，必须接受心理治疗或者药物治疗。");
		}
		if(sum > 25 || siWei >=15 || xingWei >=15) {
			c.setZhiDaoYiJian("重度严重:此时，患者的强迫症状已经非常严重，完全无法执行原有的角色功能，甚至连衣食住行等生活功能都无法进行。通常患者已经无法出门，将自己禁锢家中，无时无刻都有强迫思考，无时无刻都在执行强迫行为。重度严重的患者极易出现抑郁症状，通常需要强制治疗。");
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		MQiangPo q = new MQiangPo();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 10; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao13 dd = q.getQiangPo(daAns);
		 System.out.println(dd);
	}
	
}
