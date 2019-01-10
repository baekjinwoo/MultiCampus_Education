package homework;

/*3. 다음 결과가 나오도록 Thread
	1) 스마트폰으로 뉴스를 본다
		0 지금 지하철타고 가는 중~ 오빠~ 기다려~
		1 지금 지하철타고 가는 중~ 오빠~ 기다려~
		너무 늦었다~~ 나 간다~~
		늦게 도착한 여친~ 이건 뭥미~*/

class Girl extends Thread{
	public void run(){
		for(int i=0;i<2;i++)
			System.out.println(i+"지금 지하철타고 가는중~ 오빠 기다려~");
		try{
			Thread.sleep(300);
		}
		catch(InterruptedException e){
			
		}
	}
}

class BadBoy extends Thread{
	public void run(){
		Girl g1= new Girl();
		System.out.println("2) 스마트폰으로 뉴스를 본다.");
		g1.start();
		try{
			g1.join();
		}
		catch(InterruptedException e){
			
		}
		System.out.println("너무 늦었다~~ 나간다~~~~");
		System.out.println("먼저 도착한 여친~ 이건 뭥미~~~");
	}
}

public class hm32 {
	public static void main(String[] args) {
		BadBoy g2=new BadBoy();
		g2.start();
	
	}
}

