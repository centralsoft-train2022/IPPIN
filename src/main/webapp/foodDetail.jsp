<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.FoodDetailBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Common.css">
<link rel="stylesheet" href="css/FoodDetail2.css">
</head>
<body>
<h1>食べ物詳細</h1>
<strong>ログインユーザー名:<%=bean.getUserName()%></strong>
 <br>
<table class="tableArea" id="makeImg">
 <tr>
  <th>逸品名</th><td><%=bean.getFoodName()%></td>
 </tr>
 <tr>
  <th>食べる時間</th><td><%=bean.getTimeZone()%></td>
 </tr>
 <tr>
  <th>量</th><td><%=bean.getAmount()%></td>
 </tr>
 <tr>
  <th>手間</th><td><%=bean.getCookTime()%></td>
 </tr>
 <tr>
  <th>写真</th>
  <td>
 <% if( bean.getPhotoFileName() == null){ %>
 画像が登録されていません
 <% }%><% else{ %>

 <img src=<%="image/" + bean.getPhotoFileName()%>  width="400" height="400" >

 <% }%>
  </td>
 </tr>
</table>
 <br>
<INPUT type="button" value="戻る" onClick="history.back()">
<form method="POST" action="userListServlet?foodID=<%=bean.getFoodID() %>">
	<input type="hidden" name="from1" value="myJsp">
	<input type="submit" value="　逸品リストに追加　">
</form>

</body>
</html>
