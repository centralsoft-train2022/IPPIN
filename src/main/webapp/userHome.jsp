<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="Bean.UserHomeBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ホーム画面
	<br> ログイン社員名:<%=bean.getUserName()%><br>


	<form method="POST" action="IppinServlet">
		<input type="submit" value="IPPIN"> <br>
		<label for="TimeZone">食べる時間</label>
		<select name="TimeZone">
			<option value="未選択">未選択</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ">おやつ</option>
		</select><br> 
		<label for="Amount">量　　　　</label> <select name="Amount">
			<option value="未選択">未選択</option>
			<option value="ちょい">ちょい</option>
			<option value="まぁまぁ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br> 
		<label for="CookTime">手間　　　</label> <select name="CookTime">
			<option value="未選択">未選択</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br>
	</form>

	<button onclick="location.href='./userList.jsp'">逸品一覧表示</button>

	<form method="POST" action="UserAddFoodServlet">
		<input type="submit" value="逸品追加">
	</form>

	<button onclick="location.href='RecomServlet'">おすすめ追加</button>
</body>
</html>