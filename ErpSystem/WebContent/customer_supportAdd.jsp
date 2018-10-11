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
    <title>鑫源丰erp后台管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style>
    	.input-text{
    		resize: none;
    	}
    </style>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>鑫源丰erp后台管理系统</h1>

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
                <li id="active"><a href="${pageContext.request.contextPath }/OrderServlet?method=list">订单管理</a></li>
                <li><a href="${pageContext.request.contextPath }/SupplierServlet?method=getPageBean&currentPage=1">供应商管理</a></li>
                <li><a href="<%=request.getContextPath() %>/PurchaseOrder?method=QueryAllStock">采购单管理</a></li>
                <li><a href="${path }/ProductStockServlet?action=getPageBean&currentPage=1">库存管理</a></li>
                <li><a href="${path }/ChangeStockListServlet?action=getPageBean&currentPage=1">库存异动</a></li>
                <li><a href="${path }/CustomerSupportServlet?action=getPageBean&currentPage=1">售后记录</a></li>
                <li><a href="${pageContext.request.contextPath }/CustomerServlet?method=list">客户管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>售后记录管理页面 >> 售后添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${path }/CustomerSupportServlet?action=save" id="actionForm" method="post">
                <input name="orderNum" type="hidden" value="${orderNum }" />
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="problem">问题描述：</label>
                    <textarea name="problem" id="problem" style="height:100px;width:800px" class="input-text" placeholder="请输入不超过180个字" maxlength="180"></textarea>
                    <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span id="text-count"></span>
                </div>
                <div><br/>
                    <label for="handler">处理人：</label>
                    <input type="text" name="handler" id="handler" required/>
                    <span id="handlerInfo"></span>
                </div>
                
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="validate();"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
<script src="jquery.js" type="text/javascript" charset="utf-8"></script>
<script>
function validate(){
	var handler = document.getElementById("handler").value;
	var text = document.getElementById("problem").value;
	var isPass = true;
	if(handler == ''){
		document.getElementById("handlerInfo").innerText="*请输入处理人";
		isPass = false;
	}
	if(text == ''){
		document.getElementById("text-count").innerText="*请输入问题描述";
		isPass = false;
	}
	if(isPass){
		//window.location.href="frame.html";
		document.getElementById("actionForm").submit();
	}else{
		return false;
	}
}

</script>

</body>
</html>
