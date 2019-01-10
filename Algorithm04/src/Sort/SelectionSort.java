package Sort;

public class SelectionSort {
	public static void main(String[] args) {
//Selection Sort: 정렬이 안된상태에서 최소값을 먼저 찾아라 => 현재 정렬되있는 기준값과 맞바꾼다음에 거기까지 포함해서 정렬시킨다 =>반복
	int []arr = {40,70,60,30,10,50};
	new SelectionSort().select(arr);
	
	System.out.println("--정렬 이후--");
	for(int i=0; i<arr.length; i++){
		System.out.print(arr[i]+"  "); //select메서드안에서 출력할 필요없다
		}
	}
	
//Selection_Sort메소드의 이중포문공식
	public void select(int arr[]){
		int temp = 0; //정렬을 도울 임시변수
		int cnt = 0; //반복회수체크
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				cnt++;
				if(arr[i]>arr[j]){		//if(arr[j]<arr[temp]){
					swap(arr, i, j);	// temp=j;
				}
			}
		}
		System.out.println(cnt+"번 반복");
	}
	
//Swap메소드
	public void swap(int arr[], int i, int j){ //자리바꾸기
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}




//내가 짠 정렬코드
//int temp=0;
//
//for(int i=0; i<arr.length; i++){
//	for(int j=i+1; j<arr.length; j++){
//		if(arr[i]>arr[j]){
//			temp=arr[i];
//			arr[i]=arr[j];
//			arr[j]=temp;
//			}
//		}
//	System.out.print(arr[i]+"  ");
//	}