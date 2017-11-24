package com.jinmayi.algorithm.tizhi;

import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao11;
import com.jinmayi.entity.DaAn;

public class KYinXing {

	public CePingBaoGao11 getYinXing(List<DaAn> daAn) {

		CePingBaoGao11 c = new CePingBaoGao11();

		int qingGanPingDan = 0;
		int siWeiPinFa = 0;
		int yiZhiQueFa = 0;
		int XingQuSheJiao = 0;
		int zhuYiZhangAi = 0;
		int sum = 0;
		int sumCount = 0;

		int[] fz11 = new int[daAn.size() + 1];
		for (int i = 1; i <= daAn.size(); i++) {

			if (daAn.get(i - 1).getDaAn().equals("a")) {
				fz11[i] = 0;
			} else if (daAn.get(i - 1).getDaAn().equals("b")) {
				fz11[i] = 1;
			} else if (daAn.get(i - 1).getDaAn().equals("c")) {
				fz11[i] = 2;
			} else if (daAn.get(i - 1).getDaAn().equals("d")) {
				fz11[i] = 3;
			} else if (daAn.get(i - 1).getDaAn().equals("e")) {
				fz11[i] = 4;
			} else if (daAn.get(i - 1).getDaAn().equals("f")) {
				fz11[i] = 5;
			}
		}

		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s = "";

		// 情感平淡或迟钝
		for (int i = 1; i <= 7; i++) {
			qingGanPingDan += fz11[i];
		}

		c.setQingGanPingDan(qingGanPingDan);

		if (fz11[7] >= 3) {
			s1 = ",情感平淡或迟钝";
			sumCount++;
		}

		// 思维贫乏
		for (int i = 8; i <= 12; i++) {
			siWeiPinFa += fz11[i];
		}

		c.setSiWeiPinFa(siWeiPinFa);

		if (fz11[12] >= 3) {
			s2 = ",思维贫乏";
			sumCount++;
		}

		// 意志缺乏
		for (int i = 13; i <= 16; i++) {
			yiZhiQueFa += fz11[i];
		}

		c.setYiZhiQueFa(yiZhiQueFa);

		if (fz11[16] >= 3) {
			s3 = ",意志缺乏";
			sumCount++;
		}

		// 兴趣社交缺乏
		for (int i = 17; i <= 21; i++) {
			XingQuSheJiao += fz11[i];
		}

		c.setXingQuSheJiao(XingQuSheJiao);

		if (fz11[21] >= 3) {
			s4 = ",兴趣社交缺乏";
			sumCount++;
		}

		// 注意障碍
		for (int i = 22; i <= 24; i++) {
			zhuYiZhangAi += fz11[i];
		}

		c.setZhuYiZhangAi(zhuYiZhangAi);

		if (fz11[24] >= 3) {
			s5 = ",注意障碍";
			sumCount++;
		}

		sum = qingGanPingDan + siWeiPinFa + yiZhiQueFa + XingQuSheJiao
				+ zhuYiZhangAi;
		c.setSum(sum);

		s = s1 + s2 + s3 + s4 + s5;
		s = s.substring(1);

		if (sumCount == 0) {
			c.setShow("无突出阴性症状群");
		} else {
			c.setShow("突出症状群:" + s);
		}

		return c;
	}

	public static void main(String[] args) {
		KYinXing y = new KYinXing();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e", "f" };
		for (int i = 0; i < 24; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 6;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao11 dd = y.getYinXing(daAns);
		System.out.println(dd);
	}
}
