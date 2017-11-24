$(document).ready(function(){
	
	$("#ke_shi_tian_jia").click(function(){
		fadeIn('ke_shi_add');
	});
	$("#yi_sheng_tian_jia").click(function(){
		fadeIn('yi_sheng_add');
	});
});


$(document).ready(function(){
	$("#ke_shi_ming_cheng_add").click(function(){
		$("#ke_shi_ming_cheng_add").css("color", "#000");
	});
	$("#form_ke_shi_add").submit(function(){
		var ks = $.trim($("#ke_shi_ming_cheng_add").val());
		if(ks==''){
			$("#ke_shi_ming_cheng_add").css("color", "red");
			return false;
		}
	});
});

$(document).ready(function(){
	$("#xing_ming_add").click(function(){
		$("#xing_ming_add").css("color", "#000");
	});
	$("#lian_xi_fang_shi_add").click(function(){
		$("#lian_xi_fang_shi_add").css("color", "#000");
	});
	$("#deng_lu_hao_add").click(function(){
		$("#deng_lu_hao_add").css("color", "#000");
	});
	$("#form_yi_sheng_add").submit(function(){
		var xma = $.trim($("#xing_ming_add").val());
		if(xma==''){
			$("#xing_ming_add").css("color", "red");
			return false;
		}
		var na = $.trim($("#nan_add").attr("checked"));
		var nva=$.trim($("#nv_add").attr("checked"));
		if(na==''&&nva==''){
			alert("性别不能为空！")
			return false;
		}
		var s = $.trim($("#shi_add").attr("checked"));
		var f=$.trim($("#fou_add").attr("checked"));
		if(s==''&&f==''){
			alert("是否为主任不能为空！")
			return false;
		}
		var lxfsa = $.trim($("#lian_xi_fang_shi_add").val());
		if(lxfsa==''){
			$("#lian_xi_fang_shi_add").css("color", "red");
			return false;
		}
		var dlha = $.trim($("#deng_lu_hao_add").val());
		if(dlha==''){
			$("#deng_lu_hao_add").css("color", "red");
			return false;
		}
		document.getElementById("mi_ma_add").value = hex_md5(document.getElementById("mi_ma_add").value);
	});
});

/*$(document).ready(function(){
	$("#form_ke_shi_edit").submit(function(){
		$("#ke_shi_ming_cheng_edit").click(function(){
			$("#ke_shi_ming_cheng_edit").css("color","#000");
		});
		 var ksmce=$.trim($("#ke_shi_ming_cheng_edit").val());
		 if(ksmce==''){
			 $("#ke_shi_ming_cheng_edit").css("color","red");
			 return false;
		 }
	});
});*/

$(document).ready(function(){
	$("#ke_shi_ming_cheng_edit_e").change(function(){
		$("#ksmc_edit").val($("#ke_shi_ming_cheng_edit_e").val());
	});
	
	$("#xing_ming_edit").click(function(){
		$("#xing_ming_edit").css("color", "#000");
		$("#mi_ma_edit").val("");
	});
	$("#lian_xi_fang_shi_edit").click(function(){
		$("#lian_xi_fang_shi_edit").css("color", "#000");
		$("#mi_ma_edit").val("");
	});
	$("#deng_lu_hao_edit").click(function(){
		$("#deng_lu_hao_edit").css("color", "#000");
		$("#mi_ma_edit").val("");
	});
	$("#form_yi_sheng_edit").submit(function(){
		var xme = $.trim($("#xing_ming_edit").val());
		if(xme==''){
			$("#xing_ming_edit").css("color", "red");
			return false;
		}
		var lxfse = $.trim($("#lian_xi_fang_shi_edit").val());
		if(lxfse==''){
			$("#lian_xi_fang_shi_edit").css("color", "red");
			return false;
		}
		var dlhe = $.trim($("#deng_lu_hao_edit").val());
		if(dlhe==''){
			$("#deng_lu_hao_edit").css("color", "red");
			return false;
		}
		if($.trim($("#mi_ma_edit").val()) == "") {
			$("#mi_ma_edit").val($("#dlmm_edit").val());
		}else {
			document.getElementById("mi_ma_edit").value = hex_md5(document.getElementById("mi_ma_edit").value);
		}
	});
});

function deletedys(id) {
	if(confirm("您确定要删除这条信息吗？")) {
		$.post("csh?m=dys",{id:id},function(r){
			window.location.href="csh?m=iYyCsh&cc=z";
		});
	}
	
}

function editedys(key, id) {
	$.post("csh?m=gys", {id:key}, function(r){
		
		$("#xing_ming_edit").val(r.xingming);
		if(r.xingbie == 1){
			$("#nan_edit").attr("checked","checked");
		} else{
			$("#nv_edit").attr("checked","checked");
		}
		/*$("#jue_se_edit").prepend("<option value='"+r.juese+"'>"+r.juese+"</option>");*/
		
		jQuery("#jue_se_edit").val(r.juese);
		if(r.iszhuren == 1){
			$("#shi_edit").attr("checked","checked");
		} else{
			$("#fou_edit").attr("checked","checked");
		}
		
		$("#lian_xi_fang_shi_edit").val(r.lianxifangshi);
		/*$("#ke_shi_ming_cheng_edit").prepend("<option value='"+r.keshi_id+","+r.keshi+"'>"+r.keshi+"</option>");*/
		/*alert(r.keshi_id + ',' + r.keshi);
		var aa=r.keshi_id + '|' + r.keshi;*/
		/*jQuery("#ke_shi_ming_cheng_edit").val(r.keshi);*/
		$("#ksmc_edit").val(r.keshi_id+","+r.keshi);
		$("#dlId_edit").val(r.denglu_id);
		$("#deng_lu_hao_edit").val(r.dlh);
		$("#ysId_edit").val(key);
		$("#dlmm_edit").val(r.dlmm);
		fadeIn(id);
	}, "json");
}

function deleted(id) {
	if(confirm("您确定要禁用这个科室吗？")) {
		$.post("csh?m=dks",{id:id},function(r){
			window.location.href="csh?m=iYyCsh";
		});
	}
	
}

function will_deleted(id) {
	if(confirm("您确定要启用这个科室吗？")) {
		$.post("csh?m=wdks",{id:id},function(r){
			window.location.href="csh?m=iYyCsh";
		});
	}
	
}


function edited(key, id) {
	$.post("csh?m=gks",{id:key},function(r){
		$("#ke_shi_ming_cheng_edit").val(r);
		$("#ksId").val(key);
		fadeIn(id);
	});
}

function fadeIn(id) {
    document.getElementById(id).className = 'modal';
}

function fadeOut(id) {
    document.getElementById(id).className = 'modal hide';
}
