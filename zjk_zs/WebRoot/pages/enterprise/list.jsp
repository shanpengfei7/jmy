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
<script type="text/javascript">
	function check_btn(id,role) {
		if(confirm("您确定要审核通过该企业吗？")) {
			window.location.href="enterprise-con.php?id="+id+"&role="+role;
		}
	}
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 企业管理 </div> -->
    <div class="operate">
        <div class="left">
        </div>
        <div class="left_pad">
            <%-- <form method="post" action="enterprise-list.php?role=${role }">
                <input type="text" name="keyword" title="关键字" class="inp_default" value="${param.keyword }">
                <input type="submit" class="btn_blue" value="查  询">
            </form> --%>
        </div>
    </div>
    <div class="list">    
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
            <tr>
                <th>编号</th>
                <th>企业名称</th>
                <th>企业代号</th>
                <th>法定代表人</th>
                <th>创建时间</th>
				<th>状态</th>
				<th>是否通过审核</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${enterprises }" var="e" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${e.company }</td>
	                <td>${e.code }</td>
	                <td>${e.name }</td>
	                <td><date:date value="${e.createtime }"></date:date></td>
	                <td>
	                	<c:if test="${e.status==0 }"><a href="enterprise-status.php?id=${e.id }&operate=5&role=${role }">启用</a></c:if>
	                	<c:if test="${e.status==1 }"><a href="enterprise-status.php?id=${e.id }&operate=6&role=${role }">禁用</a></c:if>
	                </td>
	                 <td>
	                	<c:if test="${e.isconnect==0 }"><a href="javascript:void(0);">通过</a></c:if>
	                	<c:if test="${e.isconnect==1 }"><a href="javascript:check_btn('${e.id }','${role }');">未通过</a></c:if>
	                </td>
	                <td>
		                <a href="enterprise-show.php?id=${e.id }&operate=5">查看</a>
		                <a href="enterprise-show.php?id=${e.id }&operate=6">编辑</a>
		                <a href="employee-list.php?enterpriseid=${e.id }">查看员工信息</a>
		                <c:if test="${role==1 }">
		                	<a href="qrcode-list.php?enterpriseid=${e.id }">查看产品信息</a>
		                </c:if>
		                <c:if test="${role==1||role==2 }">
		                	<a href="circulate-delist.php?enterpriseid=${e.id }">发货信息</a>
		                </c:if>
		                <c:if test="${role==2||role==4 }">
		                	<a href="circulate-relist.php?enterpriseid=${e.id }">收货信息</a>
		                </c:if>
		                <c:if test="${role==4 }">
		                	<a href="circulate-sell.php?enterpriseid=${e.id }">销售信息</a>
		                </c:if>
					</td>
            </tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <div>
			   <span class="rows">共 ${rowCount }条记录</span>
			   <a class="prev" href="employee-list.php?pageNow=${pageNow-1 }"><<</a>
			   <c:choose>
			   <c:when test="${pageNow<3 }">
			   		<c:forEach begin="1" end="${pageCount>5?5:pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>=3&&pageNow<=pageCount-2 }">
			   		<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="page">
			   			<c:if test="${page==pageNow }">
							<span class="current">${page }</span>			   			
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?pageNow=${page }">${page }</a>		   			
			   			</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>pageCount-2 }">
			   		<c:forEach begin="${pageCount-5>0?pageCount-4:1 }" end="${pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   </c:choose>
			   <a class="next" href="employee-list.php?pageNow=${pageNow+1 }">>></a>
		   </div>
	   </div>

    </form>
    </div>
</div>
  </body>
</html>
