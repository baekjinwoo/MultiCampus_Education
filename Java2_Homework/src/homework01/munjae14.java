package homework01;

import java.util.StringTokenizer;

/*[문제14] 문자열변수에 "10*30*20*40*50"를 대입한후 StringTokenizer클래스를 
         이용하여 다음결과를구하시오
         String str="10*30*20*40*50";   Integer.parseInt()사용

[출력화면]
10+30+20+40+50 = 150*/

public class munjae14{ 
	public static void main(String[] args)  {
		String str = "10*30*20*40*50";
		int sum = 0;
		
		StringTokenizer ob = new StringTokenizer(str,"#*");
		
		while(ob.hasMoreTokens()){
				sum+=Integer.parseInt(ob.nextToken());
		}
		System.out.println(str.replace('*','+')+"="+sum);

		
		
	}
}
