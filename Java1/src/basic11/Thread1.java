package basic11;

class ThreadExam extends Thread{ //Thread는 내장함수이고, ThreadExam을 상속
	public void run(){
		System.out.println(getName()+"쓰레드라고전해라~"); //자동으로 이름을 붙인다.
	}
}

public class Thread1 {
	public static void main(String[] args) {
		//ThreadExam은 내장함수가 아니기때문에 클래스 만들어줘야함
		ThreadExam aa=new ThreadExam(); 
		ThreadExam bb=new ThreadExam(); //방을 만들어 놓음
		
		//ThreadExam쓰레드 가동
		//(run()함수 호출)
		aa.start();
		bb.start(); 
	}
}
