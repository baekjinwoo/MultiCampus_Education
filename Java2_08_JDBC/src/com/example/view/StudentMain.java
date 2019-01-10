package com.example.view;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

import com.example.biz.StudentBiz;
import com.example.entity.StudentEntity;

public class StudentMain {
	StudentEntity entity = null; 
	StudentBiz biz = null;
	Scanner sc = null;

	public StudentMain() {
		entity = new StudentEntity(); //entity라는 객체를 하나 생성.
		biz = new StudentBiz();
		sc = new Scanner(in);
	}

	public void menu() {
		int n = 0;
		String name = null;
		while (true) {
			out.print("1.추가 2.검색 3.전체보기 4.종료\n선택(1-4) : ");
			n = sc.nextInt();

			switch (n) {
			case 1:					
				out.print("이름을 입력 : ");		entity.setName(sc.next());
				out.print("국어점수 입력 : ");	entity.setKor(sc.nextInt());
				out.print("영어점수 입력 : ");	entity.setEng(sc.nextInt());
				out.print("수학점수 입력 : ");	entity.setMat(sc.nextInt());

				biz.insertStudent(entity);	//데이터를 넘길때 하나하나넘기기보다는 객체자체를 넘김으로써 수월한 처리 
				break;						//biz.insertStudent(kor, eng, ....);

			case 2:
				out.print("찾을이름을 입력 : ");	name = (sc.next());
				biz.getStudent(name);
				break;

			case 3:
				biz.getStudentList();
				break;

			case 4:
				sc.close();
				exit(0);
				break;
			default:
				out.println("입력오류!!\n");
			}
		}
	}

	public static void main(String[] args) {
		new StudentMain().menu();
	}

}
