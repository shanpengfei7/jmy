package com.jinmayi.algorithm.tizhi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao5;
import com.jinmayi.entity.DaAn;

public class EZhengZhuang90 {

	public CePingBaoGao5 getZhengZhuang90(List<DaAn> daAn) {

		CePingBaoGao5 c = new CePingBaoGao5();

		int[] fz5 = new int[daAn.size() + 1];

		for (int i = 1; i <= daAn.size(); i++) {

			if (daAn.get(i - 1).getDaAn().equals("a")) {
				fz5[i] = 0;
			} else if (daAn.get(i - 1).getDaAn().equals("b")) {
				fz5[i] = 1;
			} else if (daAn.get(i - 1).getDaAn().equals("c")) {
				fz5[i] = 2;
			} else if (daAn.get(i - 1).getDaAn().equals("d")) {
				fz5[i] = 3;
			} else if (daAn.get(i - 1).getDaAn().equals("e")) {
				fz5[i] = 4;
			}
		}

		int quTiHua0 = 0;
		int qiangPoZheng0 = 0;
		int renJiGuanXi0 = 0;
		int yiYu0 = 0;
		int jiaoLv0 = 0;
		int diDui0 = 0;
		int kongBu0 = 0;
		int pianZhi0 = 0;
		int jingShenBing0 = 0;
		int qiTa0 = 0;

		double quTiHua = 0;
		double qiangPoZheng = 0;
		double renJiGuanXi = 0;
		double yiYu = 0;
		double jiaoLv = 0;
		double diDui = 0;
		double kongBu = 0;
		double pianZhi = 0;
		double jingShenBing = 0;
		double qiTa = 0;

		int sum = 0;
		double ave = 0.0f;

		// 12
		quTiHua0 = fz5[1] + fz5[4] + fz5[12] + fz5[27] + fz5[40] + fz5[42]
				+ fz5[48] + fz5[49] + fz5[52] + fz5[53] + fz5[56] + fz5[58];

		// 10
		qiangPoZheng0 = fz5[3] + fz5[9] + fz5[10] + fz5[28] + fz5[38] + fz5[45]
				+ fz5[46] + fz5[51] + fz5[55] + fz5[65];

		// 9
		renJiGuanXi0 = fz5[6] + fz5[21] + fz5[34] + fz5[36] + fz5[37] + fz5[41]
				+ fz5[61] + fz5[69] + fz5[73];

		// 13
		yiYu0 = fz5[5] + fz5[14] + fz5[15] + fz5[20] + fz5[22] + fz5[26]
				+ fz5[29] + fz5[30] + fz5[31] + fz5[32] + fz5[54] + fz5[71]
				+ fz5[79];

		// 10
		jiaoLv0 = fz5[2] + fz5[17] + fz5[23] + fz5[33] + fz5[39] + fz5[57]
				+ fz5[72] + fz5[78] + fz5[80] + fz5[86];

		// 6
		diDui0 = fz5[11] + fz5[24] + fz5[63] + fz5[67] + fz5[74] + fz5[81];

		// 7
		kongBu0 = fz5[13] + fz5[25] + fz5[47] + fz5[50] + fz5[70] + fz5[75]
				+ fz5[82];

		// 6
		pianZhi0 = fz5[8] + fz5[18] + fz5[43] + fz5[68] + fz5[76] + fz5[83];

		// 10
		jingShenBing0 = fz5[7] + fz5[16] + fz5[35] + fz5[62] + fz5[77]
				+ fz5[84] + fz5[85] + fz5[87] + fz5[88] + fz5[90];

		// 7
		qiTa0 = fz5[19] + fz5[44] + fz5[59] + fz5[60] + fz5[64] + fz5[66]
				+ fz5[89];

		quTiHua = quTiHua0 * 1.0 / 12;
		qiangPoZheng = qiangPoZheng0 * 1.0 / 10;
		renJiGuanXi = renJiGuanXi0 * 1.0 / 9;
		yiYu = yiYu0 * 1.0 / 13;
		jiaoLv = jiaoLv0 * 1.0 / 10;
		diDui = diDui0 * 1.0 / 6;
		kongBu = kongBu0 * 1.0 / 7;
		pianZhi = pianZhi0 * 1.0 / 6;
		jingShenBing = jingShenBing0 * 1.0 / 10;
		qiTa = qiTa0 * 1.0 / 7;

		DecimalFormat df = new DecimalFormat("#.0");

		quTiHua = Double.parseDouble(df.format(quTiHua));
		qiangPoZheng = Double.parseDouble(df.format(qiangPoZheng));
		renJiGuanXi = Double.parseDouble(df.format(renJiGuanXi));
		yiYu = Double.parseDouble(df.format(yiYu));
		jiaoLv = Double.parseDouble(df.format(jiaoLv));
		diDui = Double.parseDouble(df.format(diDui));
		kongBu = Double.parseDouble(df.format(kongBu));
		pianZhi = Double.parseDouble(df.format(pianZhi));
		jingShenBing = Double.parseDouble(df.format(jingShenBing));
		qiTa = Double.parseDouble(df.format(qiTa));

		sum = quTiHua0 + qiangPoZheng0 + renJiGuanXi0 + yiYu0 + jiaoLv0
				+ diDui0 + kongBu0 + pianZhi0 + jingShenBing0 + qiTa0;
		ave = sum * 1.0 / 90;

		c.setSum(sum);
		c.setAve(ave);
		c.setQuTiHua0(quTiHua0);
		c.setQiangPoZheng0(qiangPoZheng0);
		c.setRenJiGuanXi0(renJiGuanXi0);
		c.setYiYu0(yiYu0);
		c.setJiaoLv0(jiaoLv0);
		c.setDiDui0(diDui0);
		c.setKongBu0(kongBu0);
		c.setPianZhi0(pianZhi0);
		c.setJingShenBing0(jingShenBing0);
		c.setQiTa0(qiTa0);

		c.setQuTiHua(quTiHua);
		c.setQiangPoZheng(qiangPoZheng);
		c.setRenJiGuanXi(renJiGuanXi);
		c.setYiYu(yiYu);
		c.setJiaoLv(jiaoLv);
		c.setDiDui(diDui);
		c.setKongBu(kongBu);
		c.setPianZhi(pianZhi);
		c.setJingShenBing(jingShenBing);
		c.setQiTa(qiTa);

		// 躯体化
		if (quTiHua < 1.4) {
			c.setBelongQuTiHua("无躯体化症状:");
			c.setBelongQuTiHua0("无");
		} else if (quTiHua <= 2.4) {
			c.setBelongQuTiHua("轻度躯体化:主观躯体感受与临床检查轻度不符，躯体症状伴有一定情绪因素。偶见头晕、紧 绷、胀痛，胃部不适、胀气、嗳气，心跳加快、心慌，疲倦等症。");
			c.setBelongQuTiHua0("轻度");
		} else if (quTiHua <= 3.5) {
			c.setBelongQuTiHua("中度躯体化:主观躯体感受与临床检查中度不符，躯体症状伴有明显情绪因素。常有头晕、头胀、紧绷，食欲不振，嗳气，胃胀，心慌、心跳快，胸闷，呼吸急促，疲乏、虚弱等症。");
			c.setBelongQuTiHua0("中度");
		} else {
			c.setBelongQuTiHua("重度躯体化:主观躯体感受与临床检查重度不符，躯体症状伴有严重情绪因素。常感头晕、头胀、心悸、胸闷气急，窒息感，胃纳差，腹胀，强烈生命恐惧感。");
			c.setBelongQuTiHua0("重度");
		}

		// 强迫症
		if (qiangPoZheng < 1.4) {
			c.setBelongQiangPoZheng("无强迫症状");
			c.setBelongQiangPoZheng0("无");
		} else if (qiangPoZheng <= 2.4) {
			c.setBelongQiangPoZheng("轻度强迫症状:表现为担心、害怕而反复思考某些念头或想法。有时表现为出现重复动作，如洗手或一些特殊的动作，但时间较短，程度较轻，虽有些痛苦，但尚能工作。");
			c.setBelongQiangPoZheng0("轻度");
		} else if (qiangPoZheng <= 3.5) {
			c.setBelongQiangPoZheng("中度强迫症状:反复重复动作明显增多，或反复思考，自觉无必要，但无法克制，伴明显焦虑，有一定求医行为。强迫思维、强迫行为每日可达３-４小时。");
			c.setBelongQiangPoZheng0("中度");
		} else {
			c.setBelongQiangPoZheng("重度强迫症状:强迫思维或强迫行为每日可达6-8小时，严重影响社会功能和生活功能。明知没必要，但无法抗拒，内心十分痛苦。完成之后，心里有轻松、舒适感，间隔不久，又被焦虑、担心所支配，再次做重复动作。");
			c.setBelongQiangPoZheng0("重度");
		}

		// 人际关系
		if (renJiGuanXi < 1.4) {
			c.setBelongRenJiGuanXi("无人际关系敏感问题");
			c.setBelongRenJiGuanXi0("无");
		} else if (renJiGuanXi <= 2.4) {
			c.setBelongRenJiGuanXi("轻度人际关系敏感问题:性格基础是内向、敏感、胆小、易害羞。心理较脆弱，有时会产生不被理解而痛苦。");
			c.setBelongRenJiGuanXi0("轻度");
		} else if (renJiGuanXi <= 3.5) {
			c.setBelongRenJiGuanXi("中度人际关系敏感问题:很少在生人面前多讲话，表现为敏感、多疑且易害羞。对别人讲话比较留心，常担心别人议论自己，有时对别人有警惕心理状态，做事小心谨慎。");
			c.setBelongRenJiGuanXi0("中度");
		} else {
			c.setBelongRenJiGuanXi("重度人际关系敏感问题:平时很内向，常因过分敏感而少与人讲话，对别人的谈论过度关注，对他人行为呈神经过敏状态，有时采取指责别人的方法，致使朋友极少。");
			c.setBelongRenJiGuanXi0("重度");
		}

		// 抑郁
		if (yiYu < 1.4) {
			c.setBelongYiYu("无抑郁症状");
			c.setBelongYiYu0("无");
		} else if (yiYu <= 2.4) {
			c.setBelongYiYu("轻度抑郁症状：自我评价稍低，心情欠佳、兴趣下降，偶有烦躁，不愿与人交往，时有睡眠差、多梦。");
			c.setBelongYiYu0("轻度");
		} else if (yiYu <= 3.5) {
			c.setBelongRenJiGuanXi("中度抑郁症状:自我评价较低，情绪低落明显，常有愁眉苦脸状态，兴趣减退。有时会哭泣或感到活着太累的想法，失眠常见，食欲不振。");
			c.setBelongYiYu0("中度");
		} else {
			c.setBelongYiYu("重度抑郁症状:自我评价低，常感自己无用，情绪低落明显，整日愁眉不展，自责。有时会产生无助感、绝望感，有消极观念，食欲减退，饮食不振。");
			c.setBelongYiYu0("重度");
		}

		// 焦虑
		if (jiaoLv < 1.4) {
			c.setBelongJiaoLv("无焦虑症状");
			c.setBelongJiaoLv0("无");
		} else if (jiaoLv <= 2.4) {
			c.setBelongJiaoLv("轻度焦虑症状：莫名担心，害怕的感觉，可伴心慌、心跳加快，易紧张，多汗，有掩饰举动。");
			c.setBelongJiaoLv0("轻度");
		} else if (jiaoLv <= 3.5) {
			c.setBelongJiaoLv("中度焦虑症状:莫名担心、紧张，无法掩饰的焦虑状态，如心跳、心慌，常有出汗，手指轻微颤抖，有时出现坐立不安。");
			c.setBelongJiaoLv0("中度");
		} else {
			c.setBelongJiaoLv("重度焦虑症状:明显的紧张不安，预感坏事要发生，坐立不安。经常大汗淋漓，心跳加快、心慌、胸闷气短，严重惊恐发作时，可有濒死感。");
			c.setBelongJiaoLv0("重度");
		}

		// 敌对
		if (diDui < 1.4) {
			c.setBelongDiDui("无敌对症状");
			c.setBelongDiDui0("无");
		} else if (diDui <= 2.4) {
			c.setBelongDiDui("轻度敌对症状：敏感多疑，怀疑他人动机，警惕性增高，关注他人行为及态度是否友好，易发脾气。");
			c.setBelongDiDui0("轻度");
		} else if (diDui <= 3.5) {
			c.setBelongDiDui("中度敌对症状:警惕性较高，经常注意或怀疑别人的举动，常与人难以相处，偶有破坏性行为。");
			c.setBelongDiDui0("中度");
		} else {
			c.setBelongDiDui("重度敌对症状:疑心严重，甚至怀疑别人采取措施迫害自己。经常发怒，激惹性增强，常以叫骂，摔东西发泄，与人难以相处，甚至连亲人都无法友好相处。");
			c.setBelongDiDui0("重度");
		}

		// 恐怖
		if (kongBu < 1.4) {
			c.setBelongKongBu("无恐怖症状");
			c.setBelongKongBu0("无");
		} else if (kongBu <= 2.4) {
			c.setBelongKongBu("轻度恐怖症状:独处恐惧感严重，需有人陪伴，特定场所恐怖，不敢与生人交往，尽力克制掩饰，对工作影响不大。");
			c.setBelongKongBu0("轻度");
		} else if (kongBu <= 3.5) {
			c.setBelongKongBu("中度恐怖症状:经常采取逃避行为，主要因担心或缺乏安全感，不敢独处，恐惧空间场所，强制去时会出现紧张、焦虑、出汗等症，亦会有心跳加快、心慌等症。");
			c.setBelongKongBu0("中度");
		} else {
			c.setBelongKongBu("重度恐怖症状:对自己所恐怖的对象无法接触，常采取强烈的逃避行为，伴紧张、焦虑，严重时会产生昏厥，甚至有胸闷气急或濒死感，严重影响工作和日常生活。");
			c.setBelongKongBu0("重度");
		}

		// 偏执
		if (pianZhi < 1.4) {
			c.setBelongPianZhi("无偏执症状");
			c.setBelongPianZhi0("无");
		} else if (pianZhi <= 2.4) {
			c.setBelongPianZhi("轻度偏执症状:性格固执，否认。有敌对性，多疑，对他人信任度不足，偶有被跟踪想法。");
			c.setBelongPianZhi0("轻度");
		} else if (pianZhi <= 3.5) {
			c.setBelongPianZhi("中度偏执症状:敏感多疑，认为别人和自己过不去，要迫害自己，对他人的举动都认为与自己相关，有被跟踪感或被监视感。");
			c.setBelongPianZhi0("中度");
		} else {
			c.setBelongPianZhi("重度偏执症状:不相信他人，常怀疑他人有阴谋迫害行为，被监视感，被跟踪感，经常采取逃避行为，或者紧张、害怕、不敢出门，日常生活受到影响。");
			c.setBelongPianZhi0("重度");
		}

		// 精神病性
		if (jingShenBing < 1.4) {
			c.setBelongJingShenBing("无精神病性症状");
			c.setBelongJingShenBing0("无");
		} else if (jingShenBing <= 2.4) {
			c.setBelongJingShenBing("轻度精神病性症状:偶有幻听，多为批评、指责、迫害等内容，有被迫害行为妄想，可出现思维被洞悉感，常有敌对性，可有自责倾向，伴有孤独感。  ");
			c.setBelongJingShenBing0("轻度");
		} else if (jingShenBing <= 3.5) {
			c.setBelongJingShenBing("中度精神病性症状:常有幻听，内容多为批评、责骂，有时与幻听互相对夸、对骂，认为别人要害他，跟踪他，伴有紧张情绪，有思维被洞悉感，播散感。有自责倾向，时感孤独。 ");
			c.setBelongJingShenBing0("中度");
		} else {
			c.setBelongJingShenBing("重度精神病性症状:有幻听，其内容多为批评、责骂，少有表扬，有时沉浸在幻听中，而不与人接触交谈，且伴有明显发呆，喃喃自语，或与幻听对骂，思维被洞悉感，因感到被控制而没有行动自由。可在命令性幻听支配下做出伤人毁物或自伤行为。可有严重自责感、孤独感。");
			c.setBelongJingShenBing0("重度");
		}

		// 其他
		if (qiTa < 1.4) {
			c.setBelongQiTa("无");
		} else if (qiTa <= 2.4) {
			c.setBelongQiTa("轻度");
		} else if (qiTa <= 3.5) {
			c.setBelongQiTa("中度");
		} else {
			c.setBelongQiTa("重度");
		}

		return c;
	}

	public static void main(String[] args) {
		EZhengZhuang90 z = new EZhengZhuang90();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < 90; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 5;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao5 dd = z.getZhengZhuang90(daAns);
		System.out.println(dd);
	}

}
