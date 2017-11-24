<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../user/nav.jsp" %>
  <title>申请套餐添加</title>
  ${error }
    <form class="layui-form" action="faceapplay/applay.jmy" method="post">
    <input type="hidden" value="${param.tid }" name="tid">
	  <div class="layui-form-item">
	    <label class="layui-form-label">申请几年</label>
	    <div class="layui-input-block">
	      <input name="years" value="${years }" id="years" lay-verify="title" autocomplete="off" placeholder="请输入几年" class="layui-input" type="number" min="0">
	    </div>
	  </div>
	  <input type="hidden" value="${param.price }" id="price">
	  <div class="layui-form-item">
	    <label class="layui-form-label">总价格</label>
	    <div class="layui-input-block">
	      <input name="money" value="0" id="money" disabled="disabled" lay-verify="title" autocomplete="off" placeholder="请输入几年" class="layui-input" type="number" min="0">
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
		$.post("faceapplay/applay.jmy", $('form').serialize(), function (data) {alert(data);location.href="faceapplay/list.jmy";});
	}
$(function(){
$("#years").val(1);
$("#money").val(($("#price").val())*($("#years").val()));
	$("#years").change(function() {
		$("#money").val(($("#price").val())*($("#years").val()));
	})
});
</script>
  <%@ include file="../common/tail.jsp" %>
