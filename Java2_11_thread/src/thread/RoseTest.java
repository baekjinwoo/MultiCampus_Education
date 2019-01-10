package thread;

/* 쓰레드의 우선순위
: setPriority()메서드를 이용하여 우선순위를 부여한다(1~10) //Cpu가 많이 할당되기때문에 cpu가 안좋은 컴퓨터에서는 Test가 불가능하다
  우선순위가 높은 쓰레드는 우선순위가 낮은 쓰레드에 비해 실행시간을 많이 할당 받는다.
  다른 쓰레드에 비해 많은 실행시간을 필요로 한다면 우선순위를 높게 두면 된다.

MAX_PRIORITY    : 우선순위 10(최고순위)
MIN_PRIORITY    : 우선순위 1(최저순위)
NORM_PRIORITY   : 우선순위 5(순위 미지정)

main은 우선순위 5

join() : 한 쓰레드의 동작이 끝날때까지 대기한다
*/





/*public class RoseTest extends Thread {

	private String str;

	public RoseTest(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for(int i=1;i<=300;i++){
			for(int j=1;j<2000000000;j++){ //시간끌기
				System.out.println(str +" "+ Thread.currentThread()); //이름 우선순위 그룹

			}
		}
	}

	public static void main(String[] args) {
		RoseTest ob1 = new RoseTest("사랑");
		RoseTest ob2 = new RoseTest("장미");
		RoseTest ob3 = new RoseTest("가시");
		ob1.setPriority(7);
		
		ob1.start();
		ob2.start();
		ob3.start();
		
	}
}*/


public class RoseTest extends Thread {

	private String str;

	public RoseTest(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 300; i++) {
			try {
				Thread.sleep(5); //쓰레드 돌릴때 try~catch필수
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(str + " " + Thread.currentThread());

		}
	}

	public static void main(String[] args) {
		RoseTest ob1 = new RoseTest("사랑");
		RoseTest ob2 = new RoseTest("장미");
		RoseTest ob3 = new RoseTest("가시");
		
		try{
		ob1.start();
		ob1.join(); //ob1이 끝날때까지 ob2, ob3는 기다려라(대기해라)
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		ob2.start();
		ob3.start();
		
	}
}