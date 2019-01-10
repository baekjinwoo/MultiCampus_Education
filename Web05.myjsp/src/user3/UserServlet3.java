package user3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		User3 user3= new User3(id, pw, name, email, phone);
		
		
		//이제는 user.jsp파일만 user객체를 공유한다. (자동이동)
		//앞전의 user2 문제에서는 프로젝트 전체파일을 공유하는 것이였음.
		RequestDispatcher dispatcher 
						= request.getRequestDispatcher("http://localhost:9090/05.myjsp/day3/user3/user3.jsp"); 
		request.setAttribute("user3", user3);
		dispatcher.forward(request, response); //요청, 응답객체를 공유해라
		
//		ServletContext application = getServletContext();
//		application.setAttribute("user3",user3); 
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out= response.getWriter();
//		out.println("<a href='/myjsp/day2/user2/user.jsp'> user.jsp로 이동 </a>");
//		out.close();
	}
}
