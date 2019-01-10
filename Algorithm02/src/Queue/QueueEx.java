package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Stack: LIFO ==마지막에 넣은 데이터를 먼저 제거
//Queue: FIFO == 먼저 넣은 데이터를 먼저 제거
public class QueueEx {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("+  -  =중에서 하나를 입력하세요");
		// + :번호표 1출력
		// - :1번 업무처리
		// ...
		
		
		int number = 1; //번호표
		Queue<Integer> q = new LinkedList<>(); //Queue<> q =new Queue<>();안된다. Queue객체가 안되기때문에 LinkedList를 쓴다
		
		while(true){
			String input = sc.next();
			//+눌렀을 때
			if(input.equals("+")){
				q.add(number); //1 2 3  
				System.out.println("번호표 "+number+"번 고객 대기중....");
				number++;
			}
			//-눌럿을 때
			else if(input.equals("-")){
				if(!q.isEmpty()){
					Integer output= q.poll(); //1 2 3				
					System.out.println(output+"번 고객 업무 처리중....");
				}
				else{
					System.out.println("대기중인 모든 고객 처리 완료");
				}
			}
			//=눌럿을 때
			else if(input.equals("=")){
				System.out.println("오늘 업무 마감");
			}
		}
	}
}
