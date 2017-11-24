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
			location.href="admin/tax/list.jmy?time=" + $("#time_input").val() +"&swjgDm=" +$("#swjgDm_input").val()+ "&idCode=" +$("#idCode_input").val();
		}
		function btn_excel() {
			window.location.href="admin/tax/excel.jmy?time=" + $("#time_input").val() +"&swjgDm=" +$("#swjgDm_input").val()+ "&idCode=" +$("#idCode_input").val();
		}
	</script>
  </head>
  
  <body>
  <form class="layui-form layui-form-pane" method="post">
  <div class="layui-form-item">
  	<label class="layui-form-label">时间节点</label>
	    <div class="layui-input-inline">
	      	<select id="time_input" name="time" lay-verify="required" lay-search="">
	          <option value="${time }">${time }</option>
	          <c:forEach items="${pritimes }" var="d">
	          <option value="${d.now }">${d.now }</option>
	          </c:forEach>
	        </select>
	    </div>
  	<label class="layui-form-label">税务机关</label>
	    <div class="layui-input-inline">
	      	<select id="swjgDm_input" name="swjgDm" lay-verify="required" lay-search="">
	          <option value="${swjgDm }">${swjgmc }</option>
	          <c:forEach items="${swjgs }" var="d">
	          <option value="${d.swjgDm }">${d.swjgmc }</option>
	          </c:forEach>
	        </select>
	    </div>
  	<label class="layui-form-label">纳税人</label>
	    <div class="layui-input-inline">
	      	<select id="idCode_input" name="idCode" lay-verify="required" lay-search="">
	          <option value="${idCode }">${name }</option>
	          <c:forEach items="${enterprises }" var="d">
	          <option value="${d.idCode }">${d.name }</option>
	          </c:forEach>
	        </select>
	    </div>
    <label class="layui-form-label"><a href="javascript:btn_show();">查看</a></label>
    <c:if test="${sessionScope.admin.role==1 }">
    <label class="layui-form-label"><a href="javascript:btn_excel();">导出</a></label>
    </c:if>
  </div>
</form>
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
        <th>纳税人识别号</th>
        <th>纳税人名称</th>
        <th>所属税务机关代码</th>
        <th>所属税务机关名称</th>
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
    	<tr>
        <td>合计</td>
        <td></td>
        <td></td>
        <td></td>
        <td>${count }</td>
        <td></td>
        <td></td>
        <td>${dtotal }</td>
        <td>${dyingys }</td>
        <td>${dqysds }</td>
        <td>${dgrsds }</td>
        <td>${dzys }</td>
        <td>${dyjs }</td>
        <td>${dfcs }</td>
        <td>${dyhs }</td>
        <td>${dtdsys }</td>
        <td>${dtdzzs }</td>
        <td>${dccs }</td>
        <td>${dyanys }</td>
        <td>${dgdzys }</td>
        <td>${dqs }</td>
        <td>${dzzs }</td>
      </tr>
      <c:forEach items="${data }" var="d">
      	<tr id="tr${d.id }">
        <%-- <td><input name="select_id" value="${d.id }" lay-skin="primary" type="checkbox"></td> --%>
        
        <td></td>
        <td>${d.nowTimeSon }</td>
        <td>${d.addTimeSon }</td>
        <td>${d.idCode }</td>
        <td>${d.name }</td>
        <td>${d.swjgDm }</td>
        <td>${d.swjgMc }</td>
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
