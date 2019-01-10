package basic02;

import java.util.Scanner;

public class ScannerEx02 {
	public static void main(String[] args) {
		/* String을 가지고 문자로 받아들여 숫자로 표현하기 
		 * Scanner입력에서 nextint은 연속으로 쓸때는 에러가 생길수있으니 nextline 문자열로 받아서 처리하는게 낫다.
		 * 그렇게 되면 뭐든지 문자로 들어온다. 그래서 문자열이 아니라도 String을 쓰는데
		 * (String) 자료형+ 변수 =Integer.parseInt(string변수);
		 * 자료형+변수=double.parsedouble(String변수)로 받아들인 문자열의 따옴표를 제거 "3"->3  */

		Scanner ss=new Scanner(System.in);
		System.out.print("입력해주세요");
			
		String aa=ss.nextLine();
		double dd=Double.parseDouble(aa);
		//double dd=ss.nextDouble(); 


		//Scanner입력을 바로 double로 써도되지만 위와같이 string으로 불럿다가 parse로 변환시키는게 안전하다. 
		//숫자->숫자가 아닌 문자->숫자를출력하고자 할때는
		
		System.out.println(dd);
	}
}
