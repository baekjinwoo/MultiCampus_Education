<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> test1</title>
<!-- include를 사용하지 않고 내용을 공유하는 또 다른 방법 -->
</head>

<body>
<!-- myjsp프로젝트 환경내부 -->
<!-- web.xml을 이용해서 공유파일 읽어오기(1) -->
<h1>
우리 과정은
<%=application.getInitParameter("title") %>
이며 종료날짜는
<%=application.getInitParameter("enddate") %>
입니다.
</h1>

<!-- web.xml과 include없이 여러페이지에서 공유하는방법은 set/getAttrute사용 -->
<!--  정보를 저장하고 공유하는 application객체를 사용하는 방법 -->
<% 
// 현재 jsp파일만  i사용가능하다 
int i=200; 
String s ="app7";
//myjsp프로젝트 모든 jsp에서 공유가능하게하다 : share변수
application.setAttribute("share", i); //변수하고자하는이름을 share%>

<%=application.getAttribute("share") %>
</body>
</html>