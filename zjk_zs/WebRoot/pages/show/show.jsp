<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>溯源信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="wilih=device-wilih, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	
	<link rel="stylesheet" href="css/show.css">
  </head>
  
  <body>
   <div class="header"><img src="images/logo.png" class="logo"></div>
<div class="wrap_wap">
	<div class="item_box">${error }
		<div class="item_tit"><div class="item_tita item_tita01"><h2>&nbsp;</h2><h3>商品基本信息</h3></div></div>
		<div class="item_con">
			<!-- <p style="text-align:center;"><img src="images/img1.jpg"></p> -->
			<p><strong>商品名称：</strong>${product.tradename }</p>
			<p><strong>型号：</strong>${product.version }</p>
			<p><strong>生产厂家：</strong>${qrcode.enterprise.company }</p>
			<p><strong>生 产 地：</strong>${qrcode.enterprise.address }</p>
			<c:if test="${!empty packageinformations }">
			<c:forEach items="${packageinformations }" var="p">
				<p>内容物： ${qrcode.son.product.tradename }</p>
				<p>数量： ${qrcode.soncount }</p>
				<br/>
			</c:forEach>
			</c:if>
			<p><strong>扫码次数：</strong>${qrcode.scannumber }</p>
			<c:if test="${!empty qrcode.price }">
				<p><strong>单价：</strong>${qrcode.price }</p>
			</c:if>
			<%-- <p><strong>生产工艺：</strong>${product.information }</p> --%>
			<c:if test="${!empty qrcode.qrcodeproperties }">
				<c:forEach items="${qrcode.qrcodeproperties }" var="p">
						<p><strong>${p.name }：</strong>${p.value }</P>
				</c:forEach>
			</c:if>
			<%-- <p><strong>公司：</strong>${enterprise.company }</p>
			<p><strong>公司简介：</strong></p>
			<p style="text-align:center;"><img src="images/img2.jpg"></p>
			<p>${qrcode.enterprise.information }</p> --%>
		</div>
	</div>
	
	<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita01"><h2>&nbsp;</h2><h3>厂家信息</h3></div></div>
		<div class="item_con">
			<%-- <p style="text-align:center;"><img src="images/img1.jpg"></p>
			<p><strong>商品名称：</strong>${product.name }</p>
			<p><strong>产品型号：</strong>${product.version }</p>
			<p><strong>生产厂家：</strong>${qrcode.enterprise.company }</p>
			<p><strong>生 产 地：</strong>${qrcode.enterprise.address }</p>
			<p><strong>生产工艺：</strong>${product.information }</p>
			<c:if test="${!empty qrcode.qrcodeproperties }">
				<c:forEach items="${qrcode.qrcodeproperties }" var="p">
						<p><strong>${p.name }：</strong>${p.value }</P>
				</c:forEach>
			</c:if> --%>
			<p><strong>公司：</strong><a href="javascript:void(0);" onclick="show('enterprise_info')">${qrcode.enterprise.company }</a></p>
			<!--<p><strong>公司简介：</strong></p> -->
			<!-- <p style="text-align:center;"><img src="images/img2.jpg"></p> -->
			<p><dt id="enterprise_info" style="display: none;">公司简介：${qrcode.enterprise.information }</dt></p>
		</div>
	</div>
	<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita02"><h2>&nbsp;</h2><h3>生产信息</h3></div></div>
		<div class="item_con">
			<!-- <p style="text-align:center;"><img src="images/img3.jpg"></p> -->
			<!-- <p>包装：2016-10-14 09:01:47</p>  -->
			<c:if test="${!empty packageinformations }">
			<c:forEach items="${packageinformations }" var="p">
				<p>包装操作人： ${p.employee.name }</p>
				<p>包装时间： <date:date value ="${p.time }"/></p>
				<p>包装地点： ${p.place }</p>
				<br/>
			</c:forEach>
			</c:if>
			<c:if test="${!empty product.information }">
				<p>产品信息：<a href="javascript:void(0);" onclick="show('product_info')">展开</a></p>
				<p><dt id="product_info" style="display: none;">${product.information }</dt></p>
			</c:if>
			<!-- <p>检验：2016-10-14 09:30:50</p>
			<p>操作人：检验部  郝子健</p>
			<p>出厂：2016-10-14 10:14:16</p>
			<p>操作人：车间   沈腾</p> -->
		</div>
	</div>
	
	<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita03"><h2>&nbsp;</h2><h3>流通信息</h3></div></div>
		<div class="item_con">
				<c:if test="${empty circulates }">
					该产品在厂家库存中！！！
				</c:if>
			<dl>
				<c:if test="${!empty circulates }">
					<dt>出厂：${qrcode.enterprise.company }</dt>
				</c:if> 
				<c:forEach items="${circulates }" var="c" varStatus="s">
						<dd>出库：  时间:<date:date value ="${c.delivertime}"/><br>
						发货人:${c.deliveremployee.name }<br>
						发货地点:${c.deliverplace }</dd>
					<c:if test="${!empty c.receiveenterprise.company }">
						<dt>流通信息：<a href="javascript:void(0);" onclick="show('enterprise_info${s.index }')">${c.receiveenterprise.company }</a></dt>
						<dt id="enterprise_info${s.index }" style="display: none;">企业信息：${c.receiveenterprise.information }</dt>
					</c:if>
						<dd>
						<c:if test="${!empty c.receivetime }">
							入库： 时间:<date:date value ="${c.receivetime}"/><br>
						</c:if>
						<c:if test="${!empty c.receiveemployee.name }">
							收货人:${c.receiveemployee.name }<br>
						</c:if>
						<c:if test="${!empty c.receiveplace }">
							收货地点:${c.receiveplace }
						</c:if>
						</dd>
						<br>
				</c:forEach>
			</dl>
				
		</div>
	</div>
		<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita03"><h2>&nbsp;</h2><h3>售出信息</h3></div></div>
		<div class="item_con">
			<c:if test="${empty sellinformation }">	
				产品未销售！！！
			</c:if>
			<c:if test="${!empty sellinformation }">
				<dl>
					<dt>售出企业：${sellinformation.enterprise.company }</dt> 
					<dt>售出员工：${sellinformation.employee.name }</dt> 
					<dt>售出日期：<date:date value ="${sellinformation.time }"/></dt> 
					<dt>销售地点：${sellinformation.place }</dt> 
				</dl>
			</c:if>	
		</div>
	</div>
	<c:if test="${qrcode.issell==1 }">
	<c:if test="${qrcode.isevaluate==0 }">
		<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita04"><h2>&nbsp;</h2><h3>用户评价</h3></div></div>
		<div class="item_con">
			<form action="evaluate.php" method="post">
			 <input type="hidden" name="productid" value="${product.id }" />
			 <input type="hidden" name="qrcodeid" value="${qrcode.id }" />
			 <input type="hidden" name="token" value="${qrcode.qrcode }" />
			  <table width="100%" border="0" cellspacing="10">
                  <tr>
                    <td>评价：</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>产品确是真货：</td>
                    <td align="left">
                    	<input type="radio" name="evaluate1" value="是">是
                    	<input type="radio" name="evaluate1" value="否">否
                    </td>
                  </tr>
                  <tr>
                    <td>服务态度很好：</td>
                    <td align="left">
                    	<input type="radio" name="evaluate2" value="是">是
                    	<input type="radio" name="evaluate2" value="否">否
                    </td>
                  </tr>
                  <tr>
                    <td>产品物有所值：</td>
                    <td align="left">
                    	<input type="radio" name="evaluate3" value="是">是
                    	<input type="radio" name="evaluate3" value="否">否
                    </td>
                  </tr>
                  <tr>
                    <td>对产品很满意：</td>
                    <td align="left">
                    	<input type="radio" name="evaluate4" value="是">是
                    	<input type="radio" name="evaluate4" value="否">否
                    </td>
                  </tr>
                  <tr>
				  	<td>您的联系方式（手机号）：</td>
                    <td align="left">
                    	<input type="text" name="phonenumber">
						<!-- <textarea cols="30"></textarea> -->
					</td>
                  </tr>
				  <tr>
                    <td colspan="2">
						<input type="submit" class="in_but" value="提&nbsp;&nbsp;&nbsp;&nbsp;交">
					</td>
                  </tr>
                </table>
			</form>			
		</div>
	</div>
	</c:if>
	</c:if>
	<div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita01"><h2>&nbsp;</h2><h3>历史评价信息</h3></div></div>
		<div class="item_con">
		<c:if test="${evaluates.size() == 0 }">
			暂时没人做评价！！！
		</c:if>
		<c:if test="${evaluates.size() != 0 }">
			评价条数：${evaluates.size() }<br />
			产品确是真货条数：${evaluate1Count },占百分比：<fmt:formatNumber type="number" value="${(evaluate1Count/evaluates.size())*100 }" pattern="0.00" maxFractionDigits="2" />%<br />
			服务态度很好条数：${evaluate2Count },占百分比：<fmt:formatNumber type="number" value="${(evaluate2Count/evaluates.size())*100 }" pattern="0.00" maxFractionDigits="2" />%<br />
			产品物有所值条数：${evaluate3Count },占百分比：<fmt:formatNumber type="number" value="${(evaluate3Count/evaluates.size())*100 }" pattern="0.00" maxFractionDigits="2" />%<br />
			对产品很满意条数：${evaluate4Count },占百分比：<fmt:formatNumber type="number" value="${(evaluate4Count/evaluates.size())*100 }" pattern="0.00" maxFractionDigits="2" />%<br />
		</c:if>
		<c:forEach items="${evaluates }" var="e" varStatus="s">
		<hr/>
			<table width="100%" border="0" cellspacing="10">
                  <tr>
                    <td>评价${s.index+1 }：</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>产品确是真货：</td>
                    <td align="left">
                    	<c:if test="${!empty e.evaluate1 }">${e.evaluate1 }</c:if>
                    	<c:if test="${empty e.evaluate1 }">暂无评价</c:if>
                    </td>
                  </tr>
                  <tr>
                    <td>服务态度很好：</td>
                    <td align="left">
                    	<c:if test="${!empty e.evaluate2 }">${e.evaluate2 }</c:if>
                    	<c:if test="${empty e.evaluate2 }">暂无评价</c:if>
                    </td>
                  </tr>
                  <tr>
                    <td>产品物有所值：</td>
                    <td align="left">
                    	<c:if test="${!empty e.evaluate3 }">${e.evaluate3 }</c:if>
                    	<c:if test="${empty e.evaluate3 }">暂无评价</c:if>
                    </td>
                  </tr>
                  <tr>
                    <td>对产品很满意：</td>
                    <td align="left">
                    	<c:if test="${!empty e.evaluate4 }">${e.evaluate4 }</c:if>
                    	<c:if test="${empty e.evaluate4 }">暂无评价</c:if>
                    </td>
                  </tr>
                  <tr>
				  	<td>您的联系方式（手机号）：</td>
                    <td align="left">
                    	<c:if test="${!empty e.phonenumber }">${e.phonenumber }</c:if>
                    	<c:if test="${empty e.phonenumber }">暂无联系方式</c:if>
					</td>
                  </tr>
                </table>
                <hr/>
		</c:forEach>
		</div>
	</div>
	<!-- <div class="item_box">
		<div class="item_tit"><div class="item_tita item_tita05"><h2>&nbsp;</h2><h3>其他信息</h3></div></div>
		<div class="item_con">
			<p><b>充电宝使用注意什么？</b></p> 
			<p>充电宝虽然现在很火，但是还有很多人不知道这个产品，当第一次听销售人员介绍充电宝 这个东东时，很多人都会说多配一块电池不就解决了问题吗? 于是销售人员一般都会说充 电宝储电容量比手机电池要大等等诸多优点。可能是先入为主的缘故，很多人在选充电宝时，第一反应就是看容量有多大，目前市场上的充电宝是由电芯、驱动电路板、外壳、 线材几部分组成，每个厂家的电路设计和使用的材料都会不同，在性能上也会有很大的不同，因此在购买充电宝时，除了要关注容量外，其它方面也需要关注一下一、输出、输入参数：能只看容量，还须 多注意一下各个方面。</p>
		
		</div>
	</div> -->
	
	

</div>
	<div class="footer">技术支持：张家口金蚂蚁科技</div>
</div>

<script type="text/javascript">
	function show(id) {
		var i = document.getElementById(id);
		if (i.style.display == "none") {    
		   i.style.display = "";    
		}
		else{    
		   i.style.display = "none";    
		}     
	}

</script>

  </body>
</html>
