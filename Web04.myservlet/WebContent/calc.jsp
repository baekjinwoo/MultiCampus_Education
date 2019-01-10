<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html> <!-- HTML5는 뒤에 주저리주저리 없음 -->
<html>
	<head>
		<meta charset=UTF-8">
		<title> JSP를 이용한 calc 샘플 </title>
	</head>
	<body>
	<% 
		int start=1;
		int end=1000;
		int sum=0;
		for(int i=0; i<=end; i++){
			sum+=i;
		}
		out.println("<h1>" +start+"~"+end+"의 합계 ==>"+sum +"</h1>");
	%>	
	</body>
</html>