$(document).ready(function(){
	
});

$(document).ready(function(){
	var click_count = $("#click_count").val();
	for(var i = 1; i <= click_count; i++) {
		$("#yao_wu_zhi_liao").val($("#yao_wu_zhi_liao").val() + '~' + $("#y_yao_ming" + i).val() + "``"+ $("#y_gui_ge" + i).val() + "``"+ $("#y_yong_liang" + i).val() + "``"+ $("#y_yong_fa" + i).val());
	}
	
	var xstj = $("#xin_shen_tiao_jie").val();
	var xstjs = xstj.split("|");
	for(var xs in xstjs) {
		var x = xstjs[xs].split(",");
		if(x[0] == '植物神经功能调节') {
			$("#zwsjgntj").attr("checked", true);
			$("#zwsjgntjc").val(x[1]);
		} else if(x[0] == '脑功能调节') {
			$("#ngntj").attr("checked", true);
			$("#ngntjc").val(x[1]);
		} else if(x[0] == '生物反馈调节') {
			$("#swfktj").attr("checked", true);
			$("#swfktjc").val(x[1]);
		} else if(x[0] == '经颅磁刺激治疗') {
			$("#jlccjzl").attr("checked", true);
			$("#jlccjzlc").val(x[1]);
		} else if(x[0] == '物理治疗') {
			$("#wlzl").attr("checked", true);
			$("#wlzlc").val(x[1]);
		} else if(x[0] == '心理治疗') {
			$("#xlzl").attr("checked", true);
			$("#xlzlc").val(x[1]);
		} else if(x[0] == '认知行为疗法') {
			$("#rzxwlf").attr("checked", true);
			$("#rzxwlfc").val(x[1]);
		} else if(x[0] == '沙盘治疗') {
			$("#spzl").attr("checked", true);
			$("#spzlc").val(x[1]);
		} else if(x[0] == '团体治疗') {
			$("#ttzl").attr("checked", true);
			$("#ttzlc").val(x[1]);
		}
	}
	
	
	var jcxm = $("#jian_ce_xiang_mu").val();
	var jcxms = jcxm.split("|");
	for(var j in jcxms) {
		if(jcxms[j] == '脑电') {
			$("#nao_dian").attr("checked", true);
		} else if(jcxms[j] == 'CCBT') {
			$("#ccbt").attr("checked", true);
		} else if(jcxms[j] == '脑认知') {
			$("#nao_ren_zhi").attr("checked", true);
		} else if(jcxms[j] == '心理测评') {
			$("#xin_li_ce_ping").attr("checked", true);
		} else if(jcxms[j] == '鹰演') {
			$("#ying_yan").attr("checked", true);
		} else if(jcxms[j] == 'HRV') {
			$("#hrv").attr("checked", true);
		}
	}
	
	var xlcpxm = $("#xin_li_ce_ping_xiang_mu").val();
	var xlcpxms = xlcpxm.split("|");
	for(var x in xlcpxms) {
		if(xlcpxms[x] == '体质分析量表') {
			$("#ti_zhi_fen_xi").attr("checked", true);
		} else if(xlcpxms[x] == '汉密顿焦虑量表') {
			$("#hm").attr("checked", true);
		} else if(xlcpxms[x] == '汉密顿抑郁量表') {
			$("#yy").attr("checked", true);
		} else if(xlcpxms[x] == 'WCPA躯体症状分类量表') {
			$("#wcpa").attr("checked", true);
		} else if(xlcpxms[x] == '90项症状清单') {
			$("#zz").attr("checked", true);
		} else if(xlcpxms[x] == '艾森克个性测验') {
			$("#ask").attr("checked", true);
		} else if(xlcpxms[x] == '简明精神病量表') {
			$("#js").attr("checked", true);
		} else if(xlcpxms[x] == '躁狂量表') {
			$("#zk").attr("checked", true);
		} else if(xlcpxms[x] == '痴呆简易筛查量表') {
			$("#cd").attr("checked", true);
		} else if(xlcpxms[x] == '长谷川痴呆量表') {
			$("#cgc").attr("checked", true);
		} else if(xlcpxms[x] == '阴性症状量表') {
			$("#yinx").attr("checked", true);
		} else if(xlcpxms[x] == '阳性症状量表') {
			$("#yangx").attr("checked", true);
		} else if(xlcpxms[x] == '强迫量表') {
			$("#qp").attr("checked", true);
		}else if(xlcpxms[x] == "抑郁症筛查量表") {
			$("#yyzsc").attr("checked", true);
		}else if(xlcpxms[x] == "广泛性焦虑量表") {
			$("#gfxjl").attr("checked", true);
		}
	}
	
	var xszd = $("#xin_shen_zhen_duan").val();
	var xszds = xszd.split("|");
	for(var x in xszds) {
		if(xszds[x] == '植物神经功能紊乱') {
			$("#zwsjgnwl").attr("checked", true);
		} else if(xszds[x] == '神经衰弱') {
			$("#sjsr").attr("checked", true);
		} else if(xszds[x] == '睡眠障碍') {
			$("#smza").attr("checked", true);
		} else if(xszds[x] == '躯体化障碍') {
			$("#qthza").attr("checked", true);
		} else if(xszds[x] == '躯体形式障碍') {
			$("#qtxsza").attr("checked", true);
		} else if(xszds[x] == '焦虑状态') {
			$("#jlzt").attr("checked", true);
		} else if(xszds[x] == '焦虑症') {
			$("#jlz").attr("checked", true);
		} else if(xszds[x] == '抑郁状态') {
			$("#yyzt").attr("checked", true);
		} else if(xszds[x] == '抑郁症') {
			$("#yyz").attr("checked", true);
		} else if(xszds[x] == '强迫状态') {
			$("#qpzt").attr("checked", true);
		} else if(xszds[x] == '强迫症') {
			$("#qpz").attr("checked", true);
		} else if(xszds[x] == '疑病症') {
			$("#ybz").attr("checked", true);
		} else if(xszds[x] == '妄想状态') {
			$("#wxzt").attr("checked", true);
		} else if(xszds[x] == '思维障碍') {
			$("#swza").attr("checked", true);
		} else if(xszds[x] == '幻觉状态') {
			$("#hjzt").attr("checked", true);
		} else if(xszds[x] == '双相情感障碍') {
			$("#sxqgza").attr("checked", true);
		} else if(xszds[x] == '躁狂症') {
			$("#zkz").attr("checked", true);
		} else if(xszds[x] == '精神分裂症') {
			$("#jsflz").attr("checked", true);
		} else if(xszds[x] == '适用障碍') {
			$("#syza").attr("checked", true);
		}
	}
});