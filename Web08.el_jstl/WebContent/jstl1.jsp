<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 항상 똑같은 C태그: 변수선언에 사용-->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 세션타입이기때문에 jstl1을 먼저실행하고, jstl2를 실행하면 jstl2에서 cnt가 100으로 출력된다. 브라우저 종료시까지 -->
<!-- c:set태그를 통해 변수선언 ------------------------------------------------------------ -->
<c:set var="cnt" value="100" scope="session" /> 
<h1> ${cnt } </h1>


<input type=text value="${cnt }">

<!-- 만들어놔도 상관없지만, 이런이름의 파일이 없기때문에 forward가 동작안한다. 그래도, 실행에 문제가 있으니, 주석처리하자. -->
<%-- <jsp:forward page="${filepath }"/> --%>

<!-- 제거 및 조건문------------------------------------------------------------------------- -->

<c:remove var="cnt"/>
확인:${cnt }<br>

									<!-- http://localhost:9090/el_jstl/jstl1.jsp?num=400 -->
<%-- <c:set var="i1" value="${param.num }"/> --%> <!-- 파라미터num을 입력받는다. -->
<c:set var="i1" value="100"/>
<c:set var="i2" value="10"/>
<c:if test="${ i1 gt i2 }"/>
${i1 }이 더 큽니다.<br>

<c:if test="${ i1 lt i2 }"/> <!-- c의 else는 없다. 따라서 원하는 조건문장을 다 만들어줘야한다. -->
${i2 }이 더 큽니다.<br>

<c:if test="${ i1 == i2 }"/> <!-- 기호형태와 문자형태의 연산자는 둘 다 똑같다. gt > lt < 등.. -->
${i1 }:${i2 } 같습니다.<br>

<!-- 스위치문 및 반복문----------------------------------------------------------------------- -->
<!-- 
파라미터 num1 존재하면 num1출력 
num1 존재x, num2 존재하면 num2출력
num1, num2 존재x num3 출력-->

<!-- choose태그의 when태그에 주석을 넣으면 실행이안되니까 주석XXXXXXXXXXXXX -->

<c:choose>
	<c:when test="${param.id.equalsIgnoreCase(\"test\")}"> ${param.id } </c:when> 
	<c:when test="${not empty param.num1 }"> ${param.num1 } </c:when> 
	<c:when test="${not empty param.num2 }"> ${param.num2 } </c:when> 
	<c:otherwise> ${param.num3 } </c:otherwise>
</c:choose>

<c:forEach begin="1" end="6" step="1"> <!-- 1부터 6까지 1씩 증가 -->
	<h${i}> 야호  </h${i }><br>
</c:forEach>

<%-- <c:forEach var="i" begin="1" end="6" step="2"> <!-- 1부터 6까지 2씩 증가 (홀수만 h1태그출력)--> --%>
<!-- 	<h?> 야호  </h?> -->
<%-- </c:forEach> --%>

<% //e11.jsp의 배열들 불러왔다.
java.util.ArrayList<String> nameList = new java.util.ArrayList<String>();
nameList.add("백중렬");
nameList.add("강성효");
nameList.add("백진우");
request.setAttribute("list", nameList); 

java.util.HashMap<String,String> phoneMap = new java.util.HashMap<String,String>();
phoneMap.put("박중렬","010-001-0001");
phoneMap.put("강성효","010-002-0002");
phoneMap.put("백진우","010-003-0003");
phoneMap.put("이자바","010-004-0004");
phoneMap.put("홍길동","010-005-0005");
request.setAttribute("map", phoneMap); 
%>

<!-- 
map이란?
index번호가 없다. 따라서, 객체(key)=value
keyset을 이용해서 key값만 출력
key는 primary key
null도 중복도 x
같은이름으로 value를 두번 선언시 수정의 기능
 -->

<!-- application쓰면, 웹서버종류할때까지 -->
<!-- session으로쓰면 브라우저안에서는  -->
<!-- 페이지 넘기려면 forward -->
<jsp:forward page="jstl2.jsp"/>

</body>
</html>