$(document).ready(function(){
	if($("#ji_chu_xin_xi_id").val()=='') {
		$("#save").attr("disabled", true);
	}
});

$(document).ready(function(){
	
	$("#zwsjgntjc").change(function(){
		var zw = $("#zwsjgntjc").val();
		if(zw=='0') {
			$("#zwsjgntj").attr("checked", false);
		} else {
			$("#zwsjgntj").attr("checked", true);
		}
	});
	$("#ngntjc").change(function(){
		var ng = $("#ngntjc").val();
		if(ng =='0'){
			$("#ngntj").attr("checked",false);
		} else {
			$("#ngntj").attr("checked",true);
		}
		
	});
	$("#swfktjc").change(function(){
		var sw = $("#swfktjc").val();
		if(sw == '0'){
			$("#swfktj").attr("cheched",false);
		} else {
			$("#swfktj").attr("checked",true);
		}
	});
	$("#jlccjzlc").change(function(){
		var jl = $("#jlccjzlc").val();
		if(jl =='0'){
			$("#jlccjzl").attr("checked",false);
		} else {
			$("#jlccjzl").attr("checked",true);
		}
	});
	$("#wlzlc").change(function(){
		var wl = $("#wlzlc").val();
		if(wl == '0'){
			$("#wlzl").attr("checked",false);
		} else {
			$("#wlzl").attr("checked",true);
		}
	});
	$("#xlzlc").change(function(){
		var xl = $("#xlzlc").val();
		if(xl =='0'){
			$("#xlzl").attr("checked",false);
		} else {
			$("#xlzl").attr("checked",true);
		}
	});
	$("#rzxwlfc").change(function(){
		var rz = $("#rzxwlfc").val();
		if(rz =='0'){
			$("#rzxwlf").attr("checked",false);
		} else{
			$("#rzxwlf").attr("checked",true);
		}
	});
	$("#spzlc").change(function(){
		var sp = $("#splfc").val();
		if(sp =='0'){
			$("#spzl").attr("checked",false);
		} else{
			$("#spzl").attr("checked",true);
		}
	});
	$("#ttzlc").change(function(){
		var tt = $("#ttzlc").val();
		if(tt =='0'){
			$("#ttzl").attr("checked",false);
		} else {
			$("#ttzl").attr("checked",true);
		}
	});
}); 
function x_z(id) {
    	$.post("jcxx?m=gjjc&x=z",{id:id},function(r){
    		$("#ji_chu_xin_xi_id").val(r.id);
    		$("#yong_hu_id").val(r.yongHuId);
    		$("#ri_qi").val(r.riQi);
    		$("#men_zhen_hao").val(r.menZhenHao);
    		$("#bing_an_hao").val(r.bingAnHao);
    		$("#zhu_guan_yi_shi").val(r.zhuGuanYiShi);
    		$("#suo_shu_ke_shi").val(r.suoShuKeShi);
    		$("#zhuan_ke_yi_sheng").val(r.zhuanKeYiSheng);
    		$("#xing_ming").val(r.xingMing);
    		//$("#xing_bie").val(r.xingBie);
    		if(r.xingBie ==1){
    			$("#xing_bie").val("男");
    		} else if(r.xingBie ==2){
    			$("#xing_bie").val("女");
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
    		
    		if(r.naoDian == true) {
    			$("#nao_dian_btn").css("background-color", "green");
    		} 
    		if(r.ccbt == true) {
    			$("#ccbt_btn").css("background-color", "green");
    		} 
    		if(r.naoRenZhi == true) {
    			$("#nao_ren_zhi_btn").css("background-color", "green");
    		} 
    		if(r.xinLiCePing == true) {
    			$("#xlcp_btn").css("background-color", "green");
    		} 
    		if(r.yingYan == true) {
    			$("#ying_yan_btn").css("background-color", "green");
    		} 
    		if(r.hrv == true) {
    			$("#hrv_btn").css("background-color", "green");
    		}
    		$("#save").attr("disabled", false);
    		fadeOut();
    	}, "json");
    }
    
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

    $(document).ready(function(){
    	$("#xlcp_btn").click(function(){
    		window.open("xzbr?m=ibg&id=" + $("#ji_chu_xin_xi_id").val());
    	});
    	$("#hrv_btn").click(function(){
    		window.open("hrvbg?m=ibg&id=" + $("#ji_chu_xin_xi_id").val() + "&cs=" +$("#ci_shu").val());
    	});
    	$("#nao_dian_btn").click(function(){
    		window.open("ndbg?m=ibg&id=" + $("#ji_chu_xin_xi_id").val() + "&cs=" +$("#ci_shu").val());
    	});
    	
    	$("#showPageCount").text($("#pageCount").val());
    	$("#change_page").change(function(){
			var href="zlfa?m=iZlfaAdd&f=t&pn="+$("#change_page").val();
			aq(href);
		});
    	$("#name").val($("#n").val());
    	
    	isZcXl();
		$("#xin_li_ce_ping").change(function(){
			isZcXl();
		});
	
    	$("#yao_wu").change(function(){
    	
    		$("#one").attr("checked",false);
	    		$("#two").attr("checked",false);
				$("#three").attr("checked",false);
				$("#four").attr("checked",false);
	    		$("#bys").attr("checked",false);
	    		$("#df").attr("checked",false);
	    		
	    		$("#qi_ta_yong_fa").val('');
    		
			$.post("zlfa?m=ggg",{name:$("#yao_wu").val()}, function(r) {
				$("#gui_ge").empty();
				for(var d in r) {
					$("#gui_ge").append("<option value='"+r[d]+"'>"+r[d]+"</option>");
				}
			}, "json");
			$.post("zlfa?m=gyl",{name:$("#yao_wu").val()}, function(r) {
				$("#yong_liang").empty();
				for(var d in r) {
					$("#yong_liang").append("<option value='"+r[d]+"'>"+r[d]+"</option>");
				}
			}, "json");
		});
		
		
    	var clickCount = 0;
    	clickCount = Number($("#click_count").val());
    	
    	$("#yao_wu_add_btn").click(function(){
    		var yongFa = "";
    		if($("#one").attr("checked") == "checked"){
    			yongFa = yongFa + "1/日" + ",";
    		} 
    		if($("#two").attr("checked") == "checked"){
    			yongFa = yongFa + "2/日" + ",";
    		} 
			if($("#three").attr("checked") == "checked"){
    			yongFa = yongFa + "3/日" + ",";
    		} 
			if($("#four").attr("checked") == "checked"){
    			yongFa = yongFa + "4/日" + ",";
    		} 
    		if($("#bys").attr("checked") == "checked"){
    			yongFa = yongFa + "必要时" + ",";
    		} 
    		if($("#df").attr("checked") == "checked"){
    			yongFa = yongFa + "顿服" + ",";
    		}  
    			
    		yongFa = yongFa.slice(0, -1);
    		
    		if($.trim($("#qi_ta_yong_fa").val()) != '') {
    			if(yongFa == '') {
    				yongFa = yongFa + $.trim($("#qi_ta_yong_fa").val());
    			} else {
    				yongFa = yongFa + "," + $.trim($("#qi_ta_yong_fa").val());
    			}
    		}
    		if($.trim($("#gui_ge").val()) == '') {
    			alert('请选择药物！')
    			return false;
    		}
    		
    		if(yongFa == '') {
    			alert('请添加药物用法！')
    			return false;
    		}
    		
    		
    		clickCount += 1;
    		$("#yao_wu_add").before("<tr class='tr"+(clickCount%2==0?2:3)+"' id='yao_wu_add"+clickCount+"'>"
	    			+"<td>"+$("#yao_wu").val()+"</td>"
		    		+"<td>"+$("#gui_ge").val()+"</td>"
	    			+"<td>"+$("#yong_liang").val()+"</td>"
	    			+"<td>"+yongFa+"</td><td><a href='javascript:void(0);' onclick=deleteYao('yao_wu_add"+clickCount+"','"+clickCount+"')>删除</a></td></tr>");
    		$("#yao_wu_zhi_liao").val($("#yao_wu_zhi_liao").val()+"~"+$("#yao_wu").val()+"``"+$("#gui_ge").val()+"``"+$("#yong_liang").val()+"``"+yongFa);
    	});
    	if($("#f").val() == 't') {
    		fadeIn();
    	}
    	
    });
    var delCount = 0;
    var delArray = new Array();
    function deleteYao(id, c) {
    	$("#"+id).remove();
    	delArray[delCount] = c;
    	var delEdt = c;
    	for (var key in delArray){
            if(c > delArray[key]) {
            	delEdt -= 1;
            }
        }
    	
    	delCount += 1;
    	var yw = $("#yao_wu_zhi_liao").val().split("~");
    	var y = yw.splice(delEdt, 1);
    	var ywzl = yw.join("~");
    	$("#yao_wu_zhi_liao").val(ywzl);
    }