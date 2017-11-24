$(document).ready(function(){
	if($("#ji_chu_xin_xi_id").val()==''){
		$("#save").attr("disabled",true);
	}
});

$(document).ready(function(){
	$("#showPageCount").text($("#pageCount").val());
	$("#change_page").change(function(){
		var href="jcxm?m=iJcxmAdd&j=t&pn="+$("#change_page").val();
		aq(href);
	});
	$("#name").val($("#n").val());
	
	isZcXl();
	$("#xin_li_ce_ping").change(function(){
		isZcXl();
	});
	if($("#j").val() == 't') {
		fadeIn();
	}
	
});

function isZcXl(){
	if($("#xin_li_ce_ping").attr("checked") == "checked") {
		jcXl();
	} else{
		jzXl();
	}
}

function jzXl(){
	$("#ti_zhi_fen_xi").attr("disabled", true);
	$("#hm").attr("disabled", true);
	$("#yy").attr("disabled", true);
	$("#wcpa").attr("disabled", true);
	$("#zz").attr("disabled", true);
	$("#ask").attr("disabled", true);
	$("#js").attr("disabled", true);
	$("#zk").attr("disabled", true);
	$("#cd").attr("disabled", true);
	$("#cgc").attr("disabled", true);
	$("#yinx").attr("disabled", true);
	$("#yangx").attr("disabled", true);
	$("#qp").attr("disabled", true);
	$("#yyzsc").attr("disabled", true);
	$("#gfxjl").attr("disabled", true);
}
function jcXl(){
	$("#ti_zhi_fen_xi").attr("disabled", false);
	$("#hm").attr("disabled", false);
	$("#yy").attr("disabled", false);
	$("#wcpa").attr("disabled", false);
	$("#zz").attr("disabled", false);
	$("#ask").attr("disabled", false);
	$("#js").attr("disabled", false);
	$("#zk").attr("disabled", false);
	$("#cd").attr("disabled", false);
	$("#cgc").attr("disabled", false);
	$("#yinx").attr("disabled", false);
	$("#yangx").attr("disabled", false);
	$("#qp").attr("disabled", false);
	$("#yyzsc").attr("disabled", false);
	$("#gfxjl").attr("disabled", false);
}

	function x_z(id) {
		
    	$.post("jcxx?m=gjjc&x=j",{id:id},function(r){
    		
    		if(r.ciShu == 0 && r.cs == undefined) {
    			retFun(r);
    		} else if(r.ciShu == r.cs) {
    			retFun(r);
    		} else{
    			alert('您还未填写诊疗方案！！');
    			fadeOut();
    		}
    		
    	}, "json");
    }
	
	function retFun(r) {
		$("#ji_chu_xin_xi_id").val(r.id);
		$("#yong_hu_id").val(r.yongHuId);
		$("#ri_qi").val(r.riQi);
		$("#men_zhen_hao").val(r.menZhenHao);
		$("#bing_an_hao").val(r.bingAnHao);
		$("#zhu_guan_yi_shi").val(r.zhuGuanYiShi);
		$("#suo_shu_ke_shi").val(r.suoShuKeShi);
		$("#zhuan_ke_yi_sheng").val(r.zhuanKeYiSheng);
		$("#xing_ming").val(r.xingMing);
		if(r.xingBie == 1) {
			$("#xing_bie").val('男');
		}
		if(r.xingBie == 2) {
			$("#xing_bie").val('女');
		}
		$("#nian").val(r.chuShengNian);
		$("#yue").val(r.chuShengYue);
		$("#ri").val(r.chuShengRi);
		$("#min_zu").val(r.minZu);
		$("#hun_yin_zhuang_kuang").val(r.hunYinZhuangKuang);
		$("#shen_gao").val(r.shenGao);
		$("#ti_zhong").val(r.tiZhong);
		$("#chu_sheng_di").val(r.chuShengDi);
		$("#zhi_ye").val(r.zhiYe);
		$("#wen_hua_cheng_du").val(r.wenHuaChengDu);
		$("#jia_li_pai_hang_1").val(r.paiHang1);
		$("#jia_li_pai_hang_2").val(r.paiHang2);
		
		var jjzk = "";
		if(r.jingJiZhuangKuang == 1) {
			jjzk = "良好";
		} else if(r.jingJiZhuangKuang == 2) {
			jjzk = "一般";
		} else if(r.jingJiZhuangKuang == 3) {
			jjzk = "较差";
		} else if(r.jingJiZhuangKuang == 4) {
			jjzk = "很差";
		}
		
		$("#jiang_ji_zhuang_kuang").val(jjzk);
		$("#lian_xi_di_zhi").val(r.lianXiDiZhi);
		$("#lian_xi_dian_hua").val(r.lianXiDianHua);
		$("#ci_shu").val(r.ciShu);
		$("#ci_shu_j").val(r.cs);
		$("#save").attr("disabled",false);
		if(r.xinLiCePingXiangMu != undefined) {
			/*fadeOut();*/
			var jc = r.jianCeXiangMu.split("|");
			for(var j in jc) {
				if(jc[j] == "脑电") {
					$("#nao_dian").attr("checked", true);
				} 
				if(jc[j] == "CCBT") {
					$("#ccbt").attr("checked", true);
				} 
				if(jc[j] == "脑认知") {
					$("#nao_ren_zhi").attr("checked", true);
				}
				if(jc[j] == "心理测评") {
					$("#xin_li_ce_ping").attr("checked", true);
				} 
				if(jc[j] == "鹰演") {
					$("#ying_yan").attr("checked", true);
				} 
				if(jc[j] == "HRV") {
					$("#hrv").attr("checked", true);
				}
			}
		}
		if(r.xinLiCePingXiangMu != undefined) {
			var xl = r.xinLiCePingXiangMu.split("|");
			for(var x in xl) {
				if(xl[x] == "体质分析量表") {
					$("#ti_zhi_fen_xi").attr("checked", true);
				}
				if(xl[x] == "汉密顿焦虑量表") {
					$("#hm").attr("checked", true);
				}
				if(xl[x] == "汉密顿抑郁量表") {
					$("#yy").attr("checked", true);
				}
				if(xl[x] == "WCPA躯体症状分类量表") {
					$("#wcpa").attr("checked", true);
				}
				if(xl[x] == "90项症状清单") {
					$("#zz").attr("checked", true);
				}
				if(xl[x] == "艾森克个性测验") {
					$("#ask").attr("checked", true);
				}
				if(xl[x] == "简明精神病量表") {
					$("#js").attr("checked", true);
				}
				if(xl[x] == "躁狂量表") {
					$("#zk").attr("checked", true);
				}
				if(xl[x] == "痴呆简易筛查量表") {
					$("#cd").attr("checked", true);
				}
				if(xl[x] == "长谷川痴呆量表") {
					$("#cgc").attr("checked", true);
				}
				if(xl[x] == "阴性症状量表") {
					$("#yinx").attr("checked", true);
				}
				if(xl[x] == "阳性症状量表") {
					$("#yangx").attr("checked", true);
				}
				if(xl[x] == "强迫量表") {
					$("#qp").attr("checked", true);
				} 
				if(xl[x] == "抑郁症筛查量表") {
					$("#yyzsc").attr("checked", true);
				}
				if(xl[x] == "广泛性焦虑量表") {
					$("#gfxjl").attr("checked", true);
				} 
				
			}
		}
		isZcXl();
		fadeOut();
	}