//UserServlet2 서블릿과 User.html 파일과 UserJdbc.java파일
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//추후 한글인코딩자리
		
		//선언
		String eid=request.getParameter("id");
		String ename=request.getParameter("name");
		String epw=request.getParameter("pw");
		String eemail=request.getParameter("email");
		String ephone=request.getParameter("phone");
		
		//인코딩
		response.setContentType("text/html; Charset=utf-8");
		
		
		//객체에 넣기
		User user =new User(eid, ename, epw, eemail, ephone);
		String result=new UserDAO().useDB(user);
		
		
		//출력객체
		PrintWriter out = response.getWriter();
		out.println(result);
	
	}
}
