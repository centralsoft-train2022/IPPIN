<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.YesBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ログインユーザー名:<%=bean.getUserName() %><br>
<%=bean.getMsg() %><br>

<img src="image/OK猿.png" alt="サル" title="拍手するサル"><br>

<form  method="POST" action="UserHomeServlet">
<input type="submit" value="ホームに戻る">
</form>

</body>
</html>