package share;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//application1.jsp�� application2.jsp�� ���� ����ؾߵ�.
public class ShareServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//��������: myjsp�ȿ������� ��� jsp�� ������ ������ �� �ִ�.
//�����Ⱓ: �����, tomcat������ ����ɋ����� ��� ����ȴ�. 
		
//���尴ü���⶧����, ���� (1)web.xml�����а�, (2)jsp�鰣�� ���������� �� �� �ִ�.   
	// application��ü�� ����ϱ����� Ÿ���� ServletContext�̱⶧���� ���� �������־���� setAttribute�Ͱ��� �޼����밡��
		
		
		//JSP���� �������� application�� ���� ����ؾߵǴ� ��.
		ServletContext application = getServletContext();
		
		//share�� �ҷ�����! (������� application1.jsp => application2.jsp => ShareServlet.java)
		Object share = application.getAttribute("share");
		application.setAttribute("share",((Integer)share)+1000);
		
	
		response.setContentType("text/html; utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>"+application.getAttribute("share")+"</h3>");
	
	
	}
}
