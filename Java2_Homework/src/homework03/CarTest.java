package homework03;

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
		//�⺻������
	}
	public Car(String name, String engine, int oilTank, int oilSize, int distance){
		//5�� ���� �޴� ������
		this.name=name;
		this.engine=engine;
		this.oilSize=oilSize;
		this.oilTank=oilTank;
		this.distance=distance;
	}
	
	public abstract void go(int distance); //���� //distance��ŭ �����ϰ� ���� �������� �����Ѵ�
	public abstract void setOil(int oilSize); //���� // Ư�� ���� �����Ѵ�
	
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
		super();  //�⺻������
	}
	public L3(String name, String engine, int oilTank, int oilSize, int distance){
		super(name, engine, oilTank, oilSize, distance);
	}
	public void go(int distance){ // 10����� ���� ������ 1����
		super.setOilSize(super.getOilSize()-distance/10);
		super.setDistance(super.getDistance()+distance);
		//����
	}
	public void setOil(int oilSize){
		super.setOilSize(super.getOilSize()+oilSize);
		//oil����
	}
	public int getTempGage(){
		return super.getDistance()/10; //�����µ�����
	}
}

class L5 extends Car implements Temp{
	public L5(){
		
	}
	public L5(String name, String engine, int oilTank, int oilSize, int distance){
		super(name, engine, oilTank, oilSize, distance);
	}
	
	public void go(int distance){ // 8����� ���� ������ 1����
		super.setOilSize(super.getOilSize()-distance/8);
		super.setDistance(super.getDistance()+distance);
		//����
	}
	public void setOil(int oilSize){
		super.setOilSize(super.getOilSize()+oilSize);
		//oil����
	}
	public int getTempGage(){
		return super.getDistance()/5; //�����µ�����
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

	
		System.out.println("���� 25");
		System.out.println("vihicleName\t engineSize\t oilTank\t oilSize\t distance\t temperature");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		for(int i=0; i<2; i++){
			ob[i].setOil(25);
		System.out.println(ob[i].getName()+"\t\t  "+ob[i].getEngine()+"\t\t  "+ob[i].getOilTank()+"\t\t  "+ob[i].getOilSize()+"\t\t  "+ob[i].getDistance());
							  }
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("���� 80");
		System.out.println("vihicleName\t engineSize\t oilTank\t oilSize\t distance\t temperature");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int i=0; i<2; i++){
			ob[i].go(80);
		System.out.println(ob[i].getName()+"\t\t  "+ob[i].getEngine()+"\t\t  "+ob[i].getOilTank()+"\t\t  "+ob[i].getOilSize()+"\t\t  "+ob[i].getDistance());
							  }
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		
// Car type�� ��ü �迭�� 2�� �����
// �迭�� ��뵥���Ϳ��� ������ 2���� Car ��ü�� �ִ´�.
// ������ �ڵ����� �⺻ ���� ���
// ������ �ڵ����� 25�� ���� �Ѵ�
// 25�� ������ �ڵ����� ������ ��� �Ѵ�
// ������ �ڵ����� 80�� ���� �Ѵ�
// 80�� ������ ������ ��� �ϸ� �����µ� ������ ��� �Ѵ�	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	}
}
