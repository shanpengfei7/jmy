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
	function btn_add(roler) {
		window.location.href="employee-add.jmy?";
	}
	function delete_btn(id) {
		if(confirm("您确定要删除这条记录吗？")) {
			window.location.href="employee-delete.php?id=" + id;
		}
	}
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 企业员工管理  &gt 员工列表</div> -->
    <div class="operate">
        <div class="left">
                <input type="button" onclick="btn_add(${roler})" class="btn_blue" value="员工添加">
        </div>
        <div class="left_pad">
            <%-- <form method="post" action="employee-list.php">
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
                <th>姓名</th>
                <th>性别</th>
                <th>帐号</th>
                <th>工号</th>
                <th>电话</th>
				<th>状态</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${employees }" var="e" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${e.name }</td>
	                <c:if test="${e.sex==1 }"><td>男</td></c:if>
	                <c:if test="${e.sex==2 }"><td>女</td></c:if>
	                <td>${e.username }</td>
	                <td>${e.jobnumber }</td>
	                <td>${e.phonenumber }</td>
	                <td>
	                	<c:if test="${e.status==0 }">启用</c:if>
	                	<c:if test="${e.status==1 }">禁用</c:if>
	                </td>
					<td>
					<date:date value ="${e.createtime} "/>
					</td>
	                <td>
	                
	                <a href="pages/employee/username.jsp?id=${e.id }&name=${e.username }">修改帐号</a>
	                <a href="pages/employee/pswd.jsp?id=${e.id }">修改密码</a>
	                <a href="employee-show.php?id=${e.id }&operate=4&roler=${roler}">编辑</a>
	                <a href="javascript:delete_btn('${e.id }')">删除</a>
					</td>
            </tr>
			</c:forEach>
        </table>
       <div class="page" style="clear: both;">
		   <div>
			   <span class="rows">共 ${rowCount }条记录</span>
			   <a class="prev" href="employee-list.php?enterpriseid=${enterpriseid }&pageNow=${pageNow-1 }"><<</a>
			   <c:choose>
			   <c:when test="${pageNow<3 }">
			   		<c:forEach begin="1" end="${pageCount>5?5:pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?enterpriseid=${enterpriseid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>=3&&pageNow<=pageCount-2 }">
			   		<c:forEach begin="${pageNow-2 }" end="${pageNow+2 }" var="page">
			   			<c:if test="${page==pageNow }">
							<span class="current">${page }</span>			   			
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?enterpriseid=${enterpriseid }&pageNow=${page }">${page }</a>		   			
			   			</c:if>
			   		</c:forEach>
			   </c:when>
			   <c:when test="${pageNow>pageCount-2 }">
			   		<c:forEach begin="${pageCount-5>0?pageCount-4:1 }" end="${pageCount }" var="page">
				   		<c:if test="${page==pageNow }">
			   				<span class="current">${page }</span>	
			   			</c:if>
			   			<c:if test="${page!=pageNow }">
							<a class="num"  href="employee-list.php?enterpriseid=${enterpriseid }&pageNow=${page }">${page }</a>		   			
				   		</c:if>
			   		</c:forEach>
			   </c:when>
			   </c:choose>
			   <a class="next" href="employee-list.php?enterpriseid=${enterpriseid }&pageNow=${pageNow+1 }">>></a>
		   </div>
	   </div>

    </form>
    </div>
</div>
  </body>
</html>
