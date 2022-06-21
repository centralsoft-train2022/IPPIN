<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="Bean.SearchBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchServlent</title>

</head>
<body>
<div style="padding: 10px; margin-bottom: 10px; border: 5px double #333333;">
<div style="text-align:center;">
  <span><font size="7">検索</font></span>
</div>
</div>
 
<form action="SearchServlet" method="get">
<input type = "hidden" name = "from jsp" value="search.jsp">

  <span><font size="5"><label for="TimeZone"><br>
  　　　　　　　　　　　　　　食べる時間</label></font></span>
		<select name="TimeZone">
		
			<option value="未選択">選択してください</option>
			<option value="朝">朝</option>
			<option value="昼">昼</option>
			<option value="夜">夜</option>
			<option value="おやつ"> おやつ</option>
		</select><br>
		
<span><font size="5"><label for="Amount">　　　　　　　　　　　　　　　　　　量</label></font></span>
		<select name="Amount">
			<option value="未選択">選択してください</option>
			<option value="ちょい">ちょい</option>
			<option value="まあまあ">まあまあ</option>
			<option value="がっつり">がっつり</option>
		</select><br>
		
<span><font size="5"><label for="CookTime">　　　　　　　　　　　　　　　　　手間</label></font></span>
		<select name="CookTime">
			<option value="未選択">選択してください</option>
			<option value="楽ちん">楽ちん</option>
			<option value="そこそこ">そこそこ</option>
			<option value="割と手間">割と手間</option>
		</select><br>
		
<button onclick="location.href='./recom.jsp'">オススメ画面に戻る</button>
<input type="submit" value="検索" onclick="SearchServlet"/><br />
</form>

<table  border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
<tr>
	<th>
		食品名
	</th>

</tr>


<% for( Dao.FoodVo emp: bean.getFoodList()){ %>
<tr>
	<td>
   		<a href="FoodDetailServlet?id=<%=emp.getFoodid() %>"><%=emp.getFoodName() %></a> <br>
   	<br>
	</td>
</tr>

<% }%>
</table>




</body>
</html>