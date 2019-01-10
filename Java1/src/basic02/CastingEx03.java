package basic02;

public class CastingEx03 {
	public static void main(String[] args) {
		//3-1. 암시적 형변환 (작은->큰)
		int i=10;
		double d=i;
		
		//3-2. 명시적 형변환 (큰->작은)
		float f1=9.3f;
		int i1=(int)f1;
		
		//3-3. 출력변수 형변환
		int i2=30;
		float f2=32.854f;
		float f3=f2+i2;
		System.out.println(f3);
		
		//3-4. 입력변수 형변환
		float f4=(float)i2;
		System.out.println(f2+f4);
	}
}
