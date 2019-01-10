package basic06;

// Call by value: 물건을 직접주는 것
// Call by reference :주소값(참조값)을 주는 것
// (사물함안에있는 키를 주는거지 안의 내용물을 주는게 아님 => 주소값을 주는 것)

// int[] lo= new int[6]라고 생성하고나서, 전달할 때는 kaja(lo)라고 call by reference를 한다
// 메소드의 매개변수에서는 public static void kaja(int[] lo)라고 써도되고 다른 이름으로 public static void kaja(int[] lo2)라고 이름을 바꿔도 주소값은 같다

// 자바에서 기억창고 하나에 번지만 전달하는 일은 없다. 불가능.=> 배열을 잡아서 전달하는 방법밖에 없다.(c#은 가능)


public class MaxFind {
	public static void main(String[] args) {
	//1. 2차원 배열에 앞서 "배열의 활용" ==> a,b,c 세수를 비교해서 최대값찾기(차트작성해서 풀기)
		int a=1588;
		int b=1798;
		int c=6518;

	//방법1
		if(a>b&&a>c)	System.out.print("a가 최대값");
		
		else if(b>a&&b>c)  System.out.print("b가 최대값");
			
		else System.out.print("c가 최대값"); 
				
	//방법2	
		if(a>b){	
			if(a>c)	
				System.out.print("a가 최대값");	
			}
		else if(b>c)
			System.out.print("b가 최대값");

		else 
			System.out.print("C가 최대값");
			
	//방법3
		int aa=50;
		int bb=200;
		int cc=100;
		int Maxbang=-900; //항상 안나올만한 수를 임의로 작성한다
				
		if(aa>bb)	
			Maxbang=aa;
		else	
			Maxbang=bb;

		if(Maxbang<cc)	
			Maxbang=cc;
			System.out.println("최대값은"+Maxbang); 

	//방법4.
		int[] bae={100,200,30,60,70,5,550};
		int max2=-1; //올 수 없는 임의의값
		
		for (int i=0;i<bae.length;i++) {
			if(max2<bae[i])
				max2=bae[i];	}
		System.out.print(max2); 
	}
}
