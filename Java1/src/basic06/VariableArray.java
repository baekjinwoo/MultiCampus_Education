package basic06;

public class VariableArray {
	public static void main(String[] args) {
		//가변배열 : 톱니바퀴배열
		//2차원배열x 1차원배열이 두개 붙어서 만들어진 1차원배열이다.

		int [][] jag = new int[2][];  
		jag[0]=new int[2]; //0~1
		jag[1]=new int[3]; //0~2
		
		jag[0][1]=20; //jag[0][2]=100;는 안된다. 자리가 없음.
		
		//XX
		//XXX 모양이된다	
	}
}
