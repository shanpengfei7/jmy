<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>HRV报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <%@include file="/commons/xlcp/header.jsp" %>
  	  最多可选择5个,多选无效！
    <form action="hrvbg?m=ebg" method="post" enctype="multipart/form-data">
    	<input type="hidden" value="${param.id }" name="id" />
    	<input type="hidden" value="${param.jid }" name="jid" />
    	<input type="hidden" value="${param.cs }" name="cishu" />
    	<input type="file" multiple="multiple" name="pic" /> 
    	<input type="submit" value="提交" onclick="upload();">
    </form>
   <%@include file="/commons/tail.jsp" %>
