<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <span>供应商管理页面</span>
        </div>
        
         <form action="${pageContext.request.contextPath }/SupplierServlet?method=list" method="post" id="query">
        <div class="search">
            <span>供应商名称：</span>
            <input type="text"  name="sname"/>
            <input type="button" value="查询" onclick="submitBtnClick()" />
            <input type="button" value="新增供应商"  onclick="window.location='providerAdd.jsp'"/>
            
        </div>
        
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="15%">供应商编码</th>
                <th width="20%">公司名称</th>
                <th width="15%">联系人</th>
                <th width="15%">联系电话</th>
                <th width="15%">公司地址</th>
                
                <th width="30%">操作</th>
            </tr>
           
            <c:forEach items="${supplierList }" var="supplier" varStatus="status">
            <tr>
            
	            <td  height="23"><span class="STYLE1">${status.index+1 }</span>
	            </td>
	            <%-- <td><span class="STYLE1"><a href="SupplierServlet?method=list&sid=${supplier.sId }">${supplier.sId }</a>
				</span>
				</td> --%>
				<td><span class="STYLE1">${supplier.supCompany }</span>
				</td>
				<td><span class="STYLE1">${supplier.supContacts }</span>
				</td>
				<td><span class="STYLE1">${supplier.supPhone }</span>
				</td>
				<td><span class="STYLE1">${supplier.supAddress }</span>
				</td>
				
            
            
               <!--  <td>PRO-CODE—001</td>
                <td>测试供应商001</td>
                <td>韩露</td>
                <td>15918230478</td>
                <td>四川成都</td> -->
               
                <td>
                    <a href="providerView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a>
                    <a href="${pageContext.request.contextPath}/SupplierServlet?method=edit&sid=${supplier.sId }"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a class="removeBill" href="${pageContext.request.contextPath}/SupplierServlet?method=delete&sid=${supplier.sId }"
                 onclick="return confirm('是否确认删除？')" value="${supplier.sId }">
                 <img src="img/schu.png" alt="删除" title="删除"/></a>
                </td>
                
                <!--点击删除按钮后弹出的页面-->
                
                
					<%-- <div class="zhezhao"></div>
					<div class="remove" id="removeProv">
					   <div class="removerChid">
					       <h2>提示</h2>
					       <div class="removeMain" >
					           <p>你确定要删除该供应商吗？</p>
					           <a href="${pageContext.request.contextPath}/SupplierServlet?method=delete&sid=1" id="yes">确定</a>
					           <a href="#" id="no">取消</a>
					       </div>
					   </div>
					</div> --%>
                
            </tr>
            </c:forEach>
        </table>
	</form>
    </div>
</section>




<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>