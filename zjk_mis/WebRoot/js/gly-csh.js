/**
 * Created by pnfy on 2016/8/25.
 */
$(document).ready(function(){
    	$("#shou_ji_hao_add").change(function(){
   			$("#den_lu_hao_add").val($("#shou_ji_hao_add").val());
   			$.post("login?m=hdl", {h:$("#den_lu_hao_add").val()}, function(r){
    			if(r == 'true') {
    				alert('该用户已存在！！');
    			}
    		});
    	});
    	$("#den_lu_hao_add").change(function(){
    		$.post("login?m=hdl", {h:$("#den_lu_hao_add").val()}, function(r){
    			if(r == 'true') {
    				alert('该用户已存在！！');
    			}
    		});
    	});
    	$("#deng_lu_hao_edit").change(function(){
    		$.post("login?m=hdl", {h:$("#deng_lu_hao_edit").val()}, function(r){
    			if(r == 'true') {
    				alert('该用户已存在！！');
    			}
    		});
    	});
    	
    	
    	$("#form_yi_yuan_add").submit(function(){
    		$("#yi_yuan_ming_cheng_add").click(function(){
    			$("#yi_yuan_ming_cheng_add").css("color","#000");
    		});
    		$("#shou_ji_hao_add").click(function(){
    			$("#shou_ji_hao_add").css("color","#000");
    		});
    		$("#den_lu_hao_add").click(function(){
    			$("#den_lu_hao_add").css("color","#000");
    		});
    		$("#mi_ma_add").click(function(){
    			$("#mi_ma_add").css("color","#000");
    		});
    		$("#yi_yuan_dai_hao_add").click(function(){
    			$("#yi_yuan_dai_hao_add").css("color","#000");
    		});
    		if($.trim($("#yi_yuan_ming_cheng_add").val())=='') {
    			$("#yi_yuan_ming_cheng_add").css("color", "red");
    			return false;
    		}else
    		if($.trim($("#shou_ji_hao_add").val())=='') {
    			$("#shou_ji_hao_add").css("color", "red");
    			return false;
    		}else
    		if($.trim($("#den_lu_hao_add").val())=='') {
    			$("#den_lu_hao_add").css("color", "red");
    			return false;
    		}/*else
    		if($.trim($("#mi_ma_add").val())=='') {
    			$("#mi_ma_add").css("color", "red");
    			return false;
    		}*/else
    		if($.trim($("#yi_yuan_dai_hao_add").val())=='') {
    			$("#yi_yuan_dai_hao_add").css("color", "red");
    			return false;
    		} else {
    		fadeOut('yi_yuan_add');
    		document.getElementById("mi_ma_add").value = hex_md5(document.getElementById("mi_ma_add").value);
    		}
    		});
    	
    	$("#form_yi_yuan_edit").submit(function(){
    		if($.trim($("#mi_ma_edit").val()) == "") {
    			$("#mi_ma_edit").val($("#dlmm_edit").val());
    		}else {
    			document.getElementById("mi_ma_edit").value = hex_md5(document.getElementById("mi_ma_edit").value);
    		}
    	});
    });

	
$(document).ready(function(){
	$("#yi_yuan_tian_jia").click(function(){
		$.post("csh?m=gSheng",function(r){
			$("#sheng_add").empty();
			$("#sheng_add").append("<option value='0'>请选择</option>");
			for(var d in r) {
				$("#sheng_add").append("<option value='"+r[d]+"'>"+r[d]+"</option>");
			}
		}, "json");
		fadeIn('yi_yuan_add');
	});
	$("#sheng_add").change(function(){
		if($("#sheng_add").val() != 0) {
			$.post("csh?m=gShi",{name: $("#sheng_add").val()},function(r){
				$("#shi_add").empty();
				$("#shi_add").append("<option value='0'>请选择</option>");
				for(var d in r) {
					$("#shi_add").append("<option value='"+d+"'>"+d+"</option>");
				}
			}, "json");
		}
	});
	$("#shi_add").change(function(){
		if($("#shi_add").val() != 0) {
			$.post("csh?m=gXian",{name: $("#shi_add").val()},function(r){
				$("#xian_add").empty();
				$("#xian_add").append("<option value='0'>请选择</option>");
				for(var d in r) {
					$("#xian_add").append("<option value='"+d+"'>"+d+"</option>");
				}
			}, "json");
		}
	});
	$("#xian_add").change(function(){
		if($("#xian_add").val() != 0) {
			
			$.post("csh?m=gYyDh",{name: $("#xian_add").val()},function(r){
				$("#yi_yuan_dai_hao_add").val(r.daihao);
			}, "json");
		}
	});
})

function edited(key, id) {
	$.post("csh?m=gYy",{id:key},function(r){
		$("#yi_yuan_ming_cheng_edit").val(r.mc);
		$("#shou_ji_hao_edit").val(r.dh);
		$("#deng_lu_hao_edit").val(r.dlh);
		$("#yyId").val(key);
		$("#dlId").val(r.dlId);
		$("#dlmm_edit").val(r.dlmm);
		fadeIn(id);
	},"json");
}

function deleted(id) {
	if(confirm("您确定要禁用这所医院吗？")) {
		$.post("csh?m=dYy",{id:id},function(r){
			window.location.href="csh?m=iGlyCsh";
		});
	}
	
}

function will_deleted(id) {
	if(confirm("您确定要启用这所医院吗？")) {
		$.post("csh?m=wdYy",{id:id},function(r){
			window.location.href="csh?m=iGlyCsh";
		});
	}
	
}

function fadeIn(id) {
    document.getElementById(id).className = 'modal';
}

function fadeOut(id) {
    document.getElementById(id).className = 'modal hide';
}