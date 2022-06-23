<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.FoodDetailBean2" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
食べ物詳細<br>
ログインユーザー名:<%=bean.getUserName()%><br>
 <br>
 逸品名：<%=bean.getIppin()%><br>
 <br>
 時間：<%=bean.getTimezone()%><br>
 <br>
 量：<%=bean.getAmount()%><br>
 <br>
 手間：<%=bean.getCookTime()%><br>
 <br>
 写真<br>
 <% if( bean.getFileName() == null){ %>
 画像が登録されていません<br>
 <% }%><% else{ %>
 <img src=<%=bean.getFileName()%> ><br>
 <% }%>
 
<form  method="POST" action="UserHomeServlet">
<input type="submit" value="ホームに戻る">
</form>

</body>
</html>