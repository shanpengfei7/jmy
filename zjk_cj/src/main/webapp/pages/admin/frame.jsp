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
    <script src="static/js/jquery-2.1.4.min.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">
	  <!-- <a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp; -->
	  <a href="javascript:history.go(-1);" class="button button-little bg-blue"><span class="icon-wrench"></span> 后退</a> &nbsp;&nbsp;
	  <a class="button button-little bg-red" href="admin/index/logout.jmy"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
  <div class="head-l" style="float: right;">
  	<a href="javascript:void(0);" class="button  bg-blue">欢迎${sessionScope.swjgmc }-${sessionScope.admin.name }进入系统</a>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>上报管理</h2>
  <ul style="display:block">
    <li><a href="admin/tax/list.jmy" target="right"><span class="icon-caret-right"></span>已上报企业</a></li>
    <li><a href="admin/tax/list2.jmy" target="right"><span class="icon-caret-right"></span>未上报企业</a></li>
  </ul>   
  <h2><span class="icon-user"></span>用户管理</h2>
  <ul style="display:block">
    <li><a href="admin/user/list.jmy" target="right"><span class="icon-caret-right"></span>用户列表</a></li>
  </ul>   
  <c:if test="${sessionScope.admin.role==0 || sessionScope.admin.role==1}">
  <h2><span class="icon-user"></span>时间节点管理</h2>
  <ul style="display:block">
    <li><a href="admin/time/list.jmy" target="right"><span class="icon-caret-right"></span>时间节点</a></li>
  </ul>   
  </c:if>
  <h2><span class="icon-user"></span>通知管理</h2>
  <ul style="display:block">
    <li><a href="admin/notice/list.jmy" target="right"><span class="icon-caret-right"></span>通知管理</a></li>
    <li><a href="admin/notice/read.jmy" target="right"><span class="icon-caret-right"></span>阅读管理</a></li>
    <c:if test="${sessionScope.admin.role==0 || sessionScope.admin.role==1}">
    <li><a href="admin/timenotice/edit.jmy" target="right"><span class="icon-caret-right"></span>定时通知</a></li>
    <li><a href="admin/phonenotice/edit.jmy" target="right"><span class="icon-caret-right"></span>定时短信</a></li>
 	</c:if>
  </ul> 
  <c:if test="${sessionScope.admin.role==0 }">
  <h2><span class="icon-user"></span>app管理</h2>
  <ul style="display:block">
    <li><a href="admin/app/list.jmy" target="right"><span class="icon-caret-right"></span>app管理</a></li>
  </ul> 
  </c:if>  
  <h2><span class="icon-user"></span>我的信息</h2>
  <ul style="display:block">
    <li><a href="admin/mine/show.jmy" target="right"><span class="icon-caret-right"></span>查看</a></li>
    <li><a href="admin/mine/edit.jmy" target="right"><span class="icon-caret-right"></span>修改</a></li>
    <li><a href="admin/mine/pass.jmy" target="right"><span class="icon-caret-right"></span>改密</a></li>
  </ul>
  <!-- <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="list.html" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
    <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
    <li><a href="cate.html" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  </ul>   -->
</div>
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
  <iframe scrolling="auto" rameborder="0" src="admin/tax/list.jmy" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>