import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 jdbc 프로그램
1. 키보드 입력
사원명 : xxxx
급여 : xxx
전화번호: xxx
부서 : xxxx

2. c_emp테이블에 저장 (사번, 사원명, 입사일, 급여, 전화번호, 부사코드)
사번: c_emp_id_seq값 활용
입사일: 오늘 날짜
전화번호: 010- 앞 포함
부서명을 c_dept조회하여 부서코드값 
 */

public class Company {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사원명: ");
		String name = sc.next();
		System.out.print("급여 (10,000이상): ");
		int salary= sc.nextInt();
		System.out.print("전화번호 (010-빼고): ");
		String phone = sc.next();
		System.out.print("부서 (총무부,인사부,신사업부,전산부,개발부): ");
		String divi_name = sc.next();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe" , "hr" , "hr");
			String sql= "insert into c_emp values(c_emp_id_seq.nextval, ?,sysdate,?,?,"
					+ "(select d_id from c_dept where d_name = ?))";
			
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1,name);
			pt.setInt(2,salary);
			pt.setString(3,"010-"+phone);
			pt.setString(4,divi_name);

			int insertRow=pt.executeUpdate();
			System.out.println(insertRow+"행 삽입"); //실행결과 화면에 출력
		
			pt.close();
			con.close();
			
		} catch (ClassNotFoundException e) { e.printStackTrace(); } 
		  catch (SQLException e) { e.printStackTrace(); }

		
		
		
		
	}
}
