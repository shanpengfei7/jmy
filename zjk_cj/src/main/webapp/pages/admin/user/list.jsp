<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">

	<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
	<script type="text/javascript" src="static/layui/layui.js"></script>
	<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		function btn_add(pid, role) {
			if(role == 3) {
				location.href="admin/enterprise/add.jmy?id=" + pid + "&role=" + role;
			} else {
				location.href="admin/user/add.jmy?pid=" + pid + "&role=" + role;
			}
		}
		function btn_show(id, role) {
			if(role == 2) {
				location.href="admin/enterprise/list.jmy?id=" + id;
			} else {
				location.href="admin/user/list.jmy?id=" + id;
			}
		}
		function btn_edit(id, role) {
			if(role == 3) {
				location.href="admin/enterprise/edit.jmy?id=" + id;
			} else {
				location.href="admin/user/edit.jmy?id=" + id;
			}
		}
		function btn_pass(id, role) {
			if(role == 3) {
				location.href="admin/enterprise/pass.jmy?id=" + id;
			} else {
				location.href="admin/user/pass.jmy?id=" + id;
			}
		}
		function btn_del(id, role) {
			var url;
			if(role == 3) {
				
				url="admin/enterprise/del.jmy?id=" + id;
			} else {
				url="admin/user/del.jmy?id=" + id;
			}
			if(confirm("你确定要删除这个用户吗？")) {
				$.get(url,function(data) {
					if(data.status==1) {
						$("#tr"+id).remove();
					}
				},"json");
			}
		}
	</script>
  </head>
  
  <body>
  <div class="layui-btn-group">
    <button class="layui-btn" onclick="btn_add('${id }','${role }')">增加</button>
    
  </div>
  <div class="layui-btn-group">
    <c:if test="${role==0 }"><button class="layui-btn layui-btn-primary layui-btn-small">市局列表</button></c:if>
    <c:if test="${role==1 }"><button class="layui-btn layui-btn-primary layui-btn-small">县区局列表</button></c:if>
    <c:if test="${role==2 }"><button class="layui-btn layui-btn-primary layui-btn-small">分局列表</button></c:if>
    <c:if test="${role==3 }"><button class="layui-btn layui-btn-primary layui-btn-small">企业列表</button></c:if>
    
  </div>
  
  
     <input type="hidden" value="${id }" id="page_id">
    <div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col width="50">
      <col width="150">
      <col width="150">
      <col width="200">
      <col>
    </colgroup>
    <thead>
      <tr>
        <!-- <th><input name="" lay-skin="primary" lay-filter="allChoose" type="checkbox"></th> -->
        <th></th>
        <th>税务机关代码</th>
        <th>姓名</th>
        <th>手机</th>
        <th>工作单位</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody>
      <c:forEach items="${data.rows }" var="d">
      	<tr id="tr${d.id }">
        <%-- <td><input name="select_id" value="${d.id }" lay-skin="primary" type="checkbox"></td> --%>
        <td></td>
        <td>${d.swjgDm }</td>
        <td>${d.name }</td>
        <td>${d.phone }</td>
        <td>${d.swjg.swjgmc }</td>
        <td>
			<div class="layui-btn-group">
			    <button class="layui-btn" onclick="btn_edit('${d.id }','${role }')">编辑</button>
			    <button class="layui-btn" onclick="btn_pass('${d.id }','${role }')">改密</button>
			    <%-- <button class="layui-btn" onclick="btn_del('${d.id }','${role }')">删除</button> --%>
			    <button class="layui-btn" onclick="btn_show('${d.id }','${role }')">查看</button>
			  </div>
		</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
    <div id="pagedata"></div>
     <input type="hidden" value="${data.count }" id="datacount">
     <input type="hidden" value="${param.page }" id="page">
</div>

<script>
layui.use(['form','laypage', 'layer'], function(){
  var $ = layui.jquery, form = layui.form();
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  laypage({
    cont: 'pagedata'
    ,pages: document.getElementById("datacount").value //总页数
    ,groups: 5 //连续显示分页数
    ,skin: '#1E9FFF'
    ,curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	    var pageNum = location.search.match(/pageNum=(\d+)/);
	    return pageNum ? pageNum[1] : 1;
	 }() 
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第 '+ obj.curr +' 页');
        location.href="admin/user/list.jmy?pageNum=" +obj.curr+"&id=" +$("#page_id").val();
      }
    }
    ,skip: true
  });
  //全选
  form.on('checkbox(allChoose)', function(data){
    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
    child.each(function(index, item){
      item.checked = data.elem.checked;
    });
    form.render('checkbox');
  });
  
});
</script>
  </body>
</html>
