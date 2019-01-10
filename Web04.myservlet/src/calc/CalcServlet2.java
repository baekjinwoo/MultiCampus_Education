//CalcServlet2.java(서블릿) 과 calc.jsp

package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩
		response.setContentType("text/html; charset=utf-8"); 
		
		//1~100 총합 계산 출력
		int start=1;
		int end=1000;
		int sum=0;
		for(int i=0; i<=end; i++){
			sum+=i;
		}
		//1~100까지의 총합 =xxxx
		PrintWriter out=response.getWriter();
		out.println("<h1>"           // html적용
					+start+"~"+end+"의 합계 ==>"+sum //servlet기초
					+"</h1>");
		
	}	
}
