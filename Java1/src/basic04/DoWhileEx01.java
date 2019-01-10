package basic04;

import java.util.Scanner;

//Do While를 이용하여 메뉴만들기 문제.
public class DoWhileEx01 {
	public static void main(String[] args) {
		//do while: 두 가지 메뉴를 선택하는 문제
		int sel1;
		String sel2=null; //for문안에 변수를 넣는거랑 같다. do while밖에다가 선언해줘야한다.

		//char c1=' '와 같은 원리.
		Scanner sc=new Scanner(System.in); 
			
		do { //메뉴를 물어볼때 잘못눌럿을때 "잘못눌렀습니다"를 표시하고 메뉴화면으로 돌아가기위할때만 쓴다.
			System.out.println("메뉴를 선택하세요");
			System.out.println("짜장은1번");
			System.out.println("짬뽕은2번");// do while안에서 계속 메뉴를 물어보기 위해서 넣는것이다.
				
			sel2=sc.nextLine();
			//sel1=Integer.parseInt(sel2);
		// } While(sel1 !=1&& sel1 !=2);
		} 
	//while(sel2 != "1" && sel2 !="2"); //내용값으로 X
	  while(!(sel2.equals("1"))&&!(sel2.equals("2"))); //번지값으로 O
			
	System.out.println("주문한것많이드세요"); 
	}
}
