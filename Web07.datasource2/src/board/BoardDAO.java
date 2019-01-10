package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
		public int getTotalCount() throws Exception{
			//전체 레코드 갯수 
			Context context = new InitialContext();
			System.out.println("====>"+context+"1111"); //test용도
			Context current = (Context)context.lookup("java:/comp/env");
			System.out.println(current); //test용도
			DataSource conpool=(DataSource)current.lookup("jdbc/myoracle");
			Connection con = conpool.getConnection();
			String sql = 
			"select count(*) from board";
			PreparedStatement pt = 
					con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			rs.next();//첫번째레코드이동
			int result = rs.getInt("count(*)");
			con.close();
			return result;
			
		}
	
	public ArrayList<BoardVO> getBoardList(int page) throws Exception{ 
		//1. DataSource 설정 이용해서 db연결
		Context context = new InitialContext();
		Context current = (Context)context.lookup("java:/comp/env");		
		DataSource conpool=(DataSource)current.lookup("jdbc/myoracle");
		Connection con = conpool.getConnection();

		//2. board 테이블 1 페이지 선택시 5개씩 보여줌
		//작성시간 최근순 정렬
		
		//=> board 테이블 날짜순 역순 정렬하여 1~5번까지 레코드 조회
		// 이떄, 전체적으로 번호를 메겨온 rownum r의 r을 써야한다. r>=2 and r<=5 (1은 생략가능) 이때, rownum자체를 쓸수 없다.
		
	String sql = 
	"select r, seq, title, writer, time1, pw, view1 " //contents 안읽음
	+" from (select rownum r, a.*"
	+" from (select * from board order by time1 desc) a"
	+" )"
	+" where r >= ? and r <= ?";
	//page:1 : 1~3        pt.setInt(1, 1); //눌럿을경우에
	//page:2 : 4~6 	      pt.setInt(2, 3); //한페이지에 3개씩
	//page:3 : 7~9
	int start = 0;
	int end= 1000;
	if(page!=0){
		int cntPerPage = 3;
		start = (page-1) * cntPerPage + 1 ; 
		end = page * cntPerPage; 
	}
	PreparedStatement pt = con.prepareStatement(sql);
	pt.setInt(1, start);
	pt.setInt(2, end);
	ResultSet rs = pt.executeQuery();
	ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	while(rs.next()){
		BoardVO vo = new BoardVO
		(rs.getInt("seq"), 
		rs.getString("title"),
		"contents", 
		rs.getString("writer"), 
		rs.getString("time1"), 
		rs.getString("pw"), 
		rs.getInt("view1"));
		list.add(vo);
	}
	con.close();//conpool 반납
	return list;
	 //list내부에 더해주도록 한다. 반복문이 끝났을경우에 리스트에 객체내용들이 저장되게 된다.
	}//getUserList end
}

