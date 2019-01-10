package HomeworkEx;

interface Temp{
	public int getTempGage();
}

abstract class Car{
	private String name;
	private String engine;
	private int oilTank;
	private int oilSize;
	private int distance;
	
	public Car(){
		//기본생성자
	}
	public Car(String name, String engine, int oilTank, int oilSize, int distance){
		//5개 변수 받는 생성자
		this.name=name;
		this.engine=engine;
		this.oilSize=oilSize;
		this.oilTank=oilTank;
		this.distance=distance;
	}
	
	public abstract void go(int distance); //주행 //distance만큼 주행하고 현재 주유량을 감소한다
	public abstract void setOil(int oilSize); //주유 // 특정 양을 주유한다
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getOilTank() {
		return oilTank;
	}
	public void setOilTank(int oilTank) {
		this.oilTank = oilTank;
	}
	public int getOilSize() {
		return oilSize;
	}
	public void setOilSize(int oilSize) {
		this.oilSize = oilSize;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}

class L3 extends Car implements Temp{
	public L3(){
		super();  //기본생성자
	}
	public L3(String name, String engine, int oilTank, int oilSize, int distance){
		super(name, engine, oilTank, oilSize, distance);
	}
	public void go(int distance){ // 10주행시 현재 주유량 1감소
		super.setOilSize(super.getOilSize()-distance/10);
		super.setDistance(super.getDistance()+distance);
		//주행
	}
	public void setOil(int oilSize){
		super.setOilSize(super.getOilSize()+oilSize);
		//oil충전
	}
	public int getTempGage(){
		return super.getDistance()/10; //엔진온도측정
	}
}

class L5 extends Car implements Temp{
	public L5(){
		
	}
	public L5(String name, String engine, int oilTank, int oilSize, int distance){
		super(name, engine, oilTank, oilSize, distance);
	}
	
	public void go(int distance){ // 8주행시 현재 주유량 1감소
		super.setOilSize(super.getOilSize()-distance/8);
		super.setDistance(super.getDistance()+distance);
		//주행
	}
	public void setOil(int oilSize){
		super.setOilSize(super.getOilSize()+oilSize);
		//oil충전
	}
	public int getTempGage(){
		return super.getDistance()/5; //엔진온도측정
	}
}

public class CarTest {
	public static void main(String[] args) {
		Car[] ob = new Car[2];
		ob[0] = new L3("L3","1500",50,25,0);
		ob[1] = new L5("L5","2000",75,35,0);
		
		System.out.println("vihicleName\t engineSize\t oilTank\t oilSize\t distance\t temperature");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println(ob[0].getName()+"\t\t  "+ob[0].getEngine()+"\t\t  "+ob[0].getOilTank()+"\t\t  "+ob[0].getOilSize()+"\t\t  "+ob[0].getDistance());
		System.out.println(ob[1].getName()+"\t\t  "+ob[1].getEngine()+"\t\t  "+ob[1].getOilTank()+"\t\t  "+ob[1].getOilSize()+"\t\t  "+ob[1].getDistance());
		System.out.println("-----------------------------------------------------------------------------------------------");

	
		System.out.println("주유 25");
		System.out.println("vihicleName\t engineSize\t oilTank\t oilSize\t distance\t temperature");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		for(int i=0; i<2; i++){
			ob[i].setOil(25);
		System.out.println(ob[i].getName()+"\t\t  "+ob[i].getEngine()+"\t\t  "+ob[i].getOilTank()+"\t\t  "+ob[i].getOilSize()+"\t\t  "+ob[i].getDistance());
							  }
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("주행 80");
		System.out.println("vihicleName\t engineSize\t oilTank\t oilSize\t distance\t temperature");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int i=0; i<2; i++){
			ob[i].go(80);
		System.out.println(ob[i].getName()+"\t\t  "+ob[i].getEngine()+"\t\t  "+ob[i].getOilTank()+"\t\t  "+ob[i].getOilSize()+"\t\t  "+ob[i].getDistance());
							  }
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		
// Car type의 객체 배열을 2개 만든다
// 배열에 사용데이터에서 제공된 2개의 Car 객체를 넣는다.
// 생성된 자동차의 기본 정보 출력
// 각각의 자동차에 25씩 주유 한다
// 25씩 주유한 자동차의 정보를 출력 한다
// 각각의 자동차에 80씩 주행 한다
// 80씩 주행한 정보를 출력 하며 엔짂온도 정보를 출력 한다	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	}
}
