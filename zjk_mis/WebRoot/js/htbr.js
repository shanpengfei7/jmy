
function fadeIns(id) {
    document.getElementById(id).className = 'modal';
}

function fadeOuts(id) {
    document.getElementById(id).className = 'modal hide';
}

function x_z(id) {
	$.post("jcxx?m=gjc",{id:id},function(r){
		$("#yong_hu_id").val(r.yongHuId);
		$("#ri_qi").val(r.riQi);
		$("#men_zhen_hao").val(r.menZhenHao);
		$("#bing_an_hao").val(r.bingAnHao);
		$("#xing_ming").val(r.xingMing);
		$("#xing_bie").val(r.xingBie);
		if(r.xingBie == 1) {
			$("#nan").attr("checked", true);
		} else if(r.xingBie == 2) {
			$("#nv").attr("checked", true);
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
		/*$("#jia_li_pai_hang_1").val(r.paiHang1);
		$("#jia_li_pai_hang_2").val(r.paiHang2);*/
		jQuery("#jia_li_pai_hang_1").val(r.paiHang1);
		jQuery("#jia_li_pai_hang_2").val(r.paiHang2);
		if(r.jingJiZhuangKuang == 1) {
			$("#liang_hao").attr("checked", true);
		} else if(r.jingJiZhuangKuang == 2) {
			$("#yi_ban").attr("checked", true);
		} else if(r.jingJiZhuangKuang == 3) {
			$("#jiao_cha").attr("checked", true);
		} else if(r.jingJiZhuangKuang == 4) {
			$("#hen_cha").attr("checked", true);
		}
		
		$("#lian_xi_di_zhi").val(r.lianXiDiZhi);
		$("#lian_xi_dian_hua").val(r.lianXiDianHua);
		fadeOuts('formTable_jcxx');
	}, "json");
}