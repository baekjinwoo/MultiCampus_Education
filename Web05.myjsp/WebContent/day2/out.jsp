<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="true"%>
    				<!-- 버퍼기본공간 8kb --> 
    									<!-- 기본공간만큼의 버퍼공간이 꽉차면 자동으로 autoFlush되도록 설정. -->
    	
    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 내장객체 out</title>
</head>
<body>	
	<%= out.getBufferSize() %>  <!-- 자주사용 -->
	<% //out = null;  //선언은 x
	   out.println("<h1> 출력내용</h1>");	//out: jsp 서버내부 임시 버퍼 공간 저장 //자주사용
	   //out.clearBuffer();	//버퍼에 저장된 것들을 삭제 : 브라우저 출력x //자동
	   out.flush(); //지금까지 버퍼에 저장된 값들을 출력하고나서 지운다. ==>  //자동
	%>
	<%= out.getRemaining() %>	
	<!-- 웹서버 자주 등장 오류번호= 오류코드  http 프로토콜 통신 컴퓨터 -->
	
	<!-- 404: 서버내부 경로, 파일없다. 따라서 파일명확인, ====>(저 이름의 파일이 없다는 뜻)-->	
	<!-- 405: http 요청방식 어긋날 때 get-> dopost이거나, post -> doget이라면 x  ====>(form과 메서드명이 일치하는지 확인할 것) -->
	<!-- 500: 서버상의 오류. 서블릿이나 jsp가 잘못되면 무조건 발생.-->	
</body>
</html>

<!-- 모든 jsp는 버퍼크기로 저장된다. 그리고 그때그때출력하지않고, 마지막에 모아두었다가 한꺼번에 출력된다. -->
<!-- getBufferSize: 현재 버퍼값을 출력 -->
<!-- getRemaining: 쓸 것 다 쓰고 남은 버퍼를 출력 -->
