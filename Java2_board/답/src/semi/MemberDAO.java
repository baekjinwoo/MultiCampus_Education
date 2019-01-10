package semi;

import java.sql.*;

import vo.BoardVO;
import vo.MemberVO;

public class MemberDAO {// DB���� �� ����.
	public void insetMember(MemberVO vo) { // BoardMember�� ���� �޼���
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String insertMemberSql = "insert into member values (?,?,?,?,?)";
			PreparedStatement insertMemberpt = con.prepareStatement(insertMemberSql);
			insertMemberpt.setString(1, vo.getId());
			insertMemberpt.setString(2, vo.getPwd());
			insertMemberpt.setString(3, vo.getMember_name());
			insertMemberpt.setString(4, vo.getEmail());
			insertMemberpt.setString(5, vo.getPhone());

			int resultRow = insertMemberpt.executeUpdate();
			System.out.println(resultRow + "�� �ԷµǾ����ϴ�");

			insertMemberpt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
