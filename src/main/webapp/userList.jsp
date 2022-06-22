<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="Bean.userListBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/UserList.css">

<body>

逸品一覧表示<br> 
ログインユーザー名:<%=bean.getUserName()%><br>

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
   
   	<form  method="POST" action="FoodDetailServlet2">
   	
	<input type="submit" value=<%=name.getFoodName() %> name = "NAME" class="button">
	</form><br>
</tr>

<% }%>
</table>

<form  method="POST" action="UserHomeServlet">
<input type="submit" value="戻る">
</form>

<form  method="POST" action="UserAddFoodServlet">
<input type="submit" value="逸品追加">
</form>

</body>
</html>