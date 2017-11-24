<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>接口信息</title>
<%@include file="../admin/nav.jsp" %>
    <form class="layui-form" action="admin/edit.jmy" method="post" enctype="multipart/form-data">
	  <div class="layui-form-item">
	    <label class="layui-form-label">增加年数</label>
	    <div class="layui-input-block">
	      <input name="name" disabled="disabled" value="${addyear }" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	     <label class="layui-form-label">上次有效截至时间</label>
	    <div class="layui-input-block">
	      <input name="phone" disabled="disabled" value="${oldTime }" lay-verify="title" autocomplete="off" placeholder="请输入手机" class="layui-input" type="text">
	    </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">新的截至时间</label>
	    <div class="layui-input-block">
	      <input name="email" disabled="disabled" value="${newTime }" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">价格</label>
	    <div class="layui-input-block">
	      <input name="address" disabled="disabled" value="${money }" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
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
