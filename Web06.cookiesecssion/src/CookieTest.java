


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*<서블릿에서 사용하는 쿠키: 쿠키는 서블릿이나 JSP나 상관없음>
		//방문자
		 
		1. 1번 요청시,
		쿠키정보 생성
		클라이언트로 전달
		
		(선택사항)
		쿠키의 지속시간 설정
		(작성하지않으면, 브라우저종료시 브라우저의 값들이 초기화가 됩니다)
		*/
		 
		Cookie c = new Cookie("count","1"); //처음에 들어가는 값은 무조건 다 String
		response.addCookie(c);
	
		/*
		2. 2번 요청시,
		클라이언트 쿠키 전달받음
		전달받은 쿠키 정보를 바꿈. (setValue, getValue)
		*/
		Cookie[] cookies = request.getCookies();
		for(Cookie coo: cookies){
			if(coo.getName().equals("count")){
				int valInt= Integer.parseInt(coo.getValue())+1;
				
				//현재 우리 서버 valInt번재 방문입니다.
				coo.setValue(String.valueOf(valInt)); //정수 -> String으로 변환
				response.addCookie(coo);//coo의 value가 바뀌었으니 새로 전달받아라.
				
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out= response.getWriter();
				out.println("<h1>현재 우리 서버"+valInt+"번째 방문입니다</h1>");
			}
		}
		
		
		
		
	}
}
