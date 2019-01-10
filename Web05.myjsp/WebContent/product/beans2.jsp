<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="vo3" class="product.ProductVO" scope="application"/> 
<!--  scope="page"는 객체를 만들어라.. request는  요청받은 값이 있는지? vo3=request.getAttribute가 있니?  없으면 새롭게 생성

request를 bean1과 bean2에 넣음으로써, setAttribute저장과 getAttribute전송이 되는 것을 알 수 있다.

따라서 scope을 이용하면 request을 이용한 set/getAttribute 정보공유/페이지이동을 대체할 수 있다.


-->

<jsp:getProperty property="code" name="vo3"/><br>
<jsp:getProperty property="name" name="vo3"/><br>
<jsp:getProperty property="price" name="vo3"/><br>
<jsp:getProperty property="balance" name="vo3"/><br>

</body>
</html>