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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 二维码管理  &gt 二维码列表</div> -->
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
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
            <tr>
                <th>序号</th>
                <th>产品是真货</th>
                <th>销售商服务态度很好</th>
                <th>产品物有所值</th>
                <th>对产品很满意</th>
                <th>联系方式（手机号）</th>
            </tr>
			<c:forEach items="${evaluates }" var="e" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td><c:if test="${!empty e.evaluate1 }">${e.evaluate1 }</c:if>
                    	<c:if test="${empty e.evaluate1 }">暂无评价</c:if></td>
                	<td><c:if test="${!empty e.evaluate2 }">${e.evaluate2 }</c:if>
                    	<c:if test="${empty e.evaluate2 }">暂无评价</c:if></td>
                	<td><c:if test="${!empty e.evaluate3 }">${e.evaluate3 }</c:if>
                    	<c:if test="${empty e.evaluate3 }">暂无评价</c:if></td>
                	<td><c:if test="${!empty e.evaluate4 }">${e.evaluate4 }</c:if>
                    	<c:if test="${empty e.evaluate4 }">暂无评价</c:if></td>
                	<td><c:if test="${!empty e.phonenumber }">${e.phonenumber }</c:if>
                    	<c:if test="${empty e.phonenumber }">暂无联系方式</c:if></td>
          			 </tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <div>
			   <span class="rows">共 ${rowCount }条记录</span>
			   <a class="prev" href="qrcode-evalist.php?pid=${pid }&pageNow=${pageNow-1 }"><<</a>
			   <c:choose>
			   <c:when test="${pageNow<3 }">
			   		<c:forEach begin="1" end="${pageCount>5?5:pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-evalist.php?pid=${pid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>=3&&pageNow<=pageCount-2 }">
			   		<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="page">
			   			<c:if test="${page==pageNow }">
							<span class="current">${page }</span>			   			
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-evalist.php?pid=${pid }&pageNow=${page }">${page }</a>		   			
			   			</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>pageCount-2 }">
			   		<c:forEach begin="${pageCount-5>0?pageCount-4:1 }" end="${pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="qrcode-evalist.php?pid=${pid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   </c:choose>
			   <a class="next" href="qrcode-evalist.php?pid=${pid }&pageNow=${pageNow+1 }">>></a>
		   </div>
	   </div>

    </form>
    </div>
</div>
  </body>
</html>
