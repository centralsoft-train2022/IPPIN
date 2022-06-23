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
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(0).getFoodID() %>"><img src="image/<%= bean.getList().get(0).getPhotoFileName()%>"></a>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(1).getFoodID() %>"><img src="image/<%= bean.getList().get(1).getPhotoFileName()%>"></a>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(2).getFoodID() %>"><img src="image/<%= bean.getList().get(2).getPhotoFileName()%>"></a>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(3).getFoodID() %>"><img src="image/<%= bean.getList().get(3).getPhotoFileName()%>"></a>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(4).getFoodID() %>"><img src="image/<%= bean.getList().get(4).getPhotoFileName()%>"></a>
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(5).getFoodID() %>"><img src="image/<%= bean.getList().get(5).getPhotoFileName()%>"></a>



</body>
</html>