<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="nav.jsp" %>
 <title>用户列表</title>
 <input type="hidden" id="name" value="${name }">
 <input type="hidden" id="username" value="${username }">
 <input type="hidden" id="phone" value="${phone }">
 <input type="hidden" id="email" value="${email }">
 <input type="hidden" id="address" value="${address }">
 <input type="hidden" id="status" value="${status }">
 <form class="layui-form" action="admin/list.jmy" method="post">

  <div class="layui-form-item">
    <div class="layui-input-block">
    
     <label class="layui-form-label">姓名</label>
      <div class="layui-input-inline">
        <input name="name" value="${name }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      
       <label class="layui-form-label">帐号</label>
      <div class="layui-input-inline">
        <input name="username" value="${username }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      
       <label class="layui-form-label">电话</label>
      <div class="layui-input-inline">
        <input name="phone" value="${phone }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      
       <label class="layui-form-label">邮箱</label>
      <div class="layui-input-inline">
        <input name="email" value="${email }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      
       <label class="layui-form-label">地址</label>
      <div class="layui-input-inline">
        <input name="address" value="${address }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>

      <label class="layui-form-label">状态</label>
      <div class="layui-input-inline">
       	<c:if test="${status!=1&&status!=2&&status!=0 }">
       		<select name="status">
			  <option value="3" selected>请选择</option>
			  <option value="0">未审核</option>
			  <option value="1">审核通过</option>
			  <option value="2">审核拒绝</option>
			</select>
       	</c:if>     
       	<c:if test="${status==0 }">
       		<select name="status">
			  <option value="3">请选择</option>
			  <option value="0" selected>未审核</option>
			  <option value="1">审核通过</option>
			  <option value="2">审核拒绝</option>
			</select>
       	</c:if>     
       	<c:if test="${status==1 }">
       		<select name="status">
			  <option value="3">请选择</option>
			  <option value="0">未审核</option>
			  <option value="1" selected>审核通过</option>
			  <option value="2">审核拒绝</option>
			</select>
       	</c:if>     
       	<c:if test="${status==2 }">
       		<select name="status">
			  <option value="3">请选择</option>
			  <option value="0">未审核</option>
			  <option value="1">审核通过</option>
			  <option value="2" selected>审核拒绝</option>
			</select>
       	</c:if>     
		</div>
		<div class="layui-form-item">
  </div>
      <label class="layui-form-label"></label>
      <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即查找</button>
        <a href="admin/register.jsp" class="layui-btn">添加用户</a>
      </div>
      
    </div>
  </div>
 </form>
 
 
  <table width="100%" class="layui-table" lay-even="" lay-skin="row">
         <tr>
             <th>序号</th>
             <th>姓名</th>
             <th>帐号</th>
             <th>电话</th>
             <th>邮箱</th>
             <th>地址</th>
             <th>状态</th>
             <th>操作</th>
         </tr>
<c:forEach items="${data.rows }" var="d" varStatus="s">
<tr class="table_tr${d.id }">
	<td>${s.index+1 }</td>
	<td>${d.name }</td>
	<td>${d.username }</td>
	<td>${d.phone }</td>
	<td>${d.email }</td>
	<td>${d.address }</td>
	<c:if test="${d.status==null }"><td id="status${d.id }">未审核</td></c:if>
	<c:if test="${d.status==0 }"><td id="status${d.id }">未审核</td></c:if>
	<c:if test="${d.status==1 }"><td id="status${d.id }">审核通过</td></c:if>
	<c:if test="${d.status==2 }"><td id="status${d.id }">审核拒绝</td></c:if>
	<td>
		<a href="admin/info.jmy?o=c&id=${d.id }" id="ext${d.id }" class="layui-btn layui-btn-mini">查看</a>
		<c:if test="${d.status!=1 }">
		<a href="javascript:check(${d.id });" id="check${d.id }" class="layui-btn layui-btn-mini">审核通过</a>
		</c:if>
		<c:if test="${d.status!=2 }">
		<a href="javascript:uncheck(${d.id });" id="uncheck${d.id }" class="layui-btn layui-btn-mini">审核拒绝</a>
		</c:if>
		<c:if test="${d.status!=1 }">
		<a href="admin/info.jmy?o=x&id=${d.id }" id="edit${d.id }" class="layui-btn layui-btn-mini">修改</a>
		</c:if>
		<a href="javascript:del(${d.id });" class="layui-btn layui-btn-mini">删除</a>
		<a href="admin/username.jsp?id=${d.id }" class="layui-btn layui-btn-mini">修改帐号</a>
		<a href="admin/password.jsp?id=${d.id }" class="layui-btn layui-btn-mini">修改密码</a>
	</td>
        	</tr>
</c:forEach>
     </table>
     <div id="pagedata"></div>
     <input type="hidden" value="${data.count }" id="datacount">
     <input type="hidden" value="${param.page }" id="page">
     <script type="text/javascript">
	function del(id) {
		if(confirm("您确定要删除这条信息吗？")) {
			$.get("admin/del.jmy", {id:id}, function (data) {
			$(".table_tr"+id).remove();
			alert(data)});
		}
	}
	function check(id) {
		if(confirm("您确定要通过审核这条信息吗？")) {
			$.get("admin/check.jmy", {id:id}, function (data) {
			$("#status"+id).text("审核通过");
			$("#check"+id).remove();
			$("#uncheck"+id).remove();
			$("#edit"+id).remove();
			$("#ext"+id).after('<a href="javascript:uncheck('+id+');" id="uncheck'+id+'" class="layui-btn layui-btn-mini">审核拒绝</a>');
			alert(data)});
		}
	}
	function uncheck(id) {
		if(confirm("您确定要审核拒绝这条信息吗？")) {
			$.get("admin/uncheck.jmy", {id:id}, function (data) {
			$("#status"+id).text("审核拒绝");
			$("#check"+id).remove();
			$("#uncheck"+id).remove();
			$("#edit"+id).remove();
			$("#ext"+id).after('<a href="javascript:check('+id+');" id="check'+id+'" class="layui-btn layui-btn-mini">审核通过</a>'
			     +'<a href="admin/info.jmy?o=x&id=${d.id }" id="edit'+id+'" class="layui-btn layui-btn-mini">修改</a>');
			alert(data)});
		}
	}
 </script>
     <script>
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  laypage({
    cont: 'pagedata'
    ,pages: document.getElementById("datacount").value //总页数
    ,groups: 5 //连续显示分页数
    ,skin: '#1E9FFF'
    ,curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	    var page = location.search.match(/page=(\d+)/);
	    return page ? page[1] : 1;
	 }() 
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第 '+ obj.curr +' 页');
        location.href="admin/list.jmy?page=" +obj.curr 
        + "&name=" + $("#name").val() + "&username=" + $("#username").val() + "&phone=" + $("#phone").val() 
        + "&email=" + $("#email").val() + "&address=" + $("#address").val() + "&status=" + $("#status").val();
      }
    }
    ,skip: true
  });
  
});
layui.use('form', function(){
  var form = layui.form(); //只有执行了这一步，部分表单元素才会修饰成功
  
  //……
});      
</script>
  <%@ include file="../common/tail.jsp" %>