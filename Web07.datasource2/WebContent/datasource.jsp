<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,javax.sql.*, javax.naming.*"%> <!--  javax.naming.*안에 context객체있다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">

<title>DB에서 datasource를 쓸경우 꼭 나오는 문장</title>
</head>
<body>
<% 
// jdbc//myoracle이름: Datasource타입객체
// context=현재파일환경(디렉토리,서버 설정파일)
	Context initContext = new InitialContext();
// context.xml 파일 정보 객체

	Context envContext= (Context) initContext.lookup("java:/comp/env"); //object형을 형변환한다. 
	
//jdbc/ myoracle 이름 객체
	DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");


//ds: 미리 일정 갯수 커넥션 풀 생성-빌려온다.
	Connection con = ds.getConnection();

	for(int i=0; i<=100;i++){
///////////////////////////////////////////////////////////////////////////////////
//xml파일이 바뀌면 톰켓서버도 새로시작해야한다.
	System.out.println(con+"==>"+i);
	con.close();
	}
%>
</body>
</html>