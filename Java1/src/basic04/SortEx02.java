package basic04;

import java.util.Arrays;

// sort(정렬): sort는 자료가 다 존재해야하고, 그렇기에 배열에서 사용하기에 좋다.
public class SortEx02 {
	public static void main(String[] args) {
		// (1)내부정렬 memory sort (중요) 	
		//		- radix sort - buble sort 	- insertion sort	- selection sort	 
		// 		- quick sort
		//	(유일하게 처리속도가 무지하게 빠르다) 중간점을 기준으로 정렬하는 것이고, 로직을 짜기 어렵다는 단점.
		
		// (2) 외부정렬(=보조기억장치 소트)

/////////////////////////////////////////////////////////////////////////////
		
		//1. selection sort(오름차순)
		int[] k={30, 50, 70, 50, 20}; 
		int imsi;
		for(int i=0; i<=4; i++){ //배열의 시작은 무조건 0부터 //선언된 수만큼 큰틀로 범위를 지정해놓고
			for(int j=i+1;j<=4;j++){ //for(int j=i+1; j<k.length; j++)와 같다. 
				if(k[i]<k[j]) {  
					//오름차순. p197참고. i를 기준으로 작으면 임시방으로 지그재그해서 큰것이 앞으로 오게.
			imsi=k[i];
			k[i]=k[j];
			k[j]=imsi;					
				}
			}
			System.out.print(k[i]+" "); //정렬된 k[]를 출력하는 문장.
		}
		System.out.println();
		
		for (int k1 = 0; k1 <=4 ; k1++) { //정렬된 k[]를 출력하는 문장.
			System.out.print(k[k1]+" ");
		}	
		System.out.println();

/////////////////////////////////////////////////////////////////////////////
		
	//2. bubble sort (어제배운건 Selection sort) (
		int[] k2={10, 70, 60, 100, 50, 80};
		int temp;
			
		for(int i=0;i<k2.length-1;i++){ 	    //0부터시작해서 5-1(k2.length-1)이
			for(int j=0;j<k2.length-1-i;j++){  //0부터시작해서 5-i (k2.length-1-i)이다 
											  //j를 돌려서 정렬문을 만드는데 j가 돌아가는 횟수와 완성된 단어를 다시 비교할 필요가 없기 때문에 -1-i를 한다
				if(k2[j]<k2[j+1]){   //규칙을 알고 위에 포문을 외우자
				temp=k2[j];
				k2[j]=k2[j+1];
				k2[j+1]=temp;		}	}}
			for(int i=0;i<k2.length;i++){
			System.out.print(k2[i]+"  ");
			}
			System.out.println();

/////////////////////////////////////////////////////////////////////////////
			
	//3. 내장형 자바api => Sort (속도가 빠르다)
			int[] jung={100,45,67,38,90};
			Arrays.sort(jung); 
			
			for(int imsi2:jung) //무조건 오름차순 sort이다
				System.out.print(imsi2+"\t");
			System.out.println();
			
			for(int i=4;i>=0;i--) //무조건 내림차순 sort이다
				System.out.print(jung[i]+"\t");
			System.out.println();
	}
}
