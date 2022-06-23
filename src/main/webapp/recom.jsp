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


<button onclick="location.href='./userHome.jsp'">ホームに戻る</button>
<button onclick="location.href='./search.jsp'">検索</button>
</body>
</html>