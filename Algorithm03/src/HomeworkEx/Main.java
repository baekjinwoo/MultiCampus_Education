package HomeworkEx;

import java.util.Scanner;

//Main 클래스 생성:
//10번 호출 WordBST.insert메소드("friend"); //배열안의 단어를 바꿔가면서 insert메소드를 10번 호출하도록  //WordNode의 word변수 사전식 정렬 (알파벳순으로 누가먼저나오는지를 비교)
//WordBST.find메소드("boy"); //meaning을 return  ==> 있으면, 소년
//WordBST.find메소드("boy"); //meaning을 return  ==> 없으면, 미등록단어

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word[] = 
			{"friend", "boy","girl","close","open","school","play","study","work","sleep"};
		String meaning[] = 
			{"친구",  "소년", "소녀", "닫다", "열다", "학교", "놀다", "공부하다", "일하다", "잠자다"};
		WordBST bst = new WordBST();
		
		for(int i=0; i<word.length; i++){
			bst.insert(word[i], meaning[i]);
		}
		
		System.out.print("찾고 싶은 단어를 입력하세요 : ");
		String mm = sc.next();
	    String temp = null;
	    
		temp = bst.find(mm); 
		
		if(temp == null){
			System.out.println("미등록단어");
		}else{
			System.out.println(temp);
		}
		
		
		}
}

