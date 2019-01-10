package Recursion;

/* 반복1
 * for(int i=1; i<=10; i++){  System.out.println("*");  }   */	


/* 재귀1
public class Recursion {
	public void recurse(){
		System.out.println("*");
		recurse();
	}

	public static void main(String[] args) {
		new Recursion().recurse();
	}
}*/



//재귀2
public class Recursion {
	public void recurse(int cnt, String input){
		if(cnt<=0)//재귀함수는 자기자신을 호출하게되면 무한루프를 돌게되니까 종료할 수 있는 범위를 주어야한다
			System.out.println("\n 종료");
		else{
		System.out.print(input);
		recurse(cnt-1,input); 
		}
	}

	public static void main(String[] args) {
		new Recursion().recurse(10,"*"); //10번만 별을 출력해~
	
	}
}
