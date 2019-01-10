package homeworkEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Mobile{
	private String code;
	private String name;
	private double price;

	public Mobile() {

	}

	public Mobile(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String printInfo() {
		return code+"\t"+name+"\t"+price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

public class hmTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Mobile> map = new HashMap<String, Mobile>();
		double sum = 0.0;
		
		Mobile m1 = new Mobile("SU7600", "Optimus Mach", 950000.0);
		Mobile m2 = new Mobile("KU5700", "Optimus Big", 700000.0);
		Mobile m3 = new Mobile("SU6600", "Optimus Black", 900000.0);
		Mobile m4 = new Mobile("LU6800", "Optimus 2X", 800000.0);
		
		map.put(m1.getName(), m1);
		map.put(m2.getName(), m2);
		map.put(m3.getName(), m3);
		map.put(m4.getName(), m4);
		
		Set <String> keys = map.keySet();
	
		for (String st : keys) {
			System.out.println(map.get(st).printInfo());
			double n = map.get(st).getPrice();
			sum += n;
			map.get(st).setPrice(n*1.1);
		}
		
		System.out.println("합계: "+sum);
		
		sum=0;
	
		System.out.println("\n가격 변경 후");
		for (String st : keys) {
			System.out.println(map.get(st).printInfo());
			double n = map.get(st).getPrice();
			sum += n;
		}
		
		System.out.printf("합계: %.1f",sum);
	}
}