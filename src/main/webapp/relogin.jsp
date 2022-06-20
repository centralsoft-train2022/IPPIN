<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red" size="5"> 
		<b>正しい情報を入力してください。</b>
	</font>
	<form method="POST" action="LoginServlet">
		ログインしてください。<br> 
		ID<input name="ID" type="text"><br>
		PW<input name="PW" type="text"> <br> 
		<input type="submit" value="ユーザーログイン">
	</form>

</body>
</html>