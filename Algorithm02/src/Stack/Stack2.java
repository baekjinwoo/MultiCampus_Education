package Stack;

import java.util.Stack;


//p83. 괄호짝 맞추기
public class Stack2 {
	public static boolean match(char[] cs) { 
		boolean result = false;
		Stack<Character> stack = new Stack<Character>();
		char [] open= {'{' , '<', '[', '('};
		char[] close = {'}', '>', ']', ')'};
		// cs[0]: open 데이터중 1개 일치:push
		// cs[0]: close 데이터중 1개 일치:
		// 예) cs[0] 데이터와 close[2] 동일하다면,  pop한 데이터와 open[2]동일
		// 스택 empty할때까지

		outer:for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < open.length; j++) {
				
				
				if (cs[i] == close[j]) {
					if(!stack.isEmpty()){
						char tmp= stack.pop();
						System.out.println(tmp+"푸쉬");
						if(tmp==open[j]){
							result=true;
						}
						else{
							result=false;
							break outer;
						}
					}
				}
				
				
				else if(cs[i]==open[j]){
					stack.push(cs[i]);
					System.out.println("cs["+i+"]="+cs[i]+"푸쉬");
				}
			}
		}
		return result;
	}
		
	public static void main(String[] args) {
	    //char[] first = { '(','[', '<', '{', '}', '>', ']', ')' };
		char[] second = {'(','[', '<', '{', '>', '}', ']', ')' };
		//char[] third = { '(', 'a', 'c', ')', '[', '{', '}', ']' };
		//System.out.println(match(first)); // t
		System.out.println(match(second)); // f
		//System.out.println(match(third)); // t
	}
}

//p85. 괄호짝찾기, 연산수식, 회문(거꾸로 읽어도 같은 문자)
//기러기, RACECAR, 소주만병주소, 이자바.......
//문자열길이/2만큼 pop한다