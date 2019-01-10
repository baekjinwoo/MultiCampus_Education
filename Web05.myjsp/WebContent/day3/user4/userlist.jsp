<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, user4.User4" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> DB내용 테이블로 출력 </h1>
<table border="2">
<th> 아이디 </th>
<th> 이름 </th>
<th> 비번 </th>
<th> 이메일 </th>
<th> 번호 </th>

<%
ArrayList<User4> list = (ArrayList<User4>)request.getAttribute("list");
for(int i = 0; i < list.size(); i++){
%>
<tr>
<td><%= (list.get(i).getId())%></td>
<td><%= (list.get(i).getName())%></td>
<td><%= (list.get(i).getPw())%></td>
<td><%= (list.get(i).getEmail())%></td>
<td><%= (list.get(i).getPhone())%></td>
</tr>
<% } %>
<%-- out.println은 <%=와 같다  %>--%>
</table>
</body>
</html>




