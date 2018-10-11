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
                <li id="active"><a href="${pageContext.request.contextPath }/OrderServlet?method=list">订单管理</a></li>
                <li><a href="providerList.jsp">供应商管理</a></li>
                <li><a href="purchaseList.jsp">采购单管理</a></li>
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
            <span>采购管理页面 >> 采购单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="<%=request.getContextPath() %>/PurchaseOrder?method=AddNote" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
             <!--    <div class="">
               
                    <label for="billId">采购单编号：</label>
                    <input type="text" name="cid" id="billId" required/>
                    <span>*请输入采购单编号</span>
                </div> -->
                <div>
                    <label for="billName">物品编号：</label>
                    <input type="text" name="psid" id="billName" />
                    <span >*请输入物品编号</span>
                </div>
                <div>
                    <label for="billName">采购数量：</label>
                    <input type="text" name="purchaseCount" id="billName" />
                    <span >*请输入采购数量</span>
                </div>
                
                     <div>
                    <label for="billCom">材料单价：</label>
                    <input type="text" name="purTotalMoney" id="billCom" />
                    <span>*请输入材料单价</span>

                </div>
             <!--    <div>
                    <label for="billCom">采购时间：</label>
                    <input type="text" name="times"  id="billCom" />
                    <span>*采购时间</span>

                </div> -->
                
                <div>
                    <label for="billNum">采购人员：</label>
                    <input type="text" name="buyer" id="billNum" />
                    <span>*请输入采购人员</span>
                </div>
                <div>
                    <label for="money">供应商编号：</label>
                    <input type="text" name="sid" id="money" />
                    <span>*请输入供应商编号</span>
                </div>
             
                <div class="providerAddBtn">
                    <input type="submit" style="width:70px; height:40px"  value="保存" />
                    <input type="reset" style="width:70px; height:40px" value="返回" />
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
