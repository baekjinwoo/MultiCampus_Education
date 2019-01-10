<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 쿠키 정보값 셋팅</title>
</head>
<body>
<%--
	<% 
	String id= request.getParameter("id");
	String pw= request.getParameter("pw");
	//member 테이블 조회 구현 완료
	//1번 입력 정보 계속 사용하도록 쿠키를 사용하자.
	
	//1. 쿠키 저장 정보 생성
	Cookie cookie1= new Cookie("cookieid",id);
	Cookie cookie2= new Cookie("cookiepw",pw); 
	//pw는 쿠키에 저장하면 안되고(보안연관되기에), 매번 입력할떄 유동적으로
	//id값만 24시간 유지: 브라우저, 서버종료 이후 가능
	cookie1.setMaxAge(60*24*60); //초 단위 ==> 24시간으로 id값만 서버, 브라우저가 종료되도 보이도록
	
	//2. 쿠키 클라이언트 전송(기본적으로 : 브라우저 종료시까지 )
	// 단, 24시간 유지하도록 설정가능하다.
	response.addCookie(cookie1);
	response.addCookie(cookie2);	
	%> 
--%>
	
	<%
	//1. 사용자 현재 서버 방문시마다 최근 방문시각 출력
	// 2017/08/10/11/12/13; 시간 날짜 객체 생성
	// 유효기간: 30일 지속 저장
	// 쿠키 저장
	String today= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	//Date now= new Date();
	//String today= now.toLocaleString();
	today= java.net.URLEncoder.encode(today,"utf-8");
	Cookie cookie3 = new Cookie("todayEx",today); //today를 넣을때 문자형만 넣을 수 있다
	
	cookie3.setMaxAge(60*60*24*30);
	
	response.addCookie(cookie3);	
	//cookieget.jsp: 쿠키 출력 => 2017/8/9 xxxx 최근접속
	%>
</body>
</html>