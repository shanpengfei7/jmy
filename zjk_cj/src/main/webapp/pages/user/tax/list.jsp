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
		function btn_show() {
			location.href="user/tax/list.jmy?time=" + $("#time_input").val();
		}
	</script>
  </head>
  
  <body>
  <div class="layui-form-item">
    <div class="layui-input-inline">
      <input id="time_input" value="${time }" class="layui-input" placeholder="上报时间" onchange="abc();" onclick="layui.laydate({elem: this, festival: true,format: 'YYYY-MM', })">
    </div>
    <label class="layui-form-label"><button class="layui-btn" onclick="btn_show()">查看</button></label>
  </div>
  <c:forEach items="${data }" var="d" varStatus="s">
		<c:if test="${s.last }">
			纳税人识别号：${d.idCode }&nbsp;&nbsp;&nbsp;
			纳税人名称：${d.name }&nbsp;&nbsp;&nbsp;
			<%-- 所属税务机关代码：${d.swjgDm }&nbsp;&nbsp;&nbsp; --%>
			所属税务机关名称：${d.swjgMc }
		</c:if>
  </c:forEach>
        
        
        
        
    <div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <%-- <col width="50">
      <col width="150">
      <col width="150">
      <col width="200">
      <col> --%>
    </colgroup>
    <thead>
      <tr>
        <!-- <th><input name="" lay-skin="primary" lay-filter="allChoose" type="checkbox"></th> -->
        <th></th>
        <th>限定上报日期</th>
        <th>实际上报日期</th>
        <th>合计</th>
        <th>营业税</th>
        <th>企业所得税</th>
        <th>个人所得税</th>
        <th>资源税</th>
        <th>城建税</th>
        <th>房产税</th>
        <th>印花税</th>
        <th>土地使用税</th>
        <th>土地增值税</th>
        <th>车船税</th>
        <th>烟叶税</th>
        <th>耕地占用税</th>
        <th>契税</th>
        <th>增值税</th>
      </tr> 
    </thead>
    <tbody>
      <c:forEach items="${data }" var="d">
      	<tr id="tr${d.id }">
        <%-- <td><input name="select_id" value="${d.id }" lay-skin="primary" type="checkbox"></td> --%>
        
        <td></td>
        <td>${d.nowTimeSon }</td>
        <td>${d.addTimeSon }</td>
        <td>${d.total }</td>
        <td>${d.yingys }</td>
        <td>${d.qysds }</td>
        <td>${d.grsds }</td>
        <td>${d.zys }</td>
        <td>${d.yjs }</td>
        <td>${d.fcs }</td>
        <td>${d.yhs }</td>
        <td>${d.tdsys }</td>
        <td>${d.tdzzs }</td>
        <td>${d.ccs }</td>
        <td>${d.yanys }</td>
        <td>${d.gdzys }</td>
        <td>${d.qs }</td>
        <td>${d.zzs }</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<script>
layui.use(['form','laypage', 'layer', 'laydate'], function(){
  var $ = layui.jquery, form = layui.form();
  var laypage = layui.laypage
  ,layer = layui.layer;
   var laydate = layui.laydate;
  
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
