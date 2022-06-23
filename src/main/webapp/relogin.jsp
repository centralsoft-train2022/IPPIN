<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/TitleHaikei.css">
</head>
<body>
	
	<form method="POST" action="LoginServlet">
	<br>
	<font color="red" size="7"> 
	<b>　正しい情報を入力してください。</b></font><br><br>
	<font size="5.5"><b>　　　ID<input name="ID"type="text"style="margin-left:10px"></b></font><br>
	<font size="5"><b>　　　PW<input name="PW"type="text"></b></font><br><br>
		<input type="submit"value="ユーザーログイン"style="margin-left:70px">
	</form>

</body>
</html>
