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
		function btn_add() {
			location.href="admin/app/add.jmy";
		}
		function btn_edit(id) {
			location.href="admin/app/edit.jmy?id=" + id;
		}
		function btn_down(id) {
			location.href="admin/app/download.jmy?id=" + id;
		}
		function btn_del(id) {
			var url;
			url="admin/app/del.jmy?id=" + id;
			if(confirm("你确定要删除这个app吗？")) {
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
    <button class="layui-btn" onclick="btn_add('${id }')">上传</button>
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
        <th>名称</th>
        <th>版本号</th>
        <th>操作</th>
      </tr> 
    </thead>
    <tbody>
      <c:forEach items="${data }" var="d">
      	<tr id="tr${d.id }">
        <%-- <td><input name="select_id" value="${d.id }" lay-skin="primary" type="checkbox"></td> --%>
        <td></td>
        <td>${d.name }</td>
        <td>${d.version }</td>
        <td>
			<div class="layui-btn-group">
			    <button class="layui-btn" onclick="btn_edit('${d.id }')">编辑</button>
			    <button class="layui-btn" onclick="btn_down('${d.id }')">下载</button>
			    <button class="layui-btn" onclick="btn_del('${d.id }')">删除</button>
			  </div>
		</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<script>
layui.use(['form','laypage', 'layer'], function(){
  var $ = layui.jquery, form = layui.form();
  var laypage = layui.laypage
  ,layer = layui.layer;
  
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
