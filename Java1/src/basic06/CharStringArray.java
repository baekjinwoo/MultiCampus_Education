package basic06;

public class CharStringArray {
	public static void main(String[] args) {
		//String 배열&char배열
		
		String[] str1=new String[3];
		str1[0]="babo";
		str1[1]="ondal";
		str1[2]="kongjoo";
			
		String[] str2={"babo","ondal","kongjoo"}; //위와 아래는 같은 내용이다.
			
////////////////////////////////////////////////////////////////////////
		
		char ch1[]= {'A', 'B','가'};

		char[] ch2=new char[3];
		ch2[0]='A';
		ch2[1]='B';
		ch2[2]='가';

////////////////////////////////////////////////////////////////////////
		
		
      //char에 babo를 넣고싶다면? (String => char[])
	 //char는 한글자밖에 못넣어서 안되기 때문에 아래와 같이 배열을 쓴다
		String str3="babo";  System.out.println(str3);
		char[] ch3={'b','a','b','o'}; System.out.println(ch3);

////////////////////////////////////////////////////////////////////////
		
	  //String에 babo를 분리하고싶다면? (char[] ->String)
		char[] ch5= str3.toCharArray(); //str3.toCharArray()는 String => char[]로 바꾸겟다는 의미
		System.out.println(ch5[3]+"\n"); //변환상태를 출력
		ch5[3]='a'; //변환된 낱개문자를 바꿀 수 있다
		for (int i=0;i<ch5.length;i++) {
			System.out.println(ch5[i]+"     ");
		}
		System.out.println();
		
		String str7=new String(ch5); //char[]=>String(한 배열창고)으로 바꾸려면, 이와같이 쓴다.
		System.out.println(str7);	
	}
}
