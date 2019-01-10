package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	public boolean getMember(String id, String pw) throws Exception{
		boolean result = false;
		
		Context context = new InitialContext();
		Context current = (Context)context.lookup("java:/comp/env");		
		DataSource conpool=(DataSource)current.lookup("jdbc/myoracle");
		Connection con = conpool.getConnection();
		String sql = 
		"select id, pw from member where id=?";
		PreparedStatement pt = 
				con.prepareStatement(sql);
		pt.setString(1, id);
		ResultSet rs = pt.executeQuery();
		if(rs.next()){
			result = rs.getString("pw").equals(pw);
		}
		con.close();
		return result;
	}
	public ArrayList<MemberVO> getUserList(){
		ArrayList<MemberVO> list = 
				new ArrayList<MemberVO>();
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
	    while(rs.next() == true){//?뻾 ?씠?룞
	    	String id = rs.getString("id");
	    	String pw = rs.getString("pw");
	    	String name = rs.getString("member_name");
	    	String email = rs.getString("email");
	    	String phone = rs.getString("phone");
	    	MemberVO u = new MemberVO
	    	(id, name, pw, email, phone);
	    	list.add(u);
	    }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return list;
	}//getUserList end
	
	public String useDB(MemberVO user){
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
	    // id 議댁옱 ?뿬遺?
	  
	    if(rs.next() == false){//議댁옱x
	        PreparedStatement pt2 = 
	        		con.prepareStatement(sql2);
	        pt2.setString(1, user.getId());
	        pt2.setString(2, user.getName());
	        pt2.setString(3, user.getPw());
	        pt2.setString(4, user.getEmail());
	        pt2.setString(5, user.getPhone());
	        pt2.executeUpdate();
	        result = user.getId() +
	        		" ?쉶?썝?떂 ?젙?긽?벑濡앸릺?뿀?뒿?땲?떎";
	    }
	    else{//議댁옱o
	    	result = user.getId()
	    	+ " 以묐났?릺?뿀?뒿?땲?떎. ?깉濡? ?쉶?썝媛??엯?븯?꽭?슂.";
	    }

	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return result;
	}//useDB END
}
