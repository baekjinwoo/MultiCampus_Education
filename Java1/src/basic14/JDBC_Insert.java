package basic14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//ResultSet r1=pst.executeQuery(); executeQuery() Select
// ResultSet r1=pst.executeUpdate(); Update, insert, delete

public class JDBC_Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		System.out.print("시작");
		
		String sq12="insert into teltable5 values(?,?,?,?)"; //id name tel d
		
		PreparedStatement pst=con1.prepareStatement(sq12);
		Scanner sc=new Scanner(System.in); // args[0]
		System.out.println("<ID>");
		String s1=sc.nextLine();
		int i1=Integer.parseInt(s1);
		
		pst.setInt(1, i1); 
		pst.setString(2, "do");
		pst.setString(3, "010-8877-9988");
		pst.setString(4, "2016-11-11"); //ORA-01861: literal does not match format string 
		int insertRow=pst.executeUpdate();
		System.out.println(insertRow+"삽입 완료");
	
		con1.close(); 
		
		
	}
}
