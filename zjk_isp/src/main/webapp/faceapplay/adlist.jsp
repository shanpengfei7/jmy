<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
 <title>套餐申请列表</title>
 <input type="hidden" id="user" value="${user }">
 <input type="hidden" id="tao" value="${tao }">
 <input type="hidden" id="status" value="${status }">
 <form class="layui-form" action="faceapplay/adlist.jmy" method="post">

  <div class="layui-form-item">
    <div class="layui-input-block">
    
     <label class="layui-form-label">申请人</label>
      <div class="layui-input-inline">
        <input name="user" value="${user }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      
       <label class="layui-form-label">套餐名称</label>
      <div class="layui-input-inline">
        <input name="tao" value="${tao }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
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
      </div>
      
    </div>
  </div>
 </form>
  <table width="100%" class="layui-table" lay-even="" lay-skin="row">
         <tr>
             <th>序号</th>
             <th>申请人</th>
             <th>套餐名称</th>
             <th>几年</th>
             <th>价格</th>
             <th>状态</th>
             <th>操作</th>
         </tr>
<c:forEach items="${data.rows }" var="d" varStatus="s">
<tr class="table_tr${d.id }">
	<td>${s.index+1 }</td>
	<td>${d.user }</td>
	<td>${d.tao }</td>
	<td>${d.years }</td>
	<td>${d.money }</td>
	<c:if test="${d.status==null }"><td>未审核</td></c:if>
	<c:if test="${d.status==0 }"><td>未审核</td></c:if>
	<c:if test="${d.status==1 }"><td>审核通过</td></c:if>
	<c:if test="${d.status==2 }"><td>审核拒绝</td></c:if>
	<td>
		<a href="faceapplay/adshow.jmy?id=${d.id }&o=c" class="layui-btn layui-btn-mini">查看</a>
		<c:if test="${d.status!=1 }">
		<a href="faceapplay/adshow.jmy?id=${d.id }&o=x" id="edit${d.id }" class="layui-btn layui-btn-mini">修改</a>
		</c:if>
		<c:if test="${d.status!=1 }">
		<a href="javascript:agree(${d.id });" id="agree${d.id }" class="layui-btn layui-btn-mini">审核通过</a>
		</c:if>
		<c:if test="${d.status!=2 }">
		<a href="javascript:reject(${d.id });" id="reject${d.id }" class="layui-btn layui-btn-mini">审核拒绝</a>
		</c:if>
	</td>
        	</tr>
</c:forEach>
     </table>
     <div id="pagedata"></div>
     <input type="hidden" value="${data.count }" id="datacount">
     <input type="hidden" value="${param.page }" id="page">
     <script type="text/javascript" src="common/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
	function agree(id) {
		if(confirm("您确定通过审核吗？")) {
			$.get("faceapplay/check.jmy", {id:id}, function (data) {
			$("#edit"+id).remove();
			$("#agree"+id).remove();
			alert(data)});
		}
	}
	function reject(id) {
		if(confirm("您确定要拒绝审核吗？")) {
			$.get("faceapplay/uncheck.jmy", {id:id}, function (data) {
			$("#reject"+id).remove();
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
        location.href="faceapplay/adlist.jmy?page=" +obj.curr
        + "&user=" + $("#user").val() + "&tao=" + $("#tao").val() + "&status=" + $("#status").val();
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