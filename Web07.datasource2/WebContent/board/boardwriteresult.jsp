<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="board.BoardVO, board.BoardDAO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="vo" class="board.BoardVO" />
<jsp:setProperty property="*" name="vo"/>
<% BoardDAO dao = new BoardDAO();
//dao.insertBoard(vo);
%>
<jsp:forward page="boardlist.jsp" />
</body>
</html>