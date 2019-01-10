package DictionarySearch;

import java.util.Scanner;

public class DictionarySearch {
	public static void main(String[] args) {
		//나중에는 words와 meaning을 DB를 통해서 받아온 값으로 시작할 수 있어야한다
		
		String []words = {"friend", "boy", "girl", "close", "open", "school", "play", "study", "work", "sleep"};
		String []meaning = {"친구","소년","소녀","닫다","열다","학교","놀다","공부하다","일하다","잠자다"};
				
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고자 하는 단어 입력: ");
		String input = sc.next();
		
		boolean flag= false; //미등록단어를 확인하기위해
		
		
		//반복문의 범위를 줄이기위해 Tree를 쓰자
		for(int i=0; i<words.length;i++){
			if(input.equalsIgnoreCase(words[i])){
				System.out.println(meaning[i]);
				flag= true;
				break;
				
			}
			System.out.println((i+1)+"번 반복중"); //반복횟수를 알기위해
		}//for-end
		if(flag==false){
			System.out.println("사전에 미등록 단어입니다");
		}
	}
}
