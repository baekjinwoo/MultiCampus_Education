package HomeworkEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//insert into DISCARDED_PRODUCT (select PDNO,PDNAME,PDSUBNAME,FACTNO,PDDATE,PDCOST,PDPRICE,PDAMOUNT,sysdate 
//from PRODUCT
//where FACTNO in(select FACTNO
//                        from FACTORY 
//                        where FACLOC='CHANGWON'));

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","credu","credu");
		System.out.print("접속했습니다\n");

		String sql = "select pdname, pdsubname,facname,STONAME,STAMOUNT" //STAMOUNT원래 코드를 수정함
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
			String stamount1= rs1.getString("STAMOUNT"); 
			
			System.out.print(pdname1+"\t"+pdsubname1+"\t"+facname1+"\t"+stamount1);
			System.out.println();
			}
		
		con1.close(); 
		
		
		
	}
}
