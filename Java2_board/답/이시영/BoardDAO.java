package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BoardVO;
import vo.MemberVO;

public class BoardDAO {
	// 회원가입
	public int insertMember(MemberVO vo) {

		int cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "insert into member values(?,?,?,?,?)";

			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPassword());
			pt.setString(3, vo.getMember_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone());

			cnt = pt.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	} // InsertMember

	// 게시물 등록
	public int insertBoard(BoardVO vo) {

		int cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select id from member where id=?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, vo.getWmember());
			ResultSet rs = selectpt.executeQuery();

			if (!rs.next()) { // 존재X
				cnt = -1;
			} else {
				String insertsql = "insert into board values(board_num.nextval,?,?,?,sysdate,?,0)";
				PreparedStatement insertpt = con.prepareStatement(insertsql);

				insertpt.setString(1, vo.getTitle());
				insertpt.setString(2, vo.getText());
				insertpt.setString(3, vo.getWmember());
				insertpt.setString(4, vo.getPwd());

				cnt = insertpt.executeUpdate();
			} // else
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
		return cnt;
	}

	// 게시물 조회
	public ArrayList<BoardVO> getBoardList(String result) {

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = " ";
			PreparedStatement selectpt = null;

			if (result.charAt(0) >= '1' && result.charAt(0) <= '9') {
				selectsql = "select num, title, wmember from (select rownum r, num, title, wmember from (select * from board order by wtime desc)) where r >=? and r <=?";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setInt(1, ((Integer.parseInt(result) - 1) * 3) + 1);
				selectpt.setInt(2, Integer.parseInt(result) * 3);

			} else {
				selectsql = "select num, title, text, wmember from board where title like ? or text like ? or wmember like ?";
				selectpt = con.prepareStatement(selectsql);
				selectpt.setString(1, "%" + result + "%");
				selectpt.setString(2, "%" + result + "%");
				selectpt.setString(3, "%" + result + "%");

			}

			ResultSet rs = selectpt.executeQuery();

			while (rs.next()) { // 레코드 이동
				BoardVO vo = new BoardVO();

				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setWmember(rs.getString("wmember"));

				list.add(vo);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	// 상세 조회
	public BoardVO getBoard(int detail) {
		BoardVO vo = new BoardVO();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String updatesql = "update board set cnt=cnt+1 where num=?";
			PreparedStatement updatept = con.prepareStatement(updatesql);
			updatept.setInt(1, detail);
			int result = updatept.executeUpdate();

			String selectsql = "select * from board where num=?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, detail);
			ResultSet rs = selectpt.executeQuery();

			while (rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setText(rs.getString("text"));
				vo.setWmember(rs.getString("wmember"));
				vo.setWtime(rs.getString("wtime"));
				vo.setCnt(rs.getInt("cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 게시물 수정
	public int updateBoard(BoardVO vo) {
		int result=0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
					
			if(checkPw(vo.getNum(),vo.getPwd())==true) {
				String updatesql = " ";
				PreparedStatement updatept = null;
				
				if(!vo.getTitle().equals("")) {
					if(!vo.getText().equals("")) {
						if(!vo.getWmember().equals("")) {
							updatesql = "update board set title=?, text=?, wmember=? where num=?";
							updatept = con.prepareStatement(updatesql);
							updatept.setString(1, vo.getTitle());
							updatept.setString(2, vo.getText());
							updatept.setString(3, vo.getWmember());
							updatept.setInt(4, vo.getNum());
						}
						
						updatesql = "update board set title=?, text=? where num=?";
						updatept = con.prepareStatement(updatesql);
						updatept.setString(1, vo.getTitle());
						updatept.setString(2, vo.getText());
						updatept.setInt(3, vo.getNum());
					}
					
					updatesql = "update board set title=? where num=?";
					updatept = con.prepareStatement(updatesql);
					updatept.setString(1, vo.getTitle());
					updatept.setInt(2, vo.getNum());
			
				}
				
				result = updatept.executeUpdate();	
				
			} else {
				result = 0;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 게시물 삭제
	public int deleteBoard(int num, String pwd) {
		int result=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			
			if(checkPw(num,pwd)==true) {
				String deletesql = "delete from board where num=?";
				PreparedStatement deletept = con.prepareStatement(deletesql);
				deletept.setInt(1, num);
				
				result=deletept.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 비밀번호 확인
	public boolean checkPw(int num, String pwd) {
		boolean result=true;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select pwd from board where num=?";
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, num);
			ResultSet rs = selectpt.executeQuery();
			
			String check=null;
			
			while(rs.next()){
				check=rs.getString("pwd");
			}
			
			if(pwd.equals(check)) {
				result=true;
			} else {
				result=false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} return result;
	}

}
