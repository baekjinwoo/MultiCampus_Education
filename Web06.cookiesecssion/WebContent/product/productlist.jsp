<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="product.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ProductVO [] ProductArray= new ProductVO[10];
	ProductArray[0]=new ProductVO(100,"삼성TV",150000,10);
	ProductArray[1]=new ProductVO(101,"샤오미배터리",20000,10);
	ProductArray[2]=new ProductVO(102,"엘지에어컨TV",300000,10);
	ProductArray[3]=new ProductVO(103,"다이슨청소기",180000,10);
	ProductArray[4]=new ProductVO(104,"바지",60000,10);
	ProductArray[5]=new ProductVO(105,"라면",50000,10);
	ProductArray[6]=new ProductVO(106,"맥주",40000,10);
	ProductArray[7]=new ProductVO(107,"김치",30000,10);
	ProductArray[8]=new ProductVO(108,"운동복",20000,10);
	ProductArray[9]=new ProductVO(109,"소고기",10000,10);
	application.setAttribute("productArray", ProductArray);
	%>
	
	
	<form action="/cookiesecssion/cart/cartsave.jsp">
	
	<select name="product"> <!-- 옵션의value는 코드,  옵션안에는 제품이름, 옵션개수는 ProductArray의 개수만큼 생성-->
	<%	
		for(int i=0; i<ProductArray.length;i++){ 
	%>
	<option value= <%=ProductArray[i].getCode()%>> <%= ProductArray[i].getName()%> </option> 
	<% } %> 
	</select>
	
	수량: <input type=text name='amount'> <!-- Select태그 상품 이름 리스트하고,  Input태그 수량 입력 화면 보여주기-->
	<input type=submit value=장바구니저장>
	</form>
</body>
</html>