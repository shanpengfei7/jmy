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

		// ���廯
		if (quTiHua < 1.4) {
			c.setBelongQuTiHua("�����廯֢״:");
			c.setBelongQuTiHua0("��");
		} else if (quTiHua <= 2.4) {
			c.setBelongQuTiHua("������廯:��������������ٴ������Ȳ���������֢״����һ���������ء�ż��ͷ�Ρ��� ������ʹ��θ�����ʡ������������������ӿ졢�Ļţ�ƣ���֢��");
			c.setBelongQuTiHua0("���");
		} else if (quTiHua <= 3.5) {
			c.setBelongQuTiHua("�ж����廯:��������������ٴ�����жȲ���������֢״���������������ء�����ͷ�Ρ�ͷ�͡�������ʳ������������θ�ͣ��Ļš������죬���ƣ��������٣�ƣ����������֢��");
			c.setBelongQuTiHua0("�ж�");
		} else {
			c.setBelongQuTiHua("�ض����廯:��������������ٴ�����ضȲ���������֢״���������������ء�����ͷ�Ρ�ͷ�͡��ļ¡�������������Ϣ�У�θ�ɲ���ͣ�ǿ�������־�С�");
			c.setBelongQuTiHua0("�ض�");
		}

		// ǿ��֢
		if (qiangPoZheng < 1.4) {
			c.setBelongQiangPoZheng("��ǿ��֢״");
			c.setBelongQiangPoZheng0("��");
		} else if (qiangPoZheng <= 2.4) {
			c.setBelongQiangPoZheng("���ǿ��֢״:����Ϊ���ġ����¶�����˼��ĳЩ��ͷ���뷨����ʱ����Ϊ�����ظ���������ϴ�ֻ�һЩ����Ķ�������ʱ��϶̣��̶Ƚ��ᣬ����Щʹ�࣬�����ܹ�����");
			c.setBelongQiangPoZheng0("���");
		} else if (qiangPoZheng <= 3.5) {
			c.setBelongQiangPoZheng("�ж�ǿ��֢״:�����ظ������������࣬�򷴸�˼�����Ծ��ޱ�Ҫ�����޷����ƣ������Խ��ǣ���һ����ҽ��Ϊ��ǿ��˼ά��ǿ����Ϊÿ�տɴ-��Сʱ��");
			c.setBelongQiangPoZheng0("�ж�");
		} else {
			c.setBelongQiangPoZheng("�ض�ǿ��֢״:ǿ��˼ά��ǿ����Ϊÿ�տɴ�6-8Сʱ������Ӱ����Ṧ�ܺ�����ܡ���֪û��Ҫ�����޷����ܣ�����ʮ��ʹ�ࡣ���֮�����������ɡ����ʸУ�������ã��ֱ����ǡ�������֧�䣬�ٴ����ظ�������");
			c.setBelongQiangPoZheng0("�ض�");
		}

		// �˼ʹ�ϵ
		if (renJiGuanXi < 1.4) {
			c.setBelongRenJiGuanXi("���˼ʹ�ϵ��������");
			c.setBelongRenJiGuanXi0("��");
		} else if (renJiGuanXi <= 2.4) {
			c.setBelongRenJiGuanXi("����˼ʹ�ϵ��������:�Ը�������������С���С���׺��ߡ�����ϴ�������ʱ�������������ʹ�ࡣ");
			c.setBelongRenJiGuanXi0("���");
		} else if (renJiGuanXi <= 3.5) {
			c.setBelongRenJiGuanXi("�ж��˼ʹ�ϵ��������:������������ǰ�ི��������Ϊ���С��������׺��ߡ��Ա��˽����Ƚ����ģ������ı��������Լ�����ʱ�Ա����о�������״̬������С�Ľ�����");
			c.setBelongRenJiGuanXi0("�ж�");
		} else {
			c.setBelongRenJiGuanXi("�ض��˼ʹ�ϵ��������:ƽʱ�����򣬳���������ж������˽������Ա��˵�̸�۹��ȹ�ע����������Ϊ���񾭹���״̬����ʱ��ȡָ����˵ķ�������ʹ���Ѽ��١�");
			c.setBelongRenJiGuanXi0("�ض�");
		}

		// ����
		if (yiYu < 1.4) {
			c.setBelongYiYu("������֢״");
			c.setBelongYiYu0("��");
		} else if (yiYu <= 2.4) {
			c.setBelongYiYu("�������֢״�����������Եͣ�����Ƿ�ѡ���Ȥ�½���ż�з��꣬��Ը���˽�����ʱ��˯�߲���Ρ�");
			c.setBelongYiYu0("���");
		} else if (yiYu <= 3.5) {
			c.setBelongRenJiGuanXi("�ж�����֢״:�������۽ϵͣ������������ԣ����г�ü����״̬����Ȥ���ˡ���ʱ�������е�����̫�۵��뷨��ʧ�߳�����ʳ������");
			c.setBelongYiYu0("�ж�");
		} else {
			c.setBelongYiYu("�ض�����֢״:�������۵ͣ������Լ����ã������������ԣ����ճ�ü��չ��������ʱ����������С������У����������ʳ�����ˣ���ʳ����");
			c.setBelongYiYu0("�ض�");
		}

		// ����
		if (jiaoLv < 1.4) {
			c.setBelongJiaoLv("�޽���֢״");
			c.setBelongJiaoLv0("��");
		} else if (jiaoLv <= 2.4) {
			c.setBelongJiaoLv("��Ƚ���֢״��Ī�����ģ����µĸо����ɰ��Ļš������ӿ죬�׽��ţ��ູ�������ξٶ���");
			c.setBelongJiaoLv0("���");
		} else if (jiaoLv <= 3.5) {
			c.setBelongJiaoLv("�жȽ���֢״:Ī�����ġ����ţ��޷����εĽ���״̬�����������Ļţ����г�������ָ��΢��������ʱ��������������");
			c.setBelongJiaoLv0("�ж�");
		} else {
			c.setBelongJiaoLv("�ضȽ���֢״:���ԵĽ��Ų�����Ԥ�л���Ҫ�������������������������죬�����ӿ졢�Ļš��������̣����ؾ��ַ���ʱ�����б����С�");
			c.setBelongJiaoLv0("�ض�");
		}

		// �ж�
		if (diDui < 1.4) {
			c.setBelongDiDui("�޵ж�֢״");
			c.setBelongDiDui0("��");
		} else if (diDui <= 2.4) {
			c.setBelongDiDui("��ȵж�֢״�����ж��ɣ��������˶��������������ߣ���ע������Ϊ��̬���Ƿ��Ѻã��׷�Ƣ����");
			c.setBelongDiDui0("���");
		} else if (diDui <= 3.5) {
			c.setBelongDiDui("�жȵж�֢״:�����Խϸߣ�����ע����ɱ��˵ľٶ��������������ദ��ż���ƻ�����Ϊ��");
			c.setBelongDiDui0("�ж�");
		} else {
			c.setBelongDiDui("�ضȵж�֢״:�������أ��������ɱ��˲�ȡ��ʩ�Ⱥ��Լ���������ŭ����������ǿ�����Խ��ˤ������й�����������ദ�����������˶��޷��Ѻ��ദ��");
			c.setBelongDiDui0("�ض�");
		}

		// �ֲ�
		if (kongBu < 1.4) {
			c.setBelongKongBu("�޿ֲ�֢״");
			c.setBelongKongBu0("��");
		} else if (kongBu <= 2.4) {
			c.setBelongKongBu("��ȿֲ�֢״:�����־�����أ���������飬�ض������ֲ������������˽����������������Σ��Թ���Ӱ�첻��");
			c.setBelongKongBu0("���");
		} else if (kongBu <= 3.5) {
			c.setBelongKongBu("�жȿֲ�֢״:������ȡ�ӱ���Ϊ����Ҫ���Ļ�ȱ����ȫ�У����Ҷ������־�ռ䳡����ǿ��ȥʱ����ֽ��š����ǡ�������֢������������ӿ졢�Ļŵ�֢��");
			c.setBelongKongBu0("�ж�");
		} else {
			c.setBelongKongBu("�ضȿֲ�֢״:���Լ����ֲ��Ķ����޷��Ӵ�������ȡǿ�ҵ��ӱ���Ϊ������š����ǣ�����ʱ��������ʣ���������������������У�����Ӱ�칤�����ճ����");
			c.setBelongKongBu0("�ض�");
		}

		// ƫִ
		if (pianZhi < 1.4) {
			c.setBelongPianZhi("��ƫִ֢״");
			c.setBelongPianZhi0("��");
		} else if (pianZhi <= 2.4) {
			c.setBelongPianZhi("���ƫִ֢״:�Ը��ִ�����ϡ��еж��ԣ����ɣ����������ζȲ��㣬ż�б������뷨��");
			c.setBelongPianZhi0("���");
		} else if (pianZhi <= 3.5) {
			c.setBelongPianZhi("�ж�ƫִ֢״:���ж��ɣ���Ϊ���˺��Լ�����ȥ��Ҫ�Ⱥ��Լ��������˵ľٶ�����Ϊ���Լ���أ��б����ٸл򱻼��ӸС�");
			c.setBelongPianZhi0("�ж�");
		} else {
			c.setBelongPianZhi("�ض�ƫִ֢״:���������ˣ���������������ı�Ⱥ���Ϊ�������ӸУ������ٸУ�������ȡ�ӱ���Ϊ�����߽��š����¡����ҳ��ţ��ճ������ܵ�Ӱ�졣");
			c.setBelongPianZhi0("�ض�");
		}

		// ������
		if (jingShenBing < 1.4) {
			c.setBelongJingShenBing("�޾�����֢״");
			c.setBelongJingShenBing0("��");
		} else if (jingShenBing <= 2.4) {
			c.setBelongJingShenBing("��Ⱦ�����֢״:ż�л�������Ϊ������ָ���Ⱥ������ݣ��б��Ⱥ���Ϊ���룬�ɳ���˼ά����Ϥ�У����еж��ԣ������������򣬰��й¶��С�  ");
			c.setBelongJingShenBing0("���");
		} else if (jingShenBing <= 3.5) {
			c.setBelongJingShenBing("�жȾ�����֢״:���л��������ݶ�Ϊ�����������ʱ���������Կ䡢�����Ϊ����Ҫ�����������������н�����������˼ά����Ϥ�У���ɢ�С�����������ʱ�й¶��� ");
			c.setBelongJingShenBing0("�ж�");
		} else {
			c.setBelongJingShenBing("�ضȾ�����֢״:�л����������ݶ�Ϊ������������б����ʱ�����ڻ����У��������˽Ӵ���̸���Ұ������Է��������������������˼ά����Ϥ�У���е������ƶ�û���ж����ɡ����������Ի���֧�����������˻����������Ϊ��������������С��¶��С�");
			c.setBelongJingShenBing0("�ض�");
		}

		// ����
		if (qiTa < 1.4) {
			c.setBelongQiTa("��");
		} else if (qiTa <= 2.4) {
			c.setBelongQiTa("���");
		} else if (qiTa <= 3.5) {
			c.setBelongQiTa("�ж�");
		} else {
			c.setBelongQiTa("�ض�");
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
