package HomeworkEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","credu","credu");
		System.out.print("접속했습니다.");

		String sql = "select PDSUBNAME, PDCOST, PDPRICE from PRODUCT"
		+" where pdcost > any (select pdcost from product where pdname='TV')"
		+" and pdcost < any (select pdcost from PRODUCT"
		+" where FACLOC='SEOUL'"
		+" where pdname='CELLPHONE') order by pdcost)";
		
		PreparedStatement pst=con1.prepareStatement(sql);
		
		ResultSet rs1= pst.executeQuery();
		
		while(rs1.next()){
			int PDCOST1= rs1.getInt("PDCOST"); 
			String PDSUBNAME1= rs1.getString("PDSUBNAME"); 
			int PDPRICE1= rs1.getInt("PDPRICE"); 
			
			System.out.print("\n"+PDSUBNAME1+"\t"+PDCOST1+"\t"+PDPRICE1);
			}
		
		con1.close(); 
		
	}
}
