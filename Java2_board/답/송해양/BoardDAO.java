package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BoardVO;
import vo.MemberVO;

public class BoardDAO {
	// 게시물 등록 sql
	// 회원가입 sql
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		try {
			/* MemberVO vo = new MemberVO(); */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "insert into member values( ?, ?, ?, ?, ? )";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPw());
			pt.setString(3, vo.getMember_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone());

			cnt = pt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return cnt;
	} // insertmember

	public int insertBoard(BoardVO vo) {
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select id from member where id = ? ";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, vo.getWriter());
			ResultSet rs = selectpt.executeQuery();
			if (!rs.next()) { // 존재x
				// 작업
				cnt = -1;
			} else {
				String insertsql = "insert into board values( board_sequence.nextval, ?, ?, ?, sysdate, ?, 0 )";
				PreparedStatement insertpt = con.prepareStatement(insertsql);
				insertpt.setString(1, vo.getTitle());
				insertpt.setString(2, vo.getMain());
				insertpt.setString(3, vo.getWriter());
				insertpt.setString(4, vo.getPw());
				cnt = insertpt.executeUpdate();
			} // else
			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return cnt;
	} // insertBoard

	public ArrayList<BoardVO> getBoardList(String condition) {
		ArrayList<BoardVO> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			String selectsql = "";
			PreparedStatement selectpt = null;
			// condition 첫문자 숫자
			if (condition.charAt(0) >= '1' && condition.charAt(0) <= '9') {
				selectsql = "select num, title, writer from(select rownum r, num, title, writer from (select * from board order by w_time desc)) where r >= ? and r <= ?";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setInt(1, (Integer.parseInt(condition) - 1) * 3 + 1);
				selectpt.setInt(2, Integer.parseInt(condition) * 3);
			} else {
				selectsql = "select num, title, writer from board where title like ? or main like ? or writer like ? ";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setString(1, "%" + condition + "%");
				selectpt.setString(2, "%" + condition + "%");
				selectpt.setString(3, "%" + condition + "%");
			}

			ResultSet rs = selectpt.executeQuery();
			while (rs.next()) { // 레코드 이동
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				list.add(vo);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return list;
	} // getBoardList

	public BoardVO getBoard(int num) {
		BoardVO vo = new BoardVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String seqsql = "update board set n_view = n_view + 1 where num =  ? ";
			PreparedStatement seqpt = con.prepareStatement(seqsql);
			seqpt = con.prepareStatement(seqsql);
			seqpt.setInt(1, num);
			int seq = 0;
			seq = seqpt.executeUpdate();

			String selectsql = "select num, title, main, writer, w_time, n_view from board where num = ? ";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, num);

			ResultSet rs = selectpt.executeQuery();
			rs.next();
			int number = rs.getInt("num");
			String title = rs.getString("title");
			String main = rs.getString("main");
			String writer = rs.getString("writer");
			String w_time = rs.getString("w_time");
			int n_view = rs.getInt("n_view");
			vo.setNum(number);
			vo.setTitle(title);
			vo.setMain(main);
			vo.setWriter(writer);
			vo.setW_time(w_time);
			vo.setN_view(n_view);

			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return vo;
	} // getBoard

	/*
	 * 1. 입력 글암호 : db 저장 글암호 비교 같으면 update 같지 않으면 0 리턴 }
	 */
	public int updateBoard(int num, BoardVO vo) {
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select pw from board where num = ? ";
			PreparedStatement selectept = con.prepareStatement(selectsql);
			selectept.setInt(1, num);
			ResultSet rs = selectept.executeQuery();
			if (!rs.next()) { // 존재x
				// 작업
				cnt = -1;
			} else {
				String updatesql = "update board set title = ?, main = ?, writer = ? where num = (select num from board where pw = ?) ";
				PreparedStatement updatept = con.prepareStatement(updatesql);
				updatept.setString(1, vo.getTitle());
				updatept.setString(2, vo.getMain());
				updatept.setString(3, vo.getWriter());
				updatept.setString(4, vo.getPw());
				cnt = updatept.executeUpdate();
			} // else
			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return cnt;

	}

	public int deleteBoard(int num, int del) {
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select pw from board where num = ? ";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, num);
			ResultSet rs = selectpt.executeQuery();
			
			if (!rs.next()) {
				cnt = -1;
			} else {
				String deletesql = "delete board where pw = ? ";
				PreparedStatement deletept = con.prepareStatement(deletesql);
				deletept.setInt(1, del);
				cnt = deletept.executeUpdate();
			} // else
			con.close();
		} catch (Exception e) {
			// TODO: handle finally clause
			e.printStackTrace();
		} // catch
		return cnt;
	} // deleteBoard
	
} // class