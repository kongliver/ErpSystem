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
    <link rel="stylesheet" href="${path }/css/public.css"/>
    <link rel="stylesheet" href="${path }/css/style.css"/>
    <link rel="stylesheet" href="${path }/css/pageStyle.css"/>
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
                <span>售后记录页面</span>
            </div>
           	
            <div class="search">
                <span>订单编号：</span>
                <input id="orderNum" value="${orderNum }" name="orderNum" type="text" placeholder="请输入订单的编号"/>
                
                <span>商品名称：</span>
                <input id="goodsName" value="${goodsName }" name="goodsName" type="text" placeholder="请输入商品的名称"/>

                <span>客户公司名称：</span>
                <input id="cusCompany" value="${cusCompany }" name="cusCompany" type="text" placeholder="请输入公司的名称"/>

                <input type="button" value="查询" onclick="fuzzyQuery()"/>
                
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="13%">编号</th>
                    <th width="13%">订单号</th>
                    <th width="13%">问题描述</th>
                    <th width="13%">处理人</th>
                    <th width="13%">处理时间</th>
                    
                    <th width="25%">操作</th>
                </tr>
                <c:forEach items="${pageBean.list }" var="CustomerSupport" varStatus="status">
                <tr>
                    <td>${status.index+1 }</td>
                    <td>${CustomerSupport.orderNum }</td>
                    <td style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;width:350px;padding-top:12px;display:block;">${CustomerSupport.problem }</td>
                    <td>${CustomerSupport.handler }</td>
                    <td>${CustomerSupport.handlerTime }</td>
                    <td>
                        <a href="CustomerSupportServlet?action=getOne&csId=${CustomerSupport.csId }"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a class="removeBill" href="${path }/CustomerSupportServlet?action=deleteOne&csId=${CustomerSupport.csId }" onclick="return confirm('是否确认删除？')" value="${CustomerSupport.csId }"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>

                </c:forEach>
            </table>
        </div>
        <input type="hidden" value/>
    </section>

<footer class="footer">
	<!--分页-->
	<div id="page" class="page_div">aaa</div>
</footer>

<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script type="text/javascript">
	function deleteCusSup(){
		var orderNum = $("#orderNum").val();
	}

	function fuzzyQuery(){
		var orderNum = $("#orderNum").val();
		var goodsName = $("#goodsName").val();
		var cusCompany = $("#cusCompany").val();
		window.location="CustomerSupportServlet?action=getPageBean&currentPage=1&orderNum="+orderNum+"&goodsName="+goodsName+"&cusCompany="+cusCompany;
	}
	
	var orderNum = $("#orderNum").val();
	var goodsName = $("#goodsName").val();
	var cusCompany = $("#cusCompany").val();
	
	$("#page").paging({
	    pageNo: ${pageBean.currentPage},
	    totalPage: ${pageBean.totalPage },
	    totalSize: ${pageBean.totalCount },
	    callback: function(num) {
	        $(window).attr('location', '${path }/CustomerSupportServlet?action=getPageBean&currentPage='+num+"&orderNum="+orderNum+"&goodsName="+goodsName+"&cusCompany="+cusCompany);
	    }
	});

</script>

</body>
</html>