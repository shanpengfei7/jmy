<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>error 404</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    <h1>error 404</h1>
    <p>可能的错误原因：</p>
    <p>系统正在维护中，请登录重试</p>
    <p>您的操作有误，请登录重试</p>
    <p>未能找到您的请求，请登录重试</p>
    <form action="#" method="get">
        <input type="submit" value="登录" style="width: 100px;height: 40px;margin-left: 300px;">
    </form>
</div>
  </body>
</html>
