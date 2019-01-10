package List1;

import java.util.Scanner;

public class Array3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int a= sc.nextInt();
		
//		char[][] star = new char[a][a];
//		for(int i=0; i<star.length; i++){ //i번째 줄
//			for(int j=0; j<=i; j++){ //j개 뽑기
//				star[i][j]='*';
//			}
//		}
		
		//1번
		for(int i=0; i<=a; i++){
			for(int j=0; j<=a; j++){
				if(i>j){
					System.out.print("*");
				}
				else
					System.out.print(" ");
			}
		System.out.println();
		}
		
		//2번
		for(int i=0; i<a; i++){
			for(int j=a; j>i; j--){
				System.out.print("*");
			}
		System.out.println();
		}
		
		//3번
		for(int i=0; i<a; i++){
			for(int j=a-1; j>i; j--){
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++){
				System.out.print("*");
			}
		System.out.println();
		}
		
		//4번
		for(int i=0; i<a; i++){
			for(int j=0; j<i; j++){
				System.out.print(" ");
			}
			for(int k=a; k>i; k--){
				System.out.print("*");
			}
		System.out.println();
		}
		
		//5번
		for(int i=1; i<=a; i++){
			for(int j=a; j>i; j--){
				System.out.print(" ");
			}
			for(int k=1; k<=(i*2)-1; k++){
				System.out.print("*");
			}
		System.out.println();
		}
	}
}
