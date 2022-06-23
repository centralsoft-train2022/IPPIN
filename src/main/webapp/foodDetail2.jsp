<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.FoodDetailBean2" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Common.css">
<link rel="stylesheet" href="css/FoodDetail2.css">
</head>
<body>
<h1>食べ物詳細画面</h1>
<strong>ログインユーザー名:<%=bean.getUserName()%></strong>
<br>
<table class="tableArea" id="makeImg">
 <tr>
  <th>逸品名</th><td><%=bean.getIppin()%></td>
 </tr>
 <tr>
  <th>食べる時間</th><td><%=bean.getTimezone()%></td>
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
 <% if( bean.getFileName() == null){ %>
 画像が登録されていません
 <% }%><% else{ %>
 <img src=<%="image/" + bean.getFileName()%> >
 <% }%>
  </td>
 </tr>
</table>
<br>
<form  method="POST" action="UserHomeServlet">
<input type="submit" value="ホームに戻る">
</form>


</body>
</html>