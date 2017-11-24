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
    <!-- <div class="pos">当前位置 | 企业员工管理 &gt 员工列表 &gt 员工修改</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="employee-update.php">
		<input type="hidden" name="roler" class="inp_large" value="${roler }" />
		<dl>
		<input type="hidden" name="id" value="${employee.id }">
			<dt> 姓名：</dt>
			<dd>
				<input type="text" name="name" class="inp_large" value="${employee.name }" />
			</dd>
		</dl>
		<dl>
			<dt> 性别：</dt>
			<input type="hidden" value="${employee.sex }" id="sex">
			<dd>
				<input type="radio" name="sex" value="1" checked="checked" id="man" />男 <input type="radio" name="sex" value="2" id="women" />女
			</dd>
		</dl>
		<dl>
			<dt> 工号：</dt>
			<dd>
				<input type="text" name="jobnumber" class="inp_large" value="${employee.jobnumber }" />
			</dd>
		</dl>
		<dl>
			<dt> 电话：</dt>
			<dd>
				<input type="text" name="phonenumber" class="inp_large" value="${employee.phonenumber }" />
			</dd>
		</dl>
		<dl>
			<dt> 权限：</dt>
			<dd>
				<c:set var="power" scope="request" value="${employee.power }" />
					<c:if test="${employee.getBit(power,0) }">
						<label><input type="checkbox" checked="checked" name="power" value="1" />打包</label>
					</c:if>
					<c:if test="${!employee.getBit(power,0) }">
						<label><input type="checkbox" name="power" value="1" />打包</label>
					</c:if>
					<c:if test="${employee.getBit(power,1) }">
						<label><input type="checkbox" checked="checked" name="power" value="2" />发货</label>
					</c:if>
					<c:if test="${!employee.getBit(power,1) }">
						<label><input type="checkbox" name="power" value="2" />发货</label>
					</c:if>
					<c:if test="${employee.getBit(power,2) }">
						<label><input type="checkbox" checked="checked" name="power" value="4" />收货</label>
					</c:if>
					<c:if test="${!employee.getBit(power,2) }">
						<label><input type="checkbox" name="power" value="4" />收货</label>
					</c:if>
					<c:if test="${employee.getBit(power,3) }">
						<label><input type="checkbox" checked="checked" name="power" value="8" />销售</label>
					</c:if>
					<c:if test="${!employee.getBit(power,3) }">
						<label><input type="checkbox" name="power" value="8" />销售</label>
					</c:if>
					<c:if test="${employee.getBit(power,4) }">
						<label><input type="checkbox" checked="checked" name="power" value="16" />员工管理</label>
					</c:if>
					<c:if test="${!employee.getBit(power,4) }">
						<label><input type="checkbox" name="power" value="16" />员工管理</label>
					</c:if>
					<c:if test="${employee.getBit(power,6) }">
						<label><input type="checkbox" checked="checked" name="power" value="64" />型号申请</label>
					</c:if>
					<c:if test="${!employee.getBit(power,6) }">
						<label><input type="checkbox" name="power" value="64" />型号申请</label>
					</c:if>
					<c:if test="${employee.getBit(power,7) }">
						<label><input type="checkbox" checked="checked" name="power" value="128" />型号管理</label>
					</c:if>
					<c:if test="${!employee.getBit(power,7) }">
						<label><input type="checkbox" name="power" value="128" />型号管理</label>
					</c:if>
					<c:if test="${employee.getBit(power,8) }">
						<label><input type="checkbox" checked="checked" name="power" value="256" />库存信息</label>
					</c:if>
					<c:if test="${!employee.getBit(power,8) }">
						<label><input type="checkbox" name="power" value="256" />库存信息</label>
					</c:if>
					<c:if test="${employee.getBit(power,9) }">
						<label><input type="checkbox" checked="checked" name="power" value="512" />产品下线</label>
					</c:if>
					<c:if test="${!employee.getBit(power,9) }">
						<label><input type="checkbox" name="power" value="512" />产品下线</label>
					</c:if>
					<c:if test="${employee.getBit(power,10) }">
						<label><input type="checkbox" checked="checked" name="power" value="1024" />产品码打印</label>
					</c:if>
					<c:if test="${!employee.getBit(power,10) }">
						<label><input type="checkbox" name="power" value="1024" />产品码打印</label>
					</c:if>
					<c:if test="${employee.getBit(power,11) }">
						<label><input type="checkbox" checked="checked" name="power" value="2048" />包装码打印</label>
					</c:if>
					<c:if test="${!employee.getBit(power,11) }">
						<label><input type="checkbox" name="power" value="2048" />包装码打印</label>
					</c:if>
			</dd>
		</dl>
		<dl>
			<dt> 状态：</dt>
			<dd>
				<c:if test="${employee.status==0 }">
					启用：<input type="radio" name="status" value="0" checked="checked" />&nbsp;&nbsp;
					禁用：<input type="radio" name="status" value="1" />
				</c:if>
				<c:if test="${employee.status==1 }">
					启用：<input type="radio" name="status" value="0" />&nbsp;&nbsp;
					禁用：<input type="radio" name="status" value="1" checked="checked" />
				</c:if>
				<%-- <input type="text" name="status" class="inp_large" value="${employee.status }" /> --%>
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
