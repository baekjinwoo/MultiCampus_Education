<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ not empty param.id }">
<% session.setAttribute("loginid", request.getParameter("id")); %>
<jsp:forward page="websocket.jsp"/>  <% //이동하라는 문장 %>
</c:if>

<c:if test="${ empty param.id  }">
<jsp:forward page="websocket_login.html"/>
</c:if>
</body>
</html>