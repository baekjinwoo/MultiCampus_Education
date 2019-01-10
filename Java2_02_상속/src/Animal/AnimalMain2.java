package Animal;

import java.util.Scanner;

//Dynamic binding: 실행시점(run time)에 호출함수를 결정한다, 코딩량을 1/10까지도 줄일 수 있다.
public class AnimalMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		Animal ob=null; //부모의 참조변수
		
		while(true){
			System.out.println("1.Dog 2.Cat 3.Fish 4.Duck 5.exit\n선택:");
			n=sc.nextInt();
			
			switch(n){ case 1: ob=new Dog(); break; //1번 누르면 Dog객체가 만들어지고
					   case 2: ob=new Cat(); break; //2번 누르면 Cat객체가 만들어지고
					   case 3: ob=new Fish(); break; //3번 누르면 Fish객체가 만들어지고
					   case 4: ob=new Duck(); break; //4번 누르면 Duck객체가 만들어진다.
					   default: System.out.println("종료");  //Case 5:와 같다.
					   			sc.close(); 
					   			System.exit(0);
			} //end switch
			ob.speak(); 
			ob.walk();
		} //end while
	}

}
