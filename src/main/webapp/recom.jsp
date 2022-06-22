<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.RecomBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
おすすめリスト画面<br>
<%=bean.getMsg() %><br>

<a href="FoodDetailServlet?foodID=1"><img src="image/takenoko.jpg" ></a>
<a href="FoodDetailServlet?foodID=2"><img src="image/kinoko.jpg" ></a>

<form  method="POST" action="UserHomeServlet">
<input type="submit" value="戻る" name = "NAME">
</form>
<form  method="GET" action="SearchServlet">
<input type="submit" value="検索" name = "NAME">
</form>

</body>
</html>