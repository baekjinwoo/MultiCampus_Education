package share;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//application1.jsp와 application2.jsp와 같이 사용해야됨.
public class ShareServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//공유범위: myjsp안에있으면 모든 jsp와 서블릿은 공유할 수 있다.
//공유기간: 실행시, tomcat서버가 종료될떄까지 계속 실행된다. 
		
//내장객체없기때문에, 만들어서 (1)web.xml정보읽고, (2)jsp들간의 정보공유를 할 수 있다.   
	// application객체를 사용하기위한 타입이 ServletContext이기때문에 따로 지정해주어야지 setAttribute와같은 메서드사용가능
		
		
		//JSP와의 차이점은 application을 만들어서 사용해야되는 점.
		ServletContext application = getServletContext();
		
		//share를 불러오고! (실행순서 application1.jsp => application2.jsp => ShareServlet.java)
		Object share = application.getAttribute("share");
		application.setAttribute("share",((Integer)share)+1000);
		
	
		response.setContentType("text/html; utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>"+application.getAttribute("share")+"</h3>");
	
	
	}
}
