package HomeworkEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","credu","credu");
		System.out.print("접속했습니다.");

		String sql = "select pdname, pdsubname,facname,STONAME,nvl(STAMOUNT,0)"
		+" from PRODUCT join FACTORY using(FACTNO) "
		+" join STORE using(PDNO) "
		+" where FACLOC='SEOUL'"
		+" and (STAMOUNT is null or STAMOUNT=0)";
		
		PreparedStatement pst=con1.prepareStatement(sql);
		
		ResultSet rs1= pst.executeQuery();
		
		while(rs1.next()){
			String pdname1= rs1.getString("pdname"); 
			String pdsubname1= rs1.getString("pdsubname"); 
			String facname1= rs1.getString("facname"); 
			String stoname1= rs1.getString("STONAME"); 
			int stamount1= rs1.getInt("STAMOUNT"); 
			
			System.out.print("\n"+pdname1+"\t"+pdsubname1+"\t"+facname1+" "+stoname1+"  "+stamount1);
			}
		
		con1.close(); 
		

	}
}
