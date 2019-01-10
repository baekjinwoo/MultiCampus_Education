package Stack;

import java.util.Stack;


//멀티쓰레드는 Stack과 반대개념이다.
public class Stack1 {
	public static void main(String[] args) {
		Stack st= new Stack();
		System.out.println(st.isEmpty());
		st.push(100);
		st.push("stack");
		st.push(new Stack1()); 
		System.out.println(st.peek()); 
		System.out.println();
		//100 "stack" 객체 순서로 저장되어있다
	
//		st.pop();
//		st.pop();
//		st.pop();
//		st.pop(); //Stack에 아무것도 없는대 pop을 했기때문에 에러

		int cnt=0;
		while(!st.isEmpty()){ //위의 에러때문에 isEmpty로 반복문을 돌려주어야한다.
		System.out.println(st.pop());
		System.out.println(++cnt);
		}
	}
}
