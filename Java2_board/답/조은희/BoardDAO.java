package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BoardVo;
import vo.MemberVo;

public class BoardDAO {

	public int insertMember(MemberVo vo) {

		int resultRow = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String sql = "insert into member" + " values(?,?,?,?,?)";

			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPw());
			pt.setString(3, vo.getMember_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone());

			resultRow = pt.executeUpdate();

			System.out.println(resultRow + "행 삽입");

			pt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultRow;
	}
	//--------------------------------------------------------------------
	public int insertBoard(BoardVo vo) {

		int cnt=0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql="select id from member where id=?";
			
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			
			selectpt.setString(1, vo.getWriter());
			
			ResultSet rs=selectpt.executeQuery();
			
			if(!rs.next()){
				cnt=-1;
			}else{
				
				String insertsql = "insert into board"
						+ " values(board_seq.nextval, ?,?,?,sysdate,?,0)";

				PreparedStatement insertpt = con.prepareStatement(insertsql);

				insertpt.setString(1, vo.getTitle());
				insertpt.setString(2, vo.getContents());
				insertpt.setString(3, vo.getWriter());
				insertpt.setString(4, vo.getPw());
				
				cnt=insertpt.executeUpdate();

				System.out.println(cnt + "행 삽입");

				insertpt.close();
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}
	//--------------------------------------------------------------------
	public String selectBoard(String str) {

		String [] s=str.split(":");
		
		if(s[0].equals("1")){
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

				String selectsql = "select num, title, writer from BOARD"
						+ " where num>=? and num<=?";

				PreparedStatement selectpt = con.prepareStatement(selectsql);
				
				int page=Integer.parseInt(s[1]);
				
				selectpt.setInt(1, (page-1)*3+1);
				selectpt.setInt(2, page*3);

				ResultSet rs = selectpt.executeQuery();
				
				while(rs.next()){
					int num=rs.getInt(1);
					String title=rs.getString(2);
					String writer=rs.getString(3);
					
					System.out.println(num+"\t"+title+"\t"+writer);
				}
				
				rs.close();
				selectpt.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (s[0].equals("2")) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

				String selectsql = "select num, title, writer from board"
						+ " where title like ? or contents like ? or writer like ?";

				PreparedStatement selectpt = con.prepareStatement(selectsql);
				
				selectpt.setString(1, "%"+s[1]+"%");
				selectpt.setString(2, "%"+s[1]+"%");
				selectpt.setString(3, "%"+s[1]+"%");

				ResultSet rs = selectpt.executeQuery();
				
				while(rs.next()){
					int num=rs.getInt(1);
					String title=rs.getString(2);
					String writer=rs.getString(3);
					
					System.out.println(num+"\t"+title+"\t"+writer);
					
				}
				
				rs.close();
				selectpt.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	//--------------------------------------------------------------------
	public String getBoard(int seq){

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String updatesql = "update BOARD set viewcount=(SELECT MAX(VIEWCOUNT)+1 FROM BOARD) where num=?";

			PreparedStatement updatept = con.prepareStatement(updatesql);

			updatept.setInt(1, seq);
			
			updatept.executeUpdate();
			
			String selectsql = "select num, title, contents, writer, w_time, viewcount from BOARD where num=?";
			
			PreparedStatement selectpt = con.prepareStatement(selectsql);
			
			selectpt.setInt(1, seq);
			
			ResultSet rs = selectpt.executeQuery();
			
			while(rs.next()){
				int num=rs.getInt(1);
				String title=rs.getString(2);
				String contents=rs.getString(3);
				String writer=rs.getString(4);
				String date=rs.getString(5);
				int count=rs.getInt(6);
				
				System.out.println(num+"\t"+title+"\t"+contents+"\t"+writer+"\t"+date+"\t"+count);
			}
			
			rs.close();
			selectpt.close();
			updatept.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//--------------------------------------------------------------------
	public int updateBoard(BoardVo vo) {
		
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

				String selectsql = "select password from BOARD where num=?";
				
				pt = con.prepareStatement(selectsql);
				
				pt.setInt(1, vo.getSeq());
				
				rs = pt.executeQuery();
				
				while(rs.next()){
					
					String check=rs.getString(1);
					
				if(check.equals(vo.getPw())){
					
					if(!vo.getTitle().equals("")){
						String updatesql = "update BOARD set title=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getTitle());
						pt.setInt(2, vo.getSeq());
						pt.executeUpdate();
					}
					if(!vo.getContents().equals("")){
						String updatesql = "update BOARD set contents=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getContents());
						pt.setInt(2, vo.getSeq());
						pt.executeUpdate();
					}
					if(!vo.getContents().equals("")){
						String updatesql = "update BOARD set writer=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getWriter());
						pt.setInt(2, vo.getSeq());
						pt.executeUpdate();
					}

					System.out.println("업데이트 되었습니다.");
				}else{
					System.out.println("비밀번호 오류");
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return 0;
		}
	
	//--------------------------------------------------------------------
	public int deleteBoard(BoardVo vo) {
		
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");

			String selectsql = "select password from BOARD where num=?";
			
			pt = con.prepareStatement(selectsql);
			
			pt.setInt(1, vo.getSeq());
			
			rs = pt.executeQuery();
			
			while(rs.next()){
				
				String check=rs.getString(1);
				
			if(check.equals(vo.getPw())){
				
				String updatesql = "delete BOARD where num=?";

				pt = con.prepareStatement(updatesql);

				pt.setInt(1, vo.getSeq());
				
				pt.executeUpdate();

				System.out.println(vo.getSeq()+"번째 데이터가 삭제 되었습니다.");
				
			}else{
				System.out.println("비밀번호 오류");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
}
