<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="Bean.FoodDetailBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
食べ物詳細<br>
 <br>
 逸品名：<%=bean.getFoodName()%><br>
 <br>
 説明：<%=bean.getExplanation()%><br>
 <br>
 量：<%=bean.getAmount()%><br>
 <br>
 手間：<%=bean.getCookTime()%><br>
 <br>
 <img src="image/<%=bean.getPhotoFileName()%>" >
 <br>
<button onclick="location.href='./recom.jsp'">戻る</button>
<button onclick="location.href='./userList.jsp'">逸品追加</button>

</body>
</html>
