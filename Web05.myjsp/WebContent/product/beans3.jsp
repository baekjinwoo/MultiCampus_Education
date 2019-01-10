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

<!--  application을 이용한 set/getAttribute를 대체해서 사용할 수 있다.

추가적으로 <jsp:param > ------- foward나 include에 끼워넣는 태그는 아래의 내용을 대체할 수 있다. 
RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/user3/user3.jsp"); 
request.setAttribute("user3", user3);
dispatcher.forward(request, response);  

--> 

<jsp:getProperty property="code" name="vo3"/><br>
<jsp:getProperty property="name" name="vo3"/><br>
<jsp:getProperty property="price" name="vo3"/><br>
<jsp:getProperty property="balance" name="vo3"/><br>

</body>
</html>