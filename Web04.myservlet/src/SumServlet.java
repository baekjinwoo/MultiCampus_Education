//sumservlet.java(서블릿)과 sum.html

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SumServlet extends HttpServlet implements Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String start= request.getParameter("start");
				String end= request.getParameter("end");
				
				//html에서 입력된 모든 파라미터값은 문자열로 입력되기때문에 아래와같이 변환해야한다 
				int a=Integer.parseInt(start);
				int b=Integer.parseInt(end);
				int sum=0;
				
				//분석 처리-총합, 로그인, 회원가입
				//id= id.toUpperCase();
				
				//응답
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				for(int i=a; i<=b; i++){
					sum+=i;
				}
				out.println("<h1>"+sum+"</h1>");
				out.close();
				
				
	
	}
}
