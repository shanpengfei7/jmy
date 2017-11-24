package com.jinmayi.algorithm.tizhi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.jinmayi.entity.CePingBaoGao6;
import com.jinmayi.entity.DaAn;

public class FAiSenKe {
	
	public CePingBaoGao6 getAiSenKe(List<DaAn> daAn , int gender) {
		
		CePingBaoGao6 c = new CePingBaoGao6();
		
		int[] fz6 = new int[daAn.size()+1];
		for (int i = 1; i <= daAn.size(); i++) {
		
			if (daAn.get(i-1).getDaAn().equals("a")) {
				fz6[i] = 0;
			} else if (daAn.get(i-1).getDaAn().equals("b")) {
				fz6[i] = 1;
			} 
		}
		
		double P = 0;
		double E = 0;
		double N = 0;
		double L = 0;
		
		
		double M = 0;
		double SD = 0;
		
		
		P = (1-fz6[2]) + (1-fz6[6]) + (1-fz6[9]) + (1-fz6[11]) + (1-fz6[18]) + fz6[22] + fz6[26] + fz6[30] + fz6[34] + (1-fz6[38]) +  (1-fz6[42]) + fz6[46] + fz6[50] + (1-fz6[56]) + (1-fz6[62]) + fz6[66]  + fz6[68] + (1-fz6[72]) + fz6[75] + fz6[76] + fz6[81] + fz6[85] + (1-fz6[88]);
		E = fz6[1] + fz6[5] + fz6[10] + fz6[13] + fz6[14] + fz6[17] + (1-fz6[21]) + fz6[25] + (1-fz6[29]) + fz6[33] + fz6[37] + fz6[41] + (1-fz6[45]) + fz6[49] + fz6[53] + fz6[55] + fz6[61] + fz6[65] + fz6[71] + fz6[80] + fz6[84];
		N = fz6[3] + fz6[7] + fz6[12] + fz6[15] + fz6[19] + fz6[23] + fz6[27] + fz6[31] + fz6[35] + fz6[39] + fz6[43] + fz6[47] + fz6[51] + fz6[57] + fz6[59] + fz6[63] + fz6[67] + fz6[69] + fz6[73] + fz6[74] + fz6[77] + fz6[78] + fz6[82] + fz6[86];
		L = (1-fz6[4]) + (1-fz6[8]) + (1-fz6[16]) + fz6[20] + (1-fz6[24]) + (1-fz6[28])  + fz6[32] + fz6[36] + (1-fz6[40]) + (1-fz6[44]) + (1-fz6[48]) + (1-fz6[52]) + (1-fz6[54]) + fz6[58] + (1-fz6[60]) + (1-fz6[64]) + (1-fz6[70]) + (1-fz6[79]) + (1-fz6[83]) + fz6[87];

		c.setPy(P);
		c.setEy(E);
		c.setNy(N);
		c.setLy(L);
		
		//P
		if(gender == 1) {  //男
			M = 6.08;
			SD = 3.22;
		} else {           //女
			M = 5.34;
			SD = 2.95;
		}
		P = 50.0 + 10.0 * (P - M) /SD;
		
		
		//E
		if(gender == 1) {
			M = 9.93;
			SD = 4.39;
		} else {
			M = 9.03;
			SD = 4.12;
		}
		E = 50.0 + 10.0 * (E - M) /SD;
		
		
		//N
		if(gender == 1) {
			M = 10.06;
			SD = 4.62;
		} else {
			M = 10.95;
			SD = 4.66;
		}
		N = 50.0 + 10.0 * (N - M) /SD;
		
		
		//L
		if(gender == 1) {
			M = 13.30;
			SD = 5.77;
		} else {
			M = 11.99;
			SD = 3.50;
		}
		L = 50.0 + 10.0 * (L - M) /SD;
		
		
		DecimalFormat df = new DecimalFormat("#.0");
		
		P = Double.parseDouble(df.format(E));
		E = Double.parseDouble(df.format(E));
		N = Double.parseDouble(df.format(N));
		L = Double.parseDouble(df.format(L));
		
		c.setP(P);
		c.setE(E);
		c.setN(N);
		c.setL(L);
		
		
		//E
		if(E >= 61.5) {
			c.setBelongE("典型的外向");
			c.setYiJianE("善于交际，喜欢参加聚会，有许多朋友，健谈，不喜欢独坐静处，学习时好与人讨论，寻求刺激，善于捕捉机会，好出风头，做事急于求成，一般来说属于冲动型；喜欢开玩笑，回答问题脱口而出，不假思索，喜欢环境变化，无忧无虑，不记仇，乐观，常喜笑颜开；好动，总想找些事来做；富于攻击性，但又很容易息怒。总之，他不能时时很好地控制自己的情感，因此，他往往不是一个足以信赖的人。");
		} else if (E <= 38.5) {
			c.setBelongE("典型的内向");
			c.setYiJianE("表现安静，不喜欢与各种人交往，善于自我省察，对书的兴趣更甚于人，除非对很亲密的朋友，他往往对人有所保留或保持距离；做事之前先订计划，瞻前顾后，不轻举妄动，不喜欢兴奋的事，待人接物严肃，生活有规律；善于控制情感，很少攻击行为，但一旦被激怒很难平复。办事可靠，偏于保守，非常看重道德价值。");
		} else if (E >= 43.3 && E < 56.7) {
			c.setBelongE("性格中间型");
			c.setYiJianE("内外倾43.3-56.7属于中间性性格特征，无明显喜欢活动和安静的特点，做事情不冲动但也不过分犹豫不决，态度平淡，热情而不失控，有节而不保守。");
		} else if (E >= 56.7 && E < 61.5) {
			c.setBelongE("倾向外向型");
			c.setYiJianE("提示被试比较孤僻，固执，遇到麻烦较多，对其他人缺乏感情，感觉比较迟钝，很少关心他人，较少有同情心和人道主义精神。有时还会做出不同于一般人的古怪行为。");
		} else {
			c.setBelongE("倾向内向型");
			c.setYiJianE("内外倾43.3-56.7属于中间性性格特征，无明显喜欢活动和安静的特点，做事情不冲动但也不过分犹豫不决，态度平淡，热情而不失控，有节而不保守。");
		}
		
		
		//N
		if(N >= 61.5) {
			c.setBelongN("典型情绪不稳");
			c.setYiJianN("焦虑，紧张，易怒，往往会有抑郁，睡眠不好，患有各种心身障碍。情绪过分，对各种刺激的反应都过于强烈，情绪激发后又很难平复下来。由于强烈的情绪反应而影响了他的正常适应。不可理喻，有时走上危险道路。在与外向结合时，这种人是容易冒火的和不休息的，以至激动、进攻，概括地说，是一个紧张的人，好抱偏见，以至错误。");
		} else if (N <= 38.5) {
			c.setBelongN("典型情绪稳定");
			c.setYiJianN("倾向于情绪反应缓慢、轻微，即使激起了情绪也很快平复下来，通常是平静，稳重，性情温和，即使生点气也是有节制的，并且不紧张焦虑。");
		} else if (N >= 43.3 && N < 56.7) {
			c.setBelongN("情绪中间型");
			c.setYiJianN("情绪相对稳定，多数情况下能理性判断事物，不会感情用事，也不会过份紧张不安、焦虑，情绪反应适中，能较好控制自己的情绪，容易将激动的情绪状态恢复正常，遇事不容易受到自己情绪状态的左右。");
		} else if (N >= 56.7 && N < 61.5) {
			c.setBelongN("倾向情绪不稳定");
			c.setYiJianN("情绪不稳定，容易紧张、焦虑、发脾气，遇事不冷静，急躁，情绪反应明显，容易感情用事，以感情作为衡量是非的标准，容易与人发生冲突，情绪激动，容易受外界刺激因素的影响。");
		} else {
			c.setBelongN("情绪相对稳定");
			c.setYiJianN("表现为情绪较为平静，很难从外部看出其情绪变化，情绪反应较慢而且强度不大，但绝不冷淡。很少表现紧张、焦虑、不安的症状。");
		}
		
		//P
		if(P >= 61.5) {
			c.setBelongP("典型精神质");
			c.setYiJianP("独身，不关心人，常有麻烦，在哪里都不合适，可能是残忍的，不人道的，缺乏同情心，感觉迟钝，对人抱敌意，即令是对亲友也如此。进攻，即使是喜爱的人。喜欢一些古怪的不平常的事情，不惧安危，喜恶作剧，总要捣乱。");
		} else if (P <= 38.5) {
			c.setBelongP("精神质（P得分小于38.5）");
			c.setYiJianP("被试人际关系好，在与人交往中能理解和关心他人，能与人友好相处，是非分明，富有同情心，可以给他人提供帮助。");
		} else if (P >= 43.3 && P < 56.7) {
			c.setBelongP("精神质（P分43.3-56.7）");
			c.setYiJianP("提示被试的精神质在正常范围内，能与其他人正常的交往，无明显固执、古怪、麻烦等表现，能善待其他人，会关心他人，表现出一定的同情心和人道主义精神，人际关系较好");
		} else if (P >= 56.7 && P < 61.5) {
			c.setBelongP("精神质（P分56.7-61.5）");
			c.setYiJianP("精神质56.7-61.5提示被试比较孤僻，固执，遇到麻烦较多，对其他人缺乏感情，感觉比较迟钝，很少关心他人，较少有同情心和人道主义精神。有时还会做出不同于一般人的古怪行为。");
		} else {
			c.setBelongP("精神质（P分38.5-43.3）");
			c.setYiJianP("提示被试无明显的古怪、偏执、冷漠等性格特征，能接纳和理解同伴，富有同情心和人道主义精神，人际关系良好，一般不会表现出古怪的、不平常的行为。");
		}
		
		
		//L
		if(L >= 61.5) {
			c.setBelongL("掩饰性（L分大于61.5）");
			c.setYiJianL("被试存在明显的掩饰倾向，所回答的问题欠真实，很少坦露自己的内心体验，有时表现为高低不一。一般来说，年龄越大，该项测试的得分越高，请根据被试的具体情况具体分析。");
		} else if (L <= 38.5) {
			c.setBelongL("掩饰性（L分得分小于38.5）");
			c.setYiJianL("掩饰性38.5以下Ｌ：提示被试毫无任何掩饰倾向，所回答的问题真实可信，行为纯朴，言行一致，容易坦露自己的内心体验。一般来说，年龄越小，该项得分越低，请根据被试的具体情况具体分析。");
		} else if (L >= 43.3 && L < 56.7) {
			c.setBelongL("掩饰性（L分43.3-56.7）");
			c.setYiJianL("掩饰性43.3-56.7 Ｌ：提示被试对问题回答真实，具有较高的可信度，无明显的掩饰倾向。");
		} else if (L >= 56.7 && L < 61.5) {
			c.setBelongL("掩饰性（L分56.7-61.5）");
			c.setYiJianL("被试对问题回答真实，具有较高的可信度，无明显的掩饰倾向。");
		} else {
			c.setBelongL("掩饰性（L分38.5-43.3）");
			c.setYiJianL("掩饰度38。5-43.3Ｌ：提示被试无掩饰倾向，回答问题真实可信，行为朴实，言行一致，能够坦露自己的内心体验。");
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		FAiSenKe as = new FAiSenKe();

		List<DaAn> daAns = new ArrayList<DaAn>();
		String[] aa = { "a", "b"};
		for (int i = 0; i < 88; i++) {
			DaAn d = new DaAn();
			d.setTiHao(i + 1);
			int a = (int) (Math.random() * 10000) % 2;
			d.setDaAn(aa[a]);
			daAns.add(d);
		}

		CePingBaoGao6 dd = as.getAiSenKe(daAns,0);
		 System.out.println(dd);
	}

}
