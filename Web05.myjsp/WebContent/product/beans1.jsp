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
//쇼핑몰을 운영중인데, 삼성tv한대가 150,000원이고 한대씩 팔때마다 balance-1;
ProductVO vo= new ProductVO();
vo.setCode(1000);
vo.setName("삼성tv");
vo.setPrice(150000);
vo.setBalance(50);

%>
<h1> 오늘 제품 등록 현황</h1>
<%= vo.getCode() %><br>
<%= vo.getName() %><br>
<%= vo.getPrice() %><br>
<%= vo.getBalance() %><br><br>

<jsp:useBean id="vo2" class="product.ProductVO" /> <!-- 패키지.클래스로 만들어준다. -->
<jsp:setProperty property="code" name="vo2"  value="2000"/>
<jsp:setProperty property="name" name="vo2"  value="LG에어컨"/>
<jsp:setProperty property="price" name="vo2"  value="200000"/>
<jsp:setProperty property="balance" name="vo2"  value="20"/>

<!-- 앞으로 객체를 나타내는 것을 name속성에 넣으면 ㅗ딘다. -->
<jsp:getProperty property="code" name="vo2"/><br>
<jsp:getProperty property="name" name="vo2"/><br>
<jsp:getProperty property="price" name="vo2"/><br>
<jsp:getProperty property="balance" name="vo2"/><br>

<!--------------------------------
-------------------------------------------->
<!-- html input name속성값 = parameter이름 
	이때, bean클래스의 변수명과 같아지게되면 param을 생략해도된다.
	
	따라서, html의 name = setter의 property가 같기때문에 아래의 vo3_setter는 param을 생략가능하다
	
	따라서, html의 name != setter의 property가 같지않다면, 해당 값은 null이 나오기때문에 param="html의 name값"으로 작성해야한다.

	(단, property="*"와 같이 작성하면 모든 setter메서드명이게 된다. 편리성과 간단성) 
	
	결론적으로, html을 작성할때에도 name값을 jsp의 객체태그 property와 동일하게 만들어주도록 하는게 코드량을 줄일 수 있습니다.
	
	★ 객체생성을 위해서는 기본생성자가 무조건 있어야한다. 만약에 기본생성자가 없다면, 객체를 절대로 만들 수 없습니다. 
	
	추가적으로, scope ="page" : 현재페이지만  적용 (default)
				   ="request" : request.setAttribute("",)와 같이 공유할 수 있는 기능이 생긴다.
-->


<jsp:useBean id="vo3" class="product.ProductVO" scope="application"/> <!-- 패키지.클래스로 만들어준다. -->
<jsp:setProperty property="*" name="vo3"/> <!--value(Integer.parseInt("request.setParameter(\"code\")"))-->
<%-- <jsp:setProperty property="name" name="vo3" param="name"/> <!-- HTML의 name값이 name인 것을 param을 통해 가져온다 => property가 name인 setter에 넣느다.--> --%>
<%-- <jsp:setProperty property="price" name="vo3" param="price"/>  --%>
<%-- <jsp:setProperty property="balance" name="vo3" param="balance"/> --%>

<jsp:forward page="beans2"/> 
<!--  scope=\'request\'와 같다 -->

<!-- 앞으로 객체를 나타내는 것을 name속성에 넣으면 ㅗ딘다. -->
<%-- <jsp:getProperty property="code" name="vo3"/><br> --%>
<%-- <jsp:getProperty property="name" name="vo3"/><br> --%>
<%-- <jsp:getProperty property="price" name="vo3"/><br> --%>
<%-- <jsp:getProperty property="balance" name="vo3"/><br> --%>

</body>
</html>