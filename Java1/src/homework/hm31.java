package homework;

/*문제. 다음 결과가 나오도록 thread
	1) 스마트폰으로 뉴스를 본다
		0 지금 지하철타고 가는 중~ 오빠 기다려~
		1 지금 지하철타고 가는 중~ 오빠 기다려~
		2 지금 지하철타고 가는 중~ 오빠 기다려~
 		같이 영화보러 들어간다*/

class Goodgirl extends Thread{
	public void run(){
		for(int i=0;i<3;i++)
			System.out.println(i+"지금 지하철 타고 가는중~ 오빠~ 기다려");
		try{
			Thread.sleep(200);
		}
		catch(InterruptedException e){
			
		}
	}
}

class GoodBoy extends Thread{
	public void run(){
	Goodgirl g1= new Goodgirl();
	System.out.println("1) 스마트폰으로 뉴스를 본다.");
	g1.start();
	try{
		g1.join();
	}
	catch(InterruptedException e){
		
	}
	System.out.println("같이 영화보러 들어간다");
	}
}

public class hm31 {
	public static void main(String[] args) {
		GoodBoy g2= new GoodBoy();
		g2.start();
	}
}