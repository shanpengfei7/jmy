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
  <form class="layui-form layui-form-pane" action="admin/user/add.jmy" method="post">
  <input type="hidden" name="pid" value="${pid }">
  <input type="hidden" name="role" value="${role }">
  <div class="layui-form-item">
      <label class="layui-form-label">选择添加的机构</label>
      <div class="layui-input-inline">
        <select name="swjgDm" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <c:forEach items="${swjgs }" var="d">
          <c:if test="${d.swjgDm==swjgDm }">
          <option value="${d.swjgDm }" checked="checked">${d.swjgmc }</option>
          </c:if>
          <c:if test="${d.swjgDm!=swjgDm }">
          <option value="${d.swjgDm }">${d.swjgmc }</option>
          </c:if>
          </c:forEach>
        </select>
      </div>
    </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input name="password1" value="${password1 }" lay-verify="pass" placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input name="password2" value="${password2 }" lay-verify="pass" placeholder="请输入" autocomplete="off" class="layui-input" type="password">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input name="name" value="${name }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">手机</label>
    <div class="layui-input-inline">
      <input name="phone" value="${phone }" lay-verify="phone" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <button class="layui-btn" lay-filter="formDemo">添加</button>${error }
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
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    return false;
  });
  
  
});
</script>
  </body>
</html>
