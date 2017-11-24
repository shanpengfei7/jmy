<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">

	<link rel="stylesheet" type="text/css" href="static/css/app_tax_add.css">
	<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
  </head>
  
  <body>
  <form class="layui-form layui-form-pane" action="app/tax/mit.jmy" method="post">
  <input type="hidden" name="enterpriseId" value="${id }">
  <div class="layui-form-item layui-form-center">
    <label class="layui-form-label">单位：元</label>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">营业税</label>
    <div class="layui-input-inline">
      <input name="yingys" type="number" step="0.01" value="${yingys }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">企业所得税</label>
    <div class="layui-input-inline">
      <input name="qysds" type="number" step="0.01" value="${qysds }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">个人所得税</label>
    <div class="layui-input-inline">
      <input name="grsds" type="number" step="0.01" value="${grsds }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">资源税</label>
    <div class="layui-input-inline">
      <input name="zys" type="number" step="0.01" value="${zys }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">城建税</label>
    <div class="layui-input-inline">
      <input name="yjs" type="number" step="0.01" value="${yjs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">房产税</label>
    <div class="layui-input-inline">
      <input name="fcs" type="number" step="0.01" value="${fcs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">印花税</label>
    <div class="layui-input-inline">
      <input name="yhs" type="number" step="0.01" value="${yhs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">土地使用税</label>
    <div class="layui-input-inline">
      <input name="tdsys" type="number" step="0.01" value="${tdsys }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">土地增值税</label>
    <div class="layui-input-inline">
      <input name="tdzzs" type="number" step="0.01" value="${tdzzs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>  
  <div class="layui-form-item">
    <label class="layui-form-label">车船税</label>
    <div class="layui-input-inline">
      <input name="ccs" type="number" step="0.01" value="${ccs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  
  
  
   <div class="layui-form-item">
    <label class="layui-form-label">烟叶税</label>
    <div class="layui-input-inline">
      <input name="yanys" type="number" step="0.01" value="${yanys }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">耕地占用税</label>
    <div class="layui-input-inline">
      <input name="gdzys" type="number" step="0.01" value="${gdzys }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">契税</label>
    <div class="layui-input-inline">
      <input name="qs" type="number" step="0.01" value="${qs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">增值税</label>
    <div class="layui-input-inline">
      <input name="zzs" type="number" step="0.01" value="${zzs }" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  
 
  
  <div class="layui-form-item last-item">
    <label class="layui-form-label">合计</label>
    <div class="layui-input-inline">
      <input id="total" name="total" value="${total }" lay-verify="required" placeholder="可以不填写" autocomplete="off" class="layui-input" type="text">
    </div>
  </div>
  <div class="layui-form-item layui-form-center bottom">
    <button class="layui-btn" lay-filter="formDemo">上&nbsp;&nbsp;&nbsp;&nbsp;报</button>${error }
  </div>
   
  </form>
  
  <script type="text/javascript">
  
    /** 
     * 模仿android里面的Toast效果，主要是用于在不打断程序正常执行的情况下显示提示数据 
     * @param config 
     * @return 
     */  
    var Toast = function(config){  
        this.context = config.context==null?$('body'):config.context;//上下文  
        this.message = config.message;//显示内容  
        this.time = config.time==null?3000:config.time;//持续时间  
        this.left = config.left;//距容器左边的距离  
        this.top = config.top;//距容器上方的距离  
        this.init();  
    }  
    var msgEntity;  
    Toast.prototype = {  
        //初始化显示的位置内容等  
        init : function(){  
            $("#toastMessage").remove();  
            //设置消息体  
            var msgDIV = new Array();  
            msgDIV.push('<div id="toastMessage">');  
            msgDIV.push('<span>'+this.message+'</span>');  
            msgDIV.push('</div>');  
            msgEntity = $(msgDIV.join('')).appendTo(this.context);  
            //设置消息样式  
            var left = this.left == null ? this.context.width()/2-msgEntity.find('span').width()/2 : this.left;  
            var top = this.top == null ? this.context.height()/2-msgEntity.find('span').height()/2 : this.top;  
            msgEntity.css({position:'absolute',top:top,'z-index':'99',left:left,'background-color':'black',color:'white','font-size':'18px',padding:'10px',margin:'10px'});  
            msgEntity.hide();  
        },  
        //显示动画  
        show :function(){  
            msgEntity.fadeIn(this.time/2);  
            msgEntity.fadeOut(this.time/2);  
        }  
              
    }  
  	 $(function() {
  	 var sum = 0;
	$("input").blur(function() {
  	 	sum = 0;
		 $.each($(":text"),function(){
		 var checkNum = /^([1-9]\d{0,9}|0)([.]?|(\.\d{1,2})?)$/;
		 if(checkNum.test(this.value)) {
			 if(this.name!="total") {
	        	 sum += parseInt(this.value);
			 }
		 } else {
		 	if(this.value!='') {
			 	alert('输入的格式不正确！')
			 	$(this).val('');
			 }
		 }
		 
    	});

		$("#total").val(sum);
	});
});
  </script>
  <script>
 
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form()
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    return false;
  });
  
  
});
</script>


  </body>
</html>
