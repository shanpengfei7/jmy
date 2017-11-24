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
			c.setZhiDaoYiJian("��ǿ��˼ά��ǿ����Ϊ");
		} 
		if ((sum >=6 && sum <= 15) || (siWei>=6 && siWei<=9) || (xingWei>=6 && xingWei<=9)) {
			c.setZhiDaoYiJian("������أ�����������ص�ǿ��֢���ߣ���֢״�Ѿ��Ի��ߵ����ѧϰ��ְҵ��ʼ���һ����Ӱ�죬���ߵ�֢״�����Ż����������ı仯���ϵĲ�����������ܾ���Ľ���������׻ᳯ�����صĳ̶ȷ�չ����������ʱ������Ч���������ʱ�ڣ����龡�����ơ�");
		}
		if ((sum >= 16 && sum <= 25) || (siWei>=10 && siWei<=14) || (xingWei>=10 && xingWei<=14)) {
			c.setZhiDaoYiJian("�ж����أ��������еȵ�ǿ��֢״����ʾ֢״��Ƶ�ʻ����س̶��Ѿ������ѧϰ��ְҵ������Ե��ϰ������»��߿����޷���Чִ����ԭ�еĽ�ɫ���ܣ�������û�г�����Ч�ĸ���ǰ�����ܵ�������֢״������������ɱ��ͷ����������������ƻ���ҩ�����ơ�");
		}
		if(sum > 25 || siWei >=15 || xingWei >=15) {
			c.setZhiDaoYiJian("�ض�����:��ʱ�����ߵ�ǿ��֢״�Ѿ��ǳ����أ���ȫ�޷�ִ��ԭ�еĽ�ɫ���ܣ���������ʳס�е�����ܶ��޷����С�ͨ�������Ѿ��޷����ţ����Լ��������У���ʱ�޿̶���ǿ��˼������ʱ�޿̶���ִ��ǿ����Ϊ���ض����صĻ��߼��׳�������֢״��ͨ����Ҫǿ�����ơ�");
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
