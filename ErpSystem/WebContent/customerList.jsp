<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>家具erp后台管理系统</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="${path }/css/pageStyle.css"/>
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
			<li id="active"><a
				href="${pageContext.request.contextPath }/OrderServlet?method=list">订单管理</a></li>
			<li><a href="providerList.jsp">供应商管理</a></li>
			<li><a href="purchaseList.jsp">采购单管理</a></li>
			<li><a
				href="${path }/ProductStockServlet?action=getPageBean&currentPage=1">库存管理</a></li>
			<li><a
				href="${path }/ChangeStockListServlet?action=getPageBean&currentPage=1">库存异动</a></li>
			<li><a
				href="${path }/CustomerSupportServlet?action=getPageBean&currentPage=1">售后记录</a></li>
			<li><a
				href="${pageContext.request.contextPath }/CustomerServlet?method=list">客户管理</a></li>
			<li><a href="userList.jsp">用户管理</a></li>
			<li><a href="password.jsp">密码修改</a></li>
			<li><a href="login.jsp">退出系统</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>客户管理页面</span>
		</div>

			<div class="search">  

					<span>公司名：</span> 
					<input type="text" name="name"  value="${name }" id="name"/>  
					<span>联系电话：</span> 
					<input type="text"  name="phone" value="${phone }" id="phone1"/> 
					 
				<input type="button" value="查询" onclick="submitQuery()" />  
				
				<input type="button" value="新增客户" onclick="save()" /> 
			</div>
			<!--账单表格 样式和供应商公用-->
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tr class="firstTr">
					<th width="13%">客户编号</th>
					<th width="13%">公司名称</th>
					<th width="13%">联系人</th>
					<th width="13%">电话</th>
					<th width="13%">公司地址</th>
					<th width="30%">操作</th>
				</tr>

				<c:forEach items="${pageBean.list }" var="customer"
					varStatus="status">
					<tr>

						<td>${status.index + 1 }</td>
						<td>${customer.cusCompany }</td>
						<td>${customer.cusContacts }</td>
						<td>${customer.cusPhone }</td>
						<td>${customer.cusAddress }</td>
						<td> <a
							href="${pageContext.request.contextPath}/CustomerServlet?method=edit&cid=${customer.cid}"><img
								src="img/xiugai.png" alt="修改" title="修改" /></a> <a
							href="${pageContext.request.contextPath}/CustomerServlet?method=delete&cid=${customer.cid}"><img
								src="img/schu.png" alt="删除" title="删除" /></a></td>

					</tr>
				</c:forEach>
			</table>
	</div>
</section> 

	<footer class="footer"> 
		<!--分页--> 
		<div id="page" class="page_div">aaa</div> 
	</footer> 
	
<script src="js/jquery.js"></script> 
<script src="js/js.js"></script> 
<script src="js/time.js"></script> 
<script type="text/javascript" src="js/paging.js"></script>

<script type="text/javascript">

 
function submitQuery(){ 
	var name = $("#name").val(); 
	var phone = $("#phone1").val(); 
	
	window.location="${pageContext.request.contextPath }/CustomerServlet?method=list&name=" + name +"&phone=" + phone;
// 	window.location='CustomerServlet?method=list&uname=' + uname + "&phone=" + phone; 
}

var name = $("#name").val(); 
var phone = $("#phone1").val(); 

$("#page").paging({

    pageNo: ${pageBean.currentPage },
    totalPage: ${pageBean.totalPage },
    totalSize: ${pageBean.totalCount },
    callback: function(num) {
    	 $(window).attr('location', '${path }/CustomerServlet?method=list&currentPage=' + num + "&name=" + name + "&phone=" + phone); 

    }
});

</script>
</body>
</html>