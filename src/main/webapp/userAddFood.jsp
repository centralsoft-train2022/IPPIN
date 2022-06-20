<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.UserAddFoodBean" scope="request" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
逸品追加画面 ログインユーザー名：<%=bean.getUserName() %>
	<form  method="POST" action="UserAddFoodServlet">
	
		<input type="hidden" name="from1" value="myJsp">
	
	
		<label for="IppinName">逸品名</label>
		<input name="IppinName" type="text" ><br>
		
		
		
		
		
		<label for="TimeZone">食べる時間</label>
		<select name="TimeZone">
			<option value="">選択してください</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ"> おやつ</option>
		</select><br>
		
		<label for="Amount">量</label>
		<select name="Amount">
			<option value="">選択してください</option>
			<option value="ちょい">ちょい</option>
			<option value="まあまあ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br>
		
		<label for="CookTime">手間</label>
		<select name="CookTime">
			<option value="">選択してください</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br>
		
		<label for="PhotoFileName">写真</label>
	
		<input type="file" name ="PhotoFileName"><br>
		<input type="submit" value="逸品追加">
	</form>

<button onclick="location.href='./userHome.jsp'">戻る</button>
</body>
</body>
</html>