<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
    
    <title>接口套餐修改</title>
  ${error }
    <form class="layui-form" action="package/edit.jmy" method="post">
    <input type="hidden" name="id" value="${id }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">名称</label>
	    <div class="layui-input-block">
	      <input name="name" value="${name }" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">价格</label>
	    <div class="layui-input-block">
	      <input name="money" value="${money }" lay-verify="title" autocomplete="off" placeholder="请输入价格" class="layui-input" min="0" type="number">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">接口</label>
	    <div class="layui-input-block">
<blockquote class="layui-elem-quote layui-quote-nm">
  <div class="layui-field-box">
    
	<c:forEach items="${data }" var="d">
		  <div class="layui-form-item">
		    <label class="layui-form-label">${d.name }</label>
		    <div class="layui-input-block">
			        <c:forEach items="${d.actions }" var="a">
			        	<c:if test="${a.select }">
			        		<input name="actions" checked="checked" title="${a.name }" value="${a.actionName }" type="checkbox">
			        	</c:if>
			        	<c:if test="${!a.select }">
			        		<input name="actions" title="${a.name }" value="${a.actionName }" type="checkbox">
			        	</c:if>
			        </c:forEach>
		  </div>
	     </div>
	</c:forEach>
  </div>
</blockquote>
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
		$.post("package/edit.jmy", $('form').serialize(), function (data) {alert(data);location.href="package/list.jmy";});
	}
 </script>
  <script>
layui.use('layedit', function(){
  var layedit = layui.layedit
  ,$ = layui.jquery;
});
</script>
  <%@ include file="../common/tail.jsp" %>
