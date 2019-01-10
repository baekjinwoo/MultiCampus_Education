package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	public int getTotalCount() throws Exception{
		//전체 레코드 갯수 
		Context context = new InitialContext();
		Context current = (Context)context.lookup("java:/comp/env");		
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
//1. DataSource 설정 이용하여 db 연결
Context context = new InitialContext();
Context current = (Context)context.lookup("java:/comp/env");		
DataSource conpool=(DataSource)current.lookup("jdbc/myoracle");
Connection con = conpool.getConnection();

//2. board 테이블 1페이지 선택시 5개씩 보여줌
//작성시간 최근순 정렬 
String sql = 
"select r, seq, title, writer, time1, pw, view1 "
+" from (select rownum r, a.*"
+" from "
+" (select * from board" 
+" order by time1 desc) a"
+" )"
+" where r >= ? and r <= ?";
//page:1 : 1~3
//page:2 : 4~6
//page:3 : 7~9
int cntPerPage = 3;
int start = (page-1) * cntPerPage + 1 ; 
int end = page * cntPerPage; 
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
	}//getBoardList end
}//class end
