package com.jinmayi.algorithm.tizhi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao1;
import com.jinmayi.entity.DaAn;


public class ATiZhi {

	public CePingBaoGao1 getTiZhi(List<DaAn> daAn) {

		int[] fz1 = new int[daAn.size()+1];
		fz1[0] = 0;
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz1[i] = 1;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz1[i] = 2;
			} else if (daAn.get(i-1).getDaAn().equals("c")) {
				fz1[i] = 3;
			} else if (daAn.get(i-1).getDaAn().equals("d")) {
				fz1[i] = 4;
			} else if (daAn.get(i-1).getDaAn().equals("e")) {
				fz1[i] = 5;
			}
		}

		int pinghe0 = 0;
		int qixu0 = 0;
		int yangxu0 = 0;
		int yinxu0 = 0;
		int tanshi0 = 0;
		int shire0 = 0;
		int yuxue0 = 0;
		int qiyu0 = 0;
		int tebing0 = 0;
		
		double pinghe = 0.0f;
		double qixu = 0.0f;
		double yangxu = 0.0f;
		double yinxu = 0.0f;
		double tanshi = 0.0f;
		double shire = 0.0f;
		double yuxue = 0.0f;
		double qiyu = 0.0f;
		double tebing = 0.0f;
		
		pinghe0 = (6-fz1[1]) + (6-fz1[1]) + fz1[9] + (6-fz1[10]) + (6-fz1[11]) + (6-fz1[20]) + fz1[36] + (6-fz1[54]);
		qixu0 = fz1[8] + fz1[12] + fz1[20] + fz1[24] + fz1[34] + fz1[35] + fz1[44] + fz1[56];
		yangxu0 = fz1[1] + fz1[12] + fz1[13] + fz1[37] + fz1[52] + fz1[59];
		yinxu0 = fz1[2] + fz1[14] + fz1[25] + fz1[36] + fz1[44] + fz1[45] + fz1[60];
		tanshi0 = fz1[15] + fz1[16] + fz1[23] +fz1[27] + fz1[31] + fz1[33] + fz1[49] + fz1[53];
		shire0 = fz1[4] + fz1[28] + fz1[32] + fz1[39] + fz1[46] + fz1[55];
		yuxue0 = fz1[5] + fz1[17] + fz1[40] + fz1[47] + fz1[50] + fz1[54] + fz1[57];
		qiyu0 = fz1[6] + fz1[11] + fz1[19] + fz1[21] + fz1[29] + fz1[41] + fz1[51];
		tebing0 = fz1[7] + fz1[18] + fz1[22] + fz1[30] + fz1[42] + fz1[48] + fz1[58];
		
		pinghe = ((pinghe0-8)*1.0 / (8*4)) * 100;
		qixu = ((qixu0-8)*(1.0) / (8*4)) * 100;
		yangxu = ((yangxu0-6)*1.0 / (6*4)) * 100;
		yinxu = ((yinxu0-7)*1.0 / (7*4)) * 100;
		tanshi = ((tanshi0-8)*1.0 / (8*4)) * 100;
		shire = ((shire0-6)*1.0 / (6*4)) * 100;
		yuxue = ((yuxue0-7)*1.0 / (7*4)) * 100;
		qiyu = ((qiyu0-7)*1.0 / (7*4)) * 100;
		tebing = ((tebing0-7)*1.0 / (7*4)) * 100;
		CePingBaoGao1 c = new CePingBaoGao1();
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		pinghe = Double.parseDouble(df.format(pinghe));
		qixu = Double.parseDouble(df.format(qiyu));
		yangxu = Double.parseDouble(df.format(yangxu));
		yinxu = Double.parseDouble(df.format(yinxu));
		tanshi = Double.parseDouble(df.format(tanshi));
		shire = Double.parseDouble(df.format(shire));
		yuxue = Double.parseDouble(df.format(yuxue));
		qiyu = Double.parseDouble(df.format(qiyu));
		tebing = Double.parseDouble(df.format(tebing));
		
		double max0 = 0.0f;
		String max = "";
		int flag = 0;
		
		if(qixu > max0) {
			max0 = qiyu;
			max = "气虚质";
			flag = 2;
		} else if(yangxu > max0) {
			max0 = yangxu;
			max = "阳虚质";
			flag = 3;
		} else if(yinxu > max0) {
			max0 = yinxu;
			max = "阴虚质";
			flag = 5;
		} else if(tanshi > max0) {
			max0 = tanshi;
			max = "痰湿质";
			flag = 6;
		} else if(shire > max0) {
			max0 = shire;
			max = "湿热质";
			flag = 7;
		} else if(yuxue > max0) {
			max0 = yuxue;
			max = "淤血质";
			flag = 8;
		} else if(qiyu > max0) {
			max0 = qiyu;
			max = "气郁质";
			flag = 1;
		} else if(tebing > max0) {
			max0 = tebing;
			max = "特禀质";
			flag =9;
		}

		c.setPingHe(pinghe);
		c.setQiXu(qixu);
		c.setYangXu(yangxu);
		c.setYinXu(yinxu);
		c.setTanShi(tanshi);
		c.setShiRe(shire);
		c.setYuXue(yuxue);
		c.setQiYu(qiyu);
		c.setTeBing(tebing);
		
		if(pinghe >= 60 && max0 < 30) {
			c.setBeLong("平和质");
			flag = 4;
		} else if(pinghe >= 60 && max0 < 40) {
			c.setBeLong("基本是平和质");
			flag = 4;
		} else if(max0 >= 40) {
			c.setBeLong(max);
		} else if (max0 >= 30) {
			c.setBeLong("倾向" + max);
		}
		c.setFlag(flag);
		return c;
	}

	public static void main(String[] args) {
		ATiZhi t = new ATiZhi();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "a", "a", "a", "a" };
		for (int i = 0; i < 60; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao1 dd = t.getTiZhi(daAns);
		 System.out.println(dd);
	}

}
