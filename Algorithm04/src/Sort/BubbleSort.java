package Sort;

public class BubbleSort {
	int temp=0;

	public static void main(String[] args) {
		int [] arr= {10,2,7,6,9,5,4,3,1,3};
		int min=1000;
		
//최소값찾기
		for(int i=1; i<arr.length;i++){
				if(min > arr[i]){
					min=arr[i];
			}
			System.out.println("min = "+min+", arr["+i+"] = "+ arr[i]);
		}
		System.out.println(min);
		System.out.println();

		new BubbleSort().bubble(arr);
		System.out.println("정렬 이후");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+"  ");
		}
	}
	

//Bubble sort: 인접한 두개의 값을 비교한 뒤, 정렬이 완료된 끝값들은 정렬반복에 불필요하니까 범위에서 제외시킨다.
// 반복횟수 90인 bubble sort메소드
//	public void bubbleSort(int[] arr) {  
//		int cnt = 0;
//		for (int i = 0; i < arr.length; i++) { //10번반복
//			for (int j = 0; j < arr.length - 1; j++) { //9번 반복
//				cnt++; 
//				if (arr[j] < arr[j + 1]) {
//					swap(arr, j, j + 1);
//				}
//			}
//		}
//		System.out.println(cnt + "번 반복한다");
//	}
// Swap메소드
//	public void swap(int arr[], int i, int j) { 
//	temp = arr[i];
//	arr[i] = arr[j];
//	arr[j] = temp;
//}	
	
	
	
	
//반복횟수 45로 줄인 bubble sort메소드의 이중포문공식
	public void bubble(int []arr){ //Bubble Sort
		int cnt=0;
		for(int i=0; i<arr.length-1;i++){				//for(int i=arr.length-1; i>=0; i--){
			for(int j=0; j<arr.length-1-i; j++){			//for(int j=0; j<i; j++){도 가능하다
				cnt++; //반복회수체크
				if(arr[j]<arr[j+1]){
				swap(arr, j, j+1);
				}
			}
		}
		System.out.println(cnt+"번 반복한다");
	}
	
//Swap메소드
	public void swap(int arr[], int i, int j){ //자리바꾸기
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
}




