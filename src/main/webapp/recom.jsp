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
<button onclick="location.href='./userHome.jsp'">ホームに戻る</button>
<button onclick="location.href='./search.jsp'">検索</button>
</body>
</html>