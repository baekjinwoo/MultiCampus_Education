package HomeworkEx;

import java.util.Scanner;

public class Search6174 {
	public static void main(String[] args) {
/*1. 입력 첫번째 데이터: 테스트 숫자 갯수 1
 *2. 1개 4자리 숫자들 (4자리 동일한 숫자 제외)
 
 (3-4번 반복)
 *3. 4자리 분리: 문자 2008: '2' '0' '0' '8' 
 *4. 정렬: 오름차순: 가장 작은 값
 *         내림차순: 가장 큰 값
 
 *
 *5. 뺄셈결과 == 6174 될때까지
 *6. 갯수 
 * 
 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("4자리 숫자 하나입력(동일숫자제외): ");
		String a = sc.next();
		int cnt = 0;
		if (a.equals("6174")) {
			System.out.println(cnt);
			return;
		}
		char[] c = a.toCharArray();
		int result = 0;
		Search6174 s = new Search6174();
		while (true) {
			cnt++;
			int max = sort(c, true); // 큰수(내림차순)
			int min = sort(c, false);// 작은수(오름차순)
			System.out.println(max + ": " + min);
			result = max - min;

			if (result == 6174) {
					break;
				}
			c= s.change(result);
			}
		System.out.println(cnt);
		}
	
	
	
	
	public static int sort(char[] c, boolean flag){
		if(flag == true){ //내림차순
			for(int i=0; i<c.length-1; i++){
				for(int j=i+1; j<c.length; j++){
					if(c[i]<c[j]){
						char temp=c[j];
						c[j]=c[i];
						c[i]=temp;
					}
				}
			}
		}
		else{ //오름차순
			for(int i=0; i<c.length-1; i++){
				for(int j=i+1; j<c.length; j++){
					if(c[i]>c[j]){
						char temp=c[j];
						c[j]=c[i];
						c[i]=temp;
					}
				}
			}
		}
		//2008 {8200 0028}
		//숫자 생성
		//'0' 문자 0으로 입력되어져 있다
		// c[0] - '0' = 8
		// c[1] - '0' = 8*10 + 2
		// c[2] - '0' = (8*10+2)+0;
		// c[3] - '0' = ((8*10+2)+0)*10;
		int sum=0;
		for (int i=0; i<c.length; i++){
			sum= sum*10+ (c[i]-'0');
		}
		
		return sum; //sort메소드 종료
	}//sort end
	
	
	//굳이 char[]배열로 안받고 String으로 입력받은 값을 toString으로 반환할 수 있다
	public char[] change(int num){
		char[] result= new char[4]; //캐릭터 배열4개선언해주고
		for(int i=result.length-1; i>=0; i--){
			result[i] = (char)(num %10 +'0');
			num= num/10;
		}
		return result; //끝나면서 그 배열을 반환할 것이다
	}
}
