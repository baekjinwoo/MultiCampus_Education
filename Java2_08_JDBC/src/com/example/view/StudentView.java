package com.example.view;

import java.util.List;

import com.example.entity.StudentEntity;

public class StudentView {

//	StudentView.java     --결과값 출력
//    +insertStudent(name:String):void
//    +getStudent(entity:StudentEntity):void
//    +getStudentList(list:List<StudentEntity>)
	
	public void insertStudent(String name){
		if(name!=null){
			System.out.println(name+"님이 추가되었습니다\n");
		}
		else{
			System.out.println("점수 입력오류!!");
		}
		
	}
	public void getStudent(StudentEntity entity){
		if (entity != null) {
				System.out.print("이름 : " + entity.getName()+"\t");
				System.out.print("총점 : " + entity.getTot()+"\t");
				System.out.print("평균 : " + entity.getAvg()+ "\n");
			} else {
			System.out.println("데이터가 없습니다\n");
		}
}
	public void getStudentList(List<StudentEntity> list){
		if (list != null) {
			for (StudentEntity entity : list) {
				System.out.print("번호 : " + entity.getNum()+"\t");
				System.out.print("이름 : " + entity.getName()+"\t");
				System.out.print("국어 : " + entity.getKor()+"\t");
				System.out.print("영어 : " + entity.getEng()+"\t");
				System.out.print("수학 : " + entity.getMat()+"\t");
				System.out.print("총점 : " + entity.getTot()+"\t");
				System.out.print("평균 : " + entity.getAvg()+ "\n");
			}
			System.out.println();
		} else {
			System.out.println("데이터가 없습니다\n");
		}
	}
}
