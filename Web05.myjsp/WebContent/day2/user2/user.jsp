<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user2.UserDAO2, user2.User2"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<% 
	//User2 user2= new User2();
	//User2 user2= (User2)application.getAttribute("user2"); //변수명 user2를 가져와라
	Object user2= application.getAttribute("user2"); //변수명 user2를 가져와라

 	UserDAO2 dao2 = new UserDAO2();
	//String result= dao2.useDB2(user2);
	String result= dao2.useDB2((User2) user2);
	out.println(result);
	%>
	
<%-- 	<h3><%= result %></h3> --%>
<%-- 	<%= new java.util.Date().toLocaleString()%> --%>
		
	
	
</body>
</html>


