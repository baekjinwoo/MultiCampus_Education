package semi;

import java.sql.*;

import vo.BoardVO;

public class BoardDAO {
	// 게시물 등록 sql
	// 회원가입 sql
	public int count = 0;

	public void contentsWrite(BoardVO bvo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("연결 성공적!");

			String selectsql = "select id from member where id = ?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, bvo.getWriter());
			ResultSet rs = selectpt.executeQuery();
			if (!rs.next()) {// 존재
				System.out.println("회원 가입이 필요합니다.");
			} else {
				String insertMemberSql = "insert into board values (?,?,?,sysdate,?,board_pageview.nextval)";
				PreparedStatement insertMemberpt = con.prepareStatement(insertMemberSql);
				insertMemberpt.setString(1, bvo.getTitle());
				insertMemberpt.setString(2, bvo.getContents());
				insertMemberpt.setString(3, bvo.getWriter());
				insertMemberpt.setString(4, bvo.getPassword());

				int resultRow = insertMemberpt.executeUpdate();
				System.out.println(resultRow + "줄 입력되었습니다");
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
			System.out.println("연결 성공적!");

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
				System.out.println("번호  :  " + rownum + "    제목  :  " + title + "     작성자  :  " + writer);
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
			System.out.println("연결 성공적!");

			String insertBoardSql = "select title,writer from board" + " where title like ?" + " or contents like ?";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			insertBoardpt.setString(1, "%" + keyWord + "%");
			insertBoardpt.setString(2, "%" + keyWord + "%");

			ResultSet rs = insertBoardpt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				System.out.println("제목 : " + title + "    작성자  : " + writer);
			}
			if (rs.next()) {
			} else {
				System.out.println("검색 결과가 없습니다.");
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
			System.out.println("연결 성공적!");

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
				System.out.println("제목 : " + title + "    작성자  : " + writer + "    내용  : " + contents  + "    시간  : " + writedate  + "    조회수  : " + pageview );
			}
			if (rs.getRow() == 0) {
				System.out.println("검색 결과가 없습니다.");
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
			System.out.println("연결 성공적!");

			String insertBoardSql = "select title,writer from board where writer = ?";

			PreparedStatement insertBoardpt = con.prepareStatement(insertBoardSql);

			insertBoardpt.setString(1, writer);

			ResultSet rs = insertBoardpt.executeQuery();

			if (rs.next()) {
				while (rs.next()) {
					String title = rs.getString("title");
					String writer0 = rs.getString("writer");
					System.out.println("제목 : " + title + "    작성자  : " + writer0);
				}
			} else {
				System.out.println("작성한 글이 없습니다.");
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
			System.out.println("연결 성공적!");

			String updatesql = "update board set title = ?, contents = ?  where password = ?";
			PreparedStatement updatept = con.prepareStatement(updatesql);
			updatept.setString(1, bvo.getTitle());
			updatept.setString(2, bvo.getContents());
			updatept.setString(3, bvo.getPassword());

			int resultRow = updatept.executeUpdate();
			if (resultRow == 0) {
				System.out.println("비밀번호가  틀렸습니다. 다시 시도해 주세요");
			} else {
				System.out.println("수정이 완료되었습니다.");
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
			System.out.println("연결 성공적!");

			String deletesql = "delete from board where password = ?";
			PreparedStatement deletept = con.prepareStatement(deletesql);
			deletept.setString(1, password);

			int resultRow = deletept.executeUpdate();
			if (resultRow == 0) {
				System.out.println("비밀번호가  틀렸습니다. 다시 시도해 주세요");
			} else {
				System.out.println("삭제가 완료되었습니다.");
			}

			deletept.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
