package factory;

public class Factory {
	private int product=0;
	
	public synchronized void produce(){      //생산
		if(product > 4){
			try{
				System.out.println("생산 중단 : " + product);
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//end if		
		product++;
		System.out.println("생산 : " + product);
		notifyAll();
	}
	//-------------------------------------------------------
	public synchronized void sell(){        //소비
		if(product < 1) //1보다 작을때까지 소비한다.
		{
			try{
				System.out.println("소비 중단 : " + product);
				wait(); //Thread가 잠을자고 기다리는 것
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//end if
		product--;
		System.out.println("소비 : " + product);
		notifyAll(); //잠자고있는 Thread를 깨우는것 (더이상 작동하지 않는 Thread를 실행시키는 것)
	}	
}
/*
Thread간의 조정
두개의 스레드가 데이터를 주고 받는 경우에 발생하는데
이를 해결하기 위해 스레드에서 wait();, notify();를 이용한다.

wait() : 스레드를 일시정지 시켜 대기 상태로 만든다.
notify() : 스레드를 깨워 다시 실행시킨다.
notifyAll() : 모든 스레드를 깨워 다시 실행시킨다. 

다중쓰레드를 사용할 경우 nofity();를 사용하면 어떤 쓰레드가 깨어날지 알 수 없기 때문에
우선순위가 높은 쓰레드가 계속 wait 상태로 머무를 수 있다.
그렇기 때문에 notifyAll();을 통해 JVM이 쓰레드의 우선순위에 따라 처리하게 하는 것이 좋다.
*/
















