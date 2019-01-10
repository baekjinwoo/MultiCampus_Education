package test1;

/*class MyThread implements Runnable{
	@Override
	public void run(){
		System.out.println("Hello Thread");
	}
}

public class LambdaEx3 {
	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		Thread t = new Thread(mt);
//		t.run();

		
		new Thread(new MyThread()).run();
	}
}
*/



//----------------------------------------------------------------------------------------------------------



/*public class LambdaEx3 {
	public static void main(String[] args) {

		
		//익명함수
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello Thread");
			}
		}).start();
	}
}*/



//----------------------------------------------------------------------------------------------------------



//람다식으로 변환
public class LambdaEx3 {
	public static void main(String[] args) {
		new Thread( 
		() -> {System.out.println("Hello Thread"); } 
				   ).start();
	}
}

