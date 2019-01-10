package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BoardVO;

public class BoardDAO { // 게시물 등록

	public int insertBoard(BoardVO vo) throws ClassNotFoundException {
		int cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");

			String selectsql = "select id from member where id = ?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, vo.getWriter());
			ResultSet rs = selectpt.executeQuery();

			if (rs.next()) {
				String insertsql = "insert into board values(board_seq.nextval,?,?,?,sysdate,?,0)";
				PreparedStatement insertpt = con.prepareStatement(insertsql);
				insertpt.setString(1, vo.getTitle());
				insertpt.setString(2, vo.getContents());
				insertpt.setString(3, vo.getWriter());
				insertpt.setString(4, vo.getPw());

				cnt = insertpt.executeUpdate();
			} else {
				cnt = -1;
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	public ArrayList<BoardVO> getBoardList(String result) throws ClassNotFoundException {
		ArrayList<BoardVO> al = new ArrayList<BoardVO>();

		char c = result.charAt(0);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");

			String sql = "";
			PreparedStatement pt = null;

			if (Character.isDigit(c) == true) {
				int n = Integer.parseInt(result);

				// String sql = "select * from board where seq >= ? and seq <=
				// ?";
				sql = "select seq, title, writer from (select rownum r, seq, title, writer from (select * from board order by time desc)) where r >= ? and r <= ?";

				pt = con.prepareStatement(sql);
				pt.setInt(1, 3 * n - 2);
				pt.setInt(2, 3 * n);
			} else {
				sql = "select seq, title, writer from board where title like ? or contents like ? or writer like ?";
				pt = con.prepareStatement(sql);
				pt.setString(1, "%" + result + "%");
				pt.setString(2, "%" + result + "%");
				pt.setString(3, "%" + result + "%");
			}

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				int seq = rs.getInt(1);
				String title = rs.getString(2);
				// String contents = rs.getString(3);
				String writer = rs.getString(3);
				// String time = rs.getString(5);
				// String pw = rs.getString(6);
				// int viewcount = rs.getInt(7);
				BoardVO vo = new BoardVO(seq, title, writer);
				al.add(vo);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public BoardVO getBoard(int seq) throws ClassNotFoundException {
		BoardVO vo = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");

			String cntsql = "update board set viewcount = (select viewcount from board where seq = ?)+1 where seq = ?";
			PreparedStatement cntpt = con.prepareStatement(cntsql);
			cntpt.setInt(1, seq);
			cntpt.setInt(2, seq);
			cntpt.executeUpdate();

			String sql = "select * from board where seq = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, seq);

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				int seq1 = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				String writer = rs.getString(4);
				String time = rs.getString(5);
				String pw = rs.getString(6);
				int viewcount = rs.getInt(7);
				vo = new BoardVO(seq1, title, contents, writer, time, pw, viewcount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;

	}

	public int UpdateBoard(BoardVO vo) throws ClassNotFoundException {

		int result = 0;
		String dbpw = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");

			int seq = vo.getSeq();
			String title = vo.getTitle();
			String contents = vo.getContents();
			String writer = vo.getWriter();
			String pw = vo.getPw();

			String pwsql = "select pw from board where seq = ?";
			PreparedStatement pwpt = con.prepareStatement(pwsql);
			pwpt.setInt(1, seq);
			ResultSet pwrs = pwpt.executeQuery();

			while (pwrs.next()) {
				dbpw = pwrs.getString(1);
			}

			dbpw = dbpw.trim();

			if (pw.equals(dbpw)) {
				if (!title.equals("")) {
					String titlesql = "update board set title = ? where seq = ?";
					PreparedStatement titlept = con.prepareStatement(titlesql);
					titlept.setString(1, title);
					titlept.setInt(2, seq);
					result = titlept.executeUpdate();
				}

				if (!contents.equals("")) {
					String contentssql = "update board set contents = ? where seq = ?";
					PreparedStatement contentspt = con.prepareStatement(contentssql);
					contentspt.setString(1, contents);
					contentspt.setInt(2, seq);
					result = contentspt.executeUpdate();
				}

				if (!writer.equals("")) {
					String writersql = "update board set writer = ? where seq = ?";
					PreparedStatement writerpt = con.prepareStatement(writersql);
					writerpt.setString(1, writer);
					writerpt.setInt(2, seq);
					result = writerpt.executeUpdate();
				}

			} else {
				result = 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public int DeleteBoard(BoardVO vo) throws ClassNotFoundException {

		int result = 0;
		String dbpw = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1 :1521:xe", "hr", "hr");

			int seq = vo.getSeq();
			String pw = vo.getPw();

			String pwsql = "select pw from board where seq = ?";
			PreparedStatement pwpt = con.prepareStatement(pwsql);
			pwpt.setInt(1, seq);
			ResultSet pwrs = pwpt.executeQuery();

			while (pwrs.next()) {
				dbpw = pwrs.getString(1);
			}

			dbpw = dbpw.trim();

			if (pw.equals(dbpw)) {

				String sql = "delete board where seq = ?";
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setInt(1, seq);
				result = pt.executeUpdate();
			} else {
				result = 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
