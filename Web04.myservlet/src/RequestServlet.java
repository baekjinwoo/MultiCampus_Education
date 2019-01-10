// RequestServlet.java(서블릿)와 login.html

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
				//doGet대신 doPost로 바꾸고 테스트 (login.html에서도 form method='post')하고 실행시 url에 값들이 노출되지않는다.
public class RequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mine타입: text/html (이떄, test/html이라고 작성하지 말 것 ==> 출력은 안되는데 mapping-url명이 다운로드된다면 mine타입 다시확인할 것)
		
		//요청 - 브라우저 id 변수 전달 (null포인트가 나오는이유는 id값이 전달이 안와서)
		//http://localhost:9090/myservlet/request_multi?id=servletjsp&pw=31245123  (?변수명=값으로 아이디를 전달받는다)
		// ==>아래의 out.println(id pw)를 넣엇기때문에 입력한 값이나온다.
		
		
		
//첫번째. url에 직접 입력해주는 방법		
		//?id= jquery&pw=32432423 //웹브라우저에서 변수명을 연결하려면 & 앤퍼샌트를 쓴다
		// ?변수명1=값1&변수명2=값2....(공백절대 x)
		
		//여기에서 id와 pw대신에 한글을 집어넣는것은 가능하나, html에서부터 전달되는 한글은 문제가 된다.
		//따라서,html에서 전달되어온 요청 브라우저 id, pw변수를 한글로 전달.
		request.setCharacterEncoding("utf-8"); //이걸 적어주면, html에서 전달되온 한글을 url에서 안깨지고 사용가능. Post를 Html에서 한글받으면 깨지는데 doGet에서 한글받으면 안깨지는듯.
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		
		//분석 처리-총합, 로그인, 회원가입
		id= id.toUpperCase();
		
		//응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> "+id+", "+pw +"</h1>");  //직접 한글을 java에서 출력시 안깨진다.
		out.close();
		
		
	
	}
}
