package homework;

import java.util.Scanner;

//참고로 달팽이 알고리즘은 생략.
public class hm19 {
	public static void main(String[] args) {
	/*문제. 문자열 3개를 입력받아 배열에 넣고 문자를 변형하여 출력하시오
	 	ex) "ondal"----> "olnad"로 출력 	
	 	 	"babo" ---> "boab" 		
			다음의 규칙은 맨 앞글자 한 번, 맨 뒷글자 한 번 번갈아가면서 적은 문자열이다. 		*/
		Scanner sc = new Scanner(System.in);
		
		String[] str = new String[3];
	
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
	 
		for (int j = 0; j < str.length; j++) {
			char[] char2 = str[j].toCharArray();
			int n = char2.length;
			
			if(n%2 == 0){
				for (int i = 0; i < n/2; i++) {
					System.out.print(char2[i]);
					System.out.print(char2[n-1-i]);
				}
				System.out.println();
			}
			else{
				for (int i = 0; i < n/2; i++) {
					System.out.print(char2[i]);
					System.out.print(char2[n-1-i]);
				}
				System.out.print(char2[n/2]);
				System.out.println();
			}//else
		}//for
	}//main_end
}


/*
또 다른 풀이방법
	// 문자열 3개 입력받아 배열에 넣고 문자를 변형하여 출력하시오
	// ex> "ondal" --> "olnad"로 출력
	// "babo" --> "boab"

	Scanner sc1 = new Scanner(System.in);
	String[] arr = new String[3];
	for (int i = 0; i < arr.length; i++) {
		System.out.printf("arr[%d]=", i);
		arr[i] = sc1.nextLine();
	}


	char[][] ch = new char[arr.length][];
	for (int i = 0; i < arr.length; i++) {
		ch[i] = arr[i].toCharArray();
		if (ch[i].length % 2 == 0) {
			for (int j = 0, k = ch[i].length-1; j < k; j++, k--) {
				System.out.print(ch[i][j]);
				System.out.print(ch[i][k]);
			}
			System.out.println();
		} else {
			int j=0;
			for (int k = ch[i].length-1; j < k; k--) {
				System.out.print(ch[i][j]);
				System.out.print(ch[i][k]);
				j++;
			}
			System.out.print(ch[i][ch[i].length/2]);
			System.out.println();
		}
	}
}
*/
