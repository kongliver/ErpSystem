<%@page import="com.erpsystem.domain.ProductStock"%>
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
    <link rel="stylesheet" href="${path }/css/public.css"/>
    <link rel="stylesheet" href="${path }/css/style.css"/>
    <link rel="stylesheet" href="${path }/css/pageStyle.css"/>
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
                <span>库存管理页面</span>
            </div>
            <div class="search">
                <form id="productQuery" action="${path }/ProductStockServlet?action=getPageBean&currentPage=1" method="post" style="display: inline-block;">
                    <span>物品编号：</span>
	                <input type="text" name="psid" id="psid" placeholder="请输入物品的编号" value="${psid }"/>
	                
	                <span>物品类别：</span>
	                <select name="productType" id="productType">
	                   <option value="">--请选择 --</option>
	                   <option value="1">原材料</option>
	                   <option value="2">成品</option>
	                </select>                
	                <input type="button" value="查询" onclick="productQuery()"/>
                </form>
                
                <a href="productUpdateCount.jsp" style="margin: 10px 25px">成品入库</a>
                <a href="productAdd.jsp" style="margin: 10px 25px">新增库存品</a>
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
             
                <c:forEach items="${pageBean.list }" var="productStock" varStatus="status">
                    <tr>
	                    <td>${productStock.psid }</td>
	                    <td>${productStock.productName }</td>
	                    <td>${productStock.productCount }</td>
	                    <td>
	                       <c:if test="${productStock.productType == 1 }">原材料</c:if>
	                       <c:if test="${productStock.productType == 2 }">成品</c:if>
	                    </td>
	                    <td>${productStock.repertoryNum }</td>
	                    <td>
	                        <a href="${path }/ProductStockServlet?action=getById&psid=${productStock.psid }"><img src="${path }/img/xiugai.png" alt="修改" title="修改"/></a>
	                        <a href='${path }/ProductStockServlet?action=delete&psid=${productStock.psid }' onclick="return confirm('是否确认删除？')" class="removeBill"><img src="${path }/img/schu.png" alt="删除" title="删除"/></a>
	                    </td>	
	                    
	                    <!--点击删除按钮后弹出的页面-->
				       <!-- <div class="zhezhao"></div> -->
				       <%-- <div class="remove" id="removeBi">
				           <div class="removerChid">
				               <h2>提示</h2>
				               <div class="removeMain">
				                   <p>你确定要删除该库存品吗？</p>
				                   <a href="${path }/ProductStockServlet?action=delete&psid=${psid }" id="yes">确定</a>
				                   <a href="#" id="no">取消</a>
				               </div>
				           </div>
				       </div> --%>                    
	                </tr>
	                
			     </c:forEach>
            </table>
        </div>
        
    </section>
    
        

    
    <footer class="footer">
	    <!--分页-->
	    <div id="page" class="page_div">aaa</div>
    </footer>

<script src="${path }/js/jquery.js"></script>
<script type="text/javascript" src="${path }/js/paging.js"></script>
<script src="${path }/js/js.js"></script>
<script src="${path }/js/time.js"></script>
<script type="text/javascript">

function productQuery() {
	$("#productQuery").submit();
}

$("#productType option[value=${productType }]").prop("selected", true);

var psid = $("#psid").val();
var productType = $("#productType").val()

$("#page").paging({
    pageNo: ${pageBean.currentPage },
    totalPage: ${pageBean.totalPage },
    totalSize: ${pageBean.totalCount },
    callback: function(num) {
        $(window).attr('location', '${path }/ProductStockServlet?action=getPageBean&currentPage=' + num + '&psid=' + psid + '&productType=' + productType);
    }
});
</script>

</body>
</html>