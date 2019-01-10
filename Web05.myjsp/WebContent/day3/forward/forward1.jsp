<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> include와 비교를 위한 forword테스트 </title>
<!-- forward1.jsp => admin& generaluser.jsp-->

<!-- 
문제1. <입력한 id값에 따라 페이지가 달라지도록>

id를 입력햇는데, 'admin'또는 'administrator'이 입력되면  ==> admin.jsp페이지로 이동한다

java, servlet, jsp중 하나 입력되면 ==> generaluser.jsp로 이동

★★★★★ 실행을 위해서 id값을 입력해야한다. url에 직접 ?id=admin
 -->
</head>
<body>
	<%
		String path = "";
		String id = request.getParameter("id");
		if(id.equals("admin") || id.equals("administrator")){
			path= "admin.jsp";
		}
		else if(id.equals("java") || id.equals("servlet") || id.equals("jsp")){
			path="generaluser.jsp";
		}
		else {
			out.print("<h1> 해당 사용자는 우리 사이트를 ");
			out.print("이용하실 수 없습니다.</h1>");
		}
		String [] board = {"1:제목1:작성자1:1234:0, 2:제목2:작성자2:1234:11, 3:제목3:작성자3:1234:5"};
		request.setAttribute("boardArray", board);
		if(path!= ""){
		%>
	<jsp:forward page="<%=path %>"/>
	<% } %>
</body>
</html>