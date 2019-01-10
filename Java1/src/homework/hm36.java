package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hm36 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	/* 문제. 
 	입사일이 2005년 이전에 입사하고 급여가 5000이상인 사원의 id, 이름, 입사일 ,급여를 출력하는 jdbc 프로그램을 작성하시오   
 	(and조건) db에서는 그냥 and
	*/
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr"); 
		
		String sql="select * from employees"+ " where salary>=5000 and hire_date<'2005-01-01'";
		Statement st2=con1.createStatement();
		ResultSet rs2= st2.executeQuery(sql);

		//(salary>=5000)and
			
		while(rs2.next()){ 
			int id=rs2.getInt("employee_id"); 
			String fname= rs2.getString("first_name"); 
			int salary= rs2.getInt("salary"); 
			String h_date=rs2.getString("hire_date"); 		
			String hire_date=h_date.substring(0, 10); //년월일만 substring사용해서 잘라서 출력
			//int aa= Integer.parseInt(hire_date);
										
			System.out.println(rs2.getRow()+id+"\t"+fname+"\t\t"+hire_date+"\t\t" + ""+salary+"\t");
		}
		con1.close();
		System.out.println("접속 끝");
	}
}
