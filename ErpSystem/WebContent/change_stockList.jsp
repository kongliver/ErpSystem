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
                <span>库存异动管理页面</span>
            </div>
            <div class="search">
                <form id="query" action="${path }/ChangeStockListServlet?action=getPageBean&currentPage=1" method="post">
                    <span>操作状态：</span>
                    <select name="oprType" id="oprType">
                        <option value="">--请选择--</option>
                        <option value="1">入库</option>
                        <option value="2">出库</option>
                    </select>                
	                <<%-- input type="text" placeholder="请输入操作状态" id="oprType" name="oprType" value="${oprType }"/> --%>
	                <span>操作时间：</span>
	                <input type="date" placeholder="请输入操作时间" id="oprTime" name="oprTime" value="${oprTime }"/>
	                <span>库存品编号：</span>
	                <input type="text" placeholder="请输入库存品编号" id="psid" name="psid" value="${psid }"/>
	                <input type="button" value="查询" onclick="query()" />
                </form>
                
            </div>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="14%">异动编号</th>
                    <th width="14%">物品编号</th>
                    <th width="14%">改变数量</th>
                    <th width="14%">操作状态</th>
                    <th width="14%">操作时间</th>
                    <th width="14%">操作人</th>
                </tr>
                <c:forEach items="${pageBean.list }" var="changeStockList" varStatus="status">
                    <tr>
	                    <td>${(pageBean.currentPage - 1) * pageBean.currentCount + status.index + 1 }</td>
	                    <td>${changeStockList.psid }</td>
	                    <td>${changeStockList.changeCount }</td>
	                    <td>
	                       <c:if test="${changeStockList.oprType == 1 }">入库</c:if>
	                       <c:if test="${changeStockList.oprType == 2 }">出库</c:if>
	                    </td>
	                    <td>${changeStockList.oprTime }</td>
	                    <td>${changeStockList.oprPerson }</td>
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
function query() {
	/* var oprType = $("#oprType").val();
	var oprTime = $("#oprTime").val();
	var psid = $("#psid").val();
	$(window).attr('location', '${path }/ChangeStockListServlet?action=getPageBean&currentPage=1&oprType=' + oprType + '&oprTime=' + oprTime + '&psid=' + psid); */
	$("#query").submit();
}

$("#oprType option[value=${oprType }]").prop("selected", true);

var oprType = $("#oprType").val();
var oprTime = $("#oprTime").val();
var psid = $("#psid").val();

$("#page").paging({
    pageNo: ${pageBean.currentPage },
    totalPage: ${pageBean.totalPage },
    totalSize: ${pageBean.totalCount },
    callback: function(num) {
        $(window).attr('location', '${path }/ChangeStockListServlet?action=getPageBean&currentPage=' + num + '&oprType=' + oprType + '&oprTime=' + oprTime + '&psid=' + psid);
    }
});
</script>

</body>
</html>
