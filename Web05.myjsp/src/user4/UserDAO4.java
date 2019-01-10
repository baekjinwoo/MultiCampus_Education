package user4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class UserDAO4 {
	public ArrayList<User4> getUserList(){
		ArrayList<User4> list = 
				new ArrayList<User4>();
	   try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection
	    ("jdbc:oracle:thin:@127.0.0.1:1521:xe",
	    	"hr", "hr");
	    String sql1 = 
	    "select * from member";
	    PreparedStatement pt = 
	    con.prepareStatement(sql1);
	    ResultSet rs = pt.executeQuery();
	    while(rs.next() == true){//행 이동
	    	String id = rs.getString("id");
	    	String pw = rs.getString("pw");
	    	String name = rs.getString("member_name");
	    	String email = rs.getString("email");
	    	String phone = rs.getString("phone");
	    	User4 u = new User4
	    	(id, name, pw, email, phone);
	    	list.add(u);
	    }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return list;
	}//getUserList end
	
	public String useDB(User4 user){
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
	    // id 존재 여부
	  
	    if(rs.next() == false){//존재x
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
	    else{//존재o
	    	result = user.getId()
	    	+ " 중복되었습니다. 새로 회원가입하세요.";
	    }

	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return result;
	}//useDB END
}
