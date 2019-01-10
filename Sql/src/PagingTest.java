import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PagingTest {
	public static void main(String[] args) {

		System.out.println("페이지번호를 입력하세요 (5개씩 보여드립니다)");
		Scanner sc = new Scanner(System.in);
		int pagenum = sc.nextInt();
		//조회페이지를 입력하세요 2(6~10);

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			String sql = "select r, first_name, hire_date "
					+ "from(select rownum r, first_name, hire_date "
					+ "from (select * from employees order by hire_date)) "
					+ "where r>=? and r<=?";
			
			//Sql 저장 전송 객체 생성 (PreparedStatement 타입, pt 변수)
			//sql ?값 (=입력파라미터값) 설정
			PreparedStatement pt = con.prepareStatement(sql);
			int start = (pagenum-1)*5+1; //6을 선택시 2페이지 (6~10)
			int end = pagenum*5;
			
			pt.setInt(1, start);
			pt.setInt(2, end);
			//select sql(결과 리턴: 테이블)실행
			ResultSet rs = pt.executeQuery();
			
			//결과조회
			while(rs.next()){ //다음레코드 이동 (t/f) 또는 ResultSet 데이터가 있는만큼 반복하시오
				int rownum = rs.getInt("r");
				String name = rs.getString("first_name");
				String hiredate = rs.getString("hire_date");
				
				System.out.println(rownum+":"+name+":"+hiredate);
			}
			rs.close();
			pt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
