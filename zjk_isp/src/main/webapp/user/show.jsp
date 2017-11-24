<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>用户资料查看</title>
<%@include file="nav.jsp" %>
    <form class="layui-form" action="user/edit.jmy" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${id }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input name="name" disabled="disabled" value="${name }" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	     <label class="layui-form-label">手机</label>
	    <div class="layui-input-block">
	      <input name="phone" disabled="disabled" value="${phone }" lay-verify="title" autocomplete="off" placeholder="请输入手机" class="layui-input" type="text">
	    </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
	    <div class="layui-input-block">
	      <input name="email" disabled="disabled" value="${email }" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">地址</label>
	    <div class="layui-input-block">
	      <input name="address" disabled="disabled" value="${address }" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">帐号</label>
	    <div class="layui-input-block">
	      <input name="username" value="${username }" lay-verify="title" autocomplete="off" disabled="disabled" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">证件照片</label>
	    <div class="layui-input-block">
	    	<img id="LAY_demo_upload" src="${pic }" width="200" height="200">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">状态</label>
	    <div class="layui-input-block">
	      <c:if test="${status==0 }">
	      	<input name="status" value="未审核" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	      <c:if test="${status==1 }">
	      	<input name="status" value="审核通过" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	      <c:if test="${status==2 }">
	      	<input name="status" value="审核拒绝" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	    </div>
	  </div>
  </form>
 <%@ include file="../common/tail.jsp" %>
