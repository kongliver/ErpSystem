<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>家具erp后台管理系统</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>家具erp后台管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！
		</p>
		<a href="login.jsp">退出</a>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2015年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<nav>
		<ul class="list">
			<li id="active"><a href="billList.jsp">订单管理</a></li>
			<li><a href="providerList.jsp">供应商管理</a></li>
			<li><a href="purchaseList.jsp">采购单管理</a></li>
			<li><a href="productList.jsp">库存管理</a></li>
			<li><a href="change_stockList.jsp">库存异动</a></li>
			<li><a href="customer_supportList.jsp">售后记录</a></li>
			<li><a href="customerList.jsp">客户管理</a></li>
			<li><a href="userList.jsp">用户管理</a></li>
			<li><a href="password.jsp">密码修改</a></li>
			<li><a href="login.jsp">退出系统</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>订单管理页面</span>
		</div>



		<form action="${pageContext.request.contextPath}/OrderServlet?method=list"  id="submit" method="post">
			<div class="search">
				<span>客户名称：</span> <input type="text" name="cname" value="${cname }"/> 
				
				<span>订单编号：</span>
				<input type="text" name="orderNum" value="${orderNum }"/> 
				
				<span>订单状态：</span> 
				<select
					name="orderType">  
					<option value="">--请选择--</option>
					<option value="1" <c:if test="${orderType==1}">selected</c:if> >刚提交</option>
					<option value="2" <c:if test="${orderType==2}">selected</c:if> >已完成入库</option>
					<option value="3" <c:if test="${orderType==3}">selected</c:if> >已完成出库</option>
					<option value="4" <c:if test="${orderType==4}">selected</c:if> >有问题的订单</option>
				</select> 
				<input type="button" value="查询"  onclick="submitBtnClick()"/> 
				
				<a href="${pageContext.request.contextPath}/orderAdd.jsp">添加订单</a>
			</div>
			<!--账单表格 样式和供应商公用-->
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tr class="firstTr">
					<th width="8%">订单编号</th>
					<th width="8%">商品名称</th>
					<th width="8%">商品数量</th>
					<th width="8%">商品单价</th>
					<th width="8%">下单时间</th>
					<th width="8%">交货时间</th>
					<th width="8%">订单状态</th>
					<th width="8%">客户名称</th>
					<th width="20%">操作</th>
				</tr>

				<c:forEach items="${pageBean.list }" var="order"
					varStatus="status">

					<tr>
						<td>${order.orderNum }</td>
						<td>${order.goodsName }</td>
						<td>${order.goodsCount }</td>
						<td>${order.goodsPrice }</td>
						<td>${order.beginTime }</td>
						<td>${order.endTime }</td>
						<td>${order.orderType }</td>
						<td>${order.cId }</td>
						
						<td><a href="billView.jsp"><img src="img/read.png"
								alt="查看" title="查看" /></a> 

						</td>





					</tr>
				</c:forEach>





			</table>
	</div>
	</form>

	</section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeBi">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该订单吗？</p>
				<a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
			</div>
		</div>
	</div>

	<footer class="footer"> </footer>

	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>
</html>