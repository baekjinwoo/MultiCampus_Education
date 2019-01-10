package biz;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import view.MemberView;
import vo.MemberVo;

public class MemberBiz {

//	3) MemberBiz : connection, close,commit,rollback처리를 한다
//getMemberList():ArrayList<MemberVo>      
//getMember(irum:String):MemberVo            
//insertMember(ob:MemberVo):int                
//deleteMember(irum:String):int 
	
	Connection conn = null;
	MemberDAO dao = null;
	MemberView view = null;
	
	public MemberBiz(){
		dao = new MemberDAO();
		view = new MemberView();
	}
	
	public void getMemberList(){
		conn=getConnection(); //객체생성
		List<MemberVo> list = dao.getMemberList(conn); //conn으로 들어가야된다.
		close(conn); //끊어주기
		
		view.getMemberList(list);
	}
	
	public void getMember(String name){
		conn=getConnection(); //객체생성
		MemberVo ob = dao.getMember(conn, name); //conn으로 들어가야된다.
		close(conn); //끊어주기
		
		view.getMember(ob);
	}
	
	public void insertMember(MemberVo ob){
		conn=getConnection();
		String name=null;
		name=dao.insertMember(ob, conn);
		close(conn); //(2)import자체에 static으로 선언해서 close
		//결과 출력
		view.insertMember(name);
		
	}



	public void deleteMember(String name){
		conn=getConnection(); //객체생성
		int n = dao.deleteMember(name, conn); //conn으로 들어가야된다.
		close(conn); //끊어주기
		view.deleteMember(n);
	}
}

