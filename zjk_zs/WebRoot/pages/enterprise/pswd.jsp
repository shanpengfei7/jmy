<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>企业信息初始化</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	   <link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/calendar.config.js"></script>
  </head>
  
  <body>
    <div class="main">
   <!--  <div class="pos">当前位置 | 企业管理 &gt 企业添加</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="enterprise-pswd.php">
		<input type="hidden" name="id" value="${enterprise.id }">
		<input type="hidden" name="operate" value="${operate }">
		<dl>
			<dt> 原密码：</dt>
			<dd>
				<input type="password" name="password" class="inp_large" value="${password }" />
			</dd>
		</dl>
		<dl>
			<dt> 新密码：</dt>
			<dd>
				<input type="password" name="password1" class="inp_large" value="${password1 }" />
			</dd>
		</dl>
		
		<dl>
			<dt> 确认密码：</dt>
			<dd>
				<input type="password" name="password2" class="inp_large" value="${password2 }" />
			</dd>
		</dl>
		
		<div class="form_b">		
			<input type="reset" class="btn_green" id="" value="重置"> <input type="submit" class="btn_blue" id="" value="提 交"> 
			${error } 
		</div>
	   </form>
	</div>
</div>
  </body>
</html>

