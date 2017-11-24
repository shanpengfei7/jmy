<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel='stylesheet' type="text/css" href="css/style.css" /> 
		    <form action="" method="post" id="form_do" name="form_do">
  </head>
  
  <body>
    <div class="main">
	    <div class="list">
	    <!--startprint1--> 
	    <div style="margin: auto 0;" id="aaaa">
		    <div style="clear: both;"></div>
		        <table width="800" border="1" cellspacing="0" cellpadding="0" bordercolor="#000000" bgcolor="#FFFFFF"  
        width="98%" height="90%" style="border-collapse:collapse">
		            <tr>
						<td colspan="2">收货地址:${waybill.willreceiveenterprise.address }</td>
						<td colspan="2">发货地址:${waybill.deliverplace }</td>
		            </tr>
					<tr>
						<td colspan="2">收货企业:${waybill.willreceiveenterprise.company }</td>
						<td colspan="2">发货企业:${waybill.deliverenterprise.company }</td>
					</tr>
					<tr>	
						<td>收货人:${waybill.willreceiveenterprise.name }</td>
						<td>收货手机号:${waybill.willreceiveenterprise.phonenumber }</td>
						<td>发货人:${waybill.deliveremployee.name }</td>
						<td>发货手机号:${waybill.deliveremployee.phonenumber }</td>
	           	 	</tr>
	           	 	 
		        </table>
		        <div style="float: left;">
			        <table width="800" border="1" cellspacing="0" cellpadding="0" bordercolor="#000000" bgcolor="#FFFFFF"  
        width="98%" height="90%" style="border-collapse:collapse">
			            <tr>
			                <th>序号</th>
			                <th>名称</th>
			                <th>数量</th>
			            </tr>
			            <c:forEach items="${countMap }" var="map"  varStatus="s">
							<tr>
				                <td>${s.index+1 }</td>
				                <td>${map.key }</td>
				                <td>${countMap[map.key]}</td>
			           	 	</tr>
			           	 </c:forEach>
			        </table>
			        <table width="800" border="1" cellspacing="0" cellpadding="0" bordercolor="#000000" bgcolor="#FFFFFF"  
        width="98%" height="90%" style="border-collapse:collapse">
		            </table>
				</div>
				
				<input type="hidden" id="qr" value="${waybill.number }" />
	
		    </form>
		 </div>  
	<!--endprint1-->
	    </div>
	</div>
  </body>
</html>
