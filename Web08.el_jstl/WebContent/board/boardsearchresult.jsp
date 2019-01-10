<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
요청하신 조건은
<c:forEach var="con" 
items="${paramValues.condition }" >
${con} , 
</c:forEach>
이고 검색어는 ${param.word }를 입력하셨습니다.
<br>

<table>
<c:forEach var="boarditem" items="${boardlist }">
 <c:forEach var="con" items="${condition}" >
 <c:if test=
 "${con == \"제목\" && 
 boarditem.title.contains(param.word) 
 ||
 con == \"내용\" && 
 boarditem.contents.contains(param.word)
 ||
 con == \"작성자\" && 
 boarditem.writer.contains(param.word)  
 }">
 <c:set var="result" value="1" />
 </c:if>
 </c:forEach>
 	<c:if test="${result == 1 }">
 		<tr><td style="border:solid 3px silver">
 		${boarditem}</td></tr>
 	</c:if>
</c:forEach>
</table>
</body>
</html>



