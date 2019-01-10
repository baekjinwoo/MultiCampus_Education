import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //변수이름결정되는 매개변수
			throws ServletException, IOException {
	
		//문제2. forwardServlet를 가지고 서블릿에서 forward를 이용하는 문제이다.
		// id의 값에 따라 admin.jsp로 갓다가, generaluser.jsp로 이동한다.
		
		String id = request.getParameter("id");
		String path="";
		if(id.equals("admin") || id.equals("administrator")){
			path= "/day3/forward/admin.jsp";  //경로를 꼭 이렇게 적어주지않으면 서블릿에서 jsp로 이동할 수 없다.
			}
		else if(id.equals("java") || id.equals("servlet") || id.equals("jsp") ){
			path="/day3/forward/generaluser.jsp";
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1> 해당 사용자는 우리 사이트를 ");
			out.print("이용하실 수 없습니다.</h1>");
			//path="/user.html";
		}
		// 하나하나 프로토콜 전송에 대한 웹 구현 복잡하기때문에 = 대신 tomcat 서버가 내부 클래스에 저장된 걸로 처리. 
		// tomcat 서버의 내부 클래스 객체 생성 (요청을 통해서)

		//다른 JSP를 호출하기위해 사용되는 requestdispatcher는 필시 dispatcher객체를 써야한다
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		String [] board = {"1:제목1:작성자1:1234:0", "2:제목2:작성자2:1234:11"," 3:제목3:작성자3:1234:5"};
		request.setAttribute("boardArray", board);
		dispatcher.forward(request, response);
		
//		C c1= new C();
//		I i1= new I(); //인터페이스는 추상적이기때문에 객체생성을 할 수 없다. 인터페이스를 상속받은 클래스는 반드시 override를 해야한다.
					   //여기서 new: 클래스 변수와 메서드 구현 메모리 복사
	}
}
