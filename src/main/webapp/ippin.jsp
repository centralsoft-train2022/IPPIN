<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.IppinBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Common.css">
<link rel="stylesheet" href="css/Ippin.css">
</head>
<body>
<h1>&emsp;逸品表示画面</h1> 
<strong>ログインユーザー名:<%=bean.getUserName() %></strong><br><br>

<span class="strInterval">【今日の<span class="str">逸品</span>】</span>

<form  method="POST" action="FoodDetailServlet2" style="display: inline">
<input type="submit" value=<%=bean.getIppin() %>  name = "NAME" class="button">
</form>

<br>
気に入った？？<br>

<form  method="POST" action="YesServlet" >
<input type="submit"  value="YES">
</form>

<form  method="POST" action="NoServlet" >
<input type="submit"  value="NO">
</form>

</body>
</html>