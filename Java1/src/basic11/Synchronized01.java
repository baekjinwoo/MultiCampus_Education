package basic11;

//1. 쓰레드의 동기화 
//(원래 쓰레드는 하나가 실행되면 끝날때까지 다른하나가 방해하지 못하는데, 동기화를 하면 교대로 실행이 가능하다
class SyncTest{			   //만약 메서드앞에 synchronized를 없애면 동기화가 적용되지 않아 교대로 출력된다
	synchronized void a(){ // 동기화(Sync)a메서드 : s1.start()실행문에만 Sync를 걸어준다. 
		for(int i=0;i<10;i++){ //10회
			try{
				System.out.println(i+"회  ^^");
				Thread.sleep(300);
				}
			catch(Exception e){
				
			}
			System.out.println();
		}
	}
	
	synchronized void b(){ // 동기화(Sync)b메서드 : s2.start()실행문에만 Sync를 걸어준다.
		for(int i=0;i<10;i++){ //10회
			try{
				System.out.println(i+"회  ><");
				Thread.sleep(300);
				}
			catch(Exception e){
				
			}
			System.out.println();
		}
	}		
}

public class Synchronized01 extends Thread {
	int soo;
	SyncTest sync1;
	
	Synchronized01(int soo, SyncTest sync1){
		this.soo=soo;
		this.sync1=sync1;
	}
						
	public void run(){ //s1.start에 의해 run()이 실행이 끝나면 s2.start에 의해 run()이 수행한다.(교대로 수행하지 않고 하던작업을 끝날때까지 다른 추가실행 간섭x) 
		if(soo==1)
			sync1.a();
		else if(soo==2)
			sync1.b(); 
	}
	
	public static void main(String[] args) {
		SyncTest sync1= new SyncTest();
		Synchronized01 s1=new Synchronized01(1,sync1); //숫자와 클래스SyncTest의 객체 sync1이 생성
		Synchronized01 s2=new Synchronized01(2,sync1);
		
		s1.start();
		s2.start();	
	}
}

