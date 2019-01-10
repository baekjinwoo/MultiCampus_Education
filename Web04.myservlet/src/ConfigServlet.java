// web.xml안에 JDBC공통코드를 저장시키는 코드

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ConfigServlet extends HttpServlet {
	String driver, jdbcurl; //init에서 생성된 driver이 doGet에서도 쓸수있도록 지역변수
	public void init(ServletConfig config) throws ServletException { //init메서드는 출력할수없음. doGet만이 out.println을 쓸수있다.
		//db종류 다르다: web.xml에 1번저장하고, 빼내오도록!
		driver = config.getInitParameter("driver");
		jdbcurl = config.getInitParameter("jdbcurl");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName(driver); //driver값을 넣어주면된다.
			Connection con= DriverManager.getConnection(jdbcurl, "hr","hr");
			
		//제대로 만들어졌다면....connection 객체가 생겼는지를 테스트겸 출력해보자
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>"+con+"</h3>");
		out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


/*</servlet>
<servlet-mapping>
  <servlet-name>UserServlet3</servlet-name>
  <url-pattern>/user3</url-pattern>
</servlet-mapping>
<servlet>
  <description></description>
  <display-name>ConfigServlet</display-name>
  <servlet-name>ConfigServlet</servlet-name>
  <servlet-class>ConfigServlet</servlet-class>
   
   //web.xml안에서 넣어준 코드
    <init-param>
	  <param-name> driver </param-name>
	  <param-value> oracle.jdbc.driver.OracleDriver</param-value>
	  </init-param>
	  
	  <init-param>
	  <param-name> jdbcurl </param-name>
	  <param-value> jdbc:oracle:thin:@127.0.0.1:1521:xe </param-value>
	  </init-param>

</servlet>*/