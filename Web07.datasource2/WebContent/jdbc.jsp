<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	for(int i=1;i<=100;i++){ //최대커넥션은 100이 아니고, 70이다.
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
	
	System.out.println(con +"==>" + i +"개 성공");
	con.close(); // con을 close하자마자, 자바는 GC로 보내게된다. // 앞으로 없앨게란 의미로 체크표시하는 것을 말한다. 
	//
	} 
%>
</body>
</html>