<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.YesBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/UserAddFood.css">
<link rel="stylesheet" href="css/Common.css">
<link rel="stylesheet" href="css/Yes.css">
</head>
<body>
<h1>　逸品確定画面</h1>
<b>ログインユーザー名:<%=bean.getUserName() %></b><br>
<font size="7"><b>　　　　　　＼決まってよかったね！！／</b></font><br>
  
<img src="image/OK猿.png"> <img src="image/OK猿.png"> <img src="image/OK猿.png"> <img src="image/OK猿.png"> <img src="image/OK猿.png">
<form  method="POST" action="UserHomeServlet">
<input type="submit" value="ホームに戻る">
</form>

</body>
</html>