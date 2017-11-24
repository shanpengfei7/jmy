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
<script type="text/javascript" src="js/qrcode.min.js"></script>
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
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>是否包装</th>
                <th>是否销售</th>
                <th>内容物</th>
                <th>数量</th>
                <th>操作</th>
                <th>显示</th>
            </tr>
			<c:forEach items="${repertories }" var="r" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td >${r.qrcode.product.tradename }</td>
	                <td><c:if test="${r.qrcode.hasson==1 }">
	                	是
	                </c:if>
	                <c:if test="${r.qrcode.hasson==0 }">
	                	否
	                </c:if></td>
	                <td><c:if test="${r.qrcode.issell==1 }">
	                	是
	                </c:if>
	                <c:if test="${r.qrcode.issell==0 }">
	                	否
	                </c:if></td>
	                <td>
		                <c:if test="${!empty r.qrcode.sons[0].product.tradename }">${r.qrcode.sons[0].product.tradename }</c:if>
		                <c:if test="${empty r.qrcode.sons[0].product.tradename }">这是最里层</c:if>
					</td>
	                <td>
		                ${r.qrcode.sons.size() }
					</td>
	                <td>
	                <c:if test="${r.qrcode.hasson==1 }">
		                <a href="repertory-sonlist.php?qrcodeid=${r.qrcode.id }">查看内容物</a>
		            </c:if>
					</td>
					<td>
						<a href="shows.php?token=${r.qrcode.qrcode }">查看展示信息</a>
					</td>
					
            	</tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <%-- <div>
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
		   </div> --%>
	   </div>

    </form>
    </div>
</div>

  </body>
</html>
