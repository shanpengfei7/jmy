 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
<link rel="stylesheet" href="css/login-new.css" />
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
$(function() {
	$("#vcode").click(function() {
	   var verifyURL = "verCode.php";
	   var time = new Date().getTime();
	   $("#vcode").attr({
	      "src" : verifyURL + "?" + time
	   });
	});
});
</script>
</head>	
<body>
	<div class="xyh-login">
		<div class="xyh-login-form">	
			<form action="login-adminlogin.jmy" method="post" id="login">
			<div class="title">可追溯商品质量服务平台（管理员）</div>
			<table width="70%" align="center" border="0">
				<tr>
					<th width="29%" align="right">帐号:</th>
					<td width="71%">
						<input type="username" value="${username }" name="username" class="len220"/>
					</td>
				</tr>
				<tr>
					<th align="right">密码:</th>
					<td>
						<input type="password" value="${password }" class="len220" name="password"/>
					</td>
				</tr>
				<tr>
					<th align="right">验证码:</th>
				  	<td>
						<input type="code" class="len100" value="${code }" name="code" autocomplete="off" style="float:left;" />
						<img src="verCode.php" id="vcode" class="yzm" />
					</td>
				</tr>
				<tr>
                	<th align="right">&nbsp;</th>
					<td >
						<button type="submit">登　　录</button>
						<span class="error">${error }</span>
						<span class="msg"></span>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>

</body>
</html>