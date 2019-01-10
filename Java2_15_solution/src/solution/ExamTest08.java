package solution;

import java.io.IOException;
import java.util.Scanner;

/*[문제8]3자리 정수를 입력받아서 각각 자리수의 합을 구하시오.

[결과 화면]
3자리 정수를 입력하세요 :457
3자리의 합은 16 입니다.
*/
public class ExamTest08 {
	public static void main(String[] args){

//		Scanner sc = new Scanner(System.in);
//		int sum=0;
//
//		System.out.print("3자리 정수를 입력하세요: ");
//		while(sc.hasNextLine()){
//			int a= sc.nextInt();
//			sum+=((a/100)+(a%100/10)+(a%100%10)); //첫자리는 /만
//												  //끝자리는 %만
//												  //중간자리는 %하고 /
//			break;
//		}
//		sc.close();
//		System.out.println("3자리의 합은"+sum+"입니다");

		
		Scanner sc = new Scanner(System.in);
		int s=0;
		System.out.print("3자리 정수를 입력하세요: ");
		String b= sc.nextLine();
		for(int i=0; i<b.length(); i++){
			s+=Integer.parseInt(b.charAt(i)+"");
		}
		System.out.println(s);
		
	}
}

