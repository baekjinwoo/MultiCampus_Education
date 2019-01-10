<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp" %>
    
<!-- 이 페이지에서 에러가 날 경우에 다음과 같이 속성을 추가해야합니다. errorPage="Error.jsp" -->    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> Jsp를 이용한 1~100 더하기 </title>
</head>
	
<!-- 	전체적으로 html과 java문장을 둘 다 쓰는 것을 볼 수 있다.
	이런 문장을 jsp scriptlet태그라고 한다 -->
	
<body>
	<%
	out.println("<h1> 1-100 총합 </h1>");
	int sum=0; //<%안에서 변수선언시, 서블릿 소스안에서 _jspService 지역변수로 선언된다.
	for(int i=1; i<=100; i++){
		sum+=i;
	}
	int a=9;
	
	out.println(sum); //jsp에서는 out을 내장객체로 만들어준다.
	testmethod(); //<%!로 만들어진(정의된) 메서드를 호출하는 문장을 <%에서 쓴다.
	%>
	
	<h1><%= 100+100+a+"안녕" %></h1>	<!--브라우저출력문장1 -->
	<h1><%= sum %></h1>	<!-- 브라우저출력문장2 -->
		
<!---------------------------------------------------------------------->	

	<% int key = 100; %>
	<%! int member=1000;
		public void testmethod() throws Exception{ 
		System.out.println("first.jsp:testmthode 실행중"); 
		System.out.println(member); //o
		//System.out.println(key); //x
		//out.println(member); //x
	} %>	
	
	<% out.println(member); //o 
	   System.out.println(member);//o%>
		
<!---------------------------------------------------------------------->	

	<% String s = null; //문자도없는대 대문자로 바꾸라는것때문에 NullPointerException발생 
		s.toUpperCase(); %>		
	

</body>
</html>

