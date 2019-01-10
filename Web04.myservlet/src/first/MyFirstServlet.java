//servlet 시작2
package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:9090/myservlet/MyFirstServlet
//main대신 doGet메소드와 매개변수:'자동호출'

//브라우저 MyFirstServlet 주소 입력하면 첫번째 파라미터가 "요청"
//두번째 파라미터는 요청했던 브라우저 응답 객체

public class MyFirstServlet extends HttpServlet {  //상속
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); //한글인코딩처리: html문서타입 선언,utf-8로 읽어라.
		PrintWriter out = response.getWriter(); //브라우저 응답= 출력객체 생성
		
		out.println("<h1>MyFirstServlet</h1>"); //브라우저 출력 내용물 21-22행 생성
		out.println("<h3>안녕하세요</h3>");   //==> system.이 없기때문에 웹브라우저로 출력
		
		out.close(); //브라우저 출력 종료
	
	
	}
}
