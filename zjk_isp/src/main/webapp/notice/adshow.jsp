<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
  <title>通知消息</title>
  ${error }
    <form class="layui-form" action="notice/add.jmy" method="post">
	  <div class="layui-form-item">
	    <label class="layui-form-label">标题</label>
	    <div class="layui-input-block">
	      <input name="title" value="${title }" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">内容</label>
	    <div class="layui-input-block">
	      <textarea name="content" placeholder="请输入备注内容" class="layui-textarea">${content }</textarea>
	    </div>
	  </div>
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">备注</label>
	    <div class="layui-input-block">
	      <textarea name="message" placeholder="请输入备注内容" class="layui-textarea">${message }</textarea>
	    </div>
	  </div>
  </form>
  <%@ include file="../common/tail.jsp" %>
