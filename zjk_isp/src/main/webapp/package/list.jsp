<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
 <title>接口套餐列表</title>
 <a href="package/iadd.jmy" class="layui-btn">添加接口套餐</a>
  <table width="100%" class="layui-table" lay-even="" lay-skin="row">
         <tr>
             <th>序号</th>
             <th>套餐名称</th>
             <th>价格</th>
             <th>操作</th>
         </tr>
<c:forEach items="${data.rows }" var="d" varStatus="s">
<tr class="table_tr${d.id }">
	<td>${s.index+1 }</td>
	<td>${d.name }</td>
	<td>${d.money }</td>
	<td>
		<a href="package/info.jmy?o=c&id=${d.id }" class="layui-btn layui-btn-mini">查看</a>
		<a href="package/info.jmy?o=x&id=${d.id }" class="layui-btn layui-btn-mini">修改</a>
		<a href="javascript:del(${d.id });" class="layui-btn layui-btn-mini">删除</a>
	</td>
        	</tr>
</c:forEach>
     </table>
     <div id="pagedata"></div>
     <input type="hidden" value="${data.count }" id="datacount">
     <input type="hidden" value="${param.page }" id="page">
     <script type="text/javascript" src="common/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
	function del(id) {
		if(confirm("您确定要删除这条信息吗？")) {
			$.get("package/del.jmy", {id:id}, function (data) {
			$(".table_tr"+id).remove();
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
        location.href="package/list.jmy?page=" +obj.curr;
      }
    }
    ,skip: true
  });
  
});
</script>
  <%@ include file="../common/tail.jsp" %>