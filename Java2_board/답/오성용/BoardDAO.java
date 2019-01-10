package sqlday7.jdcb.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	
	Connection con;
	PreparedStatement pst;
	
	public static Connection getConnection(){
		Connection tCon = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			tCon = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tCon;
	}
	
	public int insertMember(MemberVO mvo){
		int resultRow = 0;
		try {
			con = BoardDAO.getConnection();
			String insertSql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?)";
			pst = con.prepareStatement(insertSql);
			pst.setString(1, mvo.getId());
			pst.setString(2, mvo.getPwd());
			pst.setString(3, mvo.getMember_name());
			pst.setString(4, mvo.getEmail());
			pst.setString(5, mvo.getPhone());
			resultRow = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultRow;
	}
	
	public int insertBoard(BoardVO bvo){
		int resultRow = -1;
		try {
			con = BoardDAO.getConnection();
			String checkSql = "SELECT ID FROM MEMBER WHERE ID = ?";
			String insertSql = "INSERT INTO BOARD VALUES(BOARD_SEQUENCE.NEXTVAL, ?, ?, ?, SYSDATE, ?, 0)";
			
			pst = con.prepareStatement(checkSql);
			pst.setString(1, bvo.getWriter());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				pst = con.prepareStatement(insertSql);
				pst.setString(1, bvo.getTitle());
				pst.setString(2, bvo.getContents());
				pst.setString(3, bvo.getWriter());
				pst.setString(4, bvo.getPw());
				resultRow = pst.executeUpdate();
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultRow;
	}
	
	public ArrayList<BoardVO> getBoardList(String ptag){
		// 숫자변환가능 : 페이지 3개 목록
		// select, subquery, rownum
		// 문자 : 제목 내용 작성자 포함 select
		ArrayList<BoardVO> voList = new ArrayList<>();
		try {
			con = BoardDAO.getConnection();
			
			if(ptag.charAt(0) >= '0' && ptag.charAt(0) <= '9'){
				String selectSql = "SELECT * "
						+ " FROM (SELECT ROWNUM R_NUM, B.* "
						+ " FROM (SELECT * FROM BOARD ORDER BY SEQ) B)"
						+ " WHERE R_NUM BETWEEN ? AND ?";

				pst = con.prepareStatement(selectSql);
				int pageNum = Integer.parseInt(ptag);
				pst.setInt(1, 3*(pageNum-1) + 1);
				pst.setInt(2, 3*pageNum);
				
			} else {
				String selectSql = "SELECT ROWNUM, B.* FROM BOARD B"
						+ " WHERE INSTR(TITLE, ?) > 0 OR INSTR(CONTENTS, ?) > 0 OR INSTR(WRITER, ?) > 0";
				
				pst = con.prepareStatement(selectSql);
				pst.setString(1, ptag);
				pst.setString(2, ptag);
				pst.setString(3, ptag);
			}
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				voList.add(new BoardVO(rs.getInt(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voList;
	}
	
	public BoardVO getBoard(int seq){
		int resultRow = 0;
		BoardVO resultVO = null;
		try {
			con = BoardDAO.getConnection();
			String cntUpdateSql = "UPDATE BOARD SET VIEWCOUNT = ((SELECT VIEWCOUNT FROM BOARD WHERE SEQ = ?) + 1) WHERE SEQ = ?";
			pst = con.prepareStatement(cntUpdateSql);
			pst.setInt(1, seq);
			pst.setInt(2, seq);
			resultRow = pst.executeUpdate();
			if(resultRow == 0){
				System.out.println("ERROR : 해당 번호의 게시물이 존재하지 않습니다.");
				return resultVO;
			}
			
			String deselSql = "SELECT SEQ, TITLE, CONTENTS, TIME, WRITER, VIEWCOUNT FROM BOARD WHERE SEQ = ?";
			
			pst = con.prepareStatement(deselSql);
			pst.setInt(1, seq);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				resultVO = new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), null, rs.getInt(6)); 
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultVO;
	}
	
	public int updateBoard(BoardVO vo){
		int resultRow = 0;
		try {
			con = BoardDAO.getConnection();
			if((vo.getTitle() + vo.getContents() + vo.getWriter()).equals("")){
				resultRow = -1;
				return resultRow;
			}
			String setStr = ((vo.getTitle().equals("")) ? "" : (" TITLE = '" + vo.getTitle() + "',"))
					+ ((vo.getContents().equals("")) ? "" : (" CONTENTS = '" + vo.getContents() + "',"))
					+ ((vo.getWriter().equals("")) ? "" : (" WRITER = '" + vo.getWriter() + "',"));
			
			String updateSql = "UPDATE BOARD SET"
					+ setStr.substring(0, setStr.length() - 1)
					+ " WHERE SEQ = ? AND PW = ?";
			pst = con.prepareStatement(updateSql);
			pst.setInt(1, vo.getSeq());
			pst.setString(2, vo.getPw());
			resultRow = pst.executeUpdate();
			 
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRow;
	}
	
	public int deleteBoard(int seq){
		int resultRow = 0;
		try {
			con = BoardDAO.getConnection();
			String deleteSql = "DELETE BOARD WHERE SEQ = ?";
			pst = con.prepareStatement(deleteSql);
			pst.setInt(1, seq);
			resultRow = pst.executeUpdate();
			 
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRow;
	}
	
	public boolean checkPw(String inputPw){
		boolean checkFlag = false;
		try {
			con = BoardDAO.getConnection();
			String[] inputArr = inputPw.split("::");
			int cid = Integer.parseInt(inputArr[0]);
			String cpw = inputArr[1];
			String checkSql = "SELECT SEQ FROM BOARD WHERE SEQ = ? AND PW = ?";
			
			pst = con.prepareStatement(checkSql);
			pst.setInt(1, cid);
			pst.setString(2, cpw);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				checkFlag = true;
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return checkFlag;
		
	}
}
