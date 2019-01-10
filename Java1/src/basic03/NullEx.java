package basic03;

public class NullEx {
	public static void main(String[] args) {
		//1. null(주소값없음)과 ""(내용값이 없음)의 구별법
		//system.out.println(str1==null && str1==""); //false
		//앞으로 어떤 방이 비어있을때, null로 비어있는지 ""로 비어있는지를 알기위해서 아래와같이 비교해서 알아낸다.
				
		String str2=null;
		String str3="";
		String result2=(str2==null||str3=="")?"null이다":"컴마"; 
		System.out.println(result2);	

		//2. 객체.메소드를 이용해서 null과 ""비교 (그래서 String의 첫글자가 대문자이다)

		String result3=(str2==null||str3.length()<0)?"null이다":"컴마";
		//String result3=(str2==null||str3.length()==0)?"null이다":"컴마";
		System.out.println(result3);	
	}
}
