package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {
	
	public int insertMember(MemberVO vo) throws ClassNotFoundException{
		int rs = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");
			String sql = "insert into member values(?,?,?,?,?)";
			
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPw());
			pt.setString(3, vo.getMamber_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone());
			rs = pt.executeUpdate();
	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
