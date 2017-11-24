<%@page import="com.jinmayi.entity.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
   <link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/calendar.config.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 企业员工管理 &gt 员工列表 &gt 修改密码</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="employee-pswd.php">
		<input type="hidden" name="id" value="${param.id }">
		<%-- <dl>
			<dt> 原密码：</dt>
			<dd>
				<input type="text" name="password" class="inp_large" value="${password }" />
			</dd>
		</dl> --%>
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
			<input type="submit" class="btn_green" id="" value="重置"> <input type="submit" class="btn_blue" id="" value="提 交"> 
			${error } 
		</div>
	   </form>
	</div>
</div>
<script type="text/javascript">
	var sex = $("#sex").val();
	if(sex==1) {
		$("#man").attr("checked", "checked");
	} else {
		$("#women").attr("checked", "checked");
	}
</script>
  </body>
</html>
