package basic01;

public class MaxMin {
	public static void main(String[] args) {
		//최대값과 최소값
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		
		//최대값과 최소값의 활용
		//System.out.println("16진수로 표현한 char의 최대값은="+Character.ToHexString(Character.MIN_VALUE));
		//char와 String, boolean은 최대값 최소값음 없다. char와 같은 경우는 크기비교는 가능하다.
		System.out.println("16진수로 표현한 int최대값은="+Integer.toHexString(Integer.MAX_VALUE));
		System.out.println("16진수로 표현한 int최소값은="+Integer.toHexString(Integer.MIN_VALUE));
		System.out.println("16진수로 표현한 Double의 최대값은="+Double.toHexString(Double.MAX_VALUE));
		System.out.println("16진수로 표현한 double의 최소값은="+Double.toHexString(Double.MIN_VALUE));
		System.out.println("16진수의 float 최대값은="+Float.toHexString(Float.MAX_VALUE)); //hex16진수
				
		System.out.println("8진수 int형 최대값은 ="+Integer.toBinaryString(Integer.MAX_VALUE));//binary 2진수
		System.out.println("8진수의 float형 최소값은="+Float.toHexString(Float.MAX_VALUE)) ;

		System.out.println("2진수의 int형 변수 최대값은="+Integer.toOctalString(Integer.MAX_VALUE));//8진수 Octal은 int만 있는듯.
	}
}
