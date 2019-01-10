package thread;

/*실행순서의 동기화처리
 * : 쓰레드의 실행순서를 정의 하고 반드시 따르도록 하는것
 * 
 * ex) A쓰레드의 처리가 완료된후 B쓰레드가 처리되도록 하는 경우
 * 
 * 형식) 접근지정자 synchronized 메서드명(){  }
 */
class FamilyThread extends Thread{
	private Washroom wr;
	private String who;
	
	public FamilyThread(Washroom wr, String who){
		this.wr=wr;
		this.who=who;
	}
	
	@Override
	public void run(){
		try {
			wr.openDoor(who);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
//---------------------------------------------------------------
class Washroom{
	public synchronized void openDoor(String name) throws InterruptedException{ //(1)synchronized 동기화처리를 하니까 속도가 느리다. (2)한명씩 순서대로 끝날때까지 기다렸다가 실행하도록
		System.out.println(name + "님이 입장"); 									//단일Thread로 한명끝날때까지 기다렸다가 다음사람 실행되는 방법을 사용하지 않는 이유는, 순서가 없기때문에 Thread를 쓰고 동기화처리를 해야한다
		for(int i=0; i<50000; i++)
		{
			if(i % 10000==0){
				Thread.sleep(2000);
				System.out.println(name + "님이 볼일 보는중...........");
			}
		}
		System.out.println(name + "님이 퇴장");
	}
}
//---------------------------------------------------------------
public class SyncThreadTest {
	public static void main(String[] args) {
		Washroom wr=new Washroom();
		
		FamilyThread father=new FamilyThread(wr, "father");
		FamilyThread mother=new FamilyThread(wr, "mother");
		FamilyThread sister=new FamilyThread(wr, "sister");
		FamilyThread brother=new FamilyThread(wr, "brother");
		FamilyThread me=new FamilyThread(wr, "me");
		
		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();
	}
}


















