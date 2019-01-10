package user2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8"); 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		User2 user2= new User2(id, pw, name, email, phone);
		
		ServletContext application = getServletContext();
		application.setAttribute("user2",user2); //뒤의 user2객체를, 암의 user2라는 변수에 저장 
//		ServletContext context = getServletContext();
//		context.setAttribute("user2",user2); //뒤의 user2객체를, 암의 user2라는 변수에 저장 
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		out.println("<a href='/myjsp/day2/user2/user.jsp'> user.jsp로 이동 </a>");
					//   /경로.~~~를 해주어야지 localhost:port생략된다.
		out.close();
	}
}
