//servlet시작

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycleServlet1 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException { //최초 한 번 실행
		System.out.println("init호출");  //system.out이기때문에 서버로 전송한다는 의미 => 콘솔로 출력
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet호출");
		//doGet메서드의 response매개변수에 의해서, printWriter객체생성 => out.println을 통한 브라우저 출력이 가능 
		
		//init과 destroy는 매개변수가 없기때문에 브라우저출력x 
	}

	public void destroy() { //최초로 마지막 한 번 실행
		System.out.println("destroy호출");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
