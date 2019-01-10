<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 정보 입력</title>
</head>
<body>
<%
	String sessionid=null;
	if(session.getAttribute("sessionid")!=null){
	sessionid= (String)session.getAttribute("sessionid"); //항상 getAttribute는 오브젝트니까 형변환
	}
	else{
		sessionid=" "; //초기값을 null이라면 공백으로 보이도록
	}
%>
	<h1> 로그인 정보 입력</h1>
	<form action="sessionset.jsp" method="post">
		아이디: <input type=text name=id value="<%=sessionid%>"> <!-- 로그인한 적이없으니까 null -->
											  <!-- getsession까지 실행하고 sessionform으로 오면 아이디가 저장되있다. -->
		비번: <input type=password name=pw>
		<input type=submit value=로그인>
	</form>
</body>
</html>