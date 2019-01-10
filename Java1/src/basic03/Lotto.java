package basic03;

import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		//1. 로또만들기_랜덤클래스 : 중복은 나중에 처리한다
		Random r1=new Random();
		int i3=r1.nextInt(45)+1;
		int i4=r1.nextInt(45)+1;
		int i5=r1.nextInt(45)+1;
		int i6=r1.nextInt(45)+1;
		int i7=r1.nextInt(45)+1;
		int i8=r1.nextInt(45)+1;		
	
		System.out.println(i3+"\t"+i4+"\t"+i5+"\t"+i6+"\t"+i7+"\t"+i8);				
		System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t",i3,i4,i5,i6,i7,i8);
		

		//2. 로또만들기_Math함수의 Random:노가다로 작성하는데, for문을 배우면 편리하다
		System.out.print("\n"+(int)Math.ceil(45*Math.random())+"\t");
		System.out.print((int)Math.ceil(45*Math.random())+"\t");
		System.out.print((int)Math.ceil(45*Math.random())+"\t");
		System.out.print((int)Math.ceil(45*Math.random())+"\t");
		System.out.print((int)Math.ceil(45*Math.random())+"\t");
		System.out.print((int)Math.ceil(45*Math.random())+"\t");
	}
}
