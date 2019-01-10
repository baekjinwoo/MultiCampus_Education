package homework;

import java.util.Random;

public class hm18 {
	public static void main(String[] args) {
		//문제. 정수배열을 10개를 잡아 그 중 최소값을 출력하시오
		Random r=new Random();
		int[] a=new int[10];
		
		System.out.print("입력된 랜덤값입니다: ");
		
		for(int i=0;i<10;i++){ //번지수만큼 10번 반복
			a[i]=r.nextInt(20)+1;  //랜덤으로 1~20을 저장
			System.out.print(a[i]+"   "); //랜덤생성 완료
		}
		System.out.println();
		
		
		System.out.print("오름차순 값입니다: ");
		int temp;
		for(int i=0;i<10;i++){ 
			for(int j=i;j<a.length;j++){  //????
				if(a[i]>a[j]){ //내림차순  
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				}
			}
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		System.out.println("따라서 최소값은"+ a[0]+"입니다"); 
		
		
		/*
		 * 또 다른 풀이방법
		int[] arr= {10,5,4,8,7,6,1,6,7,9};
		int min = arr[0];
		for(int i=0; i<10; i++){
			if(arr[i] < min)
				min = arr[i];
		}
		System.out.println(min);
		
		 * */
	}
}
