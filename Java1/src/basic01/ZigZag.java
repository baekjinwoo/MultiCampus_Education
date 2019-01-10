package basic01;

public class ZigZag {
	public static void main(String[] args) {
		//지그재그기법
		int num1=100;
		int num2=3;
		int k=num1;
		num1=num2;
		num2=k;
		System.out.println(num1+"    "+num2);
	}
}
