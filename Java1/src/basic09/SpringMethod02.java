package basic09;


//1-2. indexof: 원하는 문자가 "주어진 문자열"에 있는지를 확인하기 위한 메소드 
//(처음에 주어진 문자가 있는지를 확인할때 주로 사용한다)
public class SpringMethod02 {
	public static void main(String[] args) {
		String aa="kajajomal";
		String bb="mal";
					
		if(aa.indexOf(bb)!=-1){ //aa라는 문자열안에 bb라는 문자열의 첫 문자가 있는지를 확인하는 것
		    	 	  //포함되어있으면 결과값이 들어가고, 포함안되있으면 -1이 들어감
			System.out.println("있네~~");
			System.out.println(aa);
			System.out.println(aa.indexOf(bb)); 
		}
		else
			System.out.println("없구만~~");
		System.out.println();
		System.out.println();
		
////////////////////////////////////////////////////////////////////////////
		

/*1-2. (도서관리 프로그램문제) 문자열배열을 잡아 easy java, java ragonahalka, ok java를 입력한 후, 
		자바가 들어간 책만 출력하시오.(indexOf를 이용할 것) */
	String[] st={"easy java","java ragonahalka","ok java"};
	System.out.println("<<<java관련 책이 있는지 확인하자>>>");
		
	for(int i=0;i<st.length;i++){
		if(st[i].indexOf("java")!=-1){ //java의 j가 st[i]에 있는지를 확인하는 조건
			System.out.print(st[i]); //j를 포함하는 st[i]를 출력한다
			System.out.println(st[i].indexOf("java")+" 위치해 있다"); //st[i]마다 j의 위치를 출력한다.
	}
		else
			System.out.println("java관련 책은 없다");
	}
	System.out.println();
	}
}


