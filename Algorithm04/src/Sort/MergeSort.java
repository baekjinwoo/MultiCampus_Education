package Sort;

public class MergeSort {
	public static void main(String[] args) {

// MergeSort 합병정렬은 이진트리와 유사. 반으로 쪼개고 본다.==> 정렬하면서 합친다

// 데이터의 길이가 1이될때까지 나눈다. 재귀호출을 이용해서 종료가 1로
// 분할된 두 데이터를 정렬해서 앞자리끼리만 비교해서 새롭게 정렬한다.
		
		int []arr= {4,5,7,9,8,1,1,2,3,6};
		new MergeSort().mergesort(arr);
		System.out.println("--정렬 이후--");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  "); // select메서드안에서 출력할 필요없다
		}
	}
	
	
	
	public void mergesort(int arr[]){
		mergesort(arr,0,arr.length); //arr의 0번 index부터 전체개수를 대상으로 sort 
	}

	
	public void mergesort(int[] arr, int startIndex, int last){ //arr->arr, 0-> startIndex, arr.length->last 
		if(last -startIndex<2){ return; }
		int middleIndex= (startIndex+last)/2;
		//0,10
		
		//재귀호출_분할
		mergesort(arr, startIndex, middleIndex); //	merge(arr, startIndex, ?);
		mergesort(arr, middleIndex , last);     // merge(arr, ? , last);
		//재귀호출_합병
		merge(arr, startIndex, middleIndex, last); //startIndex부터 last까지~~~~
	}
	
	
	public void merge(int []arr, int startIndex, int middleIndex, int last){
		if(arr[middleIndex -1] <= arr[middleIndex]) return;
		int i= startIndex, j= middleIndex, k=0;
		//합병할 임시배열. 0, 10 => (0,5) (5,10) //각각 5개씩 저장할 배열을 만들어라 
		//정렬: 양배열 첫값 비교 작은 저장, 두번째값()
		int[] tempArr = new int[last-startIndex]; //합병할 만큼만 배열을 만들어라
		while(i<middleIndex && j<last){
		if(arr[i] > arr[j]){ //합병을 하기위해서는 정렬을 해야한다. 정렬을 위한 문장. 누가 더 크니?
			tempArr[k++] = arr[j++];//일단은 저장부터 해놓고 증가시키라는 문장
			//j++; k++;
			}
		else{
			tempArr[k++] = arr[i++];
		}
	}
	//다 끝나서 합병이 처리되는 과정이다	
	if(i < middleIndex){
		System.out.println("i=" + i + " startIndex=" + startIndex + " k="+ k + " middleIndex-1=" + (middleIndex-i)	);
		System.arraycopy(arr, i, arr, startIndex+k, middleIndex-i); //arr의 i번째부터, arr의 startIndex+k번째까지 middleIndex-1개수를 복사한다.
		}
		System.arraycopy(tempArr, 0, arr, startIndex, k); //tempArr의 저장된 데이터갯수만큼 startIndex까지

	//tempArr 검증용도(지워도됨)
	System.out.println("tempArr배열출력: ");
	for(int x= 0; x < tempArr.length; x++){
		System.out.print(tempArr[x]+" ");
		}
	System.out.println();
		
	//arr 검증용도(지워도됨)
	System.out.println("arr배열출력: ");
	for(int x= 0; x <arr.length; x++){
		System.out.print(arr[x]+" ");
		}
	System.out.println();
			
		
	}
}
