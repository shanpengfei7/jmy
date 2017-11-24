<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
  <title>套餐续费</title>
  ${error }
    <form class="layui-form" action="faceinfo/ext.jmy" method="post">
    <input type="hidden" value="${fid }" id="fid" name="fid">
	  <div class="layui-form-item">
	    <label class="layui-form-label">申请几年</label>
	    <div class="layui-input-block">
	      <input name="addyear" value="${addyear }" id="years" lay-verify="title" autocomplete="off" placeholder="请输入几年" class="layui-input" type="number" min="0">
	    </div>
	  </div>
	  <input type="hidden" value="${price }" id="price">
	  <div class="layui-form-item">
	    <label class="layui-form-label">总价格</label>
	    <div class="layui-input-block">
	      <input name="money" value="0" id="money" lay-verify="title" autocomplete="off" placeholder="请输入几年" class="layui-input" type="number" min="0">
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
		$.post("faceinfo/ext.jmy", $(' form').serialize(), function (data) {alert(data);location.href="faceinfo/extlist.jmy?fid="+$("#fid").val();});
	}
$(function(){
	$("#years").change(function() {
		$("#money").val(($("#price").val())*($("#years").val()));
	})
});
</script>
  <%@ include file="../common/tail.jsp" %>
