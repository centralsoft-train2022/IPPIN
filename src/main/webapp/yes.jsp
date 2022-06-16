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
<%=bean.getMsg() %><br>

<img src="サル.jfif" alt="サル" title="拍手するサル"><br>
<button onclick="location.href='./userHome.jsp'">ホームに戻る</button>
</body>
</html>