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
<br>
<%for(int i = 0;(i < bean.getList().size())&&(i < 6); i++) {%>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(i).getFoodID() %>"><img src="image/<%= bean.getList().get(i).getPhotoFileName()%>"></a>
<%} %>

<form  method="POST" action="UserHomeServlet">
<input type="submit" value="戻る" name = "NAME">
</form>
<form  method="GET" action="SearchServlet">
<input type="submit" value="検索" name = "NAME">
</form>

</body>
</html>