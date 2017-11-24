<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>接口信息</title>
<%@include file="../user/nav.jsp" %>
    <form class="layui-form" action="admin/edit.jmy" method="post" enctype="multipart/form-data">
	  <div class="layui-form-item">
	    <label class="layui-form-label">申请人</label>
	    <div class="layui-input-block">
	      <input name="name" disabled="disabled" value="${user }" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	     <label class="layui-form-label">套餐名称</label>
	    <div class="layui-input-block">
	      <input name="phone" disabled="disabled" value="${tao }" lay-verify="title" autocomplete="off" placeholder="请输入手机" class="layui-input" type="text">
	    </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">几年</label>
	    <div class="layui-input-block">
	      <input name="email" disabled="disabled" value="${years }" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">价格</label>
	    <div class="layui-input-block">
	      <input name="address" disabled="disabled" value="${money }" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">状态</label>
	    <div class="layui-input-block">
	      <c:if test="${status==0 }">
	      	<input name="status" value="已失效" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	      <c:if test="${status==1 }">
	      	<input name="status" value="正常" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
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
