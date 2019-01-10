package basic09;

//1. split: 한 문자열안에 " , , "로 나누었을때 => ,마다 분리시켜서 문자열배열을 만든다 

//2. startwith: 주어진 문자열로 시작하는지를 검사한다. (중간에 주어진 문자열이 있는지를 확인할때 주로 사용한다)
// (제시어 ex)네이버 검색란 제시어는 한 문자열로 영화코코,코코블랙,코코ost,등....
// 작성하고 split->(1)indexOf하고 (2)startwith로 키워드찾기)						*/
public class SpringMethod03 {
	public static void main(String[] args) {
		String s11="smart, kind";
		String[] bae=s11.split(",");
		System.out.println(bae[0]+"\t"+bae[1]);
				
		if(bae[0].startsWith("sm")){
			System.out.println("맞아"); //true이면 반환
		}
		else
			System.out.println("몰라"); //false이면 반환

//3-1. substring: 전광판
		String str1="Liebe";
		System.out.println(str1.substring(0,2));
		System.out.println();
						
		char c1=str1.charAt(0); //문자로 바꿔서 쓸지
		//char[] c2=str1.toCharArray(); //문자배열로 바꿔서 쓸지 고민하다가 문자배열로 쓰는건 포기.
						
				
//3-2. Liebe를 전광판처럼 돌리시오
		for(int i=0;i<4;i++){
			System.out.print(str1.substring(i,5)); 
			for(int j=0;j<i;j++){
				System.out.print(str1.charAt(j));
			}
			System.out.println();
		}		
	}
}
