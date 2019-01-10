<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 사용순서1. 위 코드는 내 파일하나를 c라고 시작하는 태그를 쓰겠다는 의미, uri라는 경로에 따라서 문법체크를 하고, 문법을 쓰겠다.는 의미. -->

<!-- jsp 추가 태그들 : jsp stardard tag library  
jstl
java script : 별도 라이브러리 설치 x
jquery : 별도 라이브러리 설치 O
jstl : tomcat 서버 라이브러리 설치 O

사용순서2. 현재프로젝트\webcontent\web-inf\lib\*.jar안에 파일을 붙여넣는다. -->

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> jsp 추가 태그들 : jsp stand </title>
</head>
<body>

<%int cnt =1; %> 
표현문태그:<%=cnt+1 %><br> <!-- cnt=2 -->

<c:set var="cnt2" value="100"></c:set>
el표현식: ${cnt+1 }<br>  <!-- cnt=1, el표현식은 cnt2만을 변수로 받기 때문에, cnt를 찾기못한다. 따라서 cnt가 없다고 인식해서 1만 출력된다. 
									el로 표현하면 nullpoint 에러처리 필요없다. 값이 없으면 알아서 제외됨.-->
el표현식: ${cnt2+1 }<br> <!-- cnt= 100+1 -->


<!-- ------------------------------------------------------------------------------------------------------ -->


<!-- RESULT에 각각 다른값들을 저장 -->
<% request.setAttribute("RESULT", new java.util.Date()); 
session.setAttribute("RESULT", "세션속성값");
application.setAttribute("RESULT", new int[]{1,2,3});
%>


<!-- ------------------------------------------------------------------------------------------------------ -->


<% // import를 안할 경우는 패키지명을 붙여서 쓴다.
java.util.ArrayList<String> nameList = new java.util.ArrayList<String>();
nameList.add("백중렬");
nameList.add("강성효");
nameList.add("백진우");
request.setAttribute("list", nameList); 
%>


<!-- ------------------------------------------------------------------------------------------------------ -->

<%
java.util.HashMap<String,String> phoneMap = new java.util.HashMap<String,String>();
phoneMap.put("박중렬","010-001-0001");
phoneMap.put("강성효","010-002-0002");
phoneMap.put("백진우","010-003-0003");
request.setAttribute("map", phoneMap); 
%>

<!-- ------------------------------------------------------------------------------------------------------ -->

<% 
board.BoardVO vo= new board.BoardVO();
vo.setSeq(1000);
vo.setTitle("e1테스트");
vo.setContents("e1테스트글내용");
vo.setWriter("test");
vo.setTime(new java.util.Date().toLocaleString());
vo.setPw("1234");
vo.setView(100);
request.setAttribute("boardvo", vo);

%>
<!-- el2는 위의 세가지를 다 받아가는 거다. -->
<jsp:forward page="el2.jsp"/>

</body>
</html>