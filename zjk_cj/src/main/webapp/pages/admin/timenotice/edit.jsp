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

  </head>
  
  <body>
  <form class="layui-form layui-form-pane" action="admin/timenotice/edit.jmy" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-inline">
      <input name="title" value="${title }" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">发送时间</label>
    <div class="layui-input-inline">
      <input name="sendTime" value="${sendTime }" lay-verify="required" placeholder="格式为    00:00:00" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">倒计时</label>
    <div class="layui-input-block">
    	<c:if test="${isTime=='on' }">
      		<input checked="" name="isTime" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF" type="checkbox">
    	</c:if>
    	<c:if test="${isTime=='off' }">
      		<input name="isTime" lay-skin="switch" lay-text="ON|OFF" type="checkbox">
    	</c:if>
    </div>
  </div>
   <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">内容</label>
    <div class="layui-input-block">
      <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor">${content }</textarea>
    </div>
  </div>
  <input type="hidden" name="message" />
  <div class="layui-form-item">
    <button class="layui-btn" lay-filter="formDemo">修改</button>${error }
  </div>
   
  </form>
  
  <script>
  
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form()
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
  var editIndex = layedit.build('LAY_demo_editor2');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
  });
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    return false;
  });
  
  
});
</script>
  </body>
</html>
