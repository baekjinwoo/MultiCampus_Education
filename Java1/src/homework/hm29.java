package homework;

import java.util.*;

//문제.  원래 자바것을 안쓰고 내가만드는스택 "MyStack만들기" push와 pop은 메소드로 처리.
public class hm29 extends Vector{
	int max;
	
	public Object pop(){
		Object rob = "**pop할 데이터가 없음**";
		
		if(size()!=0){
			Object obj = elementAt(size()-1);
			removeElementAt(size()-1);
			rob=obj;
		}
		return rob;
	}
		
	
	public void push(Object item){
		if(size()>=max){
			System.out.println("**Stack 용량 초과**");
			return;
		}
		add(item);
	}
	
	public hm29(int max){
		this.max = max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hm29 my = new hm29(2);
		
		my.push(new Integer(4));
		my.push(new Integer(5));
		my.push("eieiei");
		
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
	}
}

/*
 * 또 다른 풀이.
class MyStack extends Vector{
	//int munja=Integer.parseInt();
	
	public Object push(Object item){
		addElement(item);
		return item;
	}	
	public Object pop(){
		Object obj=peek();
		removeElementAt(size()-1);
		return obj;		
	}
	public Object peek(){
		int len=size();
		if(len==0)
			throw new EmptyStackException();
		return elementAt(len-1);
	}
	public MyStack(){
		
	}
}

public class Munjae2 {

	public static void main(String[] args) {
	MyStack mst1= new MyStack();
	//MyStack mst2= new MyStack(5); //top길이 5로 제한
	
	mst1.push("지운것");
	mst1.push("또 지운것");
	mst1.push("역시 지운것");
	
	mst1.pop();
	System.out.println(mst1);
	
	}
}
 * 
 */