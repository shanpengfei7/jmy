<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <script type="text/javascript">
	var verifyUrl="{:U('Login/verify','','')}";
	var CONTROL_U = "{:U('Login/checkusername')}";
	var CONTROL_P = "{:U('Login/checkpassword')}";
	var URLPATHDEPR= "{:C('URL_PATHINFO_DEPR')}";
	$(function(){
		$('#vcode').click();
	});
</script>

<script type="text/javascript" src="common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="common/js/login.js"></script>		
<link rel="stylesheet" href="common/css/login.css" />
</script>
</head>	
<body>
<input type="hidden" value="${sessionScope.adminId }" id="sessionValue">
	<div class="login">
		<div class="loginForm">	
			<form action="admin/login.jmy" method="post" id="login">
			<div class="title">
			接口服务平台 				</div>
			<table width="100%">
				<tr>
					<th>帐号:</th>
					<td>
						<input type="username" value="${username }" name="username" class="len220"/>
					</td>
				</tr>
				<tr>
					<th>密码:</th>
					<td>
						<input type="password" value="${password }" class="len220" name="password"/>
					</td>
				</tr>
				<tr>
					<th>验证码:</th>
				  <td>
						<input type="code" class="len220" value="${verify }" name="verify" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>&nbsp;</th>
				  	<td>
						<img src="user/verify.jmy" align="absmiddle" id="verify" class="vcode" onclick="change_code();"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="button" onclick="sub();" class="btn_blue" value="登录"/>
						<span  class="error">${error }</span><span  class="msg"></span>	
					</td>
						
						
					
				</tr>
			</table>
		</form>
		</div>
	</div>
<script type="text/javascript" src="common/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
	function sub() {
		$.post("admin/login.jmy", $('form').serialize(), function (data) {
			if(data==1) {
				location.href="admin/list.jmy";
			} else {
				alert(data);
			}
		});
	}
 </script>
</body>
</html>