 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
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

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>		
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript">
    // 页面初始化，本处使用定时器处理
    // 如果使用onload或者jquery的$(document).read(function(){...});未必能达到效果。因地制宜。
    
    var initScript = setInterval(function(){
    
            // 针对iframe嵌套的情况
            if (window.top!=null && window.top.document.URL!=document.URL){
                clearInterval(initScript);
                window.top.location.href = "#"; 
	    	}
	    
        },400);
  
</script>
</head>	
<body>
	<div class="login">
		<div class="loginForm">	
			<form action="login-register.php" method="post" id="login">
			<div class="title">
			可追溯商品质量服务平台(注册) 			</div>
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
					<th>确认密码:</th>
					<td>
						<input type="password" value="${password }" class="len220" name="password2"/>
					</td>
				</tr>
				<tr>
					<th>验证码:</th>
				  <td>
						<input type="code" class="len220" value="${code }" name="code" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>&nbsp;</th>
				  	<td>
						<img src="verCode.php" align="absmiddle" id="vcode" class="vcode" onclick="change_code();"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left:120px;"> <input type="submit" class="btn_blue" value="登录"/><span  class="error">${error }</span></td>
				</tr>
			</table>
		</form>
		</div>
	</div>

</body>
</html>