<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 저장된 쿠키값 출력 </title>
</head>
<body>
<%-- 
	<% 
	//클라이언트자리 저장
	//동일 클라이언트: 동일ip의 동일브라우저
	//(크롬 경우: ie cookie)
	//3. 클라이언트로부터 쿠키 전송받음
	
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i<cookies.length; i++){
		out.println("<h4>"	+cookies[i].getName()	+"="	+cookies[i].getValue()	+"</h4>");	
		}
	%> 
--%>

	<%
	Cookie[] cookies = request.getCookies();
	for(int i=0; i<cookies.length; i++){
		if(cookies[i].getName().equals("JSESSIONID")){ //JSESSIONID=~~~~~~~는 그냥 session=true로 인해 자동으로 만들어지는 id값
		continue;
		}	
		else if(cookies[i].getName().equals("todayEx")){ //날짜정보가 들어있는 todayEx가 보여지는대로 화면에 출력이된다면........
			String today=
					java.net.URLDecoder.decode(cookies[i].getValue(),"utf-8"); //set쿠키에 한글이 들어온경우, 인코딩을 했는데 get에서 출력할때 원래의 값으로 바꾸라는 문장
			
			out.println("<h3>마지막 방문 시각은"+today+"입니다</h3>");
		}
		else{
			out.println("<h3>"+cookies[i].getName()+"</h3>");
		}
		out.println("<h3>"+cookies[i].getValue()+"</h3>");
	}
	%>

</body>
</html>