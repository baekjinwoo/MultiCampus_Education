package basic05;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		//로또 한 게임을 출력하시오 (배열과 for문을 사용)
		Random rd=new Random();
		int[] aa= new int[6];
		
		System.out.println();
		for(int i=1;i<aa.length;i++){
			int dap=rd.nextInt(45)+1;
			System.out.print(dap+" ");
		}
		System.out.println();

////////////////////////////////////////////////////
		for(int i=1;i<aa.length;i++){
			System.out.println(Arrays.toString(aa));
		}
	}
}
