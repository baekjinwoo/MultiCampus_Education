package basic14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_updatedelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		System.out.print("시작");
				
		//update
		String sq12="update teltable5 set tel2=? where name2=?";
		PreparedStatement pst=con1.prepareStatement(sq12);
				
		pst.setString(1, "010-0000-0000");
		pst.setString(2, "do"); 
			
		int updateRow = pst.executeUpdate();
		System.out.println(updateRow+"행 수정완료");
				
			
		//delete
		String sq13="delete teltable5 where name2=?";
		PreparedStatement pst2=con1.prepareStatement(sq13);
		pst2.setString(1, "do"); 
			
		int deleteRow=pst2.executeUpdate();
		System.out.println(deleteRow+"행 삭제완료");			
			
		con1.close();
	}
}
