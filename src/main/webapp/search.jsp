<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="Bean.SearchBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchServlent</title>
 <script src="Web/SearchServlet.java"></script>
</head>
<body>
<div style="padding: 10px; margin-bottom: 10px; border: 5px double #333333;">
<div style="text-align:center;">
  <span><font size="7">検索</font></span>
</div>
</div>
 

  <span><font size="5"><label for="TimeZone"><br>
  　　　　　　　　　　　　　　食べる時間</label></font></span>
		<select name="TimeZone">
		
			<option value="">選択してください</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ"> おやつ</option>
		</select><br>
		
<span><font size="5"><label for="Amount">　　　　　　　　　　　　　　　　　　量</label></font></span>
		<select name="Amount">
			<option value="">選択してください</option>
			<option value="ちょい">ちょい</option>
			<option value="まあまあ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br>
		
<span><font size="5"><label for="CookTime">　　　　　　　　　　　　　　　　　手間</label></font></span>
		<select name="CookTime">
			<option value="">選択してください</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br>
		
<button onclick="location.href='./recom.jsp'">オススメ画面に戻る</button>
<input type="button" value="検索" onclick="OnButtonClick();"/><br />
</body>
</html>