package thread;

/*데몬쓰레드(daemon thread)
 * 일반쓰레드가 모두 종료되면 데몬쓰레드를 강제로 종료한다	
 * 일반쓰레드가 종료되면 데몬쓰레드의 존재 의미가 없기 때문이다
 * ex) 워드프로세서의 자동저장, 화면 자동 갱신등
 */



// 쉽게말하면, Main thread가 종료되면 -> 후보 thread도 종료된다
// 더 쉽게, 스타그래프트가 종료되면 -> 스타BGM도 종료된다
class Demon extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				System.out.println("Hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MyThreadEx4 {
	public static void main(String[] args) {
		Demon ob = new Demon();
		ob.setDaemon(true); //true: main이 종료되면 데몬도 종료
		ob.start();

		int n = 0;
		while (n < 10) { //main
			n++;
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
