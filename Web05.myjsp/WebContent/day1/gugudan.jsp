<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 테이블태그로 2-9 구구단 jsp</title>
<style>
	table{border: solid 3px yellow;}
	td{background-color: lime; }
</style>
</head>

<body>
<table border='2'>
	<%!
		public String gugu(int dan, int su){ //<%!에서만 생성되는 구구단메서드
		return dan+"*"+su+"="+dan*su; //return값을 out.println(안에 직접대입가능하다)
		}
	%>


	<h1> 구구단을 출력합니다</h1>
	<%
	for(int i=1; i<10; i++){
		out.println("<tr>");
		for(int j=2;j<10;j++){
			out.println("<td>"+gugu(j,i)+"<td>"); //<%!의 메서드에서는 out.println을 쓸 수 없다.
		}
		out.println("</tr>");
	}
	%>
</table>
	<h1> 출력을 완료합니다</h1>
</body>
</html>

	
	