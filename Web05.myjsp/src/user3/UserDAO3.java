package user3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO3 {
	public String useDB3(User3 user){
		String result = "";
	   try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection
	    ("jdbc:oracle:thin:@127.0.0.1:1521:xe",
	    	"hr", "hr");
	    String sql1 = 
	    		"select * from member where id=?";
	    String sql2 = 
	    		"insert into member values(?,?,?,?,?)";
	    PreparedStatement pt = 
	    		con.prepareStatement(sql1);
	    pt.setString(1, user.getId());
	    ResultSet rs = pt.executeQuery();
	  
	    if(rs.next() == false){
	        PreparedStatement pt2 = 
	        		con.prepareStatement(sql2);
	        pt2.setString(1, user.getId());
	        pt2.setString(2, user.getName());
	        pt2.setString(3, user.getPw());
	        pt2.setString(4, user.getEmail());
	        pt2.setString(5, user.getPhone());
	        pt2.executeUpdate();
	        result = user.getId() +
	        		" 회원님 정상등록되었습니다";
	    }
	    else{
	    	result = user.getId()
	    	+ " 중복되었습니다. 새로 회원가입하세요.";
	    }

	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return result;
	}
}
