<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="nav.jsp" %>
 <title>用户密码修改</title>
  ${error }
    <form class="layui-form" action="admin/password.jmy" method="post">
    <input type="hidden" name="uid" value="${param.id }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">新密码</label>
	    <div class="layui-input-block">
	      <input name="password1" value="${password1 }" placeholder="请输入新密码" autocomplete="off" class="layui-input" type="password">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">确认密码</label>
	    <div class="layui-input-block">
	      <input name="password2" value="${password2 }" placeholder="请输入确认密码" autocomplete="off" class="layui-input" type="password">
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
		$.post("admin/password.jmy", $('form').serialize(), function (data) {
			alert(data);
			if(data=="修改成功！") {
				location.href="admin/list.jmy";
			}
		});
		
	}
 </script>
  <%@ include file="../common/tail.jsp" %>