<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>税务预测数据上报系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/login.css">
	<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
	
	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  </head>
  
  <body>
  <input type="hidden" value="<%=basePath%>">
   <!-- 你的HTML代码 -->
 <div class="xyh-login">
		<div class="xyh-login-form">	
			<form action="" method="post" id="LoginForm">
			<div class="title">税务预测数据上报系统</div>
			<table width="70%" align="center" border="0">
				<tr>
					<th width="29%" align="right"></th>
					<td width="71%">
						<input type="text" name="swjgDm" placeholder="税务机关代码" class="len220" value=""/>
					</td>
				</tr>
				<tr>
					<th align="right"></th>
					<td>
						<input type="password" class="len220" placeholder="密码" name="password" value=""/>
					</td>
				</tr>
				<tr>
					<th align="right"></th>
				  <td>
				  <input type="code" class="len100" name="code" placeholder="验证码" autocomplete="off" style="float:left;"/>
				  <img src="tool/verify.jmy" id="verify_img" class="yzm" />
                  </td>
				</tr>
				<tr>
                	<th align="right">&nbsp;</th>
					<td >
						<button type="submit" id="btn_submit">登　　录</button>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
<script type="text/javascript">
	$(function() {
		$("#verify_img").click(function() {
		   var verifyURL = "tool/verify.jmy";
		   var time = new Date().getTime();
		   $("#verify_img").attr({
		      "src" : verifyURL + "?" + time
		   });
		});
		$("#btn_submit").on("click", function() {
			var swjgDm = $('input[name="swjgDm"]').val();
			var password = $('input[name="password"]').val();
			var verify = $('input[name="code"]').val();
			$.post("admin/index/login.jmy", {swjgDm:swjgDm,password:password,verify:verify}, function(data) {
				if(data.status == 1) {
					window.location.href="admin/index/frame.jmy";
				} else {
					alert(data.error);
					
				}
				
			}, "json");
			return false;
		});
	});
</script>
</body>
</html>
