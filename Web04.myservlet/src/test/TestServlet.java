//servlet 과제1 : 콘솔을이용해서 입력받은 아이디와 비밀번호가 배열에 있는 값이라면 ~~ 없는값이라면~~ 브라우저에 출력
/*id, password 입력 가정
String id="java";
String pw="servlet";
String ids[] = {"java", "servlet", "jsp", "jquery", "html"};
id와 pw 값들이 ids 배열 포함되어 있으면
id : xxxx , pw : xxxxx : 정상 로그인되었습니다
id와 pw 값들이 ids 배열 포함되어 있으면
id : xxxx , pw : xxxxx : 회원가입부터 하세요.

1. test.TestServlet 이름 정의
2. http://ip:port/프로젝트명/login
3. 출력 정상적 로그인 o 파랑색상
                      x 빨강색상
*/

package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력: "); String id=sc.next();
		System.out.print("비번 입력: "); String pw=sc.next();
		String ids[] = {"java", "servlet", "jsp", "jquery", "html"};
		
		PrintWriter out=response.getWriter();
		int sw=0;
		
		for(int i=0; i<ids.length;i++){
			for(int j=0; j<ids.length;j++){
				//System.out.println(id +","+ pw); 검토용
				//System.out.println(ids[i]); 검토용
				if(id.equals(ids[i])){
					if(pw.equals(ids[j])){
						out.println("<h1 style='color:blue'>"+"id: "+id+", pw: "+pw+" :정상 로그인되었습니다"+"</h1>");
						sw=1;
						break;
					}
				}
			}
		}
		if(sw==0){
		out.println("<h1 style='color:red'>"+"id: "+id+", pw: "+pw+" :회원가입부터 하세요"+"</h1>");
		}
	}
}


// 3. 출력 정상적 로그인 o 파랑색상
// x 빨강색상
