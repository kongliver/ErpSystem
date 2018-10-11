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
    <script>
    	function dell(pid){
    		if(confirm("确定删除?")){
    			location.href="${pageContext.request.contextPath}/PurchaseOrder?method=DeleteNote&pid="+pid;
    		}
    		
    	}
    	
    	function upde(pid){
    		if(confirm("确定修改?")){
    			location.href="${pageContext.request.contextPath}/PurchaseOrder?method=UpdateNoteID&pid="+pid;
    		}
    	}
    	
    
    </script>
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
                <span>采购单管理页面</span>
            </div>
            <div class="search" style="float:left">
            <form style="display: inline-block;" action="<%=request.getContextPath() %>/PurchaseOrder?method=QueryStock" method="post">
                <span>库存物品编号：</span>
                <input type="text"  placeholder="请输入库存物品的编号" name="KuCun"/>
                
                <span>采购单编号：</span>
                <input type="text" placeholder="请输入采购单的编号" name="purchaseOrder"/>

                <input type="submit" style="width:75px;height:35px"  value="查询"/>
               
              </form>  
            </div>
            
            <div class="search" style="float:left ">
            <form style="display: inline-block;" action="<%=request.getContextPath() %>/PurchaseOrder?method=QueryAllStock" method="post">
          
                <input type="submit" style=" width:140px"  value="查询所有订单"/>
                
                 <a href="purchaseAdd.jsp">添加采购单</a>
              </form>  
            </div>
            
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">采购单编号</th>
                    <th width="10%">物品编号</th>
                    <th width="10%">采购数量</th>
                    <th width="10%">材料单价</th>
                    <th width="10%">采购时间</th>
                    <th width="10%">采购人员</th>
                    <th width="10%">供应商编号</th>
                    
                    <th width="30%">操作</th>
                </tr>
                
                <c:if test="${not empty note }">
						<td>1</td>
                   <%--  <td>${note.pnid }</td> --%>
                    <td>${note.psid }</td>
                    <td>${note.purchaseCount }</td>
                    <td>${note.purTotalMoney }</td>
                    <td>${note.purchaseTime }</td>
                    <td>${note.buyer }</td>
                    <td>${note.sid }</td>
                    
                    <td>
                       <!--  <a href="purchaseView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a> -->
                        <a href="javascript:;" onclick="upde('${note.pnid }')" ><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="javascript:;" onclick="dell('${note.pnid }')" ><img src="img/schu.png"   alt="删除" title="删除"/></a>
               <%--   <a href="${pageContext.request.contextPath}/PurchaseOrder?method=DeleteNote&pid=${note.pnid }"><img src="img/schu.png" alt="删除" title="删除"/></a>  --%>
                    </td>
        	</c:if>
        	 
                <c:if test="${not empty list }">
                	<c:forEach items="${list }" var="note" varStatus="num">
                	
                	 <tr>
                	<%-- <td>${note.pnid }</td> --%>
                	
                	  <td>${num.index + 1 }</td>
                	
                    <td>${note.psid }</td>
                    <td>${note.purchaseCount }</td>
                    <td>${note.purTotalMoney }</td>
                    <td>${note.purchaseTime }</td>
                    <td>${note.buyer }</td>
                    <td>${note.sid }</td>
          
                    <td>
                       <!--  <a href="purchaseView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a> -->
                        <a href="javascript:;" onclick="upde('${note.pnid }')" ><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                      <!--   <a href="#" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a> -->
                       <%-- <a href="${pageContext.request.contextPath}/PurchaseOrder?method=DeleteNote&pid=${note.pnid }"><img src="img/schu.png" alt="删除" title="删除"/></a>
                  --%>
                  <a href="javascript:;" onclick="dell('${note.pnid }')" ><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                	</c:forEach>
                </c:if>
            </table>
        </div>
    </section>



<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>