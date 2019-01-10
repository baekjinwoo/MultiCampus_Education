package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.entity.StudentEntity;
import static com.example.template.JdbcTemplate.close;
import static com.example.template.JdbcTemplate.commit;
import static com.example.template.JdbcTemplate.rollback;

public class StudentDao {

//	StudentDao.java      --DB연동
//    +insertStudent(entity:StudentEntity):String
//    +getStudent(name:String):StudentEntity
//    +getStudentList():List<StudentEntity>  
	
	public String insertStudent(StudentEntity entity, Connection conn){
		PreparedStatement ps = null;
		String name=null; //name 초기화
		String sql= "INSERT INTO STUDENT(NUM,NAME,KOR,ENG,MAT) VALUES(N_SQL.NEXTVAL,?,?,?,?)";
		int n = 0;
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setInt(2, entity.getKor());
			ps.setInt(3, entity.getEng());
			ps.setInt(4, entity.getMat());
			n=ps.executeUpdate();
			if(n>0){
				name=entity.getName();
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
	
	public StudentEntity getStudent(String name, Connection conn){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		StudentEntity entity=null;
		String sql="SELECT*FROM STUDENT WHERE NAME=?";
		
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			
			while(rs.next()){
				entity=new StudentEntity();
				entity.setNum(rs.getInt("NUM"));
				entity.setName(rs.getString("NAME"));
				entity.setKor(rs.getInt("KOR"));
				entity.setEng(rs.getInt("ENG"));
				entity.setMat(rs.getInt("MAT"));
				entity.setTot(entity.getKor()+entity.getEng()+entity.getMat());
				entity.setAvg(entity.getTot()/3);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return entity;
	}
	
	public List<StudentEntity> getStudentList(Connection conn){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<StudentEntity>list = new ArrayList<>();
		StudentEntity entity=null;
		String sql="SELECT*FROM STUDENT";
		
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				entity=new StudentEntity();
				entity.setNum(rs.getInt("NUM"));
				entity.setName(rs.getString("NAME"));
				entity.setKor(rs.getInt("KOR"));
				entity.setEng(rs.getInt("ENG"));
				entity.setMat(rs.getInt("MAT"));
				entity.setTot(entity.getKor()+entity.getEng()+entity.getMat());
				entity.setAvg(entity.getTot()/3);
				list.add(entity); //목록을 뜨게끔 추가한다는 것을 설정해야 한다.
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return list;
	}
}
