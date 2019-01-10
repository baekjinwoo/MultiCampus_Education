<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!-- 오류전담처리에서는 에러정보를 화면에 줄 준비가 됬다는 의미로써
						페이지속성 isErrorPage="true"을 추가해야한다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 오류 전담 처리</title>
</head>

<body>
	<%-- <h4><%= exception %></h4> --%>
<%-- 	<h4><% System.out.println(exception); //에러문장은 브라우저보다는 콘솔로 개발자가 확인하도록 작성한다%></h4> --%>
<%-- 	<%= "잠시기달려주세요<br>"+exception.getMessage()+"에러발생" %> --%>

	<%= "잠시기달려주세요<br>"+exception.getMessage()+"에러발생" %>

</body>
</html>