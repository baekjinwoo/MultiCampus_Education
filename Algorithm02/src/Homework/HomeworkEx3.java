package Homework;

import java.util.Scanner;

//3.int decimal = 10;
//10진수를==> 2진수 변경 : 00000000000000000000000000001010(2)
//Integer.toBinaryString(10)


public class HomeworkEx3 {
	public static void main(String[] args) {
/*		Stack st =new Stack();
		Scanner sc= new Scanner(System.in);
		System.out.print("정수를 입력하시오: ");
		int a=sc.nextInt();
		int tmp=0;
		
		for(int i=a; i>0; i=a/2){ //10부터~0까지 
			tmp=i%2;
			st.push(tmp);
			if(i==1){
				st.push(tmp);
			}
		}*/
		
		
		
		//양의 정수일 경우=>2진수로
		/*Scanner sc = new Scanner(System.in);
		System.out.print("십진수 정수를 입력하시오: ");
		int a = sc.nextInt();
		char[] s = new char[32];
		for (int i = 0; i < s.length; i++) {
			s[i] = '0'; //char형 //s[i]=48;
			System.out.print(s[i]);
		}
		int len = 0;
		while(true){
			s[len]=(char)(a%2+48); //2진수일경우 %2
			len++;
			a=a/2;
			if(a==0) break;
		}
		System.out.println();
		System.out.println("==결과출력==");

		//for(int i=s.length-1; i>=0;i--){
		for(int i=len-1; i>=0;i--){  //원래는 for(int i=0; i<s.length; i++)인데 역순한 값.
			System.out.print(s[i]);
		}
		System.out.println();*/
		
		
		
		
		
		
		// 음의 정수일 경우=> 양의 정수 => 2진수(=> 1의보수 => 2의보수)
		Scanner sc = new Scanner(System.in);
		System.out.print("십진수 정수를 입력하시오: ");
		int n = sc.nextInt();
		System.out.println("값비교=" + Integer.toBinaryString(n));

		int sign = 0;
		if (n < 0) {
			n = n * -1;
			sign = 1;
		}

		char[] s = new char[32];// 양수저장용
		char[] s2 = new char[32]; // 음수저장용 //음수-이진수(2의보수)
		for (int i = 0; i < s.length; i++) {
			s[i] = '0';// 48 //0으로 초기화
			s2[i] = '0';// char형 //s[i]=48;
		}
		int len = 0;
		while (true) {
			s[len] = (char) (n % 2 + 48); // 2진수일경우 %2
			len++;
			n = n / 2;
			if (n == 0)
				break;
		}
		System.out.println(sign);

		// 2-3. 1의 보수: 0->1 변경 1->0 변경
		if (sign == 1) {
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '1')
					s[i] = '0';
				else
					s[i] = '1';
			}

			// 2-4. 2의 보수: 1의 보수+1
			//
			int up = 1;
			if (s[0] == '0') {
				s[0] = '1';
				for (int j = 1; j < s.length; j++) {
					s2[j] = s[j];
				}
			} else if (s[0] == '1') {
				for (int j = 0; j < s.length; j++) {
					if (up == 1) {
						if ((s[j] - '0' + up) == 2) {
							s2[j] = '0';
							up = 1;
						} else if ((s[j] - '0' + up) == 1) {
							s2[j] = '1';
							up = 0;
						}
					} else {
						s2[j] = s[j];
					}
				}
			}
		}

		System.out.println("===출력결과===");
		if (sign == 0) {
			for (int i = s.length - 1; i >= 0; i--) {
				System.out.print(s[i]);
			}
		} else if (sign == 1) {
			for (int i = s.length - 1; i >= 0; i--) {
				System.out.print(s2[i]);
			}
		}
		System.out.println();
	}
}
