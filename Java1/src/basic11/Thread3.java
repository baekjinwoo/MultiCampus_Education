package basic11;

class RunnableThread implements Runnable{
	String str; //필드

	RunnableThread(String str){ //생성자
	this.str=str;
	}
	
	public void run(){ //start -> run()
		for(int i=0;i<10;i++){
			System.out.println(i+" "+str);
		}
	}
}

public class Thread3 {
	public static void main(String[] args) {
		
		RunnableThread r1;
		r1=new RunnableThread("아군!빵야!"); //클레스 객체
		
		Thread t1=new Thread(r1); //쓰레드 객체생성
		//Thread t1=new Thread (new RunnableThread("아군!빵야");
		
		Thread t2=new Thread(new RunnableThread("적군!빵빵")); //쓰레드 객체생성
		//(클래스 객체 생성+ 쓰레드 객체 생성)
		t1.start(); //run()메소드 가동하기
		t2.start(); //run()메서드 가동하기
		System.out.println("main end...");
	}
}

