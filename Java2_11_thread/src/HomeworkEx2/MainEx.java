package HomeworkEx2;


/*[문제2]자판기 프로그램을 만드시오

클래스명 : VendingMachine
               +getDrink():String
               +putDrink(drink String):void
             
            [참고]
	     wait()와 notify()를 이용하여 완성
	       Stack store=new Stack();

	       pop() :  꺼냄 
	       push():  넣기
	    
클래스명 : Producer     <-- Thread상속
클래스명 : Consumer     <-- Thread상속
클래스명 : MainEx.java
               VendingMachine vm=new VendingMachine();
     
               Producer p=new Producer(vm);
               Consumer c=new Consumer(vm);
     
	       Thread t1=new Thread(p, "생산자");
	       Thread t2=new Thread(c, "소비자");
	 
	       t1.start();
	       t2.start();
=============================================     
[출력화면]
생산자 : 음료수 No. 1 자판기에 넣기
소비자 : 음료수 No. 1 꺼내먹음
 
생산자 : 음료수 No. 2 자판기에 넣기
소비자 : 음료수 No. 2 꺼내먹음

생산자 : 음료수 No. 3 자판기에 넣기
소비자 : 음료수 No. 3 꺼내먹음
        :
        
생산자 : 음료수 No. 10 자판기에 넣기
소비자 : 음료수 No. 10 꺼내먹음 
 */

public class MainEx {
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();

		Producer p = new Producer(vm);
		Consumer c = new Consumer(vm);

		Thread t2 = new Thread(c, "소비자");
		Thread t1 = new Thread(p, "생산자");
		
		t1.start();
		t2.start();
	}
}
