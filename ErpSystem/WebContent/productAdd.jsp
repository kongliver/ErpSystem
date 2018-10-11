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
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>鑫源丰erp后台管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.USER.nickName}</span> , 欢迎你！</p>
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
                <li><a href="userAction?action=query">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>库存管理页面 >> 库存添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${path }/ProductStockServlet?action=save" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billId">物品名称：</label>
                    <input type="text" name="productName" id="billId" required/>
                    <span>
                        <c:if test="${empty error }">*请输入物品名称</c:if>
                        <c:if test="${!empty error }">${error }</c:if>
                    </span>
                </div>
                
                <div>
                    <label for="billCom">物品数量：</label>
                    <input type="text" name="productCount" id="billCom" required/>
                    <span>*请输入物品数量</span>
                </div>
                <div>
                    <label>物品类别：</label>
                    <!-- <input type="text" name="productType" id="billNum" required/>
                    <span>*请输入物品类别</span> -->
                    <select name="productType">
                        <option value="" selected="selected">-- 请选择 --</option>
                        <option value="1">原材料</option>
                        <option value="2">成品</option>
                    </select>
                </div>
                <div>
                    <label for="money">仓库编号：</label>
                    <input type="text" name="repertoryNum" id="money" required/>
                    <span>*请输入仓库编号</span>
                </div>             
                <div class="providerAddBtn">
                    <input type="submit" value="保存" style="padding: 0px" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>