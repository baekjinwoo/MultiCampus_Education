//PersonalInfoServlet.java 클래스의 서블릿과 PersonalInfo.html
//doGet으로 test하고 doPost로 최종완성

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalInfoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post로 사용할 경우 아래와 같은 파라미터들을 받기전에 한글인코딩을 한 번 해줘야한다.
		request.setCharacterEncoding("utf-8");
		
		
		//id, name, pw, gender,, job의 파라미터 : getParameter
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		String pw= request.getParameter("pw");
		String gender= request.getParameter("gender");
		String job= request.getParameter("job");

		// mailing(multiple: 복수개 선택) :getParameterValues()
		String mailing[]= request.getParameterValues("mailing");
		
		
		//회원정보 처리
		response.setContentType("text/html; Charset=utf-8"); //한글도 안깨지도록 사전에 등록
		
		PrintWriter out = response.getWriter();
		out.println("<h3>아이디:"+id+"</h3>");
		out.println("<h3>이름:"+name+"</h3>");
		out.println("<h3>암호:"+pw+"</h3>");
		out.println("<h3>성별:"+gender+"</h3>");
		out.println("<h3>직업:"+job+"</h3>");

		for(int i=0; i<mailing.length;i++){
			out.println("<h1>메일수신여부:"
						+ mailing[i] // getParameter('mailing')을 출력한다면 value=1값인 회사원만 반복으로 나온다.
						+"</h3>");	 //mailing[i]를 url로보면 mailing=~~~~&mailing=~~~~&와 같이 변수연결처럼 작성되있다.
		}
	}
}
