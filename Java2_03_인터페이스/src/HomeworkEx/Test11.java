package HomeworkEx;

/*[문제11] 오버라이드를 이용하여 다음 프로그램을 작성하시오

(1)클래스명: Circle(추상클래스)
    #r:int        
    #size:double     
    #PI:double           ==> 초기값 3.14, final
   +Circle(r:int)          ==> 반지름 대입
   +compute():void    ==> 추상메서드     
   +output():void       ==> 추상메서드

(2)클래스명 :  CircleArea     ==> Circle클래스를 상속하시오
   +CircleArea(r:int)
   +compute():void      ==> 원의 넓이=반지름 *반지름*3.141592
   +output():void         ==> 출력      
       
(3)클래스명 :  CircleRound    ==> Circle클래스를 상속하시오
   +CircleRound(r:int)
   +compute():void      ==>원의둘레=반지름 * 2 * 3.141592
   +output():void         ==>출력

(4)main()함수에서
   public static void main(String[] args){
        CircleArea   ob1 = new CircleArea(10);
        ob1.compute();
        ob1.output();

        CircleRound  ob2 = new CircleRound(10);
        ob2.compute();
        ob2.output();
   }
[실행결과]
원의넓이 : 314.1592
원의둘레 : 62.83184*/

abstract class Circle{
	protected int r;
	protected double size;
	final protected double PI = 3.14;
	
	public Circle(int r){
		this.r=r;
	}
	abstract public void compute();
	abstract public void output();
}

class CircleRound extends Circle{

	public CircleRound(int r) {
		super(r);
	}

	@Override
	public void compute() {
		super.size=(super.r * super.r)*PI;
	}
	@Override
	public void output() {
		System.out.println("원의 넓이: "+ super.size);
	}
}

class CircleArea extends Circle{

	public CircleArea(int r) {
		super(r);
	}

	@Override
	public void compute() {
		super.size=(int)((super.r*2)*PI);

	}
	@Override
	public void output() {
		System.out.println("원의 둘레: "+ super.size);	
	}
}


public class Test11 {
	public static void main(String[] args) {
		CircleArea   ob1 = new CircleArea(10);
        ob1.compute();
        ob1.output();

        CircleRound  ob2 = new CircleRound(10);
        ob2.compute();
        ob2.output();
	}
}
