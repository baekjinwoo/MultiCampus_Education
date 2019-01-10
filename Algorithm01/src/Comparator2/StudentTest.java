package Comparator2;

import java.util.Arrays;

public class StudentTest  {
	public static void main(String[] args) {
		Student[] arr= new Student[10]; //(Student)배열타입의 변수를 10길이로 공간확보한다. => 객체배열화
		arr[0]=new Student(100,"이**","전산",3);
		arr[1]=new Student(110,"박**","수학",4);
		arr[2]=new Student(120,"창**","통계",5);
		arr[3]=new Student(130,"효**","경영",1);
		arr[4]=new Student(140,"최**","정보",2);
		arr[5]=new Student(150,"배**","정보",3);
		arr[6]=new Student(160,"김**","전산",5);
		arr[7]=new Student(170,"황**","수학",3);
		arr[8]=new Student(180,"정**","음악",2);
		arr[9]=new Student(190,"백**","전산",3);
		
		Arrays.sort(arr, new StudentComparator());
		for(Student stu : arr){
			System.out.println(stu); //char1.Student@16진수
		}
	}
}
