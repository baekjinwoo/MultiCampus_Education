package dao;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVo;

public class MemberDAO {

//	4) MemberDAO 
//	getMemberList(conn:Connection):ArrayList<MemberVo>      ==> 전체보기
//	getMember(conn:Connection,irum:String):MemberVo            ==> 찾기
//	insertMember(conn:Connection,ob:MemberVo):int                ==> 추가
//	deleteMember(conn:Connection,irum:String):int                    ==> 삭제 
	     
	public ArrayList<MemberVo> getMemberList(Connection conn){ //전체
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<MemberVo>list = new ArrayList<>();
		MemberVo ob=null;
		String sql="SELECT*FROM MEMBERPHONE";
		
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				ob=new MemberVo();
				ob.setIdx(rs.getInt("IDX"));
				ob.setName((rs.getString("NAME")));
				ob.setPhone((rs.getString("PHONE")));
				list.add(ob);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return list;	
	}
	
	public MemberVo getMember(Connection conn, String name){ //찾기
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		MemberVo ob=null;
		String sql="SELECT*FROM MEMBERPHONE WHERE NAME=?";
		
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			
			while(rs.next()){
				ob=new MemberVo();
				ob.setIdx(rs.getInt("IDX"));
				ob.setName((rs.getString("NAME")));
				ob.setPhone((rs.getString("PHONE")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return ob;
	}
	
	public String insertMember(MemberVo ob, Connection conn){
		PreparedStatement ps = null;
		String name=null; //name 초기화
		String sql= "INSERT INTO MEMBERPHONE(IDX,NAME,PHONE) VALUES(mp_idx.NEXTVAL,?,?)";
		int n = 0;
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getPhone());
			n=ps.executeUpdate();
			if(n>0){
				name=ob.getName();
				commit(conn);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			rollback(conn); //실패하면 rollback;
		}finally{
			close(ps);
		}
		return name;
	}
	
	public int deleteMember(String name, Connection conn){ //삭제
		PreparedStatement pstmt = null;
		
		String sql = "delete from memberphone where name='"+name+"'";
		
		int n = 0;
		
		try{
			pstmt = conn.prepareStatement(sql);
			n=pstmt.executeUpdate();
			if(n>0){
				commit(conn);
			}
		}catch(SQLException e){
			e.printStackTrace();
			rollback(conn);
		}finally{
			close(pstmt);
		}
		
		return n;
	}
}
