<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>>
    <script type="text/javascript">
    	$(function(){
    		alert("订单物品已出库，或者库存不足，请补充库存再出库！");
    		window.location="OrderServlet?method=list"; 
    	});
    
    </script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>