package test4;

import java.util.function.BiFunction;

class Calc{
	
	//메서드에 static이 들어가면 ob::sum에 오류
	public int sum (int a, int b) { return a+b; }
	public double sum (double a, double b) { return a+b; }
	//public float sum (float a, float b) { return a+b; }
	public int sum (float a, float b) {return (int)(a+b);}
}

public class StreamEx4 {
	public static void main(String[] args) {

		Calc ob = new Calc();
		BiFunction<Integer, Integer, Integer> rs1 = ob::sum;; //(1)Integer + (2)Integer => (3)Integer
		int s1=rs1.apply(10,20);
		System.out.println(s1);
		
		
		BiFunction<Double, Integer, Double> rs2 = ob::sum;; //(1)Double + (2)Integer => (3)Double
		Double s2=rs2.apply(10.5,20);
		System.out.println(s2);
		
		
				//첫번째, 두번째, 반환값							   //객체를 넣어도 되고, 안에서 직접 생성해도 된다
		BiFunction<Float, Float, Integer> rs3 = new Calc()::sum;; //(1)Float + (2)Integer => (3)Float
		int s3=rs3.apply(10.5f,20.5f);  //반환값 변수= rs3.apply(첫번째, 두번쨰);		
		System.out.println(s3);		
	}
}
