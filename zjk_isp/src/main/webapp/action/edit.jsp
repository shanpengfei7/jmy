<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
    
    <title>接口分类修改</title>
  ${error }
    <form class="layui-form" action="action/edit.jmy" method="post">
    <input type="hidden" name="id" value="${id }">
    <input type="hidden" value="${cid }" id="cid" name="cid">
	  <div class="layui-form-item">
	    <label class="layui-form-label">名称</label>
	    <div class="layui-input-block">
	      <input name="name" value="${name }" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">action</label>
	    <div class="layui-input-block">
	      <input name="actionName" value="${actionName }" lay-verify="title" autocomplete="off" placeholder="请输入action" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">排序</label>
	    <div class="layui-input-block">
	      <input name="sort" value="${sort }" lay-verify="title" autocomplete="off" placeholder="请输入数字" class="layui-input" type="text">
	    </div>
	  </div>
	    <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">备注</label>
	    <div class="layui-input-block">
	      <textarea name="remark" placeholder="请输入备注内容" class="layui-textarea">${remark }</textarea>
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
		$.post("action/edit.jmy", $(' form').serialize(), function (data) {alert(data);location.href="action/list.jmy?cid="+$("#cid").val();});
	}
 </script>
  <%@ include file="../common/tail.jsp" %>
