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
세션으로부터 전달받았습니다.
${cnt }

<!-- --------forward를 통해 전달받기때문에 jstl1부터 시작해야한다.---------- -->
<h1> 이름 목록(list) </h1>
<c:forEach var="name" items="${list }" varStatus="st"> <!-- varStatus라는 상태값 -->
	${st.index} : ${st.count} : ${st.current}<br> <!-- index는 0부터, count는 1부터, st.current를 써라 st.name대신-->
</c:forEach>	

<h1> 전화번호부 목록(map)</h1>
<c:forEach var="phone" items="${map}">
	${phone.key} : ${phone.value }<br> 
</c:forEach>	
</body>
</html> 