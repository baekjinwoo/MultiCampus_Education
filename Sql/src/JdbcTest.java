import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest {
	public static void main(String[] args){
	//1.키보드 2자리 입력
		//int result = System.in.read(); 
		System.out.println("입력을 시작하세요(2자리 정수)");
		Scanner keyboard = new Scanner(System.in);  //'0'->48  'a'->97   'A'->65
		//06 -> "06"
		String year = keyboard.next();
		System.out.println(year);
									  
	//2.db 조회 검색
		
		//1. 연결 jdbc driver 호출 (ORACLE 11G: )
		//변하지않음
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    
		//2. DB연결
		// 데이터베이스가 있는 주소값(주고 받을수 있는)
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe" , "hr" , "hr");
			System.out.println("연결 성공적!!!");
		

		//3-1. SQL작성
		//키보드 입력 연도 입사 => 사원의 이름, 입사일 조회
		//String sql="  ";안의 내용을 2줄~3줄로 나눠쓸때는 띄어쓰기(공백)자리를 안띄웠는지를 필수로 확인할 것
		//String sql= "select first_name, hire_date from employees where hire_date like '06%' ";
		String sql= "select first_name, hire_date from employees where hire_date like ? ";
		
		//3-2. DB전송
		//select = executeQuery();
		//update, insert, delete = executeUpdate();
		
		//작성시 ?가 있으면 = PrepareStatement는 값을 전송할테니 받으라는 뜻
		//작성시 ?가 없으면 = Statement
		PreparedStatement pt = con.prepareStatement(sql);

		//?: 입력파라미터값 설정
		//키보드 입력2자리 숫자 입사년도
		
		pt.setString(1, year+"%"); //Sql이 완성이 되었고 ?안에 전송시킬 값. 자바에서는 ""를 쓴다. 
		ResultSet rs= pt.executeQuery();
		
		//4. SQL실행결과 리턴 & //5. 조회
		//주어진 sql문에 첫번째 문장을 읽어와라
		while(rs.next()==true){
			String name= rs.getString("first_name");
			String hiredate= rs.getString("hire_date");
			//java.sql.Data rs.getString("Hire_date");
			System.out.println(name + ":" + hiredate);
		}
		
		//6. DB 연결해제
		con.close();
		
		}//try-end
		catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
