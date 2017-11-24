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
	function btn_add(id) {
		window.location.href="versionp-piadd.php?pid=" + id;
	}
	function delete_btn(id, pid) {
		if(confirm("您确定要删除这个属性吗？")) {
			window.location.href="versionp-pdelete.php?id=" + id + "&pid=" +pid;
		}
	}
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 产品型号申请  &gt 型号管理</div> -->
    <div class="operate">
        <div class="left">
                <input type="button" onclick="btn_add('${pid }')" class="btn_blue" value="新增物品属性">
        </div>
    </div>
    <div class="list">    
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>值</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${productproperties }" var="p" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${p.name }</td>
	                <td>${p.value }</td>
	                <td>
		                <a href="javascript:delete_btn('${p.id }','${pid }');">删除</a>
		                <a href="versionp-piedit.php?id=${p.id }">编辑</a>
					</td>
            	</tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <%-- <div>
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
		   </div> --%>
	   </div>

    </form>
    </div>
</div>
  </body>
</html>
