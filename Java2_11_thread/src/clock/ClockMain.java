package clock;

public class ClockMain {
	public static void main(String[] args) {
		DigitalClock dc=new DigitalClock("디지틀 시계");
		Thread th=new Thread(dc);
		th.setDaemon(true);  //main이 종료되면 데몬도 종료
		th.start();
	}
}
