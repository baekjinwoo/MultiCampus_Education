package basic03;

public class Math_Random {
	public static void main(String[] args) {
		//Math함수의 반올림 : 나눈만큼 곱하면 그 자리수로 반올림된다.

		float f5=95.8854f;
		System.out.println(Math.round(f5));
		System.out.println(Math.round(f5*1000)/1000.0);

		float result4=Math.round(f5*1000)/1000;
		System.out.println(result4);
	}
}
