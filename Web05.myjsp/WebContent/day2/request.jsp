<%@page import="java.text.SimpleDateFormat, java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.io.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 내장객체 request, response(거의 쓸일없음. 왜냐하면 유일하게 쓰는contentType는 자동생성), 파일쓰기(log_write) </title>
</head>
<body>
<%
//get/post 동일 동작
//url?get : / post

out.println("요청방식="+request.getMethod()+"<br>");  //결과는 대문자.post또는 get이 나왓다 
if(request.getMethod().equals("POST")){
	request.setCharacterEncoding("utf-8");
 	out.println(request.getParameter("a"));  

}
else if(request.getMethod().equals("GET")){
	out.println(request.getParameter("a"));  
	//http://localhost:9090/myjsp/day2/request.jsp?a=dsf
}
%>
<br>
<%
//서버 로그 기록한다: 영구적 파일저장
//사용자 ip 접근시간: 어떤 파일접근 정보 출력
String clientIP = request.getRemoteAddr() ;
String fileName = request.getRequestURI();
Date now = new Date();
SimpleDateFormat sd = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초");
String now2=sd.format(now);
%>


<!-- 사용자의 ip를 -Djava.net.preferIPv4Stack=true 를 작성하여  JSP에 IPv6대신 IPv4를 출력되도록합니다 -->
<%= clientIP+"컴퓨터가"+fileName+"에 접근한 시각은"+now2+"입니다<br>" %>

<!-- 자바스크립트의 내장객체 window.navigator.geo....로도 같은결과볼 수 있다 , JSP는 출력할 문장들을 바로 출력하는게아니고, 버퍼에 쌓아두는 것이다.--> 
<%= request.getHeader("user-agent") %> 

<!-- 국민은행싸이트:보안카드숫자전체입력화면 나온다, 링크와 같다.  -->
<%-- response.sendRedirect("http://www.google.com"); --%>



<% //logwriter (파일을 작성했다.)
//로그기록을 간단하게 파일에 저장하기위하여---------> 하나의 컴퓨터에 여러사용자가 접근시, 그 로그를 txt파일로 확인가능하다
//1. c:\log.txt 파일 없으면 생성하고 저장, 잇으면 저장
//2. FileWriter 객체

	FileWriter fw = new FileWriter("c:\\log.txt",true); //또는 \한개로 작성해도된다. 또한, 2번째 매개변수를 true를 두어야지 누적할 수 있다. 안그러면 계속 초기화
	fw.write(
			clientIP+"컴퓨터가"+fileName+"에 접근한 시각은 "+now2+"입니다.\r\n"); //줄바꿈처리는 \r\n
			
	fw.close();
%>
</body>
</html>