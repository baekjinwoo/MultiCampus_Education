<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDAO, java.util.*, board.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
	table{ border : solid 2px red; }
	td { border : solid 2px red; }
</style>
</head>
<body>
<!-- 앞으로의 DB는 datasource 데이터소스방식으로 사용한다. 그리고 xml을 수정하게되면 서버클린이아니고, 서버 재시작을 해야한다. -->
<body>
<%= page %>
<%
int pageNum = 0;
if(request.getParameter("page") == null){
	pageNum = 1;
}
else{
	pageNum = Integer.parseInt(request.getParameter("page"));
}
BoardDAO dao = new BoardDAO();
ArrayList<BoardVO> list = dao.getBoardList(pageNum);
%>
<table>
<%
//시작 1페이지 3개씩 출력
for(int i = 0; i < list.size(); i++){
  out.println("<tr>");
  out.println("<td>"+list.get(i).getSeq()+"</td>");
  out.println("<td>"+list.get(i).getTitle()+"</td>");
  out.println("<td>"+list.get(i).getContents()+"</td>");
  out.println("<td>"+list.get(i).getWriter()+"</td>");
  out.println("<td>"+list.get(i).getTime()+"</td>");
  out.println("<td>"+list.get(i).getPw()+"</td>");
  out.println("<td>"+list.get(i).getView()+"</td>");
  out.println("</tr>");
}
%>
</table>

<%
int totalRecord = dao.getTotalCount();//7
int totalPage = 0;
if(totalRecord % 3 == 0){
	totalPage = totalRecord / 3;
}
else{
	totalPage = totalRecord / 3 + 1;
}
out.println("<h1>");
for(int i = 1; i <= totalPage; i++ ){
	out.println
	("<a href='boardlist.jsp?page="+i+"'>" + i +"</a> ");
}
out.println("</h1>");
%>

</body>
</html>