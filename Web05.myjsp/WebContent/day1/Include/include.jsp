<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> jsp의 include태그 </title>
</head>

<body>

<%-- <% int share=100; %> --%>
<h3><%@include file="common.jsp" %></h3>
<h1>메인 메뉴입니다.</h1>
<%@include file="common.jsp" %> <!-- 변수명이 같을경우는 오류가 뜨기 때문에 common.jsp에서 변수명을 지정하지않는 방식으로 코드를 작성하였더니 코드에 오류가 없다. -->
<h3>서브 메뉴입니다.</h3>				<!-- include를 통해 변수를 공유할 수 있고, jsp->서블릿(자바)파일에서는 심플데이터포맷이 호출할때마다 작성되있는걸 볼 수 있다. -->
<%@include file="common.jsp" %>

</body>
</html>