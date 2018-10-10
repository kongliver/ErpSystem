<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>家具erp后台管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style>
    	.input-text{
    		position: relative;
    		right: -200px;
    		top: -20px;
    		resize: none;
    	}
    </style>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>家具erp后台管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="${path }/billList.jsp">订单管理</a></li>
                <li><a href="${path }/providerList.jsp">供应商管理</a></li>
                <li><a href="${path }/purchaseList.jsp">采购单管理</a></li>
                <li><a href="${path }/productList.jsp">库存管理</a></li>
                <li><a href="${path }/change_stockList.jsp">库存异动</a></li>
                <li><a href="${path }/CustomerSupportServlet?action=getPageBean&currentPage=1">售后记录</a></li>
                <li><a href="${path }/customerList.jsp">客户管理</a></li>
                <li><a href="${path }/userList.jsp">用户管理</a></li>
                <li><a href="${path }/password.jsp">密码修改</a></li>
                <li><a href="${path }/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>售后管理 >> 信息查看</span>
        </div>
        <div class="providerView" style="position:relative">
        
            <p><strong>售后编号：</strong><span>${cusSupMap.csId }</span></p>
            <p><strong>订单号：</strong><span>${cusSupMap.orderNum }</span></p>
            <p><strong>商品名称：</strong><span>${cusSupMap.goodsName }</span></p>
            <p><strong>商品数量：</strong><span>${cusSupMap.goodsCount }</span></p>
            <p><strong>订货公司：</strong><span>${cusSupMap.cusCompany }</span></p>
            <p><strong>问题描述：</strong><br /><span>
            	<textarea readonly="readonly" style="height:80px;width:800px" class="input-text">${cusSupMap.problem }</textarea>
            </span>				
           	</p>
            <p><strong>处理人：</strong><span>${cusSupMap.handler }</span></p>
            <p><strong>处理时间：</strong><span>${cusSupMap.handlerTime }</span></p>
			 
			<a onclick="history.back(-1)" >返回</a>

        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>
