$(document).ready(function(){
	var xlcp_count = $("#xlcp_count").val();
	for(var i = 0; i < xlcp_count; i++) {
		$("#xin_li_ce_ping_xiang_mu").val($("#xin_li_ce_ping_xiang_mu").val() + "|" + $("#lb" + i).val());
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
});