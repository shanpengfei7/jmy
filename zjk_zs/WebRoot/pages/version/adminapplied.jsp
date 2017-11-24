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
	function btn_apply() {
		window.location.href="version-one.php";
	}
	function delete_btn(id) {
		if(confirm("您确定要删除这个产品吗？")) {
			window.location.href="version-delete.php?id=" + id;
		}
	}
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 产品型号申请  &gt 型号管理</div> -->
    <div class="operate">
        <div class="left">
                <!-- <input type="button" class="btn_blue" value="型号申请" disabled="disabled" />  -->
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
                <th>所属企业</th>
                <th>名称</th>
                <th>code</th>
                <th>分类名称</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${products }" var="p" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${p.enterprise.company }</td>
	                <td>${p.tradename }</td>
	                <td>${p.version }</td>
	                <td>${p.name }</td>
	                <td>
	                	<c:if test="${p.isapply==0 }">审核中</c:if>
	                	<c:if test="${p.isapply==1 }">通过</c:if>
	                </td>
	                <td>
	                	<a href="version-show.php?id=${p.id }&ad=1">编辑</a>
		                <a href="version-plist.php?pid=${p.id }">查看产品属性</a>
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
