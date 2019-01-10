<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
우리 사이트 관리자 화면입니다.
<%=request.getParameter("id")%>관리자님 환영합니다.
</h1>

<h2> 게시물을 출력합니다</h2> <!-- 배열의 자료형은 오브젝트타입. 따라서 String으로 형변환 -->
<% String[] board = (String[])request.getAttribute("boardArray"); 
for(int i=0; i<board.length; i++){
	out.println("<h3>"+board[i]+"</h3>"); //낱개로 요소출력
}
%> 
	
	
</body>
</html>