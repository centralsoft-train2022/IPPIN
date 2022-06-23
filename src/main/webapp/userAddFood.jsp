<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.UserAddFoodBean" scope="request" />
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/Common.css">
	<link rel="stylesheet" href="css/UserAddFood.css">

</head>

<body>
	<h1>&emsp;逸品追加画面</h1>
	<strong>ログインユーザー名：<%=bean.getUserName() %></strong>
 	<div style="text-align: center">
	
	<form  method="POST" action="UserAddFoodServlet">
	
		<input type="hidden" name="from1" value="myJsp">
	
	<br><label for="IppinName" style="margin-right:30px" >
	<strong>逸品名</strong>&emsp;&emsp;&emsp;</label>
	<input name="IppinName" type="text" ><br>
		

	<br><label for="TimeZone" style="margin-right:40px"><strong>食べる時間</strong>&emsp;&emsp;&emsp;</label>
		<select name="TimeZone">
			<option value="">選択してください</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ"> おやつ</option>
		</select><br>
		
	<br><label for="Amount" style="margin-right:150px"><strong>量</strong></label>
		<select name="Amount">
			<option value="">選択してください</option>
			<option value="ちょい">ちょい</option>
			<option value="まぁまぁ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br>
		
	<br><label for="CookTime" style="margin-right:140px"><strong>手間</strong></label>
		<select name="CookTime">
			<option value="">選択してください</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br>
		
		<br><label for="PhotoFileName" style="margin-left:25px"><strong>写真</strong></label>
	
		<input type="file" name ="PhotoFileName" style="margin-left:40px"><br><br><br>
		<br><input type="submit" value="逸品追加" style="margin-right:240px">
	</form>
<br>
<form  method="POST" action="UserHomeServlet">
<input type="submit" value="戻る">
</form>
</div>
</body>
</body>
</html>