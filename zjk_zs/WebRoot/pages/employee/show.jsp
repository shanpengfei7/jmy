<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee-add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 员工列表 &gt 员工查看</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="employee-add.php">
		<dl>
			<dt> 姓名：${employee.name }</dt>
		</dl>
		<dl>
			<dt> 性别：
				<c:if test="${employee.sex==1 }"><td>男</td></c:if>
	            <c:if test="${employee.sex==2 }"><td>女</td></c:if>
			</dt>
		</dl>
		<dl>
			<dt> 工号：${employee.jobnumber }</dt>
		</dl>
		<dl>
			<dt> 电话：${employee.phonenumber }</dt>
		</dl>
		<dl>
			<dt> 权限：</dt>
			<dd>
				<c:set var="power" scope="request" value="${employee.power }" />
				<c:if test="${sessionScope.role==1 }">
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
				</c:if>
				<c:if test="${sessionScope.role==2 }">
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
				</c:if>
				<c:if test="${sessionScope.role==4 }">
					<c:if test="${employee.getBit(power,2) }">
						<label><input type="checkbox" checked="checked" name="power" value="4" />收货</label>
					</c:if>
					<c:if test="${!employee.getBit(power,2) }">
						<label><input type="checkbox" name="power" value="4" />收货</label>
					</c:if>
					<c:if test="${employee.getBit(power,3) }">
						<label><input type="checkbox" checked="checked" name="power" value="4" />销售</label>
					</c:if>
					<c:if test="${!employee.getBit(power,3) }">
						<label><input type="checkbox" name="power" value="4" />销售</label>
					</c:if>
				</c:if>
			</dd>
		</dl>
		<dl>
			<dt> 帐号：${employee.username }</dt>
		</dl>
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
