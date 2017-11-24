package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao14;
import com.jinmayi.entity.DaAn;

public class NPHQ9 {
	
	public CePingBaoGao14 getPHQ9(List<DaAn> daAn) {
		
		CePingBaoGao14 c = new CePingBaoGao14();
		int sum = 0;
		String zhuYi = "";
		String zhuYi1 = "";
		String zhuYi2 = "";
		
		int[] fz14 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz14[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz14[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz14[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz14[i] = 3;
			} 
		}
		for(int i = 1; i <= daAn.size() ; i++) {
			sum += fz14[i];
		}
		c.setSum(sum);
		
		if(sum <= 4) {
			c.setYiJian("û������");
			c.setJianYi("ע�����ұ���");
		} else if (sum <= 9) {
			c.setYiJian("��������΢����");
			c.setJianYi("������ѯ����ҽ��������ҽѧ������");
		} else if (sum <= 14) {
			c.setYiJian("�������ж�����");
			c.setJianYi("�����ѯ����ҽ��������ҽѧ������");
		} else if ( sum <= 19) {
			c.setYiJian("���������ض�����");
			c.setJianYi("������ѯ����ҽ�������ҽ��");
		} else {
			c.setYiJian("�������ض�����");
			c.setJianYi("һ��Ҫ������ҽ�������ҽ��");
		}
		
		if(fz14[1] > 1 || fz14[4] > 1 || fz14[9] > 1) {
			zhuYi1 = "��Ҫ��ע,";
		}
		
		if((fz14[1] > 1 || fz14[4] > 1) && fz14[9] < 1) {
			zhuYi2 = "�������ĺ���֢״";
		} else if((fz14[1] < 1 && fz14[4] < 1) && fz14[9] > 1) {
			zhuYi2 = "����������";
		} else if((fz14[1] > 1 || fz14[4] > 1) && fz14[9] > 1){
			zhuYi2 = "�������ĺ���֢״������������";
		}
		
		zhuYi = zhuYi1 + zhuYi2;
		
		c.setJianYi(c.getJianYi() + "," + zhuYi);
		
		return c;
	}

	
	public static void main(String[] args) {
		NPHQ9 p = new NPHQ9();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d"};
		for (int i = 0; i < 9; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 4;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao14 dd = p.getPHQ9(daAns);
		 System.out.println(dd);
	}
	
}
