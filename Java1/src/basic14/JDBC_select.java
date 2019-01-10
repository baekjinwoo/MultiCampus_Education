package basic14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		System.out.println("시작");
		
		//select
		String sq12="select *from bowling"+" where name like ?";
		PreparedStatement pst=con1.prepareStatement(sq12);
		//pst.setString(1, "%"+"k"+"%");
		
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		pst.setString(1,"%"+s+"%"); 
		ResultSet rs2=pst.executeQuery();
		
		while(rs2.next()){
			String name3= rs2.getString("name"); //getString(2); 
			System.out.println(rs2.getRow()+"\t"+name3);
		}
		con1.close();
	}
}
