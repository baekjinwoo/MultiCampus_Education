package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BoardVO;
import vo.MemberVO;

public class BoardDAO {

	public int deleteBoard(int numberr, int del) {

		int n = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sqsql = "select pass from board where numberr = ?";
			PreparedStatement selectpts = con.prepareStatement(sqsql);
			selectpts.setInt(1, numberr);
			ResultSet rs = selectpts.executeQuery();
		
			
			if (!rs.next()) {
				n=-1;
				System.out.println(n);
			}else{                           //이거는 위에 패스워드가 맞다면을 뜻한다.
				String sqsql1 = "delete board where pass = ?";
				PreparedStatement selectpts1 = con.prepareStatement(sqsql1);

				selectpts1.setInt(1, del);

				n = selectpts1.executeUpdate();


			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;

	}

	public int updateBoard(BoardVO vo) {

		int n = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sqsql = "select pass from board where numberr = ?";
			PreparedStatement selectpts = con.prepareStatement(sqsql);
			selectpts.setInt(1, vo.getNumberr());
			ResultSet rs = selectpts.executeQuery();
			rs.next();
			rs.getString("pass");

			if (vo.getPass().equals(rs.getString("pass"))) {
				/*
				 * System.out.println(vo.getPass());
				 * System.out.println(rs.getString("pass"));
				 */
				String sqsql1 = "update board set title = ?, story = ?, writer = ? where pass = ?";
				PreparedStatement selectpts1 = con.prepareStatement(sqsql1);

				selectpts1.setString(1, vo.getTitle());
				selectpts1.setString(2, vo.getStory());
				selectpts1.setString(3, vo.getWriter());
				selectpts1.setString(4, vo.getPass());

				n = selectpts1.executeUpdate();

				System.out.println(n);

			} else {
				n = -1;
				System.out.println("실행이 불가합니다.");
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;

	}

	// 게시물 상세조회

	public BoardVO getBoard(int numberr) {

		BoardVO vo = new BoardVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sqsql = "update board set vieww = vieww+1 where numberr = ?";
			PreparedStatement selectpts = con.prepareStatement(sqsql);

			selectpts.setInt(1, numberr);

			String selectsql1 = "select numberr, title, story, writer, timee, vieww from board where numberr = ?";

			PreparedStatement selectpt = con.prepareStatement(selectsql1);

			selectpt.setInt(1, numberr);

			ResultSet rs = selectpt.executeQuery();
			rs.next();

			vo.setNumberr(rs.getInt("numberr"));
			vo.setTitle(rs.getString("title"));
			vo.setStory(rs.getString("story"));
			vo.setWriter(rs.getString("writer"));
			vo.setTimee(rs.getString("timee"));
			vo.setVieww(rs.getInt("vieww"));

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;

	}

	// 게시물 조회
	public ArrayList<BoardVO> getBoardList(String condition) {

		ArrayList<BoardVO> blist = new ArrayList<>(); // 자동으로 3개씩 늘어난다.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "";
			PreparedStatement selectpt = null;

			// select r, seq, title, writer from (select rownum r, seq, title,
			// writer from (select * from board order by time desc)) where r >=
			// ? and r <=?;
			// (페이지번호-1) *3 +1
			if (condition.charAt(0) >= '1' && condition.charAt(0) <= '9') {
				selectsql = "select numberr, title, writer from (select rownum r, numberr, title, writer from (select * from board order by timee desc)) where r >= ? and r <= ?";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setInt(1, (Integer.parseInt(condition) - 1) * 3 + 1);
				selectpt.setInt(2, (Integer.parseInt(condition) * 3));

			} else {
				selectsql = "select numberr, title, writer from board where title like ? or story like ? or writer like ?";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setString(1, "%" + condition + "%");
				selectpt.setString(2, "%" + condition + "%");
				selectpt.setString(3, "%" + condition + "%");

			}

			ResultSet rs = selectpt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNumberr(rs.getInt("numberr"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				blist.add(vo);
				// list에 담아야한다.
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blist;
	} // getBoardList method

	public int insertBoard(BoardVO vo) { // 회원가입 sql

		int n = 0;

		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select id from member where id = ? "; // 키보드로 받아오는
																	// 거 확인

			PreparedStatement selectpst = con.prepareStatement(selectsql);

			selectpst.setString(1, vo.getWriter()); // 회원가입이 되어있냐 확인

			ResultSet rs = selectpst.executeQuery();

			if (!rs.next()) { // 존재하지 않는다면,

				n = -1; // 메인에서 이게 만약에 -1 라고 물어보면, 회원가입부터 먼저 하세요.

			} else {
				String insertsql = "insert into board values(board_sequence.nextval,?,?,?,sysdate,?,0)";

				PreparedStatement insertpst = con.prepareStatement(insertsql);

				insertpst.setString(1, vo.getTitle());
				insertpst.setString(2, vo.getStory());
				insertpst.setString(3, vo.getWriter());
				insertpst.setString(4, vo.getPass());

				n = insertpst.executeUpdate();
			} // else
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return n;
	} // insert 멤버

	public int insertMember(MemberVO vo) { // 회원가입 sql

		int n = 0;

		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "insert into member values(?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			pst.setString(3, vo.getMember_name());
			pst.setString(4, vo.getEmail());
			pst.setString(5, vo.getPhone());

			n = pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return n;
	} // insert 멤버
}
