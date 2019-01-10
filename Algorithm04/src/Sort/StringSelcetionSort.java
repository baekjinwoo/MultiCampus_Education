package Sort;

public class StringSelcetionSort {
	public static void main(String[] args) {
		String str[] = {"1234","123as가","jave","GOOD","한글","자바","java","JAVA"};
		
//Selection Sort이용
//한글먼저 -영소문자- 영대문자-숫자정렬 
		
//System.out.println(str[0].compareToIgnoreCase("java"));
//str[0].toCharArray(); //char는 1,2,3,4 낱개로 아스키코드값을 비교해서
		
//CompareTo가 음수가 나오면 "앞문자 더 크다, 먼저 정렬되야한다"
//CompareTo가 양수가 나오면 "뒤문자 더 크다, 먼저 정렬되야한다"
//CompareTo가 0이 나오면 "같다"
		

//System.out.println("1234".compareTo("자바")); //-51039음수
//1234_순서(1) - 자바_순서(2) : 음수라면, 숫자가 더 먼저온다
	
//System.out.println("자바".compareTo("1234")); //51039
//자바_순서(2) - 1234_순서(1) : 양수라면, 숫자가 더 먼저온다
		
		
		//한글-소문자-대문자-숫자 이중포문공식
		for(int i=0; i<str.length; i++){
			int index=i;
			for(int j=i+1; j<str.length; j++){
				System.out.println(index);
				if(str[j].compareTo(str[index])>0){    //
					index=j;
					//최소값: 오름차순
					//최대값: 내림차순(사전 역순)
				}
			}
			//최대값 앞 정렬
			String temp = str[index];
			str[index]=str[i];
			str[i]=temp;
		}
		System.out.println("정렬결과출력");
		for(int i=0; i<str.length; i++){
			System.out.print(str[i]+"  ");
		}
		System.out.println();
		
//==================================================================================================================	

		
		
		
		
//오답		
//		System.out.println();
//		System.out.println(str[1]);
//		for(int i=0; i<str.length;i++){
//			char c[]=str[i].toCharArray();
//			if(c[0]>='1' && c[0]<='1'){
//				System.out.println(c);
//			}
//			if(c[0]>='A' && c[0]<='Z'){
//				System.out.println(c);
//			}
//			if(c[0]>='a' && c[0]<='z'){
//				System.out.println(c);
//			}
//		}
	}
}
