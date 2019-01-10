<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user3.UserDAO3, user3.User3"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<% 
	User3 user3= (User3)request.getAttribute("user3"); 
 	UserDAO3 dao3 = new UserDAO3();
	String result= dao3.useDB3(user3);
	out.println(result);
	%>
	<%--<%=result %> 이렇게 출력해도된다.--%>
</body>
</html>


