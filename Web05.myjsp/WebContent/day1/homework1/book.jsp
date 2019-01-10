<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="amounterror.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String booklist [] = 
{"오라클", "자바", "jquery","서블릿","스프링" };
int pricelist[]= 
{15000, 20000, 15000, 17000, 25000};

//HashMap<String, Integer> map
//= new HashMap<String, Integer>();
//map.push("오라클", 15000);
//4번 
//map.get("오라클")


//book 이름 , checkbox 선택된 것만 jsp 전송
String[] books = 
request.getParameterValues("book");

//balance 이름 가진 것 모두 : 5
String[] balances = 
request.getParameterValues("balance");

//수량 입력x : 0
//수량 음수 : amounterror.jsp 예외처리전담
for(int i = 0; i < balances.length; i++){
	if(balances[i].equals("")) balances[i] = "0";
	if(Integer.parseInt(balances[i]) < 0) 
		throw new Exception
	("수량은 음수가 불가합니다");
}

//books 사용자선택 도서가 
//booklist 전체책 목록 존재하는지 판단
//pricelist index : 가격
int pricePerBook = 0;
int priceTotalBooks = 0;
for(int i= 0; i< books.length; i++ ){
	for(int j = 0; j <booklist.length; j++){
		if(booklist[j].equals(books[i])){
			pricePerBook = pricelist[j] * 
			Integer.parseInt(balances[j]);
			out.println
			(books[i] + ":" + balances[j] 
					+ "권 선택:"
			+ pricePerBook +"원<br>"	);
			priceTotalBooks += pricePerBook;
			break;
		}
	}
}
out.println
("<h1>총가격:"+ priceTotalBooks + "</h1>");
String address = 
request.getParameter("address");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone = phone1 + "-" + phone2;
%>
배송지:<%=address %><br>
연락처:<%=phone %><br>
<%@ include file="bookcommon.jsp" %>
</body>
</html>







