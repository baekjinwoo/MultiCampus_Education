<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
요청하신 조건은
<c:forEach var="con" 
items="${paramValues.condition }" >
${con} , 
</c:forEach>
이고 검색어는 ${param.word }를 입력하셨습니다.
<%
 String [] condition = 
 request.getParameterValues("condition");
 String word = 
		 request.getParameter("word");
 request.setAttribute("condition", condition);
 request.setAttribute("word", word);
 BoardDAO boarddao = new board.BoardDAO();
 java.util.ArrayList<board.BoardVO> 
 boardlist = 
 boarddao.getBoardList(0);//전체레코드
 request.setAttribute("boardlist",  boardlist); 
%>

<jsp:forward page="boardsearchresult.jsp" />

</body>
</html>