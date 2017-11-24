/**
 * Created by pnfy on 2016/8/25.
 */
$(document).ready(function () {
    setting();
});
/*$(document).ready(function () {
    var nav = $("#nav").val();
    if(nav == '基础信息') {
    	alert('ddd')
    	nav();
    	$("#nav_jcxx").css("color", "#DCD800");
    	$("#nav_jcxx").css("font-size", "21px");
    }
});

function nav() {
	alert('eee')
	$(".con").css("color", "white");
	$(".con").css("font-size", "18px");
}*/

$(window).resize(function(){
    setting();
});

function setting() {
    var w = $(window).width();
    var h = $(window).height();
    $(".header").css("width", w);
    $(".header").css("height", "60px");
    $(".body-left").css("width", "150px");
    $(".body-left").css("height", h-60);
    $(".body-right").css("width", w-150);
    $(".body-right").css("height", h-60);
}

$(function(){
	$('#ri_qi_1').date_input();
	$('#ri_qi_2').date_input();
});
