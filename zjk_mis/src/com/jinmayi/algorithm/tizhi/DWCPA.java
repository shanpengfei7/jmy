package com.jinmayi.algorithm.tizhi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao4;
import com.jinmayi.entity.DaAn;

public class DWCPA {

	public CePingBaoGao4 getWCPA(List<DaAn> daAn) {

		int[] fz4 = new int[daAn.size() + 1];
		
		for (int i = 1; i <= daAn.size(); i++) {

			if (daAn.get(i - 1).getDaAn().equals("a")) {
				fz4[i] = 0;
			} else if (daAn.get(i - 1).getDaAn().equals("b")) {
				fz4[i] = 1;
			} else if (daAn.get(i - 1).getDaAn().equals("c")) {
				fz4[i] = 2;
			} else if (daAn.get(i - 1).getDaAn().equals("d")) {
				fz4[i] = 3;
			} else if (daAn.get(i - 1).getDaAn().equals("e")) {
				fz4[i] = 4;
			}
		}

		int yizhia0 = 0;
		int jireb0 = 0;
		int shengwuc0 = 0;
		int renzhid0 = 0;
		int xiangxiange0 = 0;

		double yizhia = 0.0f;
		double jireb = 0.0f;
		double shengwuc = 0.0f;
		double renzhid = 0.0f;
		double xiangxiange = 0.0f;

		double max1 = 0.0f;
		double max2 = 0.0f;

		int flag1 = 0;
		int flag2 = 0;

		// 12
		yizhia0 = fz4[7] + fz4[8] + fz4[32] + fz4[33] + fz4[36] + fz4[37]
				+ fz4[38] + fz4[40] + fz4[41] + fz4[43] + fz4[45] + fz4[51];

		// 14
		jireb0 = fz4[2] + fz4[5] + fz4[13] + fz4[30] + fz4[31] + fz4[34]
				+ fz4[35] + fz4[39] + fz4[42] + fz4[44] + fz4[46] + fz4[47]
				+ fz4[49] + fz4[50];

		// 5
		shengwuc0 = fz4[3] + fz4[4] + fz4[6] + fz4[10] + fz4[12];

		// 10
		renzhid0 = fz4[19] + fz4[20] + fz4[21] + fz4[22] + fz4[23] + fz4[27]
				+ fz4[52] + fz4[53] + fz4[54] + fz4[55];

		// 14
		xiangxiange0 = fz4[1] + fz4[9] + fz4[11] + fz4[14] + fz4[15] + fz4[16]
				+ fz4[17] + fz4[18] + fz4[24] + fz4[25] + fz4[26] + fz4[28]
				+ fz4[29] + fz4[48];

		yizhia = yizhia0 * 1.0 / 12;
		jireb = jireb0 * 1.0 / 14;
		shengwuc = shengwuc0 * 1.0 / 5;
		renzhid = renzhid0 * 1.0 / 10;
		xiangxiange = xiangxiange0 * 1.0 / 14;
		DecimalFormat df = new DecimalFormat("#.00");

		yizhia = Double.parseDouble(df.format(yizhia));
		jireb = Double.parseDouble(df.format(jireb));
		shengwuc = Double.parseDouble(df.format(shengwuc));
		renzhid = Double.parseDouble(df.format(renzhid));
		xiangxiange = Double.parseDouble(df.format(xiangxiange));

		CePingBaoGao4 c = new CePingBaoGao4();

		// 把第一种体制的值赋值给各个变量
		max1 = yizhia;
		max2 = yizhia;
		flag1 = 23;
		flag2 = 23;

		// 判断第二种体体质，只需和max1比较即可
		if (jireb > max1) {
			max2 = max1;
			max1 = jireb;
			flag1 = 24;
			flag2 = flag1;
		}

		// 判断第三种体制
		if (shengwuc > max1) {
			max2 = max1;
			max1 = shengwuc;
			flag2 = flag1;
			flag1 = 22;
		} else if (shengwuc > max2) {
			flag2 = 22;
			max2 = shengwuc;
		}

		// 判断第四种体质
		if (renzhid > max1) {
			max2 = max1;
			max1 = renzhid;
			flag2 = flag1;
			flag1 = 26;
		} else if (renzhid > max2) {
			flag2 = 26;
			max2 = renzhid;
		}

		// 判断第五种体制
		if (xiangxiange > max1) {
			max2 = max1;
			max1 = xiangxiange;
			flag2 = flag1;
			flag1 = 25;
		} else if (xiangxiange > max2) {
			flag2 = 25;
			max2 = xiangxiange;
		}

		c.setYiZhia(yizhia);
		c.setJiReb(jireb);
		c.setShengWuc(shengwuc);
		c.setRenZhid(renzhid);
		c.setXiangXiange(xiangxiange);
		c.setYiZhia0(yizhia0);
		c.setJiReb0(jireb0);
		c.setShengWuc0(shengwuc0);
		c.setRenZhid0(renzhid0);
		c.setXiangXiange0(xiangxiange0);

		if (flag1 == 22) {
			c.setBelong1("生物性躯体症状");
			c.setYiJian1("常规生物治疗");
		} else if (flag1 == 23) {
			c.setBelong1("抑制性躯体症状");
			c.setYiJian1("");
		} else if (flag1 == 24) {
			c.setBelong1("激惹性躯体症状");
			c.setYiJian1("药物治疗结合认知行为治疗、低频治疗");
		} else if (flag1 == 25) {
			c.setBelong1("想象性躯体症状");
			c.setYiJian1("药物治疗结合生物反馈治疗");
		} else if (flag1 == 26) {
			c.setBelong1("认知性躯体症状");
			c.setYiJian1("药物治疗结合认知行为治疗");
		}

		if (flag2 == 22) {
			c.setBelong2("生物性躯体症状");
			c.setYiJian2("常规生物治疗");
		} else if (flag2 == 23) {
			c.setBelong2("抑制性躯体症状");
			c.setYiJian2("");
		} else if (flag2 == 24) {
			c.setBelong2("激惹性躯体症状");
			c.setYiJian2("药物治疗结合认知行为治疗、低频治疗");
		} else if (flag2 == 25) {
			c.setBelong2("想象性躯体症状");
			c.setYiJian2("药物治疗结合生物反馈治疗");
		} else if (flag2 == 26) {
			c.setBelong2("认知性躯体症状");
			c.setYiJian2("药物治疗结合认知行为治疗");
		}

		return c;
	}

	public static void main(String[] args) {
		DWCPA wc = new DWCPA();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 56; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao4 dd = wc.getWCPA(daAns);
		System.out.println(dd);
	}
}
