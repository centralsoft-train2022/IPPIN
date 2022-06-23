<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.RecomBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Common.css">
<link rel="stylesheet" href="css/Recom.css">
</head>
<body>
<h1>おすすめリスト画面</h1>
<%= bean.getMsg()%>
<br>
<div class="flex-container">
  
<%for(int i = 0;(i < bean.getList().size())&&(i < 6); i++) {%>
<div class="flex-item">
<div class="image-wrap">
<a href="FoodDetailServlet?foodID=<%= bean.getList().get(i).getFoodID() %>">

<img src="image/<%= bean.getList().get(i).getPhotoFileName()%>"></a>
</div>
</div>
<%} %>
 
</div>

<form  method="POST" action="UserHomeServlet">
<input type="submit" value="戻る" name = "NAME">
</form>
<form  method="GET" action="SearchServlet">
<input type="submit" value="検索" name = "NAME">
</form>

</body>
</html>