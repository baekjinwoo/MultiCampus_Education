package homework;

//Print활용
public class hm02 {
	public static void main(String[] args) {
		/*섭씨온도 32.4도를 화씨로 출력하시오.
		   섭씨°F = °C × 1.8 + 32, 
		   화씨°C = (°F - 32) / 1.8*/

		double F1 = 32.4;
		double C1 = (F1-32)/1.8; //실수를 사칙연산할때는 왠만하면 double형을 쓴다.
		System.out.println("출력된 화씨온도는"+C1);
		
		double C2 = 78.7;
		double F2 = (C2*1.8)+32;
		System.out.println("출력된 섭씨온도는"+F2);
	}
}
