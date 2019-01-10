
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//출력 (실행시, 브라우저를 미리 닫아줄 것)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); //빼고
		
		//http:////?id=test&pw=1234의 두 파라미터를 만들어서
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		//같은 패키지안의 LoginVO클래스 객체 생성를 만들어서 그 안에 저장
		// vo 객체: 세션 저장
		LoginVO vo = new LoginVO();
		vo.setId(id);
		vo.setPw(pw);
		
		//1. 클라이언트 이전 요청 있을떄, 세션id 존재하면 세션id-세션정보 객체생성
		//2. 클라이언트 이전 요청 없을때, 세션id 존재않으면 empty세션 객체생성

		HttpSession session = request.getSession();
		
		boolean condition=	session.getAttribute("sessionvo")!=null;
			if(condition==true){
			LoginVO v= (LoginVO)session.getAttribute("sessionvo");
			if(v.getId()!=null && v.getId().equals(request.getParameter("id"))){
			out.println("<h1>이미 로그인하셨습니다. 로그아웃하겟습니까?</h1>");
			}
			else{ //로그인 id 이전과 다를때
				session.setAttribute("sessionvo", vo);//세션에 넣고
				LoginVO login = (LoginVO)session.getAttribute("sessionvo");
				out.println("<h1>입력한 아이디는"+ login.getId()
							+ " 비밀번호는"+ login.getPw()+ "입니다</h1>");
			}
		}
			else{
		session.setAttribute("sessionvo", vo);//세션에 넣고
		LoginVO login = (LoginVO)session.getAttribute("sessionvo");
		out.println("<h1>입력한 아이디는"+ login.getId()
					+ " 비밀번호는"+ login.getPw()+ "입니다</h1>");
		}
	}
}
