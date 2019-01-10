<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cart.CartVO, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int productcode = Integer.parseInt(request.getParameter("product"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		CartVO vo = new CartVO(productcode, amount);
		

		if (session.getAttribute("list") != null) {
			// 세션 내부 이미 저장 리스트 존재 경우
			ArrayList<CartVO> list = (ArrayList<CartVO>) session.getAttribute("list");
			bfLoop : for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCode() == productcode) {
					CartVO cv1 = new CartVO(productcode, list.get(i).getBuyamount() + amount);
					list.remove(list.get(i));
					list.add(cv1);
					//session.setAttribute("sessionlist", list);
					break;
				} else {
					for(int j=0; j<list.size(); j++){
						if(list.get(j).getCode() == productcode){
							continue bfLoop;
						}
					}
					list.add(vo);
					break;
				}
			}
			//session.setAttribute("list", list);
		} else {
			// 세션 내부 리스트 x(최초 상품 선택 저장)
			ArrayList<CartVO> list = new ArrayList<CartVO>();
			list.add(vo);
			session.setAttribute("list", list);
		}
	%>
	<a href="http://localhost:9090/cookiesecssion/cart/carview.jsp">
		장바구니 보러 갈래요?</a>
</body>
</html>