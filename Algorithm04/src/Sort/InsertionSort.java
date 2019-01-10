package Sort;

//정렬은 회문과도 같은 문제에서 많이 나온다
public class InsertionSort {
	public static void main(String[] args) {
		

	//InsertionSort(삽입정렬): 순차적인 정렬이면서 정렬된 마지막값과 삽입값을 비교해서, 크면 오른쪽으로 작으면 왼쪽으로 공간을 밀어내고 삽입
	//타겟값과 앞전의 값과 비교해서 끼워맞추는 정렬법
    //bubble과 selection : 수행횟수 45
	//insertion : 수행횟수 수행횟수 더 빠르다.
		int []arr = {4,5,7,9,8,1,1,2,3,6};
		
		new InsertionSort().insert(arr);
		System.out.println("--정렬 이후--");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  "); // select메서드안에서 출력할 필요없다
		}
	}

	
//insertSort메소드 이중포문 공식
	public void insert(int []arr){
		//1개씩 정렬 추가: 정렬 데이터수 증가
		//정렬되지 않은 데이터수 감소
		//현재 arr[i]데이터 비교 대상
		int cnt=0;
		for(int i=1; i<arr.length; i++){ //0이 아닌1부터 시작을 하는 이유는, 1로해야 왼쪽값과 계속 비교할 수 있기때문에 1로 고정값
			int target= arr[i];
			for(int j=i; j>0; j--){ //i부터 0까지 감소하는 j값은  ==> 정렬된 마지막값과 삽입값을 비교해서, 크면 오른쪽으로 작으면 왼쪽으로 공간을 밀어내고 삽입
				cnt++;
				if(arr[j-1] > target){ //arr[j]는 target이기에 쓰지않는다. arr[j-1]은 마지막정렬된 값부터 감소하면서 비교해야하기때문에 
					swap(arr,j,j-1);
				}
			}
		}//for_end
		System.out.println(cnt+"번 반복");
	}//insert_end

	public void swap(int[] arr, int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	
	
}//class_end
