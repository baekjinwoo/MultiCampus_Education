<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat"%>
   
<!--  Date와 SimpleDateFormat를 import한다 --> 
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 공통적으로 사용 </title>
</head>

<body>
<%= "오늘의 날씨정보는 맑음입니다" %>
<%
	//Date now= new Date();
	//SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss");
	
	//변수명없이
	//String result = new SimpleDateFormat("HH : mm : ss").
	//format(new Date());
%>

<%="지금은"+new SimpleDateFormat("HH : mm : ss").format(new Date())+"입니다" %>

<%-- <%=share%> --%>


<!-- 현재호출파일명 리턴 -->
<%=request.getRequestURI() %>
<!-- request.getParameter() 메서드--> 
<!-- request.getRemoteAddr() 메서드--> 

</body>
</html>