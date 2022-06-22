<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.IppinBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ログインユーザー名:<%=bean.getUserName() %><br>

<form  method="POST" action="FoodDetailServlet2">
<input type="submit" value=<%=bean.getIppin() %> name = "NAME">
</form>

<form  method="POST" action="YesServlet">
<input type="submit" value="YES">
</form>

<form  method="POST" action="NoServlet">
<input type="submit" value="NO">
</form>

</body>
</html>