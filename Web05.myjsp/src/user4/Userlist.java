package user4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Userlist extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	//String id= request.getParameter("id");
	//if(id.equals("admin")){
	//id가 admin일떄는 ? 위치변경.
		UserDAO4 dao = new UserDAO4();
		ArrayList<User4> userlist= dao.getUserList();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/user4/userlist.jsp");
		request.setAttribute("list", userlist);
		dispatcher.forward(request, response);
	//}
}
}
