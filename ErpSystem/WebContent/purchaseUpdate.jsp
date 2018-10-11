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
 
   <!--  <script>
    	function upde(pid){
    		if(confirm("确定保存?")){
    			location.href="${pageContext.request.contextPath}/PurchaseOrder?method=UpdateNote";
    		}
    	}
    </script> -->
    
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
            <span>采购管理页面 >> 采购单修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/PurchaseOrder?method=UpdateNote" method="post">
            
      
                <!--div的class 为error是验证错误，ok是验证成功-->
 
               <div >
                    <label for="providerName">采购单编号：</label>
                    <input type="text" value="${note.pnid }" readonly="readonly"  name="pnid"/>
                    <span ></span>
                </div>  
                
                <div>
                    <label for="providerName">物品编号：</label>
                    <input type="text"  value="${note.psid }" name="psid"/>
                    <span >*</span>
                </div>
                
                <div>
                    <label for="providerName">采购数量：</label>
                    <input type="text" value="${note.purchaseCount }" name="purchaseCount"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">材料单价：</label>
                    <input type="text"  value="${note.purTotalMoney }" name="purTotalMoney"/>
                    <span>*</span>

                </div>
              <%--   <div>
                    <label for="phone">采购时间：</label>
                    <input type="text"  value="${note.purchaseTime }" name="purchaseTime"/>
                    <span>*</span>
                </div> --%>
                <div>
                    <label for="address">采购人员：</label>
                    <input type="text" value="${note.buyer }" name="buyer"/>
                    <span>*</span>
                </div>
                
                <div>
                    <label for="fax">供应商编号：</label>
                    <input type="text" value="${note.sid }" name="sid"/>
                    <span>*</span>
           	   </div>
                
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="submit" value="保存" style="width:80px;height:40px;"/>
                    <input type="reset" value="返回" style="width:80px;height:40px;"/>
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