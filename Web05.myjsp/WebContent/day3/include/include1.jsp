<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> include1을 실행하면, include2도 실행되도록 :clude를 사용해라 </title>
<!-- 이번에 공유하는 방법은 각각의 소스가 따로있고, 실행결과만 합치는 것. -->
</head>
<body>	
	<%--<jsp:include page="include2.jsp"/> 여러번 사용가능한 것 확인후 주석 --%>
	<% String id = request.getParameter("id");
	   String check= "id정상입력"; //include2.jsp출력되도록 전달하기
	   request.setAttribute("condition2", check); //한글인코딩을 방지하기위하여, 자바의 객체를 param으로 전달할 수 없기때문에 setAttribute를 사용해야한다.
	%>

	<%--<jsp:include page="include2.jsp"/>--%> 		
	<h1>입력아이디 <%=id %> 회원님 로그인하셧습니다.</h1>
												<!-- 사용자가 정의한 내용들 외에 추가로 더 넣고 싶을때, (객체가 아닌 것들중에서) html에서는 객체를 전송하지 못하기때문에, 그럴때 그외에 추가적으로 넣을것들. -->
 	<jsp:include page="include2.jsp">		
 		<jsp:param value="check" name="condition"/> 
 		<jsp:param value="id정상입력" name="condition"/> 
 		 
 	
 	</jsp:include> <!-- (1) jsp:clude는 /슬래시로 끝난다.
 						(2) 바디가 있을경우 /를 적지 않는다. 
 						(★) jsp:안에서는 주석을 사용할 수 없다.-->
 	<%-- 정보를 전송한다 --%>
</body>
</html>