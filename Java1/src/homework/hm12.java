package homework;

import java.util.Random;

public class hm12 {
	public static void main(String[] args) {
	//문제. 위의 로또 출력을 10개임으로 출력하되 중복을 제거하여 출력하시오*/
		int [] lo= new int[6];
		Random rd=new Random();
		//int num=0;
		
		for (int k=0; k<10; k++){ //10번 찍기
			for(int i=0; i<lo.length; i++){ //한줄에 들어가는 6개의 숫자를 랜덤으로 넣기
				lo[i]=rd.nextInt(45)+1;
				//num= rd.nextInt(45)+1;
				//lo[i]=num;
				
				for (int j = 0; j < i; j++) { //비교문
					while(lo[j]==lo[i]){ 
					lo[i]=rd.nextInt(45)+1; 
					}
				}
			}	
			Psort(lo);
			for(int i=0;i<lo.length;i++){
				System.out.print(lo[i]+" ");
			}
			System.out.println();
		}
	}
		

		public static void Psort(int[] lo){
			int imsi;
			
			
			for (int i = 0; i < 6; i++) {
				for (int j = i+1; j < 6; j++) {
					if(lo[i]<lo[j]){
						imsi=lo[i];
						lo[i]=lo[j];
						lo[j]=imsi;	
				}
			}
		}
	}
}
