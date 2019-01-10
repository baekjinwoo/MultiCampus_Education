<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cart.CartVO, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>현재 바구니 목록입니다</h3>
	<table>
		<th> 상품코드 </th>
		<th> 수량 </th>
		<br>

		<%
		if (session.getAttribute("list") != null) { //null포인트
		ArrayList<CartVO> list = (ArrayList<CartVO>) session.getAttribute("list");
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
		<td><%=("상품코드: " + list.get(i).getCode())%></td>
		<td><%=("수량: " + list.get(i).getBuyamount())%></td>
		</tr>
			<%
		}
	%>
		
		
		<%
			} else {
				out.println("<tr><td>장바구니 목록 비었습니다</td></tr>");
			}
		%>
	</table>
	<a href='http://localhost:9090/cookiesecssion/cart'><h3>상품 더
			고르실래요?</h3></a>
</body>
</html>

<!-- cartview.jsp
세션에 저장된 ArrayList 조회 출력
현재 장바구니 목록입니다
상품코드 수량 
상품코드 수량 
상품 더 고르실래요?
 -->