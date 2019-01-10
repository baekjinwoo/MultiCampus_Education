package Animal;

import java.util.Scanner;

//정적바인딩(static binding): 컴파일시점에 호출함수를 이미 알고 있다.
public class AnimalMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		Dog ob1=null;
		Cat ob2=null;
		Fish ob3=null;
		Duck ob4=null;

		while(true){
			System.out.println("1.Dog 2.Cat 3.Fish 4.Duck 5.exit\n선택:");
			n=sc.nextInt();
			
			switch(n){ case 1: ob1=new Dog(); ob1.speak(); ob1.walk(); break;
					   case 2: ob2=new Cat(); ob2.speak(); ob2.walk(); break;
					   case 3: ob3=new Fish(); ob3.speak(); ob3.walk(); break;
					   case 4: ob4=new Duck(); ob4.speak(); ob4.walk(); break;
					   default: System.out.println("종료");  //Case 5:와 같다.
					   			sc.close(); 
					   			System.exit(0);
			}
		}
	}
}
