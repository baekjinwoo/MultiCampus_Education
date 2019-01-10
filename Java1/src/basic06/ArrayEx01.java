package basic06;

public class ArrayEx01 {
	public static void main(String[] args) {
		//배열 (단독주택& 아파트 생성법)
		int[] aaa= new int[3];
		
		aaa[0]= 90;
		aaa[1]= 80;
		aaa[2]= 70;
		
		System.out.println(aaa[0]);
				
		double[] ddd= new double[2];
		ddd[0]= 11.154;
		ddd[1]= 12.875;
		
		for (int i = 0; i < ddd.length; i++) {
			System.out.print(ddd[i]+" ");
		}
		System.out.println();
	}
}


// 배열의 복사: 칸을 늘리는 경우는 특별한 경우이고 왠만하면 아래와 같이 쓰면된다.
// 내용이 바뀐게 아니고 번지가 바뀐것이다.(번지위주로 진행된다) stack메모리에 저장된게 아니고 heap메모리에 저장이 되는데,
// 위와같이 작성을 하면 aa7과 bb7이 가르키는 주소가 같게 되는데 복사가 아니고 그냥 같다고 봐도 된다. aa7과 bb7등 배열의 대표명은 배열의 시작번지이다. 
// 왜? 배열을 맞추니까 배열의 시작번지가 같아지게되는대 aa7과 bb7을 통해 알 수 있다. 또한 대체적으로 2차원 배열(평면)까지는 자주쓰인다.