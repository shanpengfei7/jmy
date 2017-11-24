<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>套餐申请修改</title>
<%@include file="../admin/nav.jsp" %>
    <form class="layui-form" action="faceapplay/edit.jmy" method="post">
    <input type="hidden" name="id" value="${id }">
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
	      <input name="years"  value="${years }" id="years" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
      <input type="hidden" value="${price }" id="price">
	  <div class="layui-form-item">
	    <label class="layui-form-label">价格</label>
	    <div class="layui-input-block">
	      <input name="money"  value="${money }" id="money" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
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
		$.post("faceapplay/edit.jmy", $('form').serialize(), function (data) {alert(data);location.href="faceapplay/adlist.jmy";});
	}
$(function(){
	$("#years").change(function() {
		$("#money").val(($("#price").val())*($("#years").val()));
	})
});
</script>
 <%@ include file="../common/tail.jsp" %>
