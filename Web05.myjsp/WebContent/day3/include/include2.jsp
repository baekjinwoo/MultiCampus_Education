<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, java.text.*;"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Date now = new Date();
	   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
	   String logintime = sdf.format(now);
	%>
   <h3>로그인 시각: <%=logintime %></h3>
   <!-- 포함되는 파일에서는 포함하는 파일로 정보 전달x -->
   <!-- 포함되는 파일에서는 포함하는 파일로부터 정보전달o -->
   <!-- 1.요청정보 사용자 입력 변수 -->
   <%= request.getParameter("id") %><br> <!--  request자체가 공유되기때문에 그대로 사용한다. request와 response를 동시에 사용 -->
   
   <!-- 2. jsp파일에서 전달 변수1하고, include1.jsp의 전달태그가 param태그이기때문에 include2.jsp에서 getParameter로 출력한다 -->
   <%= request.getParameter("condition") %><br>
   
   <!-- 3. jsp파일에서 전달 변수2하면서, setAttribute를 사용했기때문에 무조건 getAttribute가 와야한다. -->
   <%= request.getAttribute("condition2") %><br>  
   <%--받은 정보를 출력한다. --%>
</body>
</html>