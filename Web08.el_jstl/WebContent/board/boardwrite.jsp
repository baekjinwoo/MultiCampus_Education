<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardwriteresult.jsp" >
제목:<input type=text name="title" ><br>
내용:<textarea rows=10 cols=50 name="contents" >
</textarea><br>
작성자:<input type=text name="writer" value="${sessionid}" ><br>
암호:<input type=password name="pw" ><br>
<input type=submit value="글쓰기" ><br>
</form>
</body>
</html>

