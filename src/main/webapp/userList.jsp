<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.userListBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
逸品一覧表示<br> 
ログイン社員名:<%=bean.getUserName()%><br>

<%=bean.getMsg() %><br>
逸品リスト:<br>
<table  border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
<tr>
	<th>
		逸品名
	</th>
</tr>

<%for( Dao.FoodVo name: bean.getIppinList()){%>
<tr>
	<td>
   	<a href= './foodDetail2.jsp' ><%=name.getFoodName() %></a><br>
</tr>

<% }%>
</table>

<input type="text" onclick="location.href='foodDetail2.jsp'" value="追加しようとしてる食べ物">

<button onclick="location.href='./userHome.jsp'">戻る</button>
<button onclick="location.href='./userAdd.jsp'">逸品追加</button>
</body>
</html>