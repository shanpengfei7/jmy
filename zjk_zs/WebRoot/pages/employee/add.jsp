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
    <!-- <div class="pos">当前位置 | 企业员工管理 &gt 员工添加</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="employee-add.php">
		<input type="hidden" name="roler" class="inp_large" value="${roler }" />
		<dl>
			<dt> 姓名：</dt>
			<dd>
				<input type="text" name="name" class="inp_large" value="${name }" />
			</dd>
		</dl>
		<dl>
			<dt> 性别：</dt>
			<input type="hidden" value="${sex }" id="sex">
			<dd>
				<input type="radio" name="sex" value="1" checked="checked" id="man" />男 <input type="radio" name="sex" value="2" id="women" />女
			</dd>
		</dl>
		<dl>
			<dt> 工号：</dt>
			<dd>
				<input type="text" name="jobnumber" class="inp_large" value="${jobnumber }" />
			</dd>
		</dl>
		<dl>
			<dt> 电话：</dt>
			<dd>
				<input type="text" name="phonenumber" class="inp_large" value="${phonenumber }" />
			</dd>
		</dl>
		<dl>
			<dt> 权限：</dt>
			<dd>
					<label><input type="checkbox" name="power" value="1" />打包</label>
					<label><input type="checkbox" name="power" value="2" />发货</label>
					<label><input type="checkbox" name="power" value="4" />收货</label>
					<label><input type="checkbox" name="power" value="8" />销售</label>
					<label><input type="checkbox" name="power" value="16" />员工管理</label>
					<label><input type="checkbox" name="power" value="64" />型号申请</label>
					<label><input type="checkbox" name="power" value="128" />型号管理</label>
					<label><input type="checkbox" name="power" value="256" />库存信息</label>
					<label><input type="checkbox" name="power" value="512" />产品下线</label>
					<label><input type="checkbox" name="power" value="1024" />产品码打印</label>
					<label><input type="checkbox" name="power" value="2048" />包装码打印</label>
			</dd>
		</dl>
		<dl>
			<dt> 帐号：</dt>
			<dd>
				<input type="text" name="username" class="inp_large" value="${username }" />
			</dd>
		</dl>
		<dl>
			<dt> 密码：</dt>
			<dd>
				<input type="password" name="password" class="inp_large" value="${password }" />
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
