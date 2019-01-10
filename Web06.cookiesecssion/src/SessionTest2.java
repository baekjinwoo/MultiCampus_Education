import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//이미로그인 //(로그인아이디가 java 또는 spring일 떄만 아래항목을 보이도록 설정)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		/*
		 * http:,,,?id=test&pw=1234
		 * ==>두번쨰 id가 최초id(세션저장id) 동일하다면
		 * 이미 로그인하셨습니다. 출력하고
		 * 세션에 저장하지않는다.
		 * */
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionvo")!=null){
			LoginVO vo= (LoginVO)session.getAttribute("sessionvo");

//			if(first!=null){
//				if(first.equals(vo.getId())){
//					out.println("이미 로그인하셨습니다");
//				}
//			}

			if(vo.getId().equals("java") || vo.getId().equals("spring")){
				out.println("<h1>내 정보보기</h1>");
				out.println("<ol>회원 정보 수정</ol>");
				out.println("<li>암호변경</li>");
				out.println("<li>주문내역</li>");
				out.println("<li>베송확인</li>");
			}
			else{ 
				out.println("<h1>+"+vo.getId()+"님은 인증받은 아이디가 아닙니다.</h1>");
			}
		}
		else{ //로그인 한 적 없음
			out.println("<h1> 로그인부터 하세요");
		}
	
		
		//내정보보기 
		//1.회원정보수정
		//2.암호변경
		//3.주문내역
		//4.배송현황
	
	}
}
