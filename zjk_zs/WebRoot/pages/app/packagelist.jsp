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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="wilih=device-wilih, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
<link rel='stylesheet' type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/qrcode.min.js"></script>
<script type="text/javascript" src="js/calendar.config.js"></script>
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 库存管理  &gt 库存信息</div> -->
    <div class="operate">
        <div class="left">
        </div>
        <div class="left_pad">
            <!-- <form method="post" action="">
                <input type="text" name="keyword" title="关键字" class="inp_default" value="">
                <input type="submit" class="btn_blue" value="查  询">
            </form> -->
        </div>
    </div>
    <div class="list">  
    <dl>
            <dt> 日期时间：</dt>
            <dd>
                <input type="text" class="inp_one" name="publishtime" id="publishtime" value="${packagetime }">
                <input type="hidden" id="employeeid" value="${employeeid }"/>
                <script type="text/javascript">
                    Calendar.setup({
                        weekNumbers: true,
                        inputField : "publishtime",
                        trigger    : "publishtime",
                        dateFormat: "%Y-%m-%d",
                        showTime: true,
                        minuteStep: 1,
                        onSelect   : function() {
                        	this.hide();
                        	window.location.href="appinfo-packagelist.php?employeeid="+$("#employeeid").val()+"&packagetime=" + $("#publishtime").val();	
                        }
                    });
                </script>
            </dd>
        </dl>  
    <c:forEach items="${countMap }" var="map">
		  ${map.key }:${countMap[map.key]}                       <!-- 有数据 -->
	</c:forEach>
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
        <c:if test="${empty packageinformations }">
            	今天没有打包信息！！！
            </c:if>
            <c:if test="${!empty packageinformations }">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>内容物</th>
                <th>数量</th>
                <th>包装时间</th>
                <th>包装地点</th>
                <th>动作</th>
            </tr>
            
			<c:forEach items="${packageinformations }" var="pi" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td >${pi.qrcode.product.tradename }</td>
					<td>${pi.qrcode.son.product.tradename }</td>
					<td>${pi.qrcode.soncount }</td>
					<td><date:date value="${pi.time }"></date:date></td>
					<td>${pi.place }</td>
					<c:if test="${pi.action==1 }">
						<td>包装</td>
					</c:if>					
					<c:if test="${pi.action==2 }">
						<td>拆包</td>
					</c:if>					
            	</tr>
			</c:forEach>
			</c:if>
        </table>
        <%-- <div class="page" style="clear: both;">
		  <div>
			   <span class="rows">共 ${rowCount }条记录</span>
			   <a class="prev" href="qrcode-qrlist.php?enterpriseid=${enterpriseid }&pid=${pid }&pageNow=${pageNow-1 }"><<</a>
			   <c:choose>
			   <c:when test="${pageNow<3 }">
			   		<c:forEach begin="1" end="${pageCount>5?5:pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-qrlist.php?enterpriseid=${enterpriseid }&pid=${pid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>=3&&pageNow<=pageCount-2 }">
			   		<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="page">
			   			<c:if test="${page==pageNow }">
							<span class="current">${page }</span>			   			
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-qrlist.php?enterpriseid=${enterpriseid }&pid=${pid }&pageNow=${page }">${page }</a>		   			
			   			</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>pageCount-2 }">
			   		<c:forEach begin="${pageCount-5>0?pageCount-4:1 }" end="${pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-qrlist.php?enterpriseid=${enterpriseid }&pid=${pid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   </c:choose>
			   <a class="next" href="qrcode-qrlist.php?enterpriseid=${enterpriseid }&pid=${pid }&pageNow=${pageNow+1 }">>></a>
			   还有${noUseQrCodeCount }码未使用
		   </div> 
	   </div>--%>

    </form>
    </div>
</div>

  </body>
</html>
