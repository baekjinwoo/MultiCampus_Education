package homework;

import java.util.Scanner;

public class hm14 {
	public static void main(String[] args) {
		/*문제 
		 * BMI비만도 = "(몸무게/(키/100)의제곱)"의 결과가
		 * 30이상이면 비만
		 * 25-30 과체중
		 * 20-25 보통
		 * 20미만이면 저체중 
		 * */

		Scanner ss= new Scanner(System.in);
		
		System.out.print("몸무게를 작성하세요(kg): ");
		String input1=ss.nextLine();
		double wei=Double.parseDouble(input1);
				
		System.out.print("키를 작성하세요(cm): ");
		String input2=ss.nextLine();
		double tall=Double.parseDouble(input2);
		tall=tall/100.0;
		
		double bmi_r=wei/Math.pow(tall, 2); //제곱함수; tall을 2제곱한다는 뜻.
		double bmi=Math.round(bmi_r*100)/100.0; //반올림함수; 100곱하고 100나눠서 소수2자리까지 생성
		System.out.println("bmi값은 "+bmi+"입니다.");
		
		String gap="null"; //값에 초기치 null을 넣어준다
		if(bmi>=30)
			gap="비만";
		else if(bmi>=25)
			gap="과체중";
		else if(bmi>=20)
			gap="보통";
		else
			gap="저체중";
		
		System.out.printf("\n 당신은 현재 %s입니다",gap);
	}
}
