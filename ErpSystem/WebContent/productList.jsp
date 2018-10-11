<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <span>库存管理页面</span>
            </div>
            <div class="search">
                <span>物品编号：</span>
                <input type="text" placeholder="请输入物品的编号"/>
                
                <span>物品类别：</span>
                <input type="text" placeholder="请输入物品的类别"/>

                

                <input type="button" value="查询"/>
                <a href="productAdd.jsp">新增库存</a>
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">物品编号</th>
                    <th width="10%">物品名称</th>
                    
                    <th width="10%">物品数量</th>
                    <th width="10%">物品类别</th>
                    <th width="10%">仓库编号</th>
                    
                    <th width="30%">操作</th>
                </tr>
                <tr>
                    <td>213</td>
                    <td>乌木茶几</td>
                    <td>1</td>
                    <td>木料</td>
                    <td>1000</td>
                    
                    <td>
                        
                        <a href="productUpdate.jsp"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                
            </table>
        </div>
        
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>