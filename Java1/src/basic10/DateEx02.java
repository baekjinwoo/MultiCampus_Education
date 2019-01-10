package basic10;

import java.sql.Date;
import java.util.*;
import java.util.StringTokenizer;

public class DateEx02 {
	public static void main(String[] args) {
	//1. 정규식표현
	//2. p.514 StringTokenizer
		String source="100,200,300,400";
		StringTokenizer st=new StringTokenizer(source,",");
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
			
			
	//3. p.518 BigInteger(" ") 문자열, BigInteger.valueOf( ) 숫자
	//4. StringBuilder
		String aa="babo";
		String bb="ondal";
		String cc=aa+bb;
		System.out.println(cc); //aa와 bb를 지우고 cc에 저장. 변화가 있을때는 String보다 StringBuffer를 써라
				
		StringBuffer sb1=new StringBuffer("java");
		StringBuffer sb2=new StringBuffer(10); //StringBuffer는 기존의 값을 버리지않고 추가하는것이다. 숫자10이아니고 10칸이라는 공간을 만드는 것
				
		System.out.println("sb1.length:"+sb1.length());
		System.out.println("sb2.length:"+sb2.length());
				
		sb2.append("java"); //sb2가 1000번지라면 번지는 그대로.
		System.out.println(sb2);
		sb2.reverse();
		System.out.println(sb2);
		sb2.delete(1, 2); //1이상 2미만 번지의 값을 제거
		System.out.println(sb2);
		sb2.replace(0, 2, "va"); //0이상 2미만 번지의 값을 va로 교체하기
		System.out.println(sb2);
		if(sb1.equals(sb2)) //번지비교 x 값비교
			System.out.println("equal");
		else
			System.out.println("not equal");
		
			
		//5. 재귀호출: 자기가 자기를 호출한다
		int result=factorial(4);
		System.out.println(result);
						//6. Date
		Date d=new Date(0);
		String s=d.toLocaleString();
		System.out.println("현재시간:"+s);
		//내장객체에는 1.class(안만듬), 
				// 2.new(도 안만듬)
					
		Date d2=new Date(1078697968786L);
		String s2=d2.toLocaleString();
		System.out.println("설정된 시각: "+s2);
		
		Date d3=new Date(2018,11,6);
		String s3=d3.toLocaleString();
		System.out.println("현재시간은"+s3);
		
		}//main_end
			
	static int factorial (int n){
		int result=0;
	
		if(n==1) result=1;
		else result=n*factorial(n-1);
	
		return result;
	}
}
