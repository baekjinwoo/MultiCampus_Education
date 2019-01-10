//servlet과제2. 
/*String [] inform= 
{"java", "홍길동", "1234", "010-666-7777", "123@zzz.com"};
id   이름   암호  폰번호 이메일
===> User 객체 생성(변수, 생성자, setter/getter...)
===> User.toString() 호출 결과 브라우저 출력
id:java 
name:홍길동 
폰번호: 010-666-7777 
이메일:123@zzz.com

1. test.UserServlet 클래스 이름
2. http://ip:port/프로젝트명/member 
3. 출력
*/

package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class User{
	String id;
	String name;
	String phone;
	String email;
	
	public User() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "id:" + id +"<br>"
			  +"name:" + name +"<br>"
			  +"폰번호:" + phone +"<br>"
			  +"이메일:" + email; 
	}
}

public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String [] inform= {"java", "홍길동", "1234", "010-666-7777", "123@zzz.com"};
		User user=new User();
		user.setId(inform[0]);
		user.setName(inform[1]);
		user.setPhone(inform[3]);
		user.setEmail(inform[4]);
		
		PrintWriter out=response.getWriter();
		out.print(user.toString()+"<br>");  //toString을 브라우저로 출력할떄는 개행:"<br>"
		//System.out.println(user.toString());  //toString을 콘솔로 출력할떄는 개행:"\n"
	}
}


//===> User.toString() 호출 결과 브라우저 출력
