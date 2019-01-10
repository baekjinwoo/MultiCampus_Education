package StringEx;

public class StringTokenineEx {
	public static void main(String[] args) {
		
	String str="학교,집,학원,,게임방,술집,도서관";
	String[] value=str.split(",");  //구분자는 1개만 사용 //구분자를 단 한개밖에 못쓴다.
	
	for(int x=0; x<value.length; x++)
	{
		System.out.println(value[x]);
	}
	
	
/*		String str = "학교,집,학원,,게임방$술집$도서관";
		
		//StringTokenizer ob = new StringTokenizer(str,delim); //delim: 구분자를 의미한다.
		StringTokenizer ob = new StringTokenizer(str,",#$"); //구분자를 여러개 쓸 수 있다.
		System.out.println("파싱할 문자수:"+ob.countTokens()+"\n");
		
		while(ob.hasMoreTokens()){
			System.out.println(ob.nextElement());
		}*/
	
	
	
	
	
	}
}
