<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="Bean.UserHomeBean" scope="request" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>

 <style>
   @media (min-width: 700px) {
      #parent {
        display: flex;
      }
      #child1 {
        flex-grow: 0.25;
      }
      #child2 {
        flex-grow: 1;
      }
 </style>
 
<link rel="stylesheet" href="css/TitleHaikei.css">
<link rel="stylesheet" href="css/Common.css">
 
</head>
<body>
	<h1>　ホーム画面</h1>
	<strong>ログインユーザー名:<%=bean.getUserName()%></strong><br>
	<div id="parent">
	
    <div id="child1">
    <br><br><br><br><form method="POST" action="userListServlet">
		<input type="submit" value="　逸品リストを見る　"style="margin-left:70px">
	</form>
    <br>
	<form method="POST" action="UserAddFoodServlet">
		<input type="submit" value="　　　逸品追加　　　"style="margin-left:70px">
	</form>
    <br>
	<button onclick="location.href='./recom.jsp'"style="margin-left:70px">　　おすすめ追加　　</button></div>
	
	
    <div id="child2">
    <br><br><br><br><form method="POST" action="IppinServlet">
		<font size="5"><b><label for="TimeZone">　　　食べる時間</label></b></font>
		<select name="TimeZone">
			<option value="未選択">未選択　</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ">おやつ</option>
		</select><br> 
		<font size="5"><b><label for="Amount">　　　量　　　　</label></b></font> 
		<select name="Amount">
			<option value="未選択">未選択</option>
			<option value="ちょい">ちょい</option>
			<option value="まぁまぁ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br> 
		<font size="5"><b><label for="CookTime">　　　手間　　　</label></b></font> 
		<select name="CookTime">
			<option value="未選択">未選択</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br><br>
		<input type="submit" value="　　IPPIN　　"style="margin-left:70px"> <br>
	</form></div>
  </div>
	<br>
	
</body>
</html>