package homework;

import java.util.Scanner;

public class hm08 {
	public static void main(String[] args) {
		/* 값을 입력받아 값의 수만큼 스타워즈를 출력하시오. 값이 만약에 5라면,
		 *      1
		 * 	   12
		 *    123
		 *   1234
		 *  12345 */ 
		
		Scanner sc=new Scanner(System.in);
		System.out.print("\n\n값을 입력하시오: ");
		String ss=sc.nextLine();
		int su=Integer.parseInt(ss);
		
		for(int i=1;i<=su;i++){
			for(int j=i;j<su;j++){ //for(int j=1; j<=aa-i; j++)
			System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				System.out.print(k);
			
			}
			System.out.println();
		}
	}
}
