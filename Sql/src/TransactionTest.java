import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
// 없는 정보는 새롭게 삽입하고, 있는 내용은 아무리 넣어도 저장되지 않도록 rollback과 commit을 이용한 코드


public class TransactionTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // system.in (키보드)
		System.out.println("emp테이블에 저장할 값을 입력하세요(id, emp_name, salary순서로 입력하시오)");
		int id = sc.nextInt();
		String emp_name = sc.next(); //sc.nextLine은 안된다
		int salary = sc.nextInt();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			con.setAutoCommit(false); // 수동 트랜젝션처리 commit을 자동이아닌 fase수동모드로 해야지
										// rollback도 가능하다
			System.out.println(con.getAutoCommit());
			// select id from emp where id=?(300)
			// 키보드 300 조우빈 sysdate 50000
			// 존재한다 : rollback
			// 존재하지 않는다: commit

			String insertsql = "insert into emp values(?,?,sysdate,?)";

			PreparedStatement insertpt = con.prepareStatement(insertsql);
			insertpt.setInt(1, id);
			insertpt.setString(2, emp_name);
			insertpt.setInt(3, salary);

			// 설정 끝

			String selectsql = "select id from emp where id=?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, id);

			ResultSet rs = selectpt.executeQuery();
			int resultRow = insertpt.executeUpdate();

			if (rs.next()) {
				con.rollback();
			} else {
				con.commit();
			}

			con.rollback();
			System.out.println(resultRow + "개의 행 삽입");

			rs.close();
			selectpt.close();
			insertpt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
