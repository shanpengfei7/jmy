<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>税务预测数据上报系统</title>
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <link rel="stylesheet" href="static/css/timers.css">
    <script src="static/js/jquery-2.1.4.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
	<script type="text/javascript" src="static/layui/layui.js"></script>  
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />企业管理中心</h1>
  </div>
  <div class="head-l">
	  <!-- <a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp; -->
	  <a href="javascript:history.go(-1);" class="button button-little bg-blue"><span class="icon-wrench"></span> 后退</a> &nbsp;&nbsp;
	  <a class="button button-little bg-red" href="user/index/logout.jmy"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
  <div class="head-l" style="float: right;">
  	<a href="javascript:void(0);" class="button  bg-blue">欢迎${sessionScope.enterprise.name }进入系统</a>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>税务数据管理</h2>
  <ul style="display:block">
    <li><a href="user/tax/add.jmy" target="right"><span class="icon-caret-right"></span>税收预测数上报</a></li>
  </ul>   
  <h2><span class="icon-user"></span>历史数据管理</h2>
  <ul style="display:block">
    <li><a href="user/tax/list.jmy" target="right"><span class="icon-caret-right"></span>历史数据查询</a></li>
  </ul>   
  <h2><span class="icon-user"></span>通知管理</h2>
  <ul style="display:block">
    <li><a href="user/notice/list.jmy" target="right"><span class="icon-caret-right"></span>通知查看<span id="unread">0</span></a></li>
  </ul>   
  <h2><span class="icon-user"></span>app管理</h2>
  <ul style="display:block">
    <li><a href="user/app/list.jmy" target="right"><span class="icon-caret-right"></span>app管理</a></li>
  </ul> 
  <h2><span class="icon-user"></span>我的信息</h2>
  <ul style="display:block">
    <li><a href="user/mine/show.jmy" target="right"><span class="icon-caret-right"></span>查看</a></li>
    <li><a href="user/mine/edit.jmy" target="right"><span class="icon-caret-right"></span>修改</a></li>
    <li><a href="user/mine/pass.jmy" target="right"><span class="icon-caret-right"></span>改密</a></li>
  	<div class="site-demo-button" style="margin-bottom: 0;display:none;">
  	<button data-method="offset" id="btn_layui" data-type="rb" class="layui-btn layui-btn-normal">右下弹出</button>
  	</div>
  </ul>   
</div>
<input type="hidden" id="layui_title">
<input type="hidden" id="layui_content">
<script type="text/javascript" src="static/js/timers.js"></script>
  <script type="text/javascript">

  $(function() {
	  $.get("user/notice/unread.jmy", function (data) {
	  	$("#unread").text(data.count);
	  	if(data.status==1) {
	  		$("#layui_title").val(data.title);
	  		$("#layui_content").val(data.content);
	  		$("#btn_layui").trigger("click");
	  	}
	  }, "json");
	  $.get("user/timenotice/notice.jmy", function (data) {
	  	if(data != null) {
		  		$("#layui_title").val(data.title);
		  		$("#layui_content").val(data.content);
		  		$("#btn_layui").trigger("click");
	  		}
	  }, "json");
  })
$('body').everyTime('10s',function(){
  $.get("user/notice/unread.jmy", function (data) {
  	$("#unread").text(data.count);
  	if(data.status==1) {
  		$("#layui_title").val(data.title);
  		$("#layui_content").val(data.content);
  		$("#btn_layui").trigger("click");
  	}
  }, "json");
  $.get("user/timenotice/notice.jmy", function (data) {
  		if(data != null) {
	  		$("#layui_title").val(data.title);
	  		$("#layui_content").val(data.content);
	  		$("#btn_layui").trigger("click");
  		}
  		
  }, "json");
});

 </script>
<script>
layui.use('layer', function(){ //独立版的layer无需执行这一句
  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
  
  //触发事件
  var active = {
    offset: function(othis){
      var type = othis.data('type')
      ,text = othis.text();
      
      layer.open({
        type: 1
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'LAY_demo'+type //防止重复弹出
        ,title: $("#layui_title").val()
        ,content: '<div style="padding: 20px 100px;">'+$("#layui_content").val()+'</div>'
        ,btn: '关闭'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
          layer.closeAll();
        }
      });
    }
  };
  
  $('.site-demo-button .layui-btn').on('click', function(){
    var othis = $(this), method = othis.data('method');
    active[method] ? active[method].call(this, othis) : '';
  });
  
});
</script>

<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="javascript:void(0);" target="right" class="icon-home"> 首页</a></li>
  <li><a href="javascript:void(0);" id="a_leader_txt">网站信息</a></li>
  <!-- <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li> -->
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" id="layui_iframe" src="user/tax/add.jmy" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>