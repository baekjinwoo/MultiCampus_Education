<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import = 
    "board.BoardDAO, board.BoardVO, java.util.*"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table { border : solid 2px red; }
td { border : solid 2px red; }
</style>
</head>
<body>

<form action="boardlist.jsp" >
검색조건
<input type="checkbox" name="condition" value="제목">제목
<input type="checkbox" name="condition" value="내용">내용
<input type="checkbox" name="condition" value="작성자">작성자
검색어:<input type=text name="word" >
<input type=submit value="검색" ><br>
</form>

<br>
<br>
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

<br>
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
 BoardDAO boarddao = new BoardDAO();
 java.util.ArrayList<board.BoardVO> 
 boardlist = 
 boarddao.getBoardList(0);//전체레코드
 request.setAttribute("boardlist",  boardlist); 
%>
<!-- 스타일 설정 적용 -->
<jsp:include page="boardsearchresult.jsp" />

</body>
</html>