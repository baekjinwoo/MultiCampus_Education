package semi;

import java.sql.*;

import vo.BoardVO;

public class BoardDAO {
	// �Խù� ��� sql
	// ȸ������ sql
	public int count = 0;

	public void contentsWrite(BoardVO bvo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String selectsql = "select id from member where id = ?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, bvo.getWriter());
			ResultSet rs = selectpt.executeQuery();
			if (!rs.next()) {// ����
				System.out.println("ȸ�� ������ �ʿ��մϴ�.");
			} else {
				String insertMemberSql = "insert into board values (?,?,?,sysdate,?,board_pageview.nextval)";
				PreparedStatement insertMemberpt = con.prepareStatement(insertMemberSql);
				insertMemberpt.setString(1, bvo.getTitle());
				insertMemberpt.setString(2, bvo.getContents());
				insertMemberpt.setString(3, bvo.getWriter());
				insertMemberpt.setString(4, bvo.getPassword());

				int resultRow = insertMemberpt.executeUpdate();
				System.out.println(resultRow + "�� �ԷµǾ����ϴ�");
				insertMemberpt.close();
			}

			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pageview(int page) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String insertBoardSql = "select r,title,writer " + " from (select rownum r, title, writer"
					+ " from (select * from board))" + " where r >= ? and r <= ? ";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			int start = (page - 1) * 3 + 1;
			int end = page * 3;
			insertBoardpt.setInt(1, start);
			insertBoardpt.setInt(2, end);

			ResultSet rs = insertBoardpt.executeQuery();

			while (rs.next()) {
				int rownum = rs.getInt("r");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				System.out.println("��ȣ  :  " + rownum + "    ����  :  " + title + "     �ۼ���  :  " + writer);
			}
			rs.close();
			insertBoardpt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void search(String keyWord) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String insertBoardSql = "select title,writer from board" + " where title like ?" + " or contents like ?";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			insertBoardpt.setString(1, "%" + keyWord + "%");
			insertBoardpt.setString(2, "%" + keyWord + "%");

			ResultSet rs = insertBoardpt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				System.out.println("���� : " + title + "    �ۼ���  : " + writer);
			}
			if (rs.next()) {
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
				count++;
			}

			rs.close();
			insertBoardpt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detailView(String detail){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String insertBoardSql = "select title,writer,contents, writedate"
					+ " ,pageview from board where title = ?";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			insertBoardpt.setString(1, detail);

			ResultSet rs = insertBoardpt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				String writedate = rs.getString("writedate");
				int pageview = rs.getInt("pageview");
				System.out.println("���� : " + title + "    �ۼ���  : " + writer + "    ����  : " + contents  + "    �ð�  : " + writedate  + "    ��ȸ��  : " + pageview );
			}
			if (rs.getRow() == 0) {
				System.out.println("�˻� ����� �����ϴ�.");
				count++;
			}

			rs.close();
			insertBoardpt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void searchForUpdate(String writer) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String insertBoardSql = "select title,writer from board where writer = ?";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			insertBoardpt.setString(1, writer);

			ResultSet rs = insertBoardpt.executeQuery();

			if (rs.next()) {
				while (rs.next()) {
					String title = rs.getString("title");
					String writer0 = rs.getString("writer");
					System.out.println("���� : " + title + "    �ۼ���  : " + writer0);
				}
			} else {
				System.out.println("�ۼ��� ���� �����ϴ�.");
				count++;
			}

			rs.close();
			insertBoardpt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(BoardVO bvo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String updatesql = "update board set title = ?, contents = ?  where password = ?";
			PreparedStatement updatept = con.prepareStatement(updatesql);
			updatept.setString(1, bvo.getTitle());
			updatept.setString(2, bvo.getContents());
			updatept.setString(3, bvo.getPassword());

			int resultRow = updatept.executeUpdate();
			if (resultRow == 0) {
				System.out.println("��й�ȣ��  Ʋ�Ƚ��ϴ�. �ٽ� �õ��� �ּ���");
			} else {
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}

			updatept.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("���� ������!");

			String deletesql = "delete from board where password = ?";
			PreparedStatement deletept = con.prepareStatement(deletesql);
			deletept.setString(1, password);

			int resultRow = deletept.executeUpdate();
			if (resultRow == 0) {
				System.out.println("��й�ȣ��  Ʋ�Ƚ��ϴ�. �ٽ� �õ��� �ּ���");
			} else {
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}

			deletept.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
