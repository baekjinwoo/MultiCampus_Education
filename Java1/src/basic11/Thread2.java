package basic11;

class SimpleThread extends Thread{
	String str; //필드

	SimpleThread(String str){ //생성자
	this.str=str;
	}
	
	public void run(){ //start -> run()
		for(int i=0;i<10;i++){
			System.out.println(i+" "+str);
			try{
			//Thread.sleep(500);  //0.5초슬로우를 줘서 번갈아서 총을 쏘도록
			Thread.sleep((int)(Math.random()*1000));
			}
			catch(InterruptedException e){}
		}
		System.out.println("Done"+" "+str);
	}
}

public class Thread2 {
	public static void main(String[] args) {
		SimpleThread st1=new SimpleThread("아군!빵야!");
		SimpleThread st2=new SimpleThread("적군!빵빵!");
		
		st1.start();
		st2.start();
		System.out.println("main end!!!");
	}
}
