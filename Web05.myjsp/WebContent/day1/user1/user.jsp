<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user1.User, user1.UserDAO, java.util.Date"%>


<%-- <%@ page import="user.User, user.UserDAO" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<!-- 	1. 요청했던 회원정보를 읽고 -->
<!-- 	2.  UserDAO.userDB 결과 리턴
<!--	3.  응답 결과 출력 -->
	
	<% 
	//request 선언과정생략됨
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	User user= new User(id, pw, name, email, phone);
	UserDAO dao = new UserDAO();
	String result= dao.useDB(user);
	//out 선언과정생략됨
	out.println("<h3>"+ result +"</h3>");
	%>
<%-- 	<h3><%= result %></h3> --%>
<%-- 	<%= new java.util.Date().toLocaleString()%> --%>
	
	
</body>
</html>


