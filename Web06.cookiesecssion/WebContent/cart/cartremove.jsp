<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cart.CartVO, product.ProductVO, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int sum = 0;
		if (session.getAttribute("list") != null && application.getAttribute("productArray") != null) {
			ArrayList<CartVO> list = (ArrayList<CartVO>) session.getAttribute("list");
			ProductVO[] array = (ProductVO[]) application.getAttribute("productArray");
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < array.length; j++) {
					int cartCode = list.get(i).getCode();
					int productCode = array[j].getCode();
					if (cartCode == productCode) {
						sum += list.get(i).getBuyamount() * array[j].getPrice();
						break;
					}
				}
			}
		}
	%>
	<h3>
		총 가격
		<%=sum%>
		원입니다.
	</h3>

	<input type=radio value="현금" id="cash" onclick="getMoney()">현금
	<input type=radio value="카드" id="card" onclick="getMoney()">카드
	<div id="here"></div>
	<script>
		function getMoney() {
			if (document.getElementById("card").checked == true) {
				document.getElementById("cash").checked == false;
				document.getElementById("here").innerHTML = "지불 수단은 "
						+ document.getElementById("card").value + " 입니다.";
				document.getElementById("card").checked = false;
			}
			if (document.getElementById("cash").checked == true) {
				document.getElementById("card").checked == false;
				document.getElementById("here").innerHTML = "지불 수단은 "
						+ document.getElementById("cash").value + " 입니다.";
				document.getElementById("cash").checked = false;
			}
		}
	</script>
	<%-- <% session.invalidate(); %> --%>
</body>
</html>


