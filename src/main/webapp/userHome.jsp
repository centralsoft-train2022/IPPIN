<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ホーム画面
<button onclick="location.href='./ippin.jsp'">IPPIN</button>
<button onclick="location.href='./userList.jsp'">逸品一覧表示</button>
<form  method="POST" action="UserAddFoodServlet">
	    <input type="submit" value="逸品追加">
</form>
	
<button onclick="location.href='./recom.jsp'">おすすめ追加</button>
</body>
</html>