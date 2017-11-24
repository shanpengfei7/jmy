$(document).ready(function(){
	$("#ri_qi_1").val($("#r").val());
	$("#ri_qi_2").val($("#q").val());
	$("#name").val($("#n").val());

	$("#showPageCount").text($("#pageCount").val());
	$("#change_page").change(function(){
		var href="bbgl?m=ibb&pn="+$("#change_page").val();
		aq(href);
	});
});        
function aq(h) {
			var href = h + "&r=" + $("#r").val() + "&q=" + $("#q").val() + "&y=" + $("#y").val()
			 + "&k=" + $("#k").val() + "&z=" + $("#z").val() + "&j=" + $("#j").val() + "&c=" + $("#c").val();
			window.location.href = href;			
			return false;
    	}

$(document).ready(function(){
	$("#pbb").click(function(){
		window.location.href="bbgl?m=pbb"+ "&r=" + $("#r").val() + "&q=" + $("#q").val() + "&y=" + $("#y").val()
			 + "&k=" + $("#k").val() + "&z=" + $("#z").val() + "&j=" + $("#j").val() + "&c=" + $("#c").val();
	});
});
$(document).ready(function(){
	$("#yi_yuan").change(function(){
		$.post("bbgl?m=gks", {id:$("#yi_yuan").val()}, function(r){
			$("#ke_shi").empty();
			$("#ke_shi").append("<option value=''>请选择</option>");
			for(var k in r) {
				$("#ke_shi").append("<option value='"+r[k]+"'>"+r[k]+"</option>");
			}
		}, "json");
		$.post("bbgl?m=gjsk", {id:$("#yi_yuan").val()}, function(r){
			$("#jing_shen_ke_yi_sheng").empty();
			$("#jing_shen_ke_yi_sheng").append("<option value=''>请选择</option>");
			for(var k in r) {
				$("#jing_shen_ke_yi_sheng").append("<option value='"+r[k]+"'>"+r[k]+"</option>");
			}
		}, "json");
		$.post("bbgl?m=gcps", {id:$("#yi_yuan").val()}, function(r){
			$("#ce_ping_shi").empty();
			$("#ce_ping_shi").append("<option value=''>请选择</option>");
			for(var k in r) {
				$("#ce_ping_shi").append("<option value='"+r[k]+"'>"+r[k]+"</option>");
			}
		}, "json");
	});
	$("#ke_shi").change(function(){
		$.post("bbgl?m=gzk", {id:$("#ke_shi").val()}, function(r){
			$("#zhuan_ke_yi_sheng").empty();
			$("#zhuan_ke_yi_sheng").append("<option value=''>请选择</option>");
			for(var k in r) {
				$("#zhuan_ke_yi_sheng").append("<option value='"+r[k]+"'>"+r[k]+"</option>");
			}
		}, "json");
	});
});
