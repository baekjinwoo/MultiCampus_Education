<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
입력 아이디 : ${param.id }<br>
입력 암호 : ${param.pw.substring(0,2) }****
<% member.MemberDAO dao = new member.MemberDAO();
   boolean flag = dao.getMember(request.getParameter("id"), request.getParameter("pw"));
   if(flag == true){
	   session.setAttribute("sessionid", request.getParameter("id"));
   }
%>
<br>
<a href="boardwrite.jsp"> 글쓰기 이동 </a>
</body>
</html>