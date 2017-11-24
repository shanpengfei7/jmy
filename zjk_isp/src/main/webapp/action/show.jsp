<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
    
    <title>接口分类修改</title>
  ${error }
    <form class="layui-form" action="class/edit.jmy" method="post">
    <input type="hidden" name="id" value="${id }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">名称</label>
	    <div class="layui-input-block">
	      <input name="name" value="${name }" disabled="disabled" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">action</label>
	    <div class="layui-input-block">
	      <input name="actionName" value="${actionName }" disabled="disabled" lay-verify="title" autocomplete="off" placeholder="请输入action" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">排序</label>
	    <div class="layui-input-block">
	      <input name="sort" value="${sort }" disabled="disabled" lay-verify="title" autocomplete="off" placeholder="请输入数字" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">备注</label>
	    <div class="layui-input-block">
	      <textarea name="remark" placeholder="请输入备注内容" class="layui-textarea">${remark }</textarea>
	    </div>
	  </div>
  </form>
  <script>
layui.use('layedit', function(){
  var layedit = layui.layedit
  ,$ = layui.jquery;
  
  //构建一个默认的编辑器
  var index = layedit.build('remark');
  
});
</script>
  <%@ include file="../common/tail.jsp" %>
