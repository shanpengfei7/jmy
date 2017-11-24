<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="nav.jsp" %>
 <title>用户帐号修改</title>
  ${error }
    <form class="layui-form" action="user/password.jmy" method="post">
	  <div class="layui-form-item">
	    <label class="layui-form-label">原密码</label>
	    <div class="layui-input-block">
	      <input name="password" value="${password }" placeholder="请输入原密码" autocomplete="off" class="layui-input" type="password">
	    </div>
	  </div>
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
	    <label class="layui-form-label">邮件验证码</label>
	    <div class="layui-input-block">
	      <input name="emailCode" value="${emailCode }" placeholder="请输入邮件验证码" autocomplete="off" class="layui-input" type="text">
		  <a href="javascript:emailCode();" class="layui-btn">获取验证码</a>
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
		$.post("user/password.jmy", $('form').serialize(), function (data) {
		if(data==1) {
			alert("修改成功！");location.href="user/info.jmy?o=c";
		} else {
			alert(data)
		}
		});
	}
	function emailCode() {
		$.get("user/email.jmy");
	}
 </script>
  <%@ include file="../common/tail.jsp" %>