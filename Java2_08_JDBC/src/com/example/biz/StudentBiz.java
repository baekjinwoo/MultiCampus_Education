package com.example.biz;

import java.sql.Connection;
import java.util.List;

import com.example.dao.StudentDao;
import com.example.entity.StudentEntity;
import com.example.view.StudentView;
import static com.example.template.JdbcTemplate.getConnection;
import static com.example.template.JdbcTemplate.close;

public class StudentBiz {


//	  StudentBiz.java      --들어온 kor,eng,mat값중 0~100사이의 점수가 아니면 오류리턴   
//	     +insertStudent(entity:StudentEntity):void
//	     +getStudent(name:String):void
//	     +getStudentList():void
	
	Connection conn = null;
	StudentDao dao = null;
	StudentView view = null;
	
	public StudentBiz(){
		dao = new StudentDao();
		view = new StudentView(); //작성이 안되있으면 null포인트 오류뜰 가능성이 큼.
	}
	
	public void insertStudent(StudentEntity entity){

// JdbcTemplate tm = new JdbcTemplate(); conn=tm.getConnection(); tm.close(conn);은 그때그때마다 DB와 java연동객체를 만들어야되서 메모리낭비가 심하다
		
		//따라서 아래와 같이 공통 연결객체를 만들어서 연결하고 종료하는 Singleton방식을 쓴다.
//		conn=JdbcTemplate.getConnection();// 연결
//		JdbcTemplate.close(conn); //종료
	
		//원래 위와 같은 방법으로 하는 것이지만, (1)import자체에 static으로 선언해서 getConnection시켜주고,
		conn=getConnection();
		String name=null;
		//유효성 검사 후 dao로 전송
		if(entity.getKor()<=100 && entity.getKor()>=0 
		&& entity.getEng()<=100 && entity.getEng()>=0
		&& entity.getMat()<=100 && entity.getMat()>=0) {
			
			name=dao.insertStudent(entity, conn);
		}
		close(conn); //(2)import자체에 static으로 선언해서 close
		//결과 출력
		view.insertStudent(name);
		
	}
	//--1건 데이터보기 ----------------------------------------------------------------------------------
	public void getStudent(String name){
		conn=getConnection(); //객체생성
		StudentEntity entity = dao.getStudent(name,conn); //conn으로 들어가야된다.
		close(conn); //끊어주기
		
		view.getStudent(entity);
	}
	
	//--전체보기  ----------------------------------------------------------------------------------
	public void getStudentList(){
		conn=getConnection(); //객체생성
		List<StudentEntity> list = dao.getStudentList(conn); //conn으로 들어가야된다.
		close(conn); //끊어주기
		
		view.getStudentList(list);
	}
}
