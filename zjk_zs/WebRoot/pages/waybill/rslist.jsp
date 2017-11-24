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
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 物流信息  &gt 收货信息</div> -->
    <div class="operate">
        <div class="left">
                <!-- <input type="button" onclick="btn_apply()" class="btn_blue" value="型号申请"> -->
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
                <th>名称</th>
                <th>内容物</th>
                <th>数量</th>
                <th>收货企业</th>
                <th>收货员工</th>
                <th>收货时间</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${circulates }" var="c" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${c.qrcode.product.tradename }</td>
	                <c:if test="${empty c.qrcode.son.product.tradename }">
	                	<td>这是最里层</td>
	                </c:if>
	                <c:if test="${!empty c.qrcode.son.product.tradename }">
	                <td>${c.qrcode.son.product.tradename }</td>
	                </c:if>
	                <c:if test="${empty c.qrcode.soncount }">
	                	<td>0</td>
	                </c:if>
	                <c:if test="${!empty c.qrcode.soncount }">
	                <td>${c.qrcode.soncount }</td>
	                </c:if>
	                <td>${c.receiveenterprise.company }</td>
	                <td>${c.receiveemployee.name }</td>
	                <td><date:date value="${c.receivetime }"></date:date></td>
					<td>
						<c:if test="${c.qrcode.hasson==1 }">
						<c:if test="${!empty c.qrcode.son.product.tradename }">
							<a href="waybill-rslist.php?waybillid=${waybillid }&qrcodeid=${c.qrcode.id }">查看</a>
	                </c:if>
						</c:if>
						<a href="shows.php?token=${c.qrcode.qrcode }">查看详细信息</a>
					</td>
            </tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <%-- <div>
			   <span class="rows">共 ${rowCount }条记录</span>
			   <a class="prev" href="waybill-dlist.php?waybillid=${waybillid }&pageNow=${pageNow-1 }"><<</a>
			   <c:choose>
			   <c:when test="${pageNow<3 }">
			   		<c:forEach begin="1" end="${pageCount>5?5:pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="waybill-dlist.php?waybillid=${waybillid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>=3&&pageNow<=pageCount-2 }">
			   		<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="page">
			   			<c:if test="${page==pageNow }">
							<span class="current">${page }</span>			   			
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="waybill-dlist.php?waybillid=${waybillid }&pageNow=${page }">${page }</a>		   			
			   			</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>pageCount-2 }">
			   		<c:forEach begin="${pageCount-5>0?pageCount-4:1 }" end="${pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="waybill-dlist.php?waybillid=${waybillid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   </c:choose>
			   <a class="next" href="waybill-dlist.php?waybillid=${waybillid }&pageNow=${pageNow+1 }">>></a>
		   </div> --%>
	   </div>

    </form>
    </div>
</div>
  </body>
</html>
