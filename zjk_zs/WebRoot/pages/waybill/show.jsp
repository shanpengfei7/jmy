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
    
  </head>
  
  <body>
    <div class="main">
	    <div class="list">
	    <!--startprint1--> 
	    <div style="margin: auto 0;" id="aaaa">
	    
	    <link rel='stylesheet' type="text/css" href="css/style.css" /> 
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="js/qrcode.min.js"></script>
		    <form action="" method="post" id="form_do" name="form_do">
		    
		    
		    
		    <div style="float: left; margin: 0 100px;">
				<img src="images/logo2.png" alt="logo" width="100" height="100" />
			</div>
		    <div style="float: left;margin: 30px 40px;"><h1>商品运货单</h1></div>
		    <div id="qrcode" style="float: left; margin: 0 100px;"></div>
		    <div style="clear: both;"></div>
		    
		    
		        <table width="800" border="1" cellspacing="0" cellpadding="0" bordercolor="#000000" bgcolor="#FFFFFF"  
        width="98%" height="90%" style="border-collapse:collapse">
		            <tr>
						<%-- <td colspan="2">收货地址:${waybill.willreceiveenterprise.address }</td> --%>
						<td colspan="2">收货地址:${waybill.receiveplace }</td>
						<td colspan="2">发货地址:${waybill.deliverplace }</td>
		            </tr>
					<tr>
						<td colspan="2">收货企业:${waybill.receiveenterprisename }</td>
<%-- 						<td colspan="2">收货企业:${waybill.willreceiveenterprise.company }</td> --%>
						<td colspan="2">发货企业:${waybill.deliverenterprise.company }</td>
					</tr>
					<tr>	
						<td>收货人:${waybill.receiveemployeename }</td>
<%-- 						<td>收货人:${waybill.willreceiveenterprise.name }</td> --%>
						<td>收货手机号:${waybill.receivephonenumber }</td>
<%-- 						<td>收货手机号:${waybill.willreceiveenterprise.phonenumber }</td> --%>
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
			        <tr>
						<td>发货时间:<date:date value="${waybill.delivertime }"></date:date>  </td>
						<td>打印人：${printname }  </td>
						<td>打印时间：<date:date value="${printtime }"></date:date> </td>
		            </tr>
		            </table>
				</div>
				
				<input type="hidden" id="qr" value="${waybill.number }" />
	
		    </form>
		 </div>  
	<!--endprint1-->
	    </div>
	</div>
	    <div style="clear: both;">
	    	<input id="btnPrint" type="button" value="打印" /> 
		</div>
	<script type="text/javascript">
	new QRCode('qrcode', {
		text:document.getElementById('qr').value,
		width:100,
		height:100,
		colorDark:'#000000',
		colorLight:'#ffffff',
		correctLevel:QRCode.CorrectLevel.M
	});
	$("#btnPrint").click(function(){
		$.post("waybill-print.php", {}, function(data) {
			preview(data.status);
		},"json"); 
	});
	
	
	function preview(oper) { 
		if (oper < 10) { 
			bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
			sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域 
			eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域 
			prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html 
			 
			prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html 
			window.document.body.innerHTML=prnhtml; 
			
			window.print(); 
			window.document.body.innerHTML=bdhtml; 
		} else { 
			window.print(); 
		} 
	}
	
	
</script>
  </body>
</html>
