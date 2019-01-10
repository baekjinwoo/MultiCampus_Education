package homework07;

import java.util.StringTokenizer;

/*[문제3-2] emp.txt파일을 읽어서 출력하시오
파일명 : EmpInputTest.java
처리조건 : StringTokenizer을 이용해서 데이타를 파싱하여 
            아래와 같이출력하시오

[출력결과]
이름 : 강호동   부서 : 개발부   급여 150000
이름 : 이순신   부서 : 영업부   급여 250000


*/

public class StringTonkenizerEx {
	public static void main(String[] args) {
		//String str="학교,집,학원#게임방$도서관,술집";
		//StringTokenizer token=new StringTokenizer(str,",#$");
		
		String str="학교		집	학원		게임방	도서관	술집";
		StringTokenizer token=new StringTokenizer(str,"\t");
		
		System.out.println("파싱된 문자열의 수:" + token.countTokens()+"개");
		while(token.hasMoreTokens())
		{
			System.out.println(token.nextToken());
		}
	}
}
