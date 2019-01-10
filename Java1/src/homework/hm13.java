package homework;

import java.util.Scanner;

public class hm13 {
	public static void main(String[] args) {
	//문제. 문자열 5개를 준비한 후 년도를 입력받아 윤년이면 오름차순 출력, 평년이면 내림차순으로 출력한다. (메소드 형식을 사용해라)
		String[] s={"apple", "candy", "pencil", "david", "folder"};
		
		System.out.print("연도를 입력하시오: ");
		Scanner sc=new Scanner(System.in);
		int y=sc.nextInt();
		
		year(y,s);
		
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
	}
	
	public static void year(int y,String[] s){
		String imsi="null";
		if(y%4==0&&y%100!=0||y%400==0){
			System.out.print("윤년이다");
			for(int i=0;i<s.length;i++){
				for (int j=i+1;j<s.length;j++) {
					if(s[i].charAt(0)>s[j].charAt(0)){// 문자열의 첫글자를 비교
						imsi=s[i];					//오름차순
						s[i]=s[j];
						s[j]=imsi;
					}
				}
			} 
			System.out.println();
		}
		else {
			System.out.print("평년이다");
			for(int i=0;i<s.length;i++){
				for (int j=i+1;j<s.length;j++) { 
					if(s[i].charAt(0)<s[j].charAt(0)){// 문자열의 첫글자를 비교
						imsi=s[i];					//내림차순
						s[i]=s[j];
						s[j]=imsi;
					}
				}
			}
		}
	}
}