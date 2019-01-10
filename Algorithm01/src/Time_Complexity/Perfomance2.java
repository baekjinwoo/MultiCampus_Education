package Time_Complexity;

public class Perfomance2 {
	public static void main(String[] args) {

		//덧셈 횟수 = 시간 측정
		System.out.println();
		int n=100, cnt=1;
		int result =n+n; //1번
		System.out.println(cnt); 
		
		for(int i=1;i<=n; i++){ //n만큼 연산횟수
			result=n+n;
			cnt++; //+1
		} //따라서 n+ 1
		System.out.println(cnt); 
		
		for(int i=1;i<=n;i++){ 
			for(int j=1;j<=n;j++){ //중첩반복문의 범위 n*n만큼
 				result=n+n;
				cnt++; //+n회 +1
			}
		}//따라서 n^2 +n +1 
		System.out.println(cnt); //따라서 최고차수를 따서 O(n^2) 연산횟수를 가진다.
		
		
		//또 다른 시간 측정
		System.out.println();
		int cnt2 = 0;
		n=100;
		for(int i=1; i<=n; i++){
			n=n/2; //n 줄어드는 연산
			cnt2++;
		}
		// O(1) < O(LogN) < O(N^2) < O(2^n)
		System.out.println(cnt2);
		// log 2 8 = 3 (2->4->8)
		//              1  2  3
	}
}
