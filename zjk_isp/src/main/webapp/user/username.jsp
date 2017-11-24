<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="nav.jsp" %>
 <title>用户帐号修改</title>
  ${error }
    <form class="layui-form" action="user/username.jmy" method="post">
	  <div class="layui-form-item">
	    <label class="layui-form-label">帐号</label>
	    <div class="layui-input-block">
	      <input name="username" value="${username }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <a href="javascript:sub();" class="layui-btn">立即提交</a>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	      
	    </div>
	  </div>
  </form>
  <script type="text/javascript">
	function sub() {
		$.post("user/username.jmy", $('form').serialize(), function (data) {alert(data);location.href="user/info.jmy?o=c";});
	}
 </script>
  <%@ include file="../common/tail.jsp" %>