package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CartStartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String contents="<script src='jquery-3.2.1.min.js'></script>"
				+"<script>"
				+"$(document).ready(function(){"
				+"$('#btn1').on('click',function(){ location.href='product/productlist.jsp';});"
				+"$('#btn2').on('click',function(){ location.href='cart/carview.jsp';});"
				+"$('#btn3').on('click',function(){ location.href='cart/cartremove.jsp';});"
				+"});"
				+"</script>";
		
		out.println(contents);
		out.println("<h1>902쇼핑몰 오신 것을 환영합니다 </h1>");
		
		out.println("<input type=button value=상품리스트보기 id=btn1>");
		out.println("<input type=button value=장바구니조회 id=btn2>");
		out.println("<input type=button value=결제 id=btn3>");
		
		out.println("<h3>오늘은 생필품을 세일하고 있습니다 </h3>");
	

	}
}