package HomeworkEx;

import java.util.ArrayList;

abstract class Ship{
	private String shipName;
	private int fuelTank;
	
	public Ship(){ 	}
	public Ship(String shipName, int fuelTank){
			this.shipName=shipName;
			this.fuelTank=fuelTank;
	}
	public abstract void sail(int dist);
	public abstract void refuel(int fuel);
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getFuelTank() {
		return fuelTank;
	}
	public void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}
}
class Boat extends Ship{
	public Boat(){
		
	}
	public Boat(String shipName, int fuelTank){
		super(shipName, fuelTank);
	}
	@Override
	public void sail(int dist){ //운항: 1운행 시 연료 10감소
		super.setFuelTank(getFuelTank()-(dist*10));
	}
	@Override
	public void refuel(int fuel){ //주유: 1 주유 시 연료 10증가
		super.setFuelTank(getFuelTank()+(fuel*10));
	}
}
class Cruise extends Ship{
	public Cruise(){
		
	}
	public Cruise(String shipName, int fuelTank){
		super(shipName, fuelTank);
	}
	@Override
	public void sail(int dist){ //운항: 1운행 시 연료 13감소
		super.setFuelTank(getFuelTank()-(dist*13));
	}
	@Override
	public void refuel(int fuel){ //주유: 1 주유 시 연료 8증가
		super.setFuelTank(getFuelTank()+(fuel*8));
	}
}
public class ShipTest {
	public static void main(String[] args) {
		ArrayList <Ship> ob = new ArrayList<>();
		
		System.out.println("<shipName> \t<fuelTank>");
		System.out.println("--------------------------");
		ob.add(new Boat("Boat01",500));
		ob.add(new Cruise("Cruise01",1000));
				
		for(Ship m : ob){
			System.out.println(m.getShipName()+"     \t"+m.getFuelTank());
		}
		
		System.out.println("운항10 입력후");
		for(Ship m : ob){
			m.sail(10);
			System.out.println(m.getShipName()+"     \t"+m.getFuelTank());
		}
		
		System.out.println("주유50 입력후");
		for(Ship m : ob){
			m.refuel(50);
			System.out.println(m.getShipName()+"     \t"+m.getFuelTank());
		}
		
		//ArrayList를만들어각각의 Boat 객체 와 Cruise객체를생성하여넣는다
		// 생성된객체의정보출력 - for문사용
		// 각각의 Ship 객체에 10 운항후객체정보출력 - for 문사용
		//각각의 Ship 객체에 50 주유후객체정보출력 – for문사용
	}
}
