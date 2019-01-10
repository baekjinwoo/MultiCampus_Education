<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> test2 </title>
</head>
<body>
<!-- web.xml을 이용해서 공유파일 읽어오기(2) -->
<h1>
우리 과정은
<%=application.getInitParameter("title") %>
이며 종료날짜는
<%=application.getInitParameter("enddate") %>
입니다.
</h1>

<!-- web.xml과 include없이 여러페이지에서 공유하는방법은 set/getAttrute사용
이때, application1 실행 => application2 올바른 순서로 실행할 것 -->
<% Object share= application.getAttribute("share"); %> <!-- Object타입 -->
<%-- <%= ((String)share).toUpperCase() %>	--%>

<!-- 현재 서버 application1.jsp와 application2.jsp 요청시마다 요청횟수 화면 출력 -->
<% application.setAttribute("share", (int)share+100); %>
<%= application.getAttribute("share") %>
</body>
</html>