<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 실행이전 전달 RESULT 속성 3개 전달 가정
request.setAttribute("RESULT", 10)
session.setAttribute("RESULT", 100)
application.setAttribute("RESULT", 1000)일 경우,ㅡ 

${ RESULT } 만 작성하면, request부터 하나씩 검색해서 출력하고, 
${ application.Scope.RESULT }와 같이 절대경로로 출력가능함.
-->

<!-- 태그표현식. 출력1 -->
<%-- Date in= (Date)request.getAttribute("RESULT"); --%>
<%-- <%Integer in= (Integer)request.getAttribute("RESULT");%> --%>
<%-- 포현문태그로 출력: <%=in%><br> --%>


<!-- el표현식. 출력2 : getAttribute는와 import를 할 필요없다.(애트리뷰트 자체를 받아오니까) -->
<!-- page => request => session => application순서대로 전체를 읽는다.  (이떄, session은 브라우저끌때까지 실행할때마다 값유지) -->

el표현식으로 출력: ${ RESULT }<br>
el표현식으로 출력: ${ RESULT }<br>
el표현식으로 출력: ${ RESULT }<br> <!-- 배열은 주소값이 출력된다. -->

el표현식으로 출력: ${ requestScope.RESULT }<br>
el표현식으로 출력: ${ sessionScop.RESULT }<br>
el표현식으로 출력: ${ applicationScope.RESULT }<br> 


<!-- ------------------------------------------------------------------------------------------------------ -->


<h3> 이름 목록은 다음과 같습니다.</h3>
${ list[0] }<br>
${ list[1] }<br>
${ list[2] }<br>
${ list[3] }<br>


<!-- ------------------------------------------------------------------------------------------------------ -->

<h3> 전화번호 목록은 다음과 같습니다.</h3>
${ map["박중렬"] }<br>
${ map["강성효"] }<br>
${ map["백진우"] }<br>
<!-- 한글이 아니고 영문일경우에는 map.abdc와 같이 사용가능하다 -->

<!-- ------------------------------------------------------------------------------------------------------ -->

<!-- 요청파라미터 name=홍길동
	  전화번호목록 미등록
	 
	 요청파라미터name=박중렬
	박중렬=xxx-xxx-xxxx  -->
	
<!-- 입력한 파라미터중 name을 읽어오는것. 한글파라미터를 받아오는건 구글에서 가능하다. el1.jsp에서 실행할때,  
http://localhost:9090/el_jstl/el1.jsp?name=박중렬 -->
${ empty map["박중렬"]?"전화번호 미등록":map[param.name] }

<!-- ------------------------------------------------------------------------------------------------------ -->

<h1> 게시물 글 작성 내용은 다음과 같습니다.</h1>
번호: ${boardvo.seq }<br>
제목: ${boardvo.title }<br>
내용: ${boardvo.contents }<br>
작성자: ${boardvo.writer }<br>
시간: ${boardvo.time }<br>
암호: ${boardvo.pw }<br>
조회수: ${boardvo.view }<br>


</body>
</html>