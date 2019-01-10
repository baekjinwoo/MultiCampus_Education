<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> getsession 조회 </title>
<script src='jquery-3.2.1.min.js'></script>
<script>
	$(document).ready(function(){
		$('#logout').on("click",function(){
				location.href="sessionremove.jsp"; //내장객체를 통해 이동
		});
	});
</script>
</head>
<body>
<h1>
<!-- 버튼이나 링크를 통해 이동하지않고 자동으로 이동하게하려면  jsp:foward 를 쓰면된다 -->
	<%
	if(session.getAttribute("sessionid")!=null && session.getAttribute("sessionpw")!=null){
	%>
	로그인 아이디(세션):
	<%=((String)session.getAttribute("sessionid")).toUpperCase() %><br>

	로그인 암호(세션):
	<%= session.getAttribute("sessionpw") %><br>
</h1>
	<a href="sessionremove.jsp">로그아웃하러 가기</a> 
	<input type=button value=로그아웃 id=logout>
	
	<% 
	}
	else{
	%>
	<jsp:forward page="sessionform.html"/>
	
	<% } %>
	
</body>
</html>