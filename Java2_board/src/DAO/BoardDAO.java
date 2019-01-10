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
	public int insertMember(MemberVO vo) { // ?,?,?,?,?�� �������� MemberVo vo�Ű�������
											// ���޹޾Ҵ�.
		int insertRow = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");

			String sql = "insert into MEMBER VALUES(?,?,?,?,?)";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getId());
			pt.setString(2, vo.getPw()); // ���� ��ȣ�� �Է��Ѵ�� ����ȴ�. �ܼ�API�� ���� �ʿ䰡 ����,
											// �������� ������ ���� �����ȿ���� ���� �ȴ�.
			pt.setString(3, vo.getMember_name());
			pt.setString(4, vo.getEmail());
			pt.setString(5, vo.getPhone()); // 5������ mapping�Ϸ�

			insertRow = pt.executeUpdate(); // ��ȸ�� �ƴ϶�, ��ȭ�� ���� ������ Ȯ���Ѵ�
			System.out.println(insertRow + "�� ����"); // ������ ȭ�鿡 ���

			pt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return insertRow; // insertRow�� ��ȭ�� ���� ������ Ȯ���ϱ����� ������ε�, ������ �������ѿ� ����
							// insertRow�� �������� 0�ʱ�ȭ�� ��
	}

	public int insertBoard(BoardVO vo) { // ?,?,?,?,?�� �������� MemberVo vo�Ű�������
											// ���޹޾Ҵ�.
		int insertRow = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");

			String selsql = "select id from member where id = ?";
			PreparedStatement selpt = con.prepareStatement(selsql);
			selpt.setString(1, vo.getWriter());
			ResultSet rs = selpt.executeQuery();
			if (!rs.next()) { // ���̵� ���ٸ�
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
		ArrayList<BoardVO> list = new ArrayList<>(3);  // �ӽ÷� 3���� ��Ƴ����� ���ڸ��� 3���� �þ�� ����迭, default���� 10
		int insertRow = 0;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		String selectsql=null;
		PreparedStatement selectpt = null;

		// BoardListView���� �����ϰ�� 
		if(condition.charAt(0)>='1'&& condition.charAt(0)<='9'){

			
			selectsql = ("select * from (select rownum r, num, title, writer from (select * from board order by editime desc))  where r>=? and r<=?"); //���۹�ȣ: (��������ȣ-1)*3 +1     //�����ȣ: ��������ȣ*3
			selectpt = con.prepareStatement(selectsql);
			selectpt.setInt(1, (Integer.parseInt(condition)-1)*3+1); //������ �����ϱ����� String->����
			selectpt.setInt(2, Integer.parseInt(condition)*3);
		}
		// BoardListView���� �����ϰ�� 
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
		while (rs.next()) { //���� ���ڵ� �̵�
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				BoardVO vo = new BoardVO(num, title, writer);
				list.add(vo);
				
				/* ���2)
				 * ��ü������ arraylist�� ���� �ֱ����� ����
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
	//getBoard(int seq){ ��ȣ

	//update: seq�� �Խù� ��ȸ�� ����, sql����
	//select sql����

	
	public ArrayList<BoardVO> getBoard(int num){ 
		// ���޹޾Ҵ�.
		int insertRow = 0;
		ArrayList<BoardVO> list = new ArrayList<>(3);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
			String sql1 = "update Board set total = total +1 where num = ?";
			PreparedStatement pt1 = con.prepareStatement(sql1);
			pt1.setInt(1, num);
			
			String sql2 = "select * from Board where num = ?"; //���߿� ��� ������~
			PreparedStatement pt2 = con.prepareStatement(sql2);
			pt2.setInt(1, num);

			insertRow = pt1.executeUpdate();
			ResultSet rs = pt2.executeQuery();

		while (rs.next()) { //���� ���ڵ� �̵�
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

					System.out.println("������Ʈ �Ǿ����ϴ�.");
				}else{
					System.out.println("��й�ȣ ����");
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

