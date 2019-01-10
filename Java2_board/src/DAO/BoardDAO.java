package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import VO.BoardVO;
import VO.MemberVO;

public class BoardDAO {
	public int insertMember(MemberVO vo) { // ?,?,?,?,?에 넣을값을 MemberVo vo매개변수에
											// 전달받았다.
		int insertRow = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");

			String sql = "insert into MEMBER VALUES(?,?,?,?,?)";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPw()); // 현재 암호는 입력한대로 노출된다. 콘솔API는 딱히 필요가 없고,
											// 웹쪽으로 갔을때 따로 비공개효과는 배우게 된다.
			pt.setString(3, vo.getMember_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone()); // 5번까지 mapping완료

			insertRow = pt.executeUpdate(); // 조회가 아니라, 변화된 행의 개수를 확인한다
			System.out.println(insertRow + "행 삽입"); // 실행결과 화면에 출력

			pt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return insertRow; // insertRow가 변화된 행의 개수를 확인하기위한 결과값인데, 변수의 범위제한에 의해
							// insertRow를 범위에서 0초기화할 것
	}

	public int insertBoard(BoardVO vo) { // ?,?,?,?,?에 넣을값을 MemberVo vo매개변수에
											// 전달받았다.
		int insertRow = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");

			String selsql = "select id from member where id = ?";
			PreparedStatement selpt = con.prepareStatement(selsql);
			selpt.setString(1, vo.getWriter());
			ResultSet rs = selpt.executeQuery();
			if (!rs.next()) { // 아이디가 없다면
				insertRow = -1;
			} else {
				insertRow = 1;
				String insertsql = "insert into board VALUES(board_num.nextval,?,?,?,sysdate,?,0)";
				PreparedStatement insertpt = con.prepareStatement(insertsql);
				insertpt.setString(1, vo.getTitle());
				insertpt.setString(2, vo.getText());
				insertpt.setString(3, vo.getWriter());
				insertpt.setString(4, vo.getPw());

				insertRow = insertpt.executeUpdate();
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return insertRow;

	}

	public ArrayList<BoardVO> getBoardList(String condition) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BoardVO> list = new ArrayList<>(3);  // 임시로 3으로 잡아놓으면 모자르면 3개씩 늘어나는 가상배열, default값은 10
		int insertRow = 0;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		String selectsql=null;
		PreparedStatement selectpt = null;

		// BoardListView에서 숫자일경우 
		if(condition.charAt(0)>='1'&& condition.charAt(0)<='9'){

			
			selectsql = ("select * from (select rownum r, num, title, writer from (select * from board order by editime desc))  where r>=? and r<=?"); //시작번호: (페이지번호-1)*3 +1     //종료번호: 페이지번호*3
			selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, (Integer.parseInt(condition)-1)*3+1); //정수로 연산하기위해 String->정수
			selectpt.setInt(2, Integer.parseInt(condition)*3);
		}
		// BoardListView에서 문자일경우 
		else{
			selectsql = "select num, title, writer"
					  + " from board "
					  + " where title like ? or text like ? or writer like ?";
			
			selectpt = con.prepareStatement(selectsql);
			selectpt.setString(1, "%"+condition+"%");
			selectpt.setString(2, "%"+condition+"%");
			selectpt.setString(3, "%"+condition+"%");
		}
		
		ResultSet rs = selectpt.executeQuery();
		while (rs.next()) { //다음 레코드 이동
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				BoardVO vo = new BoardVO(num, title, writer);
				list.add(vo);
				
				/* 방법2)
				 * 객체생성후 arraylist에 값을 넣기위한 과정
				 * BoardVO vo = new BoardVO();
				 * vo.setnum(rs.getInt("num"));
				 * vo.setTitle(rs.getString("title"));
				 * vo.setWrtier(rs.getString("writer");
				 * */
		}
		con.close();

		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//public BoardVO 
	//getBoard(int seq){ 번호

	//update: seq의 게시물 조회수 증가, sql실행
	//select sql실행

	
	public ArrayList<BoardVO> getBoard(int num){ 
		// 전달받았다.
		int insertRow = 0;
		ArrayList<BoardVO> list = new ArrayList<>(3);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
			String sql1 = "update Board set total = total +1 where num = ?";
			PreparedStatement pt1 = con.prepareStatement(sql1);
			pt1.setInt(1, num);
			
			String sql2 = "select * from Board where num = ?"; //나중에 비번 빼세용~
			PreparedStatement pt2 = con.prepareStatement(sql2);
			pt2.setInt(1, num);

			insertRow = pt1.executeUpdate();
			ResultSet rs = pt2.executeQuery();

		while (rs.next()) { //다음 레코드 이동
			int num2 = rs.getInt(1);
			String title = rs.getString(2);
			String text = rs.getString(3);
			String writer = rs.getString(4);
			String editime = rs.getString(5);
			String password = rs.getString(6);
			int total = rs.getInt(7);
			
			BoardVO vo = new BoardVO(num, title, text, writer, password, total, editime);
			list.add(vo);
			}

		pt1.close();
		pt2.close();
		con.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int updateBoard(BoardVO vo) {
		
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");

				String selectsql = "select password from BOARD where num=?";
				
				pt = con.prepareStatement(selectsql);
				
				pt.setInt(1, vo.getNum());
				
				rs = pt.executeQuery();
				
				while(rs.next()){
					
					String check=rs.getString(1);
					
				if(check.equals(vo.getPw())){
					
					if(!vo.getTitle().equals("")){
						String updatesql = "update BOARD set title=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getTitle());
						pt.setInt(2, vo.getNum());
						pt.executeUpdate();
					}
					if(!vo.getText().equals("")){
						String updatesql = "update BOARD set text=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getText());
						pt.setInt(2, vo.getNum());
						pt.executeUpdate();
					}
					if(!vo.getWriter().equals("")){
						String updatesql = "update BOARD set writer=? where num=?";
						pt = con.prepareStatement(updatesql);
						pt.setString(1, vo.getWriter());
						pt.setInt(2, vo.getNum());
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
	
	
	
	public int deleteBoard(int num){
		int deleteRow=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
			String delsql="delete board where num = ?";
		

			PreparedStatement pt = con.prepareStatement(delsql);
			pt.setInt(1,num);
			
			deleteRow = pt.executeUpdate(); 

			con.close();
			pt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteRow;
	}
}

