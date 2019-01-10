<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
    			<!-- 페이지지시자의 session은 true가 default이기떄문에 항상 사용가능하고, 생략가능하다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> setsession 추가</title>
</head>
<body>
<%
	//out.println(session.toString()); //를 통해 session이, null이아닌 값을 반환함으로써 만들어져있다는 것을 확인할 수 있다.
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	//
	session.setAttribute("sessionid", id);
	session.setAttribute("sessionpw", pw);
	
	
%>

	<!--  
		아이다와 패스워드가 jsp에서 넘겨받은 파라미터이다. 
		이를 usbBean타입으로 객체를 만들어서 풀어보기.
		
		public class LoginVO{
			private String id;
			private String pw;
			setter/getter메소드
		}
	 -->
</body>
</html>