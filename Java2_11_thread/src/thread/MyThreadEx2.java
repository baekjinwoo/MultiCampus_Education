package thread;


//Multi thread (Thread 상속)
public class MyThreadEx2 extends Thread {  //Thread를 상속받음으로써, import를 할 필요가 없다.
	
	String str;
	int num;
	
	public MyThreadEx2(String str, int num){
		this.str=str;
		this.num=num;
	}
	
	@Override //상속받은것임을 알 수 있다(재정의)
	public void run(){
		for(int i=1;i<=num;i++){
			try{
			System.out.println(str+":"+i);
			Thread.sleep(30);
			}catch(InterruptedException e){
	//			e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThreadEx2 ob1 = new MyThreadEx2("one",50);
		MyThreadEx2 ob2 = new MyThreadEx2("two",50);
		MyThreadEx2 ob3 = new MyThreadEx2("three",50);
		
//single thread 실행과 같다
//		ob1.run();
//		ob2.run();
//		ob3.run();
	
		
//multi thread 실행으로, 번갈아가면서 실행된다.
		ob1.start();
		ob2.start();
		ob3.start();
		
	}
}
