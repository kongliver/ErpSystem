<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
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
            <strong>你现在所在的位置是:</strong>
            <span>采购管理页面 >> 采购单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billId">物品编号：</label>
                    <input type="text" name="billId" id="billId" required/>
                    <span>*请输入物品编号</span>
                </div>
                <div>
                    <label for="billName">采购数量：</label>
                    <input type="text" name="billName" id="billName" required/>
                    <span >*请输入采购数量</span>
                </div>
                <div>
                    <label for="billCom">材料单价：</label>
                    <input type="text" name="billCom" id="billCom" required/>
                    <span>*请输入材料单价</span>

                </div>
                <div>
                    <label for="billNum">采购人员：</label>
                    <input type="text" name="billNum" id="billNum" required/>
                    <span>*请输入采购人员</span>
                </div>
                <div>
                    <label for="money">供应商编号：</label>
                    <input type="text" name="money" id="money" required/>
                    <span>*请输入供应商编号</span>
                </div>
               
                <!--<div>
                    <label >是否付款：</label>
                    <input type="radio" name="zhifu"checked />未付款
                    <input type="radio" name="zhifu"/>已付款
                </div>-->
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="history.back(-1)"/>
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
