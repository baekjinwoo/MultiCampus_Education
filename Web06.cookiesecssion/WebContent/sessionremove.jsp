<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.removeAttribute("sessionid");
	session.removeAttribute("sessionpw");
	//session.invalidate(); 전체삭제
	%>
	<jsp:forward page="/sessionform.html" /> 
	<!--  request.setAttribute("",)와 같이 공유  -->
</body>
</html>