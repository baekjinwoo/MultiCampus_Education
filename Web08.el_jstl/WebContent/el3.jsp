<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:9090/el_jstl/el3.jsp?num=100 -->
<%-- <%= Integer.parseInt(request.getParameter("num"))+1 %><br> <!-- 101 --> --%>
<%-- ${ param.num + 1 }<br> <!-- 101 --> --%>





<!-- el3.html에서 입력받은 값을 출력하기 -->
이름:${ param.name }입니다.<br>
선택한 애완동물은 ${ paramValues.pet }입니다.<br>

<!-- 이름:홍길동입니다. 선택한 애완동물은 [Ljava.lang.String;@7f421ad2입니다. 출력된다. 이때, String과 [ ] @는 string배열임을 알수 있다.  -->
선택한 애완동물은
${ empty paramValues.pet[0]?"없음":paramValues.pet[0] }<br>
${ empty paramValues.pet[1]?"없음":paramValues.pet[1] }<br>
${ empty paramValues.pet[2]?"없음":paramValues.pet[2] }<br>
${ empty paramValues.pet[3]?"없음":paramValues.pet[3] }<br>
${ empty paramValues.pet[4]?"없음":paramValues.pet[4] }<br>

입니다.
<!-- 이때, EL표현은 없는값을 null이 아니고, 공백을 표시한다. 
또한, EL표현을 통해 선택된 checkbox만 출력하기 위해 for문을 사용하려거든, JSTL을 통한  c:set을 써야한다 -->


<!-- ------------------------------------------------------------------------------------------------------ -->

${ 100 gt 90 } : ${100 > 90 }
${ 100 ge 90 } : ${100 >= 90 }
${ 100 lt 90 } : ${100 < 90 }
${ 100 le 90 } : ${100 <= 90 }


<!-- ------------------------------------------------------------------------------------------------------ -->



</body>
</html>