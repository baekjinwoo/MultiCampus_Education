package thread;


//Multi thread (Runnable 상속)
public class MyThreadEx3 implements Runnable {
	String str;
	int num;
	
	public MyThreadEx3(String str, int num){
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
//		MyThreadEx2 ob1 = new MyThreadEx2("one",50);
//		MyThreadEx2 ob2 = new MyThreadEx2("two",50);
//		MyThreadEx2 ob3 = new MyThreadEx2("three",50);
//		
////Multi_Thread로써, 번갈아가면서 실행		
//		Thread t1 = new Thread(ob1);
//		Thread t2 = new Thread(ob2);
//		Thread t3 = new Thread(ob3);
//		
//		t1.start();
//		t2.start();
//		t3.start();

		new Thread(new MyThreadEx2("one",50)).start();
		new Thread(new MyThreadEx2("two",50)).start();
		new Thread(new MyThreadEx2("three",50)).start();
		
	}
}

