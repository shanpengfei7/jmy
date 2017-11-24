<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="nav.jsp" %>
 <title>用户资料修改</title>
  ${error }
    
    <input type="hidden" name="id" value="${id }">
	  <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input name="name" value="${name }" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	     <label class="layui-form-label">手机</label>
	    <div class="layui-input-block">
	      <input name="phone" value="${phone }" lay-verify="title" autocomplete="off" placeholder="请输入手机" class="layui-input" type="text">
	    </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
	    <div class="layui-input-block">
	      <input name="email" value="${email }" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">地址</label>
	    <div class="layui-input-block">
	      <input name="address" value="${address }" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">帐号</label>
	    <div class="layui-input-block">
	      <input name="username" value="${username }" lay-verify="title" autocomplete="off" disabled="disabled" class="layui-input" type="text">
	    </div>
	  </div>
	  <form class="layui-form" id="subfun" action="user/pic.jmy" method="post" enctype="multipart/form-data">
	  <div class="layui-form-item">
	    <label class="layui-form-label">证件照片</label>
	    <div class="layui-input-block">
	      	<input id="mypic" name="pic" class="layui-upload-file" type="file" lay-title="添加证件的图片">
	    	<img id="LAY_demo_upload" src="${pic }" width="200" height="200">
	    	<input type="hidden" name="picName" id="picName">
	    </div>
	  </div>
	  </form>
	  <div class="layui-form-item">
	    <label class="layui-form-label">状态</label>
	    <div class="layui-input-block">
	      <c:if test="${status==0 }">
	      	<input name="status" value="未审核" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	      <c:if test="${status==1 }">
	      	<input name="status" value="审核通过" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	      <c:if test="${status==2 }">
	      	<input name="status" value="审核拒绝" lay-verify="title" autocomplete="off" disabled="disabled" placeholder="未审核" class="layui-input" type="text">
	      </c:if>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <a href="javascript:sub();" class="layui-btn">立即提交</a>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	      
	    </div>
	  </div>
   	<script type="text/javascript" src="common/js/jquery.form.js"></script>
  <script type="text/javascript">
	
	$(function() {
  		$("#picName").val($("#LAY_demo_upload").attr('src'));
  		$("#mypic").change(function(){
  			$("#subfun").ajaxSubmit(function(message){
				$("#LAY_demo_upload").attr('src',message); 
				$("#picName").val(message);
	  		});
	  		
		});
	});
	</script>
	<script type="text/javascript">
	function sub() {	
		var name = $('input[name="name"]').val();
		var phone = $('input[name="phone"]').val();
		var email = $('input[name="email"]').val();
		var address = $('input[name="address"]').val();
		var username = $('input[name="username"]').val();
		var password1 = $('input[name="password1"]').val();
		var password2 = $('input[name="password2"]').val();
		var verify = $('input[name="verify"]').val();
		var picName = $('input[name="picName"]').val();
		var id = $('input[name="id"]').val();
		
		$.post("user/edit.jmy", 
		
			{"name":name,"phone":phone,"email":email,"address":address,"picName":picName,"id":id,
			"username":username,"password1":password1,"password2":password2,"verify":verify}, 
			
			function (data) {
				if(data==1) {
					alert("注册成功！")
					location.href="user/login.jsp";
				} else {
					alert(data);
				}
			}
		);
	}
 </script>
  <%@ include file="../common/tail.jsp" %>