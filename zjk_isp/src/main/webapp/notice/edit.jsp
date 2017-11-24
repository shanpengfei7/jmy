<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
  <title>通知消息添加</title>
  ${error }
    <form class="layui-form" action="notice/edit.jmy" method="post">
    <input type="hidden" name="id" value="${id }">
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
	  
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <a href="javascript:sub();" class="layui-btn">立即提交</a>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
  </form>
    <script type="text/javascript" src="common/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
	function sub() {
		$.post("notice/edit.jmy", $(' form').serialize(), function (data) {alert(data);location.href="notice/adlist.jmy";});
	}
 </script>
  <%@ include file="../common/tail.jsp" %>
