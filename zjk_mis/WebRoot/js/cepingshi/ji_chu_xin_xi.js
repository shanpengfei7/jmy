$(document).ready(function(){
	
	/*就诊原因*/
	var jzyy = $("#jiu_zhen_yuan_yin").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "疾病问题") {
			$("#ji_bing_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "睡眠问题") {
			$("#shui_mian_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "情绪问题") {
			$("#qing_xu_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "认知问题") {
			$("#ren_zhi_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "记忆问题") {
			$("#ji_yi_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "注意力问题") {
			$("#zhu_yi_li_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "人际关系") {
			$("#ren_ji_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "婚恋情感") {
			$("#hun_lian_qing_gan").attr("checked",true);
		}
		else if(jzyy[j] == "工作问题") {
			$("#gong_zuo_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "学习问题") {
			$("#xue_xi_wen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "个性问题") {
			$("#ge_xing_wen_ti").attr("checked",true);
		}
		else{
			$("#jiu_zhen_yuan_yin_qi_ta").val(jzyy[j]);
		}
	}
	
	/*睡眠*/
	var jzyy = $("#shui_mian").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "良好") {
			$("#shui_mian_liang_hao").attr("checked",true);
		}
		else if(jzyy[j] == "一般") {
			$("#shui_mian_yi_ban").attr("checked",true);
		}
		else if(jzyy[j] == "欠佳") {
			$("#shui_mian_qian_jia").attr("checked",true);
		}
		else if(jzyy[j] == "入睡困难") {
			$("#ru_shui_kun_nan").attr("checked",true);
		}
		else if(jzyy[j] == "早醒") {
			$("#shui_mian_zao_xing").attr("checked",true);
		}
		else if(jzyy[j] == "睡眠深度不足") {
			$("#shui_mian_shen_du_bu_zu").attr("checked",true);
		}
		else if(jzyy[j] == "嗜睡") {
			$("#shui_mian_shi_shui").attr("checked",true);
		}
		else if(jzyy[j] == "醒后无力") {
			$("#xing_hou_wu_li").attr("checked",true);
		}
		else if(jzyy[j] == "多梦") {
			$("#duo_meng").attr("checked",true);
		}
	}
	
	
	/*出现1*/
	var jzyy = $("#chu_xian1").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "情绪低落") {
			$("#qing_xu_di_luo").attr("checked",true);
		}
		else if(jzyy[j] == "烦燥易怒") {
			$("#fan_zao_yi_nu").attr("checked",true);
		}
		else if(jzyy[j] == "兴奋躁动") {
			$("#xing_fun_zao_daog").attr("checked",true);
		}
		else if(jzyy[j] == "神经衰弱") {
			$("#shen_jing_shuai_ruo").attr("checked",true);
		}
		else if(jzyy[j] == "情感淡漠") {
			$("#qing_gan_dan_mo").attr("checked",true);
		}
		else if(jzyy[j] == "消极悲观") {
			$("#xiao_ji_bei_guan").attr("checked",true);
		}
		else if(jzyy[j] == "兴趣下降") {
			$("#xing_qu_xia_jiang").attr("checked",true);
		}
	}
	
	
	
	/*出现2*/
	var jzyy = $("#chu_xian2").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "注意分散") {
			$("#zhu_yi_fen_san").attr("checked",true);
		}
		else if(jzyy[j] == "记忆障碍") {
			$("#ji_yi_zhang_ai").attr("checked",true);
		}
		else if(jzyy[j] == "错觉") {
			$("#cuo_jue").attr("checked",true);
		}
		else if(jzyy[j] == "幻觉") {
			$("#huan_jue").attr("checked",true);
		}
		else if(jzyy[j] == "妄想") {
			$("#wang_xiang").attr("checked",true);
		}
		else if(jzyy[j] == "意识障碍") {
			$("#yi_shi_zhang_ai").attr("checked",true);
		}
		else if(jzyy[j] == "行为障碍") {
			$("#xing_wei_zhang_ai").attr("checked",true);
		}
		else if(jzyy[j] == "行为退缩") {
			$("#xing_wei_tui_suo").attr("checked",true);
		}
		else if(jzyy[j] == "生活懒散") {
			$("#sheng_huo_lan_san").attr("checked",true);
		}
		else if(jzyy[j] == "意志力下降") {
			$("#yi_zhi_li_xia_jiang").attr("checked",true);
		}
	}	
		
		
	/*人格特质*/
	var jzyy = $("#ren_ge_te_zhi").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "平淡") {
			$("#ping_dan").attr("checked",true);
		}
		else if(jzyy[j] == "淡漠") {
			$("#dan_mo").attr("checked",true);
		}
		else if(jzyy[j] == "活跃") {
			$("#huo_yue").attr("checked",true);
		}
		else if(jzyy[j] == "敌意") {
			$("#di_yi").attr("checked",true);
		}
	}		
	
	
	/*兴趣*/
	var jzyy = $("#xing_qu").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "读书") {
			$("#du_shu").attr("checked",true);
		}
		else if(jzyy[j] == "听音乐") {
			$("#ting_yin_yue").attr("checked",true);
		}
		else if(jzyy[j] == "唱歌") {
			$("#chang_ge").attr("checked",true);
		}
		else if(jzyy[j] == "跳舞") {
			$("#tiao_wu").attr("checked",true);
		}
		else if(jzyy[j] == "琴棋") {
			$("#qin_qi").attr("checked",true);
		}
		else if(jzyy[j] == "书画") {
			$("#shu_hua").attr("checked",true);
		}
		else if(jzyy[j] == "体育") {
			$("#ti_yu").attr("checked",true);
		}
		else if(jzyy[j] == "影视（喜剧）") {
			$("#ying_shi_xi_ju").attr("checked",true);
		}
		else if(jzyy[j] == "影视（悲剧）") {
			$("#ying_shi_bei_ju").attr("checked",true);
		}
	}
	
	
	/*生长发育*/
	var jzyy = $("#sheng_zhang_fa_yu").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "足月") {
			$("#zu_yue").attr("checked",true);
		}
		else if(jzyy[j] == "顺产") {
			$("#shun_chan").attr("checked",true);
		}
		else if(jzyy[j] == "早产") {
			$("#zao_chan").attr("checked",true);
		}
		else if(jzyy[j] == "剖腹产") {
			$("#pao_fu_chan").attr("checked",true);
		}
		else if(jzyy[j] == "难产") {
			$("#nan_chan").attr("checked",true);
		}
		else if(jzyy[j] == "母乳") {
			$("#mu_ru").attr("checked",true);
		}
	}	
	
	
	
	/*幼年抚养人*/
	var jzyy = $("#you_nian_fu_yang_ren").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "祖父/母") {
			$("#zu_fu_mu").attr("checked",true);
		}
		else if(jzyy[j] == "外祖父/母") {
			$("#wai_zu_fu_mu").attr("checked",true);
		}
		else if(jzyy[j] == "父") {
			$("#fu_mu").attr("checked",true);
		}
		else if(jzyy[j] == "兄") {
			$("#xiong").attr("checked",true);
		}
		else if(jzyy[j] == "姐") {
			$("#jie").attr("checked",true);
		}
	}		
	
	
	/*幼年生活环境*/
	var jzyy = $("#you_nian_sheng_huo_huan_jing").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "和谐") {
			$("#you_nian_huan_jing_he_xie").attr("checked",true);
		}
		else if(jzyy[j] == "温暖") {
			$("#you_nian_huan_jing_wen_nuan").attr("checked",true);
		}
		else if(jzyy[j] == "一般") {
			$("#you_nian_huan_jing_yi_ban").attr("checked",true);
		}
		else if(jzyy[j] == "冷淡") {
			$("#you_nian_huan_jing_leng_dan").attr("checked",true);
		}
		else if(jzyy[j] == "敌意") {
			$("#you_nian_huan_jing_di_yi").attr("checked",true);
		}
		else if(jzyy[j] == "依赖") {
			$("#you_nian_huan_jing_yi_lai").attr("checked",true);
		}
		else if(jzyy[j] == "过度保护") {
			$("#you_nian_huan_jing_guo_du_bao_hu").attr("checked",true);
		}
		else if(jzyy[j] == "过度忽略") {
			$("#you_nian_huan_jing_guo_du_hu_lue").attr("checked",true);
		}
		else if(jzyy[j] == "民主") {
			$("#you_nian_huan_jing_min_zhu").attr("checked",true);
		}
		else if(jzyy[j] == "专制") {
			$("#you_nian_huan_jing_zhuan_zhi").attr("checked",true);
		}
	}	

	
	
	/*现在生活环境*/
	var jzyy = $("#xian_zai_sheng_huo_huan_jing").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "和谐") {
			$("#xian_zai_huan_jing_he_xie").attr("checked",true);
		}
		else if(jzyy[j] == "温暖") {
			$("#xian_zai_huan_jing_wen_nuan").attr("checked",true);
		}
		else if(jzyy[j] == "一般") {
			$("#xian_zai_huan_jing_yi_ban").attr("checked",true);
		}
		else if(jzyy[j] == "冷淡") {
			$("#xian_zai_huan_jing_leng_dan").attr("checked",true);
		}
		else if(jzyy[j] == "敌意") {
			$("#xian_zai_huan_jing_di_yi").attr("checked",true);
		}
		else if(jzyy[j] == "依赖") {
			$("#xian_zai_huan_jing_yi_lai").attr("checked",true);
		}
		else if(jzyy[j] == "过度保护") {
			$("#xian_zai_huan_jing_guo_du_bao_hu").attr("checked",true);
		}
		else if(jzyy[j] == "过度忽略") {
			$("#xian_zai_huan_jing_guo_du_hu_lue").attr("checked",true);
		}
		else if(jzyy[j] == "民主") {
			$("#xian_zai_huan_jing_min_zhu").attr("checked",true);
		}
		else if(jzyy[j] == "专制") {
			$("#xian_zai_huan_jing_zhuan_zhi").attr("checked",true);
		}
	}	
	
	
	/*问题表现为*/
	var jzyy = $("#wen_ti_biao_xian_wei").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "害羞") {
			$("#wen_ti_biao_xian_hai_xiu").attr("checked",true);
		}
		else if(jzyy[j] == "自卑") {
			$("#wen_ti_biao_xian_zi_bei").attr("checked",true);
		}
		else if(jzyy[j] == "顾虑") {
			$("#wen_ti_biao_xian_gu_lv").attr("checked",true);
		}
		else if(jzyy[j] == "恐惧") {
			$("#wen_ti_biao_xian_kong_jv").attr("checked",true);
		}
		else if(jzyy[j] == "敌对") {
			$("#wen_ti_biao_xian_di_dui").attr("checked",true);
		}
		else if(jzyy[j] == "封闭") {
			$("#wen_ti_biao_xian_feng_bi").attr("checked",true);
		}
		else if(jzyy[j] == "误会") {
			$("#wen_ti_biao_xian_wu_hui").attr("checked",true);
		}
		else if(jzyy[j] == "不会相处") {
			$("#wen_ti_biao_xian_bu_hui_xiang_chu").attr("checked",true);
		}
	}	
	
	
	
	/*问题发生在*/
	var jzyy = $("#wen_ti_fa_sheng_zai").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "上级") {
			$("#wen_ti_fa_sheng_zai_shang_ji").attr("checked",true);
		}
		else if(jzyy[j] == "下级") {
			$("#wen_ti_fa_sheng_zai_xia_ji").attr("checked",true);
		}
		else if(jzyy[j] == "同事") {
			$("#wen_ti_fa_sheng_zai_tong_shi").attr("checked",true);
		}
		else if(jzyy[j] == "同学") {
			$("#wen_ti_fa_sheng_zai_tong_xue").attr("checked",true);
		}
		else if(jzyy[j] == "朋友") {
			$("#wen_ti_fa_sheng_zai_peng_you").attr("checked",true);
		}
		else if(jzyy[j] == "公婆") {
			$("#wen_ti_fa_sheng_zai_gong_po").attr("checked",true);
		}
		else if(jzyy[j] == "岳父母") {
			$("#wen_ti_fa_sheng_zai_yue_fu_mu").attr("checked",true);
		}
		else if(jzyy[j] == "夫妻") {
			$("#wen_ti_fa_sheng_zai_fu_qi").attr("checked",true);
		}
		else if(jzyy[j] == "子女") {
			$("#wen_ti_fa_sheng_zai_zi_nv").attr("checked",true);
		}
		else if(jzyy[j] == "父母") {
			$("#wen_ti_fa_sheng_zai_fu_mu").attr("checked",true);
		}
	}
	
	/*不满意的方面*/
	var jzyy = $("#bu_man_yi").val().split('|');
	for(var j in jzyy) {
		if(jzyy[j] == "身体") {
			$("#bu_man_yi_shen_ti").attr("checked",true);
		}
		else if(jzyy[j] == "工作") {
			$("#bu_man_yi_gong_zuo").attr("checked",true);
		}
		else if(jzyy[j] == "学习") {
			$("#bu_man_yi_xue_xi").attr("checked",true);
		}
		else if(jzyy[j] == "职称") {
			$("#bu_man_yi_zhi_cheng").attr("checked",true);
		}
		else if(jzyy[j] == "经济") {
			$("#bu_man_yi_jing_ji").attr("checked",true);
		}
		else if(jzyy[j] == "住房") {
			$("#bu_man_yi_zhu_fang").attr("checked",true);
		}
		else if(jzyy[j] == "周围环境") {
			$("#bu_man_yi_zhou_wei_huan_jing").attr("checked",true);
		}
		else if(jzyy[j] == "社交环境") {
			$("#bu_man_yi_she_jiao_huan_jing").attr("checked",true);
		}
		else if(jzyy[j] == "家庭环境") {
			$("#bu_man_yi_jia_ting_huan_jing").attr("checked",true);
		}
		else{
			$("#bu_man_yi_fang_mian_qi_ta").val(jzyy[j])
		}
	}
});

