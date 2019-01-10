package homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hm30 {
	public static void main(String[] args) {
	//문제. binary search 로직 만들기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾고싶은 숫자 입력>> ");
		int tofind = sc.nextInt();
		
		int[] s = { 5, 9, 13, 63, 71, 99, 278, 640, 891 };
		int start = 0;
		int finish = s.length;
		int mid = (start + finish) / 2;
		int result = -1;

		while (start <= finish) {
			mid = (start + finish) / 2;
			if (s[mid] > tofind)
				finish = mid - 1;
			else if (s[mid] < tofind)
				start = mid + 1;
			else {
				result = mid;
				System.out.println(mid+1 + "번째에 있습니다");
				break;
			}
		}

		if (result == -1)
			System.out.println("찾는 데이터가 없습니다");
	}
}

/*
 * //또 다른 풀이법
public class hm30 {
	public static void main(String[] args) {
		Random rd=new Random();
		Scanner sc= new Scanner(System.in);
		System.out.print("뽑을 숫자:");
		int dap=sc.nextInt();
		int bae[] ={1,9,22,25,35,43,55};
		
		int result=0;
		int first=0;
		int end=bae.length;
		int bum;
		int a=0;
		
		while(a>=3){ //true는 안하기루~
 			bum=(first+end)/2;
			if(dap>bae[bum]){
				first=bum+1;
			}
						
			else if(dap<bae[bum]){
				end=bum-1;
			}
			
			else if(first<=end){ //dap==bae[bum]
				result =bum;
				break;}	
		}
		if(result==0)
			System.out.println("없는 숫자입니다");
		else
		System.out.println(result+1);
		
		
	
		//continue하니까 무한스캐너...
		//break로 하니까  없는수 누르면 1이 뜨는 이유는?

		/*for(int i=0;i<bae.length;i++){   // 경우의수 1.만약에 입력값과 bae값이 다르다면 while(true)에서 break?
			if(dap!=bae[i])					// 경우의수 2.만약에 입력값과 bae값이 다르다면 while(a>10)에서 a=10; (flag기법?)
				a=10;						// 경우의수 3.카운터라는 것을 넣어야할텐대..
	}
}
*/